package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam params =
          new org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam(
          );
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 *
               100 /
               PixSzMM +
               0.5);
        int denom =
          100 *
          100;
        long[] rational =
          { numPix,
        denom };
        org.apache.batik.ext.awt.image.codec.tiff.TIFFField[] fields =
          { new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_RESOLUTION_UNIT,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_SHORT,
          1,
          new char[] { (char)
                         3 }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_X_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }),
        new org.apache.batik.ext.awt.image.codec.tiff.TIFFField(
          org.apache.batik.ext.awt.image.codec.tiff.TIFFImageDecoder.
            TIFF_Y_RESOLUTION,
          org.apache.batik.ext.awt.image.codec.tiff.TIFFField.
            TIFF_RATIONAL,
          1,
          new long[][] { rational }) };
        params.
          setExtraFields(
            fields);
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.TIFFTranscoder.
                  KEY_COMPRESSION_METHOD)) {
            java.lang.String method =
              (java.lang.String)
                hints.
                get(
                  org.apache.batik.transcoder.image.TIFFTranscoder.
                    KEY_COMPRESSION_METHOD);
            if ("packbits".
                  equals(
                    method)) {
                params.
                  setCompression(
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                      COMPRESSION_PACKBITS);
            }
            else
                if ("deflate".
                      equals(
                        method)) {
                    params.
                      setCompression(
                        org.apache.batik.ext.awt.image.codec.tiff.TIFFEncodeParam.
                          COMPRESSION_DEFLATE);
                }
                else {
                    
                }
        }
        try {
            int w =
              img.
              getWidth(
                );
            int h =
              img.
              getHeight(
                );
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder tiffEncoder =
              new org.apache.batik.ext.awt.image.codec.tiff.TIFFImageEncoder(
              ostream,
              params);
            int bands =
              sppsm.
              getNumBands(
                );
            int[] off =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                off[i] =
                  i;
            java.awt.image.SampleModel sm =
              new java.awt.image.PixelInterleavedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_BYTE,
              w,
              h,
              bands,
              w *
                bands,
              off);
            java.awt.image.RenderedImage rimg =
              new org.apache.batik.ext.awt.image.rendered.FormatRed(
              org.apache.batik.ext.awt.image.GraphicsUtil.
                wrap(
                  img),
              sm);
            tiffEncoder.
              encode(
                rimg);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public TIFFTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qtxz4haH5/8HWMxc+IgWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
