package org.tn.zitouna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tn.zitouna.dao.RapportPPRepository;
import org.tn.zitouna.entities.RapportPP;

@Service
public class RapportPPService implements IRapportService<RapportPP, Long> {
	private RapportPPRepository rapportPPRepository;
	@Autowired
	public RapportPPService(RapportPPRepository rapportPPRepository) {
		super();
		this.rapportPPRepository = rapportPPRepository;
	}

	@Override
	public RapportPP ajouterRapport(RapportPP rapport) {
		// TODO Auto-generated method stub
		return rapportPPRepository.insert(rapport);
	}

	@Override
	public RapportPP modifierRapport(RapportPP rapport) {
		// TODO Auto-generated method stub
		return rapportPPRepository.save(rapport);
	}

	@Override
	public void supprimerRapport(Long id) {
		// TODO Auto-generated method stub
		rapportPPRepository.deleteById(id);
	}

	@Override
	public RapportPP afficherRapportById(Long id) {
		// TODO Auto-generated method stub
		return rapportPPRepository.findById(id).get();
	}

	@Override
	public List<RapportPP> afficherRapports() {
		// TODO Auto-generated method stub
		return rapportPPRepository.findAll();
	}

}
