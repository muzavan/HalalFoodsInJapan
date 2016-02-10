package halalfoods.model;

/**
 * Created by Muzavan on 2/9/2016.
 */
public class FoodItem{
    private byte[] image = null;
    private String name = "Unknown";
    private String price = "Unknown";
    private int halalId = 0; // 0 haram, 1 halal, 2 edible

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getHalalId() {
        return halalId;
    }

    public void setHalalId(int halalId) {
        this.halalId = halalId;
    }
}