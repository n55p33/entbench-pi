package org.apache.batik.gvt.flow;
class GlyphGroupInfo {
    int start;
    int end;
    int glyphCount;
    int lastGlyphCount;
    boolean hideLast;
    float advance;
    float lastAdvance;
    int range;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    boolean[] hide;
    public GlyphGroupInfo(org.apache.batik.gvt.font.GVTGlyphVector gv, int start,
                          int end,
                          boolean[] glyphHide,
                          boolean glyphGroupHideLast,
                          float[] glyphPos,
                          float[] advAdj,
                          float[] lastAdvAdj,
                          boolean[] space) { super();
                                             this.gv = gv;
                                             this.start = start;
                                             this.end = end;
                                             this.hide = (new boolean[this.
                                                                        end -
                                                                        this.
                                                                          start +
                                                                        1]);
                                             this.hideLast =
                                               glyphGroupHideLast;
                                             java.lang.System.
                                               arraycopy(
                                                 glyphHide,
                                                 this.
                                                   start,
                                                 this.
                                                   hide,
                                                 0,
                                                 this.
                                                   hide.
                                                   length);
                                             float adv = glyphPos[2 *
                                                                    end +
                                                                    2] -
                                               glyphPos[2 *
                                                          start];
                                             float ladv =
                                               adv;
                                             adv += advAdj[end];
                                             int glyphCount =
                                               end -
                                               start +
                                               1;
                                             for (int g =
                                                    start;
                                                  g <
                                                    end;
                                                  g++) { if (glyphHide[g])
                                                             glyphCount--;
                                             }
                                             int lastGlyphCount =
                                               glyphCount;
                                             for (int g =
                                                    end; g >=
                                                           start;
                                                  g--) { ladv +=
                                                           lastAdvAdj[g];
                                                         if (!space[g])
                                                             break;
                                                         lastGlyphCount--;
                                             }
                                             if (hideLast)
                                                 lastGlyphCount--;
                                             this.glyphCount =
                                               glyphCount;
                                             this.lastGlyphCount =
                                               lastGlyphCount;
                                             this.advance =
                                               adv;
                                             this.lastAdvance =
                                               ladv; }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return gv;
    }
    public int getStart() { return start; }
    public int getEnd() { return end; }
    public int getGlyphCount() { return glyphCount; }
    public int getLastGlyphCount() { return lastGlyphCount;
    }
    public boolean[] getHide() { return hide; }
    public boolean getHideLast() { return hideLast; }
    public float getAdvance() { return advance; }
    public float getLastAdvance() { return lastAdvance; }
    public void setRange(int range) { this.range = range;
    }
    public int getRange() { return this.range; }
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
       "/YbbqtRrC5/XBmAcWi26nLQayrg/Krd9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Vi1PKKRRIeZJbcZsBWIkcJTGDiKrU1myUIvX/dVQ7DZYcuu2Jx7se5UQtbZ0" +
       "n5ZalXWZiGAhXbXMmGuEqiraGoTPerYktZA2uRlD6drwWo6/DjydWcYgTidp" +
       "p6p5rDMelQdzTzYnfKcpE0OrusGxnuN1IQo3orCeDsx2wNGVTZkIYqYzRctz" +
       "p9lEG2WrpuuQ0R6imM50pxUURT/+8XwJ6j/d3tLYo8Uq4OER06WD5BnfvY3V" +
       "r+xmK52Hi6aHv+eP/x9bND22BVXKN8meudkx0uKQzDc//+Zb6uhn4PP7q6nt" +
       "qPRA5Pl/Dsy8NedYUw/u9h9P7v1+GFzsPhns6bXbI9TXwTlX8G/HjDO2EX94" +
       "Rt7/ypPvR6VHDC06ds6pWJE+YvXv32qh8XizpxDmm2Ol94Nrvo9wfvcR/vEZ" +
       "eX+SJ38YlS4ChNPDHb8jbH90p9jyU4GLfWyLu47t3MUz8i7lyYWodB/Ahu/v" +
       "Hx4iO3fPnSLLVeJT+8g+dfeRPX5G3hN5cjkqPXwgl0fbfkcAr9wpwHxXS94H" +
       "KN99gM+fkfdinrwf2DoAkLl+b/MI5AfuAGS+P1V6BlzqPkj17oP86Bl5e3ny" +
       "oah0PwBJHewtHUH78J2O37PgMvehmXcfWuuMvD+fJ7Wo9OA+tMNN4CN49TuF" +
       "l4/cah/e6u7D656Rl+8cnftEfhRAO7F9e4Tuk3eKLj8pEe+ji+8+uvEZeWye" +
       "0Duvx5zaoD5CyNwBwuK8eH6qIN1HmN4dhOeOCjQKIs84nnYuP552bgFcX6hF" +
       "bL7nfcONxcSz1CPQ/B2Avpy/fLIouvtld39Y7TPyVnmi71w9e7jHf4TNuB1s" +
       "GRCPk59l5GfMn7ruk6/dZ0rKt9+6fPHJt+b/bncG+eBTogeY0kU9dpzjp0KP" +
       "3d/nB5puFZgf2J3J8gtCo6j0vpt+LAKGLP/LCT4X7sqDd4/fqHxUugDS4yW3" +
       "UenK6ZJR6d7i/3i514HqH5UDEcbu5niRz4HWQZH89o3dwbeTG/S7Y7TZ7sTd" +
       "U8clpoD62K0G41js/dKJ82/Fx3kHZ0fj3ed515TvvNUffvZHzZ/ZfWKhONJ2" +
       "m7dykSndv/vao2g0P3/6wk1bO2jrPuqVHz/ycw+8fBDNP7Ij+Eh6j9H23I2/" +
       "Z8BXflR8gbD9xSf/0cf+7lu/U5wX+H/DczowNTkAAA==");
}
