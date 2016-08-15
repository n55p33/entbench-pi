package org.apache.batik.apps.svgbrowser;
public class JAuthenticator extends java.net.Authenticator {
    public static final java.lang.String TITLE = "JAuthenticator.title";
    public static final java.lang.String LABEL_SITE = "JAuthenticator.label.site";
    public static final java.lang.String LABEL_REQ = "JAuthenticator.label.req";
    public static final java.lang.String LABEL_USERID = "JAuthenticator.label.userID";
    public static final java.lang.String LABEL_PASSWORD = "JAuthenticator.label.password";
    public static final java.lang.String LABEL_CANCEL = "JAuthenticator.label.cancel";
    public static final java.lang.String LABEL_OK = "JAuthenticator.label.ok";
    protected javax.swing.JDialog window;
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JButton okButton;
    protected javax.swing.JLabel label1;
    protected javax.swing.JLabel label2;
    protected javax.swing.JTextField JUserID;
    protected javax.swing.JPasswordField JPassword;
    final java.lang.Object lock = new java.lang.Object();
    private boolean result;
    private volatile boolean wasNotified;
    private java.lang.String userID;
    private char[] password;
    public JAuthenticator() { super();
                              initWindow(); }
    protected void initWindow() { java.lang.String title = org.apache.batik.apps.svgbrowser.Resources.
                                    getString(
                                      TITLE);
                                  window = new javax.swing.JDialog(
                                             (java.awt.Frame)
                                               null,
                                             title,
                                             true);
                                  java.awt.Container mainPanel = window.
                                    getContentPane(
                                      );
                                  mainPanel.setLayout(new java.awt.BorderLayout(
                                                        ));
                                  mainPanel.add(buildAuthPanel(),
                                                java.awt.BorderLayout.
                                                  CENTER);
                                  mainPanel.add(buildButtonPanel(
                                                  ), java.awt.BorderLayout.
                                                       SOUTH);
                                  window.pack();
                                  window.addWindowListener(new java.awt.event.WindowAdapter(
                                                             ) {
                                                               public void windowClosing(java.awt.event.WindowEvent e) {
                                                                   cancelListener.
                                                                     actionPerformed(
                                                                       new java.awt.event.ActionEvent(
                                                                         e.
                                                                           getWindow(
                                                                             ),
                                                                         java.awt.event.ActionEvent.
                                                                           ACTION_PERFORMED,
                                                                         "Close"));
                                                               }
                                                           });
    }
    protected javax.swing.JComponent buildAuthPanel() {
        java.awt.GridBagLayout gridBag =
          new java.awt.GridBagLayout(
          );
        java.awt.GridBagConstraints c =
          new java.awt.GridBagConstraints(
          );
        javax.swing.JPanel proxyPanel =
          new javax.swing.JPanel(
          gridBag);
        c.
          fill =
          java.awt.GridBagConstraints.
            BOTH;
        c.
          weightx =
          1.0;
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelS =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_SITE));
        labelS.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelS,
            c);
        proxyPanel.
          add(
            labelS);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        label1 =
          new javax.swing.JLabel(
            "");
        label1.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            label1,
            c);
        proxyPanel.
          add(
            label1);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelR =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_REQ));
        labelR.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelR,
            c);
        proxyPanel.
          add(
            labelR);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        label2 =
          new javax.swing.JLabel(
            "");
        label2.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            label2,
            c);
        proxyPanel.
          add(
            label2);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelUserID =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_USERID));
        labelUserID.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelUserID,
            c);
        proxyPanel.
          add(
            labelUserID);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        JUserID =
          new javax.swing.JTextField(
            20);
        gridBag.
          setConstraints(
            JUserID,
            c);
        proxyPanel.
          add(
            JUserID);
        c.
          gridwidth =
          1;
        javax.swing.JLabel labelPassword =
          new javax.swing.JLabel(
          org.apache.batik.apps.svgbrowser.Resources.
            getString(
              LABEL_PASSWORD));
        labelPassword.
          setHorizontalAlignment(
            javax.swing.SwingConstants.
              LEFT);
        gridBag.
          setConstraints(
            labelPassword,
            c);
        proxyPanel.
          add(
            labelPassword);
        c.
          gridwidth =
          java.awt.GridBagConstraints.
            REMAINDER;
        JPassword =
          new javax.swing.JPasswordField(
            20);
        JPassword.
          setEchoChar(
            '*');
        JPassword.
          addActionListener(
            okListener);
        gridBag.
          setConstraints(
            JPassword,
            c);
        proxyPanel.
          add(
            JPassword);
        return proxyPanel;
    }
    protected javax.swing.JComponent buildButtonPanel() {
        javax.swing.JPanel buttonPanel =
          new javax.swing.JPanel(
          );
        cancelButton =
          new javax.swing.JButton(
            org.apache.batik.apps.svgbrowser.Resources.
              getString(
                LABEL_CANCEL));
        cancelButton.
          addActionListener(
            cancelListener);
        buttonPanel.
          add(
            cancelButton);
        okButton =
          new javax.swing.JButton(
            org.apache.batik.apps.svgbrowser.Resources.
              getString(
                LABEL_OK));
        okButton.
          addActionListener(
            okListener);
        buttonPanel.
          add(
            okButton);
        return buttonPanel;
    }
    public java.net.PasswordAuthentication getPasswordAuthentication() {
        synchronized (lock)  {
            java.awt.EventQueue.
              invokeLater(
                new java.lang.Runnable(
                  ) {
                    public void run() {
                        label1.
                          setText(
                            getRequestingSite(
                              ).
                              getHostName(
                                ));
                        label2.
                          setText(
                            getRequestingPrompt(
                              ));
                        window.
                          setVisible(
                            true);
                    }
                });
            wasNotified =
              false;
            while (!wasNotified) {
                try {
                    lock.
                      wait(
                        );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
            if (!result)
                return null;
            return new java.net.PasswordAuthentication(
              userID,
              password);
        }
    }
    java.awt.event.ActionListener okListener =
      new java.awt.event.ActionListener(
      ) {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            synchronized (lock)  {
                window.
                  setVisible(
                    false);
                userID =
                  JUserID.
                    getText(
                      );
                password =
                  JPassword.
                    getPassword(
                      );
                JPassword.
                  setText(
                    "");
                result =
                  true;
                wasNotified =
                  true;
                lock.
                  notifyAll(
                    );
            }
        }
    };
    java.awt.event.ActionListener cancelListener =
      new java.awt.event.ActionListener(
      ) {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            synchronized (lock)  {
                window.
                  setVisible(
                    false);
                userID =
                  null;
                JUserID.
                  setText(
                    "");
                password =
                  null;
                JPassword.
                  setText(
                    "");
                result =
                  false;
                wasNotified =
                  true;
                lock.
                  notifyAll(
                    );
            }
        }
    };
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8Qn+XuCmIHQDf8W3G/8LARRT9/gsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C+wsV3nf3mvf62tjbGMwGIOx8YMAk/5n3zsbQ2B2Hjuz" +
       "O7OzOzP7mhLM7Lx33q99DDUBpBTUVJS2JqESsVqJNGnkAK0a9aU0tFEJETRS" +
       "aPpK1ZCgSCWlqFCpaVWapmdm9//a+/9f32uirHTOzpzn7/vO933nnO+cefm7" +
       "pWtxVIIC39kajp8caZvkaOk0jpJtoMVHPaYxlKNYUzFHjmMRpD2vPPWlB//4" +
       "B582H7paui6VXi97np/IieV7Ma/FvrPSVKb04Gkq4WhunJQeYpbySobTxHJg" +
       "xoqT55jSa85UTUrPMMcQYAABBhDgAgKMnpYClV6reamL5TVkL4nD0kdKV5jS" +
       "9UDJ4SWlt59vJJAj2d03MywoAC3cyN8ngKii8iYqPXlC+47mmwj+DAS/+LMf" +
       "fOgf3FV6UCo9aHlCDkcBIBLQiVS639XchRbFqKpqqlR6nadpqqBFluxYWYFb" +
       "Kj0cW4YnJ2mknTApT0wDLSr6POXc/UpOW5QqiR+dkKdbmqMev13THdkAtL7x" +
       "lNYdhWSeDgi8zwLAIl1WtOMqd9uWpyalJw5rnND4TB8UAFXvcbXE9E+6utuT" +
       "QULp4d3YObJnwEISWZ4Bil7zU9BLUnrs0kZzXgeyYsuG9nxSevSw3HCXBUrd" +
       "WzAir5KUHjksVrQERumxg1E6Mz7fHbznUx/2KO9qgVnVFCfHfwNUettBJV7T" +
       "tUjzFG1X8f53Mz8jv/FXP3m1VAKFHzkovCvzj/7S99//o2/78ld3Zd5yQRlu" +
       "sdSU5Hnl84sHfvut2Lvad+UwbgR+bOWDf47yQvyH+5znNgHQvDeetJhnHh1n" +
       "fpn/yvyjv6R952rpPrp0XfGd1AVy9DrFdwPL0aKu5mmRnGgqXbpX81SsyKdL" +
       "94BnxvK0XSqn67GW0KW7nSLpul+8AxbpoImcRfeAZ8vT/ePnQE7M4nkTlEql" +
       "e0Ao3Q9CrbT7Ff9JaQGbvqvBsiJ7lufDw8jP6Y9hzUsWgLcmvABSb8Oxn0ZA" +
       "BGE/MmAZyIGp7TPkIIjheGUsIn8daxHcQ9PEBJUtRQZCf5TLWvDn0ssmp/Wh" +
       "9ZUrYBjeemgEHKA/lO+oWvS88mLaIb7/hee/dvVEKfZcSkp5x0e7jo+Kjo/y" +
       "jo9OOz4633HpypWivzfkAHZDDgbMBqoPjOL97xJ+ovehTz51F5C1YH034HZe" +
       "FL7cNmOnxoIuTKICJLb05c+uPzb5yfLV0tXzRjYHDZLuy6sPc9N4YgKfOVSu" +
       "i9p98BPf/uMv/swL/qmanbPae+2/uWauvU8dsjfyFU0F9vC0+Xc/Kf/K87/6" +
       "wjNXS3cDkwDMYCIDsQUW5m2HfZzT4ueOLWJOyzVAsO5HruzkWcdm7L7EBGNx" +
       "mlKM+wPF8+sAj1+Ti/WbQZjt5bz4z3NfH+TxG3Zykg/aARWFxX2vEPzcf/it" +
       "P6oV7D42zg+eme4ELXnujEHIG3uwUP3XncqAGGkaKPefPzv8m5/57if+YiEA" +
       "oMTTF3X4TB5jwBCAIQRs/qmvhv/xm7/3+d+5eio0CZgR04VjKZsTIvP00n23" +
       "IBL09o5TPMCgOEDdcql5Zuy5vmrplrxwtFxK/++Dz1Z+5b996qGdHDgg5ViM" +
       "fvSVGzhNf3On9NGvffB/va1o5oqST2inPDsttrOSrz9tGY0ieZvj2HzsG4//" +
       "rd+Qfw7YW2DjYivTCrNVKnhQKgYNLuh/dxEfHeRV8uiJ+Kzwn9evMwuP55VP" +
       "/873Xjv53j//foH2/Mrl7FizcvDcTrzy6MkNaP5Nh5pOybEJytW/PPjAQ86X" +
       "fwBalECLCrBiMRcBe7M5Jxn70tfu+d1/8etv/NBv31W6Spbuc3xZJeVCyUr3" +
       "AunWYhOYqk3wvvfvBnd9A0QPFaSWbiJ+JxSPFm+PAoDvuty+kPnC41RFH/0/" +
       "nLP4+Lf+901MKCzLBfPtQX0Jfvlzj2E//p2i/qmK57XftrnZBoNF2mnd6i+5" +
       "//PqU9f/1dXSPVLpIWW/ApzITporjgRWPfHxshCsEs/ln1/B7Kbr505M2FsP" +
       "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" +
       "GgVsYMoZMJhgLtiCTWVN4dqVZYjrERM5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "fq84UPv/exoobMg6AAA=");
}
