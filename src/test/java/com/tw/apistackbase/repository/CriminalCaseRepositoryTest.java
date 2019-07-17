package com.tw.apistackbase.repository;

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
public class CriminalCaseRepositoryTest {

    @Autowired
    CriminalCaseRepository criminalCaseRepository;


    @Test
    @DirtiesContext
    public void test_should_return_case_when_create_a_case() {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setName("criminalCase");
        criminalCase.setTime((long) 102011);

        //when
        criminalCaseRepository.save(criminalCase);

        //then
        Assertions.assertEquals(Long.valueOf(102011), criminalCase.getTime());
    }

    @Test
    @DirtiesContext
    public void test_should_throw_exception_when_create_a_case() {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setName("criminalCase");

        assertThrows(Exception.class, () -> {
            criminalCaseRepository.saveAndFlush(criminalCase);
        });
    }

    @Test
    @DirtiesContext
    public void test_should_return_case_when_find_the_case_by_id () {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase");

        //when
         criminalCaseRepository.save(criminalCase);

        //then
        CriminalCase criminalCase1 = criminalCaseRepository.findById(criminalCaseRepository.save(criminalCase).getId()).orElse(null);
        Assertions.assertNotNull(criminalCase1);

    }

    @Test
    @DirtiesContext
    public void test_should_return_all_case_when_call_find_all_cases_order_by_DESC () {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase1");

        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setTime((long) 102012);
        criminalCase1.setName("criminalCase2");

        //when
        criminalCaseRepository.save(criminalCase);
        criminalCaseRepository.save(criminalCase1);

        //then
        List<CriminalCase> criminalCases= criminalCaseRepository.findAllByOrderByTimeDesc();
        Assertions.assertEquals(2, criminalCases.size());
        Assertions.assertEquals(Long.valueOf(102012), criminalCases.get(0).getTime());

    }

    @Test
    @DirtiesContext
    public void test_should_return_all_case_when_call_find_all_cases_by_name () {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase1");

        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setTime((long) 102012);
        criminalCase1.setName("criminalCase2");

        //when
        criminalCaseRepository.save(criminalCase);
        criminalCaseRepository.save(criminalCase1);

        //then
        List<CriminalCase> criminalCases= criminalCaseRepository.findAllByName("criminalCase1");
        Assertions.assertEquals("criminalCase1", criminalCases.get(0).getName());
    }

    @Test
    @DirtiesContext
    public void test_should_delete_case_when_call_find_all_cases_by_name () {
        //given
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase1");

        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setTime((long) 102012);
        criminalCase1.setName("criminalCase2");

        //when
        CriminalCase criminalCase2 = criminalCaseRepository.save(criminalCase);
        criminalCaseRepository.save(criminalCase1);

        //then
        criminalCaseRepository.deleteById(Long.valueOf(criminalCase2.getId()));

        List<CriminalCase> criminalCases = criminalCaseRepository.findAll();
        Assertions.assertEquals(1, criminalCases.size());
    }



}

