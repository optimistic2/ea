package com.neuq.ea.response;

import com.neuq.ea.common.base.BaseO;
import com.neuq.ea.constant.BizCode;
import com.neuq.ea.exception.NeuqException;

/**
 * Created by biyanchen on 2018/12/3.
 */
public class SimpleResponse<T> extends BaseO {
    private int code;

    private String message;

    private T data;

    private SimpleResponse(BizCode bizCode) {
        this.code = bizCode.getCode();
        this.message = bizCode.getMessage();
    }

    private SimpleResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static SimpleResponse success() {
        return new SimpleResponse(BizCode.SUCCESS);
    }

    public static SimpleResponse successWithMessage(String msg) {
        return new SimpleResponse(BizCode.SUCCESS.getCode(), msg);
    }

    public static SimpleResponse fail(NeuqException e) {
        return new SimpleResponse(e.getCode(), e.getMessage()).setData(e.getData());
    }

    public static SimpleResponse fail(NeuqException e, Object data) {
        return new SimpleResponse(e.getCode(), e.getMessage()).setData(data);
    }

    public static SimpleResponse failIfParamRefuse(NeuqException e) {
        if (e.getCode() == BizCode.ILLEGAL_ARGUMENT.getCode()) {
            return fail(BizCode.ILLEGAL_ARGUMENT);
        }
        return fail(e);
    }

    /**
     * 带有程序内部的提示，业务抛出NeuqException，具体提示， catch时使用
     *
     * @param e
     * @return
     */
    public static SimpleResponse failBiz(NeuqException e) {
        BizCode bizCode = BizCode.findByCode(e.getCode());
        if (bizCode == null) {
            return fail(BizCode.SERVER_INTERNAL_ERROR);
        }
        return fail(bizCode);
    }

    public static SimpleResponse fail(BizCode bizCode) {
        return new SimpleResponse(bizCode.getCode(), bizCode.getMessage());
    }

    public static SimpleResponse fail(BizCode bizCode, String msg) {
        return new SimpleResponse(bizCode.getCode(), msg);
    }

    public static SimpleResponse success(Object data) {
        return new SimpleResponse(BizCode.SUCCESS).setData(data);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public SimpleResponse setData(T data) {
        this.data = data;
        return this;
    }
}
