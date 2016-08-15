package org.apache.batik.gvt.font;
public class GVTGlyphMetrics {
    private java.awt.font.GlyphMetrics gm;
    private float verticalAdvance;
    public GVTGlyphMetrics(java.awt.font.GlyphMetrics gm, float verticalAdvance) {
        super(
          );
        this.
          gm =
          gm;
        this.
          verticalAdvance =
          verticalAdvance;
    }
    public GVTGlyphMetrics(float horizontalAdvance, float verticalAdvance,
                           java.awt.geom.Rectangle2D bounds,
                           byte glyphType) { super();
                                             this.gm = new java.awt.font.GlyphMetrics(
                                                         horizontalAdvance,
                                                         bounds,
                                                         glyphType);
                                             this.verticalAdvance =
                                               verticalAdvance;
    }
    public float getHorizontalAdvance() { return gm.getAdvance(
                                                      ); }
    public float getVerticalAdvance() { return verticalAdvance;
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return gm.
                                                       getBounds2D(
                                                         );
    }
    public float getLSB() { return gm.getLSB(); }
    public float getRSB() { return gm.getRSB(); }
    public int getType() { return gm.getType(); }
    public boolean isCombining() { return gm.isCombining(
                                               ); }
    public boolean isComponent() { return gm.isComponent(
                                               ); }
    public boolean isLigature() { return gm.isLigature();
    }
    public boolean isStandard() { return gm.isStandard();
    }
    public boolean isWhitespace() { return gm.isWhitespace(
                                                ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5sHS5wo03H7+im8D/wOZJmczEiQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
