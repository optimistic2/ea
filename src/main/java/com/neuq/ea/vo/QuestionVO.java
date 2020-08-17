package com.neuq.ea.vo;

import com.neuq.ea.vo.base.BaseVO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/12.
 */
@Data
public class QuestionVO extends BaseVO {
    private long id;
    private String name;
    private String content;
    private short type;
    private long examinationPaperId;
    private String desc;
    private short score;
}
