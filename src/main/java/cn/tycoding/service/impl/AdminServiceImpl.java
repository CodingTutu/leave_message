package cn.tycoding.service.impl;

import cn.tycoding.mapper.AdminMapper;
import cn.tycoding.pojo.Admin;
import cn.tycoding.pojo.PageBean;
import cn.tycoding.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TyCoding
 * @date 18-4-27上午7:09
 */
@Service
public class AdminServiceImpl implements AdminService {

    /**
     * 注入service层
     */
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录的功能
     *
     * @param a_name 输入的用户名
     * @return 返回查询到的该用户名对应的密码
     */
    public Admin login(String a_name) {
        return adminMapper.login(a_name);
    }

    /**
     * 注册功能
     *
     * @param admin 注册的信息
     * @return 返回影响的行数
     */
    public void insert(Admin admin) {
        adminMapper.insert(admin);
    }

    /**
     * 根据用户名查询
     *
     * @param a_name 用户名
     * @return 返回影响的行数
     */
    public Admin findByName(String a_name) {
        return adminMapper.findByName(a_name);
    }


    /**
     * 分页查询功能
     */
    public PageBean<Admin> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageBean<Admin> pageBean = new PageBean<Admin>();

        //获取区分页面的状态码
        Integer checkStatus = (Integer) conMap.get("checkStatus");

        // 封装当前页
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);

        // 封装总记录数
        if (checkStatus == 0) {
            int totalCount = adminMapper.selectCount();
            pageBean.setTotalCount(totalCount);
            // 封装总页数=总记录数/每页显示的记录数
            double tc = totalCount;
            Double num = Math.ceil(tc / pageSize);
            pageBean.setTotalPage(num.intValue());
        } else if (checkStatus == 1) {
            int totalCount = adminMapper.selectCount_u();
            pageBean.setTotalCount(totalCount);
            // 封装总页数=总记录数/每页显示的记录数
            double tc = totalCount;
            Double num = Math.ceil(tc / pageSize);
            pageBean.setTotalPage(num.intValue());
        }


        //设置limit分页查询的其实位置和终止位置
        map.put("start", (pageCode - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("checkStatus", checkStatus);

        //封装每页显示的记录数
        List<Admin> list = adminMapper.findByPage(map);
        for (Object obj : list) {
            System.out.println(obj);
        }
        pageBean.setBeanList(list);


        //封装条件查询的起始页和终止页
        conMap.put("start", (pageCode - 1) * pageSize);
        conMap.put("size", pageBean.getPageSize());
        conMap.put("checkStatus", checkStatus);

        //封装
        List<Admin> conList = adminMapper.conFindByPage(conMap);
        for (Object obj : conList) {
            System.out.println(obj);
        }
        pageBean.setBeanList(conList);


        return pageBean;
    }

    /**
     * 根据Id查询的功能
     *
     * @param a_id 要查询的id值
     * @return 返回当前id查询的数据
     */
    public Admin findById(int a_id) {
        return adminMapper.findById(a_id);
    }

    /**
     * 根据id删除信息
     *
     * @param a_id 要删除信息的id
     * @return 返回影响的行数
     */
    public void delete(int a_id) {
        adminMapper.delete(a_id);
    }

    /**
     * 更新数据的方法
     *
     * @param admin 需要更新的数据
     */
    public void update(Admin admin) {
        String a_identity = admin.getA_identity();
        if (a_identity != null) {
            if (a_identity.equals("管理员")) {
                admin.setA_identity_id(1);
            }
            if (a_identity.equals("录入员")) {
                admin.setA_identity_id(2);
            }
            if (a_identity.equals("审核员")) {
                admin.setA_identity_id(3);
            }
            if (a_identity.equals("普通用户")) {
                admin.setA_identity_id(4);
            }
            adminMapper.update(admin);
        }
    }
}
