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
public class ListOTPlanningBean {
    
    private int idOt;
    private String idDM;
    private String libelleOT;
    private String typeOT;
    private String consomme;
    private String raf;
    private String prevue;
    private String chargePlanifie;
    private String trigrammeOT;
    
    private List<ListPlanningBean> listPlanning;

    public int getIdOt() {
        return idOt;
    }

    public void setIdOt(int idOt) {
        this.idOt = idOt;
    }

    public String getLibelleOT() {
        return libelleOT;
    }

    public void setLibelleOT(String libelleOT) {
        this.libelleOT = libelleOT;
    }

    public String getTypeOT() {
        return typeOT;
    }

    public void setTypeOT(String typeOT) {
        this.typeOT = typeOT;
    }

    public String getConsomme() {
        return consomme;
    }

    public void setConsomme(String consomme) {
        this.consomme = consomme;
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

    public String getChargePlanifie() {
        return chargePlanifie;
    }

    public void setChargePlanifie(String chargePlanifie) {
        this.chargePlanifie = chargePlanifie;
    }

    public String getTrigrammeOT() {
        return trigrammeOT;
    }

    public void setTrigrammeOT(String trigrammeOT) {
        this.trigrammeOT = trigrammeOT;
    }

    
    
    public List<ListPlanningBean> getListPlanning() {
        return listPlanning;
    }

    public void setListPlanning(List<ListPlanningBean> listPlanning) {
        this.listPlanning = listPlanning;
    }

    public String getIdDM() {
        return idDM;
    }

    public void setIdDM(String idDM) {
        this.idDM = idDM;
    }
    
    
    
}
