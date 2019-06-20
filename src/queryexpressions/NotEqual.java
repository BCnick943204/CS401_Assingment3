package queryexpressions;

import java.util.Collection;
import java.util.Set;

public class NotEqual extends DefiniteExpression{
	
	public NotEqual(String field, int value) {super(field, value);}
	public NotEqual(String field, String strValue) {super(field, strValue);}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Set execute() {
		if(indexMap.containsKey(field)) {
		rbt = indexMap.get(field);
		
		Comparable queryKey;
		if(strValue != null)
			queryKey = strValue;
		else
			queryKey = value;
		
		
		
			for(var v:rbt.values()) {
				
				set.addAll(v);
			}

			@SuppressWarnings("unchecked")
			var keys =  rbt.keys();
			for(var key : keys) {
				if(!key.equals(queryKey))
					set.addAll((Collection<Integer>) rbt.get(key));
			}

	}
		return set;

}
}
