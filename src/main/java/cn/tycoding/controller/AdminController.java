package cn.tycoding.controller;

import cn.tycoding.pojo.Admin;
import cn.tycoding.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理人员的Controller层
 *
 * @author TyCoding
 * @date 18-4-27上午7:05
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    //定义一个区分进入普通用户列表还是管理员用户列表的方法
    //0是管理员列表（默认）   1是普通用户列表
    private int checkStatus = 0;

    /**
     * 注入service
     */
    @Autowired
    private AdminService adminService;


    /**
     * 跳转到系统登录首页
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * 登录功能
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam String a_name, @RequestParam String a_password, Model model, HttpSession session) {
        Admin admin = adminService.login(a_name);
        if (admin != null) {
            if (admin.getA_password().equals(a_password)) {
                session.setAttribute("name", admin.getA_name());
                return "view/page";
            } else {
                model.addAttribute("message", "用户名或密码错误");
                return "view/login/info";
            }
        } else {
            model.addAttribute("message", "登录失败");
            return "view/login/info";
        }
    }

    /**
     * 注册功能
     */
    @RequestMapping(value = "/register")
    public String register(Admin admin, HttpSession session) {
        adminService.insert(admin);
        session.setAttribute("name", admin.getA_name());
        return "view/page";
    }

    /**
     * 退出登录的功能
     */
    @RequestMapping(value = "/outLogin")
    public String outLogin(HttpSession session) {
        session.invalidate();
        return "index";
    }

    /**
     * 跳转到page首页面
     */
    @RequestMapping(value = "/page")
    public String page() {
        return "view/page";
    }

    /**
     * 根据用户名查询
     */
    @ResponseBody
    @RequestMapping(value = "/findByName")
    public String findByName(@RequestBody Admin admin) {
        Admin info = adminService.findByName(admin.getA_name());
        System.out.println(JSONObject.toJSONString(info));
        return JSONObject.toJSONString(info);
    }

    /**
     * 分页查询功能
     */
    @RequestMapping(value = "findByPage")
    public String finByPage(@RequestParam(value = "pageCode", defaultValue = "1", required = false) int pageCode,
                            @RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize,
                            HttpServletRequest request,
                            Model model) {
        //封装分页的数据
        String a_name = request.getParameter("a_name");
        String a_telephone = request.getParameter("a_telephone");
        Map<String, Object> conMap = new HashMap<String, Object>();
        conMap.put("a_name", a_name);
        conMap.put("a_telephone", a_telephone);
        //将我进入哪个页面的区分状态码放入Map集合中
        conMap.put("checkStatus", checkStatus);
        if (checkStatus == 0) {
            String a_identity = request.getParameter("a_identity");
            conMap.put("a_identity", a_identity);
        }

        //回显数据
        model.addAttribute("page", adminService.findByPage(pageCode, pageSize, conMap));
        if (checkStatus == 0) {
            return "view/admin/adminList";
        } else {
            return "view/user/userList";
        }
    }

    /**
     * 根据id查询
     */
    @ResponseBody
    @RequestMapping(value = "/findById")
    public Admin findById(@RequestBody Admin admin) {
        Admin admin_info = adminService.findById(admin.getA_id());
        if (admin_info != null) {
            return admin_info;
        } else {
            return null;
        }
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam int a_id) {
        if (a_id != 0) {
            adminService.delete(a_id);
            return "redirect:findByPage.do";
        } else {
            return null;
        }
    }

    /**
     * 更新数据的方法
     */
    @RequestMapping(value = "/update")
    public String update(Admin admin, Model model) {
        System.out.println("我在controller层获取到的身份：" + admin.getA_identity());
        if (admin != null) {
            adminService.update(admin);
            return "redirect:findByPage.do";
        } else {
            model.addAttribute("message", "更新用户信息失败");
            return "view/info/message";
        }
    }


}
