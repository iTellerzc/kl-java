package com.iteller.kl.spring.boot.dicts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/2 9:28
 * description:
 */
@Component
public class MavenDictProperties {

    @Value("${app.java.version}")
    private String javaVersion;

    public String getJavaVersion(){
        return javaVersion;
    }
}
