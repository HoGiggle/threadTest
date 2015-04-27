package com.jjhu.test.miniProject;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

class TestRunnable implements Runnable{
	
	public TestRunnable(String name, String pwd){
		username = name;
		password = pwd;
	}
	
	public void run(){
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://localhost:8080/myservlet/register");
		NameValuePair username = new NameValuePair("username", this.username);
		NameValuePair password = new NameValuePair("password", this.password);
		post.setRequestBody(new NameValuePair[] {username, password});
		try {
			client.executeMethod(post);
//			String response = new String(post.getResponseBodyAsString().getBytes());
//			System.out.println(response);		
		} catch (HttpException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		post.releaseConnection();
	}
	
    private	String username;
    private String password;
}

public class TestThreadPool {

	public static void main(String[] args) throws IOException {
		/*ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 1000; ++i){
			String username = "uu" + i;
			String password = "pp" + i;
			es.execute(new TestRunnable(username, password));
		}*/

        for (int i = 0; i < 1000; i++){
            String uname = "uu" + i;
            String pass = "pp" + i;
            Thread one = new Thread(new TestRunnable(uname, pass));
            one.start();
        }
	}
}
