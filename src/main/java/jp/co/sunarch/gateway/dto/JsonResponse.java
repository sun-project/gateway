package jp.co.sunarch.gateway.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponse implements Serializable{

	@JsonProperty("user_info")
	private Map<String, Object> userInfo = new HashMap<String, Object>();

	public Map<String, Object> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
}
