package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    //XML기반의 appConfig.xml 스프링 설정 정보를 읽는 것이 annotationConfig보다 컴파일 없이 설정 정보
    //변경이 가능하므로 빠르다. 하지만, 애노테이션를 통한 설정 정보 빈 컨테이너 등록이 더 자주 쓰임. 알아두자.
    //스프링이 이렇게 유연하게 설정 정보 등록이 가능하다(이것들은 모두 DIP를 지키기 위함이다.)
    @Test
    void smlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
