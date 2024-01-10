package com.lab.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lab.converter.StudentConverter;
import com.lab.dto.StudentDTO;
import com.lab.entity.StudentEntity;
import com.lab.repository.StudentRepository;
import com.lab.service.IStudentService;
@Service
public class StudentService implements IStudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentConverter studentConverter;
	
	@Override
	public StudentDTO insert(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return studentConverter.toDto(studentRepository.save(studentConverter.toEntity(studentDTO)));
	}

	@Override
	public List<StudentDTO> findAll(Pageable pageable) {
		List<StudentDTO> studentDTOs = new ArrayList<>();
		List<StudentEntity> studentEntities = studentRepository.findAll(pageable).getContent();
		for (StudentEntity studentEntity : studentEntities) {
			studentDTOs.add(studentConverter.toDto(studentEntity));
		}
		return studentDTOs;
	}

	@Override
	public Integer getTotalItem() {
		// TODO Auto-generated method stub
		return (int) studentRepository.count();
	}

	@Override
	public List<StudentDTO> searchStudentByKeyword(String query) {
		List<StudentDTO> studentDTOs = new ArrayList<>();
		List<StudentEntity> studentEntities = studentRepository.searchStudentByKeyword(query);
		for (StudentEntity studentEntity : studentEntities) {
			studentDTOs.add(studentConverter.toDto(studentEntity));
		}
		return studentDTOs;
	}

	@Override
	public StudentDTO findByID(Long studentIdCard) {
		// TODO Auto-generated method stub
		return studentConverter.toDto(studentRepository.findOne(studentIdCard));
	}

	@Override
	public List<StudentDTO> searchStudentDetailsByKeyword(String search) {
		List<StudentDTO> studentDTOs = new ArrayList<>();
		List<StudentEntity> studentEntities = studentRepository.searchStudentDetailsByKeyword(search);
		for (StudentEntity studentEntity : studentEntities) {
			studentDTOs.add(studentConverter.toDto(studentEntity));
		}
		return studentDTOs;
	}

}
