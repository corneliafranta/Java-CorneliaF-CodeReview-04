import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class User {
    private static Integer count = 1;
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String zip;
    private String phone;
    ArrayList<Product> history = new ArrayList<>();

    public User(String firstName, String lastName, String email, String address, String zip, String phone) {
        this.id = count;
        count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Product> getHistory() {
        return history;
    }

    public void buyProduct(Product product, Integer amount, Store store) {

        if (!store.getUsers().containsKey(getId())) {
            store.addUser(this);
        }

        Boolean success = store.getStock().removeProduct(product, amount);

        if (success) {
            System.out.println("Thanks for shopping at our store");
            this.history.add(product);
        } else {
            System.out.printf("\nSorry but we have not enough Products \n We only have %d pieces in stock \n", product.getInStock());
        }


    }

    public void displayUserDetails() {
        System.out.printf("\n%d | %-10s | %-15s | %-30s | %-25s | %-10s | %10s\n", this.id, this.firstName, this.lastName, this.email, this.address, this.zip, this.phone);
    }

    public void printReport() {
        try {
            Path currentRelativePath = Paths.get("");
            String projectPath = currentRelativePath.toAbsolutePath().toString();
            String fileName = String.format("%s_%s_Report.txt", this.firstName, this.lastName);
            File file = new File(projectPath + "/userReports/" + fileName);
            if (file.createNewFile()) {
                System.out.printf("\nFile Created %s \n", file.getName());
                FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true);
                Integer counter = 1;
                for (Product product : history) {
                    fileWriter.write(String.format("%d | %-40s  \n", counter, product.showProductDetailsShort()));
                    counter++;
                }


                fileWriter.close();
                System.out.println("Created File successfully");

            }
        } catch (IOException e) {
            System.out.println("An error occurred \n");
            e.printStackTrace();
        }

    }
}
