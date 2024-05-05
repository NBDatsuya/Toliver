package tgkt.toliver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import tgkt.toliver.entity.sysuser.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
