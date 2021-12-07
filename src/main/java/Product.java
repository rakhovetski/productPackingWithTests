import java.util.Objects;

public class Product {
    /*
     * Продукт
     *
     * nameOfProduct - название продукта
     * descriptionOfProduct - описание продукта
     * */
    private String nameOfProduct;
    private String descriptionOfProduct;

    public Product(String nameOfProduct, String descriptionOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.descriptionOfProduct = descriptionOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }
    public String getDescriptionOfProduct() {
        return descriptionOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }
    public void setDescription(String descriptionOfProduct) {
        this.descriptionOfProduct = descriptionOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameOfProduct, product.nameOfProduct) && Objects.equals(descriptionOfProduct, product.descriptionOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, descriptionOfProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + nameOfProduct + '\'' +
                ", description='" + descriptionOfProduct + '\'' +
                '}';
    }
}