package ch.h2m.backend;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public Hello get() {
        return new Hello("heinz", "foo bar");
    }
}
