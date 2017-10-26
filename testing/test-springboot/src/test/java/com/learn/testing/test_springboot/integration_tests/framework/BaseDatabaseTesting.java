package com.learn.testing.test_springboot.integration_tests.framework;

import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

@Transactional
@Sql(value ="/setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value ="/ceanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public interface BaseDatabaseTesting extends BaseTesting {
}
