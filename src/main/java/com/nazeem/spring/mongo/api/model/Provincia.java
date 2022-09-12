package com.nazeem.spring.mongo.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Provincia")
public class Provincia {
	@Id
	private String id;
	private String nombre;
	private String codigo;

}
