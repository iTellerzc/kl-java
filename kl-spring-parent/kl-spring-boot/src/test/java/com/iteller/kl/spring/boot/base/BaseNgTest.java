package com.iteller.kl.spring.boot.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/2 9:38
 * description:
 */
@SpringBootTest(value = "application.properties", classes = BootApplicationTest.class)
public class BaseNgTest extends AbstractTestNGSpringContextTests {
}
