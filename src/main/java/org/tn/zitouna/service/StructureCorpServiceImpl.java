package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.StructureCorpRepository;
import org.tn.zitouna.entities.StructureCorp;

@Service
public class StructureCorpServiceImpl implements StructureService<StructureCorp> {
	@Autowired
	private StructureCorpRepository structureCorpRepository;

	@Override
	public StructureCorp ajouterStructure(StructureCorp structure) {
		// TODO Auto-generated method stub
		return structureCorpRepository.insert(structure);
	}

	@Override
	public StructureCorp modifierStructure(StructureCorp structure) {
		// TODO Auto-generated method stub
		return structureCorpRepository.save(structure);
	}

	@Override
	public void supprimerStructure(StructureCorp structure) {
		// TODO Auto-generated method stub
		structureCorpRepository.delete(structure);
	}

	@Override
	public List<StructureCorp> afficherStructures() {
		// TODO Auto-generated method stub
		return structureCorpRepository.findAll();
	}

}
