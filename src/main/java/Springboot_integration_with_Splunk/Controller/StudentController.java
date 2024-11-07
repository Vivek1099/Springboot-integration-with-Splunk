package Springboot_integration_with_Splunk.Controller;

import Springboot_integration_with_Splunk.Entity.Student;
import Springboot_integration_with_Splunk.Repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController
{
    @Autowired
    Repository srepo;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/test")
    public String testcase()
    {
        logger.info("Splunk test Application Started");
        return "This is basic splunk test";
    }

    @PostMapping("/save")
    public String SAVE(@RequestBody Student student)
    {
        logger.info("saving the data of the students");
        srepo.save(student);
        return "Data saved";
    }

    @GetMapping("/show")
    public List<Student> SHOW()
    {
        List<Student> studentList = srepo.findAll();
        logger.info("retreving all students data "+studentList);
        return studentList;
    }

    @GetMapping("/byid/{sid}")
    public Optional<Student> ByID(@PathVariable int sid)
    {
        logger.info("retreving students data by specific student id ");
        return srepo.findById(sid);
    }

    @PutMapping("/update/{sid}")
    public Student update(@RequestBody Student student, @PathVariable int sid)
    {
        logger.info("Data update of student ");
        Student s = srepo.findById(sid).get();
        s.setSname(student.getSname());
        s.setScity(student.getScity());
        logger.info("Student data updated");
        srepo.save(s);
        return s;
    }

    @DeleteMapping("/delete/{sid}")
    public String delete(@PathVariable int sid)
    {
        logger.info("Deleting student data");
        srepo.deleteById(sid);
        return "Data Deleted";
    }



}
