import java.util.Arrays;
import java.util.Objects;


class ProductPackaging {
    /*
     * Упаковка товара
     *
     * nameOfPacking - название упаковки
     * weightOfPacking - вес упаковки
     * */
    private String nameOfPacking;
    private double weightOfPacking;

    public ProductPackaging(String nameOfPacking, double weightOfPacking) {
        if (weightOfPacking < 0) {
            throw new NullPointerException();
        }
        this.nameOfPacking = nameOfPacking;
        this.weightOfPacking = weightOfPacking;
    }

    public String getNameOfPacking() {
        return nameOfPacking;
    }
    public double getWeightOfPacking() {
        return weightOfPacking;
    }

    public void setNameOfPacking(String nameOfPacking) {
        this.nameOfPacking = nameOfPacking;
    }
    public void setWeight(double weight) {
        this.weightOfPacking = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPackaging that = (ProductPackaging) o;
        return Double.compare(that.weightOfPacking, weightOfPacking) == 0 && Objects.equals(nameOfPacking, that.nameOfPacking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfPacking, weightOfPacking);
    }

    @Override
    public String toString() {
        return "ProductPackaging{" +
                "name='" + nameOfPacking + '\'' +
                ", weight=" + weightOfPacking +
                '}';
    }
}

