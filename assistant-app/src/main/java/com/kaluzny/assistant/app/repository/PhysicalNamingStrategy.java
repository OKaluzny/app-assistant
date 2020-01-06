package com.kaluzny.assistant.app.repository;

import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 *
 *
 * @author Oleg Kaluzny
 */
public class PhysicalNamingStrategy extends SpringPhysicalNamingStrategy {
    private static final String PREFIX = "ms_";

    private static Identifier appendPrefix(Identifier identifier) {
        String name = identifier.getText();
        String nameWithPrefix = name.startsWith(PREFIX) ? name : PREFIX + name;
        return Identifier.toIdentifier(nameWithPrefix);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return super.toPhysicalTableName(appendPrefix(identifier), jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return super.toPhysicalSequenceName(appendPrefix(identifier), jdbcEnvironment);
    }
}
