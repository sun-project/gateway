package jp.co.sunarch.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.sunarch.gateway.config.EurekaConfig;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	Log logger = LogFactory.getLog(GatewayApplication.class);

	@Autowired
	private EurekaConfig config;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GatewayApplication.class, args);
		GatewayApplication app = ctx.getBean(GatewayApplication.class);
        app.showConfig(args);
	}

	public void showConfig(String... args) {
		logger.debug("★★★★★★★★★★★★★★★★★★★★★");
		logger.debug(config.getClient());
		logger.debug("★★★★★★★★★★★★★★★★★★★★★");
	}
}
