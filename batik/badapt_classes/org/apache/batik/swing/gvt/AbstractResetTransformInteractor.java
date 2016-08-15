package org.apache.batik.swing.gvt;
public abstract class AbstractResetTransformInteractor implements org.apache.batik.swing.gvt.Interactor {
    protected boolean finished = true;
    public boolean endInteraction() { return finished; }
    public void keyTyped(java.awt.event.KeyEvent e) { resetTransform(e); }
    public void keyPressed(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void keyReleased(java.awt.event.KeyEvent e) { resetTransform(e);
    }
    public void mouseClicked(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mousePressed(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseReleased(java.awt.event.MouseEvent e) { resetTransform(
                                                               e); }
    public void mouseEntered(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseExited(java.awt.event.MouseEvent e) { resetTransform(
                                                             e); }
    public void mouseDragged(java.awt.event.MouseEvent e) { resetTransform(
                                                              e); }
    public void mouseMoved(java.awt.event.MouseEvent e) { resetTransform(
                                                            e); }
    protected void resetTransform(java.awt.event.InputEvent e) { org.apache.batik.swing.gvt.JGVTComponent c =
                                                                   (org.apache.batik.swing.gvt.JGVTComponent)
                                                                     e.
                                                                     getSource(
                                                                       );
                                                                 c.
                                                                   resetRenderingTransform(
                                                                     );
                                                                 finished =
                                                                   true;
    }
    public AbstractResetTransformInteractor() { super(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5/8DyFstM6sjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fjbj2U/vN47D2TvOh5pT3Z4PNCdzAngvqIv3+87FlgcKLb8HPE8fxpanz8eW" +
       "S1D58t6yyVNleb0ovuFoKN/rB14EpNTUkvczEXRFt1wrNDX1YoNxgbUBESc5" +
       "TIjgFx76wvrHvviT+2TnvHXOEWsfefFf/sPBR1+8fCrFfPdNWd7pNvs0sxTx" +
       "raWchb8/dVEvZQviv33mhV/6ty98eC/VQ2cTJhysB37yP/6vzx184s9+9xbz" +
       "8D2y5zma5O7Dc1E2iqK7d+rmbQfAjb18l4By76oftA6qxW/u1ga4o3j9RhBQ" +
       "w3JhAFoA5UvOkSkesR3l+lEInYOFAhgB122nVbJ5O1galYO38LWDfXZ9TtZn" +
       "/q9lBdp84IQZ5YFE/Xv+/GOf+753fwFoZgTdlRTeDVR4qkcmLtYu//zljz/+" +
       "lhf/7HvK+QF41Pz9T/91mQl++0WIi0IoitkR1McKqNMyDaOkMKLLMK6px2iJ" +
       "U3hGEZgMvNeBNrr6G0MkJLtHf1RtpS+68xovwi1k3l4PYIypjrsbpjtoC/Xa" +
       "bBD1t9PJAJN33dF6sDHxLSJ3Oh2qmtRb02ark80SjBB3/Wi6YtceL810f9he" +
       "8KIpyFVtM6xpJEIJprSqTcNo2ZLqa5SSmuvMDlaCzFZRtaHrepBxTJ9h6BbX" +
       "kLWmplTaaALHLbSTcXhFHcXiZrLayhnWgxcb3vXn7lpnZpnYJMaeJDZ7sTX0" +
       "GzbVTJdovmkiozXi92Z2h87nzdFmk6n5aIqzM0PMpGC0nXo7ZcfYmCp4NGqP" +
       "bGI4Xs2q6ohinDDTonGLXLdrSJTOe8Y4n1urruw0Rn17oKDNVneJiPykP21S" +
       "2Dq2JYTV2MF4M2eGDYVYwS6uwZmOD0cREy+ymWPLPUX1VZx20Lkn9Fco31ka" +
       "TmUj0T46ZXqoKfKtlS9lGakaExGdDSdKZPf5jpoMYmQ266br5na78+atld3O" +
       "GVGcjcTxOpUa0dyxpQZer0xC3/LppZ3jTpCz6yrm1wbenBuKNWUcjDu2ZMmq" +
       "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" +
       "98jPfcu/eenz5aWA/wNo4IuMKC4AAA==");
}
