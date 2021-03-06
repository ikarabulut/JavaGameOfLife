package com.ikarabulut;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

class RulesFactoryTest {

    @Test
    @DisplayName("When 1 is passed in to getRules, then the return will be a new DefaultRules class object")
    void getRules_pass1() throws InvalidRuleSelectionException{
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(1);

        MatcherAssert.assertThat(returnValue, instanceOf(DefaultRules.class));
    }

    @Test
    @DisplayName("When 2 is passed in to getRules, then the return will be a new ComeAliveWithFour class object")
    void getRules_pass2() throws InvalidRuleSelectionException{
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(2);

        MatcherAssert.assertThat(returnValue, instanceOf(ComeAliveWithFour.class));
    }

}
