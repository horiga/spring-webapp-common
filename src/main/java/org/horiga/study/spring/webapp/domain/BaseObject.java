package org.horiga.study.spring.webapp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseObject {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String toString() {
		try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
}
