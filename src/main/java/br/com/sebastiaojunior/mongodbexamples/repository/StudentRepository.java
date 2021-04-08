package br.com.sebastiaojunior.mongodbexamples.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sebastiaojunior.mongodbexamples.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String name);
	List<Student> findByAge(Integer age);
}
