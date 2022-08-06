import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author garygan
 * @Date 2022/8/6 16:09
 * @Description
 */
public class CglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SourcesA.class);
        enhancer.setCallback(new FuckWordMethodInterceptor());
        SourcesA a =(SourcesA) enhancer.create();
        a.method("haha");
    }
}

class FuckWordMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("fuck");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("you");
        return invoke;
    }
}

class SourcesA{
    public  void method(String message){
        System.out.println(message);
    }
}

