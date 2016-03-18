/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import cgi.lemans.portail.controller.beans.AbsenceCardBean;

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

    
}
