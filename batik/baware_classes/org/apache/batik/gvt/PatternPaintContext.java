package org.apache.batik.gvt;
public class PatternPaintContext implements java.awt.PaintContext {
    private java.awt.image.ColorModel rasterCM;
    private java.awt.image.WritableRaster raster;
    private java.awt.image.RenderedImage tiled;
    protected java.awt.geom.AffineTransform usr2dev;
    public java.awt.geom.AffineTransform getUsr2Dev() { return usr2dev; }
    private static java.awt.Rectangle EVERYTHING = new java.awt.Rectangle(
      java.lang.Integer.
        MIN_VALUE /
        4,
      java.lang.Integer.
        MIN_VALUE /
        4,
      java.lang.Integer.
        MAX_VALUE /
        2,
      java.lang.Integer.
        MAX_VALUE /
        2);
    public PatternPaintContext(java.awt.image.ColorModel destCM, java.awt.geom.AffineTransform usr2dev,
                               java.awt.RenderingHints hints,
                               org.apache.batik.ext.awt.image.renderable.Filter tile,
                               java.awt.geom.Rectangle2D patternRegion,
                               boolean overflow) { super(
                                                     );
                                                   if (usr2dev ==
                                                         null) {
                                                       throw new java.lang.IllegalArgumentException(
                                                         );
                                                   }
                                                   if (hints ==
                                                         null) {
                                                       hints =
                                                         new java.awt.RenderingHints(
                                                           null);
                                                   }
                                                   if (tile ==
                                                         null) {
                                                       throw new java.lang.IllegalArgumentException(
                                                         );
                                                   }
                                                   this.
                                                     usr2dev =
                                                     usr2dev;
                                                   org.apache.batik.ext.awt.image.renderable.TileRable tileRable =
                                                     new org.apache.batik.ext.awt.image.renderable.TileRable8Bit(
                                                     tile,
                                                     EVERYTHING,
                                                     patternRegion,
                                                     overflow);
                                                   java.awt.color.ColorSpace destCS =
                                                     destCM.
                                                     getColorSpace(
                                                       );
                                                   if (destCS ==
                                                         java.awt.color.ColorSpace.
                                                         getInstance(
                                                           java.awt.color.ColorSpace.
                                                             CS_sRGB))
                                                       tileRable.
                                                         setColorSpaceLinear(
                                                           false);
                                                   else
                                                       if (destCS ==
                                                             java.awt.color.ColorSpace.
                                                             getInstance(
                                                               java.awt.color.ColorSpace.
                                                                 CS_LINEAR_RGB))
                                                           tileRable.
                                                             setColorSpaceLinear(
                                                               true);
                                                   java.awt.image.renderable.RenderContext rc =
                                                     new java.awt.image.renderable.RenderContext(
                                                     usr2dev,
                                                     EVERYTHING,
                                                     hints);
                                                   tiled =
                                                     tileRable.
                                                       createRendering(
                                                         rc);
                                                   if (tiled !=
                                                         null) {
                                                       java.awt.geom.Rectangle2D devRgn =
                                                         usr2dev.
                                                         createTransformedShape(
                                                           patternRegion).
                                                         getBounds(
                                                           );
                                                       if (devRgn.
                                                             getWidth(
                                                               ) >
                                                             128 ||
                                                             devRgn.
                                                             getHeight(
                                                               ) >
                                                             128)
                                                           tiled =
                                                             new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
                                                               org.apache.batik.ext.awt.image.GraphicsUtil.
                                                                 wrap(
                                                                   tiled),
                                                               256,
                                                               64);
                                                   }
                                                   else {
                                                       rasterCM =
                                                         java.awt.image.ColorModel.
                                                           getRGBdefault(
                                                             );
                                                       java.awt.image.WritableRaster wr;
                                                       wr =
                                                         rasterCM.
                                                           createCompatibleWritableRaster(
                                                             32,
                                                             32);
                                                       tiled =
                                                         org.apache.batik.ext.awt.image.GraphicsUtil.
                                                           wrap(
                                                             new java.awt.image.BufferedImage(
                                                               rasterCM,
                                                               wr,
                                                               false,
                                                               null));
                                                       return;
                                                   }
                                                   rasterCM =
                                                     tiled.
                                                       getColorModel(
                                                         );
                                                   if (rasterCM.
                                                         hasAlpha(
                                                           )) {
                                                       if (destCM.
                                                             hasAlpha(
                                                               ))
                                                           rasterCM =
                                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                                               coerceColorModel(
                                                                 rasterCM,
                                                                 destCM.
                                                                   isAlphaPremultiplied(
                                                                     ));
                                                       else
                                                           rasterCM =
                                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                                               coerceColorModel(
                                                                 rasterCM,
                                                                 false);
                                                   }
    }
    public void dispose() { raster = null;
    }
    public java.awt.image.ColorModel getColorModel() {
        return rasterCM;
    }
    public java.awt.image.Raster getRaster(int x,
                                           int y,
                                           int width,
                                           int height) {
        if (raster ==
              null ||
              raster.
              getWidth(
                ) <
              width ||
              raster.
              getHeight(
                ) <
              height) {
            raster =
              rasterCM.
                createCompatibleWritableRaster(
                  width,
                  height);
        }
        java.awt.image.WritableRaster wr =
          raster.
          createWritableChild(
            0,
            0,
            width,
            height,
            x,
            y,
            null);
        tiled.
          copyData(
            wr);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            wr,
            tiled.
              getColorModel(
                ),
            rasterCM.
              isAlphaPremultiplied(
                ));
        if (raster.
              getWidth(
                ) ==
              width &&
              raster.
              getHeight(
                ) ==
              height)
            return raster;
        return wr.
          createTranslatedChild(
            0,
            0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H/8PqhoWT4IeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6a/DrxnUf7pXuQ9ey7pVkSbZiyZJ85dhm8gcJ8AFUjmoS" +
       "JIgHSYAACZJwEhlPAiSIN0CAqZrETWK3mXE8jqy6mUSf7Mlj7DiTiSftZJJR" +
       "Jm3iPCavcZukM41dTzNx63gm/tC0UydxFuD/fR+yxi5nsFzsnj37O2fPnrPY" +
       "3U99FboUhVDF95x86XjxgZHFByuncRDnvhEdMIMGr4SRoROOEkUTUPaC9swv" +
       "Xf+7r3/EunERuixDDyuu68VKbHtuJBiR56SGPoCun5T2HGMTxdCNwUpJFTiJ" +
       "bQce2FH83AB6w6mmMXRzcAQBBhBgAAEuIcDtEyrQ6I2Gm2yIooXixlEA/Uvo" +
       "wgC67GsFvBh6+iwTXwmVzSEbvpQAcLhavEtAqLJxFkJPHcu+l/kWgT9WgV/6" +
       "t99/45fvga7L0HXbFQs4GgARg05k6P6NsVGNMGrruqHL0IOuYeiiEdqKY+9K" +
       "3DL0UGQvXSVOQuNYSUVh4hth2eeJ5u7XCtnCRIu98Fg80zYc/ejtkukoSyDr" +
       "oyey7iUki3Ig4DUbAAtNRTOOmty7tl09ht52vsWxjDdZQACaXtkYseUdd3Wv" +
       "q4AC6KH92DmKu4TFOLTdJSC95CWglxh6/I5MC137irZWlsYLMfTm83T8vgpQ" +
       "3VcqomgSQ4+cJys5gVF6/NwonRqfr47e8+EfcCn3YolZNzSnwH8VNHryXCPB" +
       "MI3QcDVj3/D+dw9eVh799Q9dhCBA/Mg54j3Nr/6Lr733u5589XN7mu+4DQ2n" +
       "rgwtfkH7hPrAn7yVeBd+TwHjqu9FdjH4ZyQvzZ8/rHku88HMe/SYY1F5cFT5" +
       "qvDbix/6BeMrF6FrNHRZ85xkA+zoQc3b+LZjhH3DNUIlNnQaus9wdaKsp6Er" +
       "ID+wXWNfyplmZMQ0dK9TFl32ynegIhOwKFR0BeRt1/SO8r4SW2U+8yEIugIe" +
       "CAMPDO1/5X8MvQ+2vI0BK5ri2q4H86FXyB/BhhurQLcWrAKrX8ORl4TABGEv" +
       "XMIKsAPLOKxYpjEY/BhYj8srwFYPJ9JBYWT+/1/2WSHdje2FC0Dxbz0/7R0w" +
       "YyjP0Y3wBe2lpNP72i++8PsXj6fBoV5i6J2gx4N9jwdljwegx4Pb9AhduFB2" +
       "9Kai5/3ogrFZg1kO/N/97xK/j3n/h565B5iVv70XKLYghe/shokTv0CX3k8D" +
       "xgm9+vHtD0s/WL0IXTzrTwu0oOha0ZwvvOCxt7t5fh7dju/1D3757z7z8ove" +
       "yYw646APJ/qtLYuJ+sx5vYaeZujA9Z2wf/dTymdf+PUXb16E7gWzH3i8GKit" +
       "cCZPnu/jzIR97sj5FbJcAgKbXrhRnKLqyGNdi63Q256UlAP+QJl/EOj4DYUF" +
       "Pwke/tCky/+i9mG/SN+0N5Bi0M5JUTrX7xH9n/nzP/yfaKnuIz98/VRkE434" +
       "uVNzv2B2vZzlD57YwCQ0DED33z7O/+THvvrB95UGACjefrsObxYpAeY8GEKg" +
       "5h/9XPAXX/jLT3z+4onRxCD4Japja9mxkEU5dO0uQoLe3nGCB/gOB0ywwmpu" +
       "Tt2Np9umraiOUVjp319/tvbZv/nwjb0dOKDkyIy+67UZnJS/pQP90O9///95" +
       "smRzQSti14nOTsj2DvHhE87tMFTyAkf2w3/6xL/7HeVngGsF7iyyd0bpoS6X" +
       "OrhcSv5IDL2lbKls4wN7AyJLAcwLh55uOEcUTxxTLA1vc9A2TWB3k1Bxo8KU" +
       "jqgeO6YSgBc1ioBHgWkdHdVXb/EAxWw96TcsWxUqOCBtB7iFWwGW3QtAbBBT" +
       "HQPpArnfdZclWGhvgEGlh2ELfvGhL6x/+suf3oek8zHuHLHxoZf+zTcOPvzS" +
       "xVMLgbffEotPt9kvBsqZ8Ma9UX0D/C6A5x+LpzCmomAfDB4iDiPSU8chyfcz" +
       "IM7Td4NVdkH+9Wde/LWfe/GDezEeOhsHe2CZ9+n/8g9/cPDxL/7ubZzwFdXz" +
       "HENxS5RwifLdZXpQwCrNAirrekXytui03zur3lPLyxe0j3z+b98o/e1vfK3s" +
       "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" +
       "dPjUBtOp/ecLRzswjxzvFZ0+KC32z5+40/F+eVTwiQ+89IrOfbJ28XBXvx1D" +
       "98We/92OkR4e7uw7uhdwevedN7qH5e2Gk93m3/nA/3p88rz1/tdxfPq2czjP" +
       "s/z54ad+t/8O7aMXoXuO955vuXdxttFzZ3ecr4VGnITu5My+8xPHev+OQs3P" +
       "gqdzqPfO+Y29k5G9/SbpO/eWcZdDk0/fpe4zRfJzMXRtacTTKES6h1uVJ6b0" +
       "86+1sXSaZVnwybMHtG8Bz0cPpfvot1+6/3CXul8rkl+JoSu6HfleZNx2My31" +
       "bP1E3M9+C+I+WhS+HTwvH4r78rdf3M/dpe73iuS3YuiNYDBPTkuLwuqJgP/x" +
       "WxDwIejQZH/qUMCf+vYIeO/hdL/N8NwDHEuR/c8nScni83fRw18UyR8BpwL0" +
       "IJw57njk/NHBSW2pnD9+PcrJYujh21wUKU6933zLJbT9xSntF1+5fvWxV6Z/" +
       "Vt6VOL7cdN8AumomjnP6pOpU/rIfGqZdinbf/tzKL/++FENvut31FaA1kJZ4" +
       "//ue8q9i6MZ5yhi6VP6fpvsy8AQndDF0eZ85TfIVwB2QFNm/8W+zF78/qssu" +
       "nPLjh3ZUavih19LwcZPTlygK319e/zvy08n+AuAL2mdeYUY/8LXmJ/eXODRH" +
       "2e0KLlcH0JX9fZJjX//0Hbkd8bpMvevrD/zSfc8exaUH9oBPbPoUtrfd/sZE" +
       "b+PH5R2H3b9/7Ffe87Ov/GV5NPBPbh0IN5cpAAA=");
}
