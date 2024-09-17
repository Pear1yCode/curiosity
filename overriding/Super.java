package overriding;

public class Super {
// 오버라이딩 숙지를 위한 부모 클래스 생성

    // 부모 클래스에 몇개의 메소드 생성 => 자식 클래스에서 사용하기 위함

    public void plus (int num) {
        num += 1;
    }

    public void minus (int num) {
        num -= 1;
    }

    public void multiply (int num) {
        num *= 2;
    }

    public void divide (int number) {
        number /= 2;
    }

    public void remain (int number) {
        number %= 2;
    }

    public void method () {}

    private void priMethod () {};

    public final void finalMethod () {};

    protected void proMethod() {};
}
