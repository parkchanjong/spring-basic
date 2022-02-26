package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
              .forEach(beanDefinitionName -> {
                  Object bean = ac.getBean(beanDefinitionName);
                  System.out.println("name=" + beanDefinitionName + " object=" + bean);
              });
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames)
              .forEach(beanDefinitionName -> {
                  BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
                  if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                      Object bean = ac.getBean(beanDefinitionName);
                      System.out.println("name=" + beanDefinitionName + " object=" + bean);
                  }
              });
    }

}
