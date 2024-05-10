package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class hello {
@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloworld() {
	return "Hello World, World Hello";
}
@RequestMapping(value = "/score", method = RequestMethod.GET)
	public String update(String rev) {
	StringBuilder sb = new StringBuilder(rev);
	
	return sb.reverse().toString();
}
@RequestMapping(value = "/add", method = RequestMethod.GET)
	public int add(int digitOne, int digitTwo) {
	
	try {
		return digitOne + digitTwo;
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		
	} return 0;
}
@RequestMapping(value = "/sub", method = RequestMethod.GET)
public int sub(int digitOne, int digitTwo) {
	
	try {
		return digitOne - digitTwo;
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		
	} return 0;
}
@RequestMapping(value = "/div", method = RequestMethod.GET)
public double div(double digitOne, double digitTwo) {
	
	try {
		return digitOne / digitTwo;
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		
	} return 0;
}
@RequestMapping(value = "/multi", method = RequestMethod.GET)
public int multi(int digitOne, int digitTwo) {
	
	try {
		return digitOne * digitTwo;
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		
	} return 0;
}

// added this after leaving class while waiting for the train to arrive. 
// Thought it might be better to set everything inside one method

@RequestMapping(value = "/math", method = RequestMethod.GET)
	public double math(double digitOne, String op, double digitTwo) {
	op = op.toLowerCase();
	try {
		
		switch (op) {
		case "plus": return digitOne + digitTwo;
		case "times": return digitOne * digitTwo;
		case "minus": return digitOne - digitTwo;
		case "divided": return digitOne / digitTwo;
		case "expo": return Math.pow(digitOne, digitTwo);
		default: return 0;
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
	}
	return 0;
	
	

}
}
