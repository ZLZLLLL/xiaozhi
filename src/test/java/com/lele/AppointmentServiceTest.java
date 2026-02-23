package com.lele;

import com.lele.entity.AppointmentPo;
import com.lele.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService AppointmentService;

    @Test
    void testGetOne() {
        AppointmentPo appointment = new AppointmentPo();
        appointment.setUsername("张三");
        appointment.setIdCard("123456789012345678");
        appointment.setDepartment("内科");
        appointment.setDate("2025-04-14");
        appointment.setTime("上午");

        AppointmentPo appointmentDB = AppointmentService.getOne(appointment);
        System.out.println(appointmentDB);
    }

    @Test
    void testSave() {
        AppointmentPo appointment = new AppointmentPo();
        appointment.setUsername("张三");
        appointment.setIdCard("123456789012345678");
        appointment.setDepartment("内科");
        appointment.setDate("2025-04-14");
        appointment.setTime("上午");
        appointment.setDoctorName("张医生");

        AppointmentService.save(appointment);
    }

    @Test
    void testRemoveById() {
        AppointmentService.removeById(1L);
    }
}
