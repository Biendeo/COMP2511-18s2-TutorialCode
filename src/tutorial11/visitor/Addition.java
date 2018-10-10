package tutorial11.visitor;

public class Addition implements IExpression {
	private IExpression left;
	private IExpression right;

	public Addition(IExpression left, IExpression right) {
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
