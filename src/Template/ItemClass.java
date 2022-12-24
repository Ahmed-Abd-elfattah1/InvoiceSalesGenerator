package Template;

public class ItemClass {
    private double PricePerUnit;

    private String itmname;

    private ApplicationHeader inv;

    private int quantity;

    public ItemClass() {
    }

    public ItemClass(String itmname, int quantity, double PricePerUnit, ApplicationHeader applicationHeader) {
        this.inv = applicationHeader;
        this.quantity = quantity;
        this.itmname = itmname;
        this.PricePerUnit = PricePerUnit;
    }
    public double getTLine()
    {
        return PricePerUnit * quantity;
    }



    public ApplicationHeader getInv()
    {
        return inv;
    }

    public void setInv(ApplicationHeader inv)
    {
        this.inv = inv;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getItmname()
    {
        return itmname;
    }

    public void setItmname(String itmname)
    {
        this.itmname = itmname;
    }

    public double getPricePerUnit()
    {
        return PricePerUnit;
    }


    @Override
    public String toString() {
        return "Item{" + "itemName=" + itmname + ", unitPrice=" + PricePerUnit + ", quantity=" + quantity + '}';
    }
    public double getTotal()
    {
        return PricePerUnit * quantity;
    }

    public String getItmsFTable()
    {
        return inv.getHnumber() + "," + itmname + "," + PricePerUnit + "," +quantity;
    }

}
