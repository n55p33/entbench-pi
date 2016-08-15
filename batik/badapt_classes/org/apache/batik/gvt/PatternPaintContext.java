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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4lz7BQ6P+L0Y0vmq0nUlzMoz+9+Zv239xM6LOCUuDmkpTPJ7/Y88d90K5VBE" +
       "3GzJVF9wIxZE6gom+HqL8aylB9uaZXmrL0AjL4dnk2P1TWG/9vwq5DD5808p" +
       "1DJN0oNl1o7j8B1w+zTj10PwbnaC1/Pt714obsu3JThxoynm7w8eWefBc8iR" +
       "5tDFK6IUahlhnyiz9iQOj0IKS6o2HHXlUbsHh24pVR8nVZOGmvQ089hnoJnZ" +
       "uLYMniOOeEcuXjOlUMtI/9Myaz/D4SQnjeAi3ukTJ6/ydHHqM9AFJmoRM/c5" +
       "At138boohRqSt8pJgPi9wWf0kANUqs6/FHyHIvwcFJz81hvE92/KKPUVHH4J" +
       "iRiUOhzobdrCTYG3KjT9/P9D0zlOZha5kMRDxNyCf3bIC3rlsaNNdXOOXv+q" +
       "SP75S/QGSOOprKb521zfe41psZQqRG6QTa8pft7kZFaxa1LQMYyC7bMS8i1O" +
       "msOQ0EiJXz/cXyCJeXBQ/OWLH+RtoA4g+PqO6eq7Wegb+/yo7PNzFb6a6KhQ" +
       "aL7tQprPo/hvvrCSiX8zuVUnK//RNK6cOLp14JbzVz0ob94Uje7di1Smw2FZ" +
       "XgLmK9fSktRcWjVbVn444/Fpy90a3yIZ9gJkgc/5bgS3NdHW80PXUnZn/nbq" +
       "tWPXnvrVwZqX4OC1nVRQ8JfthSeinJmFlmF7vPBSAKq8uC/rWnnfnvWXpf7+" +
       "R3HmJPISYWFp+HHlzPGbXj4091h7hEzvI9XQvrCcOKpt3qND+zVpjZFG1e7J" +
       "AYtARaVa4MZhBrolxcstoRdHnY35Wby35aSj8MKl8LYbzudTzNpkZPUkkmmE" +
       "LsObcTuYQPHPmmYIwZtxTInjgMwpaA3wx/F4v2m691E1V5siQAdLJ5mPxCsO" +
       "H/8PzkRMCYIeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
