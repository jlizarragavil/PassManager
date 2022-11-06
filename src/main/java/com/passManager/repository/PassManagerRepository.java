package com.passManager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.passManager.model.PassManager;

public interface PassManagerRepository extends JpaRepository<PassManager, Long>{
	  List<PassManager> findByUser(String owner);

}
