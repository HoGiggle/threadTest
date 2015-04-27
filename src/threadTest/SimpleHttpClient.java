package threadTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SimpleHttpClient {

	public static void main(String[] args) throws IOException {
		String url = "http://www.g.cn/";    
        System.out.println("Visit google using Apache commons-httpclient 3.1:");
        List<NameValuePair> data3 = new ArrayList<NameValuePair>();  
        data3.add(new NameValuePair("username", "testuser"));  
        data3.add(new NameValuePair("password", "testpassword"));  
        System.out.println(post3(url, data3));  
	}
	
	public static String post3(String url, List<NameValuePair> data) throws IOException {  
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();  
        PostMethod postMethod = new PostMethod(url);  
        postMethod.setRequestBody(data.toArray(new NameValuePair[data.size()]));  
        try {  
            System.out.println("<< Response: " + httpClient.executeMethod(postMethod));  
            return postMethod.getResponseBodyAsString();  
        } finally {  
            postMethod.releaseConnection();  
        }  
    }  
}
