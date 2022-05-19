package com.ikarabulut;

public class RulesFactory {

    public RuleSet getRules(int ruleSelection) {
        return switch (ruleSelection) {
            case 1 -> new DefaultRules1();
            case 2 -> new Rules2();
            default -> null;
        };
    }

}
