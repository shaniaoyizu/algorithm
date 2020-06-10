package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020-06-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class PrintABC {

    public static void main(String[] args) throws InterruptedException {
        PrintABC.print(1,1,1,10);
    }
    /**
     * Prints 'A','B','C' in loop according to requirements
     *
     * @param a     the count to print 'A' in one cycle
     * @param b     the count to print 'B' in one cycle
     * @param c     the count to print 'C' in one cycle
     * @param count total cycles
     */
    public static void print(int a, int b, int c, int count) throws InterruptedException {
        AlternateDemo demo = new AlternateDemo();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    demo.loopA(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    demo.loopB(b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                try {
                    demo.loopC(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class AlternateDemo {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * Prints 'A' in loop
     *
     * @param n
     * @throws InterruptedException
     */
    public void loopA(int n) throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.print("A");
            }
            number = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Prints 'B' in loop
     *
     * @param n
     * @throws InterruptedException
     */
    public void loopB(int n) throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.print("B");
            }
            number = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Prints 'C' in loop
     *
     * @param n
     * @throws InterruptedException
     */
    public void loopC(int n) throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 0; i < n; i++) {
                System.out.print("C");
            }
            System.out.println();
            number = 1;
            condition1.signal();
        } finally {
            lock.unlock();
        }
    }
}
