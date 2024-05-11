package hw;

import java.util.Scanner;

/**
 * main
 *
 * @author: 郭晨旭
 * @create: 2023-09-26 19:41
 * @version: 1.0
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("输入值必须要大于 0");
            return;
        }

        int[] fibonacciSequence = new int[n];

        FibonacciThread fibonacciThread = new FibonacciThread(n, fibonacciSequence);
        fibonacciThread.start();

        try {
            fibonacciThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSequence[i] + " ");
        }
    }
}

class FibonacciThread extends Thread {
    private int n;
    private int[] fibonacciSequence;

    public FibonacciThread(int n, int[] fibonacciSequence) {
        this.n = n;
        this.fibonacciSequence = fibonacciSequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                fibonacciSequence[i] = i;
                continue;
            }
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
    }
}
