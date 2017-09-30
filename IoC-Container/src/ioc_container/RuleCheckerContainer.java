package ioc_container;

import java.util.ArrayList;
import java.util.List;

public class RuleCheckerContainer {

    private List<CheckableRule> ruleList;
    private Logger logger;

    public RuleCheckerContainer(Logger logger) {

        this.logger = logger;
    }

    public void addRule(CheckableRule rule) {
        if (ruleList == null) {
            ruleList = new ArrayList<>();
        }
        ruleList.add(rule);
    }

    public void init() {
        doStuffBeforeExecutingRules();
        for (CheckableRule rule: ruleList) {
            rule.execute(logger);
            doStuffAfterExecutingOneRule(rule);
        }
        doMoreStuffAfterExecutionAllRules();
    }

    private void doMoreStuffAfterExecutionAllRules() {
        logger.logMessage("Container. Doing more stuff after executing all rules");
    }

    private void doStuffAfterExecutingOneRule(CheckableRule rule) {
        logger.logMessage("Container. Doing stuff after executing rule " + rule.toString());
    }

    private void doStuffBeforeExecutingRules() {
        logger.logMessage("Container. Doing stuff before executing the rules");
    }
}
