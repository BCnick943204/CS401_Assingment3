package queryexpressions;

import java.util.Map;
import java.util.Set;

public abstract class IndefiniteExpression extends Query{
	Query[] expressions;
	public IndefiniteExpression(Query ...expressions) {
		this.expressions = expressions;
	}
	
}
