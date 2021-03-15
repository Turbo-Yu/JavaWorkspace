package com.yhh.phone.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手机短信服务接口
 */

@RestController
@RequestMapping("phone/api/v1")
public interface PhoneService {

    @PostMapping("sendRegCode")
    String sendRegCode(String mobile);
}
