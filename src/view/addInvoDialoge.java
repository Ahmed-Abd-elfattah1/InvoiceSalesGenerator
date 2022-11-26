package view;
import java.awt.*;
import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JButton;

import javax.swing.JTextField;

public class addInvoDialoge extends JDialog
{
    private JTextField NameOfCus;
    private JLabel NameOfCusLebel;

    private JTextField DateOfInv;
    private JLabel DateLbel;

    private JButton BtCancel;
    private JButton OkB;

    public addInvoDialoge(View frame) {

        NameOfCusLebel = new JLabel("Customer Name:");
        NameOfCus = new JTextField(30);
        DateLbel = new JLabel("Date:");
        DateOfInv = new JTextField(30);

        getContentPane().setBackground(Color.white);

        OkB = new JButton("OK");
        BtCancel = new JButton("Cancel");
        OkB.setActionCommand("createInvoice");
        BtCancel.setActionCommand("cancelInvoice");

        OkB.addActionListener(frame.getCtrl());
        BtCancel.addActionListener(frame.getCtrl());

        setLayout(new GridLayout(4, 4));

        add(NameOfCusLebel);
        add(NameOfCus);
        add(DateLbel);
        add(DateOfInv);
        add(OkB);
        add(BtCancel);


        pack();


    }

    public JTextField getNameOfCus()
    {
        return NameOfCus;
    }

    public JTextField getDateOfInv()
    {
        return DateOfInv;
    }

}
