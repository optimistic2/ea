package com.neuq.ea.exception;

import com.neuq.ea.constant.BizCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * Created by biyanchen on 2018/12/3.
 */
public class NeuqException extends Exception {
    private int code;
    /**
     * 数据部分
     */
    private transient Object data = null;

    public NeuqException(int code, String message) {
        super(message);
        this.code = code;
    }

    public NeuqException(int code, Object data, String message) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public static NeuqException build(BizCode bizCode, String message) {
        Assert.notNull(bizCode, "异常业务编码未指定");
        if (StringUtils.isBlank(message)) {
            return new NeuqException(bizCode.getCode(), bizCode.getMessage());
        } else {
            return new NeuqException(bizCode.getCode(), message);
        }
    }

    public static NeuqException buildWithData(BizCode bizCode, Object data) {
        return buildWithData(bizCode, data, bizCode.getMessage());
    }

    public static NeuqException buildWithData(BizCode bizCode, Object data, String message) {
        if (StringUtils.isBlank(message)) {
            return new NeuqException(bizCode.getCode(), data, bizCode.getMessage());
        } else {
            return new NeuqException(bizCode.getCode(), data, message);
        }

    }

    public static NeuqException buildWithData(int code, String message, Object data) {
        return new NeuqException(code, data, message);
    }

    /**
     * 构建业务异常
     *
     * @param bizCode
     * @param args
     * @return
     */
    public static NeuqException build(BizCode bizCode, Object... args) {
        Assert.notNull(bizCode, "异常业务编码未指定");
        if (args == null) {
            return new NeuqException(bizCode.getCode(), bizCode.getMessage());
        } else {
            String msg = bizCode.getMessage();
            if (StringUtils.isBlank(msg)) {
                return new NeuqException(bizCode.getCode(), bizCode.getMessage());
            } else {
                msg = String.format(msg, args);
                return new NeuqException(bizCode.getCode(), msg);
            }
        }
    }

    public String toErrorString() {
        return "{code: "
                + this.code
                + ", message: "
                + this.getMessage()
                + "}";
    }
}
