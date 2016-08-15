package org.apache.batik.util.gui;
public class LocationBar extends javax.swing.JPanel {
    protected static final java.lang.String RESOURCES = "org.apache.batik.util.gui.resources.LocationBar";
    protected static java.util.ResourceBundle bundle;
    protected static org.apache.batik.util.resources.ResourceManager rManager;
    static { bundle = java.util.ResourceBundle.getBundle(RESOURCES, java.util.Locale.
                                                           getDefault(
                                                             ));
             rManager = new org.apache.batik.util.resources.ResourceManager(
                          bundle); }
    protected javax.swing.JComboBox comboBox;
    public LocationBar() { super(new java.awt.BorderLayout(5, 5));
                           javax.swing.JLabel label = new javax.swing.JLabel(
                             rManager.
                               getString(
                                 "Panel.label"));
                           add("West", label);
                           try { java.lang.String s = rManager.getString(
                                                                 "Panel.icon");
                                 java.net.URL url = getClass().getResource(
                                                                 s);
                                 if (url != null) { label.setIcon(
                                                            new javax.swing.ImageIcon(
                                                              url));
                                 } }
                           catch (java.util.MissingResourceException e) {
                               
                           }
                           add("Center", comboBox = new javax.swing.JComboBox(
                                                      ));
                           comboBox.setEditable(true); }
    public void addActionListener(java.awt.event.ActionListener listener) {
        comboBox.
          addActionListener(
            listener);
    }
    public java.lang.String getText() { return (java.lang.String)
                                                 comboBox.
                                                 getEditor(
                                                   ).
                                                 getItem(
                                                   ); }
    public void setText(java.lang.String text) { comboBox.
                                                   getEditor(
                                                     ).
                                                   setItem(
                                                     text);
    }
    public void addToHistory(java.lang.String text) { comboBox.
                                                        addItem(
                                                          text);
                                                      comboBox.
                                                        setPreferredSize(
                                                          new java.awt.Dimension(
                                                            0,
                                                            comboBox.
                                                              getPreferredSize(
                                                                ).
                                                              height));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HdYYjGcM1W95K/x9EFYScdsA4sEQ4JpYwHZy3UUx1EAd7jiV7YdLRI6k0yDY" +
       "KdRwj6g+sexEUxfb3lWikv8eDvs4aabJpB/VLFlvDhtyGlqyKduVoztb3py8" +
       "550H7TCe17H6gNme/bd+Ftm737Je69JvRd69mxfHuvizvB2H3ehDy0vtIjA2" +
       "/OnozscP77zFCWG3clI+pclJ19NvP10aLV3840SPLub35hTagmsL4aG2QumZ" +
       "20Ix1BKafLDE2lEcDnNSOc74VtAl/hx1pXD/5yAF4RFd8EzYrEycuRSKoRb2" +
       "CMGUoPpYCVE8gcMjIArTFcX3XVH85PMSxWp4NJsf7cxFUQz1dKJ4toQonsfh" +
       "F5zUge9v1TaB32vGTEAeT/8/5JHlpNbTIGHPvCDv3wzrBl566EBj1fwDV7wi" +
       "ElHulrwOUkoqoyjers7zXqEbLCULpuqsHs/K6cc5WVi0e+OkDEZx5t9Y4Ceg" +
       "rCkIDnEDv7ywr0DDFYSFRk58e+Fe46TGhYMWx3rxgrwBJwEQfD2pO3G9xVdf" +
       "DVOVKdmQv4zIKan1dEryVB4rfDFd/PXkJM3MsF1jHj2wecv1p750n3UtJyl0" +
       "dhap1EI5Zt0Q5hLv8qLUHFoVm1Z/2vBw9UonBjdbB3YtfpHHInvAdnU0j/bA" +
       "nZXZlbu6evXgxU/9ak/FS5A9tpMQ5WTu9vw7g6yegYpneyy/7IQiRVymda/+" +
       "7sylZ6c+eF3cyhCrTF1cHH5MOnHo6pf3LTjYESa1A2QOpBeWFZcZl8+oI0ya" +
       "MuKkXjb7syJ9cpkqvpq2AS2ZYlcu5GKLsz43i5e6nHTmZ8H8q/AaRZtmRq8G" +
       "nTCSgaq41p3x/Sdme0dNRtcDCO6Mp6O50UqtqA2wyLHYoK47NXRZuy58eVeh" +
       "SLNLYJ8Srzj89T96Wjwclh4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
