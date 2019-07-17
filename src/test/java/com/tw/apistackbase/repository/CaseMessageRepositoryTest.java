package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.model.CaseMessage;
import com.tw.apistackbase.model.CriminalCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CaseMessageRepositoryTest {

    @Autowired
    CaseMessageRepository caseMessageRepository;

    @Test
    @DirtiesContext
    public void test_should_return_case_message_when_create_a_case_message() {
        //given
       CaseMessage caseMessage = new CaseMessage();
       caseMessage.setMainDescription("main description");
       caseMessage.setMinorDescription("minor description");

        //when
        CaseMessage caseMessage1 = caseMessageRepository.save(caseMessage);

        //then
        Assertions.assertEquals("main description", caseMessage1.getMainDescription());
    }

}