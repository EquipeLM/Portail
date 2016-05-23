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
    
    private String trigramme;
    private String libelleDM;
    private String libelleOT;
    private String type;
    private String consommé;
    private String raf;
    private String prevue;
    private String planifie;
    private int idOt;
    
   
    private List<ListPlanningBean> listPlanning;

    public String getTrigramme() {
        return trigramme;
    }

    public void setTrigramme(String trigramme) {
        this.trigramme = trigramme;
    }

    public String getLibelleDM() {
        return libelleDM;
    }

    public void setLibelleDM(String libelleDM) {
        this.libelleDM = libelleDM;
    }

    public String getLibelleOT() {
        return libelleOT;
    }

    public void setLibelleOT(String libelleOT) {
        this.libelleOT = libelleOT;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsommé() {
        return consommé;
    }

    public void setConsommé(String consommé) {
        this.consommé = consommé;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public String getPrevue() {
        return prevue;
    }

    public void setPrevue(String prevue) {
        this.prevue = prevue;
    }

    public String getPlanifie() {
        return planifie;
    }

    public void setPlanifie(String planifie) {
        this.planifie = planifie;
    }

    public int getIdOt() {
        return idOt;
    }

    public void setIdOt(int idOt) {
        this.idOt = idOt;
    }
    
    
    


    public List<ListPlanningBean> getListPlanning() {
        return listPlanning;
    }

    public void setListPlanning(List<ListPlanningBean> listPlanning) {
        this.listPlanning = listPlanning;
    }
    
    
    
}
