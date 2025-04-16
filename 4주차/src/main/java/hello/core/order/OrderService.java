package hello.core.order;

public interface OrderService {
    /**
     * 클라이언트가 주문을 생성할 때 회원id 상품명 상품가격을 return으로 넘거야 한다.
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
