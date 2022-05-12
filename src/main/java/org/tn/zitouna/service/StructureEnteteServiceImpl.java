package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.StructureEnteteRepository;
import org.tn.zitouna.entities.StructureEntete;

@Service
public class StructureEnteteServiceImpl implements StructureService<StructureEntete> {
	@Autowired
	private StructureEnteteRepository structureEnteteRepository;
	@Override
	public StructureEntete ajouterStructure(StructureEntete structure) {
		// TODO Auto-generated method stub
		return structureEnteteRepository.insert(structure);
	}

	@Override
	public StructureEntete modifierStructure(StructureEntete structure) {
		// TODO Auto-generated method stub
		return structureEnteteRepository.save(structure);
	}

	@Override
	public void supprimerStructure(StructureEntete structure) {
		// TODO Auto-generated method stub
		structureEnteteRepository.delete(structure);
	}

	@Override
	public List<StructureEntete> afficherStructures() {
		// TODO Auto-generated method stub
		return structureEnteteRepository.findAll();
	}

}
