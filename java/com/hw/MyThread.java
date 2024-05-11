package hw;

/**
 * @author: 郭晨旭
 * @create: 2024-01-06 15:47
 * @version: 1.0
 */
public class MyThread extends Thread {

    private static int sum = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (sum > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖出了第 " + sum-- + " 张票");
                } else {
                    break;
                }
            }
        }
    }
}
