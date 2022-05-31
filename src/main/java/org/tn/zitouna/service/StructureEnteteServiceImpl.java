package org.tn.zitouna.service;

import java.util.List;
import java.util.UUID;

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
	public void supprimerStructure(String id) {
		// TODO Auto-generated method stub
		structureEnteteRepository.deleteById(id);
	}

	@Override
	public List<StructureEntete> afficherStructures() {
		// TODO Auto-generated method stub
		return structureEnteteRepository.findAll();
	}

	@Override
	public StructureEntete getStructure(String id) {
		// TODO Auto-generated method stub
		return structureEnteteRepository.findById(id).get();
	}

}
