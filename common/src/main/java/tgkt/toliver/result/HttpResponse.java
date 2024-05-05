package tgkt.toliver.result;
import org.springframework.http.HttpStatus;
import tgkt.toliver.constant.ResponseConstant;

public record HttpResponse<T>(int code, String msg, T data) {
    public static <T> HttpResponse<T> error(String msg) {
        return new HttpResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

    public static <T> HttpResponse<T> error(String msg, int code) {
        return new HttpResponse<>(code, msg, null);
    }

    public static <T> HttpResponse<T> success(String msg, T data) {
        return new HttpResponse<>(HttpStatus.OK.value(), msg, data);
    }

    public static <T> HttpResponse<T> success(T data) {
        return new HttpResponse<>(HttpStatus.OK.value(), ResponseConstant.SUCCESS, data);
    }

    public static <T> HttpResponse<T> success() {
        return new HttpResponse<>(HttpStatus.OK.value(), ResponseConstant.SUCCESS, null);
    }
}
