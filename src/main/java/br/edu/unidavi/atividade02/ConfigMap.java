package br.edu.unidavi.atividade02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigMap {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${pessoa.nome}")
    String nome;
    @Value("${pessoa.email}")
    String email;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        logger.debug(nome);
        logger.debug(email);
    }

}
