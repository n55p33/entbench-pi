package org.apache.batik.apps.svgbrowser;
public class PNGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JCheckBox check;
    public PNGOptionPanel() { super(new java.awt.GridBagLayout());
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
                              constraints.setGridBounds(0,
                                                        0,
                                                        1,
                                                        1);
                              add(new javax.swing.JLabel(
                                    resources.
                                      getString(
                                        "PNGOptionPanel.label")),
                                  constraints);
                              check = new javax.swing.JCheckBox(
                                        );
                              constraints.weightx = 1.0;
                              constraints.fill = java.awt.GridBagConstraints.
                                                   HORIZONTAL;
                              constraints.setGridBounds(1,
                                                        0,
                                                        1,
                                                        1);
                              add(check, constraints); }
    public boolean isIndexed() { return check.isSelected(
                                                ); }
    public static boolean showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "PNGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.PNGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.PNGOptionPanel(
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
          isIndexed(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KtEptC+LV2y++R9g2BhBohgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
