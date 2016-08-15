package org.apache.batik.ext.awt.image.rendered;
public class TranslateRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    protected int deltaX;
    protected int deltaY;
    public TranslateRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                        int xloc,
                        int yloc) { super(cr, new java.awt.Rectangle(xloc,
                                                                     yloc,
                                                                     cr.
                                                                       getWidth(
                                                                         ),
                                                                     cr.
                                                                       getHeight(
                                                                         )),
                                          cr.
                                            getColorModel(
                                              ),
                                          cr.
                                            getSampleModel(
                                              ),
                                          cr.
                                            getTileGridXOffset(
                                              ) +
                                            xloc -
                                            cr.
                                            getMinX(
                                              ),
                                          cr.
                                            getTileGridYOffset(
                                              ) +
                                            yloc -
                                            cr.
                                            getMinY(
                                              ),
                                          null);
                                    deltaX = xloc - cr.getMinX();
                                    deltaY = yloc - cr.getMinY();
    }
    public int getDeltaX() { return deltaX; }
    public int getDeltaY() { return deltaY; }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) { return getSource(
                                                                          ).
                                                                   getProperty(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.Raster getTile(int tileX, int tileY) {
        java.awt.image.Raster r =
          getSource(
            ).
          getTile(
            tileX,
            tileY);
        return r.
          createTranslatedChild(
            r.
              getMinX(
                ) +
              deltaX,
            r.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.Raster getData() { java.awt.image.Raster r =
                                               getSource(
                                                 ).
                                               getData(
                                                 );
                                             return r.createTranslatedChild(
                                                        r.
                                                          getMinX(
                                                            ) +
                                                          deltaX,
                                                        r.
                                                          getMinY(
                                                            ) +
                                                          deltaY);
    }
    public java.awt.image.Raster getData(java.awt.Rectangle rect) {
        java.awt.Rectangle r =
          (java.awt.Rectangle)
            rect.
            clone(
              );
        r.
          translate(
            -deltaX,
            -deltaY);
        java.awt.image.Raster ret =
          getSource(
            ).
          getData(
            r);
        return ret.
          createTranslatedChild(
            ret.
              getMinX(
                ) +
              deltaX,
            ret.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.WritableRaster wr2 =
          wr.
          createWritableTranslatedChild(
            wr.
              getMinX(
                ) -
              deltaX,
            wr.
              getMinY(
                ) -
              deltaY);
        getSource(
          ).
          copyData(
            wr2);
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F+eS0iXFDzZHEjj34IkEzh18LxLIktJD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("py/Z5TeGnrjtku/uYqryhVeuXnr8FeHf7bLJ8eXRy2Tpkr5ynNN3DU49Xwwi" +
       "TbcKuVze3Twowvi5R5LSD3yXF4wA1uPHHMC5a7sR3pqUnr73CCAiFr+nez2e" +
       "lJ64W6+kdB6Up6mfBKH9TtSAEpSnKZ8Cuf0sJZi/+D1Ndz0pXdnTgQS0ezhN" +
       "8iwYHZDkjzeCY6v5rm9joYs4iWQlAdrMdjb3xGlzL7zk0dezkVNvfM/esjop" +
       "7okfv1OtdjfFbypffGVIffTbjZ/d3eRTHHm7zUe5BBYSu0uFRwuJ09epzo52" +
       "PNZF4vnvPPxLl587fod8eMfw3vVO8faOO1+b67lBUlx02/7jx3/5B3/+la8U" +
       "Fxn+LxU21AfALwAA");
}
