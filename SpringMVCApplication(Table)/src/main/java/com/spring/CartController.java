package com.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

@Autowired
private ProductService service;

@RequestMapping(value="/cart",method=RequestMethod.GET)
public String index() {
	return "cart";
}

@RequestMapping(value="/buy/{id}",method=RequestMethod.GET)
public String buy(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
if(session.getAttribute("cart")==null) {
	List<Item> cart=new ArrayList<Item>();
	cart.add(new Item(service.productById(id),1));
	session.setAttribute("cart", cart);
} else {
	List<Item> cart=(List<Item>) session.getAttribute("cart");
	int index=isExists(id,cart);
	if(index == -1) {
	cart.add(new Item(service.productById(id),1));
} else {
	int quantity=cart.get(index).getQuantity()+1;
	cart.get(index).setQuantity(quantity);
}
    session.setAttribute("cart", cart);
}
		return "redirect:/cart";
}
private int isExists(int id, List<Item> cart) {
	for(int i=0; i<cart.size(); i++) {
		if(cart.get(i).getProduct().getId()==id) {
			return i;
		}
	}
	return -1;
}
}
