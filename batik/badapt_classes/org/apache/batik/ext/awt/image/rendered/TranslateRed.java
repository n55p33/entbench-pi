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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0Za3AV1fncm5B3yAMCMZCAScAB8V7fHYyiEAgELyFDYqxB" +
       "vGz2npss7N1dd89NLii+Rkdspw5SRNrR9IdYrIPiONrHtFgcpz5Ga0eltdb6" +
       "qHVaKnWU6VSdamu/75zdu4/7wMw0zcye7D3n+77zvb/vnD38EZlhmaSNaizC" +
       "dhjUiqzRWL9kWjTRrUqWNQhzcfm+Eukf153oWx4mZcNk5phkbZAli/YoVE1Y" +
       "w6RV0SwmaTK1+ihNIEa/SS1qjktM0bVh0qRYvSlDVWSFbdATFAGGJDNGGiTG" +
       "TGUkzWivTYCR1hhwEuWcRFcGl7tipEbWjR0ueLMHvNuzgpApdy+LkfrYNmlc" +
       "iqaZokZjisW6MiY529DVHaOqziI0wyLb1ItsFayPXZSjgvbH6z79Ys9YPVfB" +
       "LEnTdMbFszZRS1fHaSJG6tzZNSpNWdeTm0hJjFR7gBnpjDmbRmHTKGzqSOtC" +
       "Afe1VEununUuDnMolRkyMsTImX4ihmRKKZtMP+cZKFQwW3aODNIuzEorpMwR" +
       "8d6zo/vuu67+iRJSN0zqFG0A2ZGBCQabDINCaWqEmtbKRIImhkmDBsYeoKYi" +
       "qcpO29KNljKqSSwN5nfUgpNpg5p8T1dXYEeQzUzLTDez4iW5Q9m/ZiRVaRRk" +
       "nePKKiTswXkQsEoBxsykBH5no5RuV7QEIwuCGFkZO68EAEAtT1E2pme3KtUk" +
       "mCCNwkVUSRuNDoDraaMAOkMHBzQZaSlIFHVtSPJ2aZTG0SMDcP1iCaAquSIQ" +
       "hZGmIBinBFZqCVjJY5+P+i69+wZtnRYmIeA5QWUV+a8GpLYA0iaapCaFOBCI" +
       "NUtj+6U5R3eHCQHgpgCwgPnJjaeuWNZ27AUBMy8PzMaRbVRmcfngyMxX53cv" +
       "WV6CbFQYuqWg8X2S8yjrt1e6MgZkmDlZirgYcRaPbXrumlseoSfDpKqXlMm6" +
       "mk6BHzXIespQVGqupRo1JUYTvaSSaoluvt5LyuE9pmhUzG5MJi3KekmpyqfK" +
       "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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "766Ac1fy4lxcuqT5QXqkgXMPnmjg3MH3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ooFtXHro9CW7/MbQE7dd8t1dTNW+8MrVS4+/Ivzb3WxyfHn0MlW6ZCaOc/qu" +
       "wanni0FomHahl8u7mwdFGj/3SFz6ge/yghHAevyYAzh3bcfhrXHp6XtzABmx" +
       "+D3d6/G49MTdesWl86A8Tf0kSO13ogaUoDxN+RSY289SgvGL39N01+PSlT0d" +
       "mIB2D6dJngXcAUn+eCM49prv+jYWpkZxqGgxsOZ253NPnHb3IkoefT0fOfXG" +
       "9+wtq5PinvjxO1Wyuyl+U/viK0PmI99Gf3Z3k09zlCzLuVwCC4ndpcKjhcTp" +
       "61RnuR3zuth//jsP/9Ll547fIR/eCbwPvVOyvePO1+YIN4iLi27ZP3r8l3/w" +
       "51/5SnGR4f8CnCgnx8AvAAA=");
}
