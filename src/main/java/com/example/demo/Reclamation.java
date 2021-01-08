package com.example.demo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
@Entity
@Table(name="Reclamation")
public class Reclamation implements Serializable{
	private static final long serialVersionUID = 795450928237931201L;
	@Autowired
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="Liv_id",length=15,nullable=false,unique=true)
	//@Transient
	@Column(name="id")
	private long id ;
	
	@Column(name="titre")
	private String titre ;
	@Column(name="description")
	private String description ;
	@Column(name="traiter")
	private boolean traiter ;
	@Column(name="etat")
	private String etat ;
	//@Column(name="dateRec")
	//private LocalDate dateRec;

	@Transient


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTraiter() {
		return traiter;
	}

	public void setTraiter(boolean traiter) {
		this.traiter = traiter;
	}


	public Reclamation() {
		super();
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	/*public LocalDate getDateRec() {
		return dateRec;
	}*/

	/*public void setDateRec(LocalDate dateRec) {
		this.dateRec = dateRec;
	}*/
	public Reclamation(Integer id, String titre, String description) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
	}

	

	public Reclamation(long id, String titre, String description, boolean traiter, String etat/*, LocalDate dateRec*/) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.traiter = traiter;
		this.etat = etat;
		//this.dateRec = dateRec;
	}
	public Reclamation(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}
	public Reclamation(String titre, String description, boolean traiter, String etat) {
		super();
		this.titre = titre;
		this.description = description;
		this.traiter = traiter;
		this.etat = etat;
		
	}

}
