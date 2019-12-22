
public class Subtraction extends Expression {
	
	private int difference;
	
	Subtraction(int left, int right){
		super(left,right);
		this.left = left;
		this.right = right;
		
		
		this.difference = this.left - this.right;
		this.value = this.difference;
	}
	
	
	@Override
	void evaluate() {
		this.difference = this.left - this.right;
		this.value = this.difference;
	}
	
	public Object getValue() {
		return this.value;
	}

}
