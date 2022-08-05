/**
 * @Author garygan
 * @Date 2022/8/4 18:35
 * @Description
 */
public class A {
    public static A a = new A();

    private A() {
    }

    public static A getInstance() {
        return a;
    }
}
