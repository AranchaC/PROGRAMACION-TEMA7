package RetoFinalUT7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Creado por  Ascari Q. Romo Pedraza - molder.itp@gmail.com on 17/04/17.
 * Este es solo el codigo base usado en el workshop "Conociendo al API Stream de Java 8"
 * que puedes encontrar en mi blog
 * https://windoctor7.github.io/API-Stream-Java8.html
 *
 * Ahi se encuentran toda una serie de ejercicios y explicaciones.
 * Este codigo es solo la base, no contiene los ejercicios descritos en el blog.
 */
public class Main {

    public List<String> sorted(){
        List<Product> products = Util.getProducts();
        
    	//punto 2:
    	/*
    	 * Stream<Product> productStream = products.stream();
    	 * productStream.forEach(product -> System.out.println(product));
    	 */
    	  	        
         //punto 3:
         /*
          * Stream<String> streams = products.stream().map(Product::getName);
          */
           	
        /*
         * punto 4: 
         * vemos que solo saleen 12 nombres, con el filtro.
         */
        /*Stream<String> streams = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.map(Product::getName);
		        /*Esta línea da error, pero no es necesario para la salida por pantalla:
		         * streams.forEach(product -> System.out.println(product));
		         */
		        
        /*
         * punto 5: 
         * vemos que salen los 12 nombres, pero en otro orden, según UnitsInStock.
		 */
                
        Stream<String> streams1 = products.stream().filter(p -> p.getUnitsInStock()<10)
                .sorted(Comparator.comparingDouble(Product::getUnitsInStock).reversed())
                .map(Product::getName);
        
        
        /* para comprobarlo, ya que no mostramos ese dato, en vez de GetName en map, ponemos 
         * getUnitsInStock, y en Stream<Integer>, 
         * también ponemos Integer en el public List<Integer>:
         *
                 Stream<Integer> streams1 = products.stream().filter(p -> p.getUnitsInStock()<10)
                .sorted(Comparator.comparingDouble(Product::getUnitsInStock))
                .map(Product::getUnitsInStock);
		*/
        
        //punto 5 con interfaz comparable:
        /*Stream<String> streams2 = products.stream()
        		.filter(p -> p.getUnitsInStock()<10)
        		.sorted()
        		.map(Product::getName);
        
        Stream<String> streams = products.stream()
        		.filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.reverseOrder())
        		.map(Product::getName);
        */
        //orden 1ro por units descendente y luego por name ascendente.
        Stream<String> streams2 = products.stream()
        		.filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.comparing(Product::getUnitsInStock).reversed()
        		.thenComparing(Product::getName))
        		.map(Product::getName);
        
        //orden 1ro por units ascendente y luego por name descendente.
        Stream<String> streams = products.stream()
        		.filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.comparing(Product::getUnitsInStock)
        		.thenComparing(Product::getName).reversed())
        		.map(Product::getName);
        
        return streams.collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sorted().forEach(System.out::println);
        
        
    }

}
