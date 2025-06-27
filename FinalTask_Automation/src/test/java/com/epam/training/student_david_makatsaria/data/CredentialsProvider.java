package com.epam.training.student_david_makatsaria.data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CredentialsProvider {
    public static Stream<Arguments> acceptedCredentials() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("problem_user", "secret_sauce")
        );
    }
}