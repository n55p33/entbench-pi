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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a0pWQyFexK3Bt/b/AU4GYZBdIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IuRRRBA9gjCNuNtqdhf5Ioppve3145HhTFGSoUAcYSfpyFTqGux7dZLlMDKc" +
       "Uc56NwZhJapQPWlXR/t+Vew5OtevGQKiG5ZDuUTH0OTeKHT0VbeniIDXeDdg" +
       "Mlkb1mJeVeDdXO3MRihu80qE9Hh1p482nEbEBJ60s/kut3xeqildZmhi9WBJ" +
       "oxYX1EEYvZrljKAYRJpoaKMWsBFWR4Y+s2qOYTk2xinSqnkVr7kbdRBTRAe8" +
       "UrcTMzIccohzwyYXMz0VJ1xfs6vaEuZCh1cUk8n9HZxIW3crra21V1kwmVFV" +
       "6/EEgyvRaEmNHZ/cUDremjU1J6pJO7Wuy+62aWDeYpzz9BJleXcwrzoySScO" +
       "ozdmI4eeGknXnrU7K4ZtZFVcaaI40qzuaqvaYunVW7gZ6nKI4jwMVMPA3RZs" +
       "ZxtvqFP9MOCX5JqV6wGb7lAQDIynze2QauCaWrWwWOalqrecZbiajhEshNcw" +
       "umgMBRDdEwmKFlsZf/v1bbE8Vu4mnVzZ2VrtouJTr2MXJT2zV3my81b+LkFH" +
       "1zuO/8/svJ05gLpwvHP1oTd6maE4a3vqXld6ykPFz37sxZcU+hdrB0c7nt0Q" +
       "uhK63gcsNVatMzRdKvPO7efxxU7iB474+cD5ncRTid19G/G96d02ci+cNqiW" +
       "Db54n+3Z3yiSLwCKAzXc74rddRcsdg3ldOl+9bttgJ2d5RzXjxeF3weexhHX" +
       "jTeH67NM/bP71P1WkfxjwLB+zHApqFPmXnkDzJVq+gR4bh4xd/PNZ+5f3Kfu" +
       "K0XypRC6DJjjjs/2Tln78htgrdTW58CDHbGGvena2iwb/Jv78PfVIvlDwF9w" +
       "yt8/OOXvj94of8UlMv6IP/5N5e8Yj76/3Ne+67UMtswe3dYsx/r6fUTxZ0Xy" +
       "H8LizNr2QER8gmHnZPInb0Am31sUFsfMHzmSyUfe9DX/07LBt+/D6J8Xyash" +
       "dE32VSlU91IyHP1You88J9F9A1UhirdTOfyX1yOHNISef03X3Io7O0/ccS13" +
       "f5VU/txL1x56x0uLP9wfMR9f97wygR7S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Iss6e+Z/Jn/J81XNKDm/sr8B4BV/xRHP0/f3ZSH0AEgLXi5A+z4PhtCT9+4D" +
       "MPAkf7bXZaBU53uF0MXy/2y7qyF09bRdCF3aZ842eQTQBJoU2Ue94wUjXvtN" +
       "JXQdhL4khz3XKu7ZAaEDWZdLwJbHuBfOuNcj7S0X+/HvttgnXc7ePSvIKG9i" +
       "H5/RRvu72Lfkz79ETn/s1dYv7u++yZaU58UoD02gy/treCfnvO++52jHY10a" +
       "ve87j37hyvPH4cKje4JPLekMbc/c/aLZwPbC8mpY/vff8es/+Hdf+mp5KPa/" +
       "AR++I4siLwAA");
}
