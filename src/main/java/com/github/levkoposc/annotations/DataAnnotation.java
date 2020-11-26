package com.github.levkoposc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface DataAnnotation {
    Class<?>[] value();
}
