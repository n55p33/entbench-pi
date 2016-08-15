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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3qUaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
