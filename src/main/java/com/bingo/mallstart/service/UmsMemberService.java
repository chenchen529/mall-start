package com.bingo.mallstart.service;

import com.bingo.mallstart.common.CommonResult;

/**
 * 会员管理Service
 * Created by bingo on 2019/05/30
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     *
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 验证验证码
     *
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);


}
