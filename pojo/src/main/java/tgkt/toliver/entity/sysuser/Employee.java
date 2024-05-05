package tgkt.toliver.entity.sysuser;

import tgkt.toliver.entity.SystemUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@Data
public class Employee extends SystemUser {
    Integer id;
    String name;
    String password;
}
