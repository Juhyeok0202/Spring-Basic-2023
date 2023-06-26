package hello.core.member;

public class MemberServuceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override

    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return null;
    }
}
