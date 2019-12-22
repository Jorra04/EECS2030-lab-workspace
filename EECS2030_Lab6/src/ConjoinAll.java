
public class ConjoinAll extends ExpressionCollector{
	ConjoinAll(){
		super();
	}
	
	public void evaluate() {
		boolean result = true;
		if(this.myExp.size() == 0) {
			this.val = true;
		}
		else {
			for(Expression exp: this.myExp) {
				result = result && (boolean) exp.getValue();
			}
		}
		this.val = result;
	}
	@Override
	public Object getValue() {
		return this.val;
	}
}
