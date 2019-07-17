package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriminalCaseRepository extends JpaRepository<CriminalCase, Long> {

//    @Query(value = "select * from criminalCase order by time desc ", nativeQuery = true)
    List<CriminalCase> findAllByOrderByTimeDesc();

    List<CriminalCase> findAllByName(String name);
}
