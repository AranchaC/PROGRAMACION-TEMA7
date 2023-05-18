package EjercicioCOLECCIONES1;

import java.util.*;


public class ClientesBanco {

	public static void main(String[] args) {
		Cliente cli1 = new Cliente("eva", "001", 700);
		Cliente cli2 = new Cliente("arancha", "002", 20000);
		Cliente cli3 = new Cliente("sara", "003", 1800);
		Cliente cli4 = new Cliente("ana", "004", 200);
		Cliente cli5 = new Cliente("eva", "001", 700);
		Cliente cli6 = new Cliente("natalia", "006", 1500);
		Cliente cli7 = new Cliente("azahara", "007", 300);
		Cliente cli8 = new Cliente("irene", "008", 55050);
		
		//Set<Cliente> cliDelBanco = new HashSet<Cliente>();
		Set<Cliente> cliDelBanco = new HashSet<Cliente>();

		cliDelBanco.add(cli2);
		cliDelBanco.add(cli6);
		cliDelBanco.add(cli7);
		cliDelBanco.add(cli8);
		cliDelBanco.add(cli3);
		cliDelBanco.add(cli1);
		cliDelBanco.add(cli4);
		cliDelBanco.add(cli5);//no se añade porque está repetido, mismo nºcuenta.
	
		//eliminar elemento con iterador
		Iterator<Cliente> it = cliDelBanco.iterator();
		while (it.hasNext()) {
			String nombreCli = it.next().getNombre();
			if (nombreCli.equals("sara")) it.remove();
		}
		System.out.println("<<<HashSet>>>");
		//mostrar datos con for each
		for (Cliente c : cliDelBanco) {
			System.out.println(c.getNombre()+" "+c.getnCuenta()+" "+c.getSaldo()+". hashcode: "+c.hashCode());
		}
		
		/*
		//mostrar datos con Iterador
		Iterator<Cliente> it1 = cliDelBanco.iterator();		
		while (it1.hasNext()) {
			String nombreCli = it1.next().toString();
			System.out.println(nombreCli);
		}
		*/
		System.out.println();

		List<Cliente> listCli = new ArrayList<Cliente>();
		listCli.addAll(cliDelBanco);
		System.out.println("<<<ArrayList:>>>");		
		//listCli.sort(new ComparaSaldo());
		Collections.sort(listCli, new ComparaSaldo());
		
		for (Cliente c : listCli) {
			System.out.println(c.getNombre()+" "+c.getnCuenta()+" "+c.getSaldo());
		}
		
		Set<Cliente> treeCli = new TreeSet<Cliente>(listCli);
		System.out.println();
		System.out.println("<<<TreeSet>>>");
		
		for (Cliente c : treeCli) {
			System.out.println(c.getNombre()+" "+c.getnCuenta()+" "+c.getSaldo());
		}
	}
}

class ComparaSaldo implements Comparator<Cliente> {

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return (int) (o1.getSaldo()-o2.getSaldo());
	}
	
}
