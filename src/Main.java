import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Creating User Interface
        UserInterface userinterface = new UserInterface();

        // Storing Product Data in Hashmap
        HashMap<Integer, Product> products = new HashMap<>();
        // SToring Costumer Data in Hashmap
        HashMap<Integer, User> users = new HashMap<>();

        //Creating Products From Data Class
        ProductData productData = new ProductData();

        for (String[] dataSet : productData.data) {
            Product.Categories categorie = null;
            switch (dataSet[3]) {
                case "trouser":
                    categorie = Product.Categories.trouser;
                    break;
                case "t-shirt":
                    categorie = Product.Categories.tshirt;
                    break;
                case "dress":
                    categorie = Product.Categories.dress;
                    break;
                case "skirt":
                    categorie = Product.Categories.skirt;
                    break;
                case "jacket":
                    categorie = Product.Categories.jacket;
                    break;
                case "accessoire":
                    categorie = Product.Categories.accessoire;
                    break;
            }

            Product product = new Product(dataSet[0], dataSet[1], Double.parseDouble(dataSet[2]), categorie, Integer.parseInt(dataSet[4]));
            System.out.println(product.getProductId());
            products.put(product.getProductId(), product);
            System.out.println("Product has been added");

        }

        // Creating Stock
        Stock myStock = new Stock();

        //Adding Products to the Stock

        for (int i = 1; i <= products.size(); i++) {
            try {
                myStock.addNewProduct(products.get(i));
            } catch (StockLimitReachedException e) {
                e.printStackTrace();
            }
        }


        //Creating a new Store

        Store myStore = new Store(myStock, "myStore", "Schwedenplatz 2, 1010 Wien");

        // Creating Users

        UserData userDataRaw = new UserData();
        String[][] userData = userDataRaw.data;

        for (String[] user : userData) {
            User userObj = new User(user[0], user[1], user[2], user[3], user[4], user[5]);
            users.put(userObj.getId(), userObj);
        }


        // Adding User to Store

        for (int i = 1; i <= users.size(); i++) {
            myStore.addUser(users.get(i));
        }

        // Point 6

        // Example purchase 1
        User myTestUser = users.get(1);
        System.out.println("Products before: ");
        myStock.displayProducts();
        System.out.println("Number of items in stock before: ");
        System.out.println(products.get(2).getInStock());
        myTestUser.buyProduct(products.get(2), 2, myStore);
        for (Product item : myTestUser.getHistory()) {
            System.out.println(item.showProductDetails());
        }
        System.out.println("Products after: ");
        myStock.displayProducts();
        System.out.println("Number of items in stock after User bought 2 pieces");
        System.out.println(products.get(2).getInStock());


        //Purchase Process

        // Example purchase 2
        User myTestUser1 = users.get(2);
        myStock.displayProducts();
        myTestUser1.buyProduct(products.get(1), 2, myStore);
        myStock.checkStock(products.get(1));

        // Example purchase 3
        User myTestUser2 = users.get(2);
        myStock.displayProducts();
        myTestUser2.buyProduct(products.get(3), 1, myStore);
        myStock.checkStock(products.get(3));

        // Example purchase 3
        User myTestUser3 = users.get(2);
        myStock.displayProducts();
        myTestUser3.buyProduct(products.get(14), 4, myStore);
        myStock.checkStock(products.get(14));


        // Displaying Product stock goes below 5
        System.out.println("STOCK GOES BELOW 5: ");
        myTestUser.buyProduct(products.get(6), 1, myStore);
        //Adding Product to Full stock

        System.out.println("\nADDING PRODUCTS TO FULL STOCK: ");

        Product newProduct = new Product("red T-shirt", "Always nice to have", 22.99, Product.Categories.tshirt, 5);
        System.out.println(myStock.amountItemsInStock());

        try {
            myStock.addNewProduct(newProduct);
        } catch (StockLimitReachedException e) {
            System.out.println("StockLimitReachedException was thrown but caught here!");
            //e.printStackTrace();
        }

        //Displaying all Users registered to a shop

        System.out.println("SHOW USERS REGISTERED TO A STORE: ");
        myStore.diplayUsers();


        //print User Report
        myTestUser.printReport();


        // Display User Menu
        Integer usersChoice = userinterface.showMenu();
        switch (usersChoice) {
            case 1:
                myStock.displayProducts();
                break;
            case 2:
                myStock.displayAllProductsOfCategory(Product.Categories.dress);
                break;
            case 3:
                myStock.displayProductsStockSm5();
                break;
            case 4:
                myStock.displayProductsOutOfStock();
                break;
            case 5:
                myStore.diplayUsers();
                break;
            case 0:
                break;

        }

    }
}
