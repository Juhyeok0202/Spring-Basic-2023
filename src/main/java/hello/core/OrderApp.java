package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member memberB = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(memberB);

        Order orderA = orderService.createOrder(memberA.getId(), "itemA", 20000);
        Order orderB = orderService.createOrder(memberB.getId(), "itemA", 20000);

        System.out.println(orderA+ "\n" + orderA.calculatePrice());
        System.out.println(orderB+ "\n" + orderB.calculatePrice());
    }
}
