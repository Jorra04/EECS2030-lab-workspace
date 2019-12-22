
public class Addition extends Expression{
	
	private int sum;
	
	
	
	Addition(int left, int right){
		super(left,right);
		this.left = left;
		this.right = right;
		
		
		this.sum = this.left+this.right;
		this.value = this.sum;
	}
	
	@Override
	void evaluate() {
		this.sum = this.left+this.right;
		this.value = this.sum;
	}
	
	public Object getValue() {
		return this.value;
	}
}
