package org.apache.batik.swing.gvt;
public abstract class AbstractPanInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    public static final java.awt.Cursor PAN_CURSOR = new java.awt.Cursor(
      java.awt.Cursor.
        MOVE_CURSOR);
    protected boolean finished = true;
    protected int xStart;
    protected int yStart;
    protected int xCurrent;
    protected int yCurrent;
    protected java.awt.Cursor previousCursor;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { if (!finished) {
                                                                mouseExited(
                                                                  e);
                                                                return;
                                                            }
                                                            finished = false;
                                                            xStart = e.getX(
                                                                         );
                                                            yStart = e.getY(
                                                                         );
                                                            org.apache.batik.swing.gvt.JGVTComponent c =
                                                              (org.apache.batik.swing.gvt.JGVTComponent)
                                                                e.
                                                                getSource(
                                                                  );
                                                            previousCursor =
                                                              c.
                                                                getCursor(
                                                                  );
                                                            c.
                                                              setCursor(
                                                                PAN_CURSOR);
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (finished) {
            return;
        }
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            xCurrent -
              xStart,
            yCurrent -
              yStart);
        java.awt.geom.AffineTransform rt =
          (java.awt.geom.AffineTransform)
            c.
            getRenderingTransform(
              ).
            clone(
              );
        rt.
          preConcatenate(
            at);
        c.
          setRenderingTransform(
            rt);
        if (c.
              getCursor(
                ) ==
              PAN_CURSOR) {
            c.
              setCursor(
                previousCursor);
        }
    }
    public void mouseExited(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        c.
          setPaintingTransform(
            null);
        if (c.
              getCursor(
                ) ==
              PAN_CURSOR) {
            c.
              setCursor(
                previousCursor);
        }
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            xCurrent -
              xStart,
            yCurrent -
              yStart);
        c.
          setPaintingTransform(
            at);
    }
    public AbstractPanInteractor() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cJDfnxkVU869mxupxR3OyzRC05rsDuALs3adwuy1AJ71pl3Xez3VdqvcSoL7" +
       "i6eEKCuwWIEjymMF5r7Dmm+B1xM5bl18mCfNqO3wY7fan4VrfjawRuXj38xK" +
       "VM7mlsDTZ0rUV0A9rPl2rjL8UD0CW6mbvUO9ODNbL8KWgA3QBZudtLMuJ/n9" +
       "Aur6EWu+S5l/Aw77SKCTeL6cN2FQEeO2Ap/6uBS4FJ6kqYXk+BXoh5pfgez1" +
       "Gb7q+QI6+gVrzlFUyXXUS6CKAiWxwWdthfz041JIEzz7Tan2j18hfqi3Ushr" +
       "BRRyiTW/pqicK6Q9I9IcdVz4ODfYUVOmo+NXhx/qrdTxZgF1vMWay9YeWqvh" +
       "ZDJHH1f+F/rIUFSX916XXULMyPmWZHz/EJ44UV06/cTmSzzrZb9RVED+SqQl" +
       "yXlMdvSLoWhIiFy8CuPQbBTub1M0y//WGUpjaDn71wz4dyialh8eDsv83wn9" +
       "V4pqvNAAx/+dcO/BsdmGg9rW6DhBPgBeAIR1/6FagbK5wIW5rc3WOFahnwm4" +
       "65SsLetuZUtHabPQVRLwr4JW+k4b3wWjwpkT67v33Fj5iHFrKkh4ZIStUg7n" +
       "K+NuNlsCLPBdzVqreF3TzaonJy2yiiXXra2TN+5R4OL8hnOW5xpRb8zeJr4+" +
       "tur5X44WvwInyq0ogCmasjX3hiajpqH22hrJPUdCucTvN1uavjG8ujnxzu/5" +
       "HRgyzp1z/OGjwsWT2149PGOsPojKO9FEqANJhl8drR2We4kwqPWjSlGH2KNT" +
       "WEXEkuuQWsXcHLPvhVwvpjors6PsOp2ihtwzeu5HiDJJGSLaGiUt8z0Nx9xy" +
       "e8QqBV1VVFpVPQj2iONaQjQSLLMG+Go00qWq1l10ebvKt/xO31NmoIJ3Wa/y" +
       "vweTOZExIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7ioAAA==");
}
