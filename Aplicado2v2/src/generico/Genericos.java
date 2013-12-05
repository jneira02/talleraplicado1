package generico;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class Genericos {
	
static public	String fechaActual() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return hourdateFormat.format(date);
}

static public String fechaActualMasCinco() {
    Date date = new Date();
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    return hourdateFormat.format(date.getTime()+5*60000);
}


static public String tokenActual(String nombre){
		Date segundos=new Date();
		String texto=nombre+segundos.getSeconds();
		return DigestUtils.md5Hex(texto);
    }

}
