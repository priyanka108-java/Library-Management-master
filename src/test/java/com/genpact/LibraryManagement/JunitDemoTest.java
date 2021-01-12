package com.genpact.LibraryManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.genpact.LibraryManagement.service.impl.JunitDemo;
//https://www.vogella.com/tutorials/JUnit/article.html
public class JunitDemoTest {
	
	
    JunitDemo junitDemo = new JunitDemo();
    
    int a;
    int b;
    int c;
    int d;
	
    @Before
    public void execBefore() {
    	a = 3;
    	b = 4;
    	c = -2;
    	d = -3;
    	System.out.println("Executes before every test case");
    }
    
    @After
    public void execAfter() {
    	a = 0;
    	b = 0;
    	c = 0;
    	d = 0;
    	System.out.println("Executes after every test case");
    }
    
    @BeforeClass
    public static void execBeforeClass() {
    	System.out.println("Executes before JunitDemoTest");
    }
    
    @AfterClass
    public static void execAfterClass() {
    	System.out.println("Executes after JunitDemoTest");
    }
    //@Ignore
	@Test
	public void addNegative() throws Exception {
		assertEquals(junitDemo.add(c, d),-5);
	}
	@Test(timeout=100)
	//@Test
	public void addPositive() throws Exception {
		assertEquals(junitDemo.add(a, b),7);
	}
	
	@Test(expected=Exception.class)
	public void addZeros() throws Exception {
		assertEquals(junitDemo.add(0, 0),0);
	}
}
