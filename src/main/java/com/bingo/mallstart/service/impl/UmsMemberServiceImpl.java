package com.bingo.mallstart.service.impl;

import com.bingo.mallstart.common.CommonResult;
import com.bingo.mallstart.service.RedisService;
import com.bingo.mallstart.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (authCode.isEmpty()) {
            return CommonResult.failed("请输入验证码");
        }
        String value = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = value.equals(authCode);
        if (result) {
            return CommonResult.success(null, "验证码校检成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
