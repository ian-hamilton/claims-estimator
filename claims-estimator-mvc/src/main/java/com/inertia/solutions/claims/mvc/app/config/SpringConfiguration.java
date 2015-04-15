package com.inertia.solutions.claims.mvc.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * This class is a basic Spring IOC Container config
 * which does a @Component @Services scan on the base package name,
 * and also allows the AspectJ Style proxy generation.
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.inertia.solutions.claims.mvc.domain"})
public class SpringConfiguration  {

	
}
