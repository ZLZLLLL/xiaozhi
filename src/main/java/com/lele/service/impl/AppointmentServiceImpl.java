package com.lele.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lele.entity.AppointmentPo;
import com.lele.mapper.AppointmentMapper;
import com.lele.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, AppointmentPo> implements AppointmentService {
    /**
     * 查询订单是否存在
     */
    @Override
    public AppointmentPo getOne(AppointmentPo appointment) {
        LambdaQueryWrapper<AppointmentPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AppointmentPo::getUsername, appointment.getUsername());
        queryWrapper.eq(AppointmentPo::getIdCard, appointment.getIdCard());
        queryWrapper.eq(AppointmentPo::getDepartment, appointment.getDepartment());
        queryWrapper.eq(AppointmentPo::getDate, appointment.getDate());
        queryWrapper.eq(AppointmentPo::getTime, appointment.getTime());
        return baseMapper.selectOne(queryWrapper);
    }
}
