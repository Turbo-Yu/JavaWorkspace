package com.yhh.member.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 手机服务feign客户端
 */
@Component
@FeignClient(name = "phone-server") //和 ec-impl-phone 的application.yml 中的服务注册名称相同
public interface PhoneServiceFeign {

    @PostMapping("phone/api/v1/sendRegCode") // 指向ecs-api-phone Phoneervice
    String sendRegCode(@RequestParam("mobile") String mobile);
}
