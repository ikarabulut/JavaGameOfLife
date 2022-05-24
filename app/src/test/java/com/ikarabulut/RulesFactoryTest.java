package com.ikarabulut;

import com.ikarabulut.Exceptions.InvalidRuleSelectionException;
import com.ikarabulut.Rules.*;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;

class RulesFactoryTest {

    @Test
    @DisplayName("When 1 is passed in to getRules, then the return will be a new DefaultRules class object")
    void getRules_pass1() throws InvalidRuleSelectionException {
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

    @Test
    @DisplayName("When 3 is passed in to getRules, then the return will be a new ComeAliveWithTwo class object")
    void getRules_pass3() throws InvalidRuleSelectionException{
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(3);

        MatcherAssert.assertThat(returnValue, instanceOf(ComeAliveWithTwo.class));
    }

    @Test
    @DisplayName("When 4 is passed in to getRules, then the return will be a new ComeAliveRandomly class object")
    void getRules_pass4() throws InvalidRuleSelectionException{
        RulesFactory factory = new RulesFactory();
        RuleSet returnValue = factory.getRules(4);

        MatcherAssert.assertThat(returnValue, instanceOf(ComeAliveRandomly.class));
    }

}
