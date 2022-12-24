package Template;
import java.util.ArrayList;
public class ApplicationHeader {
    private String Hdate;

    private int Hnumber;

    private String Hname;

    private ArrayList<ItemClass> itemClasses;





    public ApplicationHeader(int Hnumber, String Hname, String Hdate) {

        this.Hdate = Hdate;

        this.Hname = Hname;
        this.Hnumber = Hnumber;
    }
    public double getInvTotal(){
        double t=0.0;
        for(ItemClass itemClass : getClasItems()){

            t= t + itemClass.getTLine();

        }

        return t;
    }


    public int getHnumber()
    {
        return Hnumber;
    }



    public String getHname()
    {
        return Hname;
    }



    public String getHdate()
    {
        return Hdate;
    }



    public ArrayList<ItemClass> getClasItems()
    {
        if(itemClasses ==null){

            itemClasses =new ArrayList();
        }

        return itemClasses;
    }

    @Override
    public String toString() {
        return "Header{" + "num=" + Hnumber + ", date=" + Hdate + ", name=" + Hname + ", items=" + itemClasses + '}';
    }
    public double getTotal()
    {
        double t=0.0;
        for(ItemClass itemClass : getClasItems()){

            t= t+ itemClass.getTotal();
        }

        return t;
    }

    public String getInvoFTable()
    {
        return Hnumber + "," + Hdate + "," + Hname;
    }


}
