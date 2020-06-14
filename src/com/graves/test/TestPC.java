package com.graves.test;

import java.security.Provider;
import java.util.Random;

/**
 * @author Graves
 * @DESCRIPTION 生产者消费者模式
 * @create 2020/6/14
 */
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Thread(new Producter(synContainer)).start();
        new Thread(new Coustomer(synContainer)).start();
    }
}

class Producter implements Runnable{
    private SynContainer SynContainer;

    public Producter(com.graves.test.SynContainer synContainer) {
        SynContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            SynContainer.push(new Chicken(i));
            System.out.println("生产了第" + i + "只鸡");
        }
    }
}

class Coustomer implements Runnable{
    private SynContainer SynContainer;

    public Coustomer(com.graves.test.SynContainer synContainer) {
        SynContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("消费了第" + SynContainer.pop().id + "只鸡");
        }
    }
}

class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer{
    Chicken[] chickens = new Chicken[10];

    // 计数器
    int count = 0;

    public synchronized void push(Chicken c){
        if(count == chickens.length){
            // 通知消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = c;
        count++;
        // 叫醒
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if(count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        // 叫醒
        this.notifyAll();
        return chicken;
    }
}
