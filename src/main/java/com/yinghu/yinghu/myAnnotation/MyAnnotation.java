package com.yinghu.yinghu.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author
 * @describetion ${}
 * @date 2020-9-22
 */





@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

String message();


}
//异常，在规划的范围之外的情况，称之为异常
//ssl证书如何实现