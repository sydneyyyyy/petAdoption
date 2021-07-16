package com.revature.aspects;


import org.apache.logging.log4j.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggingAspect {
	
	// PUT LOGGING IN 
		Logger log = LogManager.getLogger(this.getClass());
		
		// always better to start simple and get more complicated
		private int counter = 0;
		
		// Advice - method - this is what we want Java to do when our hook method is run
		@Before("logMethod()")
		public void logBefore(JoinPoint jp) {
			
			System.out.println("The controller calls = " + ++counter); // in this scenario this code would be replaced with Logger.log.....
			log.info("The controller called: " + jp.getSignature());
		}
			
		@After(value="logMethod()", argNames="joinPoint")
		public void logAfter(JoinPoint joinPoint) { // this needs to match argNames. This join point is representation the method that we are advising
			System.out.println(joinPoint.getSignature().getName() + " just finished executing.");
			log.info(joinPoint.getSignature().getName() + " just finished executing.");
		}
		
		// can we access objects in method? 
		
		@AfterThrowing(pointcut="execution(* com.revature.controllers.*.*(..))", throwing="error")
		public void logAfterError(JoinPoint jp, Throwable error) {
			System.out.println(jp.getSignature().getName() + " failed to execute.");
			System.out.println("Exception: " + error.getMessage());
			log.error(jp.getSignature().getName() + " failed to execute.");
			log.error("Exception: " + error.getMessage());
		}
		
//		@AfterThrowing(pointcut="execution(* com.revature.controllers.*.*(..))", throwing="exception")
//		public void logAfterException(JoinPoint jp, Throwable error) {
//			System.out.println(jp.getSignature().getName() + " failed to execute.");
//			System.out.println("Exception: " + error.getMessage());
//		}
		
		
		@Pointcut("execution(* com.revature.controllers.*.*(..))")
		public void logMethod() {
			// This is a hook method. 
			// an empty method that serves as a target for our advice
			// This method will represent the method that would be called
		}
		  

}
