package raisetech.student.management2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.management2.data.Course;
import raisetech.student.management2.data.Student;
import raisetech.student.management2.service.StudentService;

@RestController
public class StudentController {
  private StudentService service;


  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }


  @GetMapping("/studentList")
  public List<Student> gethStudentList() {
    return service.searchStudentList();

    //サービス層のメソッドを呼び出し。searchStudentList()メソッドを呼び出し、戻り値を返す。<<実際にある
    //return student.getName() + " " + student.getAge() + "歳";
  }

  @GetMapping("/courseList")
  public List<Course> getCourseList() {
    return service.searchCourseList();

  }

}
