package queryexpressions;

public abstract class DefiniteExpression extends Query{
	protected String field, strValue = null;
	protected int value;
	
	public DefiniteExpression(String field, int value){
		this.field = field;
		this.value = value;
	}
	public DefiniteExpression(String field, String strValue) {
		this.field = field;
		this.strValue = strValue;
	}
}
