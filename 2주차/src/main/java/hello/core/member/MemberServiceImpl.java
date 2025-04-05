package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository() {
    };

    @Override
    public void join(Member member){
        memberRepository.save(member); //여기서 memberRepository는 다형성에 의해 MemoryMR에 있는 save 호출
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
