package org.horiga.study.spring.webapp.controller;

import java.util.Map;

import org.horiga.study.spring.webapp.domain.Study;
import org.horiga.study.spring.webapp.model.RequestUser;
import org.horiga.study.spring.webapp.service.StudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	private static Logger log = LoggerFactory.getLogger(StudyController.class);
	
	private static Map<String, String> success = Maps.newHashMap();
	
	@Autowired StudyService studyService;
	
	@RequestMapping("/{id}")
	@ResponseBody Study findById(@PathVariable("id") String id,
			RequestUser user) {
		
		log.debug(">>> {} : {}", user.getRemoteAddr(), user.getUserAgent());
		
		return studyService.findById(id);
	}
	
	
	
	@RequestMapping(value="", method={RequestMethod.POST})
	@ResponseBody Map<String, String> add(
			@RequestBody String json
			) {
		studyService.add(json);
		return success;
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody Map<String, String> update(
			@RequestBody String json
			) {
		studyService.add(json);
		return success;
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.DELETE})
	@ResponseBody Map<String, String> remove(@PathVariable("id") String id) {
		studyService.remove(id);
		return success;
	}
}
