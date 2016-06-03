package com.importsource.tinylogic.client.sample;

public class PingDemo {

	public static void main(String[] args) {
		
		for(int i=0;i<2000000;i++){
			String s = HttpRequest.sendGet("http://localhost:8080/myApp/list1", "bbb=sdfsdf");
			System.out.println(s);
		}
		// TODO 
		// 发送 GET 请求
		

		// 发送 POST 请求
		/*String sr = HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
		System.out.println(sr);*/
	}

}
