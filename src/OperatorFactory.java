public class OperatorFactory {
	public Operator getOperator(char op) {
		if (op == '\u0000') return null;
		if (op == '+') return new Adder();
		if (op == '-') return new Subtractor();
		if (op == '*') return new Multiplier();
		if (op == '/') return new Divider();
		return null;
	}
}
