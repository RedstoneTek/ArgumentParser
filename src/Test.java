import com.tek.agpr.ArgumentParser;
import com.tek.agpr.ParseResult;

public class Test {
	
	public static void main(String[] args) {
		String[] arguments = new String[5];
		arguments[0] = "hello";
		arguments[1] = "128";
		arguments[2] = "5.5";
		arguments[3] = "321990321";
		arguments[4] = "false";
		
		ArgumentParser parser = new ArgumentParser(String.class, Byte.class, Double.class, Long.class, Boolean.class);
		ParseResult result = parser.parse(arguments);
		if(result.equals(ParseResult.SUCCESS)) {
			String arg1 = (String)result.atIndex(0);
			byte arg2 = (byte)result.atIndex(1);
			double arg3 = (double)result.atIndex(2);
			long arg4 = (long)result.atIndex(3);
			boolean arg5 = (boolean)result.atIndex(4);
			System.out.println("Success -> " + arg1 + " " + arg2 + " " + arg3 + " " + arg4 + " " + arg5);
		}else {
			System.out.println("Error while parsing " + result.name() + " at index " + result.getIndex());
		}
	}
	
}
