package org.apache.batik.ext.awt.image.codec.png;
public class PNGTranscoderInternalCodecWriteAdapter implements org.apache.batik.transcoder.image.PNGTranscoder.WriteAdapter {
    public void writeImage(org.apache.batik.transcoder.image.PNGTranscoder transcoder,
                           java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.apache.batik.transcoder.TranscodingHints hints =
          transcoder.
          getTranscodingHints(
            );
        int n =
          -1;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_INDEXED)) {
            n =
              ((java.lang.Integer)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_INDEXED)).
                intValue(
                  );
            if (n ==
                  1 ||
                  n ==
                  2 ||
                  n ==
                  4 ||
                  n ==
                  8)
                img =
                  org.apache.batik.ext.awt.image.rendered.IndexImage.
                    getIndexedImage(
                      img,
                      1 <<
                        n);
        }
        org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam params =
          org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
          getDefaultEncodeParam(
            img);
        if (params instanceof org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB) {
            ((org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB)
               params).
              setBackgroundRGB(
                new int[] { 255,
                255,
                255 });
        }
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_GAMMA)) {
            float gamma =
              ((java.lang.Float)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_GAMMA)).
              floatValue(
                );
            if (gamma >
                  0) {
                params.
                  setGamma(
                    gamma);
            }
            params.
              setChromaticity(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  DEFAULT_CHROMA);
        }
        else {
            params.
              setSRGBIntent(
                org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.
                  INTENT_PERCEPTUAL);
        }
        float PixSzMM =
          transcoder.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
        int numPix =
          (int)
            (1000 /
               PixSzMM +
               0.5);
        params.
          setPhysicalDimension(
            numPix,
            numPix,
            1);
        try {
            java.io.OutputStream ostream =
              output.
              getOutputStream(
                );
            org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder pngEncoder =
              new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
              ostream,
              params);
            pngEncoder.
              encode(
                img);
            ostream.
              flush(
                );
        }
        catch (java.io.IOException ex) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ex);
        }
    }
    public PNGTranscoderInternalCodecWriteAdapter() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SRO3W3IWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D978hbf/9gvfykun/wuucCVL6yEAAA==");
}
