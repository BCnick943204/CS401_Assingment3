package queryexpressions;

import java.util.Collection;
import java.util.Set;

public class Equal extends DefiniteExpression{

	public Equal(String field, int value) {super(field, value);}
	public Equal(String field, String strValue) {super(field, strValue);}
	
	@Override
	public Set execute() {
		
		if(indexMap.containsKey(field)) {
				rbt = indexMap.get(field);
		
		if(strValue != null)
			set.addAll((Collection<? extends Integer>) indexMap.get(strValue));
		else
			set.addAll((Collection<? extends Integer>) indexMap.get(value));
		}

			return set;
	}

	

	
	
}
