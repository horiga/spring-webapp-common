package org.horiga.study.spring.webapp.persistence;

import org.horiga.study.spring.webapp.domain.Study;
import org.horiga.study.spring.webapp.support.mybatis.Mapper;

@Mapper
public interface StudyMapper {
	Study findById(String id);
	
	void insert(Study study);
}
