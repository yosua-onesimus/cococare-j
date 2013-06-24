package main;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.common.CCFormat;
import cococare.common.CCMath;
import cococare.swing.CCSwing;
import cococare.swing.CCSwing.LookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//</editor-fold>

public class DlgCalculator extends javax.swing.JDialog {

    private boolean operator = true;
    private double lastDigit = 0;
    private String lastOperator = "";

    public DlgCalculator(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        _init();
    }

    private void _init() {
        ActionListener alTypingCurr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _typingCurr(((JButton) actionEvent.getSource()).getText());
            }
        };
        CCSwing.addActionListener(btnPoint, alTypingCurr);
        CCSwing.addActionListener(btn0, alTypingCurr);
        CCSwing.addActionListener(btn1, alTypingCurr);
        CCSwing.addActionListener(btn2, alTypingCurr);
        CCSwing.addActionListener(btn3, alTypingCurr);
        CCSwing.addActionListener(btn4, alTypingCurr);
        CCSwing.addActionListener(btn5, alTypingCurr);
        CCSwing.addActionListener(btn6, alTypingCurr);
        CCSwing.addActionListener(btn7, alTypingCurr);
        CCSwing.addActionListener(btn8, alTypingCurr);
        CCSwing.addActionListener(btn9, alTypingCurr);
        ActionListener alTypingSign = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _typingCurrSign();
            }
        };
        CCSwing.addActionListener(btnSign, alTypingSign);
        ActionListener alTypingBackspace = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _typingCurrBackspace();
            }
        };
        CCSwing.addActionListener(btnBackspace, alTypingBackspace);
        ActionListener alClearCurr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _clearCurr();
            }
        };
        CCSwing.addActionListener(btnCE, alClearCurr);
        ActionListener alTypingOperator = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _typingOperator(((JButton) actionEvent.getSource()).getText());
            }
        };
        CCSwing.addActionListener(btnSquareRoot, alTypingOperator);
        CCSwing.addActionListener(btnPower, alTypingOperator);
        CCSwing.addActionListener(btnMultiplication, alTypingOperator);
        CCSwing.addActionListener(btnDivision, alTypingOperator);
        CCSwing.addActionListener(btnAddition, alTypingOperator);
        CCSwing.addActionListener(btnSubtraction, alTypingOperator);
        ActionListener alTypingEqual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _typingEqual();
            }
        };
        CCSwing.addActionListener(btnEqual, alTypingEqual);
        ActionListener alClearAll = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _clearAll();
            }
        };
        CCSwing.addActionListener(btnC, alClearAll);
    }

    private void _typingCurr(String string) {
        String labelCurr = operator ? "0" : txtLabelCurr.getText();
        if (".".equals(string)) {
            if (!labelCurr.contains(".")) {
                txtLabelCurr.setText(labelCurr + string);
            }
        } else if ("0".equals(labelCurr)) {
            txtLabelCurr.setText(string);
        } else {
            String digit = CCFormat.getDigit(labelCurr);
            if (digit.length() < 16) {
                txtLabelCurr.setText(labelCurr + string);
            }
        }
        operator = false;
        lastDigit = Double.parseDouble(txtLabelCurr.getText());
    }

    private void _typingCurrSign() {
        String labelCurr = txtLabelCurr.getText();
        if (!"0".equals(labelCurr)) {
            if (labelCurr.contains("-")) {
                txtLabelCurr.setText(labelCurr.replaceFirst("-", ""));
            } else {
                txtLabelCurr.setText("-" + labelCurr);
            }
        }
    }

    private void _typingCurrBackspace() {
        String labelCurr = txtLabelCurr.getText();
        if (!"0".equals(labelCurr)) {
            if (labelCurr.length() > 1) {
                txtLabelCurr.setText(labelCurr.substring(0, labelCurr.length() - 1));
            } else {
                txtLabelCurr.setText("0");
            }
        }
    }

    private void _clearCurr() {
        txtLabelCurr.setText("0");
        operator = false;
    }

    private void _typingOperator(String string) {
        String labelCurr = txtLabelCurr.getText();
        String labelPrev = txtLabelPrev.getText();
        if (operator) {
            if (labelPrev.length() > 1) {
                labelPrev = labelPrev.substring(0, labelPrev.length() - 1);
            }
            txtLabelPrev.setText(labelPrev + string);
        } else {
            txtLabelPrev.setText(labelPrev + labelCurr + string);
            operator = true;
        }
        labelPrev = txtLabelPrev.getText();
        if (labelPrev.length() > 1) {
            labelPrev = labelPrev.substring(0, labelPrev.length() - 1);
        }
        txtLabelCurr.setText(CCFormat.formatDecimal(CCMath.calculate(labelPrev)));
        lastOperator = string;
    }

    private void _typingEqual() {
        String labelCurr = txtLabelCurr.getText();
        String labelPrev = txtLabelPrev.getText();
        if (labelPrev.isEmpty()) {
            if (!lastOperator.isEmpty()) {
                txtLabelCurr.setText(CCFormat.formatDecimal(CCMath.calculate(labelCurr + lastOperator + lastDigit)));
            }
        } else {
            txtLabelPrev.setText("");
            txtLabelCurr.setText(CCFormat.formatDecimal(CCMath.calculate(labelPrev + labelCurr)));
            lastDigit = Double.parseDouble(labelCurr);
        }
        operator = true;
    }

    private void _clearAll() {
        txtLabelPrev.setText("");
        txtLabelCurr.setText("0");
        operator = false;
        lastDigit = 0;
        lastOperator = "";
    }

    public static void main(String[] args) {
        //basic config
        CCConfig.FMT_FRACTION_DIGITS_ALWAYS_SHOW = false;
        //set look and feel
        CCSwing.setLookAndFeel(LookAndFeel.WINDOWS.getName(), null);
        //
        DlgCalculator dlgCalculator = new DlgCalculator(null, false);
        CCSwing.centerScreen(dlgCalculator);
        dlgCalculator.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCalculator = new javax.swing.JPanel();
        pnlLabel = new cococare.swing.component.CCImage();
        txtLabelPrev = new javax.swing.JTextField();
        txtLabelCurr = new javax.swing.JTextField();
        btnBackspace = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnSign = new javax.swing.JButton();
        btnSquareRoot = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnDivision = new javax.swing.JButton();
        btnPower = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnMultiplication = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnSubtraction = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnPoint = new javax.swing.JButton();
        btnAddition = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlCalculator.setLayout(null);

        pnlLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlLabel.setLayout(null);

        txtLabelPrev.setEditable(false);
        txtLabelPrev.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        txtLabelPrev.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pnlLabel.add(txtLabelPrev);
        txtLabelPrev.setBounds(0, 0, 250, 29);

        txtLabelCurr.setEditable(false);
        txtLabelCurr.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        txtLabelCurr.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLabelCurr.setText("0");
        pnlLabel.add(txtLabelCurr);
        txtLabelCurr.setBounds(0, 30, 250, 59);

        pnlCalculator.add(pnlLabel);
        pnlLabel.setBounds(0, 0, 250, 90);

        btnBackspace.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnBackspace.setText("<");
        btnBackspace.setFocusable(false);
        pnlCalculator.add(btnBackspace);
        btnBackspace.setBounds(0, 90, 49, 49);

        btnCE.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnCE.setText("CE");
        btnCE.setFocusable(false);
        pnlCalculator.add(btnCE);
        btnCE.setBounds(50, 90, 49, 49);

        btnC.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnC.setText("C");
        btnC.setFocusable(false);
        pnlCalculator.add(btnC);
        btnC.setBounds(100, 90, 49, 49);

        btnSign.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSign.setText("±");
        btnSign.setFocusable(false);
        pnlCalculator.add(btnSign);
        btnSign.setBounds(150, 90, 49, 49);

        btnSquareRoot.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSquareRoot.setText("√");
        btnSquareRoot.setEnabled(false);
        btnSquareRoot.setFocusable(false);
        pnlCalculator.add(btnSquareRoot);
        btnSquareRoot.setBounds(200, 90, 49, 49);

        btn7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn7.setText("7");
        btn7.setFocusable(false);
        pnlCalculator.add(btn7);
        btn7.setBounds(0, 140, 49, 49);

        btn8.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn8.setText("8");
        btn8.setFocusable(false);
        pnlCalculator.add(btn8);
        btn8.setBounds(50, 140, 49, 49);

        btn9.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn9.setText("9");
        btn9.setFocusable(false);
        pnlCalculator.add(btn9);
        btn9.setBounds(100, 140, 49, 49);

        btnDivision.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnDivision.setText("/");
        btnDivision.setFocusable(false);
        pnlCalculator.add(btnDivision);
        btnDivision.setBounds(150, 140, 49, 49);

        btnPower.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnPower.setText("^");
        btnPower.setFocusable(false);
        pnlCalculator.add(btnPower);
        btnPower.setBounds(200, 140, 49, 49);

        btn4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn4.setText("4");
        btn4.setFocusable(false);
        pnlCalculator.add(btn4);
        btn4.setBounds(0, 190, 49, 49);

        btn5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn5.setText("5");
        btn5.setFocusable(false);
        pnlCalculator.add(btn5);
        btn5.setBounds(50, 190, 49, 49);

        btn6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn6.setText("6");
        btn6.setFocusable(false);
        pnlCalculator.add(btn6);
        btn6.setBounds(100, 190, 49, 49);

        btnMultiplication.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnMultiplication.setText("*");
        btnMultiplication.setFocusable(false);
        pnlCalculator.add(btnMultiplication);
        btnMultiplication.setBounds(150, 190, 49, 49);

        btn1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn1.setText("1");
        btn1.setFocusable(false);
        pnlCalculator.add(btn1);
        btn1.setBounds(0, 240, 49, 49);

        btn2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn2.setText("2");
        btn2.setFocusable(false);
        pnlCalculator.add(btn2);
        btn2.setBounds(50, 240, 49, 49);

        btn3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn3.setText("3");
        btn3.setFocusable(false);
        pnlCalculator.add(btn3);
        btn3.setBounds(100, 240, 49, 49);

        btnSubtraction.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnSubtraction.setText("-");
        btnSubtraction.setFocusable(false);
        pnlCalculator.add(btnSubtraction);
        btnSubtraction.setBounds(150, 240, 49, 49);

        btn0.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btn0.setText("0");
        btn0.setFocusable(false);
        pnlCalculator.add(btn0);
        btn0.setBounds(0, 290, 99, 49);

        btnPoint.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnPoint.setText(".");
        btnPoint.setFocusable(false);
        pnlCalculator.add(btnPoint);
        btnPoint.setBounds(100, 290, 49, 49);

        btnAddition.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnAddition.setText("+");
        btnAddition.setFocusable(false);
        pnlCalculator.add(btnAddition);
        btnAddition.setBounds(150, 290, 49, 49);

        btnEqual.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnEqual.setText("=");
        btnEqual.setFocusable(false);
        pnlCalculator.add(btnEqual);
        btnEqual.setBounds(200, 190, 49, 149);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAddition;
    private javax.swing.JButton btnBackspace;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnDivision;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnMultiplication;
    private javax.swing.JButton btnPoint;
    private javax.swing.JButton btnPower;
    private javax.swing.JButton btnSign;
    private javax.swing.JButton btnSquareRoot;
    private javax.swing.JButton btnSubtraction;
    private javax.swing.JPanel pnlCalculator;
    private cococare.swing.component.CCImage pnlLabel;
    private javax.swing.JTextField txtLabelCurr;
    private javax.swing.JTextField txtLabelPrev;
    // End of variables declaration//GEN-END:variables
}