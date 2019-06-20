package queryexpressions;

import java.util.Set;

public class Not extends IndefiniteExpression{

	public Not(Query ...expressions) {
		super(expressions);
	}
	
	@Override
	public Set execute() {
		set = expressions[0].execute();
		
		for(int i=0; i<expressions.length; i++) {
		set.removeAll(expressions[i].execute());
		}
		return null;
	}

}
