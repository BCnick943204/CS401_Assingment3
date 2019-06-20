package queryexpressions;

import java.util.Set;

public class Or extends IndefiniteExpression{

	public Or(Query ...expressions) {
		super(expressions);
	}
	
	@Override
	public Set execute() {
		set = expressions[0].execute();
		
		for(int i=0; i<expressions.length; i++) {
		set.addAll(expressions[i].execute());
		}
		return null;
	}

}
