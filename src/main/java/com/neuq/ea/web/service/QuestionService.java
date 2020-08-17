package com.neuq.ea.web.service;

import com.neuq.ea.ao.QuestionAO;
import com.neuq.ea.ao.QuestionPageAO;
import com.neuq.ea.constant.BizCode;
import com.neuq.ea.domain.Question;
import com.neuq.ea.exception.NeuqException;
import com.neuq.ea.vo.QuestionVO;
import com.neuq.ea.vo.base.PageVO;
import com.neuq.ea.web.dao.QuestionDao;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by biyanchen on 2018/12/11.
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    public boolean edit(QuestionAO questionAO) throws NeuqException {
        long id = questionAO.getId();
        boolean flag;
        if (id < 1) {
            try {
                flag = questionDao.save(questionAO);
            } catch (Exception e) {
                log.error("#QuestionService.edit -->questionDao.save questionAO{}", questionAO, e);
                throw NeuqException.build(BizCode.FAIL, "插入试题失败");
            }
        } else {
            try {
                flag = questionDao.update(questionAO);
            } catch (Exception e) {
                log.error("#QuestionService.edit -->questionDao.update questionAO{}", questionAO, e);
                throw NeuqException.build(BizCode.FAIL, "更新试题失败");
            }
        }
        return flag;
    }


    public PageVO<QuestionVO> page(QuestionPageAO questionPageAO) throws NeuqException {
        int pageSize = questionPageAO.getSize();
        int pageNum = questionPageAO.getNumber();
        if (pageNum < 1 || pageSize < 1) {
            throw NeuqException.build(BizCode.FAIL, "分页条件非法");
        }
        List<Question> list;
        try {

            list = questionDao.pageList(questionPageAO, (pageNum - 1) * pageSize, pageSize);
        } catch (Exception e) {
            log.error("#QuestionService.page -->questionDao.pageList questionPageAO{}", questionPageAO, e);
            throw NeuqException.build(BizCode.FAIL, "分页查询试题失败");
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        int total;
        try {
            total = questionDao.pageCount(questionPageAO);
        } catch (Exception e) {
            log.error("#QuestionService.page -->questionDao.pageCount questionPageAO{}", questionPageAO, e);
            throw NeuqException.build(BizCode.FAIL, "分页查询试题失败");
        }
        if (total != 0) {
            List<QuestionVO> data = new ArrayList<>();
            for (Question question : list) {
                QuestionVO vo = new QuestionVO();
                BeanUtils.copyProperties(question, vo);
                data.add(vo);
            }
            return new PageVO<>(pageNum, pageSize, total, data);
        }
        return null;
    }
}
