package org.apache.batik.swing.svg;
public class SVGUserAgentGUIAdapter extends org.apache.batik.swing.svg.SVGUserAgentAdapter {
    public java.awt.Component parentComponent;
    public SVGUserAgentGUIAdapter(java.awt.Component parentComponent) { super(
                                                                          );
                                                                        this.
                                                                          parentComponent =
                                                                          parentComponent;
    }
    public void displayError(java.lang.String message) { javax.swing.JOptionPane pane =
                                                           new javax.swing.JOptionPane(
                                                           message,
                                                           javax.swing.JOptionPane.
                                                             ERROR_MESSAGE);
                                                         javax.swing.JDialog dialog =
                                                           pane.
                                                           createDialog(
                                                             parentComponent,
                                                             "ERROR");
                                                         dialog.
                                                           setModal(
                                                             false);
                                                         dialog.
                                                           setVisible(
                                                             true);
    }
    public void displayError(java.lang.Exception ex) {
        org.apache.batik.util.gui.JErrorPane pane =
          new org.apache.batik.util.gui.JErrorPane(
          ex,
          javax.swing.JOptionPane.
            ERROR_MESSAGE);
        javax.swing.JDialog dialog =
          pane.
          createDialog(
            parentComponent,
            "ERROR");
        dialog.
          setModal(
            false);
        dialog.
          setVisible(
            true);
    }
    public void displayMessage(java.lang.String message) {
        
    }
    public void showAlert(java.lang.String message) {
        java.lang.String str =
          "Script alert:\n" +
        message;
        javax.swing.JOptionPane.
          showMessageDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return javax.swing.JOptionPane.
          showInputDialog(
            parentComponent,
            str);
    }
    public java.lang.String showPrompt(java.lang.String message,
                                       java.lang.String defaultValue) {
        java.lang.String str =
          "Script prompt:\n" +
        message;
        return (java.lang.String)
                 javax.swing.JOptionPane.
                 showInputDialog(
                   parentComponent,
                   str,
                   null,
                   javax.swing.JOptionPane.
                     PLAIN_MESSAGE,
                   null,
                   null,
                   defaultValue);
    }
    public boolean showConfirm(java.lang.String message) {
        java.lang.String str =
          "Script confirm:\n" +
        message;
        return javax.swing.JOptionPane.
          showConfirmDialog(
            parentComponent,
            str,
            "Confirm",
            javax.swing.JOptionPane.
              YES_NO_OPTION) ==
          javax.swing.JOptionPane.
            YES_OPTION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W/2r2Xz2q5z7r/yVNR/+F1r+cmcBHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N/+r9//US1+pTsX+H0FSug9JKAAA");
}
