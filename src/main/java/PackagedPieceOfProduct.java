import java.util.Objects;

public class PackagedPieceOfProduct implements Package {
    /*
     * Упакованный штучный товар
     *
     * countOfPieces - количество штук товара
     * */
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