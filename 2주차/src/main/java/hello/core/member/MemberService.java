package hello.core.member;

public interface MemberService {

    void join(Member member); //회원가입

    Member findMember(Long memberID); //회원조회
}
