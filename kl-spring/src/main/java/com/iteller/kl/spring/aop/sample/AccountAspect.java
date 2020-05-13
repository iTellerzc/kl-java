package com.iteller.kl.spring.aop.sample;

import com.iteller.kl.spring.pojo.aop.Account;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 17:07
 * description:
 */
@Aspect
public class AccountAspect {

    @Before("com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation() && args(account, ..)")
    public void validateAccount(Account account){

    }

    @Pointcut("com.iteller.kl.spring.aop.pointcut.share.SystemArchitecture.dataAccessOperation() && args(account)")
    public void accountDataAccessOperation(Account account){

    }

    @Before("accountDataAccessOperation(account)")
    public void validatAccountV2(Account account){

    }

}
