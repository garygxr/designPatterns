import java.util.HashMap;
import java.util.Map;

/**
 * @Author garygan
 * @Date 2022/8/5 20:44
 * @Description
 */
public class MyStrategy {
    interface Strategy {
        public void doSomething();
    }


    class PrintA implements Strategy {
        static int id = 1;

        @Override
        public void doSomething() {
            System.out.println("A");
        }
    }

    class PringB implements Strategy {
        static int id = 2;

        @Override
        public void doSomething() {
            System.out.println("B");
        }
    }

    class Context {
        Map<Integer, Strategy> context = new HashMap<>();

        public Context() {
            context.put(PrintA.id, new PrintA());
            context.put(PringB.id, new PringB());
        }

        public void print(int i) {
            Strategy strategy = context.get(i);
            strategy.doSomething();
        }
    }

    public static void main(String[] args) {
        Context context = new MyStrategy().new Context();
        context.print(1);
    }
}
