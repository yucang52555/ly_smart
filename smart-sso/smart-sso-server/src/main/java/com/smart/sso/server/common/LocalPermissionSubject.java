package com.smart.sso.server.common;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 单实例权限主题
 * 
 * @author Joe
 */
public class LocalPermissionSubject extends PermissionSubject {

	/**
	 * 保存所有注册到smart-sso-server的应用编码,支持并发读写
	 */
	protected Set<String> appCodeSets = new CopyOnWriteArraySet<String>();

	public void attach(String appCode) {
		appCodeSets.add(appCode);
	}

	@Override
	protected Set<String> getAppCodesets() {
		return appCodeSets;
	}

}
