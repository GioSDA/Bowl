package io.github.GioSDA.interpreter;

import java.util.ArrayList;
import java.util.List;

public class BowlInterpreter {

	private List<Object> list = new ArrayList<Object>();

	
	public BowlInterpreter(byte[] bs, String[] input) {
		for (String i : input) {
			list.add(input);
		}
		
		System.out.println(eval(bs));
	}
	
	public Object eval(byte[] bs) {
		
	}
	
}
