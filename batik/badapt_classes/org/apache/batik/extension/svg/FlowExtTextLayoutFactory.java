package org.apache.batik.extension.svg;
public class FlowExtTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.extension.svg.FlowExtGlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public FlowExtTextLayoutFactory() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "273FqY+2r7BH2kz+B/jXn6XLGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9as/8Auv/1mZHPn/CL/T04UlAAA=");
}
