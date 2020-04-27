package Reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy implements ItestProxy, InvocationHandler {
    /*
    需求:
    在执行cest1和cest2方法时需要加入一些东西
    在执行方法前打印teat1或test2开始执行
    在执行方法后打印test1或test2执行完毕
    打印的方法名要和当时调用方法保存一致
     */
    /*注意:
    一个对象如果想通过Proxy.newProxyinstance方法被代理,
    这个对象一定要有相应的接口  InvocationHandler.

     */
    //被代理对象
    Object object;
    public TestProxy(){}
    public TestProxy(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        //多态的体现
       ItestProxy ip=new TestProxy();
       ip.test1();
       System.out.println("-------------");
       ip.test2();
       //代理对象
        InvocationHandler ich=new TestProxy(ip);
        /*此方法
        参数1是代理对象的类加载器  ich.getClass().getClassLoader()
        参数2是代理的对象的接口    ip.getClass().getInterfaces()
        参数3是代理对象          ich
        返回的值就是成功代理后的值
         */
        ItestProxy ipy= (ItestProxy) Proxy.newProxyInstance(ich.getClass().getClassLoader(),
                ip.getClass().getInterfaces(),ich);
        ipy.test1();
        ipy.test2();
    }
    //动态代理接口的方法
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(method.getName()+"方法开始执行");
        //执行的是代理对象的指定方法
        method.invoke(this.object,objects);
        System.out.println(method.getName()+"方法执行结束");
        return null;
    }
    @Override
    public void test1() {
        System.out.println("test1方法");
    }

    @Override
    public void test2() {
        System.out.println("test2方法");
    }


}
interface ItestProxy {
    void test1();
    void test2();
}
