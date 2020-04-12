package com.graves.tree;

import java.util.Arrays;

/**
 * @author Graves
 * @title: PriorityQueue
 * @projectName Algorithm
 * @description: 优先队列
 * @date 2020/4/12 23:26
 */
public class PriorityQueue {

    private int[] array;
    private int size;

    public PriorityQueue(){
        // 队列初始长度32
        array = new int[32];
    }

    public void enQueue(int key){
        // 队列长度超出范围，扩容
        if(size >= array.length){
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
    * @Author Graves
    * @Description //出队
    * @Date  23:30
    * @Param []
    * @return int
    */
    public int deQueue() throws Exception{
        if(size <= 0){
            throw new Exception("the queue is empty");
        }
        // 获取堆顶元素
        int head = array[0];
        // 让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
    * @Author Graves
    * @Description //上浮
    * @Date  23:32
    * @Param []
    * @return void
    */
    private void upAdjust(){
        int childIndex = size - 1;
        int parentIndex = (childIndex -1)/2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while(childIndex > 0 && temp > array[parentIndex]){
            // 无需真正交换，单项赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex/2;
        }
        array[childIndex] = temp;
    }

    private void downAdjust() {
        // temp保存父节点的值，用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            // r如果有右孩子，并且右孩子大于左孩子的值，则定位到右孩子
            if(childIndex + 1 < size && array[childIndex + 1] > array[childIndex]){
                childIndex++;
            }
            // 如果父节点大于任何一个孩子，则直接跳出
            if(temp > array[childIndex]){
                break;
            }
            // 无需真正交换，单项赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex*2 +1;
        }
        array[parentIndex] = temp;
    }

    /**
    * @Author Graves
    * @Description //队列扩容
    * @Date  23:42
    * @Param []
    * @return void
    */
    private void resize() {
        // 队列翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(2);
        System.out.println("出队元素 ： "+ priorityQueue.deQueue());
        System.out.println("出队元素 ： "+ priorityQueue.deQueue());
    }
}
