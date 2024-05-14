package com.myFirst.journalApp.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import java.util.stream.Stream;

public class UserArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(com.myFirst.journalApp.entity.User.builder().userName("SII").password("SII").build()),
                Arguments.of(com.myFirst.journalApp.entity.User.builder().userName("SIID").password("SIID").build())
        );
    }
}
