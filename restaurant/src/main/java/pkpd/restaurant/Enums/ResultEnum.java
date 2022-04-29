package pkpd.restaurant.Enums;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/2
 * Time:20:11
 */

public enum ResultEnum {
    UNKNOWN_ERROR(-1,"Unknown Error!"),
    SUCCESS(200,"Succeed!"),
    USER_NO_FOUND(101,"Account not found!"),
    PWD_ERROR(101,"Password Error!"),
    USER_IS_EXIST(101,"Account has been registered!"),
    PHONE_IS_EXIST(101,"Phone number already exists!"),
    ID_NUMBER_IS_EXIST(101,"ID number already exists!"),
    MC_NAME_IS_EXIST(101,"Member type already exists!"),
    DESK_CODE_IS_EXIST(101,"Desk ID already exists!"),
    DESK_CODE_NO_EXIST(101,"Desk ID not found!"),
    DESK_CODE_NO_IDLE(101,"Desk unavailable！"),
    CATEGORY_NAME_IS_EXIST(101,"Food type already exists!"),
    GOODS_NAME_IS_EXIST(101,"Food name already exists!"),
    FIELD_VALIDATION_FAILS(202,"Verification failed！"),
    INSERT_DB_FAIL(101,"Adding data failed!"),
    DEL_DB_FAIL(101,"Deleting data failed!"),
    UPDATE_DB_FAIL(101,"Modification failed!"),
    IMAGE_UPLOAD_FAIL(101,"Upload picture failed!"),
    UNAUTHENTICATED_ERROR(100,"No authority"),
    ADD_ORDER_FAIL(101,"Adding order failed!");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
