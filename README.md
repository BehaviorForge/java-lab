# java-lab

A collection of focused Java behavior demonstrations.

## Cases

- [Logger lookup class names](logger-lookup-case/README.md)
  - Demonstrates how logger names differ when created in an abstract base class versus a concrete implementation.

## Running all cases

```bash
mvn test
```

## Adding future cases

1. Create a new top-level module at `<case-name>/`.
2. Add a `README.md` explaining motivation and what behavior is demonstrated.
3. Register the module in the root `pom.xml` and link it from this README.
