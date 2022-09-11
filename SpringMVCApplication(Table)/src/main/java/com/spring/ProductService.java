package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

@Autowired
private ProductRepository repo;

public List<Product> listAll(){
return repo.findAll();
}

public void save(Product product) {
 repo.save(product);
}

public Product productById(Integer id) {
	return repo.findById(id).get();
}

public void deleteProduct(Integer id) {
	repo.deleteById(id);
}

public List<Product> getByKeyword(String keyword){
	  return repo.findByKeyword(keyword);
}

}
