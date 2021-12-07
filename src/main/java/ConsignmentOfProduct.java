import java.util.Arrays;
import java.util.Objects;
public class ConsignmentOfProduct  {
    /*
     * Партия товара
     * */
    private String descriptionOfProduct;
    private Package[] packages;

    public ConsignmentOfProduct(String descriptionOfProduct, Package... packages) {
        this.descriptionOfProduct = descriptionOfProduct;
        this.packages = packages;
    }

    public double getBrutto() {
        double bruttoSum = 0;
        for (Package pack : packages) {
            bruttoSum += pack.getBrutto();
        }
        return bruttoSum;
    }

    public String getDescriptionOfProduct() {
        return descriptionOfProduct;
    }
    public Package[] getPackages() {
        return packages;
    }

    public void setDescriptionOfProduct(String descriptionOfProduct) {
        this.descriptionOfProduct = descriptionOfProduct;
    }
    public void setPackages(Package[] packages) {
        this.packages = packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsignmentOfProduct that = (ConsignmentOfProduct) o;
        return Objects.equals(descriptionOfProduct, that.descriptionOfProduct) && Arrays.equals(packages, that.packages);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(descriptionOfProduct);
        result = 31 * result + Arrays.hashCode(packages);
        return result;
    }

    @Override
    public String toString() {
        return "BatchOfGoods{" +
                "description='" + descriptionOfProduct + '\'' +
                ", batch=" + Arrays.toString(packages) +
                '}';
    }
}