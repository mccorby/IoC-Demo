package ioc_container;

/**
 * This class is a Template method, a way of implementing IoC.
 * This class can be easily extended by clients to force the check of preconditions and post-conditions of a process
 * The template method itself requires the injection (DI) of a logger object
 */
public abstract class CheckableRule {

    abstract protected boolean preExecution();
    abstract protected void executeBody();
    abstract protected boolean postExecution();

    /**
     *
     * @param logger
     */
    final void execute(Logger logger) {
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
