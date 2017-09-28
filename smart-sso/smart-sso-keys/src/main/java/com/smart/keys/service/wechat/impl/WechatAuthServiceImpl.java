package com.smart.keys.service.wechat.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.smart.keys.common.utils.HttpRequestUtils;
import com.smart.keys.model.bo.wechat.WechatAppAssessTokenBo;
import com.smart.keys.model.bo.wechat.WechatAssessTokenBo;
import com.smart.keys.model.bo.wechat.WechatOAuth2MidBo;
import com.smart.keys.model.bo.wechat.WechatUserInfoBo;
import com.smart.keys.service.keys.IAccountUserService;
import com.smart.keys.service.wechat.IWechatAuthService;
import com.smart.mvc.cache.RedisCache;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.enums.ErrorType;
import com.smart.mvc.exception.BusinessException;

/**
 * 微信公众号访问权限相关服务
 * @author kangtiancheng
 * @date 2017年7月8日
 */
@Service("wechatAuthService")
public class WechatAuthServiceImpl implements IWechatAuthService {
	/**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(WechatAuthServiceImpl.class);
    
    public static final String WECHAT_ACCESS_TOKEN = "wechatAccessToken";
    
    public static final String WECHAT_APP_ACCESS_TOKEN = "wechatAppAccessToken";
    
    @Resource
	private RedisCache<String> redisCache;
    
    @Autowired
    IAccountUserService accountUserService;

	@Override
	public WechatAssessTokenBo getAssessToken() {
		LOG.info("请求公众号accessToken" );
		WechatAssessTokenBo wechatAssessTokenBo = null;
		if (StringUtils.isNotBlank(redisCache.get(WECHAT_ACCESS_TOKEN))) {
			wechatAssessTokenBo = new WechatAssessTokenBo();
			wechatAssessTokenBo.setWechatAccessToken(redisCache.get(WECHAT_ACCESS_TOKEN));
		} else {
			String wechatAppId = ConfigUtils.getProperty("wechat.app.id");
	        String wechatAppSecret = ConfigUtils.getProperty("wechat.app.secret");
	        String wechatUrlToken = ConfigUtils.getProperty("wechat.url.token");
	        wechatUrlToken = wechatUrlToken .replace("[_APPID_]", wechatAppId).replace("[_APPSECRET_]", wechatAppSecret);
	        String responseResult = HttpRequestUtils.sendGet(wechatUrlToken);
	        wechatAssessTokenBo = JSONObject.parseObject(responseResult, WechatAssessTokenBo.class, Feature.InitStringFieldAsEmpty);
	        redisCache.set(WECHAT_ACCESS_TOKEN, wechatAssessTokenBo.getWechatAccessToken(), 120);
		}
        return wechatAssessTokenBo;
	}

	@Override
	public WechatAppAssessTokenBo getAppAccessToken() {
		LOG.info("请求小程序accessToken" );
		WechatAppAssessTokenBo appAssessTokenBo = null;
		if (StringUtils.isNotBlank(redisCache.get(WECHAT_APP_ACCESS_TOKEN))) {
			appAssessTokenBo = new WechatAppAssessTokenBo();
			appAssessTokenBo.setWechatAccessToken(redisCache.get(WECHAT_APP_ACCESS_TOKEN));
		} else {
			String wechatAppId = ConfigUtils.getProperty("wxapp.app.id");
	        String wechatAppSecret = ConfigUtils.getProperty("wxapp.app.secret");
	        String wechatUrlToken = ConfigUtils.getProperty("wechat.url.token");
	        wechatUrlToken = wechatUrlToken .replace("[_APPID_]", wechatAppId).replace("[_APPSECRET_]", wechatAppSecret);
	        String responseResult = HttpRequestUtils.sendGet(wechatUrlToken);
	        appAssessTokenBo = JSONObject.parseObject(responseResult, WechatAppAssessTokenBo.class, Feature.InitStringFieldAsEmpty);
	        redisCache.set(WECHAT_APP_ACCESS_TOKEN, appAssessTokenBo.getWechatAccessToken(), 120);
		}
        return appAssessTokenBo;
	}

	@Override
	public String getAppWXacode() {
		LOG.info("获取小程序码" );
		String responseResult = null;
		String wxacodeUrlToken = ConfigUtils.getProperty("wxapp.url.wxacode");
		if (StringUtils.isNotBlank(redisCache.get(WECHAT_APP_ACCESS_TOKEN))) {
			wxacodeUrlToken = wxacodeUrlToken.replace("[_ACCESS_TOKEN_]", redisCache.get(WECHAT_APP_ACCESS_TOKEN));
			Map<String, String> paramMap = new HashMap<String, String>();
	        paramMap.put("path", "pages/business/recommend/recommend");
	        paramMap.put("width", "430");
//	        paramMap.put("auto_color", "true");
//	        paramMap.put("line_color", "{\"r\":\"0\",\"g\":\"0\",\"b\":\"0\"}");
	        responseResult = HttpRequestUtils.sendPost(wxacodeUrlToken, JSONUtils.toJSONString(paramMap));
	        System.out.println(responseResult);
		} else {
	        wxacodeUrlToken = wxacodeUrlToken.replace("[_ACCESS_TOKEN_]", getAppAccessToken().getWechatAccessToken());
	        Map<String, String> paramMap = new HashMap<String, String>();
	        paramMap.put("path", "pages/business/recommend/recommend");
	        paramMap.put("width", "430");
//	        paramMap.put("auto_color", "true");
//	        paramMap.put("line_color", "{\"r\":\"0\",\"g\":\"0\",\"b\":\"0\"}");
	        responseResult = HttpRequestUtils.sendPost(wxacodeUrlToken, JSONUtils.toJSONString(paramMap));
	        System.out.println(responseResult);
		}
		return responseResult;
		
	}

	@Override
	public WechatUserInfoBo getWxAppUserInfo(String code) throws BusinessException {
		//使用临时code换取accessToken信息
        WechatOAuth2MidBo wechatOAuth2MidBo = getOAuth2Info(code);
        //返回错误了，没有获取到值
        if(wechatOAuth2MidBo == null || StringUtils.isBlank(wechatOAuth2MidBo.getSession_key())){
        	throw new BusinessException(ErrorType.WX_APP_AUTH_REQUEST_FAIL);
        }
        //获取数据结果
//        WechatUserInfoBo userInfoBo = getWechatData(wechatOAuth2MidBo.getOpenid(), wechatOAuth2MidBo.getSession_key());
        WechatUserInfoBo userInfoBo = new WechatUserInfoBo(wechatOAuth2MidBo);
        //存储采集数据
        //目前是同步存储，以后要异步的话，参考文件：rjra-server-async-bean.xml
        accountUserService.saveOrUpdateWechatUserInfo(userInfoBo);
        return userInfoBo;
	}
	
//	private WechatUserInfoBo getWechatData(String wechatOpenId, String wechatAccessToken) {
//		String wechatUrlUserInfo = ConfigUtils.getProperty("wxapp.app.url.userinfo");
//        if(wechatUrlUserInfo == null || wechatOpenId == null || wechatAccessToken == null){
//            return null;
//        }
//        wechatUrlUserInfo = wechatUrlUserInfo.replace("[_ACCESS_TOKEN_]",wechatAccessToken).replace("[_OPEN_ID_]", wechatOpenId);
//        String responseResult = HttpRequestUtils.sendGet(wechatUrlUserInfo);
//        return JSONObject.parseObject(responseResult,WechatUserInfoBo.class, Feature.InitStringFieldAsEmpty);
//	}

	private WechatOAuth2MidBo getOAuth2Info(String code){
        String wechatAppId = ConfigUtils.getProperty("wxapp.app.id");
        String wechatAppSecret = ConfigUtils.getProperty("wxapp.app.secret");
        String wechatUrlOAuth2 = ConfigUtils.getProperty("wxapp.app.url.oauth");

        if(wechatAppId == null || wechatAppSecret == null || wechatUrlOAuth2 == null || code == null){
            return null;
        }
        wechatUrlOAuth2 = wechatUrlOAuth2.replace("[_APPID_]", wechatAppId).replace("[_APPSECRET_]", wechatAppSecret).replace("[_CODE_]", code);
        String responseResult = HttpRequestUtils.sendGet(wechatUrlOAuth2);

        return JSONObject.parseObject(responseResult,WechatOAuth2MidBo.class, Feature.InitStringFieldAsEmpty);
    }
}
