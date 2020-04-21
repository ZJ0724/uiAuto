package com.zj0724.StepWebDriver.annotation;

import com.zj0724.StepWebDriver.exception.CheckException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

    class Method {
        // 检查注解
        public static void check(java.lang.reflect.Method method, Object[] params) {
            if (method.isAnnotationPresent(NotNull.class)) {
                for (Object param : params) {
                    if (param == null) {
                        throw CheckException.parameterNotNull();
                    }
                }
            }
        }
    }

}
