# logger-lookup-case

## Motivation

What happens when you use `MethodHandles.lookup().lookupClass()` to name your logger, and what breaks your intuition once inheritance gets involved?

Consider this shape first:

```java
abstract class BaseLoggerCase {
   protected final Logger baseLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
}

final class DerivedLoggerCase extends BaseLoggerCase {
   private final Logger implementationLogger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

   void logBoth() {
      baseLogger.info("from base logger");
      implementationLogger.info("from implementation logger");
   }
}
```

Which class names do you expect to show up in the logs?

```text
[main] INFO lab.lookup.cases.BaseLoggerCase - from base logger
[main] INFO lab.lookup.cases.DerivedLoggerCase - from implementation logger
```

If that is not what your intuition predicted, review the code and run the module to prove it to yourself.

`MethodHandles.lookup().lookupClass()` returns the class where the call site is declared, not the runtime class of the instance.

This becomes confusing with logger initialization in inheritance hierarchies:

- A logger created in an abstract base class gets the base class name.
- Even when accessed from a concrete implementation instance, that inherited logger still keeps the base class name.
- A logger created directly in the implementation gets the implementation class name.

This module isolates that behavior in minimal tests so the naming difference is easy to see.

## Demonstrated scenarios

1. Abstract base + implementation with two loggers:
   - `baseLogger` declared in `BaseLoggerCase`.
   - `implementationLogger` declared in `DerivedLoggerCase`.
2. Normal class with a single logger:
   - `logger` declared in `NormalLoggerCase`.

## Run this case

```bash
mvn -pl logger-lookup-case test
```
