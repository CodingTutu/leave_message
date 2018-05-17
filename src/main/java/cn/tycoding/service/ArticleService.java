package cn.tycoding.service;

import cn.tycoding.pojo.Article;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.pojo.Reply;
import cn.tycoding.pojo.Words;

import java.util.List;
import java.util.Map;

/**
 * @author TyCoding
 * @date 2018/5/3 上午8:36
 */
public interface ArticleService {

    void saveArticle(Article article);

    PageBean<Article> findByPage(int pageCode, int pageSize, Map<String, Object> conMap);

    void delete(int r_id);

    void update(Article article);

    Article findById(int r_id);

    void clean(int r_id);

    void restore(int r_id);

    void saveWords(Words words);

    void saveReply(Reply reply);

    List<Words> findByWords();

    List<Reply> findByReply();
}
