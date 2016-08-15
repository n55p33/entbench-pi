package org.apache.batik.extension.svg;
public class BatikHistogramNormalizationFilter8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.extension.svg.BatikHistogramNormalizationFilter {
    private float trim = 0.01F;
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public float getTrim() { return trim; }
    public void setTrim(float trim) { this.trim = trim;
                                      touch(); }
    public BatikHistogramNormalizationFilter8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                                 float trim) {
        super(
          );
        setSource(
          src);
        setTrim(
          trim);
    }
    protected int[] histo = null;
    protected float slope;
    protected float intercept;
    public void computeHistogram(java.awt.image.renderable.RenderContext rc) {
        if (histo !=
              null)
            return;
        org.apache.batik.ext.awt.image.renderable.Filter src =
          getSource(
            );
        float scale =
          100.0F /
          src.
          getWidth(
            );
        float yscale =
          100.0F /
          src.
          getHeight(
            );
        if (scale >
              yscale)
            scale =
              yscale;
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            scale);
        rc =
          new java.awt.image.renderable.RenderContext(
            at,
            rc.
              getRenderingHints(
                ));
        java.awt.image.RenderedImage histRI =
          getSource(
            ).
          createRendering(
            rc);
        histo =
          new org.apache.batik.extension.svg.HistogramRed(
            convertSourceCS(
              histRI)).
            getHistogram(
              );
        int t =
          (int)
            (histRI.
               getWidth(
                 ) *
               histRI.
               getHeight(
                 ) *
               trim +
               0.5);
        int c;
        int i;
        for (c =
               0,
               i =
                 0;
             i <
               255;
             i++) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int low =
          i;
        for (c =
               0,
               i =
                 255;
             i >
               0;
             i--) {
            c +=
              histo[i];
            if (c >=
                  t)
                break;
        }
        int hi =
          i;
        slope =
          255.0F /
            (hi -
               low);
        intercept =
          slope *
            -low /
            255.0F;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        computeHistogram(
          rc);
        java.awt.image.SampleModel sm =
          srcRI.
          getSampleModel(
            );
        int bands =
          sm.
          getNumBands(
            );
        org.apache.batik.ext.awt.image.TransferFunction[] tfs =
          new org.apache.batik.ext.awt.image.TransferFunction[bands];
        org.apache.batik.ext.awt.image.TransferFunction tf =
          new org.apache.batik.ext.awt.image.LinearTransfer(
          slope,
          intercept);
        for (int i =
               0;
             i <
               tfs.
                 length;
             i++)
            tfs[i] =
              tf;
        return new org.apache.batik.ext.awt.image.rendered.ComponentTransferRed(
          convertSourceCS(
            srcRI),
          tfs,
          null);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "umQ1FOJF3Gp8a/8fRz4z3F0jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EXAmhBFRRuyKfMLtBWR7EBj5/zm30c1XR81w3Dv+ERyvID02o9wEZuKFAo9J" +
       "Nxk3m319yY5EysPxdV/OJ6kyUiRprXMKtzQDl4ejBtrg7cxP5Hi5ccitRhm2" +
       "tFyig9xHNl2NQAWMEIY0R1DaihtOMm9LCuOdPYnwKTH08Y21YhyC6qwhlcgd" +
       "QlWmHBs4fgtpB+0W1KrCkFrvVjUEQlv8ZuJY9soL02DD18fbsGYbKo97tZpg" +
       "T+2ARaueaEHUmkaRaNHlmquJverz+EQIXd/aCRMZs1mmbmC819BWVk7zq6DB" +
       "TnzMyFvL1ZyVLD82hfHE2a7mNX5Z5yxdXXvYxmNQY5kzAO8yK7MXRORF7Vpv" +
       "DJNGOnBYKZvIQ2q3yFinG6CJCC+snJwTbZImmkSVjHlmROPzjmGyJjXDSVbA" +
       "d9kKy1wrIeZrubFiXXblMdaqIUwUcbBI5y6S9ZZU1M+5apUcyi16s0hX1KQG" +
       "M8NMJFdsLVpTDc1g9ECGbXabcxpsTatLwzT8Ti1z/D4ci+gWZ4RFuqUX0SKN" +
       "m2ILFebRwpfg4SasT7kxPe+bRA7PGpOx79OZXXVNkiCmdWm3cqlFPyLJXU3z" +
       "fKxGd1pQ7sFJQ3T0VjweN/o+PqKq/kAe8roWEpbWG3h52qVrnLEBo+Jjx+SW" +
       "stmp46zNRVEsiMGQtTEhm01NVVuy7TDd1Kt8M+a26MgiYGJnpXCnOrZjdsRD" +
       "NaBVezzlJ7CzMzyrTUyqgxm66kki4feoBo/MWdFe1VBsnmsZhQzlONGWdm9h" +
       "4v0VF5BifeXTMoquPHqynUxXIKDst1aW7/R9FE2J2pC3eckeDRp+3wq46bS/" +
       "xXE0FusGPdxw0gJdopOhrwluh+d6dE70V8nMQ9qwMoVFdTuFqdRYDkhM8QJs" +
       "Bslsnx0aqMAgJOuPegt0OOpaiVYV5CBbr3BsQ87YdLjMkI4EuxySLZV44ndo" +
       "acWuHWAnytJhGxO0I7kJI7WJNm7XWW3YXQ1Fw/HUCWRBE6beoBeZ2xsovO1X" +
       "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" +
       "LXd/lVT6/Ms3HnrXy+zv74+Yj697XptV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HlJj2z575n8mf8UPFNUoOb+2vwHgF3/FEc/T91/LosoDIC14uVTZ93kwqjx5" +
       "7z4AA0/yZ3tdBUZ1sVdUuVz+n213PapcP20XVa7sM2ebPAJoAk2K7KP+scLG" +
       "r/+mUk8Mo0CQIsyzi3t2QOhA1qUKqPIY99KZ5fXIektlP/69lH3S5ezds4KM" +
       "8ib28RltvL+LfVv6wsuT+U+81vrl/d03yRbyvBjloVnl6v4a3sk573vvOdrx" +
       "WFdGH/juo1+89vxxuPDonuBTTzpD2zN3v2g2cPyovBqW/4N3/f0f/lsvf608" +
       "FPvfh2vnNiIvAAA=");
}
