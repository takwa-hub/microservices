package com.example.demo;

import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//changer etat reclamation
//@Projection(name = "noAddresses", types = { Reclamation.class })
public interface ReclamationRepository extends JpaRepository <Reclamation, Integer> {
	//@Modifying
	//@Query(value = "UPDATE `reclamation` SET `etat`=?1,`traiter`=1 WHERE `id`=?2", nativeQuery = true)
	//public void ChangetEtat(String Dispo, long id);
	@Query("select r from Reclamation r where r.etat like :etat")
	public Page<Reclamation> RelamationByetat(@Param("etat") String n, Pageable pageable);
}






