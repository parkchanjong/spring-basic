package hello.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;// 이곳을 무상태로 설계해야 한다
    }

    public int getPrice() {
        return price;
    }
}
