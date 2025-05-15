package singleton;

public class SingletonService {
    //자기 자신을 스태틱으로 가지고 있음..?
    //이해 안가면 자바 기본 스태틱 영역에 대해서 공부해보라고 함
    // static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();


    //public으로 열어서 객체 인스턴스가 필요하면 이 static 매서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

