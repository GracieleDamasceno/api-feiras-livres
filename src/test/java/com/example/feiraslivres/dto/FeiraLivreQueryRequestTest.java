package com.example.feiraslivres.dto;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class FeiraLivreQueryRequestTest {

    @Test
    void testFeiraLivreQueryRequestTO() {
        assertPojoMethodsFor(FeiraLivreQueryRequest.class).testing(Method.GETTER, Method.TO_STRING).areWellImplemented();
    }
}