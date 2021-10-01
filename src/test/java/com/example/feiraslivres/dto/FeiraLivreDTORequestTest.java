package com.example.feiraslivres.dto;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class FeiraLivreDTORequestTest {

    @Test
    void testFeiraLivreDTO() {
        assertPojoMethodsFor(FeiraLivreDTORequest.class).testing(Method.GETTER, Method.SETTER,
                Method.TO_STRING).areWellImplemented();
    }
}