package org.apache.batik.transcoder.image;
public class TIFFTranscoder extends org.apache.batik.transcoder.image.ImageTranscoder implements ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
                                          LOW_MODE; }
    public TIFFTranscoder() { super();
                              hints.put(KEY_FORCE_TRANSPARENT_WHITE,
                                        java.lang.Boolean.
                                          FALSE); }
    public org.apache.batik.bridge.UserAgent getUserAgent() { return this.
                                                                       userAgent;
    }
    public java.awt.image.BufferedImage createImage(int width,
                                                    int height) {
        return new java.awt.image.BufferedImage(
          width,
          height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    private org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter getWriteAdapter(java.lang.String className) {
        org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter adapter;
        try {
            java.lang.Class clazz =
              java.lang.Class.
              forName(
                className);
            adapter =
              (org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter)
                clazz.
                newInstance(
                  );
            return adapter;
        }
        catch (java.lang.ClassNotFoundException e) {
            return null;
        }
        catch (java.lang.InstantiationException e) {
            return null;
        }
        catch (java.lang.IllegalAccessException e) {
            return null;
        }
    }
    public void writeImage(java.awt.image.BufferedImage img,
                           org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        boolean forceTransparentWhite =
          false;
        if (hints.
              containsKey(
                org.apache.batik.transcoder.image.PNGTranscoder.
                  KEY_FORCE_TRANSPARENT_WHITE)) {
            forceTransparentWhite =
              ((java.lang.Boolean)
                 hints.
                 get(
                   org.apache.batik.transcoder.image.PNGTranscoder.
                     KEY_FORCE_TRANSPARENT_WHITE)).
                booleanValue(
                  );
        }
        if (forceTransparentWhite) {
            java.awt.image.SinglePixelPackedSampleModel sppsm;
            sppsm =
              (java.awt.image.SinglePixelPackedSampleModel)
                img.
                getSampleModel(
                  );
            forceTransparentWhite(
              img,
              sppsm);
        }
        org.apache.batik.transcoder.image.TIFFTranscoder.WriteAdapter adapter =
          getWriteAdapter(
            ("org.apache.batik.ext.awt.image.codec.tiff.TIFFTranscoderInte" +
             "rnalCodecWriteAdapter"));
        if (adapter ==
              null) {
            adapter =
              getWriteAdapter(
                ("org.apache.batik.transcoder.image.TIFFTranscoderImageIOWrite" +
                 "Adapter"));
        }
        if (adapter ==
              null) {
            throw new org.apache.batik.transcoder.TranscoderException(
              ("Could not write TIFF file because no WriteAdapter is availbl" +
               "e"));
        }
        adapter.
          writeImage(
            this,
            img,
            output);
    }
    public static interface WriteAdapter {
        void writeImage(org.apache.batik.transcoder.image.TIFFTranscoder transcoder,
                        java.awt.image.BufferedImage img,
                        org.apache.batik.transcoder.TranscoderOutput output)
              throws org.apache.batik.transcoder.TranscoderException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471109864000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "803zI7uIQmUHfj9ywc7ixDFiD3rdZvZX");
        java.lang.String jlc$ClassType$jl5$1 =
          ("GfheRussOG5sJCN8Qyxs72IGLhxa2N4tGbjtDbKwvZ1dNHJml27YYS8/gu/d" +
           "9Tp2yHvZHae9yxm4ezeo162gB04q6N4M3P9GmtqZ3YgaGfhMzvbhl1PVW16v" +
           "Se09lIFHMvDoG6ivt57U1xMZeDIOoTuOX+nMmhdgH/XANffKt3eh5V974dKt" +
           "978w/qM8vXN0X/k2GrpVi0zz+E3EY88XXF/VjHyAt20zOvnheO+pEHrsZXMV" +
           "IXTeODze771ti/h0CL35JoghdDE8kdw4xIPBUfo0HqCffx/vhwAKu34gxm4f" +
           "jndBwdYEdMkeq9mNyRvs7e5+uck6lnd84oYHmn60/ReAq/InX+gyP/FS9ePb" +
           "K5dgg5mmGRVwYrhlm03LiWaZqcduSO2Q1oXOU9+589dve/Iwk3nnVuDdujkm" +
           "21uun+ciLTfMM1Ppb93/T37oH73wlfza3/8DglRrSZkxAAA=");
    }
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_FORCE_TRANSPARENT_WHITE =
      org.apache.batik.transcoder.image.ImageTranscoder.
        KEY_FORCE_TRANSPARENT_WHITE;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_COMPRESSION_METHOD =
      new org.apache.batik.transcoder.keys.StringKey(
      );
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ph0AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.image.TIFFTranscoder ENT_ld =
          new org.apache.batik.transcoder.image.TIFFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Un49kv+7t3/x23/y5d8rzz7/Fi3z7vUJKwAA");
}
