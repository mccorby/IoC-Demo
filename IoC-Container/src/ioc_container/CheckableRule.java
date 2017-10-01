package ioc_container;

/**
 * This class is a Template method, a way of implementing IoC.
 * This class can be easily extended by clients to force the check of preconditions and post-conditions of a process
 * The template method itself requires the injection (DI) of a logger object
 */
public abstract class CheckableRule {

    /**
     * Defines if this rule complies with a set of preconditions
     * @return <code>true</code> if the rule complies with the preconditions; <code>false</code>
     */
    abstract protected boolean preExecution();

    /**
     * Defines the main process of this rule
     */
    abstract protected void executeBody();

    /**
     * Defines if this rule complies with a set of post-conditions
     * @return <code>true</code> if the rule complies with the post-conditions; <code>false</code>
     */
    abstract protected boolean postExecution();

    /**
     * Implementation of the Template method.
     *
     * @param logger a client-provided logger to communicate the process of the execution
     */
    public final void execute(Logger logger) {
        if (!preExecution()) {
            logger.logMessage(toString() + ": Precondition not satisfied. Canceling execution");
            return;
        }
        executeBody();
        if (!postExecution()) {
            logger.logMessage(toString() + " Post-condition not satisfied. Canceling execution");
            return;
        }
        logger.logMessage(toString() + " Rule correct");
    }
}
