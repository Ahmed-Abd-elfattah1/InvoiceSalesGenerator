package view;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class addlineDialoge extends JDialog
{
    private JTextField NameOfItm;
    private JTextField NOFItm;
    private JTextField pricePerUnit;
    private JLabel itmNameLbl;
    private JLabel pricePerUnitLbl;
    private JLabel NOFItmLbl;
    private JButton BCancel;
    private JButton OKB;

    public addlineDialoge(View frame) {

        itmNameLbl = new JLabel("Item Name:");
        NameOfItm = new JTextField(30);
        pricePerUnitLbl = new JLabel("Unit Price:");
        pricePerUnit = new JTextField(30);
        NOFItmLbl = new JLabel("Quantity:");
        NOFItm = new JTextField(30);
        OKB = new JButton("OK");
        BCancel = new JButton("Cancel");
        getContentPane().setBackground(Color.white);
        OKB.setActionCommand("createLine");
        getContentPane().setBackground(Color.white);
        BCancel.setActionCommand("cancelLine");
        OKB.addActionListener(frame.getCtrl());
        BCancel.addActionListener(frame.getCtrl());
        setLayout(new GridLayout(4, 4));
        add(itmNameLbl);
        add(NameOfItm);
        add(pricePerUnitLbl);
        add(pricePerUnit);
        add(NOFItmLbl);
        add(NOFItm);
        add(OKB);
        add(BCancel);

        pack();
    }

    public JTextField getNameOfItm()
    {
        return NameOfItm;
    }

    public JTextField getPricePerUnit() {
        return pricePerUnit;
    }

    public JTextField getNOFItm() {
        return NOFItm;
    }
}
