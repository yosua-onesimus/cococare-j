package view.form;

public class DlgGameOption extends javax.swing.JDialog {

    public DlgGameOption(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGameOption = new javax.swing.JPanel();
        chkQuestionShow = new javax.swing.JCheckBox();
        xPlayerNumber = new javax.swing.JLabel();
        txtPlayerNumber = new javax.swing.JTextField();
        pnlQuestion = new javax.swing.JPanel();
        xQuestionOrder = new javax.swing.JLabel();
        cmbQuestionOrder = new javax.swing.JComboBox();
        xQuestionNumber = new javax.swing.JLabel();
        txtQuestionNumber = new javax.swing.JTextField();
        xSquare = new javax.swing.JLabel();
        xQuestionTime = new javax.swing.JLabel();
        txtQuestionTime = new javax.swing.JTextField();
        xSecond = new javax.swing.JLabel();
        xQuestionAnswerShow = new javax.swing.JLabel();
        chkQuestionAnswerShow = new javax.swing.JCheckBox();
        pnlPlayer = new javax.swing.JPanel();
        imgIcon1 = new cococare.swing.component.CCImage();
        txtName1 = new javax.swing.JTextField();
        imgIcon2 = new cococare.swing.component.CCImage();
        txtName2 = new javax.swing.JTextField();
        imgIcon3 = new cococare.swing.component.CCImage();
        txtName3 = new javax.swing.JTextField();
        imgIcon4 = new cococare.swing.component.CCImage();
        txtName4 = new javax.swing.JTextField();
        imgIcon5 = new cococare.swing.component.CCImage();
        txtName5 = new javax.swing.JTextField();
        xGameMode = new javax.swing.JLabel();
        cmbGameMode = new javax.swing.JComboBox();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game Option");
        setResizable(false);

        pnlGameOption.setLayout(null);

        chkQuestionShow.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        chkQuestionShow.setSelected(true);
        chkQuestionShow.setText("Tampilkan Pertanyaan");
        pnlGameOption.add(chkQuestionShow);
        chkQuestionShow.setBounds(20, 10, 180, 29);

        xPlayerNumber.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xPlayerNumber.setText("Jumlah Pemain");
        xPlayerNumber.setOpaque(true);
        pnlGameOption.add(xPlayerNumber);
        xPlayerNumber.setBounds(350, 10, 140, 29);

        txtPlayerNumber.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPlayerNumber.setText("5");
        pnlGameOption.add(txtPlayerNumber);
        txtPlayerNumber.setBounds(490, 10, 50, 29);

        pnlQuestion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuestion.setLayout(null);

        xQuestionOrder.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xQuestionOrder.setText("Urutan Pertanyaan");
        pnlQuestion.add(xQuestionOrder);
        xQuestionOrder.setBounds(10, 30, 150, 29);

        cmbQuestionOrder.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlQuestion.add(cmbQuestionOrder);
        cmbQuestionOrder.setBounds(160, 30, 150, 29);

        xQuestionNumber.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xQuestionNumber.setText("Jumlah Pertanyaan");
        pnlQuestion.add(xQuestionNumber);
        xQuestionNumber.setBounds(10, 70, 150, 29);

        txtQuestionNumber.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtQuestionNumber.setText("25");
        pnlQuestion.add(txtQuestionNumber);
        txtQuestionNumber.setBounds(160, 70, 50, 29);

        xSquare.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xSquare.setText("kotak");
        pnlQuestion.add(xSquare);
        xSquare.setBounds(210, 70, 50, 29);

        xQuestionTime.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xQuestionTime.setText("Waktu Jawab");
        pnlQuestion.add(xQuestionTime);
        xQuestionTime.setBounds(10, 110, 150, 29);

        txtQuestionTime.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtQuestionTime.setText("30");
        pnlQuestion.add(txtQuestionTime);
        txtQuestionTime.setBounds(160, 110, 50, 29);

        xSecond.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xSecond.setText("detik");
        pnlQuestion.add(xSecond);
        xSecond.setBounds(210, 110, 50, 29);

        xQuestionAnswerShow.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xQuestionAnswerShow.setText("Tampilkan Jawaban");
        pnlQuestion.add(xQuestionAnswerShow);
        xQuestionAnswerShow.setBounds(10, 150, 150, 29);

        chkQuestionAnswerShow.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        chkQuestionAnswerShow.setSelected(true);
        chkQuestionAnswerShow.setText("Tampil");
        pnlQuestion.add(chkQuestionAnswerShow);
        chkQuestionAnswerShow.setBounds(160, 150, 150, 29);

        pnlGameOption.add(pnlQuestion);
        pnlQuestion.setBounds(10, 20, 320, 190);

        pnlPlayer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlPlayer.setLayout(null);

        imgIcon1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgIcon1.setIconAutoFit(true);
        imgIcon1.setIconProportion(true);

        javax.swing.GroupLayout imgIcon1Layout = new javax.swing.GroupLayout(imgIcon1);
        imgIcon1.setLayout(imgIcon1Layout);
        imgIcon1Layout.setHorizontalGroup(
            imgIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        imgIcon1Layout.setVerticalGroup(
            imgIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pnlPlayer.add(imgIcon1);
        imgIcon1.setBounds(10, 30, 29, 29);

        txtName1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlPlayer.add(txtName1);
        txtName1.setBounds(50, 30, 150, 29);

        imgIcon2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgIcon2.setIconAutoFit(true);
        imgIcon2.setIconProportion(true);

        javax.swing.GroupLayout imgIcon2Layout = new javax.swing.GroupLayout(imgIcon2);
        imgIcon2.setLayout(imgIcon2Layout);
        imgIcon2Layout.setHorizontalGroup(
            imgIcon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        imgIcon2Layout.setVerticalGroup(
            imgIcon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pnlPlayer.add(imgIcon2);
        imgIcon2.setBounds(10, 60, 29, 29);

        txtName2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlPlayer.add(txtName2);
        txtName2.setBounds(50, 60, 150, 29);

        imgIcon3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgIcon3.setIconAutoFit(true);
        imgIcon3.setIconProportion(true);

        javax.swing.GroupLayout imgIcon3Layout = new javax.swing.GroupLayout(imgIcon3);
        imgIcon3.setLayout(imgIcon3Layout);
        imgIcon3Layout.setHorizontalGroup(
            imgIcon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        imgIcon3Layout.setVerticalGroup(
            imgIcon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pnlPlayer.add(imgIcon3);
        imgIcon3.setBounds(10, 90, 29, 29);

        txtName3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlPlayer.add(txtName3);
        txtName3.setBounds(50, 90, 150, 29);

        imgIcon4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgIcon4.setIconAutoFit(true);
        imgIcon4.setIconProportion(true);

        javax.swing.GroupLayout imgIcon4Layout = new javax.swing.GroupLayout(imgIcon4);
        imgIcon4.setLayout(imgIcon4Layout);
        imgIcon4Layout.setHorizontalGroup(
            imgIcon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        imgIcon4Layout.setVerticalGroup(
            imgIcon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pnlPlayer.add(imgIcon4);
        imgIcon4.setBounds(10, 120, 29, 29);

        txtName4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlPlayer.add(txtName4);
        txtName4.setBounds(50, 120, 150, 29);

        imgIcon5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        imgIcon5.setIconAutoFit(true);
        imgIcon5.setIconProportion(true);

        javax.swing.GroupLayout imgIcon5Layout = new javax.swing.GroupLayout(imgIcon5);
        imgIcon5.setLayout(imgIcon5Layout);
        imgIcon5Layout.setHorizontalGroup(
            imgIcon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        imgIcon5Layout.setVerticalGroup(
            imgIcon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        pnlPlayer.add(imgIcon5);
        imgIcon5.setBounds(10, 150, 29, 29);

        txtName5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlPlayer.add(txtName5);
        txtName5.setBounds(50, 150, 150, 29);

        pnlGameOption.add(pnlPlayer);
        pnlPlayer.setBounds(340, 20, 210, 190);

        xGameMode.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        xGameMode.setText("Mode Permainan");
        pnlGameOption.add(xGameMode);
        xGameMode.setBounds(20, 220, 150, 29);

        cmbGameMode.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlGameOption.add(cmbGameMode);
        cmbGameMode.setBounds(170, 220, 150, 29);

        btnStart.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnStart.setText("Mulai Permainan");
        pnlGameOption.add(btnStart);
        btnStart.setBounds(370, 220, 150, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameOption, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGameOption, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JCheckBox chkQuestionAnswerShow;
    private javax.swing.JCheckBox chkQuestionShow;
    private javax.swing.JComboBox cmbGameMode;
    private javax.swing.JComboBox cmbQuestionOrder;
    private cococare.swing.component.CCImage imgIcon1;
    private cococare.swing.component.CCImage imgIcon2;
    private cococare.swing.component.CCImage imgIcon3;
    private cococare.swing.component.CCImage imgIcon4;
    private cococare.swing.component.CCImage imgIcon5;
    private javax.swing.JPanel pnlGameOption;
    private javax.swing.JPanel pnlPlayer;
    private javax.swing.JPanel pnlQuestion;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtName3;
    private javax.swing.JTextField txtName4;
    private javax.swing.JTextField txtName5;
    private javax.swing.JTextField txtPlayerNumber;
    private javax.swing.JTextField txtQuestionNumber;
    private javax.swing.JTextField txtQuestionTime;
    private javax.swing.JLabel xGameMode;
    private javax.swing.JLabel xPlayerNumber;
    private javax.swing.JLabel xQuestionAnswerShow;
    private javax.swing.JLabel xQuestionNumber;
    private javax.swing.JLabel xQuestionOrder;
    private javax.swing.JLabel xQuestionTime;
    private javax.swing.JLabel xSecond;
    private javax.swing.JLabel xSquare;
    // End of variables declaration//GEN-END:variables
}