package com.study.spring.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.Test;

class JasyptConfigAESTest {

    @Test
    void stringEncryptor() {
        String username = "ranTest";
        String password = "Eodfks$$2022";
        System.out.println("username: " + jasyptEncoding(username));
        System.out.println("password: " + jasyptEncoding(password));
    }

    public String jasyptEncoding(String value) {
        String key = "property_key";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        encryptor.setPassword(key);
        encryptor.setIvGenerator(new RandomIvGenerator());
        return encryptor.encrypt(value);
    }


}