package com.nazeem.spring.mongo.api.service;

import com.nazeem.spring.mongo.api.model.Provincia;
import com.nazeem.spring.mongo.api.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String save(Provincia provincia){
    	provinciaRepository.save(provincia);
        return provincia.getId();
    }
    public Optional<Provincia> findById(String id){
        return provinciaRepository.findById(id);
    }
  /*  public List<Provincia> findByCodigo(String codigo){
        Query query  = new Query();
        query.addCriteria(Criteria.where("codigo").regex(".*"+codigo+"*.", "i"));

        List<Provincia> provincias = mongoTemplate.find(query, Provincia.class);
        return provincias;
    }*/
    
    
    
    public List<Provincia> findByCodigo(String codigo){
    	return provinciaRepository.findByCodigo(codigo);
    }
    public List<Provincia> findAll(){
        return provinciaRepository.findAll();
    }
    public void deleteById(String id){
    	provinciaRepository.deleteById(id);
    }
}
