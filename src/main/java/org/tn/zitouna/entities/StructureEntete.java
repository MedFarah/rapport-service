package org.tn.zitouna.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "structure_entete")
public class StructureEntete {

	public enum EnteteType {
		operationDevise, personnePhysique, personneMorale
	}

	private String designation;
	private String type;
	private int taille;
	private String regleDeGestion;
	private String commentaire;
	@Transient
	private EnteteType enteteType;

}