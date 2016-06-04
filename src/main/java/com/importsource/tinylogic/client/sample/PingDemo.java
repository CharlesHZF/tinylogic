package com.importsource.tinylogic.client.sample;

public class PingDemo {

	public static void main(String[] args) {
		
		for(int i=0;i<1;i++){
			String s = HttpRequest.sendGet("http://localhost:9000/apps?sdf=sdfs", "sdf");
			System.out.println(s);
		}
		// TODO 
		// 发送 GET 请求
		

		// 发送 POST 请求
		/*String sr = HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
		System.out.println(sr);*/
	}

}
