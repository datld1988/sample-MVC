package com.vtc.aspect;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtc.business.CommonUtils;
import com.vtc.dataconstant.DataConstants;
import com.vtc.response.ResponseModel;

@Aspect
@Component
public class LoggingAspect extends LoggingPointcut {
	private static Logger log;
	
	@Autowired
	private HttpServletRequest httpRequest;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Around("controller() && allMethod()")
	public Object controllerAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("\n====================================================================================================\n")
				.append("\n====================================================================================================\n"));
		
		log.info(new StringBuffer("[AOP-CONTROLLER START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));
		log.info(str.toString());
		
		if(httpRequest.getHeaderNames() != null){
			StringBuffer sb = new StringBuffer(" RequestHeader --> ");
			Map<String, String> map = new HashMap<String, String>();
			Enumeration<String> headerNames = httpRequest.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = httpRequest.getHeader(key);
				map.put(key, value);
				sb.append(" ,").append(key).append(":").append(value);
			}
			log.info(sb.toString());
			
			String clientId = map.get(DataConstants.RequestParams.ClientId);
			if(StringUtils.isEmpty(clientId)){
				log.error(new StringBuffer("[ERROR-HEADER REQUEST] ClientId=").append(clientId));
				return new ResponseModel(DataConstants.ResponseCode.MISSING_CLIENT_ID.getValue(), DataConstants.ResponseCode.MISSING_CLIENT_ID.getDisplay());
			}
		}
		
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (!method.getReturnType().equals(Void.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null && value instanceof ResponseModel) {
				ResponseModel response = (ResponseModel) value;
				sb.append(commonUtils.toJsonString(response));
			}
			log.info(sb.toString());
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-CONTROLLER END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));
		return value;
	}

	@Around("@annotation(com.vtc.aspect.Loggable)")
	public Object loggableAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("[AOP-LOGGABLE START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));

		log.info(str.toString());
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (!method.getReturnType().equals(Void.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null) {
				if(value instanceof ResponseModel){
					ResponseModel response = (ResponseModel) value;
					sb.append(commonUtils.toJsonString(response));
				}else{
					ObjectMapper objectMapper = new ObjectMapper();//.writer().withDefaultPrettyPrinter();
					try {
						sb.append(objectMapper.writeValueAsString(value));
					} catch (Exception e) {
						sb.append(value.toString());
					}
				}
			}
			
			log.info(sb.toString());
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-LOGGABLE END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));
		return value;
	}
	
	@Around("@annotation(com.vtc.aspect.LoggableServlet)")
	public Object loggableServletAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("[AOP-LOGGABLE-SERVLET START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));

		log.info(str.toString());
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (!method.getReturnType().equals(Void.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null) {
				if(value instanceof ResponseModel){
					ResponseModel response = (ResponseModel) value;
					sb.append(response.toString());
				}else{
					sb.append(value.toString());
				}
			}
			
			log.info(sb.toString());
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-LOGGABLE-SERVLET END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));
		return value;
	}
	
	@Around("@annotation(com.vtc.aspect.Loggable) && validateToken()")
	public Object loggableValidTokenAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("[AOP-LOGGABLE-VALIDTOKEN START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));

		log.info(str.toString());
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (method.getReturnType().equals(Boolean.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null) {
				sb.append(value.toString());
				log.info(sb.toString());
				Boolean returnValue = Boolean.valueOf(value.toString());
				if(!returnValue){
					log.error(new StringBuffer("----------------INVALID TOKEN access_token ----------").toString());
				}
			}
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-LOGGABLE-VALIDTOKEN END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));
		return value;
	}

	@Around("service() && allMethod() ")
	public Object serviceAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("[AOP-SERVICE START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));

		log.info(str.toString());
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (!method.getReturnType().equals(Void.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null) {
				sb.append(commonUtils.toJsonString(value));
			}
			log.info(sb.toString());
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-SERVICE END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));

		return value;
	}

	@Around("component() && allMethod() ")
	public Object aroundAllComponent(ProceedingJoinPoint joinPoint) throws Throwable {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringType());
		MethodSignature method = (MethodSignature) joinPoint.getStaticPart().getSignature();
		List<String> params = Arrays.asList(method.getParameterNames());
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		log.info(new StringBuffer("[AOP-COMPONENT START] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()));
		StringBuffer str = new StringBuffer(" Parameters -->  ");
		Iterator<Object> i1 = args.iterator();
		params.stream().forEach(param -> str.append(", ").append(param).append(" = ").append(i1.next()));

		log.info(str.toString());
		long t1 = System.currentTimeMillis();
		Object value = null;
		value = joinPoint.proceed();

		if (!method.getReturnType().equals(Void.TYPE)) {
			StringBuffer sb = new StringBuffer(" Return<").append(method.getReturnType().getName()).append("> value: ");
			if (value != null) {
				sb.append(value.toString());
			}
			log.info(sb.toString());
		}

		long t2 = System.currentTimeMillis();
		log.info(new StringBuffer("[AOP-COMPONENT END] ").append(joinPoint.getSignature().getDeclaringTypeName())
				.append(".").append(joinPoint.getSignature().getName()).append(" TOTAL TIME: ")
				.append(String.valueOf(t2 - t1)));
		return value;
	}

	// @Before("service()")
	// public void allServiceMethodsAdvice(){
	// System.out.println("Before executing service method");
	// }

	// @Pointcut("within(com.vtc.business.impl.ModelUtilsImpl)")
	// public void allMethodsPointcut(){
	// }

	@AfterThrowing(pointcut = "@annotation(com.vtc.aspect.Loggable) "
			+ "|| (service() && allMethod())"
			+ "|| (component() && allMethod())", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		log = Logger.getLogger(joinPoint.getClass());
		
		log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
		log.error("Cause : " + exception.getCause());
		log.error("Detail: " + exception.getMessage());
	}

	// @AfterThrowing(pointcut="@annotation(com.vtc.aspect.Loggable) ||
	// (controller() && allMethod())", throwing="ex")
	// public void aroundThrowing(IOException ex){
	// if(log == null){
	// log = Logger.getLogger(LoggingAspect.class);
	// }
	//
	// log.error("[ASPECT ]ERROR", ex);
	// }

	// @Around("execution(* save(..)) && target(trackingRepository)")
	// public Object pointCut(ProceedingJoinPoint thisJoinPoint,
	// TrackingRepository trackingRepository)
	// throws Throwable
	// {
	// System.out.println(thisJoinPoint);
	// return thisJoinPoint.proceed();
	// }

	// @Around("execution(* com.vtc.mongorepository.TrackingRepository.*(..))"
	// + " || execution(*
	// org.springframework.data.mongodb.repository.MongoRepository.*(..))")
	//// + " || execution(*
	// org.springframework.data.mongodb.repository..*.*(..))"
	//// + " || within(com.vtc.mongorepository..*(..))")
	// public Object pointCut1(ProceedingJoinPoint thisJoinPoint)
	// throws Throwable
	// {
	// System.out.println(thisJoinPoint);
	// return thisJoinPoint.proceed();
	// }

	// @Around("repository() && allMethod()")
	// public Object pointCut2(ProceedingJoinPoint joinPoint) throws Throwable{
	// System.out.println(joinPoint);
	// return joinPoint.proceed();
	// }

	// @Around("execution(public * com.vtc.mongorepository.*+.*(..))")
	// public Object pointCut3(ProceedingJoinPoint joinPoint) throws Throwable{
	// System.out.println(joinPoint);
	// return joinPoint.proceed();
	// }

	// @Pointcut("within(@org.springframework.stereotype.Repository *)")
	// public void repository() {
	// }

	// @Pointcut("within(@org.springframework.stereotype.Controller *)")
	// public void controller() {
	// }

	// @Pointcut("within(@org.springframework.stereotype.Service *)")
	// public void service() {
	// }

	// @Pointcut("execution(* *.*(..))")
	// protected void allMethod() {
	// }
	//
	// @Pointcut("execution(public * *(..))")
	// protected void loggingPublicOperation() {
	// }

	// @Pointcut("execution(* *.*(..))")
	// protected void loggingAllOperation() {
	// }

	// @Pointcut("within(org.learn.log..*)")
	// private void logAnyFunctionWithinResource() {
	// }

	// @Pointcut("within(com.vtc.mongorepository.TrackingRepository+) &&
	// execution(* save(..))")
	// public void pointcutRepo(){
	// }

	// before -> Any resource annotated with @Controller annotation
	// and all method and function taking HttpServletRequest as first parameter
	// @Before("controller() && allMethod() && args(..,request)")
	// public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {
	// if(log == null){
	// log = Logger.getLogger(LoggingAspect.class);
	// }
	// log.debug("Entering in Method : " + joinPoint.getSignature().getName());
	// log.debug("Class Name : " +
	// joinPoint.getSignature().getDeclaringTypeName());
	// log.debug("Arguments : " + Arrays.toString(joinPoint.getArgs()));
	// log.debug("Target class : " +
	// joinPoint.getTarget().getClass().getName());
	//
	// if (null != request) {
	// log.debug("Start Header Section of request ");
	// log.debug("Method Type : " + request.getMethod());
	// Enumeration<String> headerNames = request.getHeaderNames();
	// while (headerNames.hasMoreElements()) {
	// String headerName = headerNames.nextElement();
	// String headerValue = request.getHeader(headerName);
	// log.debug("Header Name: " + headerName + " Header Value : " +
	// headerValue);
	// }
	// log.debug("Request Path info :" + request.getServletPath());
	// log.debug("End Header Section of request ");
	// }
	// }

	// @Around("controller() && allMethod()")
	// public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	// if(log == null){
	// log = Logger.getLogger(LoggingAspect.class);
	// }
	// long start = System.currentTimeMillis();
	// try {
	// String className = joinPoint.getSignature().getDeclaringTypeName();
	// String methodName = joinPoint.getSignature().getName();
	// Object result = joinPoint.proceed();
	// long elapsedTime = System.currentTimeMillis() - start;
	// log.debug("Method " + className + "." + methodName + " ()" + " execution
	// time : "
	// + elapsedTime + " ms");
	//
	// return result;
	// } catch (IllegalArgumentException e) {
	// log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + "
	// in "
	// + joinPoint.getSignature().getName() + "()");
	// throw e;
	// }
	// }
}
