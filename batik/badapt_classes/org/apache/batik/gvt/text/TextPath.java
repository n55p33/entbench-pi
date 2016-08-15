package org.apache.batik.gvt.text;
public class TextPath {
    private org.apache.batik.ext.awt.geom.PathLength pathLength;
    private float startOffset;
    public TextPath(java.awt.geom.GeneralPath path) { super();
                                                      pathLength = new org.apache.batik.ext.awt.geom.PathLength(
                                                                     path);
                                                      startOffset =
                                                        0; }
    public void setStartOffset(float startOffset) { this.startOffset =
                                                      startOffset;
    }
    public float getStartOffset() { return startOffset; }
    public float lengthOfPath() { return pathLength.lengthOfPath(
                                                      ); }
    public float angleAtLength(float length) { return pathLength.
                                                 angleAtLength(
                                                   length); }
    public java.awt.geom.Point2D pointAtLength(float length) { return pathLength.
                                                                 pointAtLength(
                                                                   length);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
