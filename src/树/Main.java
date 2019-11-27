package 树;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    //N为缓冲区大小
    private static final Integer N = 10;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private static Random sRandom = new Random();
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    class Producer implements Runnable {
        @Override
        public void run() {
            //获取锁
            lock.lock();
            try {
                while (list.size() == N) {
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(sRandom.nextInt(101));
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + list.size());
                //唤醒消费者
                notEmpty.signal();
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                while (list.size() == 0) {
                    try {
                        notEmpty.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.remove(0);
                System.out.println(Thread.currentThread().getName()
                        + "消费者消费，目前总共有" + list.size());
                notFull.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
