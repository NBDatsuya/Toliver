package tgkt.toliver.handler;

import tgkt.toliver.constant.ResponseConstant;
import tgkt.toliver.result.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/*@ControllerAdvice
@Slf4j*/
public class RequestExceptionHandler {/*
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpResponse<Object> notFoundHandler() {
        return HttpResponse.error(
                ResponseConstant.NOT_FOUND,
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HttpResponse<Object> notAllowedMethodHandler() {
        return HttpResponse.error(
                ResponseConstant.METHOD_NOT_ALLOWED,
                HttpStatus.METHOD_NOT_ALLOWED.value()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResponse<Object> badRequestHandler() {
        return HttpResponse.error(
                ResponseConstant.BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public HttpResponse<Object> forbiddenHandler() {
        return HttpResponse.error(
                ResponseConstant.FORBIDDEN,
                HttpStatus.FORBIDDEN.value()
        );
    }

     @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public HttpResponse<Object> unAuthorizedHandler() {
         log.error("UNAUTHORIZED");
        return HttpResponse.error(
                ResponseConstant.UNAUTHORIZED,
                HttpStatus.UNAUTHORIZED.value()
        );
    }*/
}
