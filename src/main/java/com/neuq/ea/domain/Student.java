package com.neuq.ea.domain;

import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Data
public class Student extends BaseDomain {
    private String name;
    private String code;
    private long klassId;
    private short sex;
    private short age;

}
