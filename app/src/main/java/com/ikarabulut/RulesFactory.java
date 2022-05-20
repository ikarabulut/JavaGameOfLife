package com.ikarabulut;

public class RulesFactory {

    public RuleSet getRules(int ruleSelection) throws InvalidRuleSelectionException {
        return switch (ruleSelection) {
            case 1 -> new DefaultRules();
            case 2 -> new ComeAliveWithFour();
            case 3 -> new ComeAliveWithTwo();
            case 4 -> new ComeAliveRandomly();
            default -> throw new InvalidRuleSelectionException("No rule set found with the selection of: " + ruleSelection + " Please try again: ");
        };
    }

}
