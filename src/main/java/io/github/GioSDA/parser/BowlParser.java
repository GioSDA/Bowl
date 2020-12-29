package io.github.GioSDA.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlParser {

	private String code;
	
	private List<Character> codepage = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'));
	
	public BowlParser(String code) {
		this.code = code;
	}
	
	public byte[] parse() {
		byte[] instructions = new byte[code.length()];
		for (int i = 0; i < code.length(); i++) {
			int b = codepage.indexOf(code.charAt(i));
			if (b != -1) {
				instructions[i] = (byte) (codepage.indexOf(code.charAt(i)) + 1);
			}
		}
		return instructions;
	}
	
}
