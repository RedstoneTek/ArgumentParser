package com.tek.agpr.parsers;

public class ByteParser extends Parser<Byte>{

	public ByteParser() {
		super(Byte.class);
	}

	@Override
	public Byte Parse(String argument) {
		if(IntegerParser.NONDECIMAL_NUMBER_PATTERN.matcher(argument).matches()) {
			try {
				return Byte.parseByte(argument);
			}catch(Exception e) {
				//WILL ONLY BE CALLED IF THE STRING OVERFLOWS
				return null;
			}
		}
		
		return null;
	}

}
