package com.softpath.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.softpath.dao.DiscosDAO;
import com.softpath.dao.UserDAO;
import com.softpath.entity.Discos;
import com.softpath.entity.Users;

@Controller
public class LogginController {
	
	@Autowired
	private UserDAO daoUser;
	
	@Autowired
	private DiscosDAO daoDiscos;
	
	
	@ModelAttribute("loginForm")
	public Users createUser()
	{
		return new Users();
	}
	
	
	
	
	@RequestMapping("/home")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/loginURL", method=RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("loginForm")Users user, ModelAndView model){
		
		boolean check = false;
		List<Discos> lista = null;
		check = daoUser.checkUser(user);
		lista = daoDiscos.regresaProductos();
		
		/*for (Discos discos : lista) {
			System.out.println(discos.getNameDiscos());
		}*/
		
		if (check && lista !=null){
			model.setViewName("products");
			model.addObject("lista", lista);
			return model;
		}
		
		model.setViewName("login");
		return model;
		
	}
	
	//sepone en el jsp el nombre del mapping
	@RequestMapping(value="/mostrarCatalogo", method=RequestMethod.GET)//cambia el metodo a GET
	public @ResponseBody List<Discos> mostrarCatalogo(@ModelAttribute("catalogoForm")ModelAndView model){//se añadio responsebody que lo hace objetos formato Json
		
		
		List<Discos> lista = null;
		lista = daoDiscos.regresaProductos();
		if (lista !=null){
			
			return lista;//se regresa la lista
			
		}
		
		return lista;
		
	}
	
	
	
}
