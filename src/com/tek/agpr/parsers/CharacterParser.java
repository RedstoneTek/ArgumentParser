package com.tek.agpr.parsers;

public class CharacterParser extends Parser<Character>{

	public CharacterParser() {
		super(Character.class);
	}

	@Override
	public Character Parse(String argument) {
		if(argument.length() == 1) return argument.charAt(0);
		
		return null;
	}
	
}
