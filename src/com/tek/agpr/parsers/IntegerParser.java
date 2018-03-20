package com.tek.agpr.parsers;

import java.util.regex.Pattern;

public class IntegerParser extends Parser<Integer>{

	public static final Pattern NONDECIMAL_NUMBER_PATTERN = Pattern.compile("-?\\d+");
	public static final Pattern DECIMAL_NUMBER_PATTERN = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
	
	public IntegerParser() {
		super(Integer.class);
	}

	@Override
	public Integer Parse(String argument) {
		if(NONDECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Integer.parseInt(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
