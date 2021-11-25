import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void ServiceTest1(){
        ProductPackaging pack = new ProductPackaging("Морозильная камера", 50.0);
        WeightProduct weightProduct = new WeightProduct("Куриная тушка", "Замороженная");
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(pack, weightProduct, 2.0);
        PieceOfProduct pieceOfProduct = new PieceOfProduct("Яблоко", "Зеленое", 1.2);
        PackagedPieceOfProduct packagedPieceOfProduct = new PackagedPieceOfProduct(7, pieceOfProduct, pack);
        ConsignmentOfProduct consignmentOfProduct = new ConsignmentOfProduct("Продукты", packedWeightProduct, packagedPieceOfProduct);
        BeginStringFilter beginStringFilter = new BeginStringFilter("Я");
        ProductService productService = new ProductService();
        assertEquals(1,productService.countByFilter(consignmentOfProduct, beginStringFilter));
    }

    @Test
    public void ServiceTest2(){
        ProductPackaging pack = new ProductPackaging("Морозильная камера", 50.0);
        WeightProduct weightProduct = new WeightProduct("Куриная тушка", "Замороженная");
        PackedWeightProduct packedWeightProduct = new PackedWeightProduct(pack, weightProduct, 2.0);
        PieceOfProduct pieceOfProduct = new PieceOfProduct("Яблоко", "Зеленое", 1.2);
        PackagedPieceOfProduct packagedPieceOfProduct = new PackagedPieceOfProduct(7, pieceOfProduct, pack);
        ConsignmentOfProduct consignmentOfProduct = new ConsignmentOfProduct("Продукты", packedWeightProduct, packagedPieceOfProduct);
        BeginStringFilter beginStringFilter = new BeginStringFilter("о");
        ProductService productService = new ProductService();
        assertEquals(0, productService.countByFilter(consignmentOfProduct, beginStringFilter));
    }
}


