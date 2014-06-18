package org.horiga.study.spring.webapp.resolver;

import javax.servlet.http.HttpServletRequest;

import org.horiga.study.spring.webapp.model.RequestUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class RequestUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	private static Logger log = LoggerFactory
			.getLogger(RequestUserMethodArgumentResolver.class);
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		log.debug("(argumentResolver#supportsParameter)");
		return parameter.getParameterType().isAssignableFrom(RequestUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		log.debug("(argumentResolver#resolveArgument)");
		RequestUser obj = new RequestUser();
		HttpServletRequest servletRequest = (HttpServletRequest)webRequest.getNativeRequest();
		obj.setRemoteAddr(servletRequest.getRemoteAddr());
		obj.setUserAgent(webRequest.getHeader("User-Agent"));
		return obj;
	}

}
