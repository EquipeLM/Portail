/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.service;

import cgi.lemans.portail.controller.beans.StatistiqueBean;
import java.util.List;

/**
 *
 * @author souchul
 */
public interface IStatistiqueService {
    public List<StatistiqueBean> afficherDMTraiteStats(String idRessource);
}
