package org.smart.sso.poetry.common.enums;

/**
 * 微信公众号消息推送类型
 * @author kangtiancheng
 * @date 2017年7月10日
 */
public enum MessageType {
	TEXT("text", 1, "文本消息"),
	IMAGE("img", 2, "图文消息"),
	VOICE("voice", 3, "语音消息"),
	POSITION("position", 4, "位置消息"),
	LINK("link", 5, "链接消息"),
	MEDIA("media", 6, "视频消息");
	
	private MessageType(String name, Integer code,String desc) {
		this.name = name;
		this.code = code;
		this.desc= desc;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	private Integer code;
	private String desc;
}
