/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrms.struts;

import com.hrms.dto.Users;
import com.hrms.manager.UserManager;
import com.hrms.util.HibernateUtil;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.lang.annotation.Annotation;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.hibernate.Session;
import org.jboss.logging.Message;

/**
 *
 * @author Masrat
 */
public class UserAction extends ActionSupport  {

    private static Users user;
    private UserManager udo;
    private Long count, malecount, femcount, tqrts, tgasconn, usedg, unusedg, famly;
    private HttpServletResponse response;
    private HttpServletRequest request;
    private String url;
    private static int alter;
    private static int a,b,c;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    private Long data[], data2[];

    public Long getUsedg() {
        return usedg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getFamly() {
        return famly;
    }

    public void setFamly(Long famly) {
        this.famly = famly;
    }

    public void setUsedg(Long usedg) {
        this.usedg = usedg;
    }

    public Long getUnusedg() {
        return unusedg;
    }

    public void setUnusedg(Long unusedg) {
        this.unusedg = unusedg;
    }

    public Long getTqrts() {
        return tqrts;
    }

    public void setTqrts(Long tqrts) {
        this.tqrts = tqrts;
    }

    public Long getTgasconn() {
        return tgasconn;
    }

    public void setTgasconn(Long tgasconn) {
        this.tgasconn = tgasconn;
    }

    public Long getMalecount() {
        return malecount;
    }

    public void setMalecount(Long malecount) {
        this.malecount = malecount;
    }

    public Long getFemcount() {
        return femcount;
    }

    public void setFemcount(Long femcount) {
        this.femcount = femcount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public UserManager getUdo() {
        return udo;
    }

    public void setUdo(UserManager udo) {
        this.udo = udo;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserAction() {
        udo = new UserManager();
    }

    public String reset() {

        System.out.println("");
        return "success";
    }

    public String logOut() {

        setUser(null);
        alter++;

        return SUCCESS;
    }

    public String check() {

        String xz = "fail", mn = "success";

        if (alter == 0) {

            data = udo.getEmps();
            tqrts = udo.getQuarts();
            count = data[0];
            malecount = data[1];
            femcount = data[2];
            data2 = udo.getConn();
            tgasconn = data2[0];
            usedg = data2[1];
            unusedg = data2[2];
            famly = udo.getfamilies();
            if(getUser()!=null){
                description=udo.getStatus(getUser());
                System.out.println("----------------------desc-------------->"+description);
            }

            return mn;
        } else {
            alter = 0;

            return xz;
        }

    }
	
	

    @Override
    public void validate() {

        if (getUser() != null) {

            System.out.println("11111111111" + getUser() + "----------------->" + url);
            if (user.getUsername().length() == 0) {
               
                 
                     a++;
                    if (a % 2 != 0) {
                         addFieldError("user.username", "User Name can't be blank");
                         
                    } else {
                        addFieldError("user.username", "");
                       a = 0;
                    }
            }
            if (user.getPassword().length() == 0) {
                
                 b++;
                    if (b % 2 != 0) {
                         addFieldError("user.password", "Password can't be blank");
                         
                    } else {
                        addFieldError("user.password", "");
                       b = 0;
                    }
            } else if (udo.validateUser(getUser())) {
               
                 c++;
                    if (c % 2 != 0) {
                         addFieldError("user.username", "Invalid User Name and Password");
                         
                    } else {
                        addFieldError("user.username", "");
                       c = 0;
                    }
            }
        }

    }

}
