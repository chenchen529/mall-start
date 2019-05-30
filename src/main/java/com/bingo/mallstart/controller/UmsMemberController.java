package com.bingo.mallstart.controller;

import com.bingo.mallstart.common.CommonResult;
import com.bingo.mallstart.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取验证码")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证手机验证码")
    @ResponseBody
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }


}
