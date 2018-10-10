package tutorial11.visitor;

public class Literal implements IExpression {
	private double value;

	public Literal(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
