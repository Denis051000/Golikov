package package19;

public class ORDERSERVICE {

    public void placeOrder(CLIENT client) {
        try {
            System.out.println("Начинаем оформление заказа для: " + client);

            INN.validateINN(client);
            System.out.println("Заказ успешно оформлен!");

        } catch (InvalidINNException e) {
            System.err.println("Ошибка оформления заказа: " + e.getMessage());
        }
    }
}