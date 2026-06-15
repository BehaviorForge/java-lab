package lab.lookup.cases;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DerivedLoggerCase extends BaseLoggerCase {
    final Logger implementationLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
}