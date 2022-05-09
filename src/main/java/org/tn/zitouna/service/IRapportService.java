package org.tn.zitouna.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IRapportService <X,Y> {
	public X ajouterRapport(X rapport);
	public X modifierRapport(X rapport);
	public void supprimerRapport(Y id);
	public X afficherRapportById(Y id);
	public List<X> afficherRapports();

}
