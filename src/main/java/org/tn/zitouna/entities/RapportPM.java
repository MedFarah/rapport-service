package org.tn.zitouna.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor
@Document(collection = "rapport_personne_morale")
public class RapportPM {
	private Entete entete;
	@Id
	private Long numeroDeclaration;
	private  int codeEnregistrement = 110;
	private String codeOperation = "N";
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
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateSituationJuridique;
	private String referenceJortSituationJuridique;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationPM;
	private String referenceJortPM;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateEntreExploitation;
	private int montantCapitalPM;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateFixationCapitalSocial;
	
	private String numeroTelephone1;
	private String numeroTelephone2;
	private String numeroFax;
	private String numeroTelex;
	private String adresseEmail;
	private String adresseWebPM;
	private Fin fin;
	}
