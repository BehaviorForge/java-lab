package lab.lookup.cases;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseLoggerCase {
    final Logger baseLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
}