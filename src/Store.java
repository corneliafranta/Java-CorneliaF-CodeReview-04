import java.util.HashMap;

public class Store {
    private Stock stock;
    private String name;
    private String adresse;
    private HashMap<Integer, User> users = new HashMap<>();

    public Store(Stock stock, String name, String adresse) {
        this.stock = stock;
        this.name = name;
        this.adresse = adresse;
    }

    public Stock getStock() {
        return stock;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
        System.out.println("User registered to store");
    }

    public void diplayUsers() {
        for (int i = 1; i <= users.size(); i++) {
            users.get(i).displayUserDetails();
        }
    }
}
