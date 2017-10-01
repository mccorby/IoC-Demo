package ioc_container.containers;

import ioc_container.CheckableRule;
import ioc_container.Logger;
import ioc_container.RuleCheckerContainer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This is a simple implementation of a {@link RuleCheckerContainer} that executes the rules as they come.
 *
 */
public class SimpleRuleCheckerContainer implements RuleCheckerContainer {

    private List<CheckableRule> ruleList;
    private Logger logger;

    /**
     * Constructor that requires a logger object.
     * @param logger A logger object provided by the client
     */
    public SimpleRuleCheckerContainer(Logger logger) {

        this.logger = logger;
        init();
    }

    /**
     * Adds a new rule to the container. The container will execute it as it's added
     * @param rule the rule to be executed
     */
    @Override
    public void addRule(CheckableRule rule) {
        ruleList.add(rule);
        triggerRuleExecution(rule);
    }

    private void init() {
        logger.logMessage("Container. Doing initialisation operations");
        if (ruleList == null) {
            ruleList = new ArrayList<>();
        }

        logger.logMessage("Container. Init finished. Waiting for rules to process!");
    }

    private void triggerRuleExecution(CheckableRule rule) {
        rule.execute(logger);
        doStuffAfterExecutingOneRule(rule);
    }

    private void doStuffAfterExecutingOneRule(CheckableRule rule) {
        logger.logMessage("Container. Doing stuff after executing rule " + rule.toString());
    }
}
