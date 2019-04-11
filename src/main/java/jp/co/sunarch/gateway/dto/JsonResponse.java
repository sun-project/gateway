package jp.co.sunarch.gateway.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonResponse implements Serializable{

	private JsonResponseRequest request = new JsonResponseRequest();

	private Map<String, Object> result = new HashMap<String, Object>();

	private Map<String, Object> response = new HashMap<String, Object>();

	public JsonResponseRequest getRequest() {
		return request;
	}

	public void setRequest(JsonResponseRequest request) {
		this.request = request;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

}
