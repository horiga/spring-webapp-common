package org.horiga.study.spring.webapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Study extends BaseObject {
	private String id;
	private String name;
	private Date regdt;
	private Date modidt;
}
