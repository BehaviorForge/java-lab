package lab.lookup.cases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerNameBehaviorTest {

    @Test
    void abstractBaseAndImplementation_haveDifferentLoggerNames() {
        DerivedLoggerCase implementation = new DerivedLoggerCase();

        assertEquals("lab.lookup.cases.BaseLoggerCase", implementation.baseLogger.getName());
        assertEquals("lab.lookup.cases.DerivedLoggerCase", implementation.implementationLogger.getName());
    }

    @Test
    void normalClass_loggerUsesNormalClassName() {
        NormalLoggerCase normal = new NormalLoggerCase();

        assertEquals("lab.lookup.cases.NormalLoggerCase", normal.logger.getName());
    }
}
