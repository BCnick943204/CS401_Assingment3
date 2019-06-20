package queryexpressions;

import java.util.Set;

public class And extends IndefiniteExpression{

	public And(Query...expressions) {
		super(expressions);
	}
	
	@Override
	public Set<Integer> execute() {
		set = expressions[0].execute();
		
		for(int i=0; i<expressions.length; i++) {
		set.retainAll(expressions[i].execute());
		}
		return null;
	}

}
