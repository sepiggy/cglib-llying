package cn.sepiggy;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class AuthProxyFilter implements CallbackFilter {
    public int accept(Method method) {
        if (!"query".equalsIgnoreCase(method.getName())) {
            return 0;
        }
        return 1;
    }
}
