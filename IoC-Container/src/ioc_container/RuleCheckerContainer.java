package ioc_container;

import java.util.ArrayList;
import java.util.List;

public class RuleCheckerContainer {

    private List<CheckableRule> ruleList;
    private Logger logger;

    public RuleCheckerContainer(Logger logger) {

        this.logger = logger;
        init();
    }

    private void init() {
        logger.logMessage("Container. Doing initialisation operations");
        if (ruleList == null) {
            ruleList = new ArrayList<>();
        }

        logger.logMessage("Container. Init finished. Waiting for rules to process!");
    }

    public void addRule(CheckableRule rule) {
        ruleList.add(rule);
        triggerRuleExecution(rule);
    }

    private void triggerRuleExecution(CheckableRule rule) {
        rule.execute(logger);
        doStuffAfterExecutingOneRule(rule);
    }

    private void doStuffAfterExecutingOneRule(CheckableRule rule) {
        logger.logMessage("Container. Doing stuff after executing rule " + rule.toString());
    }
}
