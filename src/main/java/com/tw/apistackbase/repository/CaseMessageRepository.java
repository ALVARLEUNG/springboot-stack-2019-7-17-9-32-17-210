package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CaseMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseMessageRepository extends JpaRepository<CaseMessage, Long> {

}
