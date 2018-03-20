package com.tek.agpr;

public enum ParseResult {
	
	SUCCESS(),
	NOPARSER(),
	PARSEERROR(),
	INVALIDLENGTH(),
	EMPTYARG();
	
	private int index = -1;
	private Object[] parsed;
	
	public void setParsedLength(int size) {
		this.parsed = new Object[size];
	}
	
	public ParseResult append(Object obj, int index) {
		parsed[index] = obj;
		return this;
	}
	
	public Object atIndex(int index) {
		return parsed[index];
	}
	
	public ParseResult setIndex(int index) {
		this.index = index;
		return this;
	}
	
	public int getIndex() {
		return this.index;
	}
	
}
