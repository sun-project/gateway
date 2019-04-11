package jp.co.sunarch.gateway.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponseRequest implements Serializable{

	private String id = null;

	@JsonProperty("process_start_time")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+9:00")
	private Date processStartTime = null;

	@JsonProperty("process_end_time")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+9:00")
	private Date processEndTime = null;

	@JsonProperty("controller_name")
	private String controllerName = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getProcessStartTime() {
		return processStartTime;
	}

	public void setProcessStartTime(Date processStartTime) {
		this.processStartTime = processStartTime;
	}

	public Date getProcessEndTime() {
		return processEndTime;
	}

	public void setProcessEndTime(Date processEndTime) {
		this.processEndTime = processEndTime;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
}
