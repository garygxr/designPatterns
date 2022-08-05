/**
 * @Author garygan
 * @Date 2022/8/5 21:33
 * @Description
 */
public class MyDecorator {
    interface Shape {
        public void draw();
    }

    static class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("圆圈");
        }
    }

    static abstract class Decorator {
        Shape shape;

        public Decorator(Shape shape) {
            this.shape = shape;
        }

        public abstract void draw();
    }

    static class RedShapeDecorator extends Decorator {

        public RedShapeDecorator(Shape shape) {
            super(shape);
        }

        @Override
        public void draw() {
            shape.draw();
            System.out.println("red");
        }
    }

    public static void main(String[] args) {
        Decorator redShapeDecorator = new RedShapeDecorator(new Circle());
        redShapeDecorator.draw();
    }


}
