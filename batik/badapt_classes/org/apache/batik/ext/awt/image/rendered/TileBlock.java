package org.apache.batik.ext.awt.image.rendered;
public class TileBlock {
    int occX;
    int occY;
    int occW;
    int occH;
    int xOff;
    int yOff;
    int w;
    int h;
    int benefit;
    boolean[] occupied;
    TileBlock(int occX, int occY, int occW, int occH, boolean[] occupied,
              int xOff,
              int yOff,
              int w,
              int h) { super();
                       this.occX = occX;
                       this.occY = occY;
                       this.occW = occW;
                       this.occH = occH;
                       this.xOff = xOff;
                       this.yOff = yOff;
                       this.w = w;
                       this.h = h;
                       this.occupied = occupied;
                       for (int y = 0; y < h; y++) for (int x = 0; x < w;
                                                        x++) if (!occupied[x +
                                                                             xOff +
                                                                             occW *
                                                                             (y +
                                                                                yOff)])
                                                                 benefit++;
    }
    public java.lang.String toString() { java.lang.String ret =
                                           "";
                                         for (int y =
                                                0;
                                              y <
                                                occH;
                                              y++) {
                                             for (int x =
                                                    0;
                                                  x <
                                                    occW +
                                                    1;
                                                  x++) {
                                                 if (x ==
                                                       xOff ||
                                                       x ==
                                                       xOff +
                                                       w) {
                                                     if (y ==
                                                           yOff ||
                                                           y ==
                                                           yOff +
                                                           h -
                                                           1)
                                                         ret +=
                                                           "+";
                                                     else
                                                         if (y >
                                                               yOff &&
                                                               y <
                                                               yOff +
                                                               h -
                                                               1)
                                                             ret +=
                                                               "|";
                                                         else
                                                             ret +=
                                                               " ";
                                                 }
                                                 else
                                                     if (y ==
                                                           yOff &&
                                                           x >
                                                           xOff &&
                                                           x <
                                                           xOff +
                                                           w)
                                                         ret +=
                                                           "-";
                                                     else
                                                         if (y ==
                                                               yOff +
                                                               h -
                                                               1 &&
                                                               x >
                                                               xOff &&
                                                               x <
                                                               xOff +
                                                               w)
                                                             ret +=
                                                               "_";
                                                         else
                                                             ret +=
                                                               " ";
                                                 if (x ==
                                                       occW)
                                                     continue;
                                                 if (occupied[x +
                                                                y *
                                                                occW])
                                                     ret +=
                                                       "*";
                                                 else
                                                     ret +=
                                                       ".";
                                             }
                                             ret +=
                                               "\n";
                                         }
                                         return ret;
    }
    int getXLoc() { return occX + xOff; }
    int getYLoc() { return occY + yOff; }
    int getWidth() { return w; }
    int getHeight() { return h; }
    int getBenefit() { return benefit; }
    int getWork() { return w * h + 1; }
    static int getWork(org.apache.batik.ext.awt.image.rendered.TileBlock[] blocks) {
        int ret =
          0;
        for (int i =
               0;
             i <
               blocks.
                 length;
             i++)
            ret +=
              blocks[i].
                getWork(
                  );
        return ret;
    }
    org.apache.batik.ext.awt.image.rendered.TileBlock[] getBestSplit() {
        if (simplify(
              ))
            return null;
        if (benefit ==
              w *
              h)
            return new org.apache.batik.ext.awt.image.rendered.TileBlock[] { this };
        return splitOneGo(
                 );
    }
    public org.apache.batik.ext.awt.image.rendered.TileBlock[] splitOneGo() {
        boolean[] filled =
          (boolean[])
            occupied.
            clone(
              );
        java.util.List items =
          new java.util.ArrayList(
          );
        for (int y =
               yOff;
             y <
               yOff +
               h;
             y++)
            for (int x =
                   xOff;
                 x <
                   xOff +
                   w;
                 x++) {
                if (!filled[x +
                              y *
                              occW]) {
                    int cw =
                      xOff +
                      w -
                      x;
                    for (int cx =
                           x;
                         cx <
                           x +
                           cw;
                         cx++)
                        if (filled[cx +
                                     y *
                                     occW])
                            cw =
                              cx -
                                x;
                        else
                            filled[cx +
                                     y *
                                     occW] =
                              true;
                    int ch =
                      1;
                    for (int cy =
                           y +
                           1;
                         cy <
                           yOff +
                           h;
                         cy++) {
                        int cx =
                          x;
                        for (;
                             cx <
                               x +
                               cw;
                             cx++)
                            if (filled[cx +
                                         cy *
                                         occW])
                                break;
                        if (cx !=
                              x +
                              cw)
                            break;
                        for (cx =
                               x;
                             cx <
                               x +
                               cw;
                             cx++)
                            filled[cx +
                                     cy *
                                     occW] =
                              true;
                        ch++;
                    }
                    items.
                      add(
                        new org.apache.batik.ext.awt.image.rendered.TileBlock(
                          occX,
                          occY,
                          occW,
                          occH,
                          occupied,
                          x,
                          y,
                          cw,
                          ch));
                    x +=
                      cw -
                        1;
                }
            }
        org.apache.batik.ext.awt.image.rendered.TileBlock[] ret =
          new org.apache.batik.ext.awt.image.rendered.TileBlock[items.
                                                                  size(
                                                                    )];
        items.
          toArray(
            ret);
        return ret;
    }
    public boolean simplify() { boolean[] workOccupied =
                                  occupied;
                                for (int y =
                                       0;
                                     y <
                                       h;
                                     y++) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    yOff++;
                                    y--;
                                    h--;
                                }
                                if (h == 0)
                                    return true;
                                for (int y =
                                       h -
                                       1;
                                     y >=
                                       0;
                                     y--) {
                                    int x;
                                    for (x =
                                           0;
                                         x <
                                           w;
                                         x++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (x !=
                                          w)
                                        break;
                                    h--;
                                }
                                for (int x =
                                       0;
                                     x <
                                       w;
                                     x++) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    xOff++;
                                    x--;
                                    w--;
                                }
                                for (int x =
                                       w -
                                       1;
                                     x >=
                                       0;
                                     x--) {
                                    int y;
                                    for (y =
                                           0;
                                         y <
                                           h;
                                         y++)
                                        if (!workOccupied[x +
                                                            xOff +
                                                            occW *
                                                            (y +
                                                               yOff)])
                                            break;
                                    if (y !=
                                          h)
                                        break;
                                    w--;
                                }
                                return false;
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
       "tvkVexxeeeGll7XRL1cu7D8ErcfQ/bEf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/Jijr3Xn2FDvKM75QzYezod/DByDfTYGpx+5HgH9QV8w/sE5bf82L/5lDF2O" +
       "/aNnoF87kuvv3+2p4PEBT2E72PYAefvYvDeADborrP9wTtu38uKPY+jSQo9n" +
       "tF9AQY5Q/clbgSraRxW9paj++zlt/yMvvrNDJd2O6r++WVTXCtLdL3tLUf35" +
       "ndv2iln+DzBBgGpqafv7Eo5g/dmbhZWfPL8P6/m3EtbelXPaHsiL+4AbALAo" +
       "3VqY8UlcexffLK7cd7ywj+uFtxTXI+e0PZoXD8XQFYCrfey10xGwh9+K1fXi" +
       "PrAX31JgT5/Tlg+09/hudU390D6F6ok3gSoHBD0Cjp/fR/XzbwBV4eW/eia0" +
       "gy02+XXrcLbird0NCLqw/0Z89x9D9tuzbRlTojiU1TjfQ6xNdO1g69lf5nTH" +
       "5HdaLvlrq73y/pvLvdrZMr6QnxbJx37ekRdMYQF5L/j2DVL55SgvxrfveCqU" +
       "v5u26J1fz86xvJvntOUp014rb/nwjpNzaD+U7f7P2eqzh+XFc3e08g+8CSsv" +
       "0qrHwfH5fSv//Fu6dgfntOWq2uvG0AOFU4piLnAKt7QHH0Ej3wS0/KV48ab+" +
       "lX1or7zRBXzXNG1vek5bvmNnbwKcbpQDG3k66Z9Cx70JdO/KK38IHN/YR/eN" +
       "tx6dek5bvrFt78MgA4gsF+AzNjnRh46w3Xoj2DIQcg8/Z8g3aT9621dUuy9/" +
       "1C+/fPXye18W/tVur+/B1zn309BlI3Gc47svj51fDEIQ8gq49+92twUFBieG" +
       "fuR1fm0BgB6c5tzv2bsR/Bh64vwRYui+4v94rzCGHr1Trxi6B5THqZMYevdZ" +
       "1IASlMcpgRivnaYE8xf/x+k+CozyiC6GLu5OjpP8DBgdkOSnH9u5r5ObL3ab" +
       "ZLOd33z0uIkW+d9d04ljN2nPnNi/WHxld7ArNNl9Z3dL/crL/eFHv1f/5d0H" +
       "Eaojb7f5KJdp6NLu24xi0Hxn6VN3HO1grIvUc99/56/e/+zBbd87dwwfLZdj" +
       "vD159mcIHTeIiw8Htv/4vf/og3/n5T8s9oL8f+BCgbn+OAAA");
}
