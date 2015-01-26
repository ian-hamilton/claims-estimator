package com.inertia.solutions.claims.mvc.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 
 * This class is a basic Spring IOC Container config
 * which does a @Component @Services scan on the base package name,
 * and also allows the AspectJ Style proxy generation.
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.inertia.solutions.claims.mvc.app"}, 
	excludeFilters = { @Filter( type=FilterType.ANNOTATION, value=Configuration.class ) })
public class SpringConfiguration {

}
