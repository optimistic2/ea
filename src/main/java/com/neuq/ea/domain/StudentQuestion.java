package com.neuq.ea.domain;

import com.neuq.ea.domain.base.BaseDomain;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Data
public class StudentQuestion extends BaseDomain {
    private long studentId;
    private long questionId;
    private short sequence;
}
