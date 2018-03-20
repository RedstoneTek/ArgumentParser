package com.tek.agpr.parsers;

public class DoubleParser extends Parser<Double>{

	public DoubleParser() {
		super(Double.class);
	}

	@Override
	public Double Parse(String argument) {
		if(IntegerParser.DECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Double.parseDouble(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
