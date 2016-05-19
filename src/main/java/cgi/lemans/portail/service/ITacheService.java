/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;


import cgi.lemans.portail.controller.beans.TacheBean;
import cgi.lemans.portail.controller.beans.TacheCardBean;

/**
 *
 * @author souchul
 */
public interface ITacheService {
    
    public TacheBean recupererDemandeModal(String tag);
    
    public TacheBean recupererInfosTypeOTModal();
    
    public TacheBean recupererListDemande(String tag);
    
    public TacheBean afficherTacheEquipe(String equipeChoisie);
    
    public TacheCardBean enregistrerConsoEnd(String idRessource, TacheCardBean bean);
    
}
