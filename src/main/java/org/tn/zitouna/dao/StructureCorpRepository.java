package org.tn.zitouna.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tn.zitouna.entities.StructureCorp;

@Repository
public interface StructureCorpRepository extends MongoRepository<StructureCorp	, String>{

}
