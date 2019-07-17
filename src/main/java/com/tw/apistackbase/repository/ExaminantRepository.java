package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Examinant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminantRepository extends JpaRepository<Examinant, Long> {

}
