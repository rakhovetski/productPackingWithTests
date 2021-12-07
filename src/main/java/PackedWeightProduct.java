import java.util.Objects;

public class PackedWeightProduct implements Package {
    private ProductPackaging productPackaging;
    private WeightProduct weightProduct;
    private double weight;

    public PackedWeightProduct(ProductPackaging productPackaging, WeightProduct weightProduct, double weight) {
        if (weight <= 0) {
            throw new NullPointerException();
        }
        this.productPackaging = productPackaging;
        this.weightProduct = weightProduct;
        this.weight = weight;
    }

    public double getNetto() {
        return this.weight;
    }

    public double getBrutto() {
        return this.getNetto() + this.productPackaging.getWeightOfPacking();
    }

    public ProductPackaging getProductPackaging() {
        return productPackaging;
    }
    public WeightProduct getWeightProduct() {
        return weightProduct;
    }
    public double getWeight() {
        return weight;
    }
    @Override
    public String getName() {
        return weightProduct.getNameOfProduct();
    }

    public void setProductPackaging(ProductPackaging productPackaging) {
        this.productPackaging = productPackaging;
    }
    public void setWeightProduct(WeightProduct weightProduct) {
        this.weightProduct = weightProduct;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(productPackaging, that.productPackaging) && Objects.equals(weightProduct, that.weightProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPackaging, weightProduct, weight);
    }

    @Override
    public String toString() {
        return "PackedWeightGoods{" +
                "productPackaging=" + productPackaging +
                ", weightProduct=" + weightProduct +
                ", weight=" + weight +
                '}';
    }
}