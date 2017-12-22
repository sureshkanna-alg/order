package in.javahome.orders;

import java.util.HashMap;
import java.util.Map;
public class OrderService {
	private static Map<Integer, String> orders = new HashMap<>();
	static {
		orders.put(1, "Derivatives");
		orders.put(2, "REPOS");
		orders.put(3, "ReverseRepo");
	}
	public static String getOrder(int orderId) {
		if(!orders.containsKey(orderId)) {
			return "Order with "+orderId+" not found";
		}
		return orders.get(orderId);
	}
}
