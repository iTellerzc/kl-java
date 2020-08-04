package com.iteller.kl.spring.boot.dicts;

import com.iteller.kl.spring.boot.base.BaseNgTest;
import com.kl.spring.boot.dicts.MavenDictProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/2 9:33
 * description:
 */

public class MavenDictPropertiesTest extends BaseNgTest{

    @Autowired
    private MavenDictProperties mavenDictProperties;

    @Test
    public void testGetJavaVersion() throws Exception {
        System.out.println(mavenDictProperties.getJavaVersion());
    }

}