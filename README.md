# About
This repository was made in the goal of simplifying user to software communication, more specifically when using commands or have to decorticate a message.

## Basic Usage
1. Import the [JarFile](https://github.com/RedstoneTek/ArgumentParser/blob/master/builds/1.0.0.jar?raw=true) into your project.

2. Initialize an ArgumentParser instance whilst passing the DataTypes you want to parse

```
//In this example I'm going to parse a String and an Integer
ArgumentParser myParser = new ArgumentParser(String.class, Integer.class);
```

3. Register your custom parsers (If Applicable) **More on that further below**

```
myParser.registerParser(new MyParser());
```

4. Parse Away!

```
ParseResult myParseResult = myParser.parse(someStringArrayWithArguments);
//Do something with myParseResult
```

*If you want an example of how to get the results from the result, see [Test.class](src/Test.java)*

## Custom Parser
In order to register a custom parser, you must first understand what it has to do. A custom parser, will parse one data-type in particular, will return the data-type object if correctly parsed and null if there was an error whilst parsing.

Knowing this we can make a very simple parser for a "Fraction" object of ours.

1. Make a class extending Parser with the data-type <>

```
public FractionParser extends Parser<Fraction>{
}
```

2. Afterwards we will need the constructor. This part is fairly simple

```
public FractionParser(){
	super(Fraction.class);
}
```

3. For our last step, we will want to create the parse function.

```
@Override
public Fraction Parse(String argument) {
	//Because I don't want to make it too complicated, I am going to assume that the two sides are valid integers.
	//A valid fraction should look like this: 5/10
	String[] tokens = argument.split("/");
	
	if(tokens.length() == 2){
		int side1 = Integer.parseInt(tokens[0]);
		int side2 = Integer.parseInt(tokens[1]);
		
		return new Fraction(side1, side2);
	}
	
	return null;
}
```

**Don't forget to register your Custom Parser!**