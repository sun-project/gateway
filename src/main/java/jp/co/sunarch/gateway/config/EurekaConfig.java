package jp.co.sunarch.gateway.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "eureka")
public class EurekaConfig {

	public static final String prefix = "eureka";

	private Map<String, String> client = null;

	public Map<String, String> getClient() {
		return client;
	}

	public void setClient(Map<String, String> client) {
		this.client = client;
	}
}
