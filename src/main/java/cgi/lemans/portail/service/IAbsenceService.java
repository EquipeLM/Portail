/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import java.util.List;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;
import cgi.lemans.portail.controller.beans.AbsenceEquipeBean;

/**
 *
 * @author souchul
 */
public interface IAbsenceService {
    
    /**
     * @return
     */
    public AbsenceCardBean recupererInfosAbsRessource(String idResource);
    
    /**
     * @param bean
     */
    public AbsenceCardBean enregistrerInfosParTypes(String idResource, AbsenceCardBean bean);
    
    /**
     * @param equipeChoisie
     * @return
     */
    public List<AbsenceEquipeBean> afficherInfosEquipe(String equipeChoisie, String moisAafficher);

    
}
