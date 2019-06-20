package moviedb;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieDBFileParser {

	private ArrayList<String> fields = null;
	
	public Movie[] fillDB(File file) {
		
		//Read the file into a list of strings (one line per string)
		List<String> fileLines = null;
		try {
		fileLines =	Files.readAllLines(file.toPath(),Charset.defaultCharset());
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		//get the name of the fields from the first line of the file and 
		//add those names to a list
		fields = getFieldNames(fileLines.get(0));
		
		Movie[] database = new Movie[fileLines.size()-1];
		
		//Initialize each Movie in database[]
		for(int i=0; i<database.length; i++)
			database[i] = new Movie();
		
		
		//Regex for parsing the fields from the lines
		String regex = "(\\d+),+(.*?),+\"?(.*?)\"?,+(\\d*?),+(.*?),+(.*?),+(.*?),+"
				+ ".*?,*(.*?),+(.*?),+(.*?),+(.*?),+(.*?),+(\\d*?),+(\\d+\\.?\\d*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		
		//Go through each line and assess whether it fulfills the pattern
		for(int i=0; i<fileLines.size()-1; i++) {
			
			matcher = pattern.matcher(fileLines.get(i+1));
			
			//if the line matches the pattern, add the present fields to the current Movie object
			//being selected. add a value for that field from the line
			if(matcher.matches()) {
			
				for(int j=1; j<=fields.size(); j++) {
											
					String fieldName = fields.get(j-1);
					String fieldValue = matcher.group(j);
					if(!fieldValue.isEmpty()) {
						//Add the field name and field value to the Movie object

						if(j == 1 || j == 4 || j == 13) { //group numbers that should be integers
							database[i].addField(fieldName, Integer.parseInt(fieldValue));
						}else if(j == 14) {
							database[i].addField(fieldName, Double.parseDouble((fieldValue)));
						}else
							database[i].addField(fieldName, fieldValue);

					}
				}
			}
		}
		
		return database;		
	}
	
	public ArrayList<String> getFieldNames(){
		return fields;
	}
	
	private ArrayList<String> getFieldNames(String lineWithFieldNames){

		ArrayList<String> fields = new ArrayList<String>();
		Pattern pattern = Pattern.compile("(\\w+),(\\w+),(\\w+),(\\w+),(\\w+),(\\w+),(\\w+),"
				+ "(\\w+),(\\w+),(\\w+),(\\w+),(\\w+),(\\w+),(\\w+)");
		Matcher matcher = pattern.matcher(lineWithFieldNames);
		if(matcher.matches()) {
		for(int i=1; i<=matcher.groupCount(); i++)
			fields.add(matcher.group(i));
		}
		return fields;
			
	}
}
