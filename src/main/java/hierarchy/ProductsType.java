package hierarchy;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Products")
public class ProductsType {
    private int TypeId;
    private String ProductType;

    @JsonGetter("idType")
    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    @JsonGetter("product")
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
