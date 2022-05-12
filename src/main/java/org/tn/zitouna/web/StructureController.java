package org.tn.zitouna.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tn.zitouna.entities.StructureCorp;
import org.tn.zitouna.entities.StructureEntete;
import org.tn.zitouna.entities.StructureFin;
import org.tn.zitouna.service.StructureCorpServiceImpl;
import org.tn.zitouna.service.StructureEnteteServiceImpl;
import org.tn.zitouna.service.StructureFinServiceImpl;

@RestController
@RequestMapping(path = "/structure",produces = "application/json")
@ResponseBody
public class StructureController {
	private StructureCorpServiceImpl structureCorpServiceImpl;
	private StructureEnteteServiceImpl structureEnteteServiceImpl;
	private StructureFinServiceImpl structureFinServiceImpl;

	@Autowired
	public StructureController(StructureCorpServiceImpl structureCorpServiceImpl,
			StructureEnteteServiceImpl structureEnteteServiceImpl, StructureFinServiceImpl structureFinServiceImpl) {
		this.structureCorpServiceImpl = structureCorpServiceImpl;
		this.structureEnteteServiceImpl = structureEnteteServiceImpl;
		this.structureFinServiceImpl = structureFinServiceImpl;
	}

	@PostMapping(path = "/corp",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureCorp ajouterStructureCorp(@RequestBody StructureCorp entity) {
		return structureCorpServiceImpl.ajouterStructure(entity);
	}

	@PutMapping(path = "/corp",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureCorp modifierStructureCorp(@RequestBody StructureCorp entity) {
		return structureCorpServiceImpl.modifierStructure(entity);
	}

	@DeleteMapping(path = "/corp",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void supprimerStructureCorp(@RequestBody StructureCorp entity) {
		structureCorpServiceImpl.supprimerStructure(entity);
	}

	@GetMapping(path = "/corp",produces = "application/json")
	public List<StructureCorp> afficherStructureCorps() {
		return structureCorpServiceImpl.afficherStructures();
	}

	// **************************************** entete ******************************************************
	@PostMapping(path = "/entete",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureEntete ajouterStructureEntete(@RequestBody StructureEntete entity) {
		return structureEnteteServiceImpl.ajouterStructure(entity);
	}

	@PutMapping(path = "/entete",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureEntete modifierStructureEntete(@RequestBody StructureEntete entity) {
		return structureEnteteServiceImpl.modifierStructure(entity);
	}

	@DeleteMapping(path = "/entete", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void supprimerStructureEntete(@RequestBody StructureEntete entity) {
		structureEnteteServiceImpl.supprimerStructure(entity);
	}

	@GetMapping(path = "/entete",produces = "application/json")
	public List<StructureEntete> afficherStructureEntetes() {
		return structureEnteteServiceImpl.afficherStructures();
	}

	// ******************************************* structure fin  *********************************************
	@PostMapping(path = "/fin",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureFin ajouterStructureFin(@RequestBody StructureFin entity) {
		return structureFinServiceImpl.ajouterStructure(entity);
	}

	@PutMapping(path = "/fin",produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StructureFin modifierStructureFin(@RequestBody StructureFin entity) {
		return structureFinServiceImpl.modifierStructure(entity);
	}

	@DeleteMapping(path = "/fin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void supprimerStructureFin(@RequestBody StructureFin entity) {
		structureFinServiceImpl.supprimerStructure(entity);
	}

	@GetMapping(path = "/fin",produces = "application/json")
	public List<StructureFin> afficherStructureFins() {
		return structureFinServiceImpl.afficherStructures();
	}
}
