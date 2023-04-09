package com.example.springsource.PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.DependsOn;

@DependsOn
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    static {
        System.out.println("BeanFactoryPostProcess#static");
    }

    public MyBeanFactoryPostProcessor() {
        System.out.println("MyBeanFactoryPostProcessor#new");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition beanDefinition =(AbstractBeanDefinition) beanFactory.getBeanDefinition("autowiredTypeUser");
        beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        beanDefinition.setDependsOn();
        System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory");
    }
}
