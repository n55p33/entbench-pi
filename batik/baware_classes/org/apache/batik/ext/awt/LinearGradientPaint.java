package org.apache.batik.ext.awt;
public final class LinearGradientPaint extends org.apache.batik.ext.awt.MultipleGradientPaint {
    private java.awt.geom.Point2D start;
    private java.awt.geom.Point2D end;
    public LinearGradientPaint(float startX, float startY, float endX, float endY,
                               float[] fractions,
                               java.awt.Color[] colors) { this(new java.awt.geom.Point2D.Float(
                                                                 startX,
                                                                 startY),
                                                               new java.awt.geom.Point2D.Float(
                                                                 endX,
                                                                 endY),
                                                               fractions,
                                                               colors,
                                                               NO_CYCLE,
                                                               SRGB);
    }
    public LinearGradientPaint(float startX, float startY,
                               float endX,
                               float endY,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod) {
        this(
          new java.awt.geom.Point2D.Float(
            startX,
            startY),
          new java.awt.geom.Point2D.Float(
            endX,
            endY),
          fractions,
          colors,
          cycleMethod,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          start,
          end,
          fractions,
          colors,
          NO_CYCLE,
          SRGB);
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace) {
        this(
          start,
          end,
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          new java.awt.geom.AffineTransform(
            ));
    }
    public LinearGradientPaint(java.awt.geom.Point2D start,
                               java.awt.geom.Point2D end,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                               java.awt.geom.AffineTransform gradientTransform) {
        super(
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          gradientTransform);
        if (start ==
              null ||
              end ==
              null) {
            throw new java.lang.NullPointerException(
              "Start and end points must be" +
              "non-null");
        }
        if (start.
              equals(
                end)) {
            throw new java.lang.IllegalArgumentException(
              "Start point cannot equal" +
              "endpoint");
        }
        this.
          start =
          (java.awt.geom.Point2D)
            start.
            clone(
              );
        this.
          end =
          (java.awt.geom.Point2D)
            end.
            clone(
              );
    }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform transform,
                                               java.awt.RenderingHints hints) {
        transform =
          new java.awt.geom.AffineTransform(
            transform);
        transform.
          concatenate(
            gradientTransform);
        try {
            return new org.apache.batik.ext.awt.LinearGradientPaintContext(
              cm,
              deviceBounds,
              userBounds,
              transform,
              hints,
              start,
              end,
              fractions,
              this.
                getColors(
                  ),
              cycleMethod,
              colorSpace);
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            e.
              printStackTrace(
                );
            throw new java.lang.IllegalArgumentException(
              "transform should be" +
              "invertible");
        }
    }
    public java.awt.geom.Point2D getStartPoint() {
        return new java.awt.geom.Point2D.Double(
          start.
            getX(
              ),
          start.
            getY(
              ));
    }
    public java.awt.geom.Point2D getEndPoint() {
        return new java.awt.geom.Point2D.Double(
          end.
            getX(
              ),
          end.
            getY(
              ));
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
       "l/FO79E+ebA37ENP3+2+ZHFl5Asff/U1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ifqZyoX9bdZWCN0XOu5fMeWtbB4b6uLuJO4QjSfz4V+CoL3m/lZx85xd5jO3" +
       "Jr9nx79TW76Xj+3RPh5C7zrcNNYsQZV3Z5NjR9rHDUA8eggxlcVQsNWjw/R3" +
       "ndxxPmzfnW783AHYE8dGsCU533scaXYYFPj92Tlb0v89L/5TCD0k+rIQyvv3" +
       "gO88VymOBI63Fgrxn+95j/+I+/l5NPQcYOT+3vDeHXvD3xz3j1G3B53TVmjm" +
       "W4ByVQ7ZfK+7ODUq9pePCPyLb5XA/BBD3idQ/vYT+OA5bfnh697VEHoAEDiw" +
       "pTPI27t2TwcQIfTYGbdB86ttT95x63x3U1r84mvXrz3x2vxf7e5HHdxmvo+E" +
       "rimRaR6/2HLs+Yrry4pW0H7f7hjZLQgCCvnk3c6wQugiKHOc996xg34yhN5x" +
       "FnR+jpCcgPyuELpxGjKELhe/x+GeCaH7j+BC6Mru4TjI82B0AJI/vuAeWNGt" +
       "ezt4S/ZOur9DZXz07aR1zGO+eOI4v/jfgYN7MNHuvwdui196DZ/8wDeaP7O7" +
       "9SmaQpblo1wjoau7C6jFoPldmufvOtrBWFdG733r4V+876UDH/zwDuEjDT+G" +
       "27NnX7EcWG5YXIrMfuWJf/yBf/jaHxdnGP8P0q02c9QxAAA=");
}
