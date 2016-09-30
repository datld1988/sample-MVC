package com.vtc.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LoggingPointcut {

	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}
	
	@Pointcut("within(@org.springframework.stereotype.Service *)")
	public void service() {
	}
	
	@Pointcut("within(@org.springframework.stereotype.Component *)")
	public void component(){
		
	}
	
	@Pointcut("execution(* *.*(..))")
	public void allMethod() {
	}

	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}
	
	@Pointcut("execution(* com.vtc.business.impl.ServiceUtilsImpl.validateToken(..))")
	public void validateToken(){}
}
