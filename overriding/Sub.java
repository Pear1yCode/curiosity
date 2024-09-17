package overriding;

public class Sub extends Super {
    // 오버라이딩 숙지를 위한 자식 클래스 - extends Super를 통해 자식 클래스를 부모 클래스에 연결해준다.

    @Override // 해당 명령어를 통해 오버라이딩이 성공적으로 적용 됐는지 확인한다. // 자식 클래스에서 오버라이딩을 사용하는 것이므로 당연히 자식클래스에서만 사용
    public void plus (int num) {
        num += 2;
    }
}
