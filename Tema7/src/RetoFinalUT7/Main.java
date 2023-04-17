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
    	  	        
         //punto 3 - Consulta simple:
          Stream<String> streams3 = products.stream().map(Product::getName);
           	
        /*
         * punto 4 - Filtro: 
         * vemos que solo saleen 12 nombres, con el filtro.
         */
        Stream<String> streams4 = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.map(Product::getName);
        		
		        /*Esta línea da error, pero no es necesario para la salida por pantalla:
		         * streams4.forEach(product -> System.out.println(product));
		         */
		        
        /*
         * punto 5 - Ordenar: 
         * vemos que salen los 12 nombres, pero en otro orden, según UnitsInStock.
		 */
                
        Stream<String> streams5 = products.stream().filter(p -> p.getUnitsInStock()<10)
                .sorted(Comparator.comparingDouble(Product::getUnitsInStock))
                .map(Product::getName);
        
        /* para comprobarlo, ya que no mostramos ese dato, en vez de GetName en map, ponemos 
         * getUnitsInStock, y en Stream<Integer>, 
         * también ponemos Integer en el public List<Integer>:
         *
                 Stream<Integer> streams1 = products.stream().filter(p -> p.getUnitsInStock()<10)
                .sorted(Comparator.comparingDouble(Product::getUnitsInStock))
                .map(Product::getUnitsInStock);
		*/
        
        //punto 5.1 - Orden inverso:
        Stream<String> streams51 = products.stream().filter(p -> p.getUnitsInStock()<10)
               .sorted(Comparator.comparingDouble(Product::getUnitsInStock).reversed())
               .map(Product::getName);
                 
        //punto 5.2 - Orden con interfaz comparable:
        Stream<String> streams52 = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.sorted().map(Product::getName);
        
        //punto 5.3 - Orden inverso interfaz comparable
        Stream<String> streams53 = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.reverseOrder()).map(Product::getName);
        
        //punto 5.4 - orden 1ro por units descendente y luego por name ascendente.
        Stream<String> streams54 = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.comparing(Product::getUnitsInStock).reversed()
        		.thenComparing(Product::getName)).map(Product::getName);
        
        //punto 5.5 - orden 1ro por units ascendente y luego por name descendente.
        Stream<String> streams55 = products.stream().filter(p -> p.getUnitsInStock()<10)
        		.sorted(Comparator.comparing(Product::getUnitsInStock)
        		.thenComparing(Product::getName).reversed()).map(Product::getName);
        
        //punto 6 - Agrupación: por proveedor.
        Map<Integer, Long> collect = products.stream()
                .collect(Collectors.groupingBy(Product::getSupplier,Collectors.counting()));
        
        //collect.forEach((s, c) -> System.out.printf("proveedor: %s: productos: %s \n", s,c));
        
        //punto 6.1 - Agrupación con filtro.
        Map<Integer, List<Product>> collect61 = products.stream()
        		.filter(p -> p.getUnitsInStock()<20)
        		.collect(Collectors.groupingBy(Product::getUnitsInStock));

        //collect61.forEach((unidades, producto) -> System.out.printf("existencias: %s Productos: %s \n", unidades, producto));;
        
        //punto 7 - Suma
        Map<Integer, Double> collect7 = products.stream()
                .collect(Collectors.groupingBy(Product::getUnitsInStock,
                		 Collectors.summingDouble(Product::getUnitPrice)));
                
        //collect7.forEach((stock, suma) -> System.out.printf("en stock: %s: suma: %s \n", stock,suma));
        
        //punto 8 - Having.
        List<Map.Entry<Integer, Double>> entryList = products.stream()
                .collect(Collectors.groupingBy(Product::getUnitsInStock, 
                         Collectors.summingDouble(Product::getUnitPrice))).entrySet()
                .stream().filter(p -> p.getValue() > 100).collect(Collectors.toList());

        //entryList.forEach(list -> System.out.printf("en stock: %s, suma: %s\n",list.getKey(), list.getValue()));
        
        //promedio
        Double average = products.stream().collect(Collectors.averagingInt(Product::getUnitsInStock));
        //System.out.printf("Promedio de existencias en almacen: %s\n\n",average );
        
        //max y min
        Optional<Product> product1 = products.stream().max(Comparator.comparing(Product::getUnitPrice));
        Optional<Product> product2 = products.stream().min(Comparator.comparing(Product::getUnitPrice));
        System.out.println("Producto más caro: "+product1.get());
        System.out.println("Producto más barato: "+product2.get());
        System.out.println();
        
        //limit
        Stream<String> streamsLimit = products.stream().map(Product::getName).limit(10);
        
        return streamsLimit.collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sorted().forEach(System.out::println);
        
        
    }

}
