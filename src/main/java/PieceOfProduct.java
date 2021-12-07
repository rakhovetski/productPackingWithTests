import java.util.Objects;

public class PieceOfProduct extends Product {
    /*
     * Штучный товар
     *
     * weightOfOnePiece - вес одной штуки
     * */
    private double weightOfOnePiece;

    public PieceOfProduct(String nameOfProduct, String descriptionOfProduct, double weightOfOnePiece) {
        super(nameOfProduct, descriptionOfProduct);
        this.weightOfOnePiece = weightOfOnePiece;
    }

    public double getWeightOfOnePiece() {
        return weightOfOnePiece;
    }

    public void setWeightOfOnePiece(double weightOfOnePiece) {
        this.weightOfOnePiece = weightOfOnePiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceOfProduct product = (PieceOfProduct) o;
        return Objects.equals(this.getNameOfProduct(), product.getNameOfProduct()) && Objects.equals(this.getDescriptionOfProduct(), product.getDescriptionOfProduct()) && Objects.equals(this.getWeightOfOnePiece(), product.getWeightOfOnePiece());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNameOfProduct(), this.getDescriptionOfProduct(), this.getWeightOfOnePiece());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + this.getNameOfProduct() + '\'' +
                ", description='" + this.getDescriptionOfProduct() + '\'' +
                ", weight='" + this.getWeightOfOnePiece() + '\'' +
                '}';
    }
}
