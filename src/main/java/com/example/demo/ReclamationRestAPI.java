package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
@RestController
@RequestMapping(value = "/api/reclamations")
public class ReclamationRestAPI {
private String title="welcome";
	
    @Autowired
	private ReclamationService ReclamationService;

   // @RequestMapping(value="/saveReclamation" , method=RequestMethod.POST)
   // public String saveReclamation(@RequestBody JSONObject requestPara) {
		//Reclamation reclamation = new Reclamation(requestPara.getAsString(titre).toString(),requestPara.getAsString(description).toString(),requestPara.getAsString(etat).toString());
   // }
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		System.out.println(title);
		
		return title;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
		return new ResponseEntity<>(ReclamationService.addReclamation(reclamation), HttpStatus.OK);
	}

	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable(value = "id") int id,
    										@RequestBody Reclamation reclamation){
		return new ResponseEntity<>(ReclamationService.updateReclamation(id, reclamation), HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReclamation(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(ReclamationService.deleteReclamation(id), HttpStatus.OK);
	}

	

}
