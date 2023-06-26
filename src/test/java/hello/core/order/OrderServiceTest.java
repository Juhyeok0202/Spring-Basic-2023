package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServuceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServuceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        Member memberB = new Member(2L, "memberB", Grade.BASIC);

        //when
        memberService.join(memberA);
        memberService.join(memberB);

        Order orderA = orderService.createOrder(memberA.getId(), "itemA", 10000);
        Order orderB = orderService.createOrder(memberB.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(orderA.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(orderB.getDiscountPrice()).isEqualTo(0);

    }
}
