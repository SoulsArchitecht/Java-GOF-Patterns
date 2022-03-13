package gof_patterns.Pattern17_Proxy;

/** Заместитель (Proxy) — это структурный паттерн проектирования, который позволяет подставлять
вместо реальных объектов специальные объекты-заменители. Эти объекты перехватывают вызовы
к оригинальному объекту, позволяя сделать что-то до или после передачи вызова оригиналу. */

import gof_patterns.Pattern8_Facade.GoodsOrderAndShippingFacade.Main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyExample {
    public static void main(String[] args) {
/*        Reader reader = new ProxyReader();
        reader.read("hello");*/

        InvocationHandler invocationHandler = new ReaderInvocationHandler();
        Object proxyInstance =
                Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] {Reader.class}, invocationHandler);
        ((Reader)proxyInstance).read("hello");
    }
}

interface Reader {
    String read(String str);
}

class MyReader implements Reader {

    @Override
    public String read(String str) {
        return str + " world";
    }
}

//good practice
class ReaderInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(args[0]);
        Object result = method.invoke(new MyReader(), args);
        System.out.println(result);
        return result;
    }
}

//bad practice
class ProxyReader extends MyReader {
    @Override
    public String read(String str) {
        System.out.println(str + " method start");
        String read = super.read(str);
        System.out.println(str + " method end");
        return read;
    }
}
