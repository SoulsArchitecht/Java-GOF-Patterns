package gof_patterns.Pattern11_Interpreter;


/** Интерпретатор (Interpreter) - Поведенческий паттерн. Если тот или иной конкретный вид проблемы возникает
достаточно часто, то, возможно, целесообразнеё изложить примеры проблемы в виде предложений на простом языке.
Тогда мы можем создать интерпретатор, который решает проблему, интерпретируя эти предложения.
*/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InterpreterExample {
    public static void main(String[] args) {
        String expression = "a + b";
        String expression2 = "a - c";
        Expr unparsed = parse(expression);
        Expr unparsed2 = parse(expression2);

        Map<String, Integer> context = new HashMap<>();
        context.put("a", 10);
        context.put("b", 25);
        int result = unparsed.interpret(context);
        System.out.println(result);

        Map<String, Integer> context2 = new HashMap<>();
        context2.put("a", 28);
        context2.put("c", 13);
        int result2 = unparsed2.interpret(context2);
        System.out.println(result2);
    }

    private static Expr parse(String exp) {
        ArrayDeque<Expr> stack = new ArrayDeque<>();
        Arrays.stream(exp.split(" "))
                .filter(token -> Character.isLetter(token.charAt(0)))
                .forEach(token -> {
                    stack.push(parseToken(token, stack));
                });
        Arrays.stream(exp.split(" "))
                .filter(token -> !Character.isLetter(token.charAt(0)))
                .forEach(token -> {
                    stack.push(parseToken(token, stack));
                });
        return stack.pop();
    }

    private static Expr parseToken(String token, ArrayDeque<Expr> stack) {
        Expr left, right;
        switch (token) {
            case "+":
                right = stack.pop();
                left = stack.pop();
                return Expr.plus(left, right);
            case "-":
                right = stack.pop();
                left = stack.pop();
                return Expr.minus(left, right);
            case "*":
                right = stack.pop();
                left = stack.pop();
                return Expr.multiply(left, right);
            case "/":
                right = stack.pop();
                left = stack.pop();
                return Expr.division(left, right);
            default:
                return Expr.variable(token);
        }
    }
}

interface Expr {
    int interpret(Map<String, Integer> context);

    static Expr plus(Expr left, Expr right) {
        return context -> left.interpret(context) + right.interpret(context);
    }

    static Expr minus(Expr left, Expr right) {
        return context -> left.interpret(context) - right.interpret(context);
    }

    static Expr multiply(Expr left, Expr right) {
        return context -> left.interpret(context) * right.interpret(context);
    }

    static Expr division(Expr left, Expr right) {
        return context -> left.interpret(context) / right.interpret(context);
    }

    static Expr variable(String name) {
        return context -> context.getOrDefault(name, 0);
    }


}
