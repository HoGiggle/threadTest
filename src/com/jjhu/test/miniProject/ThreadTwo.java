package com.jjhu.test.miniProject;

public class ThreadTwo extends Thread {

	public ThreadTwo() {
		 
    }
 
    public ThreadTwo(String name) {
        this.name = name;
    }
 
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "ÔËÐÐ     " + i);
        }
    }
 
    public static void main(String[] args) {
    	ThreadTwo h1 = new ThreadTwo("A");
    	ThreadTwo h2 = new ThreadTwo("B");
        h1.start();
        h2.start();
    }
 
    private String name;
}
