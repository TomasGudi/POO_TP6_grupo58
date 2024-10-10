package ar.edu.unju.escmi.tp6.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp6.dominio.Credito;

public class CollectionPromocionAhoraTreinta {
	
	public static List<Credito> registro = new ArrayList<Credito>();

	 public static void agregarCredito(Credito credito) {
	        
	    	try {
	    		registro.add(credito);
			} catch (Exception e) {
				System.out.println("\nNO SE PUEDO REGISTRAR");
			}
	    	
	    }
	
	
}
