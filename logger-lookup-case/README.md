# logger-lookup-case

## Motivation

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
