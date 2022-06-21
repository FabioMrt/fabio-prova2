package br.edu.univas.si7.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.order.model.Auditing;

@Repository
public interface AuditingMongoRepository extends MongoRepository<Auditing, String> {

}
