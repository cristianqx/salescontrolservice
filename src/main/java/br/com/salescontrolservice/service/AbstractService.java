package br.com.salescontrolservice.service;

public abstract class AbstractService {

	public static String capitalize (String str) {
	    char[] letras = str.toCharArray();
	    for (int i = 0; i < letras.length; ++i) {
	        if (i == 0 || !Character.isLetterOrDigit (letras[i-1])) {
	            letras[i] = Character.toUpperCase (letras[i]);
	        }
	    }
	    return new String (letras);
	}
}
