package com.learn.repository;

import com.learn.RedisApplication;
import com.learn.RedisConfig;
import com.learn.TestConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mshalabi on 10.08.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class, RedisConfig.class})
public class GettingPerson {
}
