class Product {
    double price;
}
public class Main {

        public void updatePrice(Product product, double price){
            price = price * 2;
            product.price =product.price;
        }

    public static void main(String[] args) {
        Product prt =new Product();
        prt.price=200;

        double newPrice =100;
        Main t =new Main();
        t.updatePrice(prt,newPrice);
        System.out.printf(prt.price+":"+newPrice);
    }
}