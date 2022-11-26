package view;
import Template.ApplicationHeader;

import Template.LineTableHandler;

import Template.ItemClass;

import javax.swing.event.ListSelectionEvent;

import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;

public class Events implements ListSelectionListener
{
    final private View Frme;

    public Events(View Frme) {
        this.Frme = Frme;
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        int IndexInv = Frme.getInvHeaderTab().getSelectedRow();
        if(IndexInv!= -1){

            ApplicationHeader selectedRow = Frme.getInvo().get(IndexInv);
            ArrayList<ItemClass> itemClasses = selectedRow.getClasItems();
            Frme.getIabelCName().setText(selectedRow.getHname());
            Frme.getIabelInvNumber().setText(""+selectedRow.getHnumber());
            Frme.getIabelInvDate().setText(selectedRow.getHdate());
            Frme.getIabelTCost().setText(""+selectedRow.getInvTotal());
            LineTableHandler LTH = new LineTableHandler(itemClasses);
            Frme.getInvLineTab().setModel(LTH);
            LTH.fireTableDataChanged();

        }
    }

}
