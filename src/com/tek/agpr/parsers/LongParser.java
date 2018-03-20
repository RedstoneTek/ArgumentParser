package com.tek.agpr.parsers;

public class LongParser extends Parser<Long>{

	public LongParser() {
		super(Long.class);
	}

	@Override
	public Long Parse(String argument) {
		if(IntegerParser.NONDECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Long.parseLong(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
