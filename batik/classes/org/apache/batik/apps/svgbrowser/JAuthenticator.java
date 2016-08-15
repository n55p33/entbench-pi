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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xif4u4GbgtAN/BXfbvwvRASXGPgsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zr1n2f7rXv9bXj2I4TJ44Tx47tpEnUfaQkiqLqPExR" +
       "JEWJFCWSenFpHIpv8Sk+JEqZ0ybolmAdsmxz2gxIjQ1I165wk2xYsRe6ZiuW" +
       "pkhWoFn36rCmDQosXRYgGbBuWNZ1h5S+l+73Xd/rFP3wnSPyPH////n//+ec" +
       "/zl8+bula3FUKoeBuzHdIDnSs+Ro4daPkk2ox0ddtj5QoljXCFeJYwmkPa8+" +
       "9aUH//gHn7Yeulq6Lpder/h+kCiJHfixoMeBu9I1tvTgaSrp6l6clB5iF8pK" +
       "gdLEdiHWjpNn2dJrzlRNSs+wxxAgAAECEKACAoSflgKVXqv7qUfkNRQ/iZel" +
       "j5ausKXroZrDS0pvP99IqESKt29mUFAAWriRv48BUUXlLCo9eUL7juabCP5M" +
       "GXrxZz/00D+8q/SgXHrQ9sUcjgpAJKATuXS/p3tzPYpxTdM1ufQ6X9c1UY9s" +
       "xbW3BW659HBsm76SpJF+wqQ8MQ31qOjzlHP3qzltUaomQXRCnmHrrnb8ds1w" +
       "FRPQ+sZTWncUUnk6IPA+GwCLDEXVj6vc7di+lpSeOKxxQuMzPVAAVL3H0xMr" +
       "OOnqbl8BCaWHd2PnKr4JiUlk+yYoei1IQS9J6bFLG815HSqqo5j680np0cNy" +
       "g10WKHVvwYi8SlJ65LBY0RIYpccORunM+Hy3/95PfcTv+FcLzJquujn+G6DS" +
       "2w4qCbqhR7qv6ruK97+H/Rnljb/6yaulEij8yEHhXZl//Je+/9yPvu3LX92V" +
       "ecsFZfj5QleT59XPzx/47bcS727elcO4EQaxnQ/+OcoL8R/sc57NQqB5bzxp" +
       "Mc88Os78svCV2U/+kv6dq6X7mNJ1NXBTD8jR69TAC21Xj2jd1yMl0TWmdK/u" +
       "a0SRz5TuAc+s7eu7VN4wYj1hSne7RdL1oHgHLDJAEzmL7gHPtm8Ex8+hkljF" +
       "cxaWSqV7QCjdD0KttPsrfpPSHLICT4cUVfFtP4AGUZDTH0O6n8wBby1oDqTe" +
       "geIgjYAIQkFkQgqQA0vfZyhhGEPxypxHwTrWI6iLp4kFKtuqAoT+KJe18M+l" +
       "lyyn9aH1lStgGN56aARcoD+dwNX06Hn1xbRFfv8Lz3/t6olS7LmUlPKOj3Yd" +
       "HxUdH+UdH512fHS+49KVK0V/b8gB7IYcDJgDVB8YxfvfLf5498OffOouIGvh" +
       "+m7A7bwodLltJk6NBVOYRBVIbOnLn11/bPwT8NXS1fNGNgcNku7Lqw9y03hi" +
       "Ap85VK6L2n3wE9/+4y/+zAvBqZqds9p77b+5Zq69Tx2yNwpUXQP28LT59zyp" +
       "/Mrzv/rCM1dLdwOTAMxgogCxBRbmbYd9nNPiZ48tYk7LNUCwEUSe4uZZx2bs" +
       "vsQCY3GaUoz7A8Xz6wCPX5OL9ZtBmO7lvPjNc18f5vEbdnKSD9oBFYXFfZ8Y" +
       "/tx//K0/qhXsPjbOD56Z7kQ9efaMQcgbe7BQ/dedyoAU6Too918+O/hbn/nu" +
       "J/5iIQCgxNMXdfhMHhPAEIAhBGz+y19d/qdv/t7nf+fqqdAkYEZM566tZidE" +
       "5uml+25BJOjtnad4gEFxgbrlUvPMyPcCzTZsZe7quZT+3wffUfmV//6ph3Zy" +
       "4IKUYzH60Vdu4DT9za3ST37tQ//rbUUzV9R8Qjvl2WmxnZV8/WnLeBQpmxxH" +
       "9rFvPP63f0P5OWBvgY2L7a1emK1SwYNSMWhQQf97ivjoIK+SR0/EZ4X/vH6d" +
       "WXg8r376d7732vH3/sX3C7TnVy5nx5pTwmd34pVHT2ag+TcdanpHiS1QDvly" +
       "/4MPuV/+AWhRBi2qwIrFfATsTXZOMvalr93zu//y19/44d++q3SVKt3nBopG" +
       "KYWSle4F0q3HFjBVWfiB53aDu74BoocKUks3Eb8TikeLt0cBwHdfbl+ofOFx" +
       "qqKP/h/enX/8W//7JiYUluWC+fagvgy9/LnHiPd/p6h/quJ57bdlN9tgsEg7" +
       "rVv9Je9/Xn3q+r++WrpHLj2k7leAY8VNc8WRwaonPl4WglXiufzzK5jddP3s" +
       "iQl766F5OdPtoXE5tf3gOS+dP993YE8ezbn8dhCae1XDDu3JFaChbziYkBI7" +
       "2U3KHygaensRP5NHP1KM1F3547uAZsfF6jMBwGxfcfca/qfg7woI/y8PeXd5" +
       "wm66fpjYrxmePFk0hGDiuiYxEksWtR8By/NC4HL+HO1WeDuTl8fVPHpu10/9" +
       "UgH7sfPkvxOEZ/fk/9hF5L/5gHxXmevuEbCQBQ+4W/Egj9p5RBaMp5LSfSze" +
       "ItnnRUYi8xTmAHz/DsG/A4T37cG/9yLwj14IPtKXeZHRnWG/d4ddIIcXQR/f" +
       "IfR3gfCBPfT3XwT9LRdCT8FChSlw/fidob9/h34kksKu/iEBH7pDAt4DAr4n" +
       "4LmLCHj8QgJCsBlYB5GWl9PvjIQHdiQMcFGc8MKFRBivYhTaeyKI2x8FNTc5" +
       "xd7Fe1WjQOB9gmQvIsC/QwKeAYHaE0BeRMCbLiQgcPIS6Z2Bv7EDz/cuAr66" +
       "feAP5KmPg9DZA+/cBLxUPLxwMT5A1b1hFCRgctC1Y3DX12BjDNbxezNZLEOy" +
       "oxikmkfdNtjiB4eW8qN3iPhpEJg9YuYSxJ+4BHH++LETIdiJTytNkv2MfBPg" +
       "Xd4B4E/eIeAnQOjuAXcvAfzp2wF8I3BOAf21A1R/4w5RPQkCu0fFXoLqZ28H" +
       "1fVClCvHDHz4HAPZPO8A6WdfBVJuj5S7BOnfuX2kBYbPHWD6u3eIKZ/x+ntM" +
       "/Usw/cLtYLqnOyqmkmP2vfEc+ySwwCyWhAdwf/EO4f4ICPweLn8J3C/dDtx7" +
       "u4P9xHEM+LFzgI9zLwL9D24f9H3HPB7uQQ8vAf1PbwH6xGDe7Qaqc8HCbbew" +
       "PUD5z24fZe7qKb0FBHGPUrwE5b+61IDeE0b2CqwwT0QU7ExSN7n1JmMQ2R7Y" +
       "Ga/2TjnohYe/6Xzu27+8c7gd7igOCuuffPGv/unRp168esbN+fRNnsazdXau" +
       "zgLgawuU+R7t7bfqpahB/dcvvvDPf/GFT+xQPXzeaUf6qffL//5Pvn702d//" +
       "zQt8RPfMg8DVlUPD++u3PzSP5KnvBkHaD410ydB84+KhuZo/fgWY3FXggt2D" +
       "ezJAr1krcT9IwOZcL+T7awcY/+2rEJ/RHuPoEoy/ewsh/8qJ5JwuSQ/XBP/5" +
       "DjHla4LxHtP4Ekx/cDuYbhyvMoHEvONyeS4cFDvxfOnvPf1bP/HS039Q7PFv" +
       "2DHYWuKReYE3+0yd7738ze9847WPf6Hwg909V+LdJvPwGOBmL/85532B+f4T" +
       "RhTseQMg6IEdH3a/SWnxQ3pZ81MWZZ1AtqeYOqQGYEsNAWkyIImhqLYd6bmP" +
       "YnPs0/1z7G0nI1/da3j+83VgOVVrf+6T+0Ou7D2shcjk0R8dS8P3bqFF7zpn" +
       "i6+7um8m1kWd3QUGKH/8dpiddHl118651dnOeBNu4Ou5g+w4b+cgtoOjk6Mk" +
       "kJndBD4qvedySeQKgTj1ofzGx//bY9L7rQ/fgWf4iQNBPWzy73Mv/yb9TvVv" +
       "Xi3ddeJRuemc6XylZ8/7Ue6L9CSNfOmcN+Xx3XgU/NsNRh69o+Bw8X6hT+/K" +
       "XbfIu5ZHQOSvqTmrdyNzi+I3stKB3fnW7dudE2/rt/Z2599dbHeuvOZiSSud" +
       "eDYCJ3d15o6bY8F4vBAMoAZH+goozhFeuEmPS53HfOX+V4H5f+wx/+ElmN/w" +
       "Cpgf2G1EziC68tABrEdeEdZOl/Kt5rXqUeMIzmu95c42lm9auOozx86vMWAg" +
       "YNMzC7dx0ZxC3TYgoHEPnKotG/jmsz/9h5/++l9/+pvAyHdL11a5xxEozpmF" +
       "WT/Nz4f/ysufefw1L/7+Txd+eqC645/6wWPP5WQ9dWdkPZaTJRYmklXihCtc" +
       "67qWU3ahzQPSfrhHvX1qk9dPO0jM4Md/bEVpT9tq1prqGFSGOqLBsxi6IusB" +
       "2TAXENJq23xbyXijafKoXMGDOp80ZmN0I1DViFsFogPNZzqM1yURp50Ol8Jw" +
       "n3DIYehsYNprcayEUVzAkb0WzogVp+oSihsJEtodEsYEc/0RgqJCr9FSm2Aa" +
       "TprzJtSoRfVmuSZPy0hZGDqcr6I+sfY2kRBU1jbWQ1ta1cQmsswx6/KyFY/m" +
       "GDaF/I4LqwiLOQsB7zkKOVvzI6kVLGHJTdsUjtpTasYw9mjJS/DC2mj8ahQM" +
       "lrM1IYxpsVVxEnoC00LXpewOvdQYmICCkdSlZuRmOnNcuoquebrnDUx7JkSO" +
       "52y0lUoTo3GwDBNNtXw5xGtyY2jKak+QpZZINuF4gXtCtztwRGq4mdD9XheL" +
       "K2MNQdleHEsUF68op5xtuy0dElW2Bd5ZCDWRZtpZ+lY3NJc9Jurx7c3CypbL" +
       "ATlfjMZsUmHnTJ+mYmaMWeUxJfqA5SI5GFFW0AoEcqgs+5Ul2W6Iy8AhMXhp" +
       "YYPYDwKYFMa2zNANEq4NrZk0liRjSk+DYCbI1a2ZBXXUEDzb3jJ9FB2w7LZp" +
       "J1EnNv3KkHcmbhcdCbDg0rgp4zgnWly2tJI+Jtn9dh0PCTOrss2RO5SV6kTs" +
       "awq8aNsxIXKDTXUyxzfLMa1takLc0jmmOhCdDTVstidlhq9LlWWtxVDBrIXW" +
       "hp0l4q0pPW7Nug5pp24bX9laNmbWPdvNhFSu8xozozcIhXt4Irl4NVjKFCWa" +
       "xLjbUmB47AwFj28ybNRT+/hkaRN4eclt8UZM0dWE0HtACNcdWOSaWr/ikRVi" +
       "rDqcSWz6lemC1UlkK845LJBn20GsouN+pepG1GAj4ha8cPuCsKqx5sRLLdTr" +
       "tF1aWy/Wa1pMJ8IEk8JFecMg2JDpNbZkN4bbtVq9zEdS3apj1aUoI/BAorSE" +
       "E6RZ0Ajc8Wra6mEAKObSfdKBK91WhlE1prxpLBM3VkYti/L0KOzM8e18MdQa" +
       "/mor9qeG1IS6zESIQ9Id1b0hDnl2b0mMquJyinTHiplyrXDFoOORLRnb5kIW" +
       "23xTEBXKm2vG0CEpmd54Q308ETZ+uW3PFJPYCgI9z9hN2FquqjFBlzur3gwe" +
       "jsw10Iy2z9JsGTPKXEYwCyXo0i2KGnbJSV/j4yWyUG2yQ9mzfiqI+AYzFoK9" +
       "JB1t2iZsNOYE3MhMiwr65nImgyox31MiJMP7TLnSF6UZse0ygdnnO7Cmw1t4" +
       "3CMiiu8My9SsZfHYcNai9fmAdyf8qFYZ1rquCtdYbBVTvjQ02uKEkm2BHHXa" +
       "M8pq+CaHBzyPsO15TDoUD8hZkkQ9bLdNpkZUGGM2adBwE4mqkhRP6gG/UnSO" +
       "mtGwM9UtxawvtTKNd5qjTjaka25ijlfR1LQXmUCKCmzGy6GJ1FkxxJvtuNXt" +
       "RIarkrPBeDN2nLqnxmRko6gSMkhGLExrxi7rqqjNtssJBzEJs9YbxIjrVmNH" +
       "xztZRcbUWntcnhvQWC6LwmCgoybBsIwytPStRmM1aTRftWm80SwvUWCNY7pV" +
       "bSiR5AlrVpKq5XBB2YI50Rc1QqnXW6rmYojaaQmNWU1l+ekwFTw8XsMEE25X" +
       "Ulc1FUNopz0mHA7xNuqiw5DINnM5o4EqNmvUMu0lPKJD0pqo9VRxzpupzlYS" +
       "yYEaVCUN5m67z1dgFcN6wOqpY3qlpdrKr0E1lq6n+rYabh2T1G032jKWVaWc" +
       "ZFGRpQ5rJPDGodKFVtOAVa54g+m8jJeJTGQhfFid9R0uHqY0yW2xpqLXVp05" +
       "EknVDmatIblBMN0qPyTQqciwtO7yI5zQehN+EOLt7tAaLtvTfi+brttllxl5" +
       "zEYY+hW/vKTQJoIRWK0iW2WG5PuNEVgIz812WGtMaJ/txxWtzHe1Gpl1s/ZU" +
       "jushIZvT6hKu8VJkJvPRDBolIjQxIDVERvUZY+Mx3WSqG5tLEGlmGv02jxiL" +
       "AcJPZT+ab2PKiuX2EtJrdbdOLttIXO3UllBsQJCAVLK51uiNeW2mmYkcpJY6" +
       "ESvsEBpmK5UKfJro4xo0b20DuILF9CDg1BZK0eSaTmBUwO3RpjGIeyZrV5oQ" +
       "xPihV2kw3ZqXhGQ2saZ2tCZUuTecrsJ4xgh9faStqCUQqo6IEgEybnWpFbC8" +
       "C2k9GJQtBXaDRStpVDFua0ThplFGa2lXC2WrueU7mNbys+mYH4Xpls8atUa4" +
       "6ho1Y5VW1elAmGaBupUyjIMgravqqQ4lxkSc+6q69hmjs27DUrW2pRu6Nm74" +
       "fazb4xaaw4V6SABlbGR+LawhcrNBBC7kOjrTGtl9pTftQQyhZZ5ZxyfeYqZL" +
       "vAMr9aqGhH59wffRWatuL/SZPFtUrEXXV2dCLeTmNbDEgL3Abac4oRPopmvM" +
       "kZoejMyOs91GfYubefMJHM8afDiZbho44g+by0GE0swMmQ3aFT/o2g7BMr4f" +
       "b9aZ4TEtWSknUT0gyvqMGMeLhtcKnAYhN8OwRamrbTwxa+Uqwmk85fXLQxdr" +
       "C0psQ7C53bJ4xZnM3CE/XG+9dJBsEVWxSSROOxg+bZmWy5FZX6ksbbNRSQyx" +
       "MoPL/ZY+cEhSROn6pstWyQCy2v0mqYcwUWc4yYrMjUnIi66o4J1EYVeDdlL1" +
       "iDKL4FtsMomocbnMzxHESYhOYleppUt3zUo2nrVmgh1yNliNTQCXmDE6gk1B" +
       "YAPe3wi9WtVsuiux2WtLsoOggS40gsTBlDrv4GumMvK2KerVkgab1kLM0ZcS" +
       "zZUrbtz2nKw5IEecUasKqbeV+LpJZKhBxfM0jOeBjwbzbGna5hyhvUrGTpFA" +
       "3lp2hXWriLKSrNASkRbTMmNKaFqVpVBGozqMpfYyjmaa74vj5VSYoWu3mWK4" +
       "2oLJuDKdTNa1Po20YMpdeHXLEbyp217EDQj3o9YQq8Ap1VZMrR3pK3coyE0R" +
       "mfRhZFixu0jV3tbnQ3o9X2jWzKCTOV9tp1ynLeGa7lQlbuNUN1zXSjrmptEN" +
       "LKuz2CauNU9wwS77Wb9Ntg3EaUdLtGN3hCZpSFRbKBstkh13BJycAu0ewnYr" +
       "US217FFzRVYqFW/h9eYC5DadClFeZ6xBKm0Mkrxxu9yruhImGeVabTnwJEJZ" +
       "dtMR7XcVczvkqh11GcgZV2FUI0FXsaQIYSPlgCaFPIzBxszUOzZBkCgVYisx" +
       "EGN8rdIqwfQQZohWtMqKDZGKlZhpu6YvOwhES1mF8haY4Lq2Mm3pLaRrt+yy" +
       "OW3A1rbJaVa6LPcCCQ6T+YLDRp16E3Pba7nLcmBOmJIJPMf5ibvmW0bE+6LH" +
       "EUELbtYXTt0S4/akLzrbJkaqHb9R6XocjTYV1+JEh9NTsqxuU0nv8VaKLOqO" +
       "vHHNclsc6zW21l1AaDr3y5zP2WNE6mv+vI5s2imtNHmaQ1BcGZWTASJi5HZj" +
       "IAErA8OKWZWFMM+w6RYuG1Ta6vCpMqjgjBVHWxjTY0PQYRivpdXIqi/S6sDv" +
       "SxhXa0jiYKJmrAWP5TqEygN+Tplrp2NvNSFdT+phh+ArC0yrDhpbQ0tX/cZk" +
       "qQllK9ksuhlbXRmDTNX7xsqHyHosVvmlEnItcdwMrVbPbwi8ipQHxCRK+mgI" +
       "qdN+Ynix3puYi+7Ipaphz5lPO7VxZMxEbrZpxZs6zONjz2it1ZbZZWf9DGMX" +
       "5UDu1yBpGU+H4cAvT1xjSKcGtjWaxmDdHI9nQ0wb0ca8F/sqIXEroS8OXARh" +
       "haXUDcUeg5GrGo+XxZVTX7TRTSUE2w/c4AmyMtY3YD0x7MPZRC6v3K3EQX6P" +
       "UDzaqE4QFsWbEsb3dGWorbkG5sUIX0ZVB+kQUzAAbLTIVozf2fbLZU7tSH2j" +
       "RsC0LqL1pg6vyH7WHWAWQSJJHUieQte3vjKQZbtZt6wZZEGraSiEpOC08fIE" +
       "G8gT0TS5RYVutCRlQ7mNui33mxuoX7fV3jpemAhKT2capA+oRQVq6nXKKLd8" +
       "n5iIsAgFZEdusja+1fsNw4DsJrVZRY3yoIbjo9lKqeCAlPp2js40rVrDEjq0" +
       "7O4I4PfQikxmnXKHazYMczQed1gylduMTQ/qWB8dh/SKWmGjDS7B9TK+FAdI" +
       "Uq4O+LELrZ2hlwaGypj+uiXNpoYFZyNb5oPITxqWUwVWZ6Bic6tDztItBZdF" +
       "uVylEymd0VTowES1jyXzGULivWSwLW+HTXodC+seQivOJqkEsgf+dU3UPHig" +
       "ua3+0F0aFBZhNhJ5s63QZnu6MXMTrWtobY0fN7lmZVNTazqGoshYC3AET5xg" +
       "1JhKskRU/D41xo25wy+mK6TfiDokDU2m");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("U5bfNiOaQrbOJGGibtIwg4SG2vAgTIkN0vLjsT4JUQjB0io03vRm3Rqx4LHK" +
       "olstTwY8NINUzBExeYZBnkfqkqI3Rx7lob7gi8oIlYeupk40mtj2aov+KuHk" +
       "StBU5Y6KdaseScbTbq9WSV2479SrcYNiYmatkX6spga3zlI+c4dhw1/AtKgr" +
       "JuuvtIiwRXWAOvwA1vurrlYlFGtMzNMOTUw63GxGV/nEncVsMKt3nKSnWpsB" +
       "zAZUJgebiZwMJW48tsaBwU7JbWSg8ZYRQ2QKpAJCu97GY/ozNdR9Ho5U3SYh" +
       "uVwjt14whGtUX1mp2FZoCt5stqGriFxjZ5niZXDdXKTjVK1L7oyDW/qY5xPL" +
       "nNAZkNrRRl4pqwHfQcd+i6tjSFcKxI0KJHg+TwfQujYMMVqqDaW2HscNrryI" +
       "eKjXZVd0s6apHlfTE6Mvc3oZTSPCXMyHsCtvo3Vn2zFXsD9Eux16Ma7bNSB5" +
       "BsV0h/yqSU6bXZzqdMtYh9T7sjsW0hDzRHKNzJvcJAUbXmfFikQH8mFvmrWH" +
       "jjRU54TBuc5ait0h5pTZcKzCFXTgzVIRlYnGYip3Fq6ooT1hU1nQVMObDKB6" +
       "FjQqo65aG9Cga7yxmvMohhppXasvVS2wsxjM202XBGZ3Wncdt5FSplSVV9o4" +
       "oRuhUJnW3A1aJREuDGOWB0uyRdoe6zQzgrXuQvZTTF8wc7i+Lq8aY7+O0s0q" +
       "xcJMaoxo0mLAsiywyk2kHoojMCuZw62GssNqhAMjE0wHy2akJDwNRXMayjy/" +
       "bjWaFZ5AhwY1rKUrnfcm3nTlAWO+6bsMs8msPjZcZck4HXfsJY8OeWe06Cqj" +
       "Rdad1RkzBcZirC/meNKA1CiZ1Zdgti33OsPZOt62G/5mgKpLJ5tkqFcWHHhp" +
       "8CrHI8ImxGRer6zlYYWVBnjGS6oCWGLXO2k/MCmVFxYxvJUQerNK3cw2kBSh" +
       "52aC96HW1Jiv1isBF6f0wIxxHH9f7vo7ujPX3+sKj+bJRxuvwpeZnXGmn3h+" +
       "i7/rpYOL/mc8v0XJR/de3jgqPX7ZtxjFUennP/7iSxr/85Wre5fwv0lK9yZB" +
       "+BdcfaW7Z5q6u3j+k5tvl3xwD+ODhw7oU0Jvea5/C68+fos8Io/em+Qna3Yy" +
       "Ob33c+hQXQW2durKft8r+VLPdnNAcX7pvLjMEO4pDv/sKR7cIk/Io15SemAO" +
       "bIiW3+gaKP5+jG66vJF70gNf3391VdDO/rC050faL+9pf/nPnvYP3SLvw3k0" +
       "S0oPFbTvLiIV1Ofp0imN8g9B41N5Yn4N9tf2NP7andL4rlekcXGLvIIWPSm9" +
       "2dST46ssZ+7t2af3xJ4oTit8PTm6RbmCH694F/LcVXMgW+dvCuaX+R+96YO7" +
       "3Udi6hdeevDGm14a/Yfd0ffxh1z3sqUbRuq6Z+9en3m+Hka6YRd8und3Ezss" +
       "iE+T0pOv9HEOUPbTlxz9lWRXGQB/5MLKQP/zn7NlPwKE6LBsUrpW/J4t99H8" +
       "OO+kXFK6vns4W+RjSekuUCR//Hh4Tg2LsTnHyezKebN8Yv8ffqUROmPJnz53" +
       "eFx8L3l80Jvuvph8Xv3iS93+R76P/vzuAxfVVbbbvJUbbOme3bc2J4fFb7+0" +
       "teO2rnfe/YMHvnTvO47nhgd2gE/V4Ay2Jy7+moT0wqT4/mP7T970j977Cy/9" +
       "XnGg9v8BalDcnsg6AAA=");
}
