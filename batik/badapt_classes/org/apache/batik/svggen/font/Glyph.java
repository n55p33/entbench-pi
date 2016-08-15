package org.apache.batik.svggen.font;
public class Glyph {
    protected short leftSideBearing;
    protected int advanceWidth;
    private org.apache.batik.svggen.font.Point[] points;
    public Glyph(org.apache.batik.svggen.font.table.GlyphDescription gd, short lsb,
                 int advance) { super();
                                leftSideBearing = lsb;
                                advanceWidth = advance;
                                describe(gd); }
    public int getAdvanceWidth() { return advanceWidth; }
    public short getLeftSideBearing() { return leftSideBearing; }
    public org.apache.batik.svggen.font.Point getPoint(int i) { return points[i];
    }
    public int getPointCount() { return points.length; }
    public void reset() {  }
    public void scale(int factor) { for (int i = 0; i < points.
                                                          length;
                                         i++) { points[i].
                                                  x = (points[i].
                                                         x <<
                                                         10) *
                                                        factor >>
                                                        26;
                                                points[i].
                                                  y = (points[i].
                                                         y <<
                                                         10) *
                                                        factor >>
                                                        26;
                                    }
                                    leftSideBearing = (short)
                                                        (leftSideBearing *
                                                           factor >>
                                                           6);
                                    advanceWidth = advanceWidth *
                                                     factor >>
                                                     6; }
    private void describe(org.apache.batik.svggen.font.table.GlyphDescription gd) {
        int endPtIndex =
          0;
        points =
          (new org.apache.batik.svggen.font.Point[gd.
                                                    getPointCount(
                                                      ) +
                                                    2]);
        for (int i =
               0;
             i <
               gd.
               getPointCount(
                 );
             i++) {
            boolean endPt =
              gd.
              getEndPtOfContours(
                endPtIndex) ==
              i;
            if (endPt) {
                endPtIndex++;
            }
            points[i] =
              new org.apache.batik.svggen.font.Point(
                gd.
                  getXCoordinate(
                    i),
                gd.
                  getYCoordinate(
                    i),
                (gd.
                   getFlags(
                     i) &
                   org.apache.batik.svggen.font.table.GlyfDescript.
                     onCurve) !=
                  0,
                endPt);
        }
        points[gd.
                 getPointCount(
                   )] =
          new org.apache.batik.svggen.font.Point(
            0,
            0,
            true,
            true);
        points[gd.
                 getPointCount(
                   ) +
                 1] =
          new org.apache.batik.svggen.font.Point(
            advanceWidth,
            0,
            true,
            true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nrviRZOf5bUlW4QIj1pr8e3L/wVu3Z0KQSIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+RRzFku/P6S02RgL8knc2FgOn23ybaVaFTqqzgkLbjYk+13ST5yEJ12kPaOF" +
       "kUtw9JzQiEHKcaMRK3qCbXaEcLSzhvyi4qBxLieijC9WfTPOJfDWQtE4atXR" +
       "uONkY8HOaGk4lea80c2E6qYWIpY3C+xs17Lt5ZZr0qI5SNeaskDxvAG+h/ss" +
       "164s8MV0EbP91Xayc1izlhKIvd2F4Rixud0Wn7OzTWbOV9WdwVrjiTInxmZU" +
       "reRT2wvcXa3Wdnvtfm3RE8iwq49XK3eX1XR4hpHzUJ0n3UgW0548AFOz9Lrd" +
       "Wt42GWWEMfFERlWvzW+zytaUt13Jtsa6LfO7gF3ughouppt6mi8QfTWYbDp9" +
       "YdMYhDXTGxBysBwlIRtMl5pnNisRWjNtIVS13dInIkav8ZG3XWkG17VnQ7tV" +
       "M9hN3lLrWRu3KHPgKmNyKpFrZTntJ4KGVCVhibgYjc/x0Br7zUFvs8AtwZr0" +
       "NU3jB+RcX3gCK4qqORVbbZff1ANnYpoDfr62XI3f9Cmpji1RVFlLYo3hhqQ9" +
       "k0YmrjKUoabj8UQzu8R8NM6sXU0IOG2x63hddrBJWrNFnUUkQTJwjt8OpI1l" +
       "qes8qvlEJqRDeos7XhYlVFOz+RVnrwZOioSZ5jCVHeK5SIempy17xnXjrca0" +
       "tY2XDA3OcskYncxGpsStVz1zM1cNusY41aTbZvtBZlHIpiIgO2lm2otRmHRZ" +
       "dKFVxh1s4ONjilj1ZbLd05l8oQ17az5aMKQ7QbIBkhGEyOoJUe0sIrI71/je" +
       "ZmP0xuSoidAr0XIcrIn6vh/KTk0a6Owc69la4G6b1WSykBPNGyPVpd6k6l1K" +
       "nWQp3fAki2lQ5qIdkPksaJN1vxc7vt9EGd7Ik92mwnLqZLeqsXVzks2kJVJt" +
       "ycgkrIqzVcauguJrud9BjOmy6ixWsjO1gbXwkehhNj1eL7NaRTG4SVqzh/jI" +
       "9L0Wm2HCKt+0lVDU+qk1qwq7mjX1WXPucZWxi+4WektpZGK1OazPpIVnT/D1" +
       "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" +
       "z+7vVomWkOdFL9do6Or+mtfRqeGz9+3t");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("sK8rgxe//fAvXX/hMLZ4eM/wsQqf4O3pe19k6tpeWF49yn/1sV9++ede/0p5" +
       "GPX/ALwl0HMcLQAA");
}
