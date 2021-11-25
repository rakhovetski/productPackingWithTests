class ProductService{
    public int countByFilter(ConsignmentOfProduct consignmentOfProduct, BeginStringFilter filter){
        int count = 0;
        for(Package pack : consignmentOfProduct.getPackages()){
            if(filter.apply(pack.getName())){
                count++;
            }
        }
        return count;
    }
}