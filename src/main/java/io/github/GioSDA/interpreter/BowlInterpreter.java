package io.github.GioSDA.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BowlInterpreter {

	private Stack<Object> stack = new Stack<Object>();
	private List<Object> list = new ArrayList<Object>();
	private boolean mode;
	public byte[] bs;
	
	public BowlInterpreter(byte[] bs, Queue<String> argl) {
		this.bs = bs;
		this.mode = !isInteger(argl.peek());
		
			for (String i : argl) {
				if (!mode) list.add(Integer.parseInt(i));
				if (mode) list.add(i);
			}
		
			
	}
	
	public void eval() {
		eval(bs);
		System.out.println(list);
	}
	
	public void eval(byte[] bs) {
		for (byte c : bs) {
			switch (c) {
			case 1: //+
				add(stack.pop());
				break;
			case 2: //-
				subtract(stack.pop());
				break;
			case 3: //×
				multiply(stack.pop());
				break;
			case 4: //÷
				divide(stack.pop());
				break;
			case 5: //"
				stack.push(10); 
				break;
			}
		}
	}
	
	public void add(Object a) {
		if (!mode) list.replaceAll(m -> (int) m + (int) a);
		else list.replaceAll(m -> (String) m + (String) a);
	}
	
	public void subtract(Object a) {
		list.replaceAll(m -> (int) m - (int) a);
	}
	
	@SuppressWarnings("unchecked")
	public void multiply(Object a) {
		if (!mode) list.replaceAll(m -> (int) m * (int) a);
		else list.replaceAll(m -> zip((List<String>) m, (String)a));
	}
	
	public void divide(Object a) {
		list.replaceAll(m -> (int) m / (int) a);
	}
	
	public List<String> zip(List<String> a, String b) {
		List<String> newa = new ArrayList<>();
		for (String c : a) {
			char[] ca = new char[c.length() + b.length()];
			for (int i = 0; i < ca.length; i++) {
				ca[i*2] = c.charAt(i);
			}
			for (int i = 0; i < ca.length; i++) {
				ca[i*2+1] = b.charAt(i);
			}
			newa.add(ca.toString());
		}
		return newa;
	}
	
	public static boolean isInteger(String str) {
		//https://stackoverflow.com/a/237204/10572739
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

	
}
