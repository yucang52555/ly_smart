package org.smart.sso.poetry.service.wechat.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.sso.poetry.common.utils.httpClient.HttpRequestUtils;
import org.smart.sso.poetry.model.bo.wechat.WechatAppAssessTokenBo;
import org.smart.sso.poetry.model.bo.wechat.WechatAssessTokenBo;
import org.smart.sso.poetry.service.wechat.IWechatAuthService;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.smart.mvc.cache.RedisCache;
import com.smart.mvc.config.ConfigUtils;

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
}
