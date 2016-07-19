package com.softpath.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISCOS_TABLE")
public class Discos {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idDiscos;
	private String nameDiscos;
	private String genreDiscos;
	
	
	public int getIdDiscos() {
		return idDiscos;
	}
	public void setIdDiscos(int idDiscos) {
		this.idDiscos = idDiscos;
	}
	public String getNameDiscos() {
		return nameDiscos;
	}
	public void setNameDiscos(String nameDiscos) {
		this.nameDiscos = nameDiscos;
	}
	public String getGenreDiscos() {
		return genreDiscos;
	}
	public void setGenreDiscos(String genreDiscos) {
		this.genreDiscos = genreDiscos;
	}
	
	
	
}
