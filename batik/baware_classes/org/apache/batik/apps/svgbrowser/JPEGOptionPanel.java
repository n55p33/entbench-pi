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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Tq59ib+y5hv/AUfSAN+lGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3IyB+UE1kGe+QApVI7STdgrDcV1Tpw2eDhCJ9opRd8j4Wgcv21xX9zbRojKS" +
       "O0GN53GZYyqU3OKWwYhUwqSvFhi5uoQjmiKHycSr4IZU2FQWa7jOaeN6v2C2" +
       "QWhlr276a3t7vis/KDi4qwIvzdkE+xreGrdTD2fNWw4OafLPmZP3G0fPQw8P" +
       "yaDsTfj+G11B5W/BL3zoueeVwaeRnb3DRSmEzoWO+xOmulbNI6R2AKXHb/zG" +
       "38tv4A4Pvb78oX++NHnH4r2v4Sj/wRN8niT5O70Xv9p+q/wrO9AtB0dg19wN" +
       "Hke6cvzg67yvhpFvT44df91/oNlcu28Cz7v2NPuu6x+nX//sK/eCre1vcnb7" +
       "1E3m3p81SQid19VwdOQM7N1H/ETMjqNMRwwPPWjzaucOR9fJB6IDke/LBh8B" +
       "j7InsvIaRN45dPzryn1q7yJo72Ds7vyYSozD3ez0zLFVO8zRfukmKnk2a54G" +
       "KgkWTtw0RNPJT10+eCj9M69FeqDcCyeutbIz+vuuuUrfXv/Kn3v+wm1vfJ77" +
       "q/xm5+CK9lwXuk2LTPPokeqR/hnXVzUjZ//c9oDVzb8+HkIPvdqlWybpwY+c" +
       "/Y9tkX89hO65LnIInc6+jsJ+KoQunoQFbpN/H4X7DbDaIVwIndl2joL8Zgjd" +
       "AkCy7gvuviGfeNWrwyP6TU4dz0cHhrv71Qx3JIU9eizx5P+P2E8S0fYfElfl" +
       "zz9P99/3cvXT29ss2RTTNKNyWxc6u71YO0g0D9+Q2j6tM53HXrnzC+fesp8U" +
       "79wyfBgLR3h78PpXRy3LDfPLnvQP3vh7b/+t57+VH8b+D4VnHYW4IgAA");
}
