package utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {

	/**
	 * Fecha actual.
	 *
	 * @return the string
	 */
	static public String fechaActual() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return hourdateFormat.format(date);
	}
	
	static public String generarToken(){
		/*
		 * Generar cadena aleatoria de 32 caracteres alfabeticos
		 */
		char[] token = new char[32];
		for(int i=0;i<32;i++){
			token[i] = (char) ((Math.random()*25) + 65);
		}
		return String.valueOf(token);
	}
	
	static public String fechaActualMasCinco() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		return hourdateFormat.format(date.getTime()+5*60000);
	}

}
