import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author garygan
 * @Date 2022/8/6 13:14
 * @Description
 */
public class DynamicProxy {
    public static void main(String[] args) {
        AProxy aProxy = new AProxy(new B());
        aProxy.method("haha");
    }
}

class AProxy implements A {
    A a;

    public AProxy(A a) {
        this.a = a;
    }

    @Override
    public void method(String message) {
        A aProxy = (A) Proxy.newProxyInstance(A.class.getClassLoader(), new Class[]{A.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("start---");
                if (args != null) {
                    Arrays.stream(args).forEach(System.out::println);
                }
                System.out.println(proxy);
                Object invoke = method.invoke(a, args);
                System.out.println("end---");
                return invoke;
            }
        });
        aProxy.method(message);
    }
}

class B implements A {

    @Override
    public void method(String message) {
        System.out.println("AAA"+message);
    }
}


interface A {
    void method(String message);
}
