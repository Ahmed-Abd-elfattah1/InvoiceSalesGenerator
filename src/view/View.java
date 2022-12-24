package view;
import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

import Template.FOperationHandler;
import Template.InvoiceTableHandler;
import Template.ApplicationHeader;


import javax.swing.JTable;
public class View extends JFrame
{
    private String[] cols1 = {"No.", "Date", "Customer","Total"};
    private String[] cols2 = {"No.", "ItemName", "ItemPrice","Count", "ItemTotal"};

    private String [][] data1 = {
            {"2", "Ali", "Excellent","120"},
            {"3", " Ibrahim", "Good", "150"},
            {"4","Maher","Very Good", "160"}


    };
    private String [][] data2 ={
            {"2", "Mobile", "4000", "1", "4000"},
            {"2", "Headphones", "300", "1", "300"},
            {"2", "Cover", "200","1","200"}


    };
    public View() throws InterruptedException {

        super (" Sales Invoice Generator");
        SPJ1 = new javax.swing.JScrollPane();
        InvHeaderTab = new javax.swing.JTable();
        InvHeaderTab.getSelectionModel().addListSelectionListener(ActionTab);
        SPJ2 = new javax.swing.JScrollPane();
        InvLineTab = new javax.swing.JTable();
        NumberInv = new javax.swing.JLabel();
        DateInv = new javax.swing.JLabel();
        CusName = new javax.swing.JLabel();
        TotalCostInv = new javax.swing.JLabel();
        IabelCName = new javax.swing.JLabel();
        IabelTCost = new javax.swing.JLabel();
        IabelInvDate = new javax.swing.JLabel();
        IabelInvNumber = new javax.swing.JLabel();
        NewInvButton = new javax.swing.JButton();
        NewInvButton.addActionListener(ctrl);
        DeleteInvoiceButton = new javax.swing.JButton();
        DeleteInvoiceButton.addActionListener(ctrl);
        AddLineButton = new javax.swing.JButton();
        AddLineButton.addActionListener(ctrl);
        DeleteLineButton = new javax.swing.JButton();
        DeleteLineButton.addActionListener(ctrl);
        MenuJ = new javax.swing.JMenuBar();
        BarMenu = new javax.swing.JMenu();
        MenuItemLoad = new javax.swing.JMenuItem();
        MenuItemLoad.addActionListener(ctrl);
        MenuItemSave = new javax.swing.JMenuItem();
        MenuItemSave.addActionListener(ctrl);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvHeaderTab.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        InvHeaderTab.setShowGrid(true);

        SPJ1.setViewportView(InvHeaderTab);

        InvLineTab.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        InvLineTab.setShowGrid(true);

        SPJ2.setViewportView(InvLineTab);

        InvLineTab.getAccessibleContext().setAccessibleName("");

        NumberInv.setText("Invoice Number:");

        DateInv.setText("Invoice Date:");

        CusName.setText("Customer Name:");

        TotalCostInv.setText("Invoice Total Cost:");

        IabelCName.setText("-");

        IabelTCost.setText("-");

        IabelInvDate.setText("-");

        IabelInvNumber.setText("-");

        NewInvButton.setText("Create Invoice");

        DeleteInvoiceButton.setText("Delete Invoice");

        AddLineButton.setText("Add Line");

        DeleteLineButton.setText("Delete Line");

        BarMenu.setText("File");

        MenuItemLoad.setText("Open File");
        MenuItemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                OpenMenuItemActionPerformed(evt);
            }
        });
        BarMenu.add(MenuItemLoad);

        MenuItemSave.setText("Save File");

        BarMenu.add(MenuItemSave);

        MenuJ.add(BarMenu);

        setJMenuBar(MenuJ);
        MenuJ.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(SPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(NumberInv))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(SPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(TotalCostInv)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(IabelTCost))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(CusName)
                                                                                        .addComponent(DateInv))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(IabelInvDate)
                                                                                        .addComponent(IabelCName)
                                                                                        .addComponent(IabelInvNumber)))))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(NewInvButton)
                                                .addGap(37, 37, 37)
                                                .addComponent(DeleteInvoiceButton)
                                                .addGap(68, 68, 68)
                                                .addComponent(AddLineButton)
                                                .addGap(118, 118, 118)
                                                .addComponent(DeleteLineButton)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(NumberInv)
                                                        .addComponent(IabelInvNumber))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(DateInv)
                                                        .addComponent(IabelInvDate))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(CusName)
                                                        .addComponent(IabelCName))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(TotalCostInv)
                                                        .addComponent(IabelTCost))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(SPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(SPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NewInvButton)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(DeleteInvoiceButton)
                                                .addComponent(AddLineButton)
                                                .addComponent(DeleteLineButton)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );


        DateInv.getAccessibleContext().setAccessibleName("jLabel2");

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);



    }

    public void runUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException excep) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, excep);
        }
        catch (InstantiationException excep) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, excep);
        }
        catch (IllegalAccessException excep) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, excep);
        }
        catch (javax.swing.UnsupportedLookAndFeelException excep) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, excep);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                View frme= null;
                try {
                    frme = new View();
                }
                catch (InterruptedException Excep) {
                    throw new RuntimeException(Excep);
                }
                frme.setVisible(true);
                FOperationHandler FOperationHandler = new FOperationHandler(frme);
                ArrayList<ApplicationHeader> inv= FOperationHandler.FRead();
                frme.setInvos(inv);
                InvoiceTableHandler invTable = new InvoiceTableHandler(inv);
                frme.setHeaderTable(invTable);
                frme.getInvHeaderTab().setModel(invTable);
                frme.getHeaderTab().fireTableDataChanged();

            }
        });
    }

    private javax.swing.JMenuItem MenuItemSave;
    private javax.swing.JMenuItem MenuItemLoad;
    private javax.swing.JMenuBar MenuJ;
    private javax.swing.JMenu BarMenu;

    private javax.swing.JButton AddLineButton;
    private javax.swing.JButton NewInvButton;
    private javax.swing.JButton DeleteLineButton;
    private javax.swing.JButton DeleteInvoiceButton;

    private javax.swing.JScrollPane SPJ1;
    private javax.swing.JScrollPane SPJ2;

    private javax.swing.JLabel CusName;
    private javax.swing.JLabel NumberInv;
    private javax.swing.JLabel DateInv;
    private javax.swing.JLabel TotalCostInv;

    private javax.swing.JLabel IabelTCost;
    private javax.swing.JLabel IabelInvDate;
    private javax.swing.JLabel IabelInvNumber;
    private javax.swing.JLabel IabelCName;

    private javax.swing.JTable InvLineTab;
    private javax.swing.JTable InvHeaderTab;

    private ControllerInv ctrl = new ControllerInv( this);
    private Events ActionTab = new Events(this);



    private ArrayList<ApplicationHeader> invos;





    public JLabel getIabelInvDate()
    {
        return IabelInvDate;
    }


    public ControllerInv getCtrl()
    {
        return ctrl;
    }


    public void setIabelInvDate(JLabel iabelInvDate)
    {
        this.IabelInvDate = iabelInvDate;
    }


    public JLabel getIabelInvNumber()
    {
        return IabelInvNumber;
    }

    private InvoiceTableHandler headerTable;

    public InvoiceTableHandler getHeaderTab()
    {
        return headerTable;
    }
    public void setHeaderTable(InvoiceTableHandler headerTable)
    {
        this.headerTable = headerTable;
    }
    public ArrayList<ApplicationHeader> getInvo()
    {

        if(invos ==null){
            invos = new ArrayList<>();
        }
        return invos;
    }

    public void setInvos(ArrayList<ApplicationHeader> invos)
    {
        this.invos = invos;
    }

    public JLabel getIabelCName()
    {
        return IabelCName;
    }

    public JLabel getIabelTCost()
    {
        return IabelTCost;
    }

    public JTable getInvHeaderTab()
    {
        return InvHeaderTab;
    }

    public JTable getInvLineTab()
    {
        return InvLineTab;
    }


    public int getTotalInvNo(){

        int No=0;
        for(ApplicationHeader invo: invos){
            if(invo.getHnumber()>No){
                No= invo.getHnumber();
            }
        }

        return No;
    }
}
