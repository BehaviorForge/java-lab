package lab.lookup.cases;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NormalLoggerCase {
    final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
}
