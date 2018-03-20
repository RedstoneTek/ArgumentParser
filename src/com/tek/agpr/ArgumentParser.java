package com.tek.agpr;

import java.util.Arrays;
import java.util.List;

import com.tek.agpr.parsers.BooleanParser;
import com.tek.agpr.parsers.ByteParser;
import com.tek.agpr.parsers.CharacterParser;
import com.tek.agpr.parsers.DoubleParser;
import com.tek.agpr.parsers.FloatParser;
import com.tek.agpr.parsers.IntegerParser;
import com.tek.agpr.parsers.LongParser;
import com.tek.agpr.parsers.Parser;
import com.tek.agpr.parsers.ShortParser;

public class ArgumentParser {
	
	private Class<?>[] classes;
	private List<Parser<?>> parsers;
	
	public ArgumentParser(Class<?>... classes) {
		this.classes = classes;
		
		this.parsers = Arrays.asList(
				new BooleanParser(),
				new CharacterParser(),
				new LongParser(),
				new IntegerParser(),
				new ShortParser(),
				new ByteParser(),
				new FloatParser(),
				new DoubleParser()
				);
	}
	
	public ParseResult parse(String[] arguments) {
		if(arguments.length != classes.length) return ParseResult.INVALIDLENGTH;
		
		ParseResult result = ParseResult.SUCCESS;
		result.setParsedLength(arguments.length);
		
		for(int i = 0; i < arguments.length; i++) {
			if(arguments[i] == null || arguments[i].isEmpty()) return ParseResult.EMPTYARG.setIndex(i);
			
			Class<?> clazz = classes[i];
			
			if(clazz.getName().equals(String.class.getName())) {
				result.append(arguments[i], i);
				continue;
			}
			
			boolean parsed = false;
			for(Parser<?> parser : parsers) {
				if(parser.getType().equals(clazz)) {
					Object iparsed;
					if((iparsed = parser.Parse(arguments[i])) != null) {
						parsed = true;
						result.append(iparsed, i);
						continue;
					}else {
						return ParseResult.PARSEERROR.setIndex(i);
					}
				}
			}
			
			if(!parsed) return ParseResult.NOPARSER.setIndex(i);
		}
		
		return result;
	}
	
	public void registerParser(Parser<?> parser) {
		this.parsers.add(parser);
	}
	
}
