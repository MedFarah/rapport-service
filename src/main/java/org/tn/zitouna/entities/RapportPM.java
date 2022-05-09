package org.tn.zitouna.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor
@Document(collection = "rapport_personne_morale")
public class RapportPM {
	private Entete entete;
	@Id
	private Long numeroDeclaration;
	private final int codeEnregistrement = 110;
	private char codeOperation = 'N';
	private String typeIdentifiantPersonne;
	private String numeroIdentifiantPersonne;
	private String numeroRegistreCommerce;
	private String matriculeFiscal;
	private String raisonSocialePM;
	private String siglePM;
	private String qualitePM;
	private String nationalitePM;
	private int codeTypePM;
	private String codeFormeJuridique;
	private String codeActivitePM;
	private int codeRegime;
	private int codeSituation;
	private Date dateSituationJuridique;
	private String referenceJortSituationJuridique;
	private Date creationPM;
	private String referenceJortPM;
	private Date dateEntreExploitation;
	private int montantCapitalPM;
	private Date dateFixationCapitalSocial;
	
	private String numeroTelephone1;
	private String numeroTelephone2;
	private String numeroFax;
	private String numeroTelex;
	private String adresseEmail;
	private String adresseWebPM;
	private Fin fin;
	}
