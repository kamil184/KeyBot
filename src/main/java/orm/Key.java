package orm;

import javax.persistence.*;

@Entity
@Table(name = "keys")
public class Key {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String key;

    private String platform;

    private int price;

    public Key() {}

    public Key(String key, String platform, int price) {
        this.key = key;
        this.platform = platform;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}