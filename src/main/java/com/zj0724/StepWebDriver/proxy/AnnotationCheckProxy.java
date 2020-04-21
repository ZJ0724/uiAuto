package com.zj0724.StepWebDriver.proxy;

import com.zj0724.StepWebDriver.annotation.NotNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnnotationCheckProxy implements InvocationHandler {

    private Object object;

    public AnnotationCheckProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 校验注解
        // 方法传参不能为空
        NotNull.Method.check(method, args);

        return method.invoke(object, args);
    }

    /**
     * 获取代理对象
     * */
    public static Object getProxyObject(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new AnnotationCheckProxy(object));
    }

}
