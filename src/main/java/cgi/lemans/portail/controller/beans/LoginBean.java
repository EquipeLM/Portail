/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller.beans;

import java.util.List;

/**
 *
 * @author souchul
 */
public class LoginBean {
    private List<LoginCardBean> listLogin;

    public List<LoginCardBean> getListLogin() {
        return listLogin;
    }

    public void setListLogin(List<LoginCardBean> listLogin) {
        this.listLogin = listLogin;
    }
    
    
    
}
