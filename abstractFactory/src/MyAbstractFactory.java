/**
 * @Author garygan
 * @Date 2022/8/5 20:55
 * @Description
 */
public class MyAbstractFactory {
    interface A {
        public void method();
    }

    public class B implements A {

        @Override
        public void method() {
            System.out.println("B");
        }
    }

    public class C implements A {

        @Override
        public void method() {
            System.out.println("C");
        }
    }

    public class AbstractFactory {
        public A getInstance(int i) {
            if (i == 0) {
                return new B();
            } else {
                return new C();
            }
        }
    }
}
