package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.model.CaseMessage;
import com.tw.apistackbase.model.Court;
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

    @Test
    @DirtiesContext
    public void test_should_throw_exception_when_create_a_case_message() {
        //given
        CaseMessage caseMessage = new CaseMessage();
        caseMessage.setMainDescription("main description");

        assertThrows(Exception.class, () -> {
            caseMessageRepository.saveAndFlush(caseMessage);
        });
    }

    @Test
    @DirtiesContext
    public void test_should_return_case_message_when_find_the_case_by_id () {
        //given
        CaseMessage caseMessage = new CaseMessage();
        caseMessage.setMainDescription("main description");
        caseMessage.setMinorDescription("minor description");


        //when
        CaseMessage caseMessage1 = caseMessageRepository.save(caseMessage);

        //then
        CaseMessage caseMessage2 = caseMessageRepository.findById(caseMessage1.getId()).orElse(null);
        Assertions.assertNotNull(caseMessage2);

    }

    @Test
    @DirtiesContext
    public void test_should_return_case_message_include_criminal_case_when_find_all_cases () {
        //given
        CaseMessage caseMessage = new CaseMessage();
        caseMessage.setMainDescription("main description");
        caseMessage.setMinorDescription("minor description");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase");
        caseMessage.setCriminalCase(criminalCase);


        //when
        CaseMessage caseMessage1 = caseMessageRepository.save(caseMessage);

        //then
        List<CaseMessage> caseMessages = caseMessageRepository.findAll();
        Assertions.assertNotNull(caseMessages.get(0).getCriminalCase());

    }

    @Test
    @DirtiesContext
    public void test_should_return_case_message_include_court_when_find_all_cases () {
        //given
        CaseMessage caseMessage = new CaseMessage();
        caseMessage.setMainDescription("main description");
        caseMessage.setMinorDescription("minor description");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase");
        caseMessage.setCriminalCase(criminalCase);
        Court court = new Court();
        court.setName("Court");
        caseMessage.setCourt(court);


        //when
        CaseMessage caseMessage1 = caseMessageRepository.save(caseMessage);

        //then
        List<CaseMessage> caseMessages = caseMessageRepository.findAll();
        Assertions.assertNotNull(caseMessages.get(0).getCourt());

    }


}