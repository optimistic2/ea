package com.neuq.ea.domain.base;

import com.neuq.ea.common.base.BaseO;
import lombok.Data;

/**
 * Created by biyanchen on 2018/12/3.
 */
@Data
public class BaseDomain extends BaseO {
    private Long id;
    private Integer ctime;
    private Integer utime;

}
