package raisetech.student.management2.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.management2.data.Course;
import raisetech.student.management2.data.Student;
import raisetech.student.management2.repositiry.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
  //    return repository.search();

      return repository.search().stream()
          .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
          .collect(Collectors.toList());  //return repository.search();
//ここで何か処理を行う
  }

  public List<Course> searchCourseList() {
    return repository.searchCourses().stream()
        .filter(course -> course.getCourseName().contains("情報"))
        .collect(Collectors.toList());
  }
}
