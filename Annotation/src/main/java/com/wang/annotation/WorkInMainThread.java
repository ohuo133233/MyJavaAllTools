package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
// 只能在方法上使用
@Target(ElementType.METHOD)
public @interface WorkInMainThread {
}
