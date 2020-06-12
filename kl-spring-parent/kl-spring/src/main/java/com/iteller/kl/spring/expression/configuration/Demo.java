package com.iteller.kl.spring.expression.configuration;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/12 17:35
 * description:
 */
public class Demo {

    public List<String> list;

    public static void main(String[] args){
        SpelParserConfiguration configuration = new SpelParserConfiguration(true, true);

        ExpressionParser parser = new SpelExpressionParser(configuration);
        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object data  = expression.getValue(demo);

        System.out.println(data.getClass());

        System.out.println(demo.list.size());

        for(String str : demo.list){
            System.out.println(str);
        }
    }
}
