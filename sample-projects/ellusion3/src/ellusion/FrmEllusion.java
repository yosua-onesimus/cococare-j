package ellusion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;
import utility.Utility;

/**
 * @author Yosua Onesimus
 * @since 2010.07.02
 * @version 1.0.0
 */
public class FrmEllusion extends javax.swing.JFrame {

    private int step = 0;
    private String[][] todayDict;
    private int todayDictIndex = 0;
    private String[] todayWords;
    private JButton[] aryButton1;
    private JButton[] aryButton2;
    private JButton[] aryButton3;
    private int aryButton3Index = -1;
    private int method = 0;
    private int methodStep = 0;
    private int left = 5;
    private Timer timer;
    private String sDisabled;

    public FrmEllusion() {
        initComponents();
        todayDict = Utility.getTodayDict();
        aryButton1 = new JButton[]{btn1, btn5, btn7};
        aryButton2 = new JButton[]{btn3, btn4, btn6, btn8, btn9};
        aryButton3 = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do {
                    aryButton3Index++;
                    if (aryButton3Index >= aryButton3.length) {
                        aryButton3Index = 0;
                    }
                } while (!aryButton3[aryButton3Index].isEnabled());
                if (aryButton3[aryButton3Index].isEnabled()) {
                    aryButton3Selected();
                    methodStep++;
                }
                if (method == methodStep) {
                    sDisabled += aryButton3[aryButton3Index].getText();
                    aryButton3[aryButton3Index].setEnabled(false);
                    left--;
                    methodStep = 0;
                }
                if (left == 0) {
                    aryButton3Index = -1;
                    aryButton3Selected();
                    jLabel4.setVisible(true);
                    jLabel5.setVisible(true);
                    btnNext.setVisible(true);
                    timer.stop();
                }
            }
        });
        Utility.doCenterScreen(this);
        updateScreen();
    }

    private void aryButton3Selected() {
        for (int i = 0; i < aryButton3.length; i++) {
            aryButton3[i].setBackground(i == aryButton3Index ? Color.RED : null);
        }
    }

    private void shuffle(JButton[] aryButton, Object[] word) {
        int i = 0;
        for (JButton jButton : aryButton) {
            while (i < word.length && word[i].toString().length() == 0) {
                i++;
            }
            if (i >= word.length) {
                break;
            }
            jButton.setText(word[i].toString());
            i++;
        }
    }

    private void shuffle() {
        shuffle(aryButton1, Utility.shuffle(todayWords[0].split("")));
        shuffle(aryButton2, Utility.shuffle(todayWords[1].split("")));
    }

    private void updateScreen() {
        tabStep.setSelectedIndex(step);
        btnBack.setVisible(step > 0);
        btnNext.setVisible(step < tabStep.getTabCount() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabStep = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnShuffle = new javax.swing.JButton();
        cmbMethod = new javax.swing.JComboBox();
        btnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblDisabled = new javax.swing.JLabel();
        lblEnabled = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblDisabled1 = new javax.swing.JLabel();
        lblEnabled1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnBlog = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(e)llusion II v.2010.07.02");
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setOpaque(false);

        tabStep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(e)llusion III RC v.2010.07.09", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tabStep.setEnabled(false);

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("<html>\nWelcome to the (e)llusion III, ie an illusion shows in electronic media.<br/><br/>\nIn this application, you will be given eight random letters, which then will be separated into two words by one of three ways that you choose.<br/><br/>\nClick [Next] to start the game.\n</html>");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("<html>\nSelamat datang di (e)llusion III, yaitu sebuah pertunjukkan ilusi di media elektronik.<br/><br/>\nDi aplikasi ini, Anda akan diberikan 8 huruf acak, yang kemudian akan dipisahkan menjadi dua kata berdasarkan satu dari tiga cara yang Anda pilih.<br/><br/>\nKlik [Next] untuk memulai permainan.\n</html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabStep.addTab("Instruction", jPanel3);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("<html>\nClick Shuffle to randomize letters.<br/>\nChoose a number, then click OK to divide the letters into two groups.<br/>\n<hr>\nKlik Shuffle untuk mengacak huruf.<br/>\nPilih angka, lalu klik OK untuk membagi huruf menjadi dua kelompok.<br/>\n</html>");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 10, 480, 80);

        btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1.setFocusable(false);
        jPanel4.add(btn1);
        btn1.setBounds(350, 90, 60, 60);

        btn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2.setText("!");
        btn2.setFocusable(false);
        jPanel4.add(btn2);
        btn2.setBounds(420, 120, 60, 60);

        btn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3.setFocusable(false);
        jPanel4.add(btn3);
        btn3.setBounds(470, 190, 60, 60);

        btn4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn4.setFocusable(false);
        jPanel4.add(btn4);
        btn4.setBounds(460, 260, 60, 60);

        btn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5.setFocusable(false);
        jPanel4.add(btn5);
        btn5.setBounds(390, 320, 60, 60);

        btn6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn6.setFocusable(false);
        jPanel4.add(btn6);
        btn6.setBounds(310, 320, 60, 60);

        btn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7.setFocusable(false);
        jPanel4.add(btn7);
        btn7.setBounds(240, 260, 60, 60);

        btn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8.setFocusable(false);
        jPanel4.add(btn8);
        btn8.setBounds(230, 190, 60, 60);

        btn9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn9.setFocusable(false);
        jPanel4.add(btn9);
        btn9.setBounds(280, 120, 60, 60);

        btnShuffle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShuffle.setText("Shuffle");
        btnShuffle.setFocusable(false);
        btnShuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShuffleActionPerformed(evt);
            }
        });
        jPanel4.add(btnShuffle);
        btnShuffle.setBounds(340, 190, 80, 40);

        cmbMethod.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cmbMethod.setMaximumRowCount(3);
        cmbMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "4", "5" }));
        cmbMethod.setFocusable(false);
        jPanel4.add(cmbMethod);
        cmbMethod.setBounds(320, 240, 60, 40);

        btnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOk.setText("OK");
        btnOk.setFocusable(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel4.add(btnOk);
        btnOk.setBounds(380, 240, 60, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("<html>\nThe letters were divided into two groups.<br>\nGroup \"enabled\" and group \"disabled\".<br><br>\nClick [Next] to continue the game.\n</html>");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 180, 220, 200);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("<html>\n<p align=\"right\">Huruf-huruf pun terbagi menjadi dua kelompok.<br>\nKelompok \"enabled\" dan kelompok \"disabled\".<br><br>\nClick [Next] to continue the game.</p>\n</html>");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel5);
        jLabel5.setBounds(530, 180, 220, 200);

        tabStep.addTab("Step I", jPanel4);

        lblDisabled.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDisabled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisabled.setText("XXXXX");

        lblEnabled.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblEnabled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnabled.setText("XXXXX");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("<html>\nGroup \"disabled\" consists of the letters:<br><br><br><br>\nWhile Group \"enabled\" consists of the letters:<br><br><br><br>\nLetters in each group can be formed into a word, that is..<br><br>\nClick [Next] to continue the game.\n</html>");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("<html>\nKelompok D terdiri dari huruf:<br><br><br><br>\nSedangkan Kelompok E terdiri dari huruf:<br><br><br><br>\nHuruf di tiap kelompok dapat dibentuk menjadi sebuah kata, yaitu..<br><br>\nClick [Next] to continue the game.\n</html>");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lblEnabled, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(lblDisabled, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblEnabled))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblDisabled))
        );

        tabStep.addTab("Step II", jPanel2);

        lblDisabled1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblDisabled1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisabled1.setText("XXXXX");

        lblEnabled1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblEnabled1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnabled1.setText("XXXXX");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDisabled1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnabled1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(lblDisabled1)
                .addGap(26, 26, 26)
                .addComponent(lblEnabled1))
        );

        tabStep.addTab("Step III", jPanel5);

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CloseG.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setFocusable(false);
        btnClose.setIconTextGap(0);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnBlog.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BlogG.png"))); // NOI18N
        btnBlog.setBorderPainted(false);
        btnBlog.setContentAreaFilled(false);
        btnBlog.setFocusable(false);
        btnBlog.setIconTextGap(0);
        btnBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlogActionPerformed(evt);
            }
        });

        btnAbout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/AboutG.png"))); // NOI18N
        btnAbout.setBorderPainted(false);
        btnAbout.setContentAreaFilled(false);
        btnAbout.setFocusable(false);
        btnAbout.setIconTextGap(0);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BackG.png"))); // NOI18N
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
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/NextG.png"))); // NOI18N
        btnNext.setBorderPainted(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setFocusable(false);
        btnNext.setIconTextGap(0);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBlog, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(tabStep, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(520, 520, 520)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlog, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(tabStep, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlogActionPerformed
        Utility.goToUrl("http://yosuaonesimus.wordpress.com/");
    }//GEN-LAST:event_btnBlogActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        Utility.showInformation("<html>Created by: Yosua Onesimus<br><hr>Dibuat oleh: Yosua Onesimus</html>");
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        step--;
        updateScreen();
        if (step == 0) {
            timer.stop();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        step++;
        updateScreen();
        if (step == 1) {
            todayWords = todayDict[todayDictIndex];
            todayDictIndex++;
            if (todayDictIndex >= todayDict.length) {
                todayDictIndex = 0;
            }
            shuffle();
            aryButton3Index = -1;
            aryButton3Selected();
            for (JButton jButton : aryButton3) {
                jButton.setEnabled(true);
            }
            btnShuffle.setVisible(true);
            cmbMethod.setVisible(true);
            btnOk.setVisible(true);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            btnNext.setVisible(false);
        } else if (step == 2) {
            String sEnabled = "";
            if (method == 3 || method == 4) {
                for (JButton jButton : aryButton1) {
                    sEnabled += jButton.getText();
                }
                lblDisabled1.setText(todayWords[1]);
                lblEnabled1.setText(todayWords[0]);
            } else if (method == 5) {
                for (JButton jButton : aryButton2) {
                    sEnabled += jButton.getText();
                }
                lblDisabled1.setText(todayWords[0]);
                lblEnabled1.setText(todayWords[1]);
            }
            lblDisabled.setText(sDisabled);
            lblEnabled.setText(sEnabled);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnShuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShuffleActionPerformed
        shuffle();
    }//GEN-LAST:event_btnShuffleActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        btnShuffle.setVisible(false);
        cmbMethod.setVisible(false);
        btnOk.setVisible(false);
        method = Integer.parseInt(cmbMethod.getSelectedItem().toString());
        methodStep = 0;
        if (method == 3 || method == 4) {
            left = 5;
        } else if (method == 5) {
            left = 3;
        }
        sDisabled = "";
        timer.start();
    }//GEN-LAST:event_btnOkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Utility.setNimbusLookAndFeel();
                new FrmEllusion().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBlog;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnShuffle;
    private javax.swing.JComboBox cmbMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblDisabled;
    private javax.swing.JLabel lblDisabled1;
    private javax.swing.JLabel lblEnabled;
    private javax.swing.JLabel lblEnabled1;
    private javax.swing.JTabbedPane tabStep;
    // End of variables declaration//GEN-END:variables
}