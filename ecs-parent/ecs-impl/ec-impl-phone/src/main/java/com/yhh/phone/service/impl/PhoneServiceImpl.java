package com.yhh.phone.service.impl;

import com.yhh.phone.service.PhoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 手机服务接口的实现
 */
@Service // 实现类注解
@Transactional(rollbackFor = RuntimeException.class)  //事务管理,手动捕捉的异常,发生回滚
public class PhoneServiceImpl implements PhoneService {

    @Override
    public String sendRegCode(String mobile) {
        Random random = new Random();
        int code = random.nextInt(8999) + 1000;
        return String.valueOf(code);
    }
}
