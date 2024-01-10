package com.lab.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lab.converter.BranchConverter;
import com.lab.dto.BranchDTO;
import com.lab.entity.BranchEntity;
import com.lab.repository.BranchRepository;
import com.lab.service.IBranchService;


@Service
public class BranchService implements IBranchService {

	@Autowired
	BranchRepository branchRepository;
	@Autowired
	BranchConverter branchConverter;
	
	@Override
	public BranchDTO insert(BranchDTO branchDTO) {
		// TODO Auto-generated method stub
		return branchConverter.toDto(branchRepository.save(branchConverter.toEntity(branchDTO)));
	}

	@Override
	public List<BranchDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<BranchDTO> branchDTOs = new ArrayList<>();
		List<BranchEntity> branchEntities = branchRepository.findAll(pageable).getContent();
		for (BranchEntity branchEntity : branchEntities) {
			branchDTOs.add(branchConverter.toDto(branchEntity));
		}
		return branchDTOs;
	}

	@Override
	public Integer getTotalItem() {
		// TODO Auto-generated method stub
		return (int) branchRepository.count();
	}

	@Override
	public BranchDTO findByID(Integer branchIdWork) {
		// TODO Auto-generated method stub
		return branchConverter.toDto(branchRepository.findOne(branchIdWork));
	}

}
