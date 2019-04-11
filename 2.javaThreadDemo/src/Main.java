import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("当前线程名为：" + Thread.currentThread().getName());
        System.out.println("当前线程id为：" + Thread.currentThread().getId());
    }
}

class Item implements Delayed {
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
