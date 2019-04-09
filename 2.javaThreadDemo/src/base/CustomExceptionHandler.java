package base;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/4/9 10:54
 */
public class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获到线程"+t.getName()+",异常：" + e.getMessage());
        e.printStackTrace();
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler());
        new Thread(() -> {
            throw new RuntimeException("test");
        }).start();
    }
}
