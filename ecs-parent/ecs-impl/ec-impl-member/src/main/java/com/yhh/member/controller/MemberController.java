package com.yhh.member.controller;


import com.yhh.member.feign.PhoneServiceFeign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员服务处理类
 */

@RestController
@RequestMapping("member/api/v1")
public class MemberController {

    private PhoneServiceFeign phoneServiceFeign;
    /**
     * 发送手机注册码
     * @param mobile
     * @return
     */
    @PostMapping("sendRegCode")
    public String sendRegCode(String mobile){

        String code = phoneServiceFeign.sendRegCode(mobile);
        return code;
    }
}
