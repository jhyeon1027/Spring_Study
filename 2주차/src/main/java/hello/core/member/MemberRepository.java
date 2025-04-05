package hello.core.member;

public interface MemberRepository {
    void save(Member member); //회원을 저장하는 메서드

    Member findById(Long memberID); //회원의 ID로 회원을 찾는 기능.

}