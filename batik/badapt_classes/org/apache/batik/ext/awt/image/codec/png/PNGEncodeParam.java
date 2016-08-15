package org.apache.batik.ext.awt.image.codec.png;
public abstract class PNGEncodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageEncodeParam {
    public static final int INTENT_PERCEPTUAL = 0;
    public static final int INTENT_RELATIVE = 1;
    public static final int INTENT_SATURATION = 2;
    public static final int INTENT_ABSOLUTE = 3;
    public static final int PNG_FILTER_NONE = 0;
    public static final int PNG_FILTER_SUB = 1;
    public static final int PNG_FILTER_UP = 2;
    public static final int PNG_FILTER_AVERAGE = 3;
    public static final int PNG_FILTER_PAETH = 4;
    public static org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getDefaultEncodeParam(java.awt.image.RenderedImage im) {
        java.awt.image.ColorModel colorModel =
          im.
          getColorModel(
            );
        if (colorModel instanceof java.awt.image.IndexColorModel) {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Palette(
              );
        }
        java.awt.image.SampleModel sampleModel =
          im.
          getSampleModel(
            );
        int numBands =
          sampleModel.
          getNumBands(
            );
        if (numBands ==
              1 ||
              numBands ==
              2) {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.Gray(
              );
        }
        else {
            return new org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam.RGB(
              );
        }
    }
    public static class Palette extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public Palette() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  1 &&
                  bitDepth !=
                  2 &&
                  bitDepth !=
                  4 &&
                  bitDepth !=
                  8) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam2"));
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int[] palette = null;
        private boolean paletteSet = false;
        public void setPalette(int[] rgb) {
            if (rgb.
                  length <
                  1 *
                  3 ||
                  rgb.
                    length >
                  256 *
                  3) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam0"));
            }
            if (rgb.
                  length %
                  3 !=
                  0) {
                throw new java.lang.IllegalArgumentException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam1"));
            }
            palette =
              (int[])
                rgb.
                clone(
                  );
            paletteSet =
              true;
        }
        public int[] getPalette() { if (!paletteSet) {
                                        throw new java.lang.IllegalStateException(
                                          org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                            getString(
                                              "PNGEncodeParam3"));
                                    }
                                    return (int[])
                                             palette.
                                             clone(
                                               );
        }
        public void unsetPalette() { palette =
                                       null;
                                     paletteSet =
                                       false;
        }
        public boolean isPaletteSet() { return paletteSet;
        }
        private int backgroundPaletteIndex;
        public void setBackgroundPaletteIndex(int index) {
            backgroundPaletteIndex =
              index;
            backgroundSet =
              true;
        }
        public int getBackgroundPaletteIndex() {
            if (!backgroundSet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam4"));
            }
            return backgroundPaletteIndex;
        }
        private int[] transparency;
        public void setPaletteTransparency(byte[] alpha) {
            transparency =
              (new int[alpha.
                         length]);
            for (int i =
                   0;
                 i <
                   alpha.
                     length;
                 i++) {
                transparency[i] =
                  alpha[i] &
                    255;
            }
            transparencySet =
              true;
        }
        public byte[] getPaletteTransparency() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam5"));
            }
            byte[] alpha =
              new byte[transparency.
                         length];
            for (int i =
                   0;
                 i <
                   alpha.
                     length;
                 i++) {
                alpha[i] =
                  (byte)
                    transparency[i];
            }
            return alpha;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fy06eovBga27dFhC/76e3+LdDf8H1szbr+krAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "X/H279q5LcNq5gUvvYW3XslZHyGKAY9O");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("BRSvsfObE0eAjr1DPfapuJR/qHv0Zqe0io90n//ESy/L45+Hz+3fjY/C0vn9" +
           "4bmjft5R3Jsnj1/k39aivQzR6fe4R+Bv/BL3meSN3vf/2hll/zhP/mFYuhQ5" +
           "gRKi115V3/ANZOzq8pEafvmNXj4eH+sU7PzgVem94ProHvZHbz3sL51R9pU8" +
           "+ecAth6gx78V59nkEcTffBsQC83+FXB9cg/xk7cG4sFRhQ8VFf71GTi/miev" +
           "hcDsgHL1EFO83Te3Xz/C+K/eLsZnwfXyHuPLtxzjsqjw+hkY/yhPfj8sXQQY" +
           "919YTkH8D28D4gN55uPg+tU9xF+99Zb6tTPKvpEn/wWg006gWx6h+5O3q8An" +
           "wfXqHt2rtx7dn59R9r/z5H+EpbsL+rmx9v7n2+WZ/DPZl/f4vnzL8R3cdkbZ" +
           "HXnmXwB8esCc/Dx5hO+7b1d/LXB9dY/vq7fcAQuSObh0Bsj78uRiWPq+EyvI" +
           "6Y+dRxo9eMfbQPzOPPP94PrjPeI/vvUa/f4zyvJv7gcPArDaWWA/dAT2oVuh" +
           "3m/vwX77lqq3eOaujfbuvPMnQP6v7wbb/b79gyeir8uaAqFCoLCSr3uh7mg9" +
           "J9Z917FBH7fqfMubGeaG51tuF9NQueHc5J9PD57df0o/qLxRbLmPY/NELqwg" +
           "b/XM9Sdb8kc1T9bXH1UpDGA3bNE6f3bPsMfmGWXtPKnnJeFOkjPqPpfsfn/g" +
           "jDp5SH/wZFh68IirZ6cODhzz8qfehuE/uPfygwt7U7xw6728f0YZkScoQKrd" +
           "DOnBM0dIu28FaRKWLuy7LMoeCEvN7/FYPdiSPHzdv/fs/iVF+sLLl+586OX5" +
           "v92dgDv8t5G7RqU71ciyjp/kPHZ/3vMVVS9m7q7duU6vmI5pWHrmzcoYlm4D" +
           "aQ7tYLJrPQ9LV95M6/zUUf57vO0yLD12dlvQqvg93upHwtLDN2sF5APp8dof" +
           "DkvvulFtUBOkx2sKYeny6Zpg/OL3eD0ZxGtH9cA+cHdzvEo+T6BKfrsu2GWc" +
           "7Jz/4eMeUQQI97+ReR3boj514pxb8S9ih2fSot0/iT0vffFlkv7RbzV+fndm" +
           "X7KELMt7uXNUurD794Gi0/xc23tu2tthX+cHz37n3l+66+nDTe+9O4GPvPOY" +
           "bI/f+IB8z/bC4kh79msP/fIP/t2X/6A4WPP/AZU13FS7NwAA");
    }
    public static class Gray extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public Gray() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  1 &&
                  bitDepth !=
                  2 &&
                  bitDepth !=
                  4 &&
                  bitDepth !=
                  8 &&
                  bitDepth !=
                  16) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int backgroundPaletteGray;
        public void setBackgroundGray(int gray) {
            backgroundPaletteGray =
              gray;
            backgroundSet =
              true;
        }
        public int getBackgroundGray() { if (!backgroundSet) {
                                             throw new java.lang.IllegalStateException(
                                               org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGEncodeParam6"));
                                         }
                                         return backgroundPaletteGray;
        }
        private int[] transparency;
        public void setTransparentGray(int transparentGray) {
            transparency =
              (new int[1]);
            transparency[0] =
              transparentGray;
            transparencySet =
              true;
        }
        public int getTransparentGray() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam7"));
            }
            int gray =
              transparency[0];
            return gray;
        }
        private int bitShift;
        private boolean bitShiftSet = false;
        public void setBitShift(int bitShift) {
            if (bitShift <
                  0) {
                throw new java.lang.RuntimeException(
                  );
            }
            this.
              bitShift =
              bitShift;
            bitShiftSet =
              true;
        }
        public int getBitShift() { if (!bitShiftSet) {
                                       throw new java.lang.IllegalStateException(
                                         org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                           getString(
                                             "PNGEncodeParam8"));
                                   }
                                   return bitShift;
        }
        public void unsetBitShift() { bitShiftSet =
                                        false;
        }
        public boolean isBitShiftSet() { return bitShiftSet;
        }
        public boolean isBitDepthSet() { return bitDepthSet;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dioAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/YM8+XsxdHntRnpMHH0Du+FOX+JZ2rEa");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("fvGtNvlO9nUG9sP5y2cAgmcOYD9z62F/9Zy8r+XJPwWwrYg4+VG22GM+hvir" +
           "7wJiodm/CKStHkCs3hqIe8cF+KLAvzwH57/Kk6/H0D25cq2Y1P3dR6N/dIzx" +
           "X7xbjDCQhjrASH2PML55DsY/yJPfBeRxyoDzr7dnkP67d4G0oIarQKbZAdLZ" +
           "rTfYb5yT9808+U8ApHkjkPwxyD98t+q8BuRdHIBcfI/U+SfnIP3fefLfY+hB" +
           "oM7p0dft+Ab6/B/vVp8576YHUNNbrs+9287JuyN/+acApXlDlCcU+t1bwUE/" +
           "doDyx743Ct27fA7UB/Lk7iMOOvrIeKzJvXverSYfB9J88QDjF2+9Jr/vnLz8" +
           "K/LeQwCeeRresQr3Hn63KszPi7x2AO+1Ww/v+8/JezZPnoyh+3YBwo3199S7" +
           "DQVyZv25A4A/d+sBoufk1fJkHwAEocCZj83HAOFbAfArBwC/cusBPn9OXjNP" +
           "fuAQYBECXA/w2jsBmIJY8Oh01PtiqPFnPHwNQupHrvsRyO6HC+qXXr186eFX" +
           "Z/9md97o8McFd/WhS8batk8e+Ttxf9EPdcMqRuuu3QFAvxiCbgx96O3KGEO3" +
           "gTSHtsfsarMxdPXt1M6PfeTXk3WHMfT4+XVBreJ6stYkhh65WS0gH0hPluZj" +
           "6L03Kg1KgvRkSTGGrpwtCfovrifLfTyG7j4uB9Yxu5uTRV4ArYMi+e0nczPe" +
           "o9PdqaZHTnpBMYM9+Fa2dWKJ9dSpg0bFD4kODwWtdz8lekH98qtd7oe/Xf+Z" +
           "3eFu1Zaz4tjNpT505+6cedFofrDogzdt7bCti51nv3P/L9z19OGi7f6dwMce" +
           "eUK2J258krrt+HFx9jn75Yd/8SN/+9XfKw5g/H/9jcmQ4TUAAA==");
    }
    public static class RGB extends org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam {
        public RGB() { super(); }
        private boolean backgroundSet = false;
        public void unsetBackground() { backgroundSet =
                                          false;
        }
        public boolean isBackgroundSet() {
            return backgroundSet;
        }
        public void setBitDepth(int bitDepth) {
            if (bitDepth !=
                  8 &&
                  bitDepth !=
                  16) {
                throw new java.lang.RuntimeException(
                  );
            }
            this.
              bitDepth =
              bitDepth;
            bitDepthSet =
              true;
        }
        private int[] backgroundRGB;
        public void setBackgroundRGB(int[] rgb) {
            if (rgb.
                  length !=
                  3) {
                throw new java.lang.RuntimeException(
                  );
            }
            backgroundRGB =
              rgb;
            backgroundSet =
              true;
        }
        public int[] getBackgroundRGB() {
            if (!backgroundSet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam9"));
            }
            return backgroundRGB;
        }
        private int[] transparency;
        public void setTransparentRGB(int[] transparentRGB) {
            transparency =
              (int[])
                transparentRGB.
                clone(
                  );
            transparencySet =
              true;
        }
        public int[] getTransparentRGB() {
            if (!transparencySet) {
                throw new java.lang.IllegalStateException(
                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                    getString(
                      "PNGEncodeParam10"));
            }
            return (int[])
                     transparency.
                     clone(
                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "dQTQQFpC+96+9sUUuvb91C6O7orn6bqX");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("UuipO9cFtcrn6Vr3ptDjt6sF9APpaen7U+gtt5IGkiA9LXkFTOvzkqD/8nla" +
           "7uEUuu9EDgQX+5fTIsDsF4FI8fpo6cnfzS+cDWKOXevhV3OtU3HP02cOi8ub" +
           "1kcHu9n+rvWzxhdeINkffaX52f31N8PTdruilXto6PL+Jl7ZaHE4/I7btnbU" +
           "1qXhe77z4C/c+8xRJPXgXuGTSXlKt7fd+q5Zz4/S8nbY7t889os/+K9e+OPy" +
           "ZO//AdAp+BMCLwAA");
    }
    protected int bitDepth;
    protected boolean bitDepthSet = false;
    public abstract void setBitDepth(int bitDepth);
    public int getBitDepth() { if (!bitDepthSet) {
                                   throw new java.lang.IllegalStateException(
                                     org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                       getString(
                                         "PNGEncodeParam11"));
                               }
                               return bitDepth;
    }
    public void unsetBitDepth() { bitDepthSet =
                                    false;
    }
    private boolean useInterlacing = false;
    public void setInterlacing(boolean useInterlacing) {
        this.
          useInterlacing =
          useInterlacing;
    }
    public boolean getInterlacing() { return useInterlacing;
    }
    public void unsetBackground() { throw new java.lang.RuntimeException(
                                      org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                        getString(
                                          "PNGEncodeParam23"));
    }
    public boolean isBackgroundSet() { throw new java.lang.RuntimeException(
                                         org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                           getString(
                                             "PNGEncodeParam24"));
    }
    private float[] chromaticity = null;
    private boolean chromaticitySet = false;
    public void setChromaticity(float[] chromaticity) {
        if (chromaticity.
              length !=
              8) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          chromaticity =
          (float[])
            chromaticity.
            clone(
              );
        chromaticitySet =
          true;
    }
    public void setChromaticity(float whitePointX,
                                float whitePointY,
                                float redX,
                                float redY,
                                float greenX,
                                float greenY,
                                float blueX,
                                float blueY) {
        float[] chroma =
          new float[8];
        chroma[0] =
          whitePointX;
        chroma[1] =
          whitePointY;
        chroma[2] =
          redX;
        chroma[3] =
          redY;
        chroma[4] =
          greenX;
        chroma[5] =
          greenY;
        chroma[6] =
          blueX;
        chroma[7] =
          blueY;
        setChromaticity(
          chroma);
    }
    public float[] getChromaticity() { if (!chromaticitySet) {
                                           throw new java.lang.IllegalStateException(
                                             org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                               getString(
                                                 "PNGEncodeParam12"));
                                       }
                                       return (float[])
                                                chromaticity.
                                                clone(
                                                  );
    }
    public void unsetChromaticity() { chromaticity =
                                        null;
                                      chromaticitySet =
                                        false;
    }
    public boolean isChromaticitySet() { return chromaticitySet;
    }
    private float gamma;
    private boolean gammaSet = false;
    public void setGamma(float gamma) { this.
                                          gamma =
                                          gamma;
                                        gammaSet =
                                          true;
    }
    public float getGamma() { if (!gammaSet) {
                                  throw new java.lang.IllegalStateException(
                                    org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                      getString(
                                        "PNGEncodeParam13"));
                              }
                              return gamma;
    }
    public void unsetGamma() { gammaSet =
                                 false; }
    public boolean isGammaSet() { return gammaSet;
    }
    private int[] paletteHistogram = null;
    private boolean paletteHistogramSet =
      false;
    public void setPaletteHistogram(int[] paletteHistogram) {
        this.
          paletteHistogram =
          (int[])
            paletteHistogram.
            clone(
              );
        paletteHistogramSet =
          true;
    }
    public int[] getPaletteHistogram() { if (!paletteHistogramSet) {
                                             throw new java.lang.IllegalStateException(
                                               org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                 getString(
                                                   "PNGEncodeParam14"));
                                         }
                                         return paletteHistogram;
    }
    public void unsetPaletteHistogram() {
        paletteHistogram =
          null;
        paletteHistogramSet =
          false;
    }
    public boolean isPaletteHistogramSet() {
        return paletteHistogramSet;
    }
    private byte[] ICCProfileData = null;
    private boolean ICCProfileDataSet = false;
    public void setICCProfileData(byte[] ICCProfileData) {
        this.
          ICCProfileData =
          (byte[])
            ICCProfileData.
            clone(
              );
        ICCProfileDataSet =
          true;
    }
    public byte[] getICCProfileData() { if (!ICCProfileDataSet) {
                                            throw new java.lang.IllegalStateException(
                                              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                getString(
                                                  "PNGEncodeParam15"));
                                        }
                                        return (byte[])
                                                 ICCProfileData.
                                                 clone(
                                                   );
    }
    public void unsetICCProfileData() { ICCProfileData =
                                          null;
                                        ICCProfileDataSet =
                                          false;
    }
    public boolean isICCProfileDataSet() {
        return ICCProfileDataSet;
    }
    private int[] physicalDimension = null;
    private boolean physicalDimensionSet =
      false;
    public void setPhysicalDimension(int[] physicalDimension) {
        this.
          physicalDimension =
          (int[])
            physicalDimension.
            clone(
              );
        physicalDimensionSet =
          true;
    }
    public void setPhysicalDimension(int xPixelsPerUnit,
                                     int yPixelsPerUnit,
                                     int unitSpecifier) {
        int[] pd =
          new int[3];
        pd[0] =
          xPixelsPerUnit;
        pd[1] =
          yPixelsPerUnit;
        pd[2] =
          unitSpecifier;
        setPhysicalDimension(
          pd);
    }
    public int[] getPhysicalDimension() {
        if (!physicalDimensionSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam16"));
        }
        return (int[])
                 physicalDimension.
                 clone(
                   );
    }
    public void unsetPhysicalDimension() {
        physicalDimension =
          null;
        physicalDimensionSet =
          false;
    }
    public boolean isPhysicalDimensionSet() {
        return physicalDimensionSet;
    }
    private org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[]
      suggestedPalette =
      null;
    private boolean suggestedPaletteSet =
      false;
    public void setSuggestedPalette(org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[] palette) {
        suggestedPalette =
          (org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[])
            palette.
            clone(
              );
        suggestedPaletteSet =
          true;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[] getSuggestedPalette() {
        if (!suggestedPaletteSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam17"));
        }
        return (org.apache.batik.ext.awt.image.codec.png.PNGSuggestedPaletteEntry[])
                 suggestedPalette.
                 clone(
                   );
    }
    public void unsetSuggestedPalette() {
        suggestedPalette =
          null;
        suggestedPaletteSet =
          false;
    }
    public boolean isSuggestedPaletteSet() {
        return suggestedPaletteSet;
    }
    private int[] significantBits = null;
    private boolean significantBitsSet = false;
    public void setSignificantBits(int[] significantBits) {
        this.
          significantBits =
          (int[])
            significantBits.
            clone(
              );
        significantBitsSet =
          true;
    }
    public int[] getSignificantBits() { if (!significantBitsSet) {
                                            throw new java.lang.IllegalStateException(
                                              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                getString(
                                                  "PNGEncodeParam18"));
                                        }
                                        return (int[])
                                                 significantBits.
                                                 clone(
                                                   );
    }
    public void unsetSignificantBits() { significantBits =
                                           null;
                                         significantBitsSet =
                                           false;
    }
    public boolean isSignificantBitsSet() {
        return significantBitsSet;
    }
    private int SRGBIntent;
    private boolean SRGBIntentSet = false;
    public void setSRGBIntent(int SRGBIntent) {
        this.
          SRGBIntent =
          SRGBIntent;
        SRGBIntentSet =
          true;
    }
    public int getSRGBIntent() { if (!SRGBIntentSet) {
                                     throw new java.lang.IllegalStateException(
                                       org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                         getString(
                                           "PNGEncodeParam19"));
                                 }
                                 return SRGBIntent;
    }
    public void unsetSRGBIntent() { SRGBIntentSet =
                                      false;
    }
    public boolean isSRGBIntentSet() { return SRGBIntentSet;
    }
    private java.lang.String[] text = null;
    private boolean textSet = false;
    public void setText(java.lang.String[] text) {
        this.
          text =
          text;
        textSet =
          true;
    }
    public java.lang.String[] getText() {
        if (!textSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam20"));
        }
        return text;
    }
    public void unsetText() { text = null;
                              textSet = false;
    }
    public boolean isTextSet() { return textSet;
    }
    private java.util.Date modificationTime;
    private boolean modificationTimeSet =
      false;
    public void setModificationTime(java.util.Date modificationTime) {
        this.
          modificationTime =
          modificationTime;
        modificationTimeSet =
          true;
    }
    public java.util.Date getModificationTime() {
        if (!modificationTimeSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam21"));
        }
        return modificationTime;
    }
    public void unsetModificationTime() {
        modificationTime =
          null;
        modificationTimeSet =
          false;
    }
    public boolean isModificationTimeSet() {
        return modificationTimeSet;
    }
    boolean transparencySet = false;
    public void unsetTransparency() { transparencySet =
                                        false;
    }
    public boolean isTransparencySet() { return transparencySet;
    }
    private java.lang.String[] zText = null;
    private boolean zTextSet = false;
    public void setCompressedText(java.lang.String[] text) {
        this.
          zText =
          text;
        zTextSet =
          true;
    }
    public java.lang.String[] getCompressedText() {
        if (!zTextSet) {
            throw new java.lang.IllegalStateException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGEncodeParam22"));
        }
        return zText;
    }
    public void unsetCompressedText() { zText =
                                          null;
                                        zTextSet =
                                          false;
    }
    public boolean isCompressedTextSet() {
        return zTextSet;
    }
    java.util.List chunkType = new java.util.ArrayList(
      );
    java.util.List chunkData = new java.util.ArrayList(
      );
    public synchronized void addPrivateChunk(java.lang.String type,
                                             byte[] data) {
        chunkType.
          add(
            type);
        chunkData.
          add(
            data.
              clone(
                ));
    }
    public synchronized int getNumPrivateChunks() {
        return chunkType.
          size(
            );
    }
    public synchronized java.lang.String getPrivateChunkType(int index) {
        return (java.lang.String)
                 chunkType.
                 get(
                   index);
    }
    public synchronized byte[] getPrivateChunkData(int index) {
        return (byte[])
                 chunkData.
                 get(
                   index);
    }
    public synchronized void removeUnsafeToCopyPrivateChunks() {
        java.util.List newChunkType =
          new java.util.ArrayList(
          );
        java.util.List newChunkData =
          new java.util.ArrayList(
          );
        int len =
          getNumPrivateChunks(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            java.lang.String type =
              getPrivateChunkType(
                i);
            char lastChar =
              type.
              charAt(
                3);
            if (lastChar >=
                  'a' &&
                  lastChar <=
                  'z') {
                newChunkType.
                  add(
                    type);
                newChunkData.
                  add(
                    getPrivateChunkData(
                      i));
            }
        }
        chunkType =
          newChunkType;
        chunkData =
          newChunkData;
    }
    public synchronized void removeAllPrivateChunks() {
        chunkType =
          new java.util.ArrayList(
            );
        chunkData =
          new java.util.ArrayList(
            );
    }
    private static final int abs(int x) {
        return x <
          0
          ? -x
          : x;
    }
    public static final int paethPredictor(int a,
                                           int b,
                                           int c) {
        int p =
          a +
          b -
          c;
        int pa =
          abs(
            p -
              a);
        int pb =
          abs(
            p -
              b);
        int pc =
          abs(
            p -
              c);
        if (pa <=
              pb &&
              pa <=
              pc) {
            return a;
        }
        else
            if (pb <=
                  pc) {
                return b;
            }
            else {
                return c;
            }
    }
    public int filterRow(byte[] currRow, byte[] prevRow,
                         byte[][] scratchRows,
                         int bytesPerRow,
                         int bytesPerPixel) {
        int[] badness =
          { 0,
        0,
        0,
        0,
        0 };
        int curr;
        int left;
        int up;
        int upleft;
        int diff;
        int pa;
        int pb;
        int pc;
        for (int i =
               bytesPerPixel;
             i <
               bytesPerRow +
               bytesPerPixel;
             i++) {
            curr =
              currRow[i] &
                255;
            left =
              currRow[i -
                        bytesPerPixel] &
                255;
            up =
              prevRow[i] &
                255;
            upleft =
              prevRow[i -
                        bytesPerPixel] &
                255;
            badness[0] +=
              curr;
            diff =
              curr -
                left;
            scratchRows[1][i] =
              (byte)
                diff;
            badness[1] +=
              diff >
                0
                ? diff
                : -diff;
            diff =
              curr -
                up;
            scratchRows[2][i] =
              (byte)
                diff;
            badness[2] +=
              diff >=
                0
                ? diff
                : -diff;
            diff =
              curr -
                (left +
                   up >>
                   1);
            scratchRows[3][i] =
              (byte)
                diff;
            badness[3] +=
              diff >=
                0
                ? diff
                : -diff;
            pa =
              up -
                upleft;
            pb =
              left -
                upleft;
            if (pa <
                  0) {
                if (pb <
                      0) {
                    if (pa >=
                          pb)
                        diff =
                          curr -
                            left;
                    else
                        diff =
                          curr -
                            up;
                }
                else {
                    pc =
                      pa +
                        pb;
                    pa =
                      -pa;
                    if (pa <=
                          pb)
                        if (pa <=
                              pc)
                            diff =
                              curr -
                                left;
                        else
                            diff =
                              curr -
                                upleft;
                    else
                        if (pb <=
                              -pc)
                            diff =
                              curr -
                                up;
                        else
                            diff =
                              curr -
                                upleft;
                }
            }
            else {
                if (pb <
                      0) {
                    pb =
                      -pb;
                    if (pa <=
                          pb) {
                        pc =
                          pb -
                            pa;
                        if (pa <=
                              pc)
                            diff =
                              curr -
                                left;
                        else
                            if (pb ==
                                  pc)
                                diff =
                                  curr -
                                    up;
                            else
                                diff =
                                  curr -
                                    upleft;
                    }
                    else {
                        pc =
                          pa -
                            pb;
                        if (pb <=
                              pc)
                            diff =
                              curr -
                                up;
                        else
                            diff =
                              curr -
                                upleft;
                    }
                }
                else {
                    if (pa <=
                          pb)
                        diff =
                          curr -
                            left;
                    else
                        diff =
                          curr -
                            up;
                }
            }
            scratchRows[4][i] =
              (byte)
                diff;
            badness[4] +=
              diff >=
                0
                ? diff
                : -diff;
        }
        int filterType =
          0;
        int minBadness =
          badness[0];
        for (int i =
               1;
             i <
               5;
             i++) {
            if (badness[i] <
                  minBadness) {
                minBadness =
                  badness[i];
                filterType =
                  i;
            }
        }
        if (filterType ==
              0) {
            java.lang.System.
              arraycopy(
                currRow,
                bytesPerPixel,
                scratchRows[0],
                bytesPerPixel,
                bytesPerRow);
        }
        return filterType;
    }
    public PNGEncodeParam() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1dC3xUxbmffUEgQEh4ylMgICBmFYuCoWgIAUJDiEnAa1DD" +
       "ye7J5ph9ec5sWFB83lalrVeRqrWV9v6kYBUf7ZWfWq2l2ov2qu1VbGltVWxt" +
       "fV3ro2p7tV7v982Z3XP27M4sJ3ia329nN2fmm/n+//nmm8eZc2bf2yRk6GSa" +
       "mqR1dEtaNeqakrRN0Q012hhXDKMTrnVHbg4of73g9dYlfjKki4zqU4y1EcVQ" +
       "V2pqPGp0kala0qBKMqIaraoaRYk2XTVUfUChWirZRcZpRnMiHdciGl2biqqY" +
       "YIOit5BqhVJd68lQtZlnQMnUFtAkzDQJNzij61vIiEgqvcVKPtGWvNEWgykT" +
       "VlkGJaNbLlQGlHCGavFwi2bQ+qxOTkyn4lti8RStU7O07sL4Ik7BmpZFRRTM" +
       "vK/qo0+u7xvNKBijJJMpyuAZ7aqRig+o0RZSZV1tiqsJ4yJyKQm0kEpbYkpq" +
       "W3KFhqHQMBSaQ2ulAu1HqslMojHF4NBcTkPSEVSIkhmFmaQVXUnwbNqYzpBD" +
       "BeXYmTCgPT6P1kRZBPEbJ4Z33nzB6B8GSFUXqdKSHahOBJSgUEgXEKomelTd" +
       "aIhG1WgXqU5CZXeouqbEta28pmsMLZZUaAaqP0cLXsykVZ2VaXEF9QjY9EyE" +
       "pvQ8vF5mUPy/UG9ciQHW8RZWE+FKvA4Ah2ugmN6rgN1xkWC/loxSMt0pkcdY" +
       "+yVIAKJDEyrtS+WLCiYVuEBqTBOJK8lYuANMLxmDpKEUGKBOySRhpsh1Won0" +
       "KzG1Gy3Ska7NjIJUwxgRKELJOGcylhPU0iRHLdnq5+3WpdddnFyd9BMf6BxV" +
       "I3HUvxKEpjmE2tVeVVehHZiCI+a33KSM//E1fkIg8ThHYjPNA5e8d9aCaQee" +
       "NNNMLpFmXc+FaoR2R3b3jHp2SuO8JQFUoyKdMjSs/ALkrJW18Zj6bBo8zPh8" +
       "jhhZl4s80H7w3MvvVN/yk+HNZEgkFc8kwI6qI6lEWour+io1qeoKVaPNZJia" +
       "jDay+GYyFH63aEnVvLqut9dQaTMJxtmlISn2P1DUC1kgRcPht5bsTeV+pxXa" +
       "x35n04SQ0fAhZ8FnHjH/2DclF4b7Ugk1rESUpJZMhdv0FOI3wuBxeoDbvnAP" +
       "WH1/2EhldDDBcEqPhRWwgz6VR2DLVDbTsJaA6g9HwBtFwmkwrbbWVU1J/LcN" +
       "m20d2lz6n1paFrGP2ezzQbVMcTqFOLSn1al4VNW7Izszy5veu6f7KdPgsJFw" +
       "1ig5HRSoMxWoYwowFwoK1DEF6pgCdaBAXaECxOdj5Y5FRUxTgIrsB5cAPnnE" +
       "vI7z12y6ZmYAbDC9OQi1gElnFvRNjZbfyDn77si9NSO3znjplMf9JNhCapQI" +
       "zShx7Goa9Bg4sUg/b+cjeqDXsjqP422dB/Z6eiqiRsF3iToRnktFakDV8Tol" +
       "Y2055Lo2bMRhccdSUn9y4JbNV2y47GQ/8Rf2F1hkCFwdijP+8t681uknSuVb" +
       "dfXrH91707aU5TEKOqBcv1kkiRhmOi3DSU93ZP7xyv7uH2+rZbQPA49OFWiB" +
       "4CynOcsocEj1OeeOWCoAcG9KTyhxjMpxPJz26anN1hVmstUYjDOtF03IoSDr" +
       "F77Ykb7tN79441TGZK4LqbL1/R0qrbe5LcyshjmoassiO3VVhXQv3tJ24zfe" +
       "vnojM0dIMatUgbUYNoK7gtoBBr/85EW/ffml3c/7LROm0G9nemD4k2VYxn4G" +
       "fz74/B9+0NXgBdPl1DRyv3d83vGlseQ5lm7gAuPgGNA4atcnwQy1Xk3piavY" +
       "fv5RNfuU/f9z3WizuuNwJWctC8pnYF0/bjm5/KkL/jaNZeOLYBds8WclM/36" +
       "GCvnBl1XtqAe2Suem/rNJ5TboIcAr2xoW1XmaAnjg7AKXMS4OJmFX3DEnY7B" +
       "bMNu44XNyDZU6o5c//y7Ize8++h7TNvCsZa93tcq6XrTisxagMIaCA8KHD/G" +
       "jk9jOCELOkxwOqrVitEHmX3hQOt5o+MHPoFiu6DYCDhlY50ObjNbYEo8dWjo" +
       "Cz99fPymZwPEv5IMj6eU6EqFNTgyDCxdNfrA42bTZ55l6rG5ItctZUkRQ0UX" +
       "sBaml67fpkSashrZ+uCE+5fu3fUSM8u0mcdkJo88TynwsGxYbzXyOw+d/qu9" +
       "N9y02RwYzBN7NofcxI/XxXuu/MPfi+qF+bQSgxaHfFd437cnNS57i8lbzgWl" +
       "a7PFHRc4aEt24Z2JD/0zh/ynnwztIqMjfBi9QYlnsF13wdDRyI2tYahdEF84" +
       "DDTHPPV55znF6dhsxTrdmtVhwm9Mjb9HOmxwIlbhQvgs4Da4wGmDrLs0LQpV" +
       "qmuGUW9M1Wv+8N3df7vi6sV+bGOhAVQdWBltpWvN4Gj9K/u+MbVy55GvsorP" +
       "Zb2GFT+HhfMwWMBMIYA/TwJ3ZbCBPwU4WlKJZ/PKMnubIFGWkurm1s6m1s7u" +
       "tqb2xqa2zvUNLYU9OPaSHZkeA3pbLQEeeIAPURe2bYpcU9v2qmllx5UQMNON" +
       "uyP89Q2HL3ya+fcK7M87c8zaemvo9239xmgM6rAxS6zXoU94W83L/d9+/W5T" +
       "H6epOhKr1+zc/lnddTtNv2tOQmYVzQPsMuZExKHdDFkpTGLla/due/iObVeb" +
       "WtUUDqmbYMZ4968/fbruliM/LzFiC2h8Iom+w5cfXY0tpNoEtOLaqkeurwms" +
       "hI69mVRkktpFGbU5WmjSQ41Mj417a3JjmTmHhv0bJb754HjMvhvDxRh8ybSt" +
       "pULHt6KwoZwMnzC3vXCJhoI/WhAY/uiVWTkGZ2PQXsK8RUVAj8LNu72ppaGz" +
       "eUMTXj7HASrmEtRC/sn9FoHy44/UoEGJirDabEdD5/p2gLWutRSs9CDqahEv" +
       "c5EEFlM9O2hYoiKsumpY3rGuZX1nybraMghQi3mJiyWg2PUrBg1KVASAgulU" +
       "98rmls6m9u7Wda0lQV3pEhSaeT0vsV4CirWq7YMGJSqCklE2UB3rl5fC9FWX" +
       "mOrgs4wXuEyCiTWqGweNSVQEJSNtmNa3lYK00yWkUwkfsua+ZQ3q24OGJCoC" +
       "BkY2SA0bmtobVpU0v9tc4joFPit4oSskuIL443uDxiUqgpLRNlxtDU2dq0uh" +
       "2nP0qEbh1clgW1PNpOZ3ASrCftxTGgzMGIel9RSFkacadSAZKcmWwoBIoyvU" +
       "tLm65URwr0sE86GIabyoaQIED5gIMPhBsaIiaUoqc4rCcJzJrcegztTwX2y/" +
       "z6NkaE8qFVeVpHPwgv/2OEcUDx49yBF49URQjzdif7GfMEE+LqymoWldG4BZ" +
       "uqOSKiWZgrfL4CIUVfW4EtGSMbz6iAPFz1yimMscmVngRQIUT1tVdbBYXZE0" +
       "JSMifXoqgRMCjW4pvFWUH5uzmb85dDyv8uBPjNv//ENziFpq5O9YnL5jb0Xk" +
       "d4mDbOSPRW7IKzcJdZkOnxN402XflJxzjEulIJbAdYyU3gC/2KQ0twrrVdY4" +
       "vJ8tnnzY+Nu1Z9YvLts16xW2rlChGTDBhNlMiRsDNpl397381nMjp97D1uGC" +
       "OClCCkc676gU3zApuA/C2K/C4PlsuTYJE92UUjSdMFtk0SSDGayZL7fFI6Vb" +
       "lD/vxduZMnUwF42ryZjpzzZi8Nu0lb/fFGL/T6R8JYrNfRvjqaSKi1q5OHO5" +
       "WUvV5W9YQWSxpjqZWrAUspbRY60rvDhqxx8fqo0td7POjNemlVlJxv+nQx3P" +
       "F5uIU5UnrnxzUueyvk0uloynOyzImeX31+77+ao5kR1+dk/MXPAoupdWKFRf" +
       "OCccrqs0oycLZ4GzzKpntSfwpKzezSpncaXXBd+XxH2AwV/AMCNY9aalSJL/" +
       "regqs8vladuCm6ybecalg14AdqpzF6sLHPQ/pA5aJA1TAruDhv60VIfyqUt9" +
       "YWDmf5SX+GhpfX0Bqb4iaaiimJJIKPjPC4Va+oIutZwN+f+El/MTgZbDpVqK" +
       "pGEoxbQsTaev0qWiOJR6kxf1pkDRaqmiImkYvaaVuEqpulozaCqWa+/PFo7l" +
       "qol5i5PkvinZ+DndcIypqUS4TaF9LcxT53pSL7M32T+MrE1gLfMcYZ/jy/M7" +
       "5Sj7HAz+mOtvfJOK+xv8908YvFa6q3szr5dvEv7/jtgP+WZJ4mZjMANjPjQ1" +
       "kaQ94dj8ma/GpUGfDDy8xU3yLYFBL5AatEga+nGnQQsa4UkudZ4H08TjzKTm" +
       "dwmdT5XpLJSGMX1zYyOYOG44WKFQxdEEp2D644H7R8wMzG9KIsfYRnp0LRpT" +
       "w8thtNER0bU0helEU3JA01PJBI5jeFP8ZxRja5JLyo4egz1bqOpy8AjZ8jpq" +
       "HFRDXjrIhryEta+l5RryGklcCwar8w15qawhtx5jQ/6Cy0ZRB+Y8iZv1JEGj" +
       "6JA2CpE0risXNApBM+50P2MPrOJlrhJo3CXVWCQNGqf7thhaRImv0MCyDXN/" +
       "gG+8Q+ONLjU+BcpazctcLdBYkWoskoaJTZHGApp7XCp9JhR3LS/2WoHSfVKl" +
       "RdIwZDEysZhqUDXaZrp6h79kCtTKFLC8TTKbm+M1uNmS1OHQACZ7+hax80nm" +
       "IBuDcj6pQTqfJPMJqXLOZ6sk7hIMsnnnk5I5n0uP0flo7kcRge28ircLbOwq" +
       "qY2JpGEU4bQxQbv410GMIh7mpT4s0Hm7VGeRNMzkcPus1gvNOUmXa2x5pcj5" +
       "uLgRwvQNQ0l82GF+l9D3Bqm+Imlqbve16SugeIdLlSdDYe/wQt8RqHyLVGWR" +
       "NCXDO9pXLcfV1yRT1bFG7vum+4ld4F1e2LsCVb8jVVUkTclIS1UBsd91qe0M" +
       "KJevyQcFK/q+PTJthdIwpsNN4qYf587ucDrvmm3bUsyN1aU9bTqnxH2D8rL7" +
       "BuFl2ZYE375yHvYBSdxDGOzPe9h9Mg/78DF62L0uaxw60eB0XmfTBTV+QFrj" +
       "ImlKhmKNCyzzpy71nAkltPKSWgV6PiHVUyQNxmfucYyw5dFOGCblrHKUtWkO" +
       "xqeqA8KT7juz4DquxDoBhP+WQhBJQ2fmhCCg/dmj1zmYM49LeamXCnQ+XLot" +
       "Esc9r6AkK+jZqK4kjbSC930Ea5S+3wzCZq7nJV4vUP5lKeEiaUpCWzvBuDGH" +
       "uxxaHnG/Rhm8gZdzg0DLP0u1FElTUsG0FND5mktbQEUf40U9JlD07byivheK" +
       "q18kTcmwSF8m2c+2cxfcYrHuCSqb2YMu3ZHzThg9vnbJX2fyjXcl0tqeiLnu" +
       "4R91dZ0wOpK7d/hcXim26lkDn++bSpnflJz3edzgo1oC+rAwNsQoPullW2vx" +
       "NH+2H7ngBpXF21398YZ3Fu/5osnbDMGNJCv9Q2cfefa2rffuM3cK4g0rSk4U" +
       "PZtW/EAcPiEguaFpq6MPV51x4I0/bjg/V0ej0Ho+zA8NRtn3V7MN675Pj6or" +
       "/Msg7PtxbqGPl7Zvv19q3yLpnH3jIgeKflCoqT8g0VSw8c0c6UALV8DgdSVC" +
       "LW/L/qqIeNc6SznZNsgBls84qrkxq4VmvGB7YgeNbqrooTS2K3X3lTt3Rdd9" +
       "75RcDZ8PhNBU+qS4OqDGbdo0mEOuPJIZqPhp8DmXIznXWS0WkZKx4NmOnqha" +
       "kqNjaOYrZGkKs0WLlXY1GVV1NcooQWX8k8RjO/80DMZSMi6m0hVqr5KJUxuN" +
       "uTIG++CUZU7jyhm+XTHReNNRFcywFgKrs8w8zW+3VeGvdFTFGEmOpasC/z2H" +
       "0blAQjUO/P1zKKkEr7Wc7yRiCZ0LzQMpLWoxd4IHzGFLxJ0q/pM4zpMkzGHw" +
       "biFFwyWiEgaWSuKWYXA6sBOz2GG8Wkws9oCJSoyDaYL/DA7nDPdMiEQlaJsl" +
       "cV/CYAVMpTNJo4AL/8kWF01ecQGuzd/IATW650IkKm44jzDQGySEYPvwnw29" +
       "Lj4wW7AHzc5IuweMjME48Pj+NRzWGveMiEQlgCOSOJzx+S8AMmJOMsgjFhnd" +
       "XpkHkqFwRIp7MkSiEsCSlQk/Pljl74eZmtlUlEh/TE9lklGHacS9Mg2Yzfn7" +
       "OaR+92yIRCWIt0niLsMgC2xohkVFbqJlsVH28YHB2sYigHIZh3SZezZEomLX" +
       "cYjB3i6h5GsYfBkXqVXaaNtx5DCQr3hFyRLA83WOq+hmQXlKtgtEHYgrmCIV" +
       "+O8LRxEwZm6WsPZNDHaUZe1GL5vVHg59j3vWRKISxLslcXsw+A6wEStigxyy" +
       "2Ci7rj1YG4IxqP8+Duk+92yIRCWIfyCJ+w8M9lFSzVyuxDru9so6agHMgxzU" +
       "g+75EIlKMD8qiTuAwUPAh2Y0ltjSaPHxI6/sAzcUHuSgDrrnQyQqdrumA3lK" +
       "QsozGBykpAJMZBXfOGm3jSc84AJn0OQ4AHKIAzrknguRqATqbyRx6G79h3Bb" +
       "pkUDecGi4XmvTGIKYHiRY3nRPQ0iUQnUP0niXsPgCCXDmcsoZQ+veOUrpgKK" +
       "VzmaV90TIRKVgJXs9/bjGpv/bYpP8q+yb9S1iCi7PjhYi6gHFB9wNB+4J0Ik" +
       "KnQSvvEM8WdiNgKYzP8xbnpQaZtj96TDPj7xyl9AXxLwmXma365oEYpKUI+Q" +
       "xOEqc2AoMBIryYhvfJ6RQIVXhnICwKnksCrdMyISlaA+ThI3GQNcnmSuQ24l" +
       "AS/WGJkXmQuAxnBgY9xzIhKV4J4jiZuLwQyKbyh0ElLkUAIzvbKTxQBoJgc2" +
       "0z0nIlGxQ1nMwJ8qIWYRBnUwFMN1ooJdnA5DCXtACt62w6F6gL+HIVD0qofy" +
       "pIhEJZjPksThM+mBeuAjVoIP32KLj6UeDk0DSzioJe75EIlKMK+VxK3DYDW4" +
       "V+ZMpBbS7JUrmQNw+MPqgaLn4cszIhKVoO6SxJ2HwXpgRDNKb3u2GNnglY18" +
       "EeB0cFgd7hkRiZYZmQRiElo0DHooGYt9TonN1XZLiXjFy+kA6nwObqN7XjYK" +
       "RB2wA0wR9iaCc6yAsUAlDA1gkDo6hsq+g2Wwg7fZTHETZtED5OUZEolKYF8h" +
       "ibsKg0uAklhpSuyjt21eGQ2OVC7muC52T4lIVAL7Oknc9RhcS8l4c/RWxk62" +
       "e+VzcffzVRzZVe5JEYlKgH9LEncbBjcBKTB8Ez0GYZFys1eWsgoQ3ciR3eie" +
       "FJGo2O0mGPo7JMzcicHt5oTQ+aiDw1Z2e0DLHIyDoUbgdo7tdve0iEQlqPdL" +
       "4h7A4D5zQliCEZ+1wSLwAy8nhHdzWHe7Z0QkKkH9mCTuZxj8ODchLGMlj3o5" +
       "IdzPge13z4lIVIL7l5K4ZzH4LzYhdBJS7FCe8vBWV+BJDuxJ95yIRMuN434v" +
       "IeYlDA7jIx9gKkVPqdgtpew23sGOUXBGeJhDO+yeFZGoBPQbkri3MHgVCImV" +
       "IsQ+QvmTV2aCE6BXOKpX3BMiEpWA/kgS93cM3oNBm+lOpDbyvlfeBD3sGxzX" +
       "G+4pEYmKYQcDkrgQYv0/oAS8SeknpSxKPvPKSk4CPB9zXB+7p0QkKnQm5pQn" +
       "OFrCSw0GlZSMREOxP49ls5HgCK82600BdEPNPM1vV4QIRSV4p0ripmMwEbiI" +
       "ObiwbdcLHufhHqRgNQdU7Z4LkagE73xJ3AIMZuf2IAktY46HmyWCEzmkie7Z" +
       "EIlKEJ8uiVuCwUK2B6n4SUCLjVM97F6Cczmkue7ZEImKRyF3MdgrJJSsxOBM" +
       "SoaCefAHdOyGcZZXO6MnA47TOJ7T3FMhEpUgPVsS14FBC7AQy7Pgu8tiYa1X" +
       "BoEs8DzNb3csiEQlSC+QxG3C4FxKhjFnUcIaurxyE9iB8DcyBIve51CeB5Go" +
       "BGu/JA5v3QV7gQfNsD8NZvFQ9n3Ug7WHMwAEf9AiKHt0Q8CDSFTsIJ5mgLMS" +
       "MrZiYJjrHmsdz0w6zIN6QAsTh3lKsJdj63VPi0hUgvrLkrirMbjcXPcowYjv" +
       "aYuRKzxc9wimOaz8IQRHz4hIVIJ6hyRuJwZfz617lLGS6zxc9whmObCse05E" +
       "ohLc35HE/TsGt7J1DychxQ7lWx5uzwzyJeKg+9VloagE9z5J3D0Y7M1tz+y0" +
       "PcDssJE7PNyeGeT7loPutzwLRSWYH5LEPYzB/Wx7ZmeJp7ktPvZ7ZR/4iP2t" +
       "HNSt7vkQiZYbkR6UkPIkBj81N0rg4U26ahhqtMRo5DGvxqb4XOudHNmd7kkR" +
       "iUowH5LE/QqDX5gbJYr4sI9Sf+nhRong/RzU/e75EIlKMB+RxP0Bg9/lNkpI" +
       "LeT3Hm6UCPKX+ASLXgFUnhGRqAT125K4");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("dzB4nW2UKKSj2JG84QEjbHK+EuA8w2E9I2GEhSUeyx5hbEniW3eT2taiN/RP" +
       "kOTtoMXxAuuit+RclNurFfyHmNAQFhD8kJIqJRptM99H34iPozvM6yMPyGQv" +
       "tgwD0F9zwL92TSaq9r8lKBTlKCFCsh80hPtBQ0PMYXBrJmHniaW3FttCQz0g" +
       "ir09ZyHAeZnDevlzI0qUo7BXMxdoQ5JH2UNTMBjLd8/aqOIv9g5+arHlxU7R" +
       "PFt8PT4oW8p3x5Yox3JszZWwNR+DmcVsFW8PDM3yyqMtA0zvc2zvf25siXKU" +
       "kHGaJI5RcDIl03U1kRpQ1ycNpVftTOHB3c4GafNcoVO8Im0RISG+nB+S3Qlw" +
       "RZowRwkxkjXPEK55hpZRMt4krSEel3F1pgdcsXNmjgdEVRxZlQuu2H64JzAo" +
       "eTLPREm25dpku4S1TgxaKAkoPU7/7sX6KOsI5wMGfg8gJLt9UJIi6eFFwmwd" +
       "DIi3IIY2ScjqwaCLklFpRaV9bboa1fBwUgdvZV97OwjeqnI2sIkD3CThDYPi" +
       "8alQ1AE4xBTBW7K+xRflvbL10lk2eQB9fPxtHOb3sb/IPjZAw73x1OYwjnHx" +
       "0PLluqr0G5/Xe/Jl2Zu1gK/JDaWQSN/SdDotedGgzVwSEnPJYNBHybBeLU5V" +
       "vT212WEpZd8DezSWkjXPhbO9AgcPup3oPCNTifQrMbU7cs+uqooJu9YfNs/A" +
       "wcNLMJsRLaSiNxOP249itf0eAtOPXo1hH8HCavY+yNA2SuYe7Xt6wMekzRda" +
       "hi4xpS+npPZopPG0Evy2y15FyTS5LEixb7vUVyiZKJJCH7iZ2lNfS8nYUqkh" +
       "JX+HZy7l12BS4kwJ5bNve7p/o2S4lY6SIeYPe5IdkDskwZ83pkvMeMyTdrPm" +
       "u5gm220DTYqUHWbmRezndCMFaXbuPX+HXKaNv/7s3l1rWi9+77TvmeeER+LK" +
       "Vrx1QCpbyFDzNHKWaaDoVWr23HJ5DVk975NR9w2bnXv/VcE55XbdmGFDi2Nn" +
       "ek9yHJxt1ObPz/7t7qWPPnPNkOf8xLeR+BQYWW4sPpM4m87oZOrGluLzWzco" +
       "OjvRu37erVuWLeh953e5w399hWc9O9N3R57fe/6hHRN3T/OTymYws2RUzbLD" +
       "kldsSbarkQG9i4zUjKYsqAi5aEq84HDYUdjoFJy3Ml44nSPzV/EAeUpmFp+L" +
       "6zhXvr4FT8jerOrL+ftH8CSrSuuKWTOOg4cy6bRDwLrCqxJD9thwXdb07IHu" +
       "lrXpdO709WHZNPM8PUL/GNrDfuKvvf8P2kF+bziHAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vJnZd3bk9bKEuGb2r9xl9uQNZl89e+95+Ye2gvqhU9SCvqXe87hanKK3wyfR" +
       "e/7iFuAvngJwcksDh2ztkD4HtmWHdX0ztj1u9tMzggPyuLztbjffJ4D7zlsB" +
       "d/8xcKc03hNnxPdcgOurW3xfPQWfciv47mQZop7NJW1u2Rybl7s0P/s44vLX" +
       "tri+dgquUybnr8d11yGuU5rsDBPya2gvAION7ZTh/ilThpeCW4G2n61qO+Yb" +
       "n5GdMOtdL22usPkOc0/cuErgFQ97kRDoXuSEymOb1QYPb24sPry+rfjwZgXZ" +
       "a177MDlo4k9QNRJnH37lw7ay2ua8XrDEN7zm6tWrr338pa57zekeucW5KXe6" +
       "D00O+H73k/Kh8ZP0ocnatcU386E/sCPvzVnyfdd8aLzLh/7gDT40PKPKgM5u" +
       "/6Gtyjx0isqcMlV/vcrclqnMKXp8hnn5NagXHh88nwDqbbfU328WlEjrGbER" +
       "iEoONOnuw4UTINBTjuF9+9k7ov3BFu/gFLy7puoPO6LjeE9p0DPMze8fSPm7" +
       "twC/+xSA7z4ZYO5aHxT6gh24Qra66pTJq0vveRKCfusW11tPwfXeW2m4K+kI" +
       "qN812zsC6X8+++TV/j/fQvrnp0D6N7cC6fY1pFMa6t+eUYAZql/ZovqVU1B9" +
       "9CYCvEPSIttYL3U7ujzi+hlmRlitV9U+IX1s+Mef+cn0g+/brH7I7j2Eufxp" +
       "C7RvXCOerezbcWPkyNLdvyJe8Ykv/en4tXtbqE+9nvrtu6ifYM/9zUKzS79y" +
       "rMk/9iSa/Fe31/3VU5r8k7fU5AcTHpc+fiOzU69wQOEGHp+6KY/1xeNLl4BZ" +
       "wFfRq4Ws1n86Gelpt1ufvTClRw869rHiZ4O5Rxcmmp3q9dcDOpjOuAVAQO/u" +
       "PuzC+46tPv7DX3jrb/6zRz4HlKx7sJQpK90A1jR+04u+mt1yufR7Z8P+nAw7" +
       "u56r6QtBSK5dqiJn8NenOD4HYzqb+4tPilL4cK6NBJ3awV+/KDdKMReL1nzO" +
       "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" +
       "VvKJiJ8W7UT0BVLVhnrJ6urJRIVpzq+r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "BRnwCvjMtkxmJyxu3DbkjoX5xEYex5a/X7q+AZ63Xk94SJhRbFnxFXnNdr2I" +
       "8h9OXz+/l2nApW+EuWeqSthU5kJkhkda6NjCy2/erDs+evZjTbJ+eAIG7B7Z" +
       "1N18n7VJLn19V5Nk/5JrWnftoHxPltwe5p4aKNnTOuuNYU5cFrl0dPka+b2b" +
       "PpK5g3ym1NmTI3vfuiX/rWcgv6b12Im8j9La8TDqXvYw6t6zAWX1kPK6sQ7p" +
       "PXAOek/NDj4EaL1iS+8VF0/vsR15L8uSR8LcXZEdXEdw775Dgjd9ZvVmBIE9" +
       "7zW2BBsXQ/CI3v70mgmyg2UlS6Awd3e2nfF1GwMdpVk4B82nZweB79rrbml2" +
       "L16Or96Rl21ytvc4YKgeZ5j76UOG33ZeQWYMhS1D4eIZ9nfkZbv67RFh7p6N" +
       "pgqSofpOZMvHhNg+rxBfCKgZW4rGxVOc7sjjs4QFFPXgkN/BQyCHFEfnlWIZ" +
       "UHvjluIbL9wcP7LmIu/gOc+SJ7InU5WwcWRXm2OifN15eVYBv3+65XnDM75P" +
       "juft6wK3Z/9+7BaSNd0dD+HtZfvS7hk3bQrzIrT6Z7dN8bMXr9XftSPvu7Nk" +
       "BSiqN1DMfeSQYnxeaYOoaO9DW4ofuniKb9mR90NZ8n1h7r61b9ohx+8/rxwf" +
       "BeQ+uiX50Ysn+fYdeT+eJf8MkNSDxglbUR2SfOt5JZntAfXJLclPXgzJI/5p" +
       "Y5Q/tYPp/5gl/woMtIAwie3GVkel+M5zEFyP1r4FEPudLcHfuXgpvm9H3gey" +
       "5Oey7bEOueU+dsjt588rvOcBTn+45faHF8/tozvy/tcs+YUwd+faDE+S3IfP" +
       "a3/PB6y+sGX3hYtn92s78j6ZJb8cZpuQE0e3Njtk94nzyu5xwOovt+z+8sIN" +
       "78/XNP7zDoq/nSW/ke2poYT0sU2pjknyN89rg9lOLdvdCDbfFyvJP9iR90dZ" +
       "8llAUz2RZu7PD2n+/nlF+hJA76lbmk+9eJpf3JH35Sz50zD3zLU53kSeXziv" +
       "ZT4GCD59S/TpF0/0L3fk/XWWfBUQ1YPj");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "v+3n3vVH2bnc/x9iLtLLgZcAAA==");
}
