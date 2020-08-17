package com.neuq.ea.ao;

import com.neuq.ea.ao.base.PageAO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Data
public class QuestionPageAO extends PageAO {
    private String keyWord;
    private short type;
    private long examinationPaperId;
    private short minScore;
    private short maxScore;
}
