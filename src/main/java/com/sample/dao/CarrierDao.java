package com.sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.Carriers;

@Repository
public interface CarrierDao extends JpaRepository<Carriers, String> {

	List<Carriers> findByStatus(String name);

}
