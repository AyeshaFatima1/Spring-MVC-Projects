package com.spring;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

@Autowired
private ProductService service;

@RequestMapping("/")
public String viewHomePage(Model model) {
	List<Product1> listProducts=service.listAll();
	model.addAttribute("listProducts",listProducts);
	return "index";
}

@RequestMapping("/new")
public String showNewProductPage(Model model) {
	Product1 product=new Product1();
	model.addAttribute("product",product);
	return "new_product";
}

@RequestMapping(value="/save",method=RequestMethod.POST)
public String saveProduct(@ModelAttribute("product") Product1 product) {
	service.saveProduct(product);
	return "redirect:/";
}

@GetMapping("/upload")
public String fileUpload(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
 Product1 product = new Product1();
 String fileName = file.getOriginalFilename();
 product.setProfilePicture(fileName);
 product.setContent(file.getBytes());
 product.setSize(file.getSize());
 service.saveProduct(product);
 model.addAttribute("success", "File Uploaded Successfully!!!");
 return "index";
 
}

@GetMapping("/downloadfile")
public void downloadFile(@Param("id") Integer id , Model model, HttpServletResponse response) throws IOException {
 Optional<Product1> temp = service.findProductById(id);
 if(temp!=null) {
 Product1 product= temp.get();
  response.setContentType("application/octet-stream");
  String headerKey = "Content-Disposition";
  String headerValue = "attachment; filename = "+product.getProfilePicture();
  response.setHeader(headerKey, headerValue);
  ServletOutputStream outputStream = response.getOutputStream();
  outputStream.write(product.getContent());
  outputStream.close();
 }
}

@GetMapping("/image")
public void showImage(@Param("id") Integer id, HttpServletResponse response, Optional<Product1> product)
  throws ServletException, IOException {
 
 product= service.findProductById(id);
 response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
 response.getOutputStream().write(product.get().getContent());
 response.getOutputStream().close();
}

@RequestMapping("/edit/{id}")
public ModelAndView showEditProductPage(@PathVariable(name="id") Integer id) {
	ModelAndView mod=new ModelAndView("edit_product");
	Optional<Product1> product=service.findProductById(id);
	mod.addObject("product",product);
    return mod;
}

@RequestMapping("/delete/{id}")
public String deleteProduct(@PathVariable(name="id") Integer id) {
	service.delete(id);
	return "redirect:/";
}
}
