package cn.sepiggy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AuthProxy implements MethodInterceptor {
    private String name;

    // 传入用户名称
    public AuthProxy(String name) {
        this.name = name;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 判断用户
        if (!"张三".equals(name)) {
            System.out.println("你没有权限！");
            return null;
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
