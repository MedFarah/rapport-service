package org.tn.zitouna.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.tn.zitouna.entities.StructureFin;

@Repository
public interface StructureFinRepository extends MongoRepository<StructureFin, String> {

}
