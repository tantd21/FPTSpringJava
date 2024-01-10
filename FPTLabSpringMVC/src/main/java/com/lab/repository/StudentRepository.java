package com.lab.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.lab.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	 @Query("SELECT s FROM StudentEntity s WHERE " +
	           "LOWER(s.studentName) LIKE LOWER(concat('%', :keyword, '%')) OR " +
	           "LOWER(s.studentEmail) LIKE LOWER(concat('%', :keyword, '%')) OR " +
	           "LOWER(s.studentPhone) LIKE LOWER(concat('%', :keyword, '%')) OR " +
	           "LOWER(s.studentAddress) LIKE LOWER(concat('%', :keyword, '%')) OR " +
	           "CAST(s.studentIdCard AS string) LIKE LOWER(concat('%', :keyword, '%'))")
	    List<StudentEntity> searchStudentByKeyword(@Param("keyword") String keyword);
	 
	 @Query("SELECT DISTINCT s FROM StudentEntity s " +
			   "LEFT JOIN s.graduateList graduate " +
			   "LEFT JOIN graduate.school school " +
		       "LEFT JOIN s.workList work " +
		       "LEFT JOIN work.branch branch " +
		       "WHERE LOWER(s.studentName) LIKE LOWER(concat('%', :keyword, '%')) OR " +
		       "LOWER(s.studentEmail) LIKE LOWER(concat('%', :keyword, '%')) OR " +
		       "LOWER(s.studentPhone) LIKE LOWER(concat('%', :keyword, '%')) OR " +
		       "LOWER(s.studentAddress) LIKE LOWER(concat('%', :keyword, '%')) OR " +
		       "CAST(s.studentIdCard AS string) LIKE LOWER(concat('%', :keyword, '%')) OR " +
		       "LOWER(school.schoolName) LIKE LOWER(concat('%', :keyword, '%')) OR "+
		       "LOWER(work.workCompanyName) LIKE LOWER(concat('%', :keyword, '%')) OR "+
		       "LOWER(branch.branchName) LIKE LOWER(concat('%', :keyword, '%')) ")
		List<StudentEntity> searchStudentDetailsByKeyword(@Param("keyword") String keyword);	 
}
