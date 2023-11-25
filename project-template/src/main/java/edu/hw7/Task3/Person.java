package edu.hw7.Task3;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record Person(int id,
                     @NotBlank String name,
                     @NotBlank String address,
                     @NotBlank String phoneNumber) {
}

