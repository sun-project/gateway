package jp.co.sunarch.gateway.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sunarch.gateway.dto.JsonResponse;

@Controller
@ResponseBody
public class GatewayController {

	@RequestMapping(value = "user_info", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> sample(JwtAuthenticationToken auth) {
		JsonResponse res = new JsonResponse();

		//さすがに手を抜きすぎな気がする
		res.getUserInfo().putAll(auth.getTokenAttributes());

		return ResponseEntity.ok(res);
	}

}
