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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+/x/ANmxxCOrIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+1LFP33sH3/P33/lK9WlgP8D3ItT8yguAAA=");
}
