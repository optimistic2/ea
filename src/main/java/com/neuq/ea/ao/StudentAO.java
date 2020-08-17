package com.neuq.ea.ao;

import com.neuq.ea.ao.base.BaseAO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/4.
 */
@Data
public class StudentAO extends BaseAO {
    private String name;
    private String code;
    private long klassId;
    private short sex;
    private short age;
}
