package com.cts;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.entity.Todo;
import com.cts.repository.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(TodoRepository todoRepository) {
		return args -> {
			Arrays.asList(Todo.builder()
					.description("First Todo")
					.imageUrl("todo1.jpg")
					.build(),
					Todo.builder()
							.description("Second Todo")
							.imageUrl("todo2.jpg")
							.build(),
					Todo.builder()
							.description("Third Todo")
							.imageUrl("todo3.jpg")
							.build(),
					Todo.builder()
							.description("Fourth Todo")
							.imageUrl("todo4.jpg")
							.build())
					.forEach(todo -> todoRepository.save(todo));
			log.info("Todo's saved");
		};
	}
}
