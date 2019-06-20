package queryexpressions;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.princeton.cs.algs4.RedBlackBST;
import moviedb.RedBlackTree;

public abstract class Query<T extends Comparable<T>>{
	protected static Map<String, RedBlackTree<?, HashSet<Integer>>> indexMap;
	protected Set<Integer> set;
	protected RedBlackTree<? extends Comparable<?>, HashSet<Integer>> rbt;
	
	public Set<Integer> execute(Map indexMap) {
		Query.indexMap = indexMap;
		return execute();
	}
	
	abstract public Set<Integer> execute();
	
}
