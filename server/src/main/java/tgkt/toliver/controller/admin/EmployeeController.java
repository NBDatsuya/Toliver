package tgkt.toliver.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import tgkt.toliver.constant.ResponseConstant;
import tgkt.toliver.dao.AuthorizeInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tgkt.toliver.result.HttpResponse;
import tgkt.toliver.request.LoginRequest;
import tgkt.toliver.service.EmployeeService;
import tgkt.toliver.util.JWTUtil;
import tgkt.toliver.vo.AuthorizeVO;

@Controller
@RestController
@Configuration
@Slf4j
@RequestMapping("/api/employee")
@Tag(name = "银行账号接口", description = "定义银行账号接口")
@ComponentScan("tgkt.toliver.properties")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @Autowired
    AuthorizeInfoRepository authorizeInfoRepository;

    @Resource
    JWTUtil jwtUtil;

    @PostMapping("/login")
    public HttpResponse<Object> login(@RequestBody LoginRequest request) {
        try {
            var user = service.findUserByName(request.getUsername());
            if (user.isEmpty()) {
                return HttpResponse.error(
                        ResponseConstant.UNAUTHORIZED,
                        HttpStatus.UNAUTHORIZED.value());
            }
            var userInfo = user.get();
            System.out.println(userInfo.getPassword());
            System.out.println(request);
            var result = new BCryptPasswordEncoder()
                    .matches(request.getPassword(), userInfo.getPassword());
            if (!result) {
                return HttpResponse.error(
                        ResponseConstant.UNAUTHORIZED,
                        HttpStatus.UNAUTHORIZED.value());
            }

            // 防止重复登陆


            var expireTime = jwtUtil.expireTime();
            var authorizeVO = AuthorizeVO.builder()
                    .token(jwtUtil.createJWT(userInfo, expireTime))
                    .expires(expireTime)
                    .build();
            BeanUtils.copyProperties(userInfo, authorizeVO);
            authorizeInfoRepository.save(authorizeVO);

            return HttpResponse.success(
                    ResponseConstant.LOGIN_SUCCESS,
                    authorizeVO
            );
        } catch (RuntimeException e) {
           /* if (e instanceof UsernameNotFoundException) {
                log.error("Unexpected exception");
                return HttpResponse.error(
                        ResponseConstant.UNAUTHORIZED,
                        HttpStatus.UNAUTHORIZED.value());
            } else {*/
            e.printStackTrace();
            return HttpResponse.error(
                    ResponseConstant.INNER_ERROR
                            .formatted(e.getMessage())
            );
            //}
        }
    }
}
