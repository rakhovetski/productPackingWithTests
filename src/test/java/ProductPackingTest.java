import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductPackingTest {

    @Test
    public void BruttoPieceTest()
    {
        ProductPackaging pack = new ProductPackaging("Коробка", 2.0);
        PieceOfProduct pieceOfProduct = new PieceOfProduct("Яблоко","Красное", 1.0);
        PackagedPieceOfProduct packagedPieceOfProduct = new PackagedPieceOfProduct(5, pieceOfProduct, pack );
        assertEquals(7.0,packagedPieceOfProduct.getBrutto());
    }

    @Test
    public void NettoPieceTest()
    {
        ProductPackaging pack = new ProductPackaging("Коробка", 2.0);
        PieceOfProduct pieceOfProduct = new PieceOfProduct("Яблоко", "Зеленое", 1.2);
        PackagedPieceOfProduct packagedPieceOfProduct = new PackagedPieceOfProduct(7, pieceOfProduct, pack);
        assertEquals(8.4, packagedPieceOfProduct.getNetto());
    }

    @Test
    public void NettoWeightTest()
    {
        ProductPackaging pack = new ProductPackaging("Морозильная камера", 50.0);
        WeightProduct weightProduct = new WeightProduct("Куриная тушка", "Замороженная");
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(pack, weightProduct, 2.0);
        assertEquals(2.0, packedWeightProduct.getNetto());
    }

    @Test
    public void BruttoWeightTest()
    {
        ProductPackaging pack = new ProductPackaging("Морозильная камера", 50.0);
        WeightProduct weightProduct = new WeightProduct("Куриная тушка", "Замороженная");
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(pack, weightProduct, 2.0);
        assertEquals(52.0, packedWeightProduct.getBrutto());
    }

    @Test
    public void BruttoConsignmentTest()
    {
        ProductPackaging pack = new ProductPackaging("Морозильная камера", 50.0);
        WeightProduct weightProduct = new WeightProduct("Куриная тушка", "Замороженная");
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(pack, weightProduct, 2.0);
        PieceOfProduct pieceOfProduct = new PieceOfProduct("Яблоко", "Зеленое", 1.2);
        PackagedPieceOfProduct packagedPieceOfProduct = new PackagedPieceOfProduct(7, pieceOfProduct, pack);
        ConsignmentOfProduct consignmentOfProduct = new ConsignmentOfProduct("Продукты", packedWeightProduct, packagedPieceOfProduct);
        assertEquals(110.4, consignmentOfProduct.getBrutto());
    }
}
