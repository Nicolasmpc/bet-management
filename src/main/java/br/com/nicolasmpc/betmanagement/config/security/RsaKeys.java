package br.com.nicolasmpc.betmanagement.config.security;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class RsaKeys {

    private final RSAPublicKey rsaPublicKey;
    private final RSAPrivateKey rsaPrivateKey;

    public RsaKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");

        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        this.rsaPrivateKey = (RSAPrivateKey) kp.getPrivate();
        this.rsaPublicKey = (RSAPublicKey) kp.getPublic();

    }

    public RSAPublicKey getRsaPublicKey() {
        return rsaPublicKey;
    }
    public RSAPrivateKey getRsaPrivateKey() {
        return rsaPrivateKey;
    }
}
