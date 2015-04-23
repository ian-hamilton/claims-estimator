package com.inertia.solutions.claims.mvc.aspect.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.inertia.solutions.claims.mvc.aspect.LoggingAspect;
import com.inertia.solutions.claims.mvc.rest.controller.ClaimItemsRestController;


/**
 * Using JRE 1.7.0_75
 * 
 * The Class LoggingAspectImpl is the implementation provided 
 * for the logging interface, which is really on three joinpoints...
 * 1. Before/After function execution
 * 2. After exception is thrown (for obvious reasons)
 * 3. After any execution marked with the logging annotation.
 *
 * @author Ian Hamilton
 * @version 1.0
 * @since 1.0
 * 
 */
@Aspect
@Component
public class LoggingAspectImpl implements LoggingAspect {
	private static final Logger log = LoggerFactory.getLogger(ClaimItemsRestController.class);

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.aspect.LoggingAspect#logBefore(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@Before("execution(* com.inertia.solutions.claims.mvc..*(..))")
	@Order(0)
	public void logBefore(JoinPoint joinPoint) {
		if(log.isDebugEnabled())
			log.debug("The method " + joinPoint.getSignature().getName()
					+ "() begins with " + Arrays.toString(joinPoint.getArgs()));		
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.aspect.LoggingAspect#logAfter(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@After("execution(* com.inertia.solutions.claims.mvc..*(..))") 
	public void logAfter(JoinPoint joinPoint) {
		if(log.isDebugEnabled())
			log.debug("The method " + joinPoint.getSignature().getName() + "() ends");		
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.aspect.LoggingAspect#logAfterThrowing(org.aspectj.lang.JoinPoint, java.lang.Throwable)
	 */
	@Override
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error(String.format("Error thrown during application execution -> %s()", joinPoint.getSignature().getName()), e);		
	}

	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.aspect.LoggingAspect#logBeforeAnnotation(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@Before("@annotation(com.inertia.solutions.claims.mvc.aspect.impl.FineGrainLogging)")
	@Order(1)
	public void logBeforeAnnotation(JoinPoint joinPoint, FineGrainLogging annotation) {
		log.info("The annotated method " + joinPoint.getSignature().getName()
				+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
			
	}
	
	/* (non-Javadoc)
	 * @see com.inertia.solutions.claims.mvc.aspect.LoggingAspect#logBeforeAnnotation(org.aspectj.lang.JoinPoint)
	 */
	@Override
	@After("@annotation(com.inertia.solutions.claims.mvc.aspect.impl.FineGrainLogging)")
	@Order(1)
	public void logAfterAnnotation(JoinPoint joinPoint, FineGrainLogging annotation) {
		log.info("The annotated method " + joinPoint.getSignature().getName()
				+ "() ends with " + Arrays.toString(joinPoint.getArgs()));
		
	}

}
