package org.apache.batik.ext.awt.image.rendered;
public class FilterAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public FilterAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          src.
            getBounds(
              ),
          src.
            getColorModel(
              ),
          src.
            getSampleModel(
              ),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_ALPHA);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          srcRed.
          getSampleModel(
            );
        if (sm.
              getNumBands(
                ) ==
              1)
            return srcRed.
              copyData(
                wr);
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          zeroRect(
            wr);
        java.awt.image.Raster srcRas =
          srcRed.
          getData(
            wr.
              getBounds(
                ));
        org.apache.batik.ext.awt.image.rendered.AbstractRed.
          copyBand(
            srcRas,
            srcRas.
              getNumBands(
                ) -
              1,
            wr,
            wr.
              getNumBands(
                ) -
              1);
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OYnt8GZD2I0/vyHkf1284nDuv6hdfkeIFAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/0v9HwAA");
}
