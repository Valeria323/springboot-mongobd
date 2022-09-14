package com.nazeem.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nazeem.spring.mongo.api.model.Ciudad;
import com.nazeem.spring.mongo.api.model.Provincia;
import com.nazeem.spring.mongo.api.service.CiudadService;
import com.nazeem.spring.mongo.api.service.ProvinciaService;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;

	@PostMapping("/add")
	public String saveCiudad(@RequestBody Ciudad ciudad) {
		String id  = ciudadService.save(ciudad);
		return "Added ciudad with id : " + id;
	}

	@GetMapping("/findAll")
	public List<Ciudad> getCiudad() {
		return ciudadService.findAll();
	}

	@GetMapping("/findByCodigo/{codigo}")
	public List<Ciudad> getCodigo( @PathVariable String codigo) {
		return ciudadService.findByCodigo(codigo);
	}
	
	/*@GetMapping("/findByCodigo/{codigo}")
	public List<Provincia> findByCodigo( @PathVariable("codigo") String codigo) {
		return provinciaService.findByCodigo(codigo);
	}*/

	@GetMapping("/findAll/{id}")
	public Optional<Ciudad> getCiudad(@PathVariable String id) {
		return ciudadService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCiudad(@PathVariable String id) {
		ciudadService.deleteById(id);
		return "ciudad deleted with id : " + id;
	}

}