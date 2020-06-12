package com.iteller.kl.spring.expression;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/12 14:51
 * description:
 */
public class SimpleTest {

    public static void main(String[] args){
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'hello world!'.bytes.length");

        //hello world!.getBytes().length;

        System.out.println(expression.getValue());
    }
}
