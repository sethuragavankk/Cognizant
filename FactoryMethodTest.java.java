public interface Document {
    void open();
}
public class WordDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Word Document..."); }
}
public class PdfDocument implements Document {
    @Override
    public void open() { System.out.println("Opening PDF Document..."); }
}
public class ExcelDocument implements Document {
    @Override
    public void open() { System.out.println("Opening Excel Document..."); }
}
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
public class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new WordDocument(); }
}
public class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new PdfDocument(); }
}
public class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() { return new ExcelDocument(); }
}
public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
    }
}