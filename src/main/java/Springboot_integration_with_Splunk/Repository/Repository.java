package Springboot_integration_with_Splunk.Repository;

import Springboot_integration_with_Splunk.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Student,Integer>
{
}
