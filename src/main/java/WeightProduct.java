import java.util.Objects;

public class WeightProduct{
    /*
     * Весовой продукт
     *
     * nameOfProduct - название продукта
     * descriptionOfProduct - описание продукта
     * */
    private String nameOfProduct;
    private String descriptionOfProduct;

    public WeightProduct(String nameOfProduct, String descriptionOfProduct) {
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
        WeightProduct that = (WeightProduct) o;
        return Objects.equals(nameOfProduct, that.nameOfProduct) && Objects.equals(descriptionOfProduct, that.descriptionOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct, descriptionOfProduct);
    }

    @Override
    public String toString() {
        return "WeightProduct{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", descriptionOfProduct='" + descriptionOfProduct + '\'' +
                '}';
    }
}