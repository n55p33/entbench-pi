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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ucETl/FO52ifOsgNh9Az97ovWVwZ+cLH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X3vdGPxc5cJ+mhWNoQdiP/gLjrk2nWNDXdydxB2i8VQ+/MsQtNfYTxU3zsky" +
       "n5ma/L4d/06lfC8fy9E+EUPvOkwa265mmbuzyXwT4BxAPHYIIZg62ExYR4fp" +
       "7zqZcT5s351u/MIB2JPHRvAMM889dm0vjgr8/uSclPR/z4v/GEMP66Gpxeb+" +
       "PeC7z1WKI4HjrYVC/Kf7zvEfcT8/j4aeB4zczw3v3ZUb/ta4f4y6PeictkIz" +
       "vwkot8xYzHPdxalRkV8+IvDPvl0C80MMc59A8ztP4EPntOWHr3tXY+hBQCDp" +
       "GWeQt3ftvg4gYujxM26D5lfbnrrr1vnuprT+xddvXHvy9dG/3N2POrjN/AAL" +
       "XZsljnP8Ysux9ytBaM7sgvYHdsfIQUEQUMin7nWGFUMXQZnjvPeOHfRTMfSO" +
       "s6Dzc4TsBOT3xNDN05AxdLn4PQ73bAxdP4KLoSu7l+MgL4DRAUj++mJwYEW3" +
       "7+/gLds76f4OlfGxt5PWMY/50onj/OJ/Bw7uwSS7/x64o3/p9V7/h7/R+Lnd" +
       "rU/d0bbbfJRrLHR1dwG1GDS/S/PCPUc7GOtK973ffOSXH3j5wAc/skP4SMOP" +
       "4fbc2VcsSTeIi0uR23/w5N/7wN95/Q+LM4z/B6ThMQPUMQAA");
}
