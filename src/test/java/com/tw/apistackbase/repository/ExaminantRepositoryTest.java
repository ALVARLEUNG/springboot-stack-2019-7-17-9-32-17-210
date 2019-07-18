package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.model.Court;
import com.tw.apistackbase.model.Examinant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ExaminantRepositoryTest {
    @Autowired
    private ExaminantRepository examinantRepository;

    @Test
    @DirtiesContext
    public void test_should_return_examinant_when_create_a_examinant() {
        //given
        Examinant examinant = new Examinant();
        examinant.setName("Examinant");

        //when
        Examinant result = examinantRepository.save(examinant);

        //then
        Assertions.assertEquals("Examinant", result.getName());
    }

    @Test
    @DirtiesContext
    public void test_should_throw_exception_when_create_a_examinant_given_no_name() {
        //given

        assertThrows(Exception.class, () -> {
            examinantRepository.saveAndFlush(new Examinant());
        });
    }

    @Test
    @DirtiesContext
    public void test_should_return_examinant_when_find_the_examinant_by_id () {
        //given
        Examinant examinant = new Examinant();
        examinant.setName("Examinant");


        //when
        Examinant examinant1 = examinantRepository.save(examinant);

        //then
        Examinant result = examinantRepository.findById(examinant1.getId()).orElse(null);
        Assertions.assertNotNull(result);

    }



}