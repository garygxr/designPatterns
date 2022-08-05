import java.util.ArrayList;
import java.util.List;

/**
 * @Author garygan
 * @Date 2022/8/5 21:52
 * @Description
 */
public class MyObserver {
    static class Event {
        public String msg;

        public Event(String haha) {
            this.msg = haha;
        }
    }

    interface Observer {
        public void update(Event event);
    }


    static class ObserverA implements Observer {

        @Override
        public void update(Event event) {
            System.out.println("update A" + event.msg);
        }
    }

    static class ObserverB implements Observer {

        @Override
        public void update(Event event) {
            System.out.println("update B" + event.msg);
        }
    }

    static class Subject {
        List<Observer> observerList = new ArrayList<>();

        public void subject(Observer observer) {
            observerList.add(observer);
        }

        public void notifyAllObservers(Event event) {
            for (Observer observer : observerList) {
                observer.update(event);
            }
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.subject(new ObserverA());
        subject.subject(new ObserverB());

        Event haha = new Event("haha");
        subject.notifyAllObservers(haha);
    }


}
