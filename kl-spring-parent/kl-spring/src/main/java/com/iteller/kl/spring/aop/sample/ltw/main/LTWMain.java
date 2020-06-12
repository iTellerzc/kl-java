package com.iteller.kl.spring.aop.sample.ltw.main;

import com.iteller.kl.spring.aop.sample.ltw.service.DefaultPrintService;
import com.iteller.kl.spring.aop.sample.ltw.service.PrintService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 17:09
 * description:
 * java -javaagent:F:\kl\kl-spring\lib\spring-instrument.jar
 *
 * 控制台运行:
 *  java -javaagent:spring-instrument.jar
 *  -cp .;spring-core-5.2.6.RELEASE.jar;spring-aop-5.2.6.RELEASE.jar;spring-beans-5.2.6.RELEASE.jar;spring
    -aspects-5.2.6.RELEASE.jar;spring-context-5.2.6.RELEASE.jar;aspectjweaver-1.8.13
    .jar;spring-jcl-5.2.6.RELEASE.jar;spring-expression-5.2.6.RELEASE.jar;F:\\aspect
    -ltw-test\\kl-spring-1.0-SNAPSHOT.jar com.iteller.kl.spring.aop.sample.ltw.main.
    LTWMain
 */
public final class LTWMain {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop/aop-ltw-config-test.xml");

        PrintService printService = context.getBean("printService", PrintService.class);
        printService.printName("iTeller_zc, this is load time weaver test!");

        //no spring just same with upper
        PrintService newPrintService = new DefaultPrintService();
        newPrintService.printName("no load time weaver test!");
    }
}
