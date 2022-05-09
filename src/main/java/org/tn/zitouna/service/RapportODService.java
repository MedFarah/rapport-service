package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.entities.RapportOperationDevise;
@Service
public class RapportODService implements IRapportService<RapportOperationDevise, Long> {
	
	private RapportOperationDeviseRepository rapportOperationDeviseRepository;
	
	@Autowired
	public RapportODService(RapportOperationDeviseRepository rapportOperationDeviseRepository) {
		super();
		this.rapportOperationDeviseRepository = rapportOperationDeviseRepository;
	}

	@Override
	public RapportOperationDevise ajouterRapport(RapportOperationDevise rapport) {
		// TODO Auto-generated method stub
		return rapportOperationDeviseRepository.insert(rapport);
	}

	@Override
	public RapportOperationDevise modifierRapport(RapportOperationDevise rapport) {
		// TODO Auto-generated method stub
		return rapportOperationDeviseRepository.save(rapport);
	}

	@Override
	public void supprimerRapport(Long id) {
		// TODO Auto-generated method stub
		rapportOperationDeviseRepository.deleteById(id);
	}

	@Override
	public RapportOperationDevise afficherRapportById(Long id) {
		// TODO Auto-generated method stub
		return rapportOperationDeviseRepository.findById(id).get();
	}

	@Override
	public List<RapportOperationDevise> afficherRapports() {
		// TODO Auto-generated method stub
		return rapportOperationDeviseRepository.findAll();
	}

}
