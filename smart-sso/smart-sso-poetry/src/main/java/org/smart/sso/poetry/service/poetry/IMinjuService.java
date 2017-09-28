package org.smart.sso.poetry.service.poetry;

import java.util.List;

import org.smart.sso.poetry.model.bo.poetry.MinjuRecommendBo;
import org.smart.sso.poetry.model.po.poetry.Minju;

/**
 * 古诗文标签服务
 * @author kangtiancheng
 * @date 2017年6月20日
 */
public interface IMinjuService {
	
	/**
	 * 保存作者信息
	 * @param GSWAuthor
	 * @return
	 */
	public void saveMinjus(List<Minju> GSWMinjus);

	/**
	 * 查询每日推荐名句
	 * @return
	 */
	public MinjuRecommendBo findMinjuByRecommend();

	/**
	 * 获取下一个推荐
	 * @param minjuId
	 * @return
	 */
	public MinjuRecommendBo findMinjuByRecommendNext(Integer minjuId);
	
}
