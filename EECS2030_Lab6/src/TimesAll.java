
public class TimesAll extends ExpressionCollector{
	TimesAll(){
		super();
	}
	
	public void evaluate() {
		Integer totalProd = 1;
		if(this.myExp.size() == 0) {
			this.val = 1;
		}
		else {
			for(Expression exp: this.myExp) {
				exp.evaluate();
				totalProd *=  (Integer)exp.getValue();
			}
			this.val = totalProd;
		}
		
	}
	
	@Override
	public Object getValue() {
		return this.val;
	}
}
