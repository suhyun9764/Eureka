package com.springbackground.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CheckNotNullInvocationHandler implements InvocationHandler {

    private Object target;

    public CheckNotNullInvocationHandler(Object target) {
        this.target = target;
    }

    // proxy를 통해 myIf에 있는 메서드를 호출할 때 마다, invoke()가 대신 호출 된다.
    // args[] : proxy를 통해서 호출되는 메서드의 파라미터 값을 의미
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy가 할일이 있으면 하고나서 필요에 따라 실제 메서드를 호출하고
        // 특별히 할일이 없으면 bypass
        Method targetMethod = target.getClass().getMethod(method.getName(),method.getParameterTypes());

        // 할 일 : @CheckNotNull 관련 처리
        if(targetMethod.isAnnotationPresent(CheckNotNull.class)){
            System.out.println("checkNotNull method call!! ");
            return handleCheckNotNull(targetMethod, args);
        }

        return method.invoke(targetMethod, args);
    }

    private Object handleCheckNotNull(Method method, Object[] args ) throws Throwable{

        CheckNotNull annotation = method.getAnnotation(CheckNotNull.class);
        String[] parameterNames = annotation.parameterName();

        for (int i = 0; i < args.length; i++) {
            if( args[i] == null ) {
                throw new IllegalArgumentException("Parameter " + parameterNames[i] + " is null (should be notnull)");
            }
        }

        return method.invoke(target, args);
    }
}
