/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;


import org.springframework.stereotype.Repository;

import cgi.lemans.portail.domaine.entites.gamaweb.Absence;
import cgi.lemans.portail.domaine.gamaweb.IAbsenceDao;
import cgi.lemans.portail.domaine.newportal.impl.AbstractGenericDaoNewPortal;


/**
 *
 * @author souchul
 */
@Repository
public class AbsenceDao extends AbstractGenericDaoGamaweb<Absence> implements IAbsenceDao{
}
