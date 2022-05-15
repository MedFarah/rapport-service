package org.tn.zitouna.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data @NoArgsConstructor
@Document(collection = "rapport_personne_physique")
public class RapportPP {
	private Entete entete;
	@Id
	private Long numeroDeclaration;
	private  int codeEnregistrement = 105;
	private String codeOperation = "N";
	private String typeDocument;
	private String numeroDocumentIdentification;

	private Date dateDebutDocumentIdentification;
	private String lieuDelivranceDocumentIdentification;

	private Date dateFinValiditeDocumentIdentification;

	private String nomPersonPhysique;
	private String prenomPersonnePhysique;
	private String sexePersonnePhysique;
	private Date dateNaissance;
	private String lieuNaissance;
	private String qualitePersonne;
	private String nationalite;
	private String profession;
	private String etatCivil;
	private int situationJuridique;
	private Date dateSituationJuridique;
	private String numeroTelephone1;
	private String numeroTelephone2;
	private String numeroFax;
	private String numeroTelex;
	private String adresseEmail;
	private Fin fin;

}
