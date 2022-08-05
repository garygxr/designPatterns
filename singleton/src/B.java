/**
 * @Author garygan
 * @Date 2022/8/4 18:37
 * @Description
 */
public class B {
    private static B b;

    private B() {
    }

    public static B getInstance() {
        if (b == null) {
            synchronized (B.class) {
                if (b == null) {
                    b = new B();
                }
                return b;
            }
        }
        return b;
    }
}
