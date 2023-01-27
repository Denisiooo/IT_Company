package Hierarchy;

public class ProductsType {
    private int TypeId;
    private String ProductType;

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    @Override
    public String toString() {
        return "ProductsType{" +
                "TypeId=" + TypeId +
                ", ProductType='" + ProductType + '\'' +
                '}';
    }
}
