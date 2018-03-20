package com.tek.agpr.parsers;

public abstract class Parser<T> {
	
	private final Class<T> type;
	
	public Parser(Class<T> type) {
		this.type = type;
	}
	
	public abstract T Parse(String argument);
	
	public Class<?> getType(){
		return type;
	}
	
}
