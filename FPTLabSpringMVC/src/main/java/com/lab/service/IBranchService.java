package com.lab.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lab.dto.BranchDTO;


public interface IBranchService {
	BranchDTO insert(BranchDTO branchDTO);
	List<BranchDTO> findAll(Pageable pageable);
	Integer getTotalItem();
	BranchDTO findByID(Integer branchIdWork);
}
