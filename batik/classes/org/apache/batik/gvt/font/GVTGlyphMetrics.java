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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5sHy5wo03H7+im8D/wPuGY7/EiQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
