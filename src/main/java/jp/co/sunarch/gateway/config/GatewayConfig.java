package jp.co.sunarch.gateway.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class GatewayConfig {

	public static final String prefix = "spring.cloud.gateway";

	private Map<String, String> discovery = null;

	private Map<String, String> routes = null;

	public Map<String, String> getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Map<String, String> discovery) {
		this.discovery = discovery;
	}

	public Map<String, String> getRoutes() {
		return routes;
	}

	public void setRoutes(Map<String, String> routes) {
		this.routes = routes;
	}
}
