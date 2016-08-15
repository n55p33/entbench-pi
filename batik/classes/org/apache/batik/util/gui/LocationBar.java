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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2SmwT4tXHP72H6VAF36WHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
