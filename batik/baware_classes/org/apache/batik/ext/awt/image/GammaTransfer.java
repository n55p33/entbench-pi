package org.apache.batik.ext.awt.image;
public class GammaTransfer implements org.apache.batik.ext.awt.image.TransferFunction {
    public byte[] lutData;
    public float amplitude;
    public float exponent;
    public float offset;
    public GammaTransfer(float amplitude, float exponent, float offset) {
        super(
          );
        this.
          amplitude =
          amplitude;
        this.
          exponent =
          exponent;
        this.
          offset =
          offset;
    }
    private void buildLutData() { lutData = (new byte[256]);
                                  int j;
                                  int v;
                                  for (j = 0; j <= 255; j++) { v = (int) java.lang.Math.
                                                                     round(
                                                                       255 *
                                                                         (amplitude *
                                                                            java.lang.Math.
                                                                            pow(
                                                                              j /
                                                                                255.0F,
                                                                              exponent) +
                                                                            offset));
                                                               if (v >
                                                                     255) {
                                                                   v =
                                                                     (byte)
                                                                       255;
                                                               }
                                                               else
                                                                   if (v <
                                                                         0) {
                                                                       v =
                                                                         (byte)
                                                                           0;
                                                                   }
                                                               lutData[j] =
                                                                 (byte)
                                                                   (v &
                                                                      255);
                                  } }
    public byte[] getLookupTable() { buildLutData(
                                       );
                                     return lutData;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EK/YvPlvYVGLz/wcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
