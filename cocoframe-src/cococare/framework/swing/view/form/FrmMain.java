package cococare.framework.swing.view.form;

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class FrmMain extends javax.swing.JFrame {

    public FrmMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        north = new javax.swing.JPanel();
        northWest = new javax.swing.JPanel();
        aApplLogo = new cococare.swing.component.CCImage();
        aApplName = new javax.swing.JLabel();
        northEast = new javax.swing.JPanel();
        aCompLogo = new cococare.swing.component.CCImage();
        aCompName = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        aMenuBarH = new cococare.swing.component.CCMenuBar();
        aMenuBarV = new cococare.swing.component.CCMenuBar();
        aContent = new cococare.swing.component.CCImage();
        south = new javax.swing.JPanel();
        southWest = new javax.swing.JPanel();
        aCopyright = new javax.swing.JLabel();
        aApplVer = new javax.swing.JLabel();
        aProgressBar = new cococare.swing.component.CCProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frmMain"); // NOI18N

        north.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        north.setMinimumSize(new java.awt.Dimension(800, 60));
        north.setPreferredSize(new java.awt.Dimension(800, 60));
        north.setLayout(new java.awt.BorderLayout());

        northWest.setPreferredSize(new java.awt.Dimension(500, 60));

        aApplLogo.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        aApplLogo.setIconAutoFit(true);
        aApplLogo.setIconProportion(true);
        aApplLogo.setMinimumSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout aApplLogoLayout = new javax.swing.GroupLayout(aApplLogo);
        aApplLogo.setLayout(aApplLogoLayout);
        aApplLogoLayout.setHorizontalGroup(
            aApplLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        aApplLogoLayout.setVerticalGroup(
            aApplLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        aApplName.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        aApplName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout northWestLayout = new javax.swing.GroupLayout(northWest);
        northWest.setLayout(northWestLayout);
        northWestLayout.setHorizontalGroup(
            northWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northWestLayout.createSequentialGroup()
                .addComponent(aApplLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(aApplName, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        northWestLayout.setVerticalGroup(
            northWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aApplLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aApplName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        north.add(northWest, java.awt.BorderLayout.WEST);

        northEast.setPreferredSize(new java.awt.Dimension(300, 60));

        aCompLogo.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        aCompLogo.setIconAutoFit(true);
        aCompLogo.setIconProportion(true);
        aCompLogo.setMinimumSize(new java.awt.Dimension(60, 60));

        javax.swing.GroupLayout aCompLogoLayout = new javax.swing.GroupLayout(aCompLogo);
        aCompLogo.setLayout(aCompLogoLayout);
        aCompLogoLayout.setHorizontalGroup(
            aCompLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        aCompLogoLayout.setVerticalGroup(
            aCompLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        aCompName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        aCompName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout northEastLayout = new javax.swing.GroupLayout(northEast);
        northEast.setLayout(northEastLayout);
        northEastLayout.setHorizontalGroup(
            northEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(northEastLayout.createSequentialGroup()
                .addComponent(aCompName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(aCompLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        northEastLayout.setVerticalGroup(
            northEastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aCompName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aCompLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        north.add(northEast, java.awt.BorderLayout.EAST);

        getContentPane().add(north, java.awt.BorderLayout.NORTH);

        center.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        center.setMinimumSize(new java.awt.Dimension(800, 510));
        center.setPreferredSize(new java.awt.Dimension(800, 510));
        center.setLayout(new java.awt.BorderLayout());

        aMenuBarH.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        aMenuBarH.setMinimumSize(new java.awt.Dimension(800, 30));
        aMenuBarH.setPreferredSize(new java.awt.Dimension(800, 30));
        center.add(aMenuBarH, java.awt.BorderLayout.NORTH);

        aMenuBarV.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        aMenuBarV.setMinimumSize(new java.awt.Dimension(200, 510));
        aMenuBarV.setOrientation(cococare.swing.component.CCMenuBar.Orientation.VERTICAL);
        aMenuBarV.setPreferredSize(new java.awt.Dimension(200, 510));
        center.add(aMenuBarV, java.awt.BorderLayout.WEST);

        aContent.setIconAutoFit(true);
        aContent.setLayout(new java.awt.BorderLayout());
        center.add(aContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        south.setBorder(new javax.swing.border.LineBorder(java.awt.Color.cyan, 1, true));
        south.setMinimumSize(new java.awt.Dimension(800, 30));
        south.setPreferredSize(new java.awt.Dimension(800, 30));
        south.setLayout(new java.awt.BorderLayout());

        southWest.setMinimumSize(new java.awt.Dimension(200, 30));
        southWest.setPreferredSize(new java.awt.Dimension(200, 30));

        aCopyright.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        aCopyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aCopyright.setText("Copyright © 2013");

        aApplVer.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        aApplVer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aApplVer.setText("1.0.130317");

        javax.swing.GroupLayout southWestLayout = new javax.swing.GroupLayout(southWest);
        southWest.setLayout(southWestLayout);
        southWestLayout.setHorizontalGroup(
            southWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(southWestLayout.createSequentialGroup()
                .addComponent(aCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(aApplVer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        southWestLayout.setVerticalGroup(
            southWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aCopyright, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aApplVer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        south.add(southWest, java.awt.BorderLayout.WEST);

        aProgressBar.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        aProgressBar.setMinimumSize(new java.awt.Dimension(200, 30));
        aProgressBar.setPreferredSize(new java.awt.Dimension(200, 30));
        south.add(aProgressBar, java.awt.BorderLayout.EAST);

        getContentPane().add(south, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cococare.swing.component.CCImage aApplLogo;
    private javax.swing.JLabel aApplName;
    private javax.swing.JLabel aApplVer;
    private cococare.swing.component.CCImage aCompLogo;
    private javax.swing.JLabel aCompName;
    private cococare.swing.component.CCImage aContent;
    private javax.swing.JLabel aCopyright;
    private cococare.swing.component.CCMenuBar aMenuBarH;
    private cococare.swing.component.CCMenuBar aMenuBarV;
    private cococare.swing.component.CCProgressBar aProgressBar;
    private javax.swing.JPanel center;
    private javax.swing.JPanel north;
    private javax.swing.JPanel northEast;
    private javax.swing.JPanel northWest;
    private javax.swing.JPanel south;
    private javax.swing.JPanel southWest;
    // End of variables declaration//GEN-END:variables
}