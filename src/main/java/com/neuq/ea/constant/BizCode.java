package com.neuq.ea.constant;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by biyanchen on 2018/12/3.
 */
public enum BizCode {
    SUCCESS(0, -1, "成功"),
    ILLEGAL_ARGUMENT(10001, 3, "参数错误"),
    SERVER_INTERNAL_ERROR(10003, 3, "服务器开小差啦, 请重试"),
    FAIL(-99, 2, "失败");

    private int code;
    private int level;
    private String message;


    private static Map<Integer, BizCode> map = Maps.newHashMap();

    BizCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    BizCode(int code, int level, String message) {
        this.code = code;
        this.level = level;
        this.message = message;
    }

    static {
        for (BizCode bizCode : BizCode.values()) {
            map.put(bizCode.getCode(), bizCode);
        }
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "BizCode{" +
                "code=" + code +
                ", level=" + level +
                ", message='" + message + '\'' +
                '}';
    }

    public static BizCode findByCode(int code) {
        return map.get(code);
    }

}
