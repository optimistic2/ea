package com.neuq.ea.ao;

import com.neuq.ea.ao.base.PageAO;
import com.neuq.ea.domain.Student;
import lombok.Data;

import java.util.List;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Data
public class StudentPageAO extends PageAO {
    private String name;
    private String code;
    private long klassId;
    private short sex;
    private short age;

}
