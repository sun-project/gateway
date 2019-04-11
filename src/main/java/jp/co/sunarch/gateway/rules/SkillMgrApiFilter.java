package jp.co.sunarch.gateway.rules;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.server.ServerWebExchange;

@Configuration
public class SkillMgrApiFilter {

	private Log logger = LogFactory.getLog(SkillMgrApiFilter.class);

	private static final String HEADER_NAME = "X_GATEWAY_USER_ID";

	@Bean
	@Order(100000000)
	public GlobalFilter apply() {
		return (exchange, chain) -> exchange.getPrincipal()
				.filter(principal -> principal instanceof OAuth2AuthenticationToken)
				.cast(OAuth2AuthenticationToken.class)
				.map(authentication -> writeAuthHeader(exchange, authentication))
				.defaultIfEmpty(exchange)
				.flatMap(chain::filter);
	}

	private ServerWebExchange writeAuthHeader(ServerWebExchange exchange, OAuth2AuthenticationToken oauth2Authentication) {
		//preferred_username
		logger.debug("★★★★★");
		logger.debug(oauth2Authentication);
		logger.debug("★★★★★");
		return exchange.mutate()
				.request(req -> req.header(HEADER_NAME, oauth2Authentication.getPrincipal().getAttributes().get("preferred_username").toString()))
				.build();
	}
}
