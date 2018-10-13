package com.test.multithreading;

public class CurrentThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = Thread.currentThread();
		System.out.println("name: "+thread);
		System.out.println(thread.getName());
		thread.setName("name");
		System.out.println("name: "+thread.getName());
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			thread.sleep(1000);
		}
	}
}
