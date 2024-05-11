package hw;

import java.util.*;

/**
 * @author: 郭晨旭
 * @create: 2024-01-06 15:44
 * @version: 1.0
 */
public class TreadTest {
    public static void main(String[] args) {
        new Thread(new MyThread(), "线程1").start();
        new Thread(new MyThread(), "线程2").start();
        new Thread(new MyThread(), "线程3").start();
    }
}
