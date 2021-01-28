package com.desafio.bcp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	ConnectionFactory connectionFactory;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//	Flux<TypeChange> flux = repo.findAll();
		//	flux.doOnNext(System.out::println);
	}

	/*public static void main(String[] args) {


		SpringApplication.run(DesafioBcpApplication.class, args);

		*//*Dado un arreglo con los siguientes números [1, 2, 8, 23, 5, 15, 17, 15]
		 mostrar un arreglo solo con números primos y ordenado: [2, 5, 17, 23]*//*

		int lost [] = {1, 2, 8, 23, 5, 15, 17, 15};

		System.out.println(lost);
		int tmp = 0;

		List<String> numeroPrimos = new ArrayList<String>();

		for(int i: lost){
			int pri = i % 1;
			int seg = i % i;

			if((pri == 0) && (seg == 0)){
				numeroPrimos.add(String.valueOf(i));
				if(tmp < i){
					tmp = i;
				}
			}

		}

		System.out.println(numeroPrimos);
		System.out.println(tmp);


	}
*/

	/*@Override
	public void run(String... args) throws Exception {
		*//* ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
		databasePopulator.addScript(new ClassPathResource("data.sql"));
		DatabasePopulatorUtils.execute(databasePopulator, connectionFactory).block();*//*



		*//*Dado un arreglo con los siguientes números [1, 2, 8, 23, 5, 15, 17, 15]
		 mostrar un arreglo solo con números primos y ordenado: [2, 5, 17, 23]*//*

		int lost [] = {1, 2, 8, 23, 5, 15, 17, 15};

		System.out.println(lost);
		int tmp = 0;

		List<String> numeroPrimos = new ArrayList<String>();

		for(int i: lost){
			int pri = i % 1;
			int seg = i % i;

			if((pri == 0) && (seg == 0)){
				numeroPrimos.add(String.valueOf(pri));
				if(tmp < pri){
					tmp = pri;
				}
			}

		}

	}*/
}
