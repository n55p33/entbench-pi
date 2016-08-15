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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0Sm0L4tXbL75H2BxbP+iGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
