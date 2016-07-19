package com.softpath.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softpath.entity.Discos;


@Repository
@Transactional
public class DiscosdaoImplement implements DiscosDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Discos> regresaProductos() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Discos");
		
		List<Discos> regresaProductos =  (List<Discos>)query.list();
		
		if(regresaProductos!=null)
		return regresaProductos;
		
		return null;
	}

}
