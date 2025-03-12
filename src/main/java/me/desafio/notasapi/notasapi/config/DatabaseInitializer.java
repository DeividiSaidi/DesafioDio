package me.desafio.notasapi.notasapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void verificarBanco() {
        try {
            jdbcTemplate.queryForObject("SELECT 1 FROM aluno LIMIT 1", Integer.class);
            System.out.println("Banco de dados já existe.");
        } catch (Exception e) {
            System.out.println("Banco de dados não encontrado. Criando tabelas...");
            criarBanco();
        }
    }

    private void criarBanco() {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("schema.sql"));
            System.out.println("Banco de dados criado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar banco: " + e.getMessage());
        }
    }
}

