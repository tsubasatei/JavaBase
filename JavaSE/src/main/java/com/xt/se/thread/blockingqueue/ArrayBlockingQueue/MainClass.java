package com.xt.se.thread.blockingqueue.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {
 
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3,true);
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}