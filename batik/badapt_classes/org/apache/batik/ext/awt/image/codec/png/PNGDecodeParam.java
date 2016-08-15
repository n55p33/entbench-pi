package org.apache.batik.ext.awt.image.codec.png;
public class PNGDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    public PNGDecodeParam() { super(); }
    private boolean suppressAlpha = false;
    public boolean getSuppressAlpha() { return suppressAlpha; }
    public void setSuppressAlpha(boolean suppressAlpha) { this.suppressAlpha =
                                                            suppressAlpha;
    }
    private boolean expandPalette = false;
    public boolean getExpandPalette() { return expandPalette; }
    public void setExpandPalette(boolean expandPalette) { this.expandPalette =
                                                            expandPalette;
    }
    private boolean output8BitGray = false;
    public boolean getOutput8BitGray() { return output8BitGray; }
    public void setOutput8BitGray(boolean output8BitGray) { this.output8BitGray =
                                                              output8BitGray;
    }
    private boolean performGammaCorrection = true;
    public boolean getPerformGammaCorrection() { return performGammaCorrection;
    }
    public void setPerformGammaCorrection(boolean performGammaCorrection) {
        this.
          performGammaCorrection =
          performGammaCorrection;
    }
    private float userExponent = 1.0F;
    public float getUserExponent() { return userExponent; }
    public void setUserExponent(float userExponent) { if (userExponent <=
                                                            0.0F) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                              getString(
                                                                "PNGDecodeParam0"));
                                                      }
                                                      this.
                                                        userExponent =
                                                        userExponent;
    }
    private float displayExponent = 2.2F;
    public float getDisplayExponent() { return displayExponent;
    }
    public void setDisplayExponent(float displayExponent) {
        if (displayExponent <=
              0.0F) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGDecodeParam1"));
        }
        this.
          displayExponent =
          displayExponent;
    }
    private boolean expandGrayAlpha = false;
    public boolean getExpandGrayAlpha() {
        return expandGrayAlpha;
    }
    public void setExpandGrayAlpha(boolean expandGrayAlpha) {
        this.
          expandGrayAlpha =
          expandGrayAlpha;
    }
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    public boolean getGenerateEncodeParam() {
        return generateEncodeParam;
    }
    public void setGenerateEncodeParam(boolean generateEncodeParam) {
        this.
          generateEncodeParam =
          generateEncodeParam;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getEncodeParam() {
        return encodeParam;
    }
    public void setEncodeParam(org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam encodeParam) {
        this.
          encodeParam =
          encodeParam;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zxPN5xn5z6iB5/gjPj3/X2ns4SWKMAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lk3feyDOg4UW7wPHh/fE+fDx6e9D+U+e");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+356Zz6nrPl/5ZS4rxbBb8WlC6YRC0dXT7fT+odW9+U3m2M9WvD2xutXbjUp" +
       "1h3mexznt4bjmcME3W2Cr51C9OtF8K8B0egY0RNnmdf+Uj8k/9s3Qf5A4GCP" +
       "fHDrBf6DU+L+sAj+w05g4qoV2EOO37gVAn98j+PH3yKB//gUov+tCL65E/gq" +
       "ov/2kOi3blbMi+B4aY/oS7dezO+dEve/iuA7oKcAYg6uXrM+JPmnN6tmsQr3" +
       "S3skf+ktUvOvT2H6N0Xwl4BpdBLTI3L+1c3K+Rw4vrjH9Iu3XM4zd58Sd64I" +
       "botL7wZyDq+9zH9A9sztNysrA47X98i+/tbIeuYdpzB+qAjOA8bRaYwP5T1z" +
       "4SYYbwc/j4Pjq3uMv3rr5X38lLgni+CH4tJ5IO/kyA6JIq19SPE9NysqAo5v" +
       "71H89i0X1d5yee4UnpeK4IcBz+hqnkekfPpmpSx60T/f4/nnt17K5ilxxQry" +
       "GSQuPQCkxE/YPXLIsnYLPO+Zh3d5d+e3QM3TqoEsgg8CqtGJVI8I+qZbyd7M" +
       "9T4FQF3co3rx1gs6PCWOL4LeTlDihB03hyzZmxX0eQAY2WOJ3HJBdz73x06h" +
       "+pEikHaCnkD1iKDTmxX0GQBqL+/ufGsFXZwSZxVBsZ8aCEpdY5fSIVP9ZkXt" +
       "lIodlzum7FskanwK3XUR+IBudE26R4QNboLuI8XNp4sdPnt0xVsv7CdOiXux" +
       "CD4Wl+4rWuqVDD91yPDHb1bQDwCwl/cYXr7lgn5qS+VnT6H5chG8BGhGV9E8" +
       "IuQnb4RmBkq78juc4qOCh6/6IHD3EZv2xdfO3/2u1yb/afspysGHZvewpbvn" +
       "ieMc3QN+5PpO8CI9X27p37PbER5s6bwal56+3n13cek2EBbwz7yyy/2ZuHTx" +
       "enLHpTu256N5fzkuPXp6XpBrez6a67W49PC1cgF8IDya+tfi0jtOSg1SgvBo" +
       "ys+CF9LjKcHzt+ej6X49Lp07TBeX7txdHE3yeVA6SFJc/uPdPtcrdwLutvhn" +
       "uym8h4+a+vZF6YE3M52DLEe/wCmqYPuh6f4EWbL71PSy9qXXuv2Pfb/xud0X" +
       "QJqj5nlRyt1s6a7dx0jbQotJtieuWdp+WXfSz/zgvt+856n9CcH7doAPm90R" +
       "bI+d/LkN4Qbx9gOZ/Lfe9U9/5Ndf+6PtxsT/B4a67FsBPAAA");
}
