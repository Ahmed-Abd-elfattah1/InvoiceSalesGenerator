package Template;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class LineTableHandler extends AbstractTableModel
{
    private String[] cols = {"Num", "Item", "Unit Price", "Quantity", "Total"};
    private ArrayList<ItemClass> Classitm;

    public LineTableHandler(ArrayList<ItemClass> Classitm)
    {
        this.Classitm = Classitm;
    }

    @Override
    public int getRowCount()
    {
        return Classitm.size();
    }

    @Override
    public int getColumnCount()
    {
        return cols.length;
    }

    @Override
    public Object getValueAt(int indexR, int indexCol) {

        ItemClass itemClass = Classitm.get(indexR);
        switch(indexCol){
            case 0:
                return itemClass.getInv().getHnumber();

            case 1:
                return itemClass.getItmname();

            case 2:
                return itemClass.getPricePerUnit();

            case 3:
                return itemClass.getQuantity();

            case 4:
                return itemClass.getTLine();

        }

        return null;

    }

    @Override
    public String getColumnName(int col)
    {
        return cols[col];
    }
}
