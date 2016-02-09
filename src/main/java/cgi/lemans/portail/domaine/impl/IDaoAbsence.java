/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.impl;

import cgi.lemans.portail.domaine.entites.Absence;

/**
 *
 * @author souchul
 */
public interface IDaoAbsence {
    
    public Absence findAbsenceByCongeAndRessourceAndPris(String idRessource);
    public Absence findAbsenceByCongeAndRessourceAndSolde(String idRessource);
    
    
}
