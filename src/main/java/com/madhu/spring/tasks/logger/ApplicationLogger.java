/**
 * 
 */
package com.madhu.spring.tasks.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author RamachandranM1
 *
 */
@Configuration
@Aspect
@Slf4j
public class ApplicationLogger {
	
	@Pointcut(value="execution (* com.madhu.spring.tasks.controller.*.*(..))")
	public void controllerPointcut() {
		
	}
	
	@Pointcut(value="execution (* com.madhu.spring.tasks.service.*.*(..))")
	public void servicePointcut() {
		
	}
	
	@Around(value = "controllerPointcut() || servicePointcut() ")
	public Object appLogger(ProceedingJoinPoint pjp) throws Throwable{
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		log.info(String.format("Method Entered: %s.%s", className, methodName));
		Object obj = pjp.proceed();
		log.info(String.format("Method Exited: %s.%s", className, methodName));
		return obj;
	}
}
