package com.beiming.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *	读注解 
 */

@Target(ElementType.METHOD)                               //定义该注解的作用范围（类注解的作用是什么,如何使用）
@Retention(RetentionPolicy.RUNTIME)                     //定义该注解的作用时期,我们自定义的注解一般都是JVM运行时使用
@Documented                                                          //表示生成Doc文档,自定义注解不需要该注释
@Inherited                                                                //使用在类上时,表示子类也会使用拥有该注解,自定义注解不需要该注解
public @interface Read {
	
	String name() default "Read";
}
