package hw;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(~(-1));
        System.out.println(~(1));
        System.out.println(~(0));
        // System.out.println(check(true));
        // System.out.println(check(false));
        // System.out.printf("%.4f", 1.0);
        // new Test().testMapPQ();
    }

    public static String check(Boolean flag) {
        try {
            return "假";
        } finally {
            if (flag) {
                return "真";
            }
        }
    }

    public void testMapPQ() {
        Map<String, ACRequest> waitingMap = new HashMap<>();
        ACRequest r1 = ACRequest.builder().userId("12").price("123").build();
        waitingMap.put(r1.getUserId(), r1);
        ACRequest r2 = ACRequest.builder().userId("11").price("333").build();
        waitingMap.put(r2.getUserId(), r2);
        PriorityQueue<String> requestQueue = new PriorityQueue<>((e1, e2) -> {
            ACRequest o1 = waitingMap.get(e1);
            ACRequest o2 = waitingMap.get(e2);
            if (!Objects.equals(o1.getPrice(), o2.getPrice())) {
                return ~(new BigDecimal(o1.getPrice()).compareTo(new BigDecimal(o2.getPrice())));
            }
            return 0;
        });
        requestQueue.add("12");
        System.out.println(requestQueue.peek());
        requestQueue.add("11");
        System.out.println(requestQueue.peek());
        ACRequest r3 = ACRequest.builder().userId("12").price("999").build();
        waitingMap.put(r3.getUserId(), r3);
        requestQueue.removeIf((e) -> Objects.equals(e, "12"));
        requestQueue.add("12");
        System.out.println(requestQueue.peek());
        System.out.println(requestQueue.size());
    }
}

class ACRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String price; // 加个

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ACRequest acRequest = (ACRequest) o;
        return Objects.equals(userId, acRequest.userId);
    }

    public static class builder {
        private ACRequest acRequest = new ACRequest();

        public ACRequest.builder userId(String id) {
            this.acRequest.setUserId(id);
            return this;
        }

        public ACRequest.builder price(String _price) {
            this.acRequest.setPrice(_price);
            return this;
        }

        public ACRequest build() {
            return this.acRequest;
        }
    }

    public static ACRequest.builder builder() {
        return new ACRequest.builder();
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
    }

    public void setPrice(String _price) {
        this.price = _price;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getPrice() {
        return this.price;
    }
}
