package com.neuq.ea.vo;

import com.neuq.ea.vo.base.BaseVO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Data
public class StudentVO extends BaseVO {
    private String name;
    private String code;
    private long klassId;
    private short sex;
    private short age;
}
