
public class Multiplication extends Expression {
	private int product;
	
	Multiplication(int left, int right){
		super(left, right);
		this.left = left;
		this.right = right;
		
		
		this.product = this.left * this.right;
		this.value = this.product;
	}
	
	@Override
	public void evaluate() {
		this.product = this.left * this.right;
	}
	
	public Object getValue() {
		return this.value;
	}
	
	
}
