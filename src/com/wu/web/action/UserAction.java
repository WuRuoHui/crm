package com.wu.web.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.User;
import com.wu.service.UserService;
import com.wu.vo.PageBean;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.util.HashMap;
import java.util.Map;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    UserService userService;

    private Integer page;
    private Integer rows;

    User user = new User();

    public String delete() throws Exception {
        userService.deleteUserById(user);
        return null;
    }

    public String edit() throws Exception {
        User u = userService.getUserById(user);
        u.setUser_password("");
        String json = JSON.toJSONString(u);
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        PageBean pageBean = userService.getPageBean(dc, page, rows);
        Map map = new HashMap();
        map.put("total",pageBean.getTotalCount());
        map.put("rows",pageBean.getList());
        String json = JSON.toJSONString(map);
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String login() throws Exception {
        User u = userService.getUserByCode(user);
        ActionContext.getContext().getSession().put("user",u);
        return SUCCESS;
    }

    public String regist() throws Exception {
        try {
            userService.saveUser(user);
        }catch (Exception e){
            ActionContext.getContext().put("error",e.getMessage());
            return "toRegist";
        }
        return "toLogin";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public User getModel() {
        return user;
    }
}
