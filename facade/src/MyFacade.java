/**
 * @Author garygan
 * @Date 2022/8/5 21:22
 * @Description
 */
public class MyFacade {
    class CPU {
        public void start() {
            System.out.println("cpu start");
        }
    }

    class GPU {
        public void start() {
            System.out.println("gpu start");
        }
    }


    class Computer {
        public void start() {
            new CPU().start();
            new GPU().start();
        }
    }
}
