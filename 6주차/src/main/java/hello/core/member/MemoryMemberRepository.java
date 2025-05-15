package hello.core.member;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //해시맵도 동시성 이슈 때문에
    //ConcurrentHashMap을 써야한다 원래는. 근데 역시 예제니까 복잡해지지 않으려고 그냥 씀.


    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //Map 자료형에 데이터를 넣는 방법이 put.
    }
//원래는 이 put get 부분에서 오류처리를 해줘야 하지만 지금은 예제니까 패스
    @Override
    public Member findById(Long memberID) {
        return store.get(memberID);
    }
}
