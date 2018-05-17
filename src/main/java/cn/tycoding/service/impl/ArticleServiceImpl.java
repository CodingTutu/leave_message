package cn.tycoding.service.impl;

import cn.tycoding.mapper.ArticleMapper;
import cn.tycoding.pojo.Article;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.pojo.Reply;
import cn.tycoding.pojo.Words;
import cn.tycoding.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TyCoding
 * @date 2018/5/3 上午8:36
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * 注入Mapper层
     */
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 添加文章信息
     * @param article 前台传来的文章数据
     */
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }

    /**
     * 分页查询的方法
     * @param pageCode 当前页
     * @param pageSize 每页显示的记录条数
     * @param conMap 分页查询的数据
     * @return 分页查询的结果
     */
    public PageBean<Article> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Article> pageBean = new PageBean<Article>();

        //获取Controller层封装的状态码
        Integer goId = (Integer)conMap.get("goId");

        //封装数据
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = 0;
        if(goId == 0){
            //访问的是文章列表页面
            totalCount = articleMapper.selectCount();
        }else if(goId == 1){
            //访问的是回收站页面
            totalCount = articleMapper.selectCount2();
        }
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());

        //设置limit起始位置和终止位置
        map.put("start",(pageCode - 1) * pageSize);
        map.put("size",pageBean.getPageSize());

        //封装每页显示的数据
        List<Article> list = articleMapper.findByPage(map);
        pageBean.setBeanList(list);

        for(Object obj : list){
            System.out.println(obj);
        }

        //条件查询的封装
        conMap.put("start",(pageCode - 1) * pageSize);
        conMap.put("size",pageBean.getPageSize());

        List<Article> conList = articleMapper.findConByPage(conMap);
        pageBean.setBeanList(conList);
        return pageBean;
    }

    /**
     * 删除功能
     * @param r_id 要删除字段的ID值
     */
    public void delete(int r_id) {
        articleMapper.delete(r_id);
    }

    /**
     * 更新用户信息的功能
     * @param article 需要更新的数据
     */
    public void update(Article article) {
        articleMapper.update(article);
    }

    /**
     * 根据ID查询信息
     * @param r_id 要查询的ID
     * @return 返回查询到的数据
     */
    public Article findById(int r_id) {
        return articleMapper.findById(r_id);
    }

    /**
     * 删除文章的功能（仅把文章放入到回收站中）
     * @param r_id 需要删除的文章的ID值
     */
    public void clean(int r_id) {
        articleMapper.clean(r_id);
    }

    /**
     * 恢复文章的功能（即将文章从回收站中移除）
     * @param r_id 要恢复的文章的ID值
     */
    public void restore(int r_id) {
        articleMapper.restore(r_id);
    }

    /**
     * 保存留言信息功能
     * @param words 保存的信息
     */
    public void saveWords(Words words) {
        articleMapper.saveWords(words);
    }

    /**
     * 保存回复信息内容
     * @param reply 回复信息
     */
    public void saveReply(Reply reply) {
        articleMapper.saveReply(reply);
    }

    /**
     * 查询所有留言信息
     * @return 返回查询查询到的留言信息并存放到List集合中
     */
    public List<Words> findByWords() {
        return articleMapper.findByWords();
    }

    /**
     * 查询所有的回复信息
     * @return 返回查询到的回复信息并存放到List集合中
     */
    public List<Reply> findByReply() {
        return articleMapper.findByReply();
    }

}
