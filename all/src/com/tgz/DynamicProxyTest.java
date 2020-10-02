package com.tgz;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        ITeacherDao target=new TeacherDao();
        ITeacherDao proxyTeacher=(ITeacherDao)new ProxyFactory(new TeacherDao()).GetProxyInstance();
        proxyTeacher.teach();
    }
}

interface ITeacherDao{
    void teach();
}

class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("正在授课");
    }
}

class ProxyFactory{
    private  Object target=new Object();

    public ProxyFactory(Object object){
        this.target=object;
    }

    public Object GetProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理开始！");
               Object returnobj=method.invoke(target,args);
               return returnobj;
            }
        });
    }
}