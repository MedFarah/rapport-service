package org.tn.zitouna.service;

import org.bson.json.JsonObject;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerateRapport {

	public String generateRapportOD(String rapportFormat) throws Exception ;
	public String generateRapportPP(String rapportFormat) throws Exception ;
	public String generateRapportPM(String rapportFormat) throws Exception ;
}
