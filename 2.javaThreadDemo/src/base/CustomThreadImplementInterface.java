package base;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/4/8 11:11
 */
public class CustomThreadImplementInterface implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setName(((Double) Math.random()).toString());
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println("创建线程名为：" + threadName + ",id为：" + threadId);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CustomThreadImplementInterface());
        Thread thread2 = new Thread(new CustomThreadExtendThread());
        thread1.start();
        thread2.start();

        //使用lambda表达式，让创建线程更简单
        new Thread(() -> {
            System.out.println("创建了一个新线程");
        }).start();
    }
}
