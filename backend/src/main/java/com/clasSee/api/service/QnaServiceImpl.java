package com.clasSee.api.service;

import com.clasSee.api.request.QnaAnswerRegistPostReq;
import com.clasSee.api.request.QnaRegisterPostReq;
import com.clasSee.api.request.QnaUpdatePutReq;
import com.clasSee.db.entity.qna.Qna;
import com.clasSee.db.entity.qna.QnaAnswer;
import com.clasSee.db.entity.user.User;
import com.clasSee.db.repository.QnaRepositorySupport;
import com.clasSee.db.repository.UserRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("QnAService")
@Transactional
public class QnaServiceImpl implements QnaService {

    @Autowired
    QnaRepositorySupport qnaRepositorySupport;

    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Override
    public void createQna(QnaRegisterPostReq qnaRegisterPostReq) {
        Qna qna = Qna.builder()
                .title(qnaRegisterPostReq.getTitle())
                .content(qnaRegisterPostReq.getContent())
                .regTime(LocalDateTime.now().toString())
                .user(userRepositorySupport.findUserByAuth(qnaRegisterPostReq.getUser_email()).get())
                .build();

        qnaRepositorySupport.save(qna);
    }

    @Override
    public void createQnaAnswer(QnaAnswerRegistPostReq qnaAnswerRegistPostReq) {
        Qna qna = qnaRepositorySupport.findOne(qnaAnswerRegistPostReq.getQna_id());

        QnaAnswer qnaAnswer = QnaAnswer.builder()
                .content(qnaAnswerRegistPostReq.getContent())
                .qna(qna)
                .build();

        qnaRepositorySupport.saveAnswer(qnaAnswer);
        return;
    }

    @Override
    public void deleteQna(Long id) {

        Qna qna = qnaRepositorySupport.findOne(id);

        qnaRepositorySupport.delete(qna);

    }

    @Override
    public void deleteQnaAnswer(Long id) {

        QnaAnswer qnaAnswer = qnaRepositorySupport.findOneAnswer(id);

        qnaRepositorySupport.deleteAnswer(qnaAnswer);


    }

    @Override
    @Transactional(readOnly = true)
    public Qna readQna(Long id) {
        return qnaRepositorySupport.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Qna> readQnaList(int offset, int limit, String email) {
        User user = userRepositorySupport
                .findUserByAuth(email)
                .get();

        Long user_id = user.getId();

        return qnaRepositorySupport.findList(offset, limit, user_id);
    }

    @Override
    @Transactional(readOnly = true)
    public Long qnaCount(){
        return qnaRepositorySupport
                .QnaCount();
    }

    @Override
    public void updateQna(QnaUpdatePutReq qnaUpdatePutReq) {

        User user = userRepositorySupport
                .findUserByAuth(qnaUpdatePutReq.getUser_email())
                .get();

        Qna qna = qnaRepositorySupport
                .findOne(qnaUpdatePutReq.getId());

            qnaRepositorySupport.updateQna(qnaUpdatePutReq);

    }

}
