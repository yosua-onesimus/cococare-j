package view.form;

public class PnlQuestion extends javax.swing.JPanel {

    public PnlQuestion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditor = new javax.swing.JPanel();
        btnSave = new cococare.swing.component.CCButton();
        btnClose = new cococare.swing.component.CCButton();
        xQuestion = new javax.swing.JLabel();
        scrQuestion = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        xAnswer = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        xGift = new javax.swing.JLabel();
        txtGift = new javax.swing.JTextField();
        xGiftInfo = new javax.swing.JLabel();
        xPenalty = new javax.swing.JLabel();
        txtPenalty = new javax.swing.JTextField();
        xPenaltyInfo = new javax.swing.JLabel();
        xAutoAnswer = new javax.swing.JLabel();
        cmbAutoAnswer = new javax.swing.JComboBox();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        btnSave.setType(cococare.swing.component.CCButton.Type.SAVE);

        btnClose.setType(cococare.swing.component.CCButton.Type.CLOSE);

        xQuestion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xQuestion.setText("Pertanyaan");

        scrQuestion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtQuestion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtQuestion.setLineWrap(true);
        scrQuestion.setViewportView(txtQuestion);

        xAnswer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xAnswer.setText("Jawaban");

        txtAnswer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xGift.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xGift.setText("Gift");

        txtGift.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xGiftInfo.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        xGiftInfo.setText("<html>Gift bernilai 0 atau positif, 0: diam di tempat</html>");

        xPenalty.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPenalty.setText("Penalty");

        txtPenalty.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        xPenaltyInfo.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        xPenaltyInfo.setText("<html>Penalty bernilai 0 atau negatif, 0: diam di tempat, 1: kembali ke tempat sebelumnya</html>");

        xAutoAnswer.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xAutoAnswer.setText("Auto Answer");

        cmbAutoAnswer.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlEditorLayout = new javax.swing.GroupLayout(pnlEditor);
        pnlEditor.setLayout(pnlEditorLayout);
        pnlEditorLayout.setHorizontalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xGift, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtGift, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xGiftInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(xPenaltyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addComponent(xAutoAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmbAutoAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEditorLayout.setVerticalGroup(
            pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xGift, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGift, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xGiftInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xPenaltyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xAutoAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAutoAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JComboBox cmbAutoAnswer;
    private javax.swing.JPanel pnlEditor;
    private javax.swing.JScrollPane scrQuestion;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtGift;
    private javax.swing.JTextField txtPenalty;
    private javax.swing.JTextArea txtQuestion;
    private javax.swing.JLabel xAnswer;
    private javax.swing.JLabel xAutoAnswer;
    private javax.swing.JLabel xGift;
    private javax.swing.JLabel xGiftInfo;
    private javax.swing.JLabel xPenalty;
    private javax.swing.JLabel xPenaltyInfo;
    private javax.swing.JLabel xQuestion;
    // End of variables declaration//GEN-END:variables
}