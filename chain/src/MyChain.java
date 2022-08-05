import java.util.ArrayList;
import java.util.List;

/**
 * @Author garygan
 * @Date 2022/8/5 22:09
 * @Description
 */
public class MyChain {

    public static void main(String[] args) {
        FilterA filterA = new FilterA();
        FilterB filterB = new FilterB();

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(filterA);
        filterChain.addFilter(filterB);

        Message message = new Message("hello ");
        filterChain.filter(message);
        System.out.println(message.msg);
    }
}

class Message {
    String msg;

    public Message(String message) {
        this.msg = message;
    }
}

interface Filter {
    boolean filter(Message message);
}

class FilterA implements Filter {

    @Override
    public boolean filter(Message message) {
        message.msg = message.msg + "a";
        return false;
    }
}

class FilterB implements Filter {

    @Override
    public boolean filter(Message message) {
        message.msg = message.msg + "b";
        return false;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    boolean state = true;

    @Override
    public boolean filter(Message message) {
        for (Filter filter : filters) {
            if (!state) {
                return state;
            }
            state = filter.filter(message);
        }
        return state;
    }
}

