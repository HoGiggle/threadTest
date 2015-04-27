package com.jjhu.test.miniProject;

public class ThreadOne implements Runnable {

	@Override
	public void run() {
		for(int i = 3; i > 0; --i){
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ThreadOne td = new ThreadOne();
		new Thread(td, "A").start();;
		new Thread(td, "B").start();;
		new Thread(td).start();;
	}

}
