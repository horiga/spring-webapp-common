package org.horiga.study.spring.webapp.model;

import lombok.Data;

@Data
public class RequestUser {
	String userAgent;
	String remoteAddr;
}
