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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CourtRepositoryTest {

    @Autowired
    private CourtRepository courtRepository;

    @Test
    @DirtiesContext
    public void test_should_return_court_when_create_a_court() {
        //given
        Court court = new Court();
        court.setName("Court");

        //when
        Court result = courtRepository.save(court);

        //then
        Assertions.assertEquals("Court", result.getName());
    }

    @Test
    @DirtiesContext
    public void test_should_throw_exception_when_create_a_case_message() {
        //given

        assertThrows(Exception.class, () -> {
            courtRepository.saveAndFlush(new Court());
        });
    }

    @Test
    @DirtiesContext
    public void test_should_return_court_when_find_the_court_by_id () {
        //given
        Court court = new Court();
        court.setName("Court");


        //when
        Court court1 = courtRepository.save(court);

        //then
        Court result = courtRepository.findById(court1.getId()).orElse(null);
        Assertions.assertNotNull(result);

    }


}