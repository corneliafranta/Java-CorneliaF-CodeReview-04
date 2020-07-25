public class Product {

    private static Integer count = 1;

    enum Categories {
        tshirt,
        trouser,
        dress,
        skirt,
        jacket,
        accessoire
    }

    private Integer productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Categories productCategory;
    private Integer inStock;
    private Integer maxAmount = 15;

    public Product(String productName, String productDescription, Double productPrice, Categories categorie, Integer inStock) {
        this.productId = count;
        count++;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCategory = categorie;
        this.inStock = inStock;
    }


    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Categories getProductCategory() {
        return productCategory;
    }

    public Integer getInStock() {
        return inStock;
    }

    public void setInStock(Integer inStock) {
        this.inStock = inStock;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public String showProductDetails() {

        return String.format("%-3d | %-25s |  %-10s | %-5s | %-5d | %-50s \n", this.productId, this.productName, this.productCategory, this.productPrice, this.inStock, this.productDescription);

    }

    public String showProductDetailsShort() {
        return String.format("%-25s | %-10s | %-5s |", this.productName, this.productCategory, this.productPrice);
    }
}
