package com.bingo.mallstart.common.utils;

import com.bingo.mallstart.dto.UmsAdminService;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SpringSecurity extends WebSecurityConfigurerAdapter {
    private UmsAdminService adminService;

}
