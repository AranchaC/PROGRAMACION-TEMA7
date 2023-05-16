package EjercicioCOLECCIONES1;

import java.util.*;


public class ClientesBanco {

	public static void main(String[] args) {
		Cliente cli1 = new Cliente("Arancha", "001", 20000);
		Cliente cli2 = new Cliente("Eva", "002", 20000);
		Cliente cli3 = new Cliente("Sara", "003", 200000);
		Cliente cli4 = new Cliente("Ana", "004", 20);
		Cliente cli5 = new Cliente("Arancha", "001", 20000);
		
		Set<Cliente> cliDelBanco = new HashSet<Cliente>();
		cliDelBanco.add(cli1);
		cliDelBanco.add(cli2);
		cliDelBanco.add(cli3);
		cliDelBanco.add(cli4);
		cliDelBanco.add(cli5);//no se añade porque está repetido.
		
		//eliminar elementeo con iterador
		Iterator<Cliente> it = cliDelBanco.iterator();
		while (it.hasNext()) {
			String nombreCli = it.next().getNombre();
			if (nombreCli.equals("Sara")) it.remove();
		}
		
		//mostrar datos con for each
		for (Cliente c : cliDelBanco) {
			System.out.println(c.getNombre()+" "+c.getnCuenta()+" "+c.getSaldo());
		}
		
		/*
		Iterator<Cliente> it = cliDelBanco.iterator();		
		while (it.hasNext()) {
			String nombreCli = it.next().toString();
			System.out.println(nombreCli);
		}
		*/
		
		
		
		/*
		if (cli1.equals(cli5)) {
			System.out.println("son iguales");
		}
		else {
			System.out.println("no son iguales");
			System.out.println(cli1.hashCode());
			System.out.println(cli2.hashCode());
		}
		*/
	}

}
