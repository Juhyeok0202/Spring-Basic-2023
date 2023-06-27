package hello.core.singleton;

public class SingletonService {

    //자기자신이 private static으로 존재하기 떄문에 class level로 존재하여 단 하나만 존재하게 됨.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
