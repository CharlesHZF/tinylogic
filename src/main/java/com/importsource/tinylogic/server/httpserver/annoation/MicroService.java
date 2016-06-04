package com.importsource.tinylogic.server.httpserver.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 支持method方法。把这个声明到某个逻辑上便可以实现aop切面逻辑切入。
 * @author Hezf
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MicroService {
	String value() default "";
}
