package org.horiga.study.spring.webapp;

import java.util.List;

import org.horiga.study.spring.webapp.interceptor.TestInterceptor;
import org.horiga.study.spring.webapp.resolver.RequestUserMethodArgumentResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
// @EnableCaching
@EnableAsync
@EnableScheduling
@EnableAutoConfiguration
@ImportResource("classpath:/applicationContext.xml")
public class Application extends WebMvcConfigurerAdapter implements
		CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	TestInterceptor testInterceptor;

	@Autowired
	RequestUserMethodArgumentResolver requestUserArgumentResolver;

	@Override
	public void run(String... args) throws Exception {
		int n = 0;
		for (String arg : args) {
			log.debug("args({})={}", n, arg);
			n++;
		}
	}

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(requestUserArgumentResolver);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor).addPathPatterns("/**/*");
	}
}
