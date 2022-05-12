package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.StructureFinRepository;
import org.tn.zitouna.entities.StructureFin;

@Service
public class StructureFinServiceImpl implements StructureService<StructureFin> {
	@Autowired
	private StructureFinRepository structureFinRepository;

	@Override
	public StructureFin ajouterStructure(StructureFin structure) {
		// TODO Auto-generated method stub
		return structureFinRepository.insert(structure);
	}

	@Override
	public StructureFin modifierStructure(StructureFin structure) {
		// TODO Auto-generated method stub
		return structureFinRepository.save(structure);
	}

	@Override
	public void supprimerStructure(StructureFin structure) {
		// TODO Auto-generated method stub
		structureFinRepository.delete(structure);
	}

	@Override
	public List<StructureFin> afficherStructures() {
		// TODO Auto-generated method stub
		return structureFinRepository.findAll();
	}

}
