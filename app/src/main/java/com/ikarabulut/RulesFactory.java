package com.ikarabulut;

public class RulesFactory {

    public RuleSet getRules(int ruleSelection) {
        return switch (ruleSelection) {
            case 1 -> new Rules();
            case 2 -> new Rules1();
            default -> null;
        };
    }

}
