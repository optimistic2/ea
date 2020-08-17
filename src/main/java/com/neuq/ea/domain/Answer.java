package com.neuq.ea.domain;

import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Data
public class Answer extends BaseDomain {
    private String content;
    private long questionId;
    private short rightKey;
    private String desc;
}
