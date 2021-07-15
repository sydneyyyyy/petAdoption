package com.revature.aspects;

import java.util.*;

import javax.servlet.http.HttpServletRequest;


import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggingAspect {
	
	// PUT LOGGING IN 
		Logger log = LoggerFactory.getLogger(this.getClass());
		// always better to start simple and get more complicated
		private int counter = 0;
		
		// Advice - method - this is what we want Java to do when our hook method is run
		@Before("logMethod()")
		public void logBefore(JoinPoint joinPoint, HttpServletRequest request) {
			
			System.out.println("The controller calls = " + ++counter); // in this scenario this code would be replaced with Logger.log.....
			log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
	        log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
	        log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
	        log.debug("Target class : " + joinPoint.getTarget().getClass().getName());
	        
	        log.info("Entering in Method :  " + joinPoint.getSignature().getName());
	        log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
	        log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
	        log.info("Target class : " + joinPoint.getTarget().getClass().getName());
	 
	        if (null != request) {
	            log.debug("Start Header Section of request ");
	            log.debug("Method Type : " + request.getMethod());
	            Enumeration headerNames = request.getHeaderNames();
	            while (headerNames.hasMoreElements()) {
	                String headerName = (String) headerNames.nextElement();
	                String headerValue = request.getHeader(headerName);
	                log.debug("Header Name: " + headerName + " Header Value : " + headerValue);
	                log.info("Header Name: " + headerName + " Header Value : " + headerValue);
	            }
	            log.debug("Request Path info :" + request.getServletPath());
	            log.debug("End Header Section of request ");
	            log.info("Request Path info :" + request.getServletPath());
	            log.info("End Header Section of request ");
	        }
		}
			
		@AfterReturning(value="logMethod()", argNames="joinPoint", returning = "result")
		public void logAfter(JoinPoint joinPoint, Object result) { // this needs to match argNames. This join point is representation the method that we are advising
			System.out.println(joinPoint.getSignature().getName() + " just finished executing.");
			String returnValue = this.getValue(result);
	        log.debug("Method Return value : " + returnValue);
	        log.info("Method Return value : " + returnValue);
	    }
	    //After -> Any method within resource annotated with @Controller annotation 
	    // throws an exception ...Log it
	    @AfterThrowing(pointcut="execution(* com.revature.controllers.*.*(..))", throwing = "exception")
	    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
	        log.error("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
	        log.error("Cause : " + exception.getCause());
		}
		
		// can we access objects in method? 
		
		@AfterThrowing(pointcut="execution(* com.revature.controllers.*.*(..))", throwing="error")
		public void logAfterFailure(JoinPoint jp, Throwable error) {
			log.error("An exception has been thrown in " + jp.getSignature().getName() + " ()");
	        log.error("Cause : " + error.getCause());
			System.out.println(jp.getSignature().getName() + " failed to execute.");
			System.out.println("Exception: " + error.getMessage());
		}
		
		
		@Pointcut("execution(* com.revature.controllers.*.*(..))")
		public void logMethod() {
			// This is a hook method. 
			// an empty method that serves as a target for our advice
			// This method will represent the method that would be called
		}
		private String getValue(Object result) {
	        String returnValue = null;
	        if (null != result) {
	            if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
	                returnValue = (String) result;
	            } else {
	                returnValue = result.toString();
	            }
	        }
	        return returnValue;
	    }

}
