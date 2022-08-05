import java.util.ArrayList;
import java.util.List;

/**
 * @Author garygan
 * @Date 2022/8/5 22:22
 * @Description
 */
public class ServletChain {

    class Request {
        String message;

        public Request(String request) {
            this.message = request;
        }
    }

    class Response {
        String message;

        public Response(String response) {
            this.message = response;
        }
    }

    interface Filter {
        public boolean doFilter(Request request, Response response, FilterChain filter);
    }

    class FilterChain implements Filter {
        int index = 0;
        List<Filter> filters = new ArrayList<>();

        public FilterChain addFilter(Filter filter) {
            filters.add(filter);
            return this;
        }

        @Override
        public boolean doFilter(Request request, Response response, FilterChain filter) {
            if (index == filters.size()) {
                return false;
            }
            Filter filter1 = filters.get(index++);
            if (filter1 instanceof FilterChain) {
                filter = (ServletChain.FilterChain) filter1;
            }
            filter1.doFilter(request, response, filter);
            return true;
        }
    }

    class FilterA implements Filter {

        @Override
        public boolean doFilter(Request request, Response response, FilterChain filter) {
            System.out.println(request.message + "a");
            filter.doFilter(request, response, filter);
            System.out.println(response.message + "a");
            return true;
        }
    }

    class FilterB implements Filter {

        @Override
        public boolean doFilter(Request request, Response response, FilterChain filter) {
            System.out.println(request.message + "b");
            filter.doFilter(request, response, filter);
            System.out.println(response.message + "b");
            return true;
        }
    }

    class FilterC implements Filter {

        @Override
        public boolean doFilter(Request request, Response response, FilterChain filter) {
            System.out.println(request.message + "c");
            filter.doFilter(request, response, filter);
            System.out.println(response.message + "c");
            return true;
        }
    }

    class FilterD implements Filter {

        @Override
        public boolean doFilter(Request request, Response response, FilterChain filter) {
            System.out.println(request.message + "d");
            filter.doFilter(request, response, filter);
            System.out.println(response.message + "d");
            return true;
        }
    }


    public static void main(String[] args) {
        ServletChain servletChain = new ServletChain();
        FilterA filterA = servletChain.new FilterA();
        FilterB filterB = servletChain.new FilterB();

        FilterChain filterChain = servletChain.new FilterChain().addFilter(filterA).addFilter(filterB);
        Request request = servletChain.new Request("request");
        Response response = servletChain.new Response("response");

        FilterC filterC = servletChain.new FilterC();
        FilterD filterD = servletChain.new FilterD();
        FilterChain filterChain2 = servletChain.new FilterChain().addFilter(filterC).addFilter(filterD);
        filterChain.addFilter(filterChain2);

        filterChain.doFilter(request, response, filterChain);
    }


}

