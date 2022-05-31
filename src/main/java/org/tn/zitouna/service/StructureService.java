package org.tn.zitouna.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface StructureService <X> {
	public X ajouterStructure(X structure);
	public X modifierStructure(X structure);
	public void supprimerStructure(String id);
	public List<X> afficherStructures();
	public X getStructure(String id);
}
