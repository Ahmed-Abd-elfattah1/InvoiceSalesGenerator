package Template;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class InvoiceTableHandler extends AbstractTableModel
{
    private String[] cols = {"Num", "Date", "Customer", "Total"};
    private ArrayList<ApplicationHeader> invs;

    public InvoiceTableHandler(ArrayList<ApplicationHeader> invs)
    {
        this.invs = invs;
    }

    @Override
    public int getRowCount()
    {
        return invs.size();
    }

    @Override
    public int getColumnCount()
    {
        return cols.length;
    }

    @Override
    public Object getValueAt(int indexRow, int indexCol) {

        ApplicationHeader invoice = invs.get(indexRow);
        switch(indexCol){
            case 0:
                return invoice.getHnumber();

            case 1:
                return invoice.getHdate();

            case 2:
                return invoice.getHname();

            case 3:
                return invoice.getInvTotal();

        }

        return null;
    }

    @Override
    public String getColumnName(int col)
    {

        return cols[col];
    }
}
