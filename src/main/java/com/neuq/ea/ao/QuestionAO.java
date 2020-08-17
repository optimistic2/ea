package com.neuq.ea.ao;

import com.neuq.ea.ao.base.BaseAO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Data
public class QuestionAO extends BaseAO {
    private long id;
    private String name;
    private String content;
    private short type;
    private long examinationPaperId;
    private String desc;
    private short score;
}
