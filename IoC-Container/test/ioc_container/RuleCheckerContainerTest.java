package ioc_container;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RuleCheckerContainerTest {

    @Mock
    private Logger mockLogger;
    private RuleCheckerContainer cut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cut = new RuleCheckerContainer(mockLogger);
    }

    @Test
    public void testInitExecutesRules() {
        // Given
        CheckableRule rule1 = mock(CheckableRule.class);
        CheckableRule rule2 = mock(CheckableRule.class);

        // When
        cut.addRule(rule1);
        cut.addRule(rule2);

        // Then
        verify(rule1).execute(mockLogger);
        verify(rule2).execute(mockLogger);
    }
}