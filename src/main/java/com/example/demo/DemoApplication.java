package com.example.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Address;
import com.example.demo.domain.City;
import com.example.demo.domain.Imate;
import com.example.demo.domain.ImateVisitors;
import com.example.demo.domain.PrisionalInstitution;
import com.example.demo.domain.State;
import com.example.demo.enums.SecurityLevel;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.ImateRepository;
import com.example.demo.repository.ImateVisitorRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.repository.PrisonInstitutionRepository;
import com.example.demo.repository.StateRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	 ImateRepository imateRepository;
	
	@Autowired
	ImateVisitorRepository imateVisitorRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Autowired
	PrisonInstitutionRepository prisonInstitutionRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
 
	@Override
	public void run(String... args) throws Exception {
		
		if (stateRepository.count() == 0) {
		// Criando estados
		State nm = new State(null, "New Mexico");
		State tx = new State(null, "Texas");

		// Criando cidades
		City albuquerque = new City(null, "Albuquerque", nm);
		City elPaso = new City(null, "El Paso", tx);

		

        City city1 = new City(null, "San Francisco", nm);
        City city2 = new City(null, "San Quentin",tx);
        City city3 = new City(null, "Folsom", nm);
        
		cityRepository.saveAll(Arrays.asList());
		
		// Adicionando cidades aos estados
		nm.getCities().addAll(Arrays.asList(albuquerque, city1, city2, city3));
		tx.getCities().add(elPaso);

		
		
		// Salvando estados e cidades
		stateRepository.saveAll(Arrays.asList(nm, tx));
		cityRepository.saveAll(Arrays.asList(albuquerque, elPaso, city1, city2, city3));

		// Criando personagens (Imates)
		Imate walterWhite = new Imate(null, "Male", LocalDate.of(1958, 9, 7), "Walter White", 123456789, "Former high school chemistry teacher turned meth manufacturer.");
		Imate jessePinkman = new Imate(null, "Male", LocalDate.of(1984, 9, 24), "Jesse Pinkman", 987654321, "Former student of Walter White and his business partner in meth production.");
		Imate lydiaRodarte = new Imate(null, "Female", LocalDate.of(1970, 3, 4), "Lydia Rodarte-Quayle", 222333444, "Executiva da empresa que ajudou Gus Fring.");
		Imate toddAlquist = new Imate(null, "Male", LocalDate.of(1991, 5, 5), "Todd Alquist", 789456123, "Funcionário de Vamonos Pest e associado ao tráfico de drogas.");
		Imate gusFring = new Imate(null, "Male", LocalDate.of(1958, 4, 6), "Gustavo 'Gus' Fring", 445566778, "Barão das drogas e rival de Walter White.");
		Imate mikeEhrmantraut = new Imate(null, "Male", LocalDate.of(1940, 6, 5), "Mike Ehrmantraut", 556677889, "Ex-policial e segurança de Gus Fring.");
		Imate hectorSalamanca = new Imate(null, "Male", LocalDate.of(1928, 1, 1), "Hector Salamanca", 999888777, "Membro da família Salamanca.");

		// Criando personagens visitantes (ImateVisitors)
		ImateVisitors hollyWhite = new ImateVisitors(null, "Female", LocalDate.of(2006, 2, 11), "Holly White", 123321123);
		ImateVisitors marieSchrader = new ImateVisitors(null, "Female", LocalDate.of(1974, 2, 11), "Marie Schrader", 987123456);
		ImateVisitors stevenGomez = new ImateVisitors(null, "Male", LocalDate.of(1980, 11, 3), "Steven Gomez", 654321987);
		ImateVisitors janeMargolis = new ImateVisitors(null, "Female", LocalDate.of(1982, 5, 15), "Jane Margolis", 321654987);
		ImateVisitors badger = new ImateVisitors(null, "Male", LocalDate.of(1985, 2, 20), "Badger", 654789123);
		ImateVisitors skinnyPete = new ImateVisitors(null, "Male", LocalDate.of(1983, 8, 17), "Skinny Pete", 789123654);
		ImateVisitors skylerWhite = new ImateVisitors(null, "Female", LocalDate.of(1970, 8, 11), "Skyler White", 223344556);
		ImateVisitors saulGoodman = new ImateVisitors(null, "Male", LocalDate.of(1961, 11, 12), "Saul Goodman", 111223344);

		//Imate hankSchrader = new Imate(null, "Male", LocalDate.of(1966, 3, 12), "Hank Schrader", 334455667, "Agente da DEA e cunhado de Walter White.");

		// Endereços dos personagens
		Address walterAddress = new Address(null, "308 Negra Arroyo Lane", "1", albuquerque, walterWhite, null);
		Address jesseAddress = new Address(null, "9809 Margo Street", "2", albuquerque, jessePinkman, null);
	//	Address hankAddress = new Address(null, "5000 Voss St", "3", albuquerque, hankSchrader, null);
		Address gusAddress = new Address(null, "1044 Mountain Rd", "4", albuquerque, gusFring, null);
		Address mikeAddress = new Address(null, "1200 W San Mateo Rd", "5", albuquerque, mikeEhrmantraut, null);
		Address saulAddress = new Address(null, "9800 Montgomery Blvd NE", "6", albuquerque, null, saulGoodman);
		Address skylerAddress = new Address(null, "308 Negra Arroyo Lane", "1", albuquerque, null, skylerWhite);
		Address janeAddress = new Address(null, "1234 Elm St", "2", albuquerque, jessePinkman, null);
		Address marieAddress = new Address(null, "5003 W 6th St", "3", albuquerque, walterWhite, null);

		// Associando endereços aos personagens
		walterWhite.setAddresses(Arrays.asList(walterAddress));
		walterWhite.setVisitors(Arrays.asList(saulGoodman,skylerWhite )); 
		saulGoodman.setImates(Arrays.asList(walterWhite));
		skylerWhite.setImates(Arrays.asList(walterWhite));

		jessePinkman.setAddresses(Arrays.asList(jesseAddress));
		//hankSchrader.setAddresses(Arrays.asList(hankAddress));
		gusFring.setAddresses(Arrays.asList(gusAddress));
		mikeEhrmantraut.setAddresses(Arrays.asList(mikeAddress));
		saulGoodman.setAddresses(Arrays.asList(saulAddress));
		skylerWhite.setAddresses(Arrays.asList(skylerAddress));
		janeMargolis.setAddresses(Arrays.asList(janeAddress));
		marieSchrader.setAddresses(Arrays.asList(marieAddress));
		
		   // Criando os endereços associados às cidades
        Address address1 = new Address(null, "123 Island Rd", "1", city1, null, null);
        Address address2 = new Address(null,"San Quentin Rd", "2", city2, null, null);
        Address address3 = new Address(null,"300 Prison Rd", "3", city3, null, null);
        
        addressRepository.saveAll(Arrays.asList(address1, address2, address3));

		// Salvando personagens e endereços
		imateRepository.saveAll(Arrays.asList(walterWhite, jessePinkman, gusFring, mikeEhrmantraut, lydiaRodarte, toddAlquist, hectorSalamanca));
		addressRepository.saveAll(Arrays.asList(walterAddress, jesseAddress , gusAddress, mikeAddress, saulAddress, skylerAddress, janeAddress, marieAddress));
		imateVisitorRepository.saveAll(Arrays.asList(skylerWhite, hollyWhite, marieSchrader, saulGoodman, stevenGomez, janeMargolis, badger, skinnyPete));

		
        // Instanciando as prisões
		 PrisionalInstitution p1 = new PrisionalInstitution("Alcatraz", SecurityLevel.HIGH, new Date(1940, 1, 1), 100, 200, "Famous high-security prison.", address1);
		 PrisionalInstitution p2 =  new PrisionalInstitution("San Quentin", SecurityLevel.MEDIUM, new Date(1852, 7, 1), 1500, 3000, "California state prison for men.", address2);
		PrisionalInstitution p3 =  new PrisionalInstitution("Folsom", SecurityLevel.HIGH, new Date(1880, 1, 1), 1200, 2500, "Prison located in California, famous for Johnny Cash's performance.", address3);
		 prisonInstitutionRepository.saveAll(Arrays.asList( p1, p2, p3));
		
     
        

		}

     
        
     

	}

}
