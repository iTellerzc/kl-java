package com.iteller.kl.spring.expression;

import com.iteller.kl.spring.expression.vo.Inventor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.GregorianCalendar;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/12 17:15
 * description:
 */
public class InventorParseTest {

    public static void main(String[] args){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(1991,4,18);

        Inventor inventor = new Inventor("iTeller", calendar.getTime(), "china");

        ExpressionParser expressionParser = new SpelExpressionParser();

        Expression nameExpression = expressionParser.parseExpression("name");
        String name = (String) nameExpression.getValue(inventor);
        System.out.println(name);

        nameExpression = expressionParser.parseExpression("'iTeller' == name");
        boolean result = nameExpression.getValue(inventor, Boolean.class);
        System.out.println(result);
    }
}
