package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.RapportOperationDeviseRepository;
import org.tn.zitouna.dao.RapportPMRepository;
import org.tn.zitouna.entities.RapportPM;

@Service
public class RapportPMService implements IRapportService<RapportPM, Long> {

	private RapportPMRepository rapportPMRepository;

	@Autowired
	public RapportPMService(RapportPMRepository rapportPMRepository,
			RapportOperationDeviseRepository rapportOperationDevise) {
		this.rapportPMRepository = rapportPMRepository;
	}

	@Override
	public RapportPM ajouterRapport(RapportPM rapport) {
		// TODO Auto-generated method stub
		return rapportPMRepository.insert(rapport);
	}

	@Override
	public RapportPM modifierRapport(RapportPM rapport) {
		// TODO Auto-generated method stub
		return rapportPMRepository.save(rapport);
	}

	@Override
	public void supprimerRapport(Long id) {
		// TODO Auto-generated method stub
		rapportPMRepository.deleteById(id);
	}

	@Override
	public RapportPM afficherRapportById(Long id) {
		// TODO Auto-generated method stub
		return rapportPMRepository.findById(id).get();
	}

	@Override
	public List<RapportPM> afficherRapports() {
		// TODO Auto-generated method stub
		return rapportPMRepository.findAll();
	}

}
