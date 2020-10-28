package com.leszeksz.passwordmanager.passwordGenerator;

import org.passay.*;

import java.util.Arrays;
import java.util.List;

public class Generator {

    public static String generateRandomPassword() {

        List rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1));

        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(10, rules);
        return password;
    }

}
