package tutorial11.visitor;

public interface IExpressionVisitor<T> {
	T visit(Literal l);
	T visit(Addition a);
	T visit(Subtraction s);
}
