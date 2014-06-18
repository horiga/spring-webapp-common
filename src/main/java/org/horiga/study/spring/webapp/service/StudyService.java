package org.horiga.study.spring.webapp.service;

import java.util.UUID;

import org.horiga.study.spring.webapp.domain.Study;
import org.horiga.study.spring.webapp.persistence.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudyService {
	
	@Autowired
	StudyMapper studyMapper;
	
	public Study findById(String id) {
		return studyMapper.findById(id);
	}
	
	@Transactional
	public void add(String name) {
		Study study = new Study();
		study.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		study.setName(name);
		studyMapper.insert(study);
	}
	
	@Transactional
	public void update(final String id, final String name) {
		
	}
	
	@Transactional
	public void remove( final String id) {
	}
}
