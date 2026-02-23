package com.lele.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lele.entity.AppointmentPo;

public interface AppointmentService extends IService<AppointmentPo> {
    AppointmentPo getOne(AppointmentPo appointment);
}
