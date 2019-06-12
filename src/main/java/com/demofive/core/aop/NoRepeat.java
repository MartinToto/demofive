package com.demofive.core.aop;


import java.lang.annotation.*;

/**
 *
 */
//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.METHOD})
//@Documented

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@Documented
public @interface NoRepeat {


}
