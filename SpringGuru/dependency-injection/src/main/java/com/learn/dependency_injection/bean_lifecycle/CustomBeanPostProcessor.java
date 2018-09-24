package com.learn.dependency_injection.bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Nullable @Override public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof BeanLifecycleExample) {
			((BeanLifecycleExample) bean).beforeInit();
		}
		return bean;
	}

	@Nullable @Override public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof BeanLifecycleExample) {
			((BeanLifecycleExample) bean).afterInit();
		}
		return bean;
	}
}
