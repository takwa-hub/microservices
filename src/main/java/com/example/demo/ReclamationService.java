package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService {
	@Autowired
	private ReclamationRepository ReclamationsRepository;


	//Ajouter une reclamation
	public Reclamation addReclamation(Reclamation rec) {
		rec.setTraiter(false); 
		rec.setEtat("En_attente");
		return ( ReclamationsRepository).save(rec);
	}

	//public Reclamation findbyid(Integer rec_id){
		//return ( ReclamationsRepository).getOne(rec_id);}

	/*Update d'un reclamation*/
	/*public  reclamation updaterec(reclamation rec)	{
		return reclamationRepository.save(rec);

	}*/
	/* traiter une reclamation */
	public Reclamation traiter(Reclamation rec) {

		return ReclamationsRepository.save(rec);
	}
	//public reclamation addReclamation(reclamation rec) {
	//return reclamationRepository.save(rec);
	//}

	public Reclamation updateReclamation(long id, Reclamation newReclamation) {
		if (ReclamationsRepository.findById((int) id).isPresent()) {
			Reclamation existingreclamation = ReclamationsRepository.findById((int) id).get();
			existingreclamation.setTraiter(newReclamation.isTraiter());
			existingreclamation.setEtat(newReclamation.getEtat());
			existingreclamation.setDescription(newReclamation.getDescription());
			existingreclamation.setTitre(newReclamation.getTitre());
			//existingreclamation.setDateRec(newReclamation.getDateRec());
			return ReclamationsRepository.save(existingreclamation);
		} else
			return null;
	}

	public String deleteReclamation(long id) {
		if (ReclamationsRepository.findById((int)id).isPresent()) {
			ReclamationsRepository.deleteById((int)id);
			return "reclamation supprimé";
		} else
			return "reclamation non supprimé";
	}


}
