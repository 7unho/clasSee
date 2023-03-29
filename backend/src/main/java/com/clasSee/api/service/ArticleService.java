package com.clasSee.api.service;

import com.clasSee.api.request.ArticleRegisterPostReq;
import com.clasSee.api.request.ArticleUpdatePutReq;
import com.clasSee.db.entity.board.Article;

import java.util.List;

public interface ArticleService {

    void createArticle(ArticleRegisterPostReq articleRegisterPostReq);
    Article readArticle(Long id);
    List<Article> readArticleList(int offset, int limit);
    Long articleCount();
    void updateArticle(Long articleId, ArticleUpdatePutReq articleUpdatePutReq);
    void deleteArticle(Long id);

}
