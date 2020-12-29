package io.github.GioSDA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import io.github.GioSDA.interpreter.BowlInterpreter;
import io.github.GioSDA.parser.BowlParser;

public class Main {

	public static void main(String[] args) {
		String code = "";
		LinkedList<String> argl = new LinkedList<String>();
		
		if (args.length < 1) {
			Scanner s = new Scanner(System.in).useDelimiter("\n");
			
			argl.addAll(Arrays.asList(s.next().split(" ")));
			
			s.close();
		} else {
			
			argl.addAll(Arrays.asList(args));
		}
		
		code = argl.pop();
		
		BowlParser parser = new BowlParser(code);
		
		BowlInterpreter interpreter = new BowlInterpreter(parser.parse(), argl);
		
		interpreter.eval();
	}

}
