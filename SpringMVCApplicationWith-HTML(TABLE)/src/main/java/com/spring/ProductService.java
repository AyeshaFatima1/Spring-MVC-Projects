package com.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

@Autowired
private ProductRepository repo;

//display all data
public List<Product1> listAll(){
return repo.findAll();
}

//Insert data
public void saveProduct(Product1 product) {
 repo.save(product);
}

//Sreach by id
public Optional<Product1> findProductById(Integer id) {
	return repo.findById(id);
}

//delete record
public void delete(Integer id) {
	repo.deleteById(id);
}
}
