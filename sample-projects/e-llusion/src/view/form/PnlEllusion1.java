package view.form;

public class PnlEllusion1 extends javax.swing.JPanel {

    public PnlEllusion1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabStep = new javax.swing.JTabbedPane();
        pnlStep0 = new javax.swing.JPanel();
        lblStep0Left = new javax.swing.JLabel();
        lblStep0Right = new javax.swing.JLabel();
        pnlStep1 = new javax.swing.JPanel();
        lblStep1A = new javax.swing.JLabel();
        spnMax = new javax.swing.JSpinner();
        lblStep1BLeft = new javax.swing.JLabel();
        lblStep1BRight = new javax.swing.JLabel();
        pnlStep2 = new javax.swing.JPanel();
        lblStep2 = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSpan = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        tabStep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(e)llusion I", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tabStep.setEnabled(false);

        pnlStep0.setOpaque(false);

        lblStep0Left.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep0Left.setText("<html>\nWelcome to the (e)llusion I, ie an illusion shows in electronic media.<br/><br/>\nPlease choose one number you want according to your specified limit.<br/><br/>\nThe application is able to guess what number you choose through some of the questions given.<br/><br/>\nClick [Next] to start the game.\n</html>");

        lblStep0Right.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep0Right.setText("<html>\nSelamat datang di (e)llusion I, yaitu sebuah pertunjukkan ilusi di media elektronik.<br/><br/>\nSilahkan memilih satu bilangan yang Anda inginkan sesuai dengan batas limit yang Anda tentukan.<br/><br/>\nAplikasi mampu menebak bilangan yang Anda pilih lewat beberapa pertanyaan yang diberikan.<br/><br/>\nKlik [Next] untuk memulai permainan.\n</html>");

        javax.swing.GroupLayout pnlStep0Layout = new javax.swing.GroupLayout(pnlStep0);
        pnlStep0.setLayout(pnlStep0Layout);
        pnlStep0Layout.setHorizontalGroup(
            pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep0Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblStep0Left, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStep0Right, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlStep0Layout.setVerticalGroup(
            pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep0Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlStep0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStep0Right, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStep0Left, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabStep.addTab("Instruction", pnlStep0);

        pnlStep1.setOpaque(false);

        lblStep1A.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1A.setText("<html>\nSelect the limit of the number!<br/>\n<hr>\nPilih batas maksimum dari bilangan!\n</html>");

        spnMax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnMax.setValue(60);

        lblStep1BLeft.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1BLeft.setText("<html>If you are sure, please select a number from 1 up to "+spnMax.getValue().toString()+", remember these numbers.<br><br>Click [Next] to continue the game.</html>");
        lblStep1BLeft.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblStep1BRight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep1BRight.setText("<html>Jika Anda sudah yakin, silahkan pilih bilangan dari 1 sampai dengan "+spnMax.getValue().toString()+", ingat bilangan tersebut.<br><br>Klik [Next] untuk melanjutkan permainan.</html>");
        lblStep1BRight.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlStep1Layout = new javax.swing.GroupLayout(pnlStep1);
        pnlStep1.setLayout(pnlStep1Layout);
        pnlStep1Layout.setHorizontalGroup(
            pnlStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStep1Layout.createSequentialGroup()
                        .addComponent(lblStep1A, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStep1Layout.createSequentialGroup()
                        .addComponent(lblStep1BLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStep1BRight, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlStep1Layout.setVerticalGroup(
            pnlStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblStep1A, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStep1BLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStep1BRight, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
        );

        tabStep.addTab("Step I", pnlStep1);

        lblStep2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStep2.setText("<html>\nAre there numbers that you choose among the following set of numbers?<br/>\n<hr>\nApakah bilangan yang Anda pilih terdapat di antara kumpulan bilangan berikut ini?\n</html>");

        lblAnswer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblQuestion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnYes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnYes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Y.png"))); // NOI18N
        btnYes.setBorderPainted(false);
        btnYes.setContentAreaFilled(false);
        btnYes.setFocusable(false);
        btnYes.setIconTextGap(0);

        btnNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/N.png"))); // NOI18N
        btnNo.setBorderPainted(false);
        btnNo.setContentAreaFilled(false);
        btnNo.setFocusable(false);
        btnNo.setIconTextGap(0);

        javax.swing.GroupLayout pnlStep2Layout = new javax.swing.GroupLayout(pnlStep2);
        pnlStep2.setLayout(pnlStep2Layout);
        pnlStep2Layout.setHorizontalGroup(
            pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGroup(pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStep2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblStep2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStep2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStep2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        pnlStep2Layout.setVerticalGroup(
            pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStep2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStep2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabStep.addTab("Step II", pnlStep2);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BackG.png"))); // NOI18N
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusable(false);
        btnBack.setIconTextGap(0);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/NextG.png"))); // NOI18N
        btnNext.setBorderPainted(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setFocusable(false);
        btnNext.setIconTextGap(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(tabStep)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabStep, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnYes;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSpan;
    private javax.swing.JLabel lblStep0Left;
    private javax.swing.JLabel lblStep0Right;
    private javax.swing.JLabel lblStep1A;
    private javax.swing.JLabel lblStep1BLeft;
    private javax.swing.JLabel lblStep1BRight;
    private javax.swing.JLabel lblStep2;
    private javax.swing.JPanel pnlStep0;
    private javax.swing.JPanel pnlStep1;
    private javax.swing.JPanel pnlStep2;
    private javax.swing.JSpinner spnMax;
    private javax.swing.JTabbedPane tabStep;
    // End of variables declaration//GEN-END:variables
}