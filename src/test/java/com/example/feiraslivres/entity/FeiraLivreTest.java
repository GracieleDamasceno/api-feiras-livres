package com.example.feiraslivres.entity;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class FeiraLivreTest {

    @Test
    void testFeiraLivreDTO() {
        assertPojoMethodsFor(FeiraLivre.class).testing(Method.GETTER, Method.SETTER,
                Method.TO_STRING, Method.CONSTRUCTOR, Method.HASH_CODE, Method.EQUALS).areWellImplemented();
    }
}