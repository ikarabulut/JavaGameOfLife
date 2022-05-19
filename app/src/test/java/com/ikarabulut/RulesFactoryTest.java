package com.ikarabulut;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

class RulesFactoryTest {

    @Test
    @DisplayName("When 1 is passed in to getRules, then the return will be a new Rules class object")
    void getRules_pass1() {
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(1);

        MatcherAssert.assertThat(returnValue, instanceOf(DefaultRules1.class));
    }

    @Test
    @DisplayName("When 2 is passed in to getRules, then the return will be a new Rules1 class object")
    void getRules_pass2() {
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(2);

        MatcherAssert.assertThat(returnValue, instanceOf(Rules2.class));
    }

}
