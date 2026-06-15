public interface Image {
    void display();
}
public class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.println("Loading image from remote server: " + filename);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); 
        }
        realImage.display();
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("high_res_photo.jpg");
        System.out.println("First call:");
        image.display();
        System.out.println("\nSecond call:");
        image.display();
    }
}