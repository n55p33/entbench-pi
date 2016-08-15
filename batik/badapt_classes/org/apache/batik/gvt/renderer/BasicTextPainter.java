package org.apache.batik.gvt.renderer;
public abstract class BasicTextPainter implements org.apache.batik.gvt.TextPainter {
    private static org.apache.batik.gvt.text.TextLayoutFactory textLayoutFactory =
      new org.apache.batik.gvt.text.ConcreteTextLayoutFactory(
      );
    protected java.awt.font.FontRenderContext fontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      true,
      true);
    protected java.awt.font.FontRenderContext aaOffFontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    protected org.apache.batik.gvt.text.TextLayoutFactory getTextLayoutFactory() {
        return textLayoutFactory;
    }
    public org.apache.batik.gvt.text.Mark selectAt(double x,
                                                   double y,
                                                   org.apache.batik.gvt.TextNode node) {
        return hitTest(
                 x,
                 y,
                 node);
    }
    public org.apache.batik.gvt.text.Mark selectTo(double x,
                                                   double y,
                                                   org.apache.batik.gvt.text.Mark beginMark) {
        if (beginMark ==
              null) {
            return null;
        }
        else {
            return hitTest(
                     x,
                     y,
                     beginMark.
                       getTextNode(
                         ));
        }
    }
    public java.awt.geom.Rectangle2D getGeometryBounds(org.apache.batik.gvt.TextNode node) {
        return getOutline(
                 node).
          getBounds2D(
            );
    }
    protected abstract org.apache.batik.gvt.text.Mark hitTest(double x,
                                                              double y,
                                                              org.apache.batik.gvt.TextNode node);
    protected static class BasicMark implements org.apache.batik.gvt.text.Mark {
        private org.apache.batik.gvt.TextNode
          node;
        private org.apache.batik.gvt.text.TextHit
          hit;
        protected BasicMark(org.apache.batik.gvt.TextNode node,
                            org.apache.batik.gvt.text.TextHit hit) {
            super(
              );
            this.
              hit =
              hit;
            this.
              node =
              node;
        }
        public org.apache.batik.gvt.text.TextHit getHit() {
            return hit;
        }
        public org.apache.batik.gvt.TextNode getTextNode() {
            return node;
        }
        public int getCharIndex() { return hit.
                                      getCharIndex(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "949FF5tL/wHykKlcthoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7Mw8P5879LH3vdqJyFFxecNTB5rdvX94+J49zd7z49fs46/w7tms+KUQeh3Q" +
           "bP/yID8PPVTvoz+CerdljfeD5+k99Z7+8av3a6/w7vms+GQI3QTUa82zA2t1" +
           "77DYOIIOyxA6be79ASNX+bnXonIcQucPrkL3Q3/3td2lghC++6o/bmz/bKB8" +
           "9rmL5+56jvvr/A7x4A8B5wnonB5Z1tGT9iP1s56v6WZug/Pbc3cv//rc9W6O" +
           "9ocWQuf2q7kuL275fjuEbr8WH7AcKI9S/m4IXTpJGUJn8u+jdH8QQhcO6UBs" +
           "bStHSf4ISAckWfUL3jUOnrdXFPGpI2C454H5LN76arN4wHL0UjID0PyvNvtg" +
           "F23/bHNFefG5wejdL1c+tb0UVSwpTTMp5wjoxu397AFgPnhdafuyzvYe+cHN" +
           "nzv/pn1kv3k74MNoODK2+699/di2vTC/MEx//67feduvP/eN/Bz8fwGx9LLw" +
           "AyUAAA==");
    }
    public BasicTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z33Vj73w19VB0v8CkLSfcNsoAAA=");
}
