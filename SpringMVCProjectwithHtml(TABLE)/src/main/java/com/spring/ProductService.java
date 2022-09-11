package com.spring;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

@Autowired
private ProductRepository repo;

public List<Product2> listAll(){
return repo.findAll();
}

public void save(Product2 product) {
 repo.save(product);
}

public Product2 productById(Integer id) {
	return repo.findById(id).get();
}

public void deleteProduct(Integer id) {
	repo.deleteById(id);
}

public List<Product2> getByKeyword(String keyword){
	  return repo.findByKeyword(keyword);
}

/*public void saveImageToDB(MultipartFile file, String name, float price) {
	Product p=new Product();
	String fileName=StringUtils.cleanPath(file.getOriginalFilename());
	if(fileName.contains("..")) {
		System.out.println("not a vaild file");
	}
	try {
		p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
	} catch (IOException e) {
		e.printStackTrace();
	}
	p.setName(name);
	p.setPrice(price);
	repo.save(p);
}*/
}
