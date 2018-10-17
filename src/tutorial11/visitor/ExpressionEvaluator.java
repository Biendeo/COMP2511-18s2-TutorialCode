package tutorial11.visitor;

public class ExpressionEvaluator implements IExpressionVisitor<Double> {
	public ExpressionEvaluator() {}

	@Override
	public Double visit(Literal l) {
		return l.getValue();
	}

	@Override
	public Double visit(Addition a) {
		return a.getLeft().accept(this) + a.getRight().accept(this);
	}

	@Override
	public Double visit(Subtraction s) {
		return s.getLeft().accept(this) - s.getRight().accept(this);
	}

	public static void main(String[] args) {
		Addition x = new Addition(new Addition(new Literal(5.0), new Literal(2.0)), new Literal(3.0));
		ExpressionEvaluator ee = new ExpressionEvaluator();
		x.accept(ee);
		System.out.println(ee.visit(x));
	}
}
