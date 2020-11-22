import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aet00
 */
public class SearchAction extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form RegisterForm
     */
    public SearchAction() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeightUnits = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new JLabel();
        jLabelClose = new JLabel();
        jLabelMinimize = new JLabel();
        jPanel2 = new javax.swing.JPanel();
        jJButtonTopN = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(248, 148, 6));

        jLabelTitle.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new Color(255, 255, 255));
        jLabelTitle.setText("Search Engine");

        jLabelClose.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new Color(255, 255, 255));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                System.exit(1);
            	//jLabelCloseMouseClicked(evt);
            }
        });

        jLabelMinimize.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelMinimize.setForeground(new Color(255, 255, 255));
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitle)
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMinimize)
                .addGap(18, 18, 18)
                .addComponent(jLabelClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelClose)
                    .addComponent(jLabelMinimize))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(44, 62, 80));


        jJButtonTopN.setBackground(new Color(192, 57, 43));
        jJButtonTopN.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jJButtonTopN.setForeground(new Color(255, 255, 255));
        jJButtonTopN.setText("Top N");
        jJButtonTopN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jJButtonTopN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	jJButtonTopNCreateActionPerformed(evt);
            }

			private void jJButtonTopNCreateActionPerformed(ActionEvent evt) {
				EnterNvalue enterNvalue = new EnterNvalue();
				enterNvalue.setVisible(true);
				hideCur();
				
			}
        });
        
        JButton jJButtonSearchForTerm = new JButton();
        jJButtonSearchForTerm.setText("Search For Term");
        jJButtonSearchForTerm.setForeground(Color.WHITE);
        jJButtonSearchForTerm.setFont(new Font("Tahoma", Font.BOLD, 18));
        jJButtonSearchForTerm.setBackground(new Color(192, 57, 43));
        jJButtonSearchForTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	jJButtonTopNCreateActionPerformed(evt);
            }

			private void jJButtonTopNCreateActionPerformed(ActionEvent evt) {
				EnterSearchTerm enterTerm = new EnterSearchTerm();
				enterTerm.setVisible(true);
				hideCur();
				
			}
        });
        
        
        
        JLabel lblLoaded = new JLabel();
        lblLoaded.setText("Engine was loaded");
        lblLoaded.setForeground(new Color(236, 240, 241));
        lblLoaded.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lblLoaded_1 = new JLabel();
        lblLoaded_1.setText("&");
        lblLoaded_1.setForeground(new Color(236, 240, 241));
        lblLoaded_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lblLoaded_2 = new JLabel();
        lblLoaded_2.setText("Inverted indicies were constructed successfully!");
        lblLoaded_2.setForeground(new Color(236, 240, 241));
        lblLoaded_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        lblPleaseSelectAction = new JLabel();
        lblPleaseSelectAction.setText("Please Select Action");
        lblPleaseSelectAction.setForeground(new Color(236, 240, 241));
        lblPleaseSelectAction.setFont(new Font("Tahoma", Font.PLAIN, 20));
        

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(65)
        					.addComponent(lblLoaded_2, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(239)
        					.addComponent(lblLoaded_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(174)
        					.addComponent(lblLoaded, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(164)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jJButtonTopN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jJButtonSearchForTerm, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
        						.addComponent(lblPleaseSelectAction, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addGap(47)
        			.addComponent(lblLoaded, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLoaded_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLoaded_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addGap(27)
        			.addComponent(lblPleaseSelectAction, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jJButtonSearchForTerm, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addComponent(jJButtonTopN, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(230, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    protected void jLabelCloseMouseClicked(MouseEvent evt) {
		System.exit(1);
		
	}

	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAction().setVisible(true);
            }
        });
    }
    private void hideCur() {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup HeightUnits;
    private JButton jJButtonTopN;
    private JLabel jLabelClose;
    private JLabel jLabelTitle;
    private JLabel jLabelMinimize;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private JLabel lblLoaded_1;
    private JLabel lblLoaded_2;
    private JLabel lblPleaseSelectAction;
}