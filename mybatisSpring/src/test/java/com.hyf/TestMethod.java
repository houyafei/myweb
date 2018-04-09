package com.hyf;

import com.hyf.services.BalanceMacService;
import org.junit.Test;

/**
 * 测试
 *
 * @author yafei.hou  on 2018/3/21
 */
public class TestMethod {

    @Test
    public void testInsert(){
        BalanceMacService balanceMacService = new BalanceMacService();
        balanceMacService.insertBalanceMac();
    }

}
