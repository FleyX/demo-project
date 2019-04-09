package base;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/4/8 11:04
 */
public class CustomThreadExtendThread extends Thread{

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println("创建线程名为："+threadName+",id为："+threadId);
    }

    public static void main(String[] args){
        Thread thread1 = new CustomThreadExtendThread();
        Thread thread2 = new CustomThreadExtendThread();
        thread1.start();
        thread2.start();
    }
}
