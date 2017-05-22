package com.zejian.annotationdemo;

import java.lang.annotation.*;

/**
 * Created by wuzejian on 2017/5/19.
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Document_A {
}
