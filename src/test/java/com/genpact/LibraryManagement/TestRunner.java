package com.genpact.LibraryManagement;

import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
  public static void main(String[] args) {
	  
	  Class<?>[] classes = { TestSuite.class};
	  Result result = JUnitCore.runClasses(new ParallelComputer(true, true), classes);
    
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
    
  }
}