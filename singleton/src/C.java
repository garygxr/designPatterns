/**
 * @Author garygan
 * @Date 2022/8/4 18:44
 * @Description
 */
public class C {

    private C() {
    }

    static class InnerClass{
       private final static C c = new C();
    }

    public C getInstance(){
        return InnerClass.c;
    }
}
