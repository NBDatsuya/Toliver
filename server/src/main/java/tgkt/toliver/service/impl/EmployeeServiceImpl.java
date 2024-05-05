package tgkt.toliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tgkt.toliver.entity.sysuser.Employee;
import tgkt.toliver.dao.EmployeeMapper;
import tgkt.toliver.service.EmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImpl
        extends ServiceImpl<EmployeeMapper, Employee>
        implements EmployeeService {
    @Override
    public Optional<Employee> findUserByName(String username) {
        return query()
                .eq("name", username)
                .last(" limit 1")
                .oneOpt();
    }

}
