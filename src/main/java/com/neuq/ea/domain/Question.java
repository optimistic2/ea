package com.neuq.ea.domain;

import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Data
public class Question extends BaseDomain {
    private String name;
    private String content;
    private short type;
    private long examinationPaperId;
    private String desc;
    private short score;
}
