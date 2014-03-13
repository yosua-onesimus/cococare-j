package ellusion;

import javax.swing.JButton;
import utility.Utility;

/**
 * @author Yosua Onesimus
 * @since 2010.07.02
 * @version 1.0.0
 */
public class FrmEllusion extends javax.swing.JFrame {

    private int step = 0;
    private JButton[][] aryButton;
    private int click = 0;
    private String[] aryChosen;

    public FrmEllusion() {
        initComponents();
        aryButton = new JButton[][]{
            {btn1, btn2, btn3, btn4},
            {btn5, btn6, btn7, btn8},
            {btn9, btn10, btn11, btn12},
            {btn13, btn14, btn15, btn16}
        };
        aryChosen = new String[4];
        Utility.doCenterScreen(this);
        updateScreen();
    }

    private void updateScreen() {
        tabStep.setSelectedIndex(step);
        btnBack.setVisible(step > 0);
        btnNext.setVisible(step < tabStep.getTabCount() - 1);
    }

    private void visibleOtherButton(JButton jButton) {
        //
        int row = -1;
        int column = -1;
        for (int index1 = 0; index1 < 4; index1++) {
            for (int index2 = 0; index2 < 4; index2++) {
                if (aryButton[index1][index2].equals(jButton)) {
                    row = index1;
                    column = index2;
                    aryChosen[click - 1] = (aryButton[index1][index2].getText());
                    aryButton[index1][index2].setEnabled(false);
                    break;
                }
            }
        }
        //
        for (int index1 = 0; index1 < 4; index1++) {
            for (int index2 = 0; index2 < 4; index2++) {
                if (index1 == row && index2 == column) {
                    continue;
                }
                if (index1 == row || index2 == column) {
                    aryButton[index1][index2].setVisible(false);
                }
            }
        }
        //
        jLabel4.setVisible(click >= 4);
        jLabel5.setVisible(click >= 4);
        btnNext.setVisible(click >= 4);
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
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblAnswer1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblAnswer2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblAnswer3 = new javax.swing.JLabel();
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

        tabStep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "(e)llusion II v.2010.07.02", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        tabStep.setEnabled(false);

        jPanel3.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("<html>\nWelcome to the (e)llusion II, ie an illusion shows in electronic media.<br/><br/>\nIn this application, you will select a number in accordance with your own. Then I'll be doing a process, so the numbers that you choose will become more meaningful.<br/><br/>\nClick [Next] to start the game.\n</html>");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("<html>\nSelamat datang di (e)llusion II, yaitu sebuah pertunjukkan ilusi di media elektronik.<br/><br/>\nDi aplikasi ini, Anda akan memilih sebuah bilangan sesuai dengan keinginanmu sendiri. Lalu saya akan akan melakukan sebuah proses, sehingga bilangan yang Anda pilih akan menjadi lebih bermakna.<br/><br/>\nKlik [Next] untuk memulai permainan.\n</html>");

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
        jLabel3.setText("<html>\nClick one of the numbers below. Then I'll eliminate a few other numbers.<br/>\nDo it repeatedly until only the remaining four numbers only!<br/>\n<hr>\nKlik salah satu bilangan di bawah ini. Lalu saya akan menghilangkan beberapa bilangan lainnya.<br/>\nLakukan berulang kali sampai hanya tersisa empat bilangan saja!<br/>\n</html>");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 10, 650, 90);

        btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1.setText("XXX");
        btn1.setFocusable(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn1);
        btn1.setBounds(240, 100, 70, 70);

        btn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2.setText("XXX");
        btn2.setFocusable(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn2);
        btn2.setBounds(310, 100, 70, 70);

        btn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3.setText("XXX");
        btn3.setFocusable(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn3);
        btn3.setBounds(380, 100, 70, 70);

        btn4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn4.setText("XXX");
        btn4.setFocusable(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn4);
        btn4.setBounds(450, 100, 70, 70);

        btn5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5.setText("XXX");
        btn5.setFocusable(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn5);
        btn5.setBounds(240, 170, 70, 70);

        btn6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn6.setText("XXX");
        btn6.setFocusable(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn6);
        btn6.setBounds(310, 170, 70, 70);

        btn7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7.setText("XXX");
        btn7.setFocusable(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn7);
        btn7.setBounds(380, 170, 70, 70);

        btn8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8.setText("XXX");
        btn8.setFocusable(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn8);
        btn8.setBounds(450, 170, 70, 70);

        btn9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn9.setText("XXX");
        btn9.setFocusable(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn9);
        btn9.setBounds(240, 240, 70, 70);

        btn10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn10.setText("XXX");
        btn10.setFocusable(false);
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn10);
        btn10.setBounds(310, 240, 70, 70);

        btn11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn11.setText("XXX");
        btn11.setFocusable(false);
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn11);
        btn11.setBounds(380, 240, 70, 70);

        btn12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn12.setText("XXX");
        btn12.setFocusable(false);
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn12);
        btn12.setBounds(450, 240, 70, 70);

        btn13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn13.setText("XXX");
        btn13.setFocusable(false);
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn13);
        btn13.setBounds(240, 310, 70, 70);

        btn14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn14.setText("XXX");
        btn14.setFocusable(false);
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn14);
        btn14.setBounds(310, 310, 70, 70);

        btn15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn15.setText("XXX");
        btn15.setFocusable(false);
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn15);
        btn15.setBounds(380, 310, 70, 70);

        btn16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn16.setText("XXX");
        btn16.setFocusable(false);
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButton(evt);
            }
        });
        jPanel4.add(btn16);
        btn16.setBounds(450, 310, 70, 70);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("<html>\nRemember these four numbers, if necessary, write on a piece of paper.<br/><br/>\nClick [Next] to continue the game.\n</html>");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 190, 230, 190);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("<html>\nIngat empat bilangan ini, bila perlu tulis di secarik kertas.<br/><br/>\nKlik [Next] untuk melanjutkan permainan.\n</html>");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel5);
        jLabel5.setBounds(520, 190, 230, 190);

        tabStep.addTab("Step I", jPanel4);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("<html>\nThe four numbers that you select is<br/>\n<hr>\nKeempat bilangan yang Anda pilih adalah<br/>\n</html>");

        lblAnswer1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswer1.setText("XXX, XXX, XXX, XXX");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><center>\nAnd if the four numbers are added together will produce numbers<br/>\n<hr>\nDan jika keempat bilangan tersebut dijumlahkan akan menghasilkan bilangan<br/>\n</center></html>");

        lblAnswer2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAnswer2.setText("<html>\nXXXX<br>\nXXXX<br>\nXXXX<br>\nXXXX +<br>\n<hr>\nXXXX<br>\n</html>");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("<html>\nYou know the meaning of these numbers?<br><br>\nNumbers are means\n</html>");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("<html>\nAnda tahu makna bilangan tersebut?<br><br>\nBilangan tersebut berarti\n</html>");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblAnswer3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblAnswer3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnswer3.setText("MMMM, dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(lblAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(lblAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabStep.addTab("Step II", jPanel2);

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
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        step++;
        updateScreen();
        if (step == 1) {
            click = 0;
            Object[][] todayMatrix = Utility.horizontalShuffle(Utility.verticalShuffle(Utility.getTodayMatrix()));
            for (int index1 = 0; index1 < 4; index1++) {
                for (int index2 = 0; index2 < 4; index2++) {
                    aryButton[index1][index2].setEnabled(true);
                    aryButton[index1][index2].setVisible(true);
                    aryButton[index1][index2].setText(todayMatrix[index1][index2].toString());
                }
            }
            visibleOtherButton(null);
        } else if (step == 2) {
            String string1 = "";
            String string2 = "<html>";
            int total = 0;
            for (String string : aryChosen) {
                if (string1.length() > 0) {
                    string1 += ", ";
                    string2 += "<br>";
                }
                string1 += string;
                string2 += string;
                total += Integer.parseInt(string);
            }
            lblAnswer1.setText(string1);
            string2 += " +<br><hr>" + total;
            lblAnswer2.setText(string2);
            lblAnswer3.setText(Utility.getString(Utility.TODAY, "MMMM, dd"));
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void selectButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButton
        click++;
        visibleOtherButton((JButton) evt.getSource());
}//GEN-LAST:event_selectButton

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
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAnswer1;
    private javax.swing.JLabel lblAnswer2;
    private javax.swing.JLabel lblAnswer3;
    private javax.swing.JTabbedPane tabStep;
    // End of variables declaration//GEN-END:variables
}