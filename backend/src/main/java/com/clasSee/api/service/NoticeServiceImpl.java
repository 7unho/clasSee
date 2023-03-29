package com.clasSee.api.service;

import com.clasSee.api.request.NoticeRegisterPostReq;
import com.clasSee.api.request.NoticeUpdatePutReq;
import com.clasSee.db.entity.board.Notice;
import com.clasSee.db.entity.user.User;
import com.clasSee.db.repository.NoticeRepositorySupport;
import com.clasSee.db.repository.UserRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("noticeService")
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeRepositorySupport noticeRepositorySupport;

    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Override
    public void createNotice(NoticeRegisterPostReq noticeRegisterPostReq) {

        Long user_id = userRepositorySupport
                .findId(noticeRegisterPostReq.getEmail());

        User user = userRepositorySupport
                .findOne(user_id);

            Notice notice = Notice.builder()
                    .title(noticeRegisterPostReq.getTitle())
                    .content(noticeRegisterPostReq.getContent())
                    .img(noticeRegisterPostReq.getImg())
                    .regtime(LocalDateTime.now().toString())
                    .user(user)
                    .build();

            noticeRepositorySupport.save(notice);
            return;
    }

    @Override
    @Transactional(readOnly = true)
    public Notice readNotice(Long id) {
        Notice notice = noticeRepositorySupport.findOne(id);
        return notice;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Notice> readNoticeList(int offset, int limit) {
        List<Notice> noticeList = noticeRepositorySupport.findList(offset, limit);
        return noticeList;
    }

    @Override
    @Transactional(readOnly = true)
    public Long noticeCount() {
        return noticeRepositorySupport.noticeCount();
    }

    @Override
    public void updateNotice(Long noticeId, NoticeUpdatePutReq noticeUpdatePutReq) {

        User user = userRepositorySupport
                .findUserByAuth(noticeUpdatePutReq.getEmail())
                        .get();

            noticeRepositorySupport.updateNotice(noticeId, noticeUpdatePutReq);

    }

    @Override
    public void deleteNotice(String email, Long id) {
        Notice notice = noticeRepositorySupport.findOne(id);

        User user = userRepositorySupport
                .findUserByAuth(email)
                .get();

            noticeRepositorySupport.delete(notice);
            return;

    }
}
