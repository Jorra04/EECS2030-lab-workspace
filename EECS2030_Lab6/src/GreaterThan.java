
public class GreaterThan extends Expression{
	private boolean greaterThan;
	
	GreaterThan(int left, int right){
		super(left, right);
		this.left = left;
		this.right = right;
		this.greaterThan  = this.left > this.right;
		this.value = this.greaterThan;
	}
	
	@Override
	public void evaluate() {
		this.greaterThan = this.left > this.right;
	}
	
	public Object getValue() {
		return this.value;
	}
}
