package pkpd.restaurant.Enums;


public enum ResultEnum {
    UNKNOWN_ERROR(-1,"Unknown Error!"),
    SUCCESS(200,"Successful!"),
    USER_NO_FOUND(101,"Cannot find the account!"),
    PWD_ERROR(101,"Password Error!"),
    USER_IS_EXIST(101,"The account has existed!"),
    PHONE_IS_EXIST(101,"The phone number has existed!"),
    ID_NUMBER_IS_EXIST(101,"The ID has existed!"),
    MC_NAME_IS_EXIST(101,"The member type has existed!"),
    DESK_CODE_IS_EXIST(101,"The desk ID has existed!"),
    DESK_CODE_NO_EXIST(101,"Cannot find the desk ID!"),
    DESK_CODE_NO_IDLE(101,"The desk is not idle!"),
    CATEGORY_NAME_IS_EXIST(101,"The goods type has existed!"),
    GOODS_NAME_IS_EXIST(101,"The goods name has existed!"),
    FIELD_VALIDATION_FAILS(202,"Field validation fails!"),
    INSERT_DB_FAIL(101,"Insert database failed!"),
    DEL_DB_FAIL(101,"Delete database failed!"),
    UPDATE_DB_FAIL(101,"Update database failed!"),
    IMAGE_UPLOAD_FAIL(101,"Image upload failed!"),
    UNAUTHENTICATED_ERROR(100,"Unauthorized!"),
    ADD_ORDER_FAIL(101,"    Add order failed!");
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
