package jp.co.sunarch.gateway;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.sunarch.gateway.config.EurekaConfig;
import jp.co.sunarch.gateway.config.GatewayConfig;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	Log logger = LogFactory.getLog(GatewayApplication.class);

	@Autowired
	private EurekaConfig eurekaConfig;
	@Autowired
	private GatewayConfig gatewayConfig;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GatewayApplication.class, args);
		GatewayApplication app = ctx.getBean(GatewayApplication.class);
        app.showConfig(args);
	}

	public void showConfig(String... args) {
		logger.debug("★★★★★★★★★★★★★★★★★★★★★");
		if(eurekaConfig.getClient() != null) {
			Map<String, String> client = eurekaConfig.getClient();
			for(String key : client.keySet()) {
				logger.debug(EurekaConfig.prefix + ".client." + key + ":" + client.get(key));
			}
		}
		if(gatewayConfig.getDiscovery() != null) {
			Map<String, String> discovery = gatewayConfig.getDiscovery();
			for(String key : discovery.keySet()) {
				logger.debug(GatewayConfig.prefix + ".discovery." + key + ":" + discovery.get(key));
			}
		}
		if(gatewayConfig.getRoutes() != null) {
			Map<String, String> routes = gatewayConfig.getRoutes();
			for(String key : routes.keySet()) {
				logger.debug(GatewayConfig.prefix + ".routes." + key + ":" + routes.get(key));
			}
		}
		logger.debug("★★★★★★★★★★★★★★★★★★★★★");
	}


}
