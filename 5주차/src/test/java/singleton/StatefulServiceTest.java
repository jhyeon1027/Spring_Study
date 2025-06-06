package singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10,000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadA: B사용자 20,000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //A가 주문을 하고 조회를 하는 사이에 B가 주문을 넣은 상황
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}