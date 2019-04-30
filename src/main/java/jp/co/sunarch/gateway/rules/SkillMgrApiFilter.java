package jp.co.sunarch.gateway.rules;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.server.ServerWebExchange;

@Configuration
public class SkillMgrApiFilter {

	private Log logger = LogFactory.getLog(SkillMgrApiFilter.class);

	private static final String AUTH_HEADER_NAME = "X_GATEWAY_USER_ID";
	private static final String DATE_HEADER_NAME = "X_STT_PROCTIME";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	@Bean
	@Order(10000)
	public GlobalFilter apply() {
		return (exchange, chain) -> exchange.getPrincipal()
				.filter(principal -> principal instanceof JwtAuthenticationToken)
				.cast(JwtAuthenticationToken.class)
				.map(authentication -> writeAuthHeader(exchange, authentication))
				.defaultIfEmpty(exchange)
				.flatMap(chain::filter);
	}

	private ServerWebExchange writeAuthHeader(ServerWebExchange exchange, JwtAuthenticationToken oauth2Authentication) {
		logger.debug("★★★★★");
		logger.debug(oauth2Authentication.getTokenAttributes());
		logger.debug("preferred_username:" + oauth2Authentication.getTokenAttributes().get("preferred_username"));
		logger.debug("★★★★★");
		return exchange.mutate()
				.request(req -> req.header(AUTH_HEADER_NAME, oauth2Authentication.getTokenAttributes().get("preferred_username").toString()))
				.request(req -> req.header(DATE_HEADER_NAME, DATE_FORMAT.format(new Date())))
				.build();
	}
}
