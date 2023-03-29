package com.clasSee.api.service;

import com.clasSee.api.request.NoticeRegisterPostReq;
import com.clasSee.api.request.NoticeUpdatePutReq;
import com.clasSee.db.entity.board.Notice;

import java.util.List;

public interface NoticeService {

    void createNotice(NoticeRegisterPostReq noticeRegisterPostReq);
    Notice readNotice(Long id);
    List<Notice> readNoticeList(int offset, int limit);
    Long noticeCount();
    void updateNotice(Long noticeId, NoticeUpdatePutReq noticeUpdatePutReq);
    void deleteNotice(String email, Long id);

}
