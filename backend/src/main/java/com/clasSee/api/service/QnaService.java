package com.clasSee.api.service;

import com.clasSee.api.request.QnaAnswerRegistPostReq;
import com.clasSee.api.request.QnaRegisterPostReq;
import com.clasSee.api.request.QnaUpdatePutReq;
import com.clasSee.db.entity.qna.Qna;

import java.util.List;

public interface QnaService {

    void createQna(QnaRegisterPostReq qnaRegisterPostReq);

    void createQnaAnswer(QnaAnswerRegistPostReq qnaAnswerRegistPostReq);

    void deleteQna(Long id);

    void deleteQnaAnswer(Long id);

    Qna readQna(Long id);

    Long qnaCount();

    List<Qna> readQnaList(int offset, int limit, String email);

    void updateQna(QnaUpdatePutReq qnaUpdatePutReq);
}
