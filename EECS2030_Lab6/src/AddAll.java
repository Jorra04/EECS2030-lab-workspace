
public class AddAll extends ExpressionCollector{
	
	AddAll(){
		super();
	}
	
	@Override
	void evaluate() {
		Integer totalSum = 0;
		if(this.myExp.size() == 0) {
			this.val = 0;
		}
		else {
			for(Expression exp: this.myExp) {
				exp.evaluate();
				totalSum+= (Integer) exp.getValue();
			}
			this.val = totalSum;
		}
		
		
	}
	@Override
	public Object getValue() {
		return this.val;
	}
}
