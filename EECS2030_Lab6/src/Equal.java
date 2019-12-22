
public class Equal extends Expression{
	private boolean equals;
	
	Equal(int left, int right){
		super(left, right);
		this.left = left;
		this.right = right;
		this.equals = this.left == this.right;
		this.value = this.equals;
		
	}
	
	@Override
	public void evaluate() {
		this.equals = this.left == this.right;
	}
	
	public Object getValue() {
		return this.value;
	}
	
}
