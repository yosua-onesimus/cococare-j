package view.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.sale.SaleLanguage;
//</editor-fold>

public class PnlConfig extends javax.swing.JPanel {

    public PnlConfig() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xMinimalProfit = new javax.swing.JLabel();
        txtMinimalProfit = new javax.swing.JTextField();
        xSalePriceRound = new javax.swing.JLabel();
        txtSalePriceRound = new javax.swing.JTextField();
        xPin = new javax.swing.JLabel();
        txtPin = new javax.swing.JTextField();
        xFormatChangePin = new javax.swing.JLabel();
        txtFormatChangePin = new javax.swing.JTextField();
        xFormatCheckSaldo = new javax.swing.JLabel();
        txtFormatCheckSaldo = new javax.swing.JTextField();
        xFormatCheckVoucherPrice = new javax.swing.JLabel();
        txtFormatCheckVoucherPrice = new javax.swing.JTextField();
        xFormatVoucherSelling = new javax.swing.JLabel();
        txtFormatVoucherSelling = new javax.swing.JTextField();
        xFormatComplain = new javax.swing.JLabel();
        txtFormatComplain = new javax.swing.JTextField();
        xCenterPhone = new javax.swing.JLabel();
        txtCenterPhone = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(600, 400));

        pnlEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, SaleLanguage.turn(SaleLanguage.Config), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        pnlEditor.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        btnSave.setText("Save & Calc");
        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xMinimalProfit.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xMinimalProfit.setText("Minimal Profit");

        txtMinimalProfit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xSalePriceRound.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xSalePriceRound.setText("Sale Price Round");

        txtSalePriceRound.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xPin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPin.setText("Pin");

        txtPin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormatChangePin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormatChangePin.setText("Format Change Pin");

        txtFormatChangePin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormatCheckSaldo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormatCheckSaldo.setText("Format Check Saldo");

        txtFormatCheckSaldo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormatCheckVoucherPrice.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormatCheckVoucherPrice.setText("Format Check Price");

        txtFormatCheckVoucherPrice.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormatVoucherSelling.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormatVoucherSelling.setText("Format Selling");

        txtFormatVoucherSelling.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xFormatComplain.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xFormatComplain.setText("Format Complain");

        txtFormatComplain.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xCenterPhone.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xCenterPhone.setText("Center Phone");

        txtCenterPhone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xMinimalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtMinimalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xSalePriceRound, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtSalePriceRound, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xPin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xFormatChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFormatChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xFormatCheckSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFormatCheckSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xFormatCheckVoucherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFormatCheckVoucherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xFormatVoucherSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFormatVoucherSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xFormatComplain, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtFormatComplain, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditorLayout.createSequentialGroup()
                        .addComponent(xCenterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCenterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xMinimalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinimalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xSalePriceRound, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalePriceRound, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormatChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatChangePin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormatCheckSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatCheckSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormatCheckVoucherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatCheckVoucherPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormatVoucherSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatVoucherSelling, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xFormatComplain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormatComplain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xCenterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCenterPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtCenterPhone;
    private javax.swing.JTextField txtFormatChangePin;
    private javax.swing.JTextField txtFormatCheckSaldo;
    private javax.swing.JTextField txtFormatCheckVoucherPrice;
    private javax.swing.JTextField txtFormatComplain;
    private javax.swing.JTextField txtFormatVoucherSelling;
    private javax.swing.JTextField txtMinimalProfit;
    private javax.swing.JTextField txtPin;
    private javax.swing.JTextField txtSalePriceRound;
    private javax.swing.JLabel xCenterPhone;
    private javax.swing.JLabel xFormatChangePin;
    private javax.swing.JLabel xFormatCheckSaldo;
    private javax.swing.JLabel xFormatCheckVoucherPrice;
    private javax.swing.JLabel xFormatComplain;
    private javax.swing.JLabel xFormatVoucherSelling;
    private javax.swing.JLabel xMinimalProfit;
    private javax.swing.JLabel xPin;
    private javax.swing.JLabel xSalePriceRound;
    // End of variables declaration//GEN-END:variables
}