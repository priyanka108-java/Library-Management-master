package com.genpact.LibraryManagement.service.impl;

public class JunitDemo {

	
	public int add(int a, int b) throws Exception {
		if(a== 0 && b== 0) {
			System.out.println("Exception thrown");
			throw new Exception("Both numbers are zeros");
		}
		Thread.currentThread().sleep(100);
		
		return a+b;
	}
}
