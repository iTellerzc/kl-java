package com.iteller.kl.spring.mvc.ctr;

import com.iteller.kl.spring.mvc.common.Result;
import com.iteller.kl.spring.mvc.consts.ErrorEnums;
import com.iteller.kl.spring.mvc.exception.MvcBizException;
import com.iteller.kl.spring.mvc.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/16 9:59
 * description:
 */
@RestController
public class IndexCtr {


    @GetMapping("/index")
    public Result<String> index(){
        return ResultUtil.buildSuccess("hello, world!");
    }

    @GetMapping("/bizError")
    public void error(){
        throw new MvcBizException(new RuntimeException("npe!"), ErrorEnums.TEST_ERROR);
    }

}
