package library;


import javax.swing.JFileChooser;
import java.text.ParseException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UserInterfaceProduct {
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton13;
	private javax.swing.JLabel jLabel32;
	private javax.swing.JPanel jPanel10;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JTextField jTextField32;

	public javax.swing.JButton getJButton11() 
	{
		return jButton11;
	}

	public void setJButton11(javax.swing.JButton jButton11) 
	{
		this.jButton11 = jButton11;
	}

	public javax.swing.JButton getJButton13() {
		return jButton13;
	}

	public void setJButton13(javax.swing.JButton jButton13) {
		this.jButton13 = jButton13;
	}

	public javax.swing.JLabel getJLabel32() {
		return jLabel32;
	}

	public void setJLabel32(javax.swing.JLabel jLabel32) {
		this.jLabel32 = jLabel32;
	}

	public javax.swing.JPanel getJPanel10() {
		return jPanel10;
	}

	public void setJPanel10(javax.swing.JPanel jPanel10) {
		this.jPanel10 = jPanel10;
	}

	public javax.swing.JDialog getJDialog1() {
		return jDialog1;
	}

	public void setJDialog1(javax.swing.JDialog jDialog1) {
		this.jDialog1 = jDialog1;
	}

	public javax.swing.JTextField getJTextField32() {
		return jTextField32;
	}

	public void setJTextField32(javax.swing.JTextField jTextField32) {
		this.jTextField32 = jTextField32;
	}

	public void jButton11MouseClicked(java.awt.event.MouseEvent evt) {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().getPath();
			jTextField32.setText(filename);
		}
	}

	public void loadFiles() throws ParseException {
		jDialog1.pack();
		jDialog1.setVisible(true);
	}

	public void jButton10MouseClicked(java.awt.event.MouseEvent evt) {
		try {
			loadFiles();
		} catch (ParseException ex) {
			Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public void bookFileComponent(final UserInterface userInterface) {
		jPanel10.setBorder(javax.swing.BorderFactory
				.createTitledBorder(javax.swing.BorderFactory
						.createTitledBorder("Books file")));
		jLabel32.setText("Books file location?");
		jTextField32.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userInterface.jTextField32ActionPerformed(evt);
			}
		});
		jButton11.setText("Browse");
		jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton11MouseClicked(evt);
			}
		});
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				userInterface.jButton11ActionPerformed(evt);
			}
		});
		jButton13.setText("OK");
		jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				userInterface.jButton13MouseClicked(evt);
			}
		});
		javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(
				jPanel10);
		jPanel10.setLayout(jPanel10Layout);
		jPanel10Layout
				.setHorizontalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel10Layout
																		.createSequentialGroup()
																		.addComponent(
																				jTextField32,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				254,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				18,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton11))
														.addComponent(jLabel32)
														.addComponent(
																jButton13,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addContainerGap()));
		jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { jButton11, jButton13 });
		jPanel10Layout
				.setVerticalGroup(jPanel10Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel10Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel32)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel10Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField32,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton11))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												9, Short.MAX_VALUE)
										.addComponent(jButton13)));
		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jDialog1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel10,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jDialog1Layout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel10,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
	}
}