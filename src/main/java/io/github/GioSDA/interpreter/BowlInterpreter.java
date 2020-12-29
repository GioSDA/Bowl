package io.github.GioSDA.interpreter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BowlInterpreter {

	private List<Object> list = new ArrayList<Object>();
	public byte[] bs;
	
	public BowlInterpreter(byte[] bs, LinkedList<String> input) {
		this.bs = bs;
		
		for (String i : input) {
			list.add(Integer.parseInt(i));
		}
	}
	
	public void eval() {
		System.out.println(eval(bs));
	}
	
	public Object eval(byte[] bs) {
		for (byte c : bs) {
			switch (c) {
			case 1: //A
				return list;
			}
		}
		return bs;
	}
	
}
