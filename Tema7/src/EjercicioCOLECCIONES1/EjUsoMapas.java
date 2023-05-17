package EjercicioCOLECCIONES1;

import java.util.*;

public class EjUsoMapas {

	public static void main(String[] args) {
		Map<String,Empleado> mapaEmple = new HashMap<String,Empleado>();
		mapaEmple.put("100", new Empleado("Arancha"));
		mapaEmple.put("150", new Empleado("Eva"));
		mapaEmple.put("050", new Empleado("Ana"));
		mapaEmple.put("103", new Empleado("Sara"));
		
		System.out.println(mapaEmple);
		
		mapaEmple.remove(103);
		System.out.println(mapaEmple);
		
		for (Map.Entry<String, Empleado> emp : mapaEmple.entrySet()) {
			String clave = emp.getKey();
			Empleado valor = emp.getValue();
			System.out.println("Clave: "+ clave + " Valor: "+valor);
		}
	}
}
	
class Empleado {
	private String nombre;
	private double salario;
	
	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
		salario = 2000;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + "]";
	}
	
	
	
	
}
