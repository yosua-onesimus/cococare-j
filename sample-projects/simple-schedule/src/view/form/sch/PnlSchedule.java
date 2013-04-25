package view.form.sch;

public class PnlSchedule extends javax.swing.JPanel {

    public PnlSchedule() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnEdit = new cococare.swing.component.CCButton();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xRepetition = new javax.swing.JLabel();
        cmbRepetition = new javax.swing.JComboBox();
        xDateBegin = new javax.swing.JLabel();
        dtpDateBegin = new cococare.swing.component.CCDatePicker();
        xDateEnd = new javax.swing.JLabel();
        dtpDateEnd = new cococare.swing.component.CCDatePicker();
        xTimeBegin = new javax.swing.JLabel();
        txtTimeBegin = new cococare.swing.component.CCTimeInput();
        xTimeEnd = new javax.swing.JLabel();
        txtTimeEnd = new cococare.swing.component.CCTimeInput();
        xDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        xPerson = new javax.swing.JLabel();
        bndPerson = new cococare.swing.component.CCBandBox();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        pnlEditor.setMinimumSize(new java.awt.Dimension(600, 400));
        pnlEditor.setPreferredSize(new java.awt.Dimension(600, 400));
        pnlEditor.setLayout(null);

        btnEdit.setType(cococare.swing.component.CCButton.Type.EDIT);
        pnlEditor.add(btnEdit);
        btnEdit.setBounds(0, 10, 100, 29);

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);
        pnlEditor.add(btnSave);
        btnSave.setBounds(100, 10, 100, 29);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);
        pnlEditor.add(btnClose);
        btnClose.setBounds(200, 10, 100, 29);

        xRepetition.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xRepetition.setText("Repetition");
        pnlEditor.add(xRepetition);
        xRepetition.setBounds(0, 50, 100, 29);

        cmbRepetition.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(cmbRepetition);
        cmbRepetition.setBounds(100, 50, 150, 29);

        xDateBegin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xDateBegin.setText("Date");
        pnlEditor.add(xDateBegin);
        xDateBegin.setBounds(0, 80, 100, 29);
        pnlEditor.add(dtpDateBegin);
        dtpDateBegin.setBounds(100, 80, 130, 29);

        xDateEnd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xDateEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xDateEnd.setText("-");
        pnlEditor.add(xDateEnd);
        xDateEnd.setBounds(230, 80, 50, 29);
        pnlEditor.add(dtpDateEnd);
        dtpDateEnd.setBounds(280, 80, 130, 29);

        xTimeBegin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xTimeBegin.setText("Time");
        pnlEditor.add(xTimeBegin);
        xTimeBegin.setBounds(0, 110, 100, 29);

        txtTimeBegin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtTimeBegin);
        txtTimeBegin.setBounds(100, 110, 50, 29);

        xTimeEnd.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xTimeEnd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xTimeEnd.setText("-");
        pnlEditor.add(xTimeEnd);
        xTimeEnd.setBounds(150, 110, 50, 29);

        txtTimeEnd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtTimeEnd);
        txtTimeEnd.setBounds(200, 110, 50, 29);

        xDescription.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xDescription.setText("Description");
        pnlEditor.add(xDescription);
        xDescription.setBounds(0, 140, 100, 29);

        txtDescription.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlEditor.add(txtDescription);
        txtDescription.setBounds(100, 140, 250, 29);

        xPerson.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPerson.setText("Person");
        pnlEditor.add(xPerson);
        xPerson.setBounds(0, 170, 100, 29);
        pnlEditor.add(bndPerson);
        bndPerson.setBounds(100, 170, 250, 29);

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
    private cococare.swing.component.CCBandBox bndPerson;
    private cococare.swing.component.CCButton btnClose;
    private cococare.swing.component.CCButton btnEdit;
    private cococare.swing.component.CCButton btnSave;
    private javax.swing.JComboBox cmbRepetition;
    private cococare.swing.component.CCDatePicker dtpDateBegin;
    private cococare.swing.component.CCDatePicker dtpDateEnd;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JTextField txtDescription;
    private cococare.swing.component.CCTimeInput txtTimeBegin;
    private cococare.swing.component.CCTimeInput txtTimeEnd;
    private javax.swing.JLabel xDateBegin;
    private javax.swing.JLabel xDateEnd;
    private javax.swing.JLabel xDescription;
    private javax.swing.JLabel xPerson;
    private javax.swing.JLabel xRepetition;
    private javax.swing.JLabel xTimeBegin;
    private javax.swing.JLabel xTimeEnd;
    // End of variables declaration//GEN-END:variables
}