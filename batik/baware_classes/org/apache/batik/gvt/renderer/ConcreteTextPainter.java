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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BnFeZU//8K2//57ffvmbeaXvfwEcQ0RrQCAAAA==");
}
