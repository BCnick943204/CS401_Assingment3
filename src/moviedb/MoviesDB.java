package moviedb;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MoviesDB<T extends Comparable<T>> {
	private Map<String, RedBlackTree<T, HashSet<Integer>>> indexTreeMap
	= new HashMap<String, RedBlackTree<T, HashSet<Integer>>>();
	private Movie[] database;
	private ArrayList<String> fieldNames;
	
	//load the array with the data given in the csv file
	public MoviesDB(String fileName){
	MovieDBFileParser parser = new MovieDBFileParser();
	database = parser.fillDB(new File(fileName)); //fill the database
	fieldNames = parser.getFieldNames();
	}
	
	//create a new red black tree by field
	@SuppressWarnings("unchecked")
	public void addFieldIndex(String field) {
		if(!fieldNames.contains(field) || indexTreeMap.containsKey(field))
			return;
	RedBlackTree<T, HashSet<Integer>> indexTree = new RedBlackTree<T, HashSet<Integer>>();

	String id = fieldNames.get(0);
	HashSet<Integer> fieldSet;
	
	for(Movie movie : database) {
		if(!movie.contains(field))
			continue;
		
		//get the value of the field from the current movie (such as it's "title" value)
		T movieField = (T) movie.getField(field);
		
		//Create a new HashSet if the indexTree does not have the field indexed
		if(!indexTree.contains(movieField)) {
			fieldSet= new HashSet<Integer>();
		}else {
			fieldSet = indexTree.get(movieField);
		}
		fieldSet.add((Integer) movie.getField(id));
		indexTree.put(movieField, fieldSet);
	}
	
	//Add the new RBT to the Map
	indexTreeMap.put(field, indexTree);
		
	}
	
	//returns the hash map for index trees (red black trees)
	public Map<String, RedBlackTree<T, HashSet<Integer>>> getIndexTreeMap(){
	return indexTreeMap;
	}
	

}
