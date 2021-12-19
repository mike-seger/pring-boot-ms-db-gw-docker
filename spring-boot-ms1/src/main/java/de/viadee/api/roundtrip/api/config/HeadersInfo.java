package de.viadee.api.roundtrip.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class HeadersInfo implements InfoContributor {
	@Autowired
	private HttpServletRequest request;

	@Override
	public void contribute(Info.Builder builder) {
		var headers = new TreeMap<>(Collections.list(request.getHeaderNames())
			.stream().sorted()
			.collect(Collectors.toMap(
				Function.identity(),
				name -> Collections.list(request.getHeaders(name))))
		);
		builder.withDetail("headers", headers);
	}
}
