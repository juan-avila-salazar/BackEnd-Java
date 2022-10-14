package com.ej7.crudvalidation.students.application;

import com.ej7.crudvalidation.exceptions.CustomError;
import com.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.ej7.crudvalidation.people.domain.Person;
import com.ej7.crudvalidation.people.infrastructure.repository.PersonRepository;
import com.ej7.crudvalidation.students.domain.Student;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoIn;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOut;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOutFull;
import com.ej7.crudvalidation.students.infrastructure.dto.StudentDtoOutSimple;
import com.ej7.crudvalidation.students.infrastructure.repository.StudentRepository;
import com.ej7.crudvalidation.subjects.infrastructure.repository.SubjectRepository;
import com.ej7.crudvalidation.teachers.domain.Teacher;
import com.ej7.crudvalidation.teachers.infrastructure.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequestMapping("/student")
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectRepository subjectRepository;

    //VALIDATIONS
    private void throwUnprocessableEntityException(String message) throws UnprocessableEntityException {
        throw new UnprocessableEntityException(new CustomError(new Date(System.currentTimeMillis()), 422, message));
    }
    private boolean checkStudent(StudentDtoIn student) throws UnprocessableEntityException {
        if (student.getNum_hours_week() == null)
            throwUnprocessableEntityException("The student must have assigned weekly hours.");
        if (student.getBranch() == null)
            throwUnprocessableEntityException("The student must have an assigned branch.");
        for (String Id : student.getSubjectsList())
            if (!subjectRepository.existsById(Id))
                throwUnprocessableEntityException("The subject with id" + Id + "does not exist.");
        return true;
    }

    //CRUD//
    // POST
    @Override
    public StudentDtoOutSimple addStudent(StudentDtoIn student) throws UnprocessableEntityException, EntityNotFoundException {
        if (checkStudent(student)){
            Student newStudent = new Student(student);
            List<Teacher> teacherList = teacherRepository.findAll();
            for (Teacher p : teacherList)
                if (p.getPerson().getPerson_id().equals(student.getPerson_id()))
                    throw new UnprocessableEntityException("That person is a teacher and can NOT be a student.");
            Person person = personRepository.findById(student.getPerson_id()).orElseThrow(() -> new EntityNotFoundException("That person does not exist."));
            student.setPerson(person);
            Teacher teacher = teacherRepository.findById(student.getTeacher_id()).orElseThrow(() -> new EntityNotFoundException("That teacher does not exist."));
            student.setTeacher(teacher);
            List<Subject> subjectList = get(student.getSubjectsList());
            student.setListaAsignaturas(subjectList);
            studentRepository.save(student);
            return new StudentDtoOutSimple(student);
        }else
            throw new UnprocessableEntityException("Failed to add student");
    }

    //GET
    // FULL PERSON TABLE
    @Override
    public List<StudentDtoOutSimple> getAllStudent() {
        List<StudentDtoOutSimple> list = new ArrayList<>();
        studentRepository.findAll().forEach(s -> list.add(new StudentDtoOutSimple(s)));
        return list;
    }
    @Override
    public StudentDtoOutFull getStudentByIdFull(String id) throws EntityNotFoundException{
        return new StudentDtoOutFull(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("That record does not exist.")));
    }
    @Override
    public StudentDtoOutSimple getStudentByIdSimple(String id) throws EntityNotFoundException {
        return new StudentDtoOutSimple(studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("That record does not exist.")));
    }
    @Override
    public List<StudentDtoOutSimple> getStudentsByUserName(String userName) {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDtoOutSimple> studentWhitThisUserName = new ArrayList<>();
        if (!studentRepository.isEmpty()) {
            Stream<Student> studentStream = studentRepository.stream();
            studentWhitThisUserName = studentStream.filter(s -> s.getPerson().getUserName().equals(userName))
                    .map(StudentDtoOutSimple::new).toList();
        }
        return studentWhitThisUserName;
    }


    //PUT
    @Override
    public StudentDtoOut updateStudent(Integer id, StudentDtoIn updatedStudent) throws UnprocessableEntityException, EntityNotFoundException {
        Student student = new Student(updatedStudent);
        if (checkStudent(student)){
            Integer ident = getStudentById(id).getStudent_id();
            student.setStudent_id(ident);
            studentRepository.save(student);
            return new StudentDtoOut(student);
        }
        return null;
    }
    //DELETE
    @Override
    public String deleteStudent(Integer id) throws EntityNotFoundException {
        if (studentRepository.findById(id).isPresent()) {
            try {
                studentRepository.deleteById(id);
            }catch (EmptyResultDataAccessException exc){
                throw new EntityNotFoundException(new CustomError(new Date(System.currentTimeMillis()), 404, "Error! the customer does not exist"));
            }
            return "Customer removed successfully";
        }
        return "Error! the customer does not exist";
    }

}