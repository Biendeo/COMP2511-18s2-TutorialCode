package tutorial11.visitor;

public interface IExpression {
	<T> T accept(IExpressionVisitor<T> visitor);
}
