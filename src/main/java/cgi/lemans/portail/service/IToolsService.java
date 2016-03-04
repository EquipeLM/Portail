package cgi.lemans.portail.service;

import cgi.lemans.portail.controller.beans.ToolsCardBean;

/**
 * @author gautierfa
 *
 */
public interface IToolsService {
	
	
	public ToolsCardBean afficherLesIconesCardByUser(String user);
	
	public void enregistrerClicIcone(String idIcone, String idUser);
}
