/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.controller.beans;

import java.util.Date;

/**
 *
 * @author souchul
 */
public class PlanningCardBean {
    
    private int idOtPlan;
    private String idRessource;
    private int noSem;
    private Double charge;
    private Date dateModif;
    private String userModif;
    private String equipePlan;

    public int getIdOtPlan() {
        return idOtPlan;
    }

    public void setIdOtPlan(int idOtPlan) {
        this.idOtPlan = idOtPlan;
    }

    public String getIdRessource() {
        return idRessource;
    }

    public void setIdRessource(String idRessource) {
        this.idRessource = idRessource;
    }

    public int getNoSem() {
        return noSem;
    }

    public void setNoSem(int noSem) {
        this.noSem = noSem;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public String getUserModif() {
        return userModif;
    }

    public void setUserModif(String userModif) {
        this.userModif = userModif;
    }

    public String getEquipePlan() {
        return equipePlan;
    }

    public void setEquipePlan(String equipePlan) {
        this.equipePlan = equipePlan;
    }
    
    
    
}
