package com.wu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wu.domain.Customer;
import com.wu.service.CustomerService;
import com.wu.vo.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer;
    private Integer pageSize;
    private Integer currentPage;
    private CustomerService customerService;

    //上传的文件会自动封装到File对象
    //在后台提供一个与前台input type=file组件 name相同的属性
    private File photo;
    //在提交键名后加上固定后缀FileName,文件名称会自动封装到属性中
    private String photoFileName;
    //在提交键名后加上固定后缀ContentType,文件MIME类型会自动封装到属性中
    private String photoContentType;

    public String list() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        if (StringUtils.isNoneBlank(customer.getCust_name())) {
            dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        PageBean pageBean = customerService.getPageBean(dc, currentPage, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        String parameter = ServletActionContext.getRequest().getParameter("select");
        System.out.println("parameter"+parameter);
        return "list";
    }

    public String add() throws Exception {
        if (photo != null) {
            photo.renameTo(new File("G:/fileUpload/hh.png"));
            System.out.println("photoContentType：" + photoContentType);
            System.out.println("photoFileName：" + photoFileName);
        }
        customerService.saveOrUpdate(customer);
        return "toList";
    }

    public String edit() throws Exception {
        System.out.println(customer.getCust_id());
        Customer c = customerService.getById(customer.getCust_id());
        ServletActionContext.getContext().put("customer",c);
        return "toEdit";
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    @Override
    public Customer getModel() {
        customer = new Customer();
        return customer;
    }
}
