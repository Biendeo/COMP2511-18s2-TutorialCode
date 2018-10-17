package tutorial11.visitor;

public class Subtraction implements IExpression {
	private IExpression left;
	private IExpression right;

	public Subtraction(IExpression left, IExpression right) {
		this.left = left;
		this.right = right;
	}

	public IExpression getLeft() {
		return left;
	}

	public IExpression getRight() {
		return right;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
