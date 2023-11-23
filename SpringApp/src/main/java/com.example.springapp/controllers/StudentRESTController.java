package com.example.springapp.controllers;

import com.example.springapp.model.Team;
import com.example.springapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springapp.model.Student;
import com.example.springapp.repository.StudentRepository;
import com.example.springapp.repository.AccountRepository;
import com.example.springapp.repository.AddressRepository;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/students")
public class StudentRESTController {

    private StudentRepository studentRepository;
    private AddressRepository addressRepository;

    @Autowired
    public StudentRESTController(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @RequestMapping(method = RequestMethod.GET/*, produces = "application/xml"*/)
    //@GetMapping
    public List<Student> findAllStudents() { return studentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        // Commented out due to simplify http requests sent from angular app
//        if (student.getAddress().getId() <= 0 )
//        {
//            addressRepository.save(student.getAddress());
//        }
        // Commented out due to simplify http requests sent from angular app
        studentRepository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent (@PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<List<Student>> updateCollection(@RequestBody List<Student> newListOfStudents){
        this.studentRepository.deleteAll();
        /*for(Student newStudent : newListOfStudents){
            addressRepository.save(newStudent.getAddress());
            studentRepository.save(newStudent);
        }*/
        studentRepository.saveAll(newListOfStudents);
        return new ResponseEntity<List<Student>>(newListOfStudents, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    //@PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id) {
        student.setId(id);
        studentRepository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    //@PatchMapping("/{id}")
    public ResponseEntity<Student> updatePartOfStudent(@RequestBody Map<String, Object> updates, @PathVariable("id") long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(student,updates);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    private void partialUpdate(Student student, Map<String, Object> updates) {
        if (updates.containsKey("firstname")) {
            student.setFirstname((String) updates.get("firstname"));
        }
        if (updates.containsKey("lastname")) {
            student.setLastname((String) updates.get("lastname"));
        }
        if (updates.containsKey("email")) {
            student.setEmail((String) updates.get("email"));
        }
        if (updates.containsKey("telephone")) {
            student.setTelephone((String) updates.get("telephone"));
        }
        studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudents() {
        studentRepository.deleteAll();
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

}


/*
public class StudentRESTController {
    private StudentRepository studentRepository;
    private AddressRepository addressRepository;
    private AccountRepository accountRepository;
    private TeamRepository teamRepository;
    @Autowired
    public StudentRESTController(StudentRepository studentRepository, AddressRepository addressRepository, AccountRepository accountRepository, TeamRepository teamRepository){
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
        this.teamRepository = teamRepository;
    }
    @RequestMapping(method=RequestMethod.GET)
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> findStudent(@PathVariable("id") long id){
        Student student = studentRepository.findById(id);
        return new ResponseEntity<Student>(student, HttpStatus.FOUND);
    }
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        if(student.getAddress().getId()<=0){
            addressRepository.save(student.getAddress());
        }
        for(Team team : student.getTeamList()){
            if(team.getId()<=0){
                teamRepository.save(team);
            }
            else{
                teamRepository.findById(team.getId()).getStudentList().add(student);
            }
        }
        studentRepository.save(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<StudentRepository> deleteCollection(){
        studentRepository.deleteAll();

        return new ResponseEntity<StudentRepository>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id){
        Student student=studentRepository.findById(id);
        if(student == null){
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentRepository.deleteById(id);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<StudentRepository> updateCollection(@RequestBody List<Student> newListOfStudents){
        this.studentRepository.deleteAll();
        for(Student newStudent : newListOfStudents){
            addressRepository.save(newStudent.getAddress());
            studentRepository.save(newStudent);
        }
        return new ResponseEntity<StudentRepository>(HttpStatus.CREATED);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        student.setId(id);
        if(student.getAddress().getId()<=0){
            addressRepository.save(student.getAddress());
        }
        student.getAccount().setId(studentRepository.findById(id).getAccount().getId());
        studentRepository.save(student);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public ResponseEntity<Student> updatePartOfStudent(@RequestBody Map<String, Object> updates, @PathVariable("id") long id){
        Student student = studentRepository.findById(id);
        if(student == null){
            System.out.println("Student not found!");
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(student, updates);
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Student student, Map<String, Object> updates){
        if(updates.containsKey("firstname")){
            student.setFirstname((String) updates.get("firstname"));
        }
        if(updates.containsKey("lastname")){
            student.setLastname((String) updates.get("lastname"));
        }
        if(updates.containsKey("email")){
            student.setEmail((String) updates.get("email"));
        }
        if(updates.containsKey("telephone")){
            student.setTelephone((String) updates.get("telephone"));
        }
        studentRepository.save(student);
    }
}
*/
