package com.jjhu.test.miniProject;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class MiniHttpClient {

	public static void main(String[] args) throws IOException{
		HttpClient client = new HttpClient();
		//client.getHostConfiguration().setHost("http://localhost:8080/myservlet");
		//HttpMethod method = getPostMethod(); // ??? POST ????????
		HttpMethod method = getGetMethod();
		System.out.println(client.executeMethod(method));
		String response = new String(method.getResponseBodyAsString().getBytes());
		System.out.println(response);
		method.releaseConnection();
	}

	private static HttpMethod getGetMethod() {
		return new GetMethod("http://localhost:8080/myservlet/login");
	}

	/**
	 * ??? POST ????????
	 *
	 * @return
	 */
	private static HttpMethod getPostMethod() {
		PostMethod post = new PostMethod("http://localhost:8080/myservlet/register");
		NameValuePair username = new NameValuePair("username", "heihei");
		NameValuePair password = new NameValuePair("password","heihei");
		post.setRequestBody(new NameValuePair[] {username, password});
		return post;
	}

}
