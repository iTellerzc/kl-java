package com.kl.spring.aop.proxy;

import com.kl.spring.service.aop.pojo.Pojo;
import com.kl.spring.service.aop.pojo.SimplePojo;
import com.kl.spring.service.aop.pojo.SimplePojoWithAop;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/14 10:45
 * description:
 */
public class ProxyMain {

    public static void main(String[] args){
        //no proxy
        SimplePojo pojo = new SimplePojo();
        pojo.foo();

        //with proxy
        ProxyFactory proxyFactory = new ProxyFactory(new SimplePojo());
        proxyFactory.addInterface(Pojo.class);

        Pojo pojoWithProxy = (Pojo) proxyFactory.getProxy();
        pojoWithProxy.foo();

        //with proxy
        ProxyFactory aopProxyFactory = new ProxyFactory(new SimplePojoWithAop());
        aopProxyFactory.addInterface(Pojo.class);
        aopProxyFactory.setExposeProxy(true);

        Pojo proxyFactoryProxy = (Pojo) aopProxyFactory.getProxy();
        proxyFactoryProxy.foo();
    }
}
