package synchronization;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类功能简述：测试不使用同步的后果
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/4/10 10:28
 */
public class Demo1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        //创建10个线程，不停的将一个账号资金转移到另一个账号上
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    int account1 = ((Double) Math.floor(Math.random() * 10)).intValue();
                    int account2 = ((Double) Math.floor(Math.random() * 10)).intValue();
                    int num = ((Long) Math.round(Math.random() * 100)).intValue();
                    bank.transfer(account1, account2, num);
                    try {
                        Thread.sleep(((Double) (Math.random() * 10)).intValue());
                    } catch (Exception e) {
                    }
                }
            }).start();
        }
    }
}

class Bank {
    /**
     * 10个资金账户
     */
    public int[] accounts = new int[10];

    private ReentrantLock lock = new ReentrantLock();
//    private Condition condition = lock.newCondition();

    public Bank() {
        Arrays.fill(accounts, 1000);
    }

    synchronized public void transfer(int from, int to, int num) {
        try {
//            lock.lock();
            while (accounts[from] < num) {
                //进入阻塞状态
//                condition.await();
                this.wait();
            }
            accounts[from] -= num;
            accounts[to] += num;
            //计算和
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += accounts[j];
            }
            System.out.println(sum);
            //通知解除阻塞
//            condition.signalAll();
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            lock.unlock();
//        }
    }
}
