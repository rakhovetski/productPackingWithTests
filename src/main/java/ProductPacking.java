import java.util.Arrays;
import java.util.Objects;

class ProductPackaging {
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

class Product {
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

class WeightProduct extends  Product{
    public WeightProduct(String nameOfProduct, String descriptionOfProduct) {
        super(nameOfProduct, descriptionOfProduct);
    }
}

class PieceOfProduct extends Product {
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


class PackedWeightProduct implements Package {
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

class PackagedPieceOfProduct implements Package {
    private int countOfPieces;
    private PieceOfProduct pieceOfProduct;
    private ProductPackaging productPackaging;

    public PackagedPieceOfProduct(int countOfPieces, PieceOfProduct pieceOfProduct, ProductPackaging productPackaging) {
        if (countOfPieces < 1) {
            throw new NullPointerException();
        }
        this.countOfPieces = countOfPieces;
        this.pieceOfProduct = pieceOfProduct;
        this.productPackaging = productPackaging;
    }

    public double getBrutto() {
        return this.getNetto() + this.productPackaging.getWeightOfPacking();
    }

    public double getNetto() {
        return this.countOfPieces * this.pieceOfProduct.getWeightOfOnePiece();
    }

    public String getName() {
        return pieceOfProduct.getNameOfProduct();
    }
    public PieceOfProduct getPieceOfProduct() {
        return pieceOfProduct;
    }
    public ProductPackaging getProductPackaging() {
        return productPackaging;
    }
    public int getCountOfPieces() {
        return countOfPieces;
    }


    public void setPieceOfProduct(PieceOfProduct pieceOfProduct) {
        this.pieceOfProduct = pieceOfProduct;
    }
    public void setCountOfPieces(int countOfPieces) {
        this.countOfPieces = countOfPieces;
    }
    public void setProductPackaging(ProductPackaging productPackaging) {
        this.productPackaging = productPackaging;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagedPieceOfProduct that = (PackagedPieceOfProduct) o;
        return countOfPieces == that.countOfPieces && Objects.equals(pieceOfProduct, that.pieceOfProduct) && Objects.equals(productPackaging, that.productPackaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPieces, pieceOfProduct, productPackaging);
    }

    @Override
    public String toString() {
        return "PackagedPieceGoods{" +
                "count=" + countOfPieces +
                ", pieceGoods=" + pieceOfProduct +
                ", productPackaging=" + productPackaging +
                '}';
    }
}

interface Package {
    double getBrutto();

    double getNetto();

    String getName();
}

class ConsignmentOfProduct  {
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



