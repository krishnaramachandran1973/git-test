package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Builder
@Entity
public class Todo {
	
	@Id
	@Default
	private String id = UUID.randomUUID().toString();
	
	private final String description;
	
	@Default
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime created = LocalDateTime.now();
	
	@Default
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDateTime modified = LocalDateTime.now();
	
	private String imageUrl;

}
