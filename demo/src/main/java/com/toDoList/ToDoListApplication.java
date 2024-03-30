package com.toDoList;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.toDoList.entity.Category;
import com.toDoList.entity.Task;
import com.toDoList.repository.CategoryRepository;
import com.toDoList.repository.TaskRepository;

@SpringBootApplication
public class ToDoListApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
	

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
			Category categorie = new Category(null, "compras");
			Category categorie1 = new Category(null, "coisas a se fazer");
			Category categorie2 = new Category(null, "urgencia");
			Category categorie3 = new Category(null, "Conserto");


			categoryRepository.saveAll(Arrays.asList(categorie, categorie1, categorie2, categorie3));
			
			Task task = new Task(null, "perfume", "perfume ladro", categorie);
			taskRepository.save(task);
		
			
	}

	
	
}
