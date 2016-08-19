/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgi.lemans.portail.domaine.gamaweb.impl;

import cgi.lemans.portail.domaine.entites.gamaweb.Login;
import cgi.lemans.portail.domaine.gamaweb.ILoginDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author souchul
 */
@Repository
public class LoginDao extends AbstractGenericDaoGamaweb<Login> implements ILoginDao{

    @Override
    public List<Login> findLoginPerson() {
        
        String hql =  "from Login a ";
        Query query = getSession().createQuery(hql);
        List<Login> results = (List<Login>) query.list();
        return results;
    
    }
    
    
}
