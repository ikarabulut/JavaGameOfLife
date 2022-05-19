package com.ikarabulut;

public class RulesFactory {

    public RuleSet getRules(int ruleSelection) throws InvalidRuleSelectionException {
        return switch (ruleSelection) {
            case 1 -> new DefaultRules1();
            case 2 -> new Rules2();
            default -> throw new InvalidRuleSelectionException("No rule set found with the selection of: " + ruleSelection + " Please try again: ");
        };
    }

}
