package io.github.GioSDA;

import java.util.Arrays;
import java.util.LinkedList;

import io.github.GioSDA.interpreter.BowlInterpreter;

public class Main {

	public static void main(String[] args) {
		LinkedList<String> argl = new LinkedList<String>(Arrays.asList(args));
		
		String code = argl.getFirst();
		
		BowlInterpreter BI = new BowlInterpreter(code, args);
		
	}

}
