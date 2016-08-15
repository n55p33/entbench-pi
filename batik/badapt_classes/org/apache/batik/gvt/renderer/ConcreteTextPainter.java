package org.apache.batik.gvt.renderer;
public abstract class ConcreteTextPainter extends org.apache.batik.gvt.renderer.BasicTextPainter {
    public void paint(java.text.AttributedCharacterIterator aci, java.awt.geom.Point2D location,
                      org.apache.batik.gvt.TextNode.Anchor anchor,
                      java.awt.Graphics2D g2d) { java.awt.font.TextLayout layout =
                                                   new java.awt.font.TextLayout(
                                                   aci,
                                                   fontRenderContext);
                                                 float advance =
                                                   layout.
                                                   getAdvance(
                                                     );
                                                 float tx =
                                                   0;
                                                 switch (anchor.
                                                           getType(
                                                             )) {
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_MIDDLE:
                                                         tx =
                                                           -advance /
                                                             2;
                                                         break;
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_END:
                                                         tx =
                                                           -advance;
                                                 }
                                                 layout.
                                                   draw(
                                                     g2d,
                                                     (float)
                                                       (location.
                                                          getX(
                                                            ) +
                                                          tx),
                                                     (float)
                                                       location.
                                                       getY(
                                                         ));
    }
    public ConcreteTextPainter() { super(
                                     ); }
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
      ("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");
}
