package tgkt.toliver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tgkt.toliver.entity.sysuser.Employee;

import java.util.Optional;

public interface EmployeeService extends IService<Employee>{
    Optional<Employee> findUserByName(String username);
}
