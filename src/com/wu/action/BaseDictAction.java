package com.wu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wu.domain.BaseDict;
import com.wu.service.BaseDictService;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class BaseDictAction extends ActionSupport {
    //属性驱动获取dict_type_code
    private String dict_type_code;

    private BaseDictService baseDictService;

    @Override
    public String execute() throws Exception {
        List<BaseDict> baseDictList =  baseDictService.getListByTypeCode(dict_type_code);
        System.out.println(baseDictList.toString());
        String json = JSONArray.fromObject(baseDictList).toString();
        System.out.println(json);
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);
        return null;
    }

    public String getDict_type_code() {
        return dict_type_code;
    }

    public void setDict_type_code(String dict_type_code) {
        this.dict_type_code = dict_type_code;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }
}
