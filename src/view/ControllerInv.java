package view;
import Template.FOperationHandler;

import Template.InvoiceTableHandler;

import Template.LineTableHandler;

import Template.ApplicationHeader;

import Template.ItemClass;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;

import javax.swing.event.ListSelectionListener;
public class ControllerInv implements ActionListener , ListSelectionListener
{
    private ItemClass itemClass;

    private ApplicationHeader applicationHeader;

    final private View FrmApplication;

    private String name ;

    private addInvoDialoge DialogeInvo;

    private addlineDialoge DialogeItem;

    public ControllerInv(View frame) {
        this.FrmApplication = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Create Invoice":
                newInv();
                break;
            case "Delete Invoice":
                delInv();
                break;
            case "Add Line":
                AddLine();
                break;
            case "Delete Line":
                removeLine();
                break;

            case "createInvoice":
                InvoiceOk();
                break;

            case "cancelInvoice":
                InvoCancel();
                break;
            case "createLine":
                LineAdding();
                break;
            case "cancelLine":
                LineRemove();
                break;

            case "Open File":

                FrmApplication.setInvos(null);
                FOperationHandler FOperationHandler = new FOperationHandler(FrmApplication);
                ArrayList<ApplicationHeader> inv= FOperationHandler.FRead();
                FrmApplication.setInvos(inv);
                InvoiceTableHandler invoiceTable = new InvoiceTableHandler(inv);
                FrmApplication.setHeaderTable(invoiceTable);
                FrmApplication.getInvHeaderTab().setModel(invoiceTable);
                FrmApplication.getHeaderTab().fireTableDataChanged();

                break;

            case "Save File":

                FOperationHandler FOperationHandler1 = new FOperationHandler(FrmApplication);
                FOperationHandler1.FileSave(FrmApplication.getInvo());

                break;

        }
    }

    private void newInv() {
        DialogeInvo = new addInvoDialoge(FrmApplication);

        DialogeInvo.setVisible(true);

    }

    private void delInv() {

        int row = FrmApplication.getInvHeaderTab().getSelectedRow();

        if(row!= -1){

            FrmApplication.getInvo().remove(row);
            FrmApplication.getHeaderTab().fireTableDataChanged();

        }
    }

    private void AddLine() {

        DialogeItem = new addlineDialoge(FrmApplication);

        DialogeItem.setVisible(true);

    }

    private void removeLine() {

        int SelectedInvo= FrmApplication.getInvHeaderTab().getSelectedRow();

        int row = FrmApplication.getInvLineTab().getSelectedRow();

        if((SelectedInvo!=-1) && (row!= -1)){

            ApplicationHeader INvo = FrmApplication.getInvo().get(SelectedInvo);
            INvo.getClasItems().remove(row);
            FrmApplication.getHeaderTab().fireTableDataChanged();
            LineTableHandler line = new LineTableHandler(INvo.getClasItems());
            FrmApplication.getInvLineTab().setModel(line);
            line.fireTableDataChanged();
        }
    }

    public void InvoiceOk() {

        String invDate= DialogeInvo.getDateOfInv().getText();
        String Client = DialogeInvo.getNameOfCus().getText();
        int invNum= FrmApplication.getTotalInvNo();
        invNum++;
        ApplicationHeader newInvoice = new ApplicationHeader(invNum,Client,invDate);
        FrmApplication.getInvo().add(newInvoice);

        FrmApplication.getHeaderTab().fireTableDataChanged();
        DialogeInvo.setVisible(false);

        DialogeInvo.dispose();
        DialogeInvo =null;

    }

    public ApplicationHeader getInvByNo(int No){

        for(ApplicationHeader invNo: FrmApplication.getInvo()){

            if(No==invNo.getHnumber()){
                return invNo;
            }
        }
        return null;
    }

    private void InvoCancel() {

        DialogeInvo.setVisible(false);
        DialogeInvo.dispose();
        DialogeInvo =null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        throw new UnsupportedOperationException("Not supported .");
    }

    private void LineRemove() {

        DialogeItem.setVisible(false);
        DialogeItem.dispose();

        DialogeItem =null;

    }
    private void LineAdding() {

        int SelectedInv= FrmApplication.getInvHeaderTab().getSelectedRow();
        if(SelectedInv!=-1){
            ApplicationHeader invoice = FrmApplication.getInvo().get(SelectedInv);
            String item= DialogeItem.getNameOfItm().getText();
            String unitPrice = DialogeItem.getPricePerUnit().getText();
            String quantity = DialogeItem.getNOFItm().getText();
            double itemUnitPrice = Double.parseDouble(unitPrice);
            int itemQuantity = Integer.parseInt(quantity);
            ItemClass newLine = new ItemClass(item,itemQuantity,itemUnitPrice,invoice);
            invoice.getClasItems().add(newLine);
            LineTableHandler line = new LineTableHandler(invoice.getClasItems());
            FrmApplication.getHeaderTab().fireTableDataChanged();
            FrmApplication.getInvLineTab().setModel(line);
            line.fireTableDataChanged();

        }
        DialogeItem.setVisible(false);

        DialogeItem.dispose();

        DialogeItem =null;

    }

}
