package tutorial11.visitor;

public class ExpressionBuilder implements IExpressionVisitor<String> {
	@Override
	public String visit(Literal l) {
		return Double.toString(l.getValue());
	}

	@Override
	public String visit(Addition a) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(a.getLeft().accept(this));
		sb.append(" + ");
		sb.append(a.getRight().accept(this));
		sb.append(")");
		return sb.toString();
	}

	public static void main(String[] args) {
		Addition x = new Addition(new Addition(new Literal(5.0), new Literal(2.0)), new Literal(3.0));
		ExpressionBuilder eb = new ExpressionBuilder();
		x.accept(eb);
		System.out.println(eb.visit(x));
	}
}
