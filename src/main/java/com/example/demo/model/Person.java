/*
    Models:

    Models represent the data structures used within the application. They define the structure,
    attributes, and behavior of the data entities. Models encapsulate the data and provide methods
    to manipulate and access that data.

    Best practices for models include:

    * Designing models based on the domain requirements: Models should accurately represent the concepts
    and entities in the application's domain.

    * Keeping models decoupled from the persistence layer: Models should not have direct dependencies on database or persistence-related code. Use separate entities or data transfer objects (DTOs) for persistence concerns.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
