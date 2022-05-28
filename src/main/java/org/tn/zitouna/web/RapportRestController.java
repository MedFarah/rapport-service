package org.tn.zitouna.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tn.zitouna.entities.RapportOperationDevise;
import org.tn.zitouna.entities.RapportPM;
import org.tn.zitouna.entities.RapportPP;
import org.tn.zitouna.service.GenerateRapportFromFile;
import org.tn.zitouna.service.GenerateRapportImpl;
import org.tn.zitouna.service.RapportODService;
import org.tn.zitouna.service.RapportPMService;
import org.tn.zitouna.service.RapportPPService;

@RestController
@RequestMapping("/rapport")
@CrossOrigin("*")
public class RapportRestController {
	private RapportODService rapportODService;
	private RapportPPService rapportPPService;
	private RapportPMService rapportPMService;
	private GenerateRapportImpl generateRapportImpl;
	private GenerateRapportFromFile generateRapportFromFile;

	@Autowired
	public RapportRestController(RapportODService rapportODService, RapportPPService rapportPPService,
			RapportPMService rapportPMService,GenerateRapportImpl generateRapportImpl, GenerateRapportFromFile generateRapportFromFile) {
		this.rapportODService = rapportODService;
		this.rapportPPService = rapportPPService;
		this.rapportPMService = rapportPMService;
		this.generateRapportImpl = generateRapportImpl;
		this.generateRapportFromFile = generateRapportFromFile;
	}
	
	//************************************** Jasper report **************************************************
	@GetMapping(path ="/generateRapportOD", produces = MediaType.APPLICATION_JSON_VALUE)
	public String generateRapportOD(@RequestParam(name = "format",required = true,defaultValue = "csv") String rapportFormat,HttpServletResponse response) throws Exception {
		return generateRapportImpl.generateRapportOD(rapportFormat);
	}
	
	@GetMapping(path ="/generateRapportPP", produces = "application/json")
	public String generateRapportPP(@RequestParam(name = "format",required = true,defaultValue = "csv") String rapportFormat) throws Exception {
		return generateRapportImpl.generateRapportPP(rapportFormat);
	}
	
	@GetMapping(path ="/generateRapportPM", produces = "application/json")
	public String generateRapportPM(@RequestParam(name = "format",required = true,defaultValue = "csv") String rapportFormat) throws Exception {
		return generateRapportImpl.generateRapportPM(rapportFormat);
	}
	
	
	//************************************************** drools and regle de gestion*******************
	/*
	 * 	@RequestMapping(path = "/show",produces = "application/json",method = RequestMethod.GET)
	
		/* lancy drools files
		 * public Integer calculateFare(Utilisateur u) {
	        KieSession kieSession = kieContainer.newKieSession();
	      //  kieSession.setGlobal("u", u);
	        kieSession.insert(u);
	        kieSession.fireAllRules();
	        kieSession.dispose();
	        return u.getNumber();
    		}
		
	
	 * */
	
	//**********************************************************************************************************
	@GetMapping(path = "/rapportOD",produces = "application/json")
	public List<RapportOperationDevise> afficherRapportsOD() {
		return rapportODService.afficherRapports();
	}
	@GetMapping(path = "/rapportOD/{id}",produces = "application/json")
	public RapportOperationDevise afficherRapportODById(@PathVariable Long id) {
		return rapportODService.afficherRapportById(id);
	}
	@PostMapping(path = "/rapportOD",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportOperationDevise ajouterRapportOD(@RequestBody RapportOperationDevise rapportOperationDevise) {
		return rapportODService.ajouterRapport(rapportOperationDevise);
	}
	@PutMapping(path = "/rapportOD",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportOperationDevise modifierRapportOD(@RequestBody RapportOperationDevise rapportOperationDevise) {
		return rapportODService.modifierRapport(rapportOperationDevise);
	}
	@DeleteMapping(path = "/rapportOD/{id}")
	public void supprimerRapportOD(@PathVariable Long id) {
		rapportODService.supprimerRapport(id);
	}

	// ****************************************** ***********************************************************************************
	@GetMapping(path = "/rapportPP",produces = "application/json")
	public List<RapportPP> afficherRapportsPP() {
		return rapportPPService.afficherRapports();
	}
	@GetMapping(path = "/rapportPP{id}",produces = "application/json")
	public RapportPP afficherRapportPPById(@PathVariable  Long id) {
		return rapportPPService.afficherRapportById(id);
	}
	@PostMapping(path = "/rapportPP",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportPP ajouterRapportPP(@RequestBody RapportPP rapportOperationDevise) {
		return rapportPPService.ajouterRapport(rapportOperationDevise);
	}
	@PutMapping(path = "/rapportPP",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportPP modifierRapportPP(@RequestBody RapportPP rapportOperationDevise) {
		return rapportPPService.modifierRapport(rapportOperationDevise);
	}
	@DeleteMapping(path = "/rapportPP/{id}")
	public void supprimerRapportPP(@PathVariable Long id) {
		rapportPPService.supprimerRapport(id);
	}

	// *****************************************************************************************************************************
	@GetMapping(path = "/rapportPM",produces = "application/json")
	public List<RapportPM> afficherRapportsPM() {
		return rapportPMService.afficherRapports();
	}
	@GetMapping(path = "/rapportPM/{id}",produces = "application/json")
	public RapportPM afficherRapportPMById(@PathVariable  Long id) {
		return rapportPMService.afficherRapportById(id);
	}
	@PostMapping(path = "/rapportPM",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportPM ajouterRapportPM(@RequestBody RapportPM rapportOperationDevise) {
		return rapportPMService.ajouterRapport(rapportOperationDevise);
	}
	@PutMapping(path = "/rapportPM",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RapportPM modifierRapportPM(@RequestBody RapportPM rapportOperationDevise) {
		return rapportPMService.modifierRapport(rapportOperationDevise);
	}
	@DeleteMapping(path = "/rapportPM/{id}")
	public void supprimerRapportPM(@PathVariable Long id) {
		rapportPMService.supprimerRapport(id);
	}

}
