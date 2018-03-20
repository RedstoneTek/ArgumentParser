package com.tek.agpr.parsers;

public class BooleanParser extends Parser<Boolean>{

	public BooleanParser() {
		super(Boolean.class);
	}

	@Override
	public Boolean Parse(String argument) {
		if(argument.equals("true") || argument.equals("false")) {
			return Boolean.parseBoolean(argument);
		}
		
		return null;
	}

}
