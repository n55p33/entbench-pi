package org.apache.batik.gvt.text;
public class ConcreteTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.text.GlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public ConcreteTextLayoutFactory() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "raUaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sr0w7zqmf/K6P3rrp577Vt75+H8rIqSUViUAAA==");
}
