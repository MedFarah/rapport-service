package org.tn.zitouna.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor
@Document(collection = "rapport_operation_devise")
public class RapportOperationDevise {
	private Entete entete;
	@NonNull @Id
	private Long numeroDeclaration;
	private  int codeEnregistrement = 910;
	@JsonIgnore
	private String codeOperation ;
	@Field(name = "TYPDOC")
	@JsonIgnore
	private String typeIdentifiantClient;
	private String numIdentifiantClient;
	private int codeAgenceDeclarant;
	@Field(name = "NINTOPER")
	private String identifiantInterneOperation;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOperation;
	private String codeTypeOperation;
	private String codeDevise;
	private Double montantEnDevise;
	private Double montantEnDinar;
	@Field(name = "NumDeclarationDouane")
	private String numDeclarationDouane;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateDeclarationDouane;
	private Double montantDeclareEnDouane;
	@JsonIgnore
	private String typeIdentifiantBeneficiairePP;
	private int numIdentifiantBeneficiairePP;
	private String typeIdentifiantBeneficiairePM;
	private int numIdentifiantBeneficiairePM;
	@Field(name = "KRIB")
	private String ribBeneficiaire;
	@Field(name = "KTYPCPT")
	private String typeCompteBeneficiaire;
	@Field(name = "KPAYS")
	private String codePaysExpediteurDesFonds;
	
	private Fin fin;
	
	
}
