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
public class PlanningBean {
    
    
    private String libelleDM;
    
    private String idDm;
    private List<ListOTPlanningBean> listOTPlanning;
    

   

    public String getLibelleDM() {
        return libelleDM;
    }

    public void setLibelleDM(String libelleDM) {
        this.libelleDM = libelleDM;
    }


    public String getIdDm() {
        return idDm;
    }

    public void setIdDm(String idDm) {
        this.idDm = idDm;
    }

    public List<ListOTPlanningBean> getListOTPlanning() {
        return listOTPlanning;
    }

    public void setListOTPlanning(List<ListOTPlanningBean> listOTPlanning) {
        this.listOTPlanning = listOTPlanning;
    }
    
    
    
    
    
}
