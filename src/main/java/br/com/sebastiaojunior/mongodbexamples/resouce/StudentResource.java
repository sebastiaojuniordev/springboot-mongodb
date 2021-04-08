package br.com.sebastiaojunior.mongodbexamples.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sebastiaojunior.mongodbexamples.model.Student;
import br.com.sebastiaojunior.mongodbexamples.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentResource {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public ResponseEntity<List<Student>> findAll() {
		List<Student> students = studentRepository.findAll();
		return ResponseEntity.ok(students);
	}

	@PostMapping
	public ResponseEntity<Student> insert(@RequestBody Student student) {
		Student saved = studentRepository.save(student);
		return ResponseEntity.ok(saved);
	}
	
	@PutMapping
	public ResponseEntity<Student> update(@RequestBody Student student) {
		Assert.notNull(student.getId(), "Id cannot be null");
		Student saved = studentRepository.save(student);
		return ResponseEntity.ok(saved);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		studentRepository.delete(student);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable String id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
		return ResponseEntity.ok(student);
	}
	
	@GetMapping("/age/{age}")
	public ResponseEntity<List<Student>> findByAge(@PathVariable Integer age) {
		List<Student> students = studentRepository.findByAge(age);
		return ResponseEntity.ok(students);
	}
}
