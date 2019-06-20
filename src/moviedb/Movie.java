package moviedb;
/*
 * This class is a wrapper for a HashMap which maps String values
 * to Comparable values. The Strings and their corresponding values 
 * will be determined by the class which fills the movie
 */


import java.util.HashMap;

public class Movie {
	
	HashMap<String, Comparable<?>> fields;
	
	public Movie() {
		fields = new HashMap<String, Comparable<?>>();
	}
	
	public void addField(String fieldName, Comparable<?> fieldValue) {
		fields.put(fieldName, fieldValue);
	}
	
	public Comparable<?> getField(String fieldName){
		return fields.get(fieldName);
	}
	
	public boolean contains(String fieldName) {
		return fields.containsKey(fieldName);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(String s : fields.keySet()) {
			str += s +": " + fields.get(s) +"\n";  
		}
		return str;
	}

}
