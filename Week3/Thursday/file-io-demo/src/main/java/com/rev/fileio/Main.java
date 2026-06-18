package com.rev.fileio;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // 1. Creating Optionals
        Optional<String> name = Optional.of("Oscar");
        Optional<String> emptyName = Optional.empty();
        Optional<String> nullableName = Optional.ofNullable(null);

        // 2. Checking if value exists
        if (name.isPresent()) {
            System.out.println("Name exists: " + name.get());
        }

        // 3. Default value if empty
        String result = emptyName.orElse("Default User");
        System.out.println(result);

        // 4. Lazy default (only runs if empty)
        String lazyResult = emptyName.orElseGet(() -> "Generated User");
        System.out.println(lazyResult);

        // 5. Throw exception if empty
        try {
            String value = nullableName.orElseThrow(
                () -> new RuntimeException("No name found!")
            );
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // 6. Transform value
        Optional<Integer> length = name.map(String::length);
        System.out.println("Length: " + length.get());

        // 7. Filter values
        Optional<String> filtered = name.filter(n -> n.startsWith("O"));
        System.out.println(filtered.orElse("No match"));

        // 8. Run code only if present
        name.ifPresent(n -> System.out.println("Hello " + n));
    }
}