
public class DisjoinAll extends ExpressionCollector{
	DisjoinAll(){
		super();
	}
	
	
	public void evaluate() {
		boolean result = false;
		if(this.myExp.size() == 0) {
			this.val = false;
			
		}
		else {
			for(Expression exp: this.myExp) {
				result = result || (boolean)exp.getValue();
			}
		}
		this.val = result;
		
		
	}
	@Override
	
	public Object getValue() {
		return this.val;
	}
	
	
}
