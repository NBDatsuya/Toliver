package tgkt.toliver.vo;

import tgkt.toliver.entity.AuthorizeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
public class AuthorizeVO extends AuthorizeInfo {
}
