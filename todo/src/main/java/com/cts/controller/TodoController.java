package com.cts.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Todo;
import com.cts.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TodoController {

	private final TodoRepository todoRepository;

	@GetMapping("/todo")
	public ResponseEntity<List<Todo>> getTodos() {
		log.info("Fetching all Todo's");
		return ResponseEntity.ok(todoRepository.findAll());
	}

	@GetMapping(value = "/image/{file}", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String file) throws IOException {
		log.info("Fetching image ()", file);

		ClassPathResource imgFile = new ClassPathResource("assets/"+file);

		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(new InputStreamResource(imgFile.getInputStream()));
	}

}
