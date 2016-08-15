package org.apache.batik.apps.svgbrowser;
public class SVGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JCheckBox xmlbaseCB;
    protected javax.swing.JCheckBox prettyPrintCB;
    public SVGOptionPanel() { super(new java.awt.BorderLayout());
                              add(new javax.swing.JLabel(resources.getString(
                                                                     "SVGOptionPanel.label")),
                                  java.awt.BorderLayout.
                                    NORTH);
                              xmlbaseCB = new javax.swing.JCheckBox(
                                            resources.
                                              getString(
                                                "SVGOptionPanel.UseXMLBase"));
                              xmlbaseCB.setSelected(resources.getBoolean(
                                                                "SVGOptionPanel.UseXMLBaseDefault"));
                              add(xmlbaseCB, java.awt.BorderLayout.
                                               CENTER);
                              prettyPrintCB = new javax.swing.JCheckBox(
                                                resources.
                                                  getString(
                                                    "SVGOptionPanel.PrettyPrint"));
                              prettyPrintCB.setSelected(resources.
                                                          getBoolean(
                                                            "SVGOptionPanel.PrettyPrintDefault"));
                              add(prettyPrintCB, java.awt.BorderLayout.
                                                   SOUTH); }
    public boolean getUseXMLBase() { return xmlbaseCB.isSelected(
                                                        ); }
    public boolean getPrettyPrint() { return prettyPrintCB.isSelected(
                                                             ); }
    public static org.apache.batik.apps.svgbrowser.SVGOptionPanel showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "SVGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.SVGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.SVGOptionPanel(
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
        return panel;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TQwK7ldEF5vL/wGcU1IzmBoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tiQAAA==");
}
