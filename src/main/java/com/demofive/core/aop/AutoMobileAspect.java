package com.demofive.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//import org.aspectj.lang.annotation.Aspect;


/**
 * aop
 * 
 */
@Aspect
@Component
public class AutoMobileAspect {
	Logger logger = LoggerFactory.getLogger(AutoMobileAspect.class);

	public AutoMobileAspect() {
	}

//	@Pointcut(value = "@annotation(com.demosix.demosix.aop.NoRepeat)")
	@Pointcut("execution(public * ((@NoRepeat *)+).*(..)) && within(@NoRepeat *)")
	public void autoMobileAnnotation() {
		System.out.println("----11111----------");
	}
	/*
	 * 通过连接点切入
	 */
	@Before("autoMobileAnnotation()")
	public void twi(){
		for (int i = 0; i <6 ; i++) {
			System.err.println ("before=============twi=====================" );
		}
	}

//	@Pointcut("execution()")
//	public void pointCut(){}
//
//	@Before(value = "pointCut()")
//	public void before(){
//        for (int i = 0; i <6 ; i++) {
//            System.err.println ("before=============twi=====================" );
//        }
//	}

//	@Before(value = "pointCut()")
//	public void before(){
//        for (int i = 0; i <6 ; i++) {
//            System.err.println ("before=============twi=====================" );
//        }
//	}
//
//D:\product\vanmilk_search\demosix\src\main\java\com\demosix\demosix\service\IndexService.java
	@Pointcut("execution(* com.demosix.demosix.service..*(..))")
	public void pointCut1(){}

	@Before(value = "pointCut1()")
	public void before1(){
		System.out.println("===============111111111============================>before");
	}


}
