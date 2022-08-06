/**
 * @Author garygan
 * @Date 2022/8/5 20:37
 * @Description
 */
public class StaticProxy {
    interface A {
        public void method();
    }

    class B implements A {
        @Override
        public void method() {
            System.out.println("哈哈");
        }
    }

    class BProxy implements A {
        B b;

        public BProxy() {
            this.b = new B();
        }

        @Override
        public void method() {
            System.out.println("start---");
            b.method();
            System.out.println("end----");
        }
    }

    public static void main(String[] args) {
        BProxy bProxy = new StaticProxy().new BProxy();
        bProxy.method();
    }
}
