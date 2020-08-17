package com.neuq.ea.constant;

/**
 * Created by biyanchen on 2018/12/11.
 */
public enum QuestionType {
    SELECTION(1),
    JUDGE(2),
    ANALYSIS(3);

    private int value;

    private QuestionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
