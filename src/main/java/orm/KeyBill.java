package orm;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "key_bills")
public class KeyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int price;

    private String platform;

    @Column(name = "chat_id")
    private long chatId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public KeyBill() {}

    public KeyBill(int id, String platform, int price, long chatId) {
        this.id = id;
        this.platform = platform;
        this.price = price;
        this.chatId = chatId;
    }
}