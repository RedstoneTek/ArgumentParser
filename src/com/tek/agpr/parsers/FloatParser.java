package com.tek.agpr.parsers;

public class FloatParser extends Parser<Float>{

	public FloatParser() {
		super(Float.class);
	}

	@Override
	public Float Parse(String argument) {
		if(IntegerParser.DECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Float.parseFloat(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
