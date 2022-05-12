package org.tn.zitouna.entities;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "structure_corp")
public class StructureCorp {
	public enum CorpType {
		operationDevise, personnePhysique, personneMorale
	}

	private String designation;
	private String type;
	private int taille;
	private String table;
	private String champ;
	private String commentaire;
	@Transient
	private CorpType corpType;
}
