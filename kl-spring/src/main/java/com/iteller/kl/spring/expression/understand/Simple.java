package com.iteller.kl.spring.expression.understand;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/12 17:28
 * description:
 */
public class Simple {

    public List<Boolean> list = new ArrayList<>();

    public static void main(String[] args){
        Simple simple = new Simple();
        simple.list.add(true);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("list[0]").setValue(context, simple,  "false");

        boolean result = simple.list.get(0);
        System.out.println(result);
    }
}
