package com.kl.common.utils.hash;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 15:49
 * description:
 */
public class ConsistentHashUtilsTest {

    @Test
    public void testGetNode(){
        ConsistentHashUtils consistentHashUtils = new ConsistentHashUtils();
        List<String> nodes = new ArrayList<>();
        nodes.add("127.0.0.1");
        nodes.add("192.168.1.1");
        consistentHashUtils.init(nodes);
        String nodeSelect = consistentHashUtils.getNode("127.0.0.2");
        System.out.println(nodeSelect);
        nodeSelect = consistentHashUtils.getNode("127.0.0.1");
        System.out.println(nodeSelect);
    }

}