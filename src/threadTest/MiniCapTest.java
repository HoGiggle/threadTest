package threadTest;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

class MiniTestRunnable implements Runnable{
	public MiniTestRunnable(String inUrl, NameValuePair []inParams){
		this.url = inUrl;
		this.reqParams = inParams;
	}
	
	public MiniTestRunnable(String inUrl){
		this.url = inUrl;
	}
	
	public void run(){
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url);
		post.setRequestBody(reqParams);
		try {
			client.executeMethod(post);	
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		post.releaseConnection();
	}
	
	private String url;                            //�������Ա����������request����url��parameters
	private NameValuePair []reqParams;
}

public class MiniCapTest{
	public static void main(String[] args) {
		ExecutorService esCached = Executors.newCachedThreadPool();      //ע����̳߳�ΪCache�ͣ���Ϊ���賤ʱ������
		ExecutorService esFixed   = Executors.newFixedThreadPool(1000);  //��¼���̳߳���fixed�ͣ��û�����ʱ�䲻��
		String registerUrl = "http://localhost:8080/myservlet/register";
		String loginUrl    = "http://localhost:8080/myservlet/login";
		String yoUrl       = "http://localhost:8080/myservlet/yo";
		String logoutUrl   = "http://localhost:8080/myservlet/logout";
		/*
		for(int i = 0; i < 5000; ++i){                           //ע�Ṧ�ܲ���
			NameValuePair []params = {new NameValuePair("username", "U" + i), new NameValuePair("password", "P" + i)};
			esCached.execute(new MiniTestRunnable(registerUrl, params));
		}*/
		
		/*for(int i = 0; i < 5000; ++i){                           //��¼���ܲ���
			NameValuePair []params = {new NameValuePair("username", "U" + i), new NameValuePair("password", "P" + i)};
			esFixed.execute(new MiniTestRunnable(loginUrl, params));
		}*/
		
//		int count = 0;
//		for(int i = 0; i < 30; ++i){                             //yo���ܲ���
//			for(int j = i + 1; j < 30; ++j){
//				NameValuePair []params = {new NameValuePair("from", "U" + i), new NameValuePair("to", "U" + j)};
//				count++;	
//				esCached.execute(new MiniTestRunnable(yoUrl, params));
//			}
//		}
//		System.out.println(count);
		
		for(int i = 0; i < 5000; ++i){                           //ע�����ܲ���
			NameValuePair []params = {new NameValuePair("user", "U" + i)};	
			esCached.execute(new MiniTestRunnable(logoutUrl, params));
		}
	}
}