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

import static org.junit.jupiter.api.Assertions.assertThrows;

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
        criminalCase.getId();
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
        criminalCase.getId();
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
        criminalCase.getId();
        criminalCase.setTime((long) 102011);
        criminalCase.setName("criminalCase");

        //when
         criminalCaseRepository.save(criminalCase);

        //then
        CriminalCase criminalCase1 = criminalCaseRepository.findById(criminalCaseRepository.save(criminalCase).getId()).orElse(null);
        Assertions.assertNotNull(criminalCase1);

    }



}

