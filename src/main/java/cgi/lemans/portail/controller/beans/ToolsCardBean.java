package cgi.lemans.portail.controller.beans;

import java.util.List;

/**
 * @author gautierfa
 *
 */
public class ToolsCardBean {
	private IconesCardBean iconDernierUtilise;
	private List<IconesCardBean> iconesPlusUtilise;
	
	public IconesCardBean getIconDernierUtilise() {
		return iconDernierUtilise;
	}
	public void setIconDernierUtilise(IconesCardBean iconDernierUtilise) {
		this.iconDernierUtilise = iconDernierUtilise;
	}
	public List<IconesCardBean> getIconesPlusUtilise() {
		return iconesPlusUtilise;
	}
	public void setIconesPlusUtilise(List<IconesCardBean> iconesPlusUtilise) {
		this.iconesPlusUtilise = iconesPlusUtilise;
	}
	
	
}
