package pkpd.restaurant.exception;

import pkpd.restaurant.Enums.ResultEnum;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/2
 * Time:17:13
 */
/**
 * 
 * ：RuntimeExceptionException？
 * ：SpringRuntimeException，Exception
 */
public class SysUserImplException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SysUserImplException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
