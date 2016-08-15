package org.apache.batik.apps.svgbrowser;
public class JPEGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JSlider quality;
    public JPEGOptionPanel() { super(new java.awt.GridBagLayout());
                               org.apache.batik.util.gui.ExtendedGridBagConstraints constraints =
                                 new org.apache.batik.util.gui.ExtendedGridBagConstraints(
                                 );
                               constraints.insets = new java.awt.Insets(
                                                      5,
                                                      5,
                                                      5,
                                                      5);
                               constraints.weightx = 0;
                               constraints.weighty = 0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    NONE;
                               constraints.setGridBounds(
                                             0,
                                             0,
                                             1,
                                             1);
                               add(new javax.swing.JLabel(
                                     resources.
                                       getString(
                                         "JPEGOptionPanel.label")),
                                   constraints);
                               quality = new javax.swing.JSlider(
                                           );
                               quality.setMinimum(0);
                               quality.setMaximum(100);
                               quality.setMajorTickSpacing(
                                         10);
                               quality.setMinorTickSpacing(
                                         5);
                               quality.setPaintTicks(true);
                               quality.setPaintLabels(true);
                               quality.setBorder(javax.swing.BorderFactory.
                                                   createEmptyBorder(
                                                     0,
                                                     0,
                                                     10,
                                                     0));
                               java.util.Hashtable labels =
                                 new java.util.Hashtable(
                                 );
                               for (int i = 0; i < 100; i +=
                                                          10) {
                                   labels.
                                     put(
                                       new java.lang.Integer(
                                         i),
                                       new javax.swing.JLabel(
                                         "0." +
                                         i /
                                           10));
                               }
                               labels.put(new java.lang.Integer(
                                            100),
                                          new javax.swing.JLabel(
                                            "1"));
                               quality.setLabelTable(labels);
                               java.awt.Dimension dim = quality.
                                 getPreferredSize(
                                   );
                               quality.setPreferredSize(new java.awt.Dimension(
                                                          350,
                                                          dim.
                                                            height));
                               constraints.weightx = 1.0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    HORIZONTAL;
                               constraints.setGridBounds(
                                             1,
                                             0,
                                             1,
                                             1);
                               add(quality, constraints);
    }
    public float getQuality() { return quality.getValue() /
                                  100.0F; }
    public static float showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "JPEGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.JPEGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.JPEGOptionPanel(
          );
        org.apache.batik.apps.svgbrowser.OptionPanel.Dialog dialog =
          new org.apache.batik.apps.svgbrowser.OptionPanel.Dialog(
          parent,
          title,
          panel);
        dialog.
          pack(
            );
        dialog.
          setVisible(
            true);
        return panel.
          getQuality(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "k2tf4q+s+eZ/ABibJfalGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
