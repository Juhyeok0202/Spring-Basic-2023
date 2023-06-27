package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    //스프링 빈은 항상 stateLess로 개발하자.⭐⭐⭐⭐
    @Test
    void statefulServiceSingleton() {   //싱글톤 방식의 주의점 고려 안한 경우
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //ThreadB: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //Expected: 10000
        // actual: 20000
//        int price = statefulService1.getPrice();    //같은 인스턴스를 사용하므로
        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);


//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
//따라서, 싱글톤 방식은 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
        //
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}