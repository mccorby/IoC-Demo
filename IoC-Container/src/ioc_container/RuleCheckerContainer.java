package ioc_container;

/**
 * This class represents a container that can be used by third-parties to analise and execute rules
 *
 * Classes implementing this contract are responsible for providing the execution mechanism
 */
public interface RuleCheckerContainer {

    /**
     * Adds a new rule to the container
     * @param rule the rule to be executed
     */
    void addRule(CheckableRule rule);
}
