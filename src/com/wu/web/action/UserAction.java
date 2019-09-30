package com.wu.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.User;
import com.wu.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    UserService userService;
    User user = new User();

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

    @Override
    public User getModel() {
        return user;
    }
}
