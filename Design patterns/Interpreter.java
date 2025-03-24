interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private int number;
    public NumberExpression(int number) { this.number = number; }
    public int interpret() { return number; }
}

class AddExpression implements Expression {
    private Expression left, right;
    public AddExpression(Expression left, Expression right) { 
        this.left = left;
        this.right = right;
    }
    public int interpret() { return left.interpret() + right.interpret(); }
}

public class Interpreter {
    public static void main(String[] args) {
        Expression five = new NumberExpression(5);
        Expression ten = new NumberExpression(10);
        Expression sum = new AddExpression(five, ten);
        System.out.println("Result: " + sum.interpret());
    }
}
