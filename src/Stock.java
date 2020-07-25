import java.util.HashMap;

public class Stock {
    private HashMap<Integer, Product> products = new HashMap<>();
    private int maxNumberProducts = 15;


    public void addNewProduct(Product product) throws StockLimitReachedException {
        if (products.size() + 1 <= maxNumberProducts) {
            products.put(product.getProductId(), product);
        } else {
            String errMsg = "!!! Product cant be added stock is full !!!";
            System.out.println(errMsg);
            throw new StockLimitReachedException(errMsg);
        }
    }

    public void addToExistingProduct(Product product, Integer amount) {
        if (product.getInStock() + amount < product.getMaxAmount()) {
            product.setInStock(product.getInStock() + amount);
        } else if (product.getInStock() + amount == product.getMaxAmount()) {
            product.setInStock(product.getInStock() + amount);
            System.out.printf("\n !! Stock of %s full !! \n", product.getProductName());
        } else {
            System.out.printf("\n Stock of %s is full - CANT add Product", product.getProductName());
        }
    }

    public Boolean removeProduct(Product product, Integer amount) {


        Integer amountInStock = product.getInStock();
        if (amount <= amountInStock) {
            product.setInStock(amountInStock - amount);
            checkStock(product);
            return true;
        } else {
            System.out.println("Not enough products available");
            return false;
        }
    }

    public void checkStock(Product product) {
        if (product.getInStock() < 5) {
            System.out.println("!!! FILL UP STOCK !!!");
        }
    }

    public void displayProducts() {
        System.out.println("ALL PRODUCTS");
        System.out.println("----------------------------------------------");
        for (int i = 1; i <= products.size(); i++) {
            System.out.println(products.get(i).showProductDetails());
        }
    }

    public void displayAllProductsOfCategory(Product.Categories categorie) {

        System.out.printf("\nPRODUCTS FROM CATEGORY %s\n", categorie.toString());
        System.out.println("----------------------------------------------");
        for (int i = 1; i <= products.size(); i++) {
            Product product = products.get(i);
            if (product.getProductCategory().equals(categorie)) {
                System.out.println(product.showProductDetails());
            }
        }
    }

    public void displayProductsStockSm5() {
        System.out.println("ALL PRODUCTS WHERE STOCK SMALLER 5");
        System.out.println("----------------------------------------------");
        for (int i = 1; i <= products.size(); i++) {
            Product product = products.get(i);
            if (product.getInStock() < 5) {
                System.out.println(product.showProductDetails());
            }
        }

    }

    public void displayProductsOutOfStock() {
        System.out.println("OUT OF STOCK PRODUCTS");
        System.out.println("---------------------------");
        for (int i = 1; i <= products.size(); i++) {
            Product product = products.get(i);
            if (product.getInStock() == 0) {
                System.out.println(product.showProductDetails());
            }
        }
    }

    public Integer amountItemsInStock() {
        return products.size();
    }
}

