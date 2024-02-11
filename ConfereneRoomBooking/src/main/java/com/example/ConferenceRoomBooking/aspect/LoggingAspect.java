package com.example.ConferenceRoomBooking.aspect;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.ConferenceRoomBooking.exceptions.NotFoundException;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
	
	//AOP expression for which methods shall be intercepted
		@Around("execution(* com.example.ConferenceRoomBooking.services..*(..)))")
		public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
		{
			MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

			//Get intercepted method details
			String className = methodSignature.getDeclaringType().getSimpleName();
			String methodName = methodSignature.getName();

			final StopWatch stopWatch = new StopWatch();

			//Measure method execution time
			stopWatch.start();
			Object result = proceedingJoinPoint.proceed();
			stopWatch.stop();

			//Log method execution time
			LOGGER.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + " ms");

			return result;
		}
		/**
		 * handle the logging level(config in application.properties) use diff types of logging eg debug log..*/
	    @AfterThrowing(pointcut ="execution(* com.example.ConferenceRoomBooking.services..*(..)))",throwing="e")
	    public ResponseEntity<Object> handleException(NotFoundException e){
	    	Map<String, Object> body = new HashMap<>();
			 //log.error("Resource not found", ex);
		        body.put("message", e.getLocalizedMessage());
	    	return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

}
