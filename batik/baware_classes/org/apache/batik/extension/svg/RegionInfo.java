package org.apache.batik.extension.svg;
public class RegionInfo extends java.awt.geom.Rectangle2D.Float {
    private float verticalAlignment = 0.0F;
    public RegionInfo(float x, float y, float w, float h, float verticalAlignment) {
        super(
          x,
          y,
          w,
          h);
        this.
          verticalAlignment =
          verticalAlignment;
    }
    public float getVerticalAlignment() { return verticalAlignment;
    }
    public void setVerticalAlignment(float verticalAlignment) { this.
                                                                  verticalAlignment =
                                                                  verticalAlignment;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uW/mCcf/Bp41soKRIgAA");
}
