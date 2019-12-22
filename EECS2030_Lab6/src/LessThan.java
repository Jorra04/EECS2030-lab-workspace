
public class LessThan extends Expression {
	private boolean lessThan;
	LessThan(int left, int right){
		super(left, right);
		this.left = left;
		this.right = right;
		this.lessThan  = this.left < this.right;
		this.value = this.lessThan;
	}
	
	@Override
	public void evaluate() {
		this.lessThan = this.left < this.right;
	}
	
	public Object getValue() {
		return this.value;
	}

}
