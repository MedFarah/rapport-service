package org.tn.zitouna.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tn.zitouna.entities.StructureEntete;
@Repository
public interface StructureEnteteRepository extends MongoRepository<StructureEntete, Long> {

}
