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
public class StatistiqueBean {
    private String trigramme;
    private String date;
    private List<ListStatistiqueBean> listStats;

    public String getTrigramme() {
        return trigramme;
    }

    public void setTrigramme(String trigramme) {
        this.trigramme = trigramme;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ListStatistiqueBean> getListStats() {
        return listStats;
    }

    public void setListStats(List<ListStatistiqueBean> listStats) {
        this.listStats = listStats;
    }
    
    
}
