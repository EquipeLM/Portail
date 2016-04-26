package cgi.lemans.portail.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author gautierfa
 *
 */
public class ConvertUtils {
	
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static DateFormat dfr = new SimpleDateFormat("dd/MM/yyyy");
	
	
	/**
	 * Parse string en date.
	 * 
	 * @param dateAParser
	 * @param type US ou FR
	 * @return une date
	 */
	public static Date parseToDate(String dateAParser, String type){
		DateFormat dfTmp = "US".equals(type) ? df : dfr;
		Date retour = null;
		try {
			if(dateAParser != null){
				retour = df.parse(dateAParser);
                                
			}
		} catch (ParseException e) {
			//TODO : add log
		}
		return retour;
	}
	
	/**
	 * Formattage date en string
	 * 
	 * @param date
	 * @return
	 */
	public static String formatterDateUS(Date date){
		String retour = null;
		if(date != null){
			retour = df.format(date);
		}
		return retour;
	}
	
	/**
	 * Formattage date en string
	 * 
	 * @param date
	 * @return
	 */
	public static String formatterDate(Date date){
		String retour = null;
		if(date != null){
			retour = dfr.format(date);
		}
		return retour;
	}
	
	/**
	 * Convertir un String en Double avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur en Double ou null
	 */
	public static Double parseDouble(String valeur) {
		try {
			if (valeur != null) {
				return Double.parseDouble(valeur.replace(" ", "").replaceAll(",", "."));
			}
		} catch (NumberFormatException e) {
			//Log.error(NCC, e.getMessage());
		}
		return null;
	}
	
	/**
	 * Convertir un String en Long avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Long (null si problème de conversion)
	 */
	public static Long parseLong(String valeur) {
		try {
			if (valeur != null) {
				return Long.parseLong(valeur.trim());
			}
		} catch (NumberFormatException e) {
//			Log.error(NCC, e.getMessage());
		}
		return null;
	}

	/**
	 * Convertir un String en Integer avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Integer (null si problème de conversion)
	 */
	public static Integer parseInteger(String valeur) {
		try {
			if (valeur != null) {
				return Integer.parseInt(valeur);
			}
		} catch (NumberFormatException e) {
//			Log.error(NCC, e.getMessage());
		}
		return null;
	}
	

	/**
	 * Convertir un Long en Integer avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Integer (null si problème de conversion)
	 */
	public static Integer parseInteger(Long valeur) {
		try {
			if (valeur != null) {
				return Integer.parseInt(valeur.toString());
			}
		} catch (NumberFormatException e) {
//			Log.error(NCC, e.getMessage());
		}
		return null;
	}


	/**
	 * Convertir un String en Boolean avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Booléen (null si problème de conversion)
	 */
	public static Boolean parseBoolean(String valeur) {
		try {
			if (valeur != null) {
				return Boolean.valueOf(valeur);
			}
		} catch (NumberFormatException e) {
//			Log.error(NCC, e.getMessage());
		}
		return null;
	}

	/**
	 * Convertir un Long en Boolean avec gestion de l'exception (0 = false, 1 = true).
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Booléen (null si problème de conversion)
	 */
	public static Boolean parseBoolean(Long valeur) {
		if (valeur != null) {
			return valeur == 1L;
		}
		return false;
	}

	/**
	 * Convertir un String en Short avec gestion de l'exception.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return La valeur de type String converti en Booléen (null si problème de conversion)
	 */
	public static Short parseShort(String valeur) {
		try {
			if (valeur != null) {
				return Short.valueOf(valeur);
			}
		} catch (NumberFormatException e) {
//			Log.error(NCC, e.getMessage());
		}
		return null;
	}

	/**
	 * Convertion d'un objet en String.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return Le toString de la valeur
	 */
	public static String toString(Object valeur) {
		if (valeur != null) {
			return valeur.toString();
		}
		return null;
	}

	/**
	 * Convertion d'un objet en String.
	 * 
	 * @param valeur La valeur à  convertir
	 * @return Le toString de la valeur
	 */
	public static String toStringOuVide(Object valeur) {
		String retour = toString(valeur);
		return retour != null ? retour : StringUtils.EMPTY;
	}
}
