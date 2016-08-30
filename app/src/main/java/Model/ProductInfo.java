package Model;

/**
 * Created by MD.Arifur on 7/21/2016.
 */
public class ProductInfo {
    private int productID;
    private String productName;
    private String productPrice;
    private String productQuantity;
    private String productBrand;
    private String additionalInfo;

    public ProductInfo(int productID, String productName, String productPrice, String productQuantity, String productBrand, String additionalInfo) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
        this.additionalInfo = additionalInfo;
    }

    public ProductInfo(String productName, String productPrice, String productQuantity, String productBrand, String additionalInfo) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
        this.additionalInfo = additionalInfo;
    }

    public ProductInfo() {
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getProductBrand() {
        return productBrand;
    }
}
