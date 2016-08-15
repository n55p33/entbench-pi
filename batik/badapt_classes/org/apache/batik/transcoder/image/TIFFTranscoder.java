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
          1471028785000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471028785000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "ppDqxchlxlTYaasr11FxN5g35Z4TzCtTxIDBrg1hFpXDooQjCD2B+0k46Tpq" +
           "vBAHjUnZSsipZqRrETbnAoKgKGzwbQFdYIrI9xc82VUVR5fXvaBlkI4AnDRT" +
           "Y3FKJU0kWJYKcDjpdYPVdEOhhN1fzpPpyMBHQbjaUMkgwfy6UVDGhisyOEuO" +
           "3EmL0NuEKQ7KNmPM1mKRnTCax9aZ4aibxmKnOxiv55Rf5yx9VXThRROza8Uy" +
           "ERTHRmW96HfwmSGxPY1U8I47WLLV9rJfaZdAxCa6kVDAE2qBFu2RgIdRRJvD" +
           "6qDLzgZ4bT21fZZKGqGXkJrPkJToRBO+jjY7fGG5VNMK0vPhfqdZXjndhl4N" +
           "u1N8OCy2pYpNBuEoqeKsSstT04+L5fkqqhHFwdLalMblsVBdLEobmCJFFN+Q" +
           "KtcHVtRi5ymtCcOq1Sq5w25lPico8K656I1gAtEm1W4wZUiWbcsRuzIRfNZy" +
           "6O6UjN04xerzZowWF06pyG+UatEhyJQecY5LDpq6s9JmLVzWTNogO8t0EY4Q" +
           "PUXUNa4mpdqgNYjmCLwc1ERZRVJ40l7KuN9pOAtTYbwKV290qaGL9SZBv4EL" +
           "fXdWIwWWmNoFJCgDw1lX3XDYNQaoVW0bxJjtNxGS74TjujwtMZGGNJMGN51z" +
           "6YoYVR3Ut5sTdFITSY4SnPWCcodh6Dci38VDSsHRcohGaGPoaJV6K0HQhUe0" +
           "erNuYTPD1yOWn7LxqKY1QpfnG9p6npJU0y2vpji30roa0+GXxfEQn5WwWqtv" +
           "YOF8zWwIebNsM5XSut8a+B1mICNIGbcwpkfHlfLSG9EgfASaPQ2SQqFA11QZ" +
           "Bi537AMrrog0xk7jqYd0EyWUKGO+WKVpQtP0YFhYV2a9ZdtoJ5ihGZzXZby1" +
           "LpMqtZww9Q6hMz3KJjG9GVOVhV5poCtsZKRqqzkdVZe8utRho1R22+6iONNX" +
           "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" +
           "R3YRhcpe+P3IBSeLE68Re9DrVrO/ysD3");
        java.lang.String jlc$ClassType$jl5$1 =
          ("M1pnwetGLBnhG6JhexczcP5Qw/ZuzcCFN0jD9nZ6geWTXbrugL38FXzvrtdx" +
           "Qt7L7jjtXc7A3btFvW4BPXBSQPdm4P43UtXO7FaEZeCz+bQP30xUb3m9KrX3" +
           "UAYeycCjb6C83npSXk9k4MkkhO44fqUz616Ac9QDL7tXvr0Lrfz6C5duu/+F" +
           "8R/m6Z2j+8oXetBt88g0j99EPPZ83vW1uZEv8MI2o5O/HO89FUKP3TRXEUK3" +
           "GIev93tv2yI+HUJvvgFiCF0MTyQ3DvFg8Cp9Gg/Qz7+PjysDCrtxIMZuH44P" +
           "qYKjCRiSPdayG5PXOdvdfbPNOpZ3fOK6LzRMtP0XgKvKp16g+z/1Uu0T2yuX" +
           "4ICZphkV8MZw6zablhPNMlOPXZfaIa3znae+e+dvXHjyMJN555bhnd0c4+0t" +
           "185zEZYb5pmp9Dfv/8c/8vdf+Gp+7e//AeiPAYWZMQAA");
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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HQAA");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.transcoder.image.TIFFTranscoder ENT_ld =
          new org.apache.batik.transcoder.image.TIFFTranscoder(
          );
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+eVI/i/e+aXv/ulX/rQ89/x/nlR3WgUrAAA=");
}
