package com.tek.agpr.parsers;

public class ShortParser extends Parser<Short>{

	public ShortParser() {
		super(Short.class);
	}

	@Override
	public Short Parse(String argument) {
		if(IntegerParser.NONDECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Short.parseShort(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
