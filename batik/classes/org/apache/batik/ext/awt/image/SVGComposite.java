package org.apache.batik.ext.awt.image;
public class SVGComposite implements java.awt.Composite {
    public static final org.apache.batik.ext.awt.image.SVGComposite OVER =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        OVER);
    public static final org.apache.batik.ext.awt.image.SVGComposite IN = new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        IN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      OUT =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        OUT);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      ATOP =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        ATOP);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      XOR =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        XOR);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      MULTIPLY =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        MULTIPLY);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      SCREEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        SCREEN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      DARKEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        DARKEN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      LIGHTEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        LIGHTEN);
    org.apache.batik.ext.awt.image.CompositeRule rule;
    public org.apache.batik.ext.awt.image.CompositeRule getRule() {
        return rule;
    }
    public SVGComposite(org.apache.batik.ext.awt.image.CompositeRule rule) {
        super(
          );
        this.
          rule =
          rule;
    }
    public boolean equals(java.lang.Object o) { if (o instanceof org.apache.batik.ext.awt.image.SVGComposite) {
                                                    org.apache.batik.ext.awt.image.SVGComposite svgc =
                                                      (org.apache.batik.ext.awt.image.SVGComposite)
                                                        o;
                                                    return svgc.
                                                      getRule(
                                                        ) ==
                                                      getRule(
                                                        );
                                                }
                                                else
                                                    if (o instanceof java.awt.AlphaComposite) {
                                                        java.awt.AlphaComposite ac =
                                                          (java.awt.AlphaComposite)
                                                            o;
                                                        switch (getRule(
                                                                  ).
                                                                  getRule(
                                                                    )) {
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_OVER:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcOver;
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_IN:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcIn;
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_OUT:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcOut;
                                                            default:
                                                                return false;
                                                        }
                                                    }
                                                return false;
    }
    public boolean is_INT_PACK(java.awt.image.ColorModel cm) {
        if (!(cm instanceof java.awt.image.PackedColorModel))
            return false;
        java.awt.image.PackedColorModel pcm =
          (java.awt.image.PackedColorModel)
            cm;
        int[] masks =
          pcm.
          getMasks(
            );
        if (masks.
              length !=
              4)
            return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks[3] !=
              -16777216)
            return false;
        return true;
    }
    public java.awt.CompositeContext createContext(java.awt.image.ColorModel srcCM,
                                                   java.awt.image.ColorModel dstCM,
                                                   java.awt.RenderingHints hints) {
        if (false) {
            java.awt.color.ColorSpace srcCS =
              srcCM.
              getColorSpace(
                );
            java.awt.color.ColorSpace dstCS =
              dstCM.
              getColorSpace(
                );
            java.lang.System.
              out.
              println(
                "srcCS: " +
                srcCS);
            java.lang.System.
              out.
              println(
                "dstCS: " +
                dstCS);
            java.lang.System.
              out.
              println(
                "lRGB: " +
                java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB));
            java.lang.System.
              out.
              println(
                "sRGB: " +
                java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB));
        }
        boolean use_int_pack =
          is_INT_PACK(
            srcCM) &&
          is_INT_PACK(
            dstCM);
        switch (rule.
                  getRule(
                    )) {
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_OVER:
                if (!dstCM.
                      hasAlpha(
                        )) {
                    if (use_int_pack)
                        return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK_NA(
                          srcCM,
                          dstCM);
                    else
                        return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_NA(
                          srcCM,
                          dstCM);
                }
                if (!use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext(
                      srcCM,
                      dstCM);
                if (srcCM.
                      isAlphaPremultiplied(
                        ))
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK_UNPRE(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_IN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.InCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.InCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_OUT:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.OutCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.OutCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_ATOP:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.AtopCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.AtopCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_XOR:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.XorCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.XorCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_ARITHMETIC:
                float[] coeff =
                  rule.
                  getCoefficients(
                    );
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.ArithCompositeContext_INT_PACK_LUT(
                      srcCM,
                      dstCM,
                      coeff[0],
                      coeff[1],
                      coeff[2],
                      coeff[3]);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.ArithCompositeContext(
                      srcCM,
                      dstCM,
                      coeff[0],
                      coeff[1],
                      coeff[2],
                      coeff[3]);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_MULTIPLY:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.MultiplyCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.MultiplyCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_SCREEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.ScreenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.ScreenCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_DARKEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.DarkenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.DarkenCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_LIGHTEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.LightenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.LightenCompositeContext(
                      srcCM,
                      dstCM);
            default:
                throw new java.lang.UnsupportedOperationException(
                  "Unknown composite rule requested.");
        }
    }
    public abstract static class AlphaPreCompositeContext implements java.awt.CompositeContext {
        java.awt.image.ColorModel srcCM;
        java.awt.image.ColorModel dstCM;
        AlphaPreCompositeContext(java.awt.image.ColorModel srcCM,
                                 java.awt.image.ColorModel dstCM) {
            super(
              );
            this.
              srcCM =
              srcCM;
            this.
              dstCM =
              dstCM;
        }
        public void dispose() { srcCM = null;
                                dstCM = null;
        }
        protected abstract void precompose(java.awt.image.Raster src,
                                           java.awt.image.Raster dstIn,
                                           java.awt.image.WritableRaster dstOut);
        public void compose(java.awt.image.Raster src,
                            java.awt.image.Raster dstIn,
                            java.awt.image.WritableRaster dstOut) {
            java.awt.image.ColorModel srcPreCM =
              srcCM;
            if (!srcCM.
                  isAlphaPremultiplied(
                    ))
                srcPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        src,
                      srcCM,
                      true);
            java.awt.image.ColorModel dstPreCM =
              dstCM;
            if (!dstCM.
                  isAlphaPremultiplied(
                    ))
                dstPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        dstIn,
                      dstCM,
                      true);
            precompose(
              src,
              dstIn,
              dstOut);
            if (!srcCM.
                  isAlphaPremultiplied(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    (java.awt.image.WritableRaster)
                      src,
                    srcPreCM,
                    false);
            if (!dstCM.
                  isAlphaPremultiplied(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    dstOut,
                    dstPreCM,
                    false);
                if (dstIn !=
                      dstOut)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        (java.awt.image.WritableRaster)
                          dstIn,
                        dstPreCM,
                        false);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xv8PJe2sqE4lAAA=");
    }
    public abstract static class AlphaPreCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        AlphaPreCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                          java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        protected abstract void precompose_INT_PACK(final int width,
                                                    final int height,
                                                    final int[] srcPixels,
                                                    final int srcAdjust,
                                                    int srcSp,
                                                    final int[] dstInPixels,
                                                    final int dstInAdjust,
                                                    int dstInSp,
                                                    final int[] dstOutPixels,
                                                    final int dstOutAdjust,
                                                    int dstOutSp);
        protected void precompose(java.awt.image.Raster src,
                                  java.awt.image.Raster dstIn,
                                  java.awt.image.WritableRaster dstOut) {
            int x0 =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int h =
              dstOut.
              getHeight(
                );
            java.awt.image.SinglePixelPackedSampleModel srcSPPSM;
            srcSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                src.
                getSampleModel(
                  );
            final int srcScanStride =
              srcSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt srcDB =
              (java.awt.image.DataBufferInt)
                src.
                getDataBuffer(
                  );
            final int[] srcPixels =
              srcDB.
              getBankData(
                )[0];
            final int srcBase =
              srcDB.
              getOffset(
                ) +
              srcSPPSM.
              getOffset(
                x0 -
                  src.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  src.
                  getSampleModelTranslateY(
                    ));
            java.awt.image.SinglePixelPackedSampleModel dstInSPPSM;
            dstInSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                dstIn.
                getSampleModel(
                  );
            final int dstInScanStride =
              dstInSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt dstInDB =
              (java.awt.image.DataBufferInt)
                dstIn.
                getDataBuffer(
                  );
            final int[] dstInPixels =
              dstInDB.
              getBankData(
                )[0];
            final int dstInBase =
              dstInDB.
              getOffset(
                ) +
              dstInSPPSM.
              getOffset(
                x0 -
                  dstIn.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  dstIn.
                  getSampleModelTranslateY(
                    ));
            java.awt.image.SinglePixelPackedSampleModel dstOutSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                dstOut.
                getSampleModel(
                  );
            final int dstOutScanStride =
              dstOutSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt dstOutDB =
              (java.awt.image.DataBufferInt)
                dstOut.
                getDataBuffer(
                  );
            final int[] dstOutPixels =
              dstOutDB.
              getBankData(
                )[0];
            final int dstOutBase =
              dstOutDB.
              getOffset(
                ) +
              dstOutSPPSM.
              getOffset(
                x0 -
                  dstOut.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  dstOut.
                  getSampleModelTranslateY(
                    ));
            final int srcAdjust =
              srcScanStride -
              w;
            final int dstInAdjust =
              dstInScanStride -
              w;
            final int dstOutAdjust =
              dstOutScanStride -
              w;
            precompose_INT_PACK(
              w,
              h,
              srcPixels,
              srcAdjust,
              srcBase,
              dstInPixels,
              dstInAdjust,
              dstInBase,
              dstOutPixels,
              dstOutAdjust,
              dstOutBase);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "c1UVHiMtNcioBBPhXr4crVl4jOV7hgm5zFtYljfOUHuWFu40weI9SqSTiWH4" +
           "4mCv4ClmA7CYhmS3UyyHlIWiG33Y9BFmi0/mO8xszwpisUd3bp81ctcwmc5k" +
           "gSXZjgxFYoMTvLoidcMn8fka7BlUaqe17UauC0IY2Hbf3uAisgrIUGrNYzls" +
           "kTo12zSVwBzLw4EkDohlZKFie5SpKwoBWR2FCuOU9kjMsKL91FoVY8F0DL45" +
           "miwXuJztB7OG21tbRTgjeL1A6FnWYlS9kY9cPG+27RpwzHQ+2Xi7HYY3vKSx" +
           "XLKt7cRQBw464xfLToubqLUOtsyJhRFvEHIBz1KqU28QehQEe349Y+hwgm+b" +
           "Nb6TDu2dS/AYMmHHNS4YYqN83cpEhE6JFmDSM8fj8TLY6Wx/VuPnbrHsT9B+" +
           "B6/VHI3AOy11TKbN0XTbHGyJoWDu8Q3vJw5pZ1h/LDZywd2P+v5E0kh7Utt3" +
           "8t58ZAlwU907LbkHMx1qaVrNxN2o7YUC19o9fFunkMSJVkrgDBsGmu6scOis" +
           "bFNx2WZdziR14HKNtkBjkhwu5mGUbTNmBXPRbrRD8RWv9IE/IjKe2JmYDusu" +
           "YAmypc1+YK+UwhDJkSqlNIfSC5ohmoo7zdNB0rcMI+ELb7VdgTRFSIotVh8O" +
           "aZJeNpD9FkRno6bHYQfHGojetlkeI0y+TvaSyTKs53671Z0osyUxsIW2KPap" +
           "7qAxZ4VJzHA80997cKT2UEbIJJT1+w6cTsf2Fku4FYa5S1lZj6L6et0VUWE5" +
           "MJqtEJX2ZIdxu71o0tQdeURhjVpKin1rI03ZDZgBdWSp3QXbM0OtHJSXUHjl" +
           "87Mpva+nOOHh9L6zYRTw7/j7y7/Nd9/ZycXT1SHNWaXOtNvlg/E7+MeePWzC" +
           "GLopb6I4lJXq5HZwfkpcnfw9f7X+c/GU+PxMECrPKV54UImuOqP44iffeFOd" +
           "fql+dHKWKsXQjZPK6TmfI8Dmww8+jGGq8uT5Ad+vffI/P8//gP7xd1DU+MAV" +
           "Ia+y/DvMW78x+F7lrx1Bj5wd991TOL086LXLh3xPhFqchC5/6ajvhTOzVmU1" +
           "Bpjz9olZn7x/YeG+PjuKocf90Is1JdbUsls/hMmVM+t3VcTvqu6FC+GxjqFH" +
           "DLdyNPgrAn3owZauDtYPp1hv/uwrv/2JN1/5d9Wh800DJFohEe7uU5K9MOab" +
           "b33t67/77he+XJVtHt3I0cEUV2vZ95aqL1WgK92ePLNcZahbIDDZg+UOvzGk" +
           "/AnLhbLvR3CU7jaht4+0EGY9VZsZiqWFM9nV7NOq5P+PabKDa079eO2k3Hd2" +
           "5PaJ7BpURcmPPiA+zkDkDD9u2Jq7O9R187L5IT8743+lPPLs+elrz/ZcrazR" +
           "nD47lCYN7/js1QbwMLuvpN5B0mqy+4t5rRLzvqF7sdzyVx/y7CfL5i/H0HWl" +
           "lPSg2EPIP59BZxY4mOGBtxV99hBeXyibEJjLDzWlKulqZ5Xc+y25R1PPUM+h" +
           "OvpOh6sX5zsY9GwJPFN2EsCAz56AxzPvADwqq6f3tfojJ5WdE2e/50qdbCFH" +
           "8aHm8rOnJC9cIVmGRlyGxIG0muRLD7Hh3y2bvxVDT5zbsOz5m+dm+pl3YqYs" +
           "hl7+jlX2U9Fr76B2D1DyuXveDzq806J8+c1bN9/3pvAvDyB3+t7J4zR0c5vY" +
           "9sWyz4XrG0DhrVHZ4PFDEcivfn4phl58uFwg1qvfSo2/fxj1KzH03INGAawH" +
           "7UXqfwiW8f2oASVoL1J+NYZuX6UE81e/F+neBh48pwNgc7i4SPKrgDsgKS//" +
           "qX/qAvL/xusT2bXLGchZ6DzznULnQtLyyqU9sHpj7DQzSA7vjN1VvvLmmP3B" +
           "b7W+dCjmK7ZcFCWXm2C7OrxXcJZdvPxAbqe8bgxf/fZTv/j4h07ToKcOAp8v" +
           "2wuyfeD+JXTK8eOq6F38g/f90vf93Ju/XxXH/g9AtKGuyicAAA==");
    }
    public static class OverCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OverCompositeContext(java.awt.image.ColorModel srcCM,
                             java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class OverCompositeContext_NA extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OverCompositeContext_NA(java.awt.image.ColorModel srcCM,
                                java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int srcSP =
                  0;
                int dstSP =
                  0;
                int end =
                  w *
                  4;
                while (srcSP <
                         end) {
                    final int dstM =
                      (255 -
                         srcPix[srcSP +
                                  3]) *
                      norm;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    ++srcSP;
                    ++dstSP;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    ++srcSP;
                    ++dstSP;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    srcSP +=
                      2;
                    ++dstSP;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class OverCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                      java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int dstInP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstInP =
                      dstInPixels[dstInSp++];
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         -16777216) +
                        ((dstInP >>>
                            24) *
                           dstM +
                           pt5 &
                           -16777216) |
                        (srcP &
                           16711680) +
                        (((dstInP >>
                             16 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           8) |
                        (srcP &
                           65280) +
                        (((dstInP >>
                             8 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           16) |
                        (srcP &
                           255) +
                        ((dstInP &
                            255) *
                           dstM +
                           pt5 >>>
                           24);
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dqfGwk+ycIB9hT3S4Sf/BWInzOEnGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WaFymMD3/Sdjzd79D/9xlRFy3LnG/nyCfwo/89H7sTd9L+c/BICM+8HkauwG" +
           "Rd0hb/HTq3/befTsn+9AN0+hi8pexSjJ1jpLqymokoL9MhJUlcfeH694ttv7" +
           "5QOAe+1J8Dky7UnoOdwzwHVGnV2fP4o2PwJ/p8D//2T/mbmzB9t99i5sb7N/" +
           "+GC3d93k1KkQOlPcre0iGf+bcymP5OOlbPjJrZtCUBOvZ5YBsulskJergGtu" +
           "2LKVT94MQZhZyqX9GSRQvgK/XDKt2n66XMxDKrPA7rbm20JeNpZyEduwqF43" +
           "hC5vqfK97Y5DYaQDysf3/eMHv/aBx14Afu1DZ6LM5sCdR2ak11lF/cvPfOiB" +
           "W5/6zvtyHANIJf3iS/e/OZNKX0fr7LKbDXg2EPuq3p+pKuTFAikHIZVjkKbm" +
           "2t4wnFnfWAGEjvbKRfjJu15YfvS7n92Wgidj9wSx9t6nfuVHu+9/audIAf7Y" +
           "VTXwUZ5tEZ4v+vY9C/vQIzeaJefo/tNzT/7xJ598z3ZVdx0vJzvg29Jn//K/" +
           "v7b7ke985RpVzGnL+TEcG97xSaIc9Jr7f6Q0wYqxmCQrjUkis1WqbahFfRY0" +
           "Ed5sVLt9ku+6plCclFl91q/HAc/NGHZWrKzLo1oBWa9LbLEo2DRXduNeLPLC" +
           "wggX3sgbGrjIV7ii7AXFwcgSl4buuq22TPcQbC5yISmKXUks+og5a0yLs1LD" +
           "7pZ4S6D7ChymUS1N4RSG4WLEjEU6HbYQtLeQOkbLxM0JZnNOH6t5rUlS3Exa" +
           "5mwilA3WQpYwMR5bag2dW9zGGHjCIuyY2GK2XvpNhYqn/KLKTfhuqzNjeYMY" +
           "UH5sOsWgXTY6HUtqhV1lo+mMPOstBY8nzFF3QGFtpydxfmfQJ5HhsFUSJu2F" +
           "7mJKv7dgkFWcztcVesKvDNkpTl12zNQXNaJbd6aKr202mNP3eQJv4ZgskP14" +
           "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" +
           "rc8JJgAA");
    }
    public static class OverCompositeContext_INT_PACK_NA extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK_NA(java.awt.image.ColorModel srcCM,
                                         java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int dstInP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstInP =
                      dstInPixels[dstInSp++];
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         16711680) +
                        (((dstInP >>
                             16 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           8) |
                        (srcP &
                           65280) +
                        (((dstInP >>
                             8 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           16) |
                        (srcP &
                           255) +
                        ((dstInP &
                            255) *
                           dstM +
                           pt5 >>>
                           24);
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qvKSOzUWgRL5Y+wr7JEOP/0vaqJzti0bAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1S1FbMwwMRGlMRI9vMGnS08M5xopW6Wgl9XitFVJ28DrNXIUC+IS7L2NjaFb" +
           "c8qC+wuTa0X+SkP8ZDkbmkilaunhTF0sPFELtGa9Ey7tWkjCUjapzy3dL1MV" +
           "uuKlkjGrIFNi1kZd3mrVZwyluFvbhE3bR4h02rbmTntRAiVQZqd1ieUcsYbO" +
           "CSvdyiSDJdyAoOSt0uDRlaJqpmGOEGlmdThsHCaNkl8pLdgh8GmGkcgmkbvZ" +
           "SnFYrkMlctx0GvRcAnvsqryKW5yFom1S84N130kGWtaswQnc9sqqgzW3akCU" +
           "q2bbtdeSPy95DZa3sqkRuHiXbUSbadZqUvx0gXY2iNoyUoMlnY1eDrnWqJ3S" +
           "KrHiQfWiscNlAko4eiSM5HZVoT1ljQXspp2IcYlbxbBSz5RVayx1u+Ykkxqz" +
           "Smu9aMm0uKxrWyA/orZVpheN5kqNrCt+z7QnZDSJuxvfiDtMP+XTCtOLPSJF" +
           "16a6LpnLfpRSs8lWrcTbVpVxxXVDcDabZjWsYiVmCUq4jtScLXq9bYRz5Cqd" +
           "0+R2ymnzjGLr486yMRO7FCbGmrUZzTjYK/fhVTSzhtTIQiXecbqTkIsHmYi1" +
           "jLCbwKMO0nC4lC23Q246XbYNf4EK4Rq1UD22fNZWpG1d29BbRGP4tqSIjW7F" +
           "ctaiVCHLC2tY9ePMq4nuzGfN8dCtKL1lHQs6y24wyCLCcVZVs9RS1FKQDPoa" +
           "OuSa7pzXqhlSq7diYwPXcX7c7CSOPMQ5NST1raotlG6pNvGWy7Y2Ukg+Y4PI" +
           "Q2tVSSq1Gpa2BQUy6YrVWllOO7xZEvmygOpexbBZHdQujazppl1fJpHqorpI" +
           "NkHNttJkrs5ZTECiTVttlssz2myFsrTUW5rg4E0Oa4uJ3IdRSZr0QyOsjur9" +
           "2orukdUKXcbIRbNHk7NM25oeN0Bnc8xfd6QNHmgqFXq+QDL0mG9NCcXQm81q" +
           "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" +
           "PYozfBMmAAA=");
    }
    public static class OverCompositeContext_INT_PACK_UNPRE extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK_UNPRE(java.awt.image.ColorModel srcCM,
                                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
            if (srcCM.
                  isAlphaPremultiplied(
                    ))
                throw new java.lang.IllegalArgumentException(
                  "OverCompositeContext_INT_PACK_UNPRE is only for" +
                  "sources with unpremultiplied alpha");
        }
        public void compose(java.awt.image.Raster src,
                            java.awt.image.Raster dstIn,
                            java.awt.image.WritableRaster dstOut) {
            java.awt.image.ColorModel dstPreCM =
              dstCM;
            if (!dstCM.
                  isAlphaPremultiplied(
                    ))
                dstPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        dstIn,
                      dstCM,
                      true);
            precompose(
              src,
              dstIn,
              dstOut);
            if (!dstCM.
                  isAlphaPremultiplied(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    dstOut,
                    dstPreCM,
                    false);
                if (dstIn !=
                      dstOut)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        (java.awt.image.WritableRaster)
                          dstIn,
                        dstPreCM,
                        false);
            }
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (srcP >>>
                         24) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         -16777216) +
                        (dstP >>>
                           24) *
                        dstM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "bLjyX5U08UiCHAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8zsaFnv+fbs2bPLsufsIrCs7C6wB8wy+HU6nenMZL3Q" +
           "6dza6fQ2vcxU5dBpO9N2er/MdEYXhKggJkh0UUxk/zAgQlZQI9HEQBaNF4Ix" +
           "0RBviYDGRBRJ4A/RiLe3ne9+zlncePmS75227/M+73N7f+/T9+lzX4XuTmKo" +
           "EgbudukG6aGZp4eO2zhMt6GZHFJ0g9PixDQIV0sSETy7qb/uV65945vvs64f" +
           "QFdU6GWa7wepltqBnwhmErhr06Cha6dPe67pJSl0nXa0tQZnqe3CtJ2kT9HQ" +
           "S84MTaEb9LEIMBABBiLApQgwfkoFBr3U9DOPKEZofppE0NugSzR0JdQL8VLo" +
           "teeZhFqseUdsuFIDwOFqcS8DpcrBeQy95kT3vc63KPz+CvzMz77l+q/dBV1T" +
           "oWu2PynE0YEQKZhEhe73TG9uxgluGKahQg/6pmlMzNjWXHtXyq1CDyX20tfS" +
           "LDZPjFQ8zEIzLuc8tdz9eqFbnOlpEJ+ot7BN1zi+u3vhakug6ytOdd1r2C+e" +
           "AwXvs4Fg8ULTzeMhl1e2b6TQ4xdHnOh4YwQIwNB7PDO1gpOpLvsaeAA9tPed" +
           "q/lLeJLGtr8EpHcHGZglhR65I9PC1qGmr7SleTOFHr5Ix+27ANW9pSGKISn0" +
           "8otkJSfgpUcueOmMf77KfNd7f9Af+gelzIapu4X8V8Ggxy4MEsyFGZu+bu4H" +
           "3v9G+me0V3zq3QcQBIhffoF4T/MbP/T1N7/psef/YE/z7behYeeOqac39Q/N" +
           "H/jjVxNPtu8qxLgaBoldOP+c5mX4c0c9T+UhWHmvOOFYdB4edz4v/N7shz9m" +
           "fuUAuo+EruiBm3kgjh7UAy+0XTMemL4Za6lpkNC9pm8QZT8J3QOuads390/Z" +
           "xSIxUxK67JaPrgTlPTDRArAoTHQPuLb9RXB8HWqpVV7nIQRBD4F/6JUQdHAA" +
           "lX/73xR6C2wFnglruubbfgBzcVDon8Cmn86BbS14DqJ+BSdBFoMQhIN4CWsg" +
           "DizzqKNYmdomhW0PuB+eyAMCKFWobR4WcRb+n8+QFzpe31y6BMz/6ouL3wXr" +
           "Zhi4hhnf1J/JOr2vf/zm5w5OFsORdVKIBZMe7ic9LCctgRNMelhOenh20hvs" +
           "2oxP7o5w4ybJiDc5nBjdlBhO6EGXLpXyfFsh4D4UgCNXABIAWN7/5OQHqLe+" +
           "+3V3gRgMN5eBFwpS+M6YTZyCCFlCpQ4iGXr+A5t3yG+vHkAH58G3UAo8uq8Y" +
           "zhWQeQKNNy4uutvxvfauL3/jEz/zdHC6/M6h+REq3DqyWNWvu2j+ONBNA+Dk" +
           "Kfs3vkb75M1PPX3jALoMoALAY6qBcAbI89jFOc6t7qeOkbLQ5W6g8CKIPc0t" +
           "uo7h7b7UioPN6ZMyLh4orx8ENr5ahHsFxP3lo/gvf4vel4VF+237OCqcdkGL" +
           "Eom/exJ+8M//6O/R0tzHoH3tzDY4MdOnzgBFwexaCQkPnsaAGJsmoPurD3A/" +
           "/f6vvuv7ygAAFE/cbsIbRVuEGXAhMPOP/kH0F1/8woc+f3ASNFB+XrerL6Ab" +
           "mOQNp2IAfHHBCiyC5Ybke4FhL2xt7ppFcP7btdcjn/zH917fu98FT46j503f" +
           "msHp81d1oB/+3Fv++bGSzSW92N9OTXVKtgfNl51yxuNY2xZy5O/4k0d/7ve1" +
           "DwL4BZCX2DuzRLGDUvWDUvOXp9CrypGn6xRwDuJxYJjlngGXLj0siZ8s2+8s" +
           "7HJkveK+VjSPJ2eXxvnVdyZduam/7/Nfe6n8tU9/vVTqfL5zNhLGWvjUPviK" +
           "5jU5YP/Kizgw1BIL0NWfZ77/uvv8NwFHFXDUAf4lbAzQKj8XN0fUd9/zl5/5" +
           "nVe89Y/vgg760H1uoBl9rVyC0L0g9s3EAkCXh9/75n0QbIqouF6qCt2i/D52" +
           "Hi7v7gICPnln9OkX6crpAn74X1l3/s6/+ZdbjFDizm126QvjVfi5n3+E+J6v" +
           "lONPAaAY/Vh+K4KD1O50bO1j3j8dvO7K7x5A96jQdf0ob5Q1NyuWlQpypeQ4" +
           "mQS55bn+83nPfpN/6gTgXn0RfM5MexF6TncOcF1QF9f3nUWb/wR/l8D/fxT/" +
           "hbmLB/vd9iHiaMt/zcmeH4b5pUspdHftsHlYLca/ueTy2rK9UTTfsXdTCjLj" +
           "bO7aYDVdScqkFYxa2L7mlpPjKQgzV79xPIMMkljglxuO2zxeLtfLkCoscLjP" +
           "/PaQV7RoyWIfFtgdQ+ipPVW5tz1wyowOQBL5E3/7vj/8ySe+CPxKQXevC5sD" +
           "d56ZkcmKvPrHnnv/oy955ks/UeIY2PnkH/nmI28uuDJ30Lq47BfNoGiGx6o+" +
           "Uqg6KVMGWkvScYlBplFq+4LhzMW2BxB6fZQ0wk8/9MXVz3/5l/cJ4cXYvUBs" +
           "vvuZ9/zn4XufOTiThj9xSyZ8dsw+FS+FfumRhWPotS80Szmi/3efePq3funp" +
           "d+2leuh8UtkD70y//Kf//oeHH/jSZ2+Ty1x2g/+BY9Nr14f1hMSP/2hZJWob" +
           "Kc89k81TZ87tVvCc7Ay2gbmepJRGpmNtljvLSj/xa/mmrzIbh1t4C3KNGuEC" +
           "JK1pnZkREk8ksiQFZDSz3cjFA9IirCBSRzxm26uVQJEbOaju+FG7M0DSDi/L" +
           "XSWdpOuq3/CNWmtheDLpus4WZeA1x8HwrgJXVBat0o7YY+SeIQ0iam4oo4Hi" +
           "Slo+U6m6XR0xCYKMO6YIsk5i0UbqAcqoPWpaDfRgxTjJak6RNW9i5ckGZlau" +
           "Is5cyVZt3dLnM1uzCHHQY2fbMNas7ZxS/XQk1wQqtBDN7xLE1Mt7El7zEKrb" +
           "rDYmVWWzCTxL6kx0Sl/5xA5GZbFD1qbMsBbzu6YsGE3bTMaB1GqY1Goqr3Sk" +
           "TpALUe7PiZ7hrURh1aUNElHNDA/SHr81urzqKaE6I5GVJjWo0GnyqTw0Nq1V" +
           "1FxRlNeRkYk13VU2XhjNxqvpsieL3i7mQ8qT17yM9IUOpTRtwo0cxp5b3lAc" +
           "D/JIq6T8csHLQq/mK84k68ZSwzWXk17dtlm57rGOutl6pNgQya6FUBGm16fL" +
           "prZL2sGInjLSYhgKFQbfDbA119cGEefybrRDxkPc6wV0hxrmthRyETUT58P6" +
           "VjStWijpwxk3VibJlgGveG1TawXESBNifd7I+qKmIrM13h7KWWdY7aHkFhF2" +
           "uh25FbyjTqvzFdLd4OwSqxl9WWOcQWM17IytVW+ck7N60tAkZxNE6GCEratx" +
           "4gS1eCkRSjeoCYo12dYacjwYzXhasoXOJOkGQpPkRAmf4EZQ7eEDS2Doli3V" +
           "5HhYtXGT7PaUlYhh0XDZl1m2ThrLiW3PG1tx6bcYCsSiocOxL2fTHWz4CjJY" +
           "8Z1V12UpckpNNxiN+Vs6W3nEABe3PLHR17vOdtBrV0y5xZMTwmwQY4XpwmCT" +
           "X1j5VJpOc706hmne4OQ1ZY2Yib7ARu2KWptTS0XoiQEiTkVq1UCxcWPXHAVt" +
           "bRYGG44Qx42tSrS77SSjUVU30akyQvGtnfiqRHruiF3KuUww4UhGFJsejKKx" +
           "iLtjcV4VbTt31/UKOqv2wzpYAXFv3tftmUBrThDInKvYLbO9DJaTzYyYRcua" +
           "oYqKU0vqjXDltH2DFHh6sXVG/LK/rDuwLVVGTKCJShD1kpkgK8aUkCTGqYSp" +
           "xVN5JRlUtyjeFrh8WUvnfIcUHMUhexvLschelvS31U1LHDNbIt0smplrIDw1" +
           "Gs9lyh4rKhz569Wgh4nWku2Mu60xjFJxtWvGjCax3b5djYbVbTprqjVqbScd" +
           "e6t0VAsjs1qXXzFLNBdFV9pEM2sN3qPXiusgOYDAtJWgpI0YGEYLajpHkrli" +
           "VLWmgvSWG1ZRtzgvBTzBDnGBxHsbc411/ZaozNtJNV1ajmTV1x2inlfjSK+l" +
           "ol2fzZi22A3nSrOf7mLJjTeqoPOiPAs8L9GpkTgf5ziBe105BLtOfRGFqsgN" +
           "tKa9BO81wQwsemspYz175vdCROowzAoWhI4+zJqTnMLrU9rOGw1Jnzqb3brp" +
           "o7Ze7UltZkanmTRbdqMaNw55Llh7zhTTt2MT1bIK47TqJhqtGjbbC/nh3Nj1" +
           "fcqgnNjJbdhU6Mkm9esLduf6M1RvsmO8OvEGXXyyiTluXecHK8pa694Ec4Nh" +
           "hxgj1GymtZNBYyGEox7D7sYtd7Cut6o8sOJICWbJUp5lqcsqiyaLrPwZIgqs" +
           "vWM5JtzM1kMXjasNtNloW61Fg9VqWHUrR9VhQM5FylJqABKQYSIE/pzRVQvv" +
           "Gp2qaaNojCFgywB26gT2cGEFSKJSqw695Hcc7GPu2gTLL60xqs3oDTHH3Blm" +
           "e9hmO82HXbLT60hEtyOtHdMCsbhqklm/ZdEUXJFFeb1drOAm1lKarrHMA8zM" +
           "wbZSH+ecUndr67mfN1FFF6WOTRmr3JXGnj7EiE3TV8dcR6FWhteuyOquiQ38" +
           "OjvCJ1a6TROy064v5R1KMmp7VBUnlWrQU+qjjUqP0jrA4dF0EfDUprlrSX2v" +
           "30qxJpdMa2KXM0bmgIFTfSirY9bvIsZqugYAj2Z92uwnVYMQkNk8pzt5fd4Y" +
           "KDic820jag7UDh0NaX9WkSNEX+OJXqkTTofqpIa1wpOOy6F9R5q15hXMNtdi" +
           "2qyKVm+URr2toHM5k+Rij6x1a4Th9WK8EaBwYyb0epvtJopiLxr1Fg0f9z0L" +
           "jltDr8FgqthUmYyWUGwDj0WSEbBuluH5poVuxmiub8k5R6wMQet1RdjoDjd1" +
           "jjKrY19b+8TAbwmGBHLyzbi7m4BNBsbNpmGb/JbL44yhha4xwSpVQ4l6yGJd" +
           "n8JoPTZYcTqv8KEykRW/EiaDgdg0tZDsVGB4SIjNgKOXTbQpsXR3u1gGpIdl" +
           "TaHuLtFK2lnWlT5RpxYus6jBAx/LrCklLgyBqITtdD3ZwcPmEBMNZafqbMf3" +
           "dqNWiIshcIYhrlI7TDSrG2Cu4lFhFtYJX1hxcqW/YKIOnhva1IPHTsts1Gsx" +
           "PkyT1qa/bEyc8aJj8Tm9kmoivt3yuoMadq8TYu0mzVDq2iXXHk26vYFJssqW" +
           "c4JRdSzOqj1OUEgfZcHWorV6AVV1u+KqJw/mFNZadNlalnWFWqtFb+k52nSa" +
           "9tir8AgMs7QIr0hrq8/DcNt1lxljAiStTxMknLUHXJ1odeFFewlX633GxjE0" +
           "TeQoqRl+pbYZdHhNGzfC2QLAI9fYGRWDpvxp1nVXqCK5fCsc+/aEVsZdM+sJ" +
           "jQXs590B5c6jBd2kBzXd6HVIRvYcyckpf846jKPFGL5K210b9peh0KxUWwNC" +
           "RMNFyGEwJ+AGxVbj3RALpt0o7W7oDlNbrSr9dZvGmpVJzaxh0likSbUBdkW8" +
           "g0wRhGM6NplYfZTDc17eGnMD74zrq0FtRqEx2kcSuBUr0TCvBLQSdK1BOgwV" +
           "V0ZD0mtO+2s3aCFVuJot1d0uCrmd6/CJZS9HNClsZgLTRe1sBfaNFp53mxyi" +
           "VjBhusuaLZiqbqUdplX4yprqYdNJBXPpYTsQ3ATDknQUMbo9ork+VZ2pHNZd" +
           "IjzNS0MmDXtx3MTVqCrWsgXlZ4rBjUezukM7NrfQUOAzdTBAYTwLEL4WmCG+" +
           "ZicNdkik2RTFKglK9+cc22JDZTem2VbcRXN7ivKJvBNbo7Y0VgaoOhf1KrMO" +
           "o8WotUyJcLM1svWo7zfgOkiZrB4/cviRChJsATZsv22izabTyBVHXvQ4womU" +
           "dmvK+UjVTLKRh27bejW3ojzZZZLhJCN71w76YjRv9RuNeYshnUE76kfbecRj" +
           "LXkENhN4oeC7ahNzbQwf7dD12lJHdU7xR0haUReWhc7BSw5Ju7uUsrBW3B9U" +
           "CBZnSSel20SjxYf0UvOSWaCs8Yo76ncacJNJNoNGczIUnFpqanakGBhPVbxo" +
           "xssTODPYsU8rttXsb5br8c7LN7OhTqiYP+04TEPwXNSqGw2jSg4a9T4y4T0X" +
           "6Th9jl73iaAah4Gk09FkOKH5pMVmS7fVCER/tEsWakCSoTFjZguJq2nBpK27" +
           "MttU2cDv+EGfw4aV3Jnb9XVWb9SHLT+Pdm5tm3EVaRfkkivVVWVRyZaduOn4" +
           "ZEum057iDkHulmP0EqzWgZCF654drWSVlVIBNa3t0uQaFLJwnL6FONEotGS1" +
           "s5uJgjitmqSzXDByl8BGamulURG3nSY7kEYaRFuQ2TnPqxjV2S2ojomzFLvL" +
           "+wZS4/VFe0pLyAgNJsIGmVTpmsqzmOCsFtNwmPbdSsYjWbejcfXdEqkh1cpo" +
           "aIVW1fAEpgHPmv6uldHueNVR4Hke2xIPS3x7F6uzVqQv0zyZ2krcb2/TxWCo" +
           "A3N6yMbu+JqaWXbmyKvRBMu2AdtG0IaC11SvZaJOVoPHNNcOZb2TOYslTs6q" +
           "XrtL26rf7k707s7o6WnibQZCpQ+2wzqTzuVtzsKs3F64MRtP5UoFyNfWRUfe" +
           "NFhOnk0Fdpr2RkzkD4R6MrVWUTtkQmLgdJEpqXrJQMD5DKcy04+2kwaPeFy1" +
           "s8kQx4vHDptESd3O5t5wKWzpXZfuA7wYEBl4f4xQzcca4wrXgHVulM9H1Xid" +
           "KGyXzQSPaGq40G8gkmSjYpD5ACBpo9fYEtVgR6ymmcbNaWc7bUjVlmQTQ/AK" +
           "XLwa33xxpxMPlgcxJ/U4x20WHdSLeCvPbz/hwemEp8e/5ZHegxdLO2ePf08P" +
           "+6DiAOLRO1XfysOHD73zmWcN9sPIwdEhqZpCV46Koqd8DgCbN975lGVcVh5P" +
           "T+5+/53/8Ij4PdZbX0S14vELQl5k+dHxc58dvEH/qQPorpNzvFtqoucHPXX+" +
           "9O6+2Eyz2BfPneE9emLWa4W5aKDqA0dmfeD2FYPbOupS6ah9PFw4gL7r6NT1" +
           "6FDu5RfOsAUtSffnoZtjkkcvkCixnRbn7XvScpL1C5xy/1DRRCl0j15Wrfb1" +
           "EelMBM5S6PI6sI3T0Iy/1YHR2TnKB/55u42BvZ44stvj/zt2e0lJ8JLbSX+X" +
           "7Zd1iveAqHz9naOyrC7sj/Ke/cUn/ujtzz7x1+XJ+1U7kbUYj5e3qUyfGfO1" +
           "5774lT956aMfL2tXl+dasg+biyX9Wyv25wrxpW73n1jrfmhvssvM3lr73xTS" +
           "/4dVUy0MEzhZL+dxsEnMGGYCw+RsfWXGnOab7nFx9v9jmnzvmmM/XjqqeZ6c" +
           "O74vvwSVkfHMtwK9E4C94pr+cl/efk/R/GSYn/C/UCN62ekRNOEGvlksnOO+" +
           "fX3WDg5PvvAAnfltJfX3kpaTvejQPbsaf+EF+j5UNM+m0N16IelesRcg/0gO" +
           "nVhgb4Y73pb0P/4CvD5aND8CzBXG5hFOnBS1i663nYLDj74YcMhT6In/RsX8" +
           "2COVF1GJB4v94Vu+9tl/oaJ//NlrV1/5rPRn+7V6/BXJvTR0dZG57tkSzpnr" +
           "K0D3hV2a4959QScsf34thR57YbmAy8rfUo1f3Y/6ZAo9fKdRALJAe5b6N0E0" +
           "3o4aUIL2LOVvpdD1i5Rg/vL3LN2nU+i+UzqwZvYXZ0k+A7gDkuLyt8NjF4xf" +
           "zMcQuBtaGhebd3Rvful89nESRQ99qyg6k7A8cQ7Tyw/BjrOCbP8p2E39E89S" +
           "zA9+HfvwvkKvuxp4GwRcrgL43X8scJJZvPaO3I55XRk++c0HfuXe1x+nQA/s" +
           "BT7dt87I9vjt6+I9L0zLSvbuN1/569/1kWe/UFa8/gtaFD3eoScAAA==");
    }
    public static class InCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        InCompositeContext(java.awt.image.ColorModel srcCM,
                           java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      dstPix[sp +
                               3] *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYfWwUxxWfu/M3/jyMTQAbMIbKht4WEaoiUxrb2GA4G8sm" +
           "VDENx3hvzrd4b3eZnbPPpk4DUgXtHwhRB0jV+C9HaaskRFWjtmoTuYrUJEpb" +
           "KSlqm1YhlfpH6QdqUKX0D9qmb2Z2b/f2bCMq9aSb25t58968r997sy/eRaU2" +
           "Ra3EYDE2YxE71mewYUxtkuzVsW0fh7mEej2C/3HqztC+MCobQ7VpbA+q2Cb9" +
           "GtGT9hhq0QybYUMl9hAhSb5jmBKb0CnMNNMYQ+s0eyBj6ZqqsUEzSTjBCUzj" +
           "qAEzRrXxLCMDDgOGWuJwEkWcROkOLnfFUbVqWjMe+Xofea9vhVNmPFk2Q/Xx" +
           "M3gKK1mm6Upcs1lXjqKdlqnPTOgmi5Eci53R9zomOBLfW2SCtlfqPr5/JV0v" +
           "TLAWG4bJhHr2CLFNfYok46jOm+3TScY+i55CkTha4yNmqD3uClVAqAJCXW09" +
           "Kjh9DTGymV5TqMNcTmWWyg/E0NZCJhamOOOwGRZnBg4VzNFdbAZtt+S1lVoW" +
           "qfjMTmX++qn670VQ3Riq04xRfhwVDsFAyBgYlGTGCbW7k0mSHEMNBjh7lFAN" +
           "69qs4+morU0YmGXB/a5Z+GTWIlTI9GwFfgTdaFZlJs2rlxIB5fwrTel4AnRt" +
           "8nSVGvbzeVCwSoOD0RSGuHO2lExqRpKhzcEdeR3bjwIBbC3PEJY286JKDAwT" +
           "KCpDRMfGhDIKoWdMAGmpCQFIGdqwIlNuawurk3iCJHhEBuiG5RJQVQpD8C0M" +
           "rQuSCU7gpQ0BL/n8c3do/+VzxmEjjEJw5iRRdX7+NbCpNbBphKQIJZAHcmN1" +
           "Z/wabnrtUhghIF4XIJY0P/jyvcd2tS69JWk2LkNzbPwMUVlCXRyvfXdTb8e+" +
           "CD9GhWXaGnd+geYiy4adla6cBQjTlOfIF2Pu4tLIz554+rvkr2FUNYDKVFPP" +
           "ZiCOGlQzY2k6oYeIQShmJDmAKomR7BXrA6gcnuOaQeTssVTKJmwAlehiqswU" +
           "/8FEKWDBTVQFz5qRMt1nC7O0eM5ZCKEofFEzQuGDSHzkL0OnlLSZIQpWsaEZ" +
           "pjJMTa6/rQDijINt08o4RP2kYptZCiGomHRCwRAHaeIs8MzE00zRMuB+ZfTE" +
           "oV5QiqtNYjzOrP+7hBzXce10KATm3xRMfh3y5rCpJwlNqPPZnr57LyfekYHF" +
           "k8GxDkMHQGhMCo0JoQIqQWhMCI35hbYPGPlnBzVQKCTEN/LzSM+D3yYBAQCC" +
           "qztGnzxy+lJbBELOmi4Bo3PStoJS1OvBhIvtCfVmtGZ26+3db4RRSRxFscqy" +
           "WOeVpZtOAGapk05aV49DkfJqxRZfreBFjpoqSQJUrVQzHC4V5hShfJ6hRh8H" +
           "t5LxnFVWriPLnh8t3Zg+f+IrnwmjcGF54CJLAdn49mEO6nnwbg/CwnJ86y7e" +
           "+fjmtTnTA4iCeuOWyaKdXIe2YIAEzZNQO7fgVxOvzbULs1cCgDMMCQfY2BqU" +
           "UYA/XS6Wc10qQOGUSTNY50uujatYmprT3oyI3Abx3AhhUcETcgNkZr+ToeKX" +
           "rzZZfGyWkc7jLKCFqBWfH7We++0v/7xHmNstK3W+fmCUsC4flHFmUQFaDV7Y" +
           "HqeEAN0HN4a/8czdiydFzALFtuUEtvORpwK4EMz81bfOvv/h7cVb4Xyco1yh" +
           "bhWr6AZCdnjHAATUASN4sLQ/bkBYaikNj+uE59O/6rbvfvVvl+ul+3WYcaNn" +
           "14MZePOP9KCn3zn1z1bBJqTyCuyZyiOTsL7W49xNKZ7h58idf6/l2Tfxc1Ag" +
           "AJRtbZYInA0L1cNC8/UMPSJ2ekgCnE3Ks0pUtb3CpY8KYkWMe7hdHOvx/5/j" +
           "w3bbnxqF2edrqBLqlVsf1Zz46PV7QqnCjswfCYPY6pLBx4cdOWDfHISuw9hO" +
           "A92jS0NfqteX7gPHMeCoAkLbxyjgaa4gbhzq0vLf/fSNptPvRriDq3QTJ/ux" +
           "SEFUCbFP7DRAcc76wmMyCKZ5VNQLVVGR8kUT3A+bl/dwX8ZiwiezP2z+/v4X" +
           "Fm6LGLQkj41+hp8SYycfPi0dxaDfzI5D2w4PtmgFvagVGxuCNdMftQUCKGpZ" +
           "qa0RLdnihfmF5LHnd8vmI1rYKvRBJ/zSr//989iNP7y9TIUqc9pSTyCvIi0F" +
           "VWRQtHsekn1Qe/WPP2qf6HmYAsLnWh9QIvj/zaBB58oFIXiUNy/8ZcPxA+nT" +
           "D1ELNgdsGWT5ncEX3z60Q70aFr2tLANFPXHhpi6/VUEoJdDEG1xNPlMjUmJb" +
           "3vt13Kt7wetHHe8fWR6Pl42rEH/sDwBgrctkGWYBDIgILhEXRtYFYGQE29Cv" +
           "88Uxl6QlQPJFqjEOeZJUnPWJVYAmwYdRhqosSlTR3xAIsI5V7o5Uy0AhmXK6" +
           "b2Uu+uHkt+68JIM72KoHiMml+a9/Ers8LwNd3me2FV0p/HvknUactF4a9RP4" +
           "hOD7H/7lavAJ2dNGe53Geku+s+ZoQNHW1Y4lRPT/6ebcj789dzHsmOUoQyVT" +
           "piYvUfv4cFw6df//iGJ8oseCnjFa3Ee6rtz5EO0oaLW+6Morr2nqywt1Fc0L" +
           "j/9GAED+KlUNqZzK6rovE/xZUQYBkNKE8tWySFjih3dAq5+LoVLxK9Q4K3dl" +
           "4ca00i6GIjD6qcEsjctRA6VrHofyHEP1QUqQL379dE9BRHt0gKPywU9yHrgD" +
           "CX+8YLkuOPgwN4Ju3UrjYUqC/syFiiuQiKF1D4ohX03ZVpCC4iWIi4hZ+RoE" +
           "rgoLR4bO3fvs87L3U3U8OysuzXFULtvQPKpuXZGby6vscMf92lcqt7sZ0CAP" +
           "7GHdRh9q9ADSWbwybwh0SHZ7vlF6f3H/67+4VPYeJPtJFMIMrT3pewUh79vQ" +
           "ZmWhnJ2MewXN9xJNtG5dHd+cObAr9fffi+LuFMBNK9Mn1FsvPPmrq+sXocVb" +
           "MwChaSRJbgxVafbBGWOEqFN0DNVodl8OjghcNKwPoIqsoZ3NkoFkHNXydMH8" +
           "9Yiwi2POmvwsvzkw1FYMWsX3LWiEpgntMbNGUtQZqIDeTMHbGbcwZS0rsMGb" +
           "ybuysVj3hHrwa3U/uRKN9EPKF6jjZ19uZ8fzRc//wsargvV8IDkJp5FEfNCy" +
           "XHit3GPJLJmXNHwebsCdziwHu5BXAq8LdtfEIx+e/S9qI/EhixUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class InCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        InCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                    java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcM =
                      (dstInPixels[dstInSp++] >>>
                         24) *
                        norm;
                    srcP =
                      srcPixels[srcSp++];
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "koXD6yvskQ4/+S+eYxW6IxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class OutCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OutCompositeContext(java.awt.image.ColorModel srcCM,
                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      (255 -
                         dstPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVZe8zkVnX3fptNNkvIbhLyIJD3QhWGfh6P56nlEXvG9ng8" +
           "tuflebgti+2xx++3ZzwDaQG1TVTUQMsCqQT5C9QWhYeqolaqqFJVLSBQJSrU" +
           "l1RAVaXSUiTyR2nVtKXXnu/75vu+3Q2Kqo40d+7Y55x7z7nn/O655774Q+hc" +
           "FEIF37PXC9uL99U03jftyn689tVov9Ot9KQwUudNW4qiEXh2VXn8Sxd//MpH" +
           "9Ut70K0idI/kul4sxYbnRgM18uylOu9CF3dPCVt1ohi61DWlpQQnsWHDXSOK" +
           "r3Sh1x1jjaHL3cMpwGAKMJgCnE8BxnZUgOn1qps4zYxDcuMogH4ROtOFbvWV" +
           "bHox9NhJIb4USs6BmF6uAZBwPvs/BkrlzGkIPXqk+1bn6xT+eAG+9sn3XPq9" +
           "s9BFEbpouMNsOgqYRAwGEaE7HNWR1TDC5nN1LkJ3uao6H6qhIdnGJp+3CN0d" +
           "GQtXipNQPTJS9jDx1TAfc2e5O5RMtzBRYi88Uk8zVHt++O+cZksLoOt9O123" +
           "GpLZc6DgBQNMLNQkRT1kucUy3HkMPXKa40jHywwgAKy3OWqse0dD3eJK4AF0" +
           "93btbMldwMM4NNwFID3nJWCUGHrwpkIzW/uSYkkL9WoMPXCarrd9Bahuzw2R" +
           "scTQvafJcklglR48tUrH1ueH3Duee5/bdvfyOc9Vxc7mfx4wPXyKaaBqaqi6" +
           "irplvONt3U9I933l2T0IAsT3niLe0vzB+19+6u0Pv/S1Lc2bbkDDy6aqxFeV" +
           "z8h3fuvNzScbZ7NpnPe9yMgW/4Tmufv3Dt5cSX0QefcdScxe7h++fGnw57MP" +
           "fE79wR50gYZuVTw7cYAf3aV4jm/YakiprhpKsTqnodtVd97M39PQbaDfNVx1" +
           "+5TXtEiNaegWO390q5f/BybSgIjMRLeBvuFq3mHfl2I976c+BEF3gy90PwTt" +
           "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");
    }
    public static class OutCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OutCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                     java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcM =
                      (255 -
                         (dstInPixels[dstInSp++] >>>
                            24)) *
                        norm;
                    srcP =
                      srcPixels[srcSp++];
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xqJPcur4+gp7pMNP/gsmwuMDJRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "szzlcAHf95+8NXn3P/zHVU7Iceca2/MJ/jHy7Efvx9/83Zz/EAAy7ofSq6Eb" +
           "5HSHvKVP2f+289jZP9+Bbh5DF7W9hFFRrShbVmOQJAX7WSRIKo/1H094trv7" +
           "5QOAe+Ak+BwZ9iT0HG4Z4Dqjzq7PH0WbH4LPKfD9n+ybuTt7sN1m78L39vpH" +
           "DjZ7z0tPnQqhM6Xd2m4h438yl/Jo3l7Kmh/fTlMIUuJoYplgNZ0N8mwVcE1N" +
           "R7XywbEQhJmlXdofQQHZK5iXSwurtr9cLuYhlXlgd5vybSEva9FcxDYsqtcN" +
           "octbqnxvu+NQGOuC7PF9//jBr37g8RfAvHagM3HmczCdR0bkoiyh/oVnP/Tg" +
           "rU9/+305joGdT/m5l+5/MpPKXcfq7JLMGipr2vum3p+Z2s9zBVYNwm6OQYae" +
           "W3vDcBZ80wYIHe9li8hTd72w/Oh3Pr3NBE/G7gli471P/+IPd9//9M6R/Pvx" +
           "q1LgozzbHDxX+vY9D/vQozcaJecg/+kzT/3xJ596z1aru45nkwR4Wfr0X/73" +
           "V3c/8u0vXyOJOW25P8LEhnd8sl0OaGz/wyojvJTIaWobfBovGuVoaOgmNhVb" +
           "aZUsdly8sPYmhE4lqQOX+x1PX2DBREMrxage1uJgE1qOt+kJjMZwJNFz6UmP" +
           "sVZudd6nDVnxZdEseKrS7zOUvSQ4t7DodRoiXgjFnqJIatzn4qIzjqclbaAt" +
           "VoHar6BjB0EsB4kRBAkNLXJJm2p5qwRzO0uL4Kg6WZrLPQLVWilnLZMFX0jI" +
           "dDBlxRYcRaHaQF2Eiby2JTvNapMmMVSnB3R5gqhzQ54lJoPTpWhB8YVUFtti" +
           "OGqnKu3hfkOlK0udGRUGIm0VVkOq2x+6BNJLVnOCLqjKyI6a/DIhm40BUe6P" +
           "TL3DSSaiJ5oYDcyVi6qVtszXF5M2WViNg1hb44zL11KKmiu42m/TLtu0l7zK" +
           "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" +
           "eDhxMHxrTnBrfi8fiYNRCN1kOvk5eAK8+9rrezc/vd4eFT3zm49/7R3PPP73" +
           "+cnuOTNQVB/zZ9coeR7h+f6zL3z3G7c/+FxeGzkN3na35p+sFV9dCj5W4c1t" +
           "u+3AW7dBW5ed5rbe2v6GkPYjluNUzwuQIJ5NfDcJDB/hXN0QTG1p+ILqGNZ+" +
           "1e//Y5h0OzX783hqbyEcnGs9lZ6C8sh418st3gOgOGsZzmxbN02y5u1eeiD/" +
           "RA3i7sMjTtxyHSMrhOz3bet/prt78NcB0JleU1Nnq2k+2CsO3aM1jQ/coO+X" +
           "suZ9IXRGyzTdGnYD8qdT6MADWzdc9zanj28g68NZswLu8nxDy+umxkG59FpL" +
           "7nTsmvohJvsvd4J5rLoRQg/cqDy7Pz3wK6j3gpV/31X/Kdn+D0J77pkL5+59" +
           "Rv6r7cLd/6/CLSx0bhpZ1tF6wZHrs8ARUzP3zS3b6oGX//xGCD10Y73A/OW/" +
           "uRm/vuX6RAjddz0ugF+gPUr9SRCa16IGlKA9Svk7IXTxJCUYP/89SvdcCJ0/" +
           "pAMLaHtxlOR3gXRAkl1+ztufgu4rKbljljdXBd+47sSmp45vqQfhc9fLhc+R" +
           "XfjxYwCf/91of6uLtn84uqJ95pkO97YXq5/YloM1S91sMinnABZvK9MH2+Wj" +
           "15W2L+ts+4mX7vjsLa/d39fv2Cp8uIkd0e3haxdhCdsL87Lp5g/v/f03/tYz" +
           "38rLK/8Lacc69gcmAAA=");
    }
    public static class AtopCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        AtopCompositeContext(java.awt.image.ColorModel srcCM,
                             java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      dstPix[sp +
                               3] *
                      norm;
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    sp +=
                      2;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class AtopCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        AtopCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                      java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (dstP >>>
                         24) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      dstP &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xuAnOT3AvsYe6fCT/wLbcA45JxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WCDJtmOLHd/pmnqpyBQUrIvjsF2Jm9pm2Yblad0cGiDUJipXqXVHQgUooqMM" +
           "vVnq6IMNFyLYSoaXJG+7FaIYBOair7LEctyf4U3E5VZBh8CtjmMG1UVLVhvm" +
           "iiuKgedhOCOlqDxtCzI3kWe4gBUZ1Zl1zPVoE6Qbclhcq5tuc4NoK5KRPYLH" +
           "Yhd2BNnxivOaM4+agxnZpX0Ygzce1++2R41+pd4rU+1GH+T1dX6mdmkdjq3p" +
           "YDAlCpMl3ORgxWwu3bkDghpAZToJe3CNkbtyhdb6Xsi6LoqwuMViZUlz5w2H" +
           "6Yc4N5MLnfUwGI3IEC0tGRvpWLKO9AN4oWz8uoRMRptWrSPMFga/anB1xlwZ" +
           "jleWCkmyMtVIQTslhMYSE60Me6wyGKnadBiIxmwsJQxqTeuKMmN8Xe6BTI0f" +
           "tApISJSdntPD+U2MB7hYC92pUot0dz1edDuFSqRwvIPXJzOqifcpoY6txsbE" +
           "aGBCb1CKNgTmRqjW0kkhUuCEXqBpNGtyyLqghCGYTyVqVaNjpnC/Vm43eG4w" +
           "i9SyVoD9ELyD+FO2WRcnC16TCgN56E2HBSFuUSuMx4rEVOdlEsUVLWLBu4kv" +
           "1ehaa91gRrRLL1R70ysG2loAb2RJJFp+1x4CW43LZuwPyvMaHgZTW2mqYt9d" +
           "p5TEtQ2Z15tdZmSKvNCdOb6axpjDjstYEs6VqtoaI6veQsLQSjcNwYvpm96U" +
           "vbJefWWnBnflByQHFTLTqmUd3Vfwtpxef8KdwwkPj2Xzo7a7ThZbjh7LHh7C" +
           "QdnBwIM3qoflhwKfeM/Tz8jsJ4s7e4eXQgSd2ytTHvLJTmZef+PTj35eCzw8" +
           "UfvSe/7lgfGb9be9girCwycWeZLl7/af/Qr5OulXd6DTB+dr11Qpjw+6cvxU" +
           "7UKgRHHgjI+drT14oNaLmbr6wMi37p12n73+Sf51DXUqN9TWH04cDN+WE9yW" +
           "30+O+ME8gk4bTn4OvgLafeLG2s1Pr7dHRc/89uNff+czj/99frJ73gh5McAC" +
           "7To1zyNjfvDsC9/75h0PPpfXRs4sxHAr/sli8bW14GMl3ly22w+0dTu0VdkZ" +
           "Zqut7W8EST9mPU70vBAB++cicFehEiCMKyucIS2VgBMdxdov+/1/TJNuTbNv" +
           "x1N7gXBwrvVUegrKPePdLxe8B0BxzlJALpwXTldZ8w4vPeB/ogZxz+ERZ8ty" +
           "HSUrhOz3bet/hrt78N8B0Jled6XOdqX5ZK/YdY/WND54k75fyZr3R9BZKVvp" +
           "VrCbkD+dQgca2Krhhrc5fXITXh/JGh+oywsUKa+bKgfl0uuF3JnENeRDTA5e" +
           "7gTzWHUjgh68aX123z7wK6j4gtC//5p/lWz/CSE998zF8/c9M/mrbeTu/1vh" +
           "1h50Xo0t62jB4Mj1OaAJ1ciVc+u2fODlP78VQQ/dfF3AgPlvLsZvbkd9MoLu" +
           "v9EoAGCgPUr9KeCb16MGlKA9Svl7EXTpJCWYP/89SvdcBF04pAMRtL04SvL7" +
           "gDsgyS4/7+2boP+Kiu6Wp4tcoNzQsOmp43vqgf/c/XL+c2QbfvwYwud/ONrf" +
           "6+LtX46uSp99psu8/cXqJ7f1YMkSN5uMy3kAxtvS9MF++egNue3zOtd58qU7" +
           "P3frE/sb+53bBR/uYkfW9vD1q7C47UV53XTzR/f9wRt/55lv5/WV/wXdfLDT" +
           "CSYAAA==");
    }
    public static class XorCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        XorCompositeContext(java.awt.image.ColorModel srcCM,
                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      (255 -
                         dstPix[sp +
                                  3]) *
                      norm;
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4XrMY3OzO6trm5XUX2+mdK1t+XyJ8ty2Yab9RNF67FyiLZ3vrmHNIKI0Stu9" +
           "AlG00FrH1xXUqtXi9hxZ94eMqJqL0QQcLt797uzYce31nfzuzg+5R3cb4MCX" +
           "vei+jhNPcnOFezuFu9JaXi65+3SZ/HhpbVdIgbLD3cO3usnID3af/vD1F5XB" +
           "Z9C9gwLUHJzlDy6YdnKy0/U7bn2CpfNbnF1V5Csf/peHuPcY738dleBHTw3y" +
           "tMjfpV/6GvV2+Tf2oLNHNZIb7pdOMl09WRm5GKhRHLjcifrIw0duvZS5qwzc" +
           "iR64tXDzauxNJ+pMPlHbeDhV3Dt7UNE6KHjcd6o+OBLDaFtrWh+SPHyKZBqY" +
           "UVbL3JLmSlavUUH8YNYsI+iiH6hyfguwLT9PjgWhAA7lK89UdtEZ/KTz+Ila" +
           "XQTde5M7hkMD4NdxVwEC68Eb7kO3d3jy51+8dOGBFyd/nVfmj+7Z7uhDF7TY" +
           "to8XvY49nwdma2buiTu2JTA//3kugh557XFF0Ln8Nzfj2S3XRyLowVtxRdBZ" +
           "0B6nfj6C3nQzakB56J4Dyl+PoMunKYH+/Pc43XUwjzs6sDS3D8dJPgGkA5Ls" +
           "8QX/cAqar+e6qGH7hsgG6un5TM6chJKjYLnnJwXLMfR58gRs5Dfkh0s83t6R" +
           "X5O/8GKX+cArlc9srzJkW0zTTMqFPnT79lblCCYev6W0Q1nn20+9etcX73jb" +
           "IZ7dtR3wbvEeG9ujN79AIB0/ykv+6R8+8Pvv+u0Xv52XBv8XdmfM77ogAAA=");
    }
    public static class XorCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        XorCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                     java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (255 -
                         (dstP >>>
                            24)) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        (dstP >>>
                           24) *
                        dstM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Ho1Fn9TU8fVV9kiHn/wXXjx99CUbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kTiYR9Bpw8nPwWNg3ddf37r56fX2qOjZ337s6+969rG/z092zxshLwRYoF2j" +
           "5XmE5wfPvfi9b972wPN5b+SMKIRb9U/2iq9uBR/r8Oa63XpgrVuhrcnO9LfW" +
           "2n5GkPRjtuMEzwvhcK2JgRuHSgD3XVkZGpKpBEPBUaz9rt//xzTJ1jX7fjy1" +
           "lwgH51pPJ6egPDLe/UrJewAU5yzF0bZ90zgb3uklB/JP9CDuOjziJCzXUbJG" +
           "yP67bf/PcHcPfjoAXibXXKmzXWk+2asO3aM9jQ/e4N2vZMP7I+islK10q9gN" +
           "yJ9JoAMLbM1w3ducfn0DWR/JBh+YywsUKe+bKgft0mul3Jm1a8iHmBy80gnm" +
           "se5GBN1/o/bsvnsKr6LfCzL/3qt+U7L9HYT0/LMXz9/z7OSvtom7/1uFmxno" +
           "vLqyrKP9giPX54AhVCO3zc3b7oGXf/xWBD1443UB/+WfuRq/ueX6ZATdez0u" +
           "gF9gPEr9KRCa16IGlGA8Svl7EXTpJCWYP/88Svd8BF04pAMJtL04SvL7QDog" +
           "yS4/7+27oPdqWu6Y5enCMFCu69jk1PEt9SB87nyl8DmyCz92DODznxvtb3Wr" +
           "7Q+OrkiffZbuv+Ol6ie37WDJEtI0k3IeYPG2M32wXT5yXWn7ss5Rj798++du" +
           "fv3+vn77dsGHm9iRtT107SZsy/aivG2a/tE9f/Dm33n223l75X8Bq6rERgcm" +
           "AAA=");
    }
    public static class ArithCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        float k1;
        float k2;
        float k3;
        float k4;
        ArithCompositeContext(java.awt.image.ColorModel srcCM,
                              java.awt.image.ColorModel dstCM,
                              float k1,
                              float k2,
                              float k3,
                              float k4) {
            super(
              srcCM,
              dstCM);
            this.
              k1 =
              k1;
            this.
              k2 =
              k2;
            this.
              k3 =
              k3;
            this.
              k4 =
              k4;
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int bands =
              dstOut.
              getNumBands(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            float kk1 =
              k1 /
              255.0F;
            float kk4 =
              k4 *
              255.0F +
              0.5F;
            int y;
            int i;
            int b;
            int val;
            int max;
            for (y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                for (i =
                       0;
                     i <
                       srcPix.
                         length;
                     i++) {
                    max =
                      0;
                    for (b =
                           1;
                         b <
                           bands;
                         b++,
                           i++) {
                        val =
                          (int)
                            (kk1 *
                               srcPix[i] *
                               dstPix[i] +
                               k2 *
                               srcPix[i] +
                               k3 *
                               dstPix[i] +
                               kk4);
                        if ((val &
                               -256) !=
                              0)
                            if ((val &
                                   -2147483648) !=
                                  0)
                                val =
                                  0;
                            else
                                val =
                                  255;
                        if (val >
                              max)
                            max =
                              val;
                        dstPix[i] =
                          val;
                    }
                    val =
                      (int)
                        (kk1 *
                           srcPix[i] *
                           dstPix[i] +
                           k2 *
                           srcPix[i] +
                           k3 *
                           dstPix[i] +
                           kk4);
                    if ((val &
                           -256) !=
                          0)
                        if ((val &
                               -2147483648) !=
                              0)
                            val =
                              0;
                        else
                            val =
                              255;
                    if (val >
                          max)
                        dstPix[i] =
                          val;
                    else
                        dstPix[i] =
                          max;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "37LL8/8Hc079GsQZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/BYv/cO7f/+tn3ruW/lp5f8CIFpSpo8kAAA=");
    }
    public static class ArithCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        float k1;
        float k2;
        float k3;
        float k4;
        ArithCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                       java.awt.image.ColorModel dstCM,
                                       float k1,
                                       float k2,
                                       float k3,
                                       float k4) {
            super(
              srcCM,
              dstCM);
            this.
              k1 =
              k1 /
                255.0F;
            this.
              k2 =
              k2;
            this.
              k3 =
              k3;
            this.
              k4 =
              k4 *
                255.0F +
                0.5F;
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            int srcP;
            int dstP;
            int a;
            int r;
            int g;
            int b;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    a =
                      (int)
                        ((srcP >>>
                            24) *
                           (dstP >>>
                              24) *
                           k1 +
                           (srcP >>>
                              24) *
                           k2 +
                           (dstP >>>
                              24) *
                           k3 +
                           k4);
                    if ((a &
                           -256) !=
                          0)
                        if ((a &
                               -2147483648) !=
                              0)
                            a =
                              0;
                        else
                            a =
                              255;
                    r =
                      (int)
                        ((srcP >>
                            16 &
                            255) *
                           (dstP >>
                              16 &
                              255) *
                           k1 +
                           (srcP >>
                              16 &
                              255) *
                           k2 +
                           (dstP >>
                              16 &
                              255) *
                           k3 +
                           k4);
                    if ((r &
                           -256) !=
                          0)
                        if ((r &
                               -2147483648) !=
                              0)
                            r =
                              0;
                        else
                            r =
                              255;
                    if (a <
                          r)
                        a =
                          r;
                    g =
                      (int)
                        ((srcP >>
                            8 &
                            255) *
                           (dstP >>
                              8 &
                              255) *
                           k1 +
                           (srcP >>
                              8 &
                              255) *
                           k2 +
                           (dstP >>
                              8 &
                              255) *
                           k3 +
                           k4);
                    if ((g &
                           -256) !=
                          0)
                        if ((g &
                               -2147483648) !=
                              0)
                            g =
                              0;
                        else
                            g =
                              255;
                    if (a <
                          g)
                        a =
                          g;
                    b =
                      (int)
                        ((srcP &
                            255) *
                           (dstP &
                              255) *
                           k1 +
                           (srcP &
                              255) *
                           k2 +
                           (dstP &
                              255) *
                           k3 +
                           k4);
                    if ((b &
                           -256) !=
                          0)
                        if ((b &
                               -2147483648) !=
                              0)
                            b =
                              0;
                        else
                            b =
                              255;
                    if (a <
                          b)
                        a =
                          b;
                    dstOutPixels[dstOutSp++] =
                      a <<
                        24 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "yfIzZfkfCh6PXLB4f3tRvCE+iy/ndX0m3bulfuB3vvJq4Suf/Wo5/Pl88ex0" +
           "GsnhXlkPF8UbC9kfuwimfTm2AF31JfY/3XBf+hroUQI9qiB+xFwE0H57bvId" +
           "Ud93///75V953bu+cA900IMeBPJqPbnEMegBACB6bIFAsQ2//R37mZQVU+tG" +
           "KSp0m/D7Cfh4+Xb/3X2tV6R7pyj4+N9zrvKeP/m725RQgvcl7nehvYS8+JEn" +
           "2t/2pbL9KYoWrZ/a3h4BQWp82hb7uPfXB2+++r8OoPsl6IZ6lHcLspsW2CSB" +
           "XDM+TsZBbn6u/nzeuE+Snj2JEq+/6P9nhr2I36d+B54L6uL5wcsg+0kAZ589" +
           "grXPXoTsK1D5QJdN3lSWN4vim8+4Zy2BDlboiT/fKKm+tSiGewO+447G7r5y" +
           "VsYvywp2GSuTrwMri5dlBb+MleXXgZVbL8tK9TJW3vWyrJTtt1euAOzCDonD" +
           "SvFuXD7YPQlYVKaKa4NodDUu13sF4tm+7B6z8ZjjqjePoVcA6z8wJW86LnEc" +
           "bm6UaFI4/+F+0XSB39q/ml+AFg+fdsYEYP31g3/6gd/64ae/CKY0Dd23KaYb" +
           "mMlnRmTTYkn6/S9+8MlXPf9HP1jmASBzFL73a0+8o+g1uoPUxaNTFKuiOBH1" +
           "iULUaZltM3KcjMoYrmsn0qJn5CESkAkE/wZpk+tv71fjQev4jxGkznI7Ryci" +
           "zBFxDDd4uGGnWXuXMWTUykllLrroUNQEVZRqKm3vJprL9VkvjwkHx3N8wzVB" +
           "u447GKx6Sdgdm4s5G4XhwJLW88EuXMvyMBnJiLzCG7KMoUu/OZKxhKXnaDJv" +
           "bmQVrjWRnMut4XSscnoTblSbPKKrjRqaEzUCtru77YylOXYiuWm2XU8WMeqG" +
           "5MiuS4Qw8nZJTKrzqO7PN5HSNBuUUNEGzRkZ5t1INNtbKenCFsjZZNrDhpLT" +
           "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");
    }
    public static class ArithCompositeContext_INT_PACK_LUT extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        byte[] lut;
        ArithCompositeContext_INT_PACK_LUT(java.awt.image.ColorModel srcCM,
                                           java.awt.image.ColorModel dstCM,
                                           float k1,
                                           float k2,
                                           float k3,
                                           float k4) {
            super(
              srcCM,
              dstCM);
            k1 =
              k1 /
                255.0F;
            k4 =
              k4 *
                255.0F +
                0.5F;
            int sz =
              256 *
              256;
            lut =
              (new byte[sz]);
            int val;
            for (int i =
                   0;
                 i <
                   sz;
                 i++) {
                val =
                  (int)
                    ((i >>
                        8) *
                       (i &
                          255) *
                       k1 +
                       (i >>
                          8) *
                       k2 +
                       (i &
                          255) *
                       k3 +
                       k4);
                if ((val &
                       -256) !=
                      0)
                    if ((val &
                           -2147483648) !=
                          0)
                        val =
                          0;
                    else
                        val =
                          255;
                lut[i] =
                  (byte)
                    val;
            }
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            byte[] workTbl =
              lut;
            int srcP;
            int dstP;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    int a =
                      255 &
                      workTbl[srcP >>
                                16 &
                                65280 |
                                dstP >>>
                                24];
                    int r =
                      255 &
                      workTbl[srcP >>
                                8 &
                                65280 |
                                dstP >>
                                16 &
                                255];
                    int g =
                      255 &
                      workTbl[srcP &
                                65280 |
                                dstP >>
                                8 &
                                255];
                    int b =
                      255 &
                      workTbl[srcP <<
                                8 &
                                65280 |
                                dstP &
                                255];
                    if (r >
                          a)
                        a =
                          r;
                    if (g >
                          a)
                        a =
                          g;
                    if (b >
                          a)
                        a =
                          b;
                    dstOutPixels[dstOutSp++] =
                      a <<
                        24 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "yfr/Bn3wA6aOKQAA");
    }
    public static class MultiplyCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        MultiplyCompositeContext(java.awt.image.ColorModel srcCM,
                                 java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcM;
            int dstM;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "0yyTTtvNEbewNIkJuuWS49otdGY11nDblzaYPrJRTBltxiSjBq2yvqIYeWHX" +
           "q10yrbMNHaypzYZYAyTANxVGow2qY5YNGI/9StNZTtoDDMuOHddf38nvnvyQ" +
           "e3TBAQ582Qv6dZx4klsPuLcbcFday8sl95yulR8vre0KKVB2uHv4dtcZ+cHu" +
           "Ux+68aLW/3Rp76AAJYOz/MEt005Odrp+x+1PsGx+lbOrinz5Q//yEP9u872v" +
           "oxL86KlJnhb5u+xLXyXfrv7GHnT2qEZy0yXTSaZrJysjl3w9jHyHP1EfefjI" +
           "rJczc1WBObEDsz5962rsLR11JnfUNh5OFffOHlS0Dgoe952qDw6VINzWmuJD" +
           "kodPkYx9K8xqmVvSfJD1a1QQ3581qxC65Pm6mt8CbMvPwrEglMChfO1a2i46" +
           "/R93Hj9RqwuhB2930XCoReF13FqA6HrwppvR7W2e+rkXL1984EXhr/Py/NGN" +
           "250MdNGIbPt45evY8wWgu2Hl5rhzWwfz8p/nQuiR155XCJ3Pf3M1nt1yfRio" +
           "ezuuEDoL2uPUz4fQm29FDSgPzXNA+eshdOU0JRg//z1OdwM4c0cH1uf24TjJ" +
           "x4F0QJI9vuAduuB1XRxhtgd2MF8/7c/kzEk8OYqYe39cxByDoCdPYEd+V364" +
           "zqPtbfl19fMv0r33vYJ+enufoYI0I82kXGSgO7ZXK0dY8fhtpR3KukA99erd" +
           "X7jzbYegdvd2wrsVfGxuj976FoFYemFe90//8IHff9dvv/itvD74v8KaEQPE" +
           "IAAA");
    }
    public static class MultiplyCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        MultiplyCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                          java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcA;
            int srcR;
            int srcG;
            int srcB;
            int srcM;
            int dstP;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcA =
                      srcP >>>
                        24;
                    dstA =
                      dstP >>>
                        24;
                    srcR =
                      srcP >>
                        16 &
                        255;
                    dstR =
                      dstP >>
                        16 &
                        255;
                    srcG =
                      srcP >>
                        8 &
                        255;
                    dstG =
                      dstP >>
                        8 &
                        255;
                    srcB =
                      srcP &
                        255;
                    dstB =
                      dstP &
                        255;
                    srcM =
                      255 -
                        dstA;
                    dstM =
                      255 -
                        srcA;
                    dstOutPixels[dstOutSp++] =
                      ((srcR *
                          srcM +
                          dstR *
                          dstM +
                          srcR *
                          dstR) *
                         norm +
                         pt5 &
                         -16777216) >>>
                        8 |
                        ((srcG *
                            srcM +
                            dstG *
                            dstM +
                            srcG *
                            dstG) *
                           norm +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcB *
                           srcM +
                           dstB *
                           dstM +
                           srcB *
                           dstB) *
                        norm +
                        pt5 >>>
                        24 |
                        srcA +
                        dstA -
                        (srcA *
                           dstA *
                           norm +
                           pt5 >>>
                           24) <<
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "so0aC0HJwkH2FfZIh5/8F9p3kaEvGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "HKwS6C7LK+/BU2DdN97ZuuXt9f6q6NlffOILP/LsE39X3uxetWJBirDIuE3d" +
           "88ycrz33pa/8ycsf/VRZG7ksS/Fe/YsF41vrwefKvKVu959Y635ob7LL7JG1" +
           "2P1NpPIt1uSkIIiReGvIkZ/GWoSwvqpxlrLWIk7yNOe49Pf/sUy2d82xHy8d" +
           "bYSTe62ns0tQGRnveLHNewIUVxzNM/bF07RofijITvhfqEG84vSKE3d8TysK" +
           "Icdj+/qf5R+e/H4ADGa3ldTbS1ou9pJD92xN430vMPZTRfOeBLpbKSTdK/YC" +
           "5M9k0IkF9ma442tJv30BXh8smhCYK4g0paybaifl0tttuctb31JPMTl6sRvM" +
           "c9WNBHr8RWu0xz6CX0LlF2z/h2/5dcn+FxHKp569dvU1z/J/vt+9x79auHcI" +
           "XdU3jnO2aHDm+Qqwhm6VBrp3X0IIyo9fSKDHXlgu4MTys1Tj5/ezPpZAD99p" +
           "FgAx0J6l/jiIz9tRA0rQnqX8lQS6fpESrF9+nqX7VALdd0oHdtH+4SzJrwLu" +
           "gKR4/LXg2AUvqfiOOYEpcZF2R8dml86fqycx9NCLxdCZo/iJcyhf/vDo+Lzb" +
           "7H96dFP59LMD9ge/3vrYviasOFKeF1yuAkDel6dPzszH78jtmNeV/pPffOAz" +
           "977x+HB/YC/w6Ul2RrbX3b4SS7hBUtZO8996za+/5Zee/ZuyxvK/qYNEyBEm" +
           "AAA=");
    }
    public static class ScreenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        ScreenCompositeContext(java.awt.image.ColorModel srcCM,
                               java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    int iSrcPix =
                      srcPix[sp];
                    int iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mrHEIAAA");
    }
    public static class ScreenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        ScreenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                        java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcA;
            int srcR;
            int srcG;
            int srcB;
            int dstP;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcA =
                      srcP >>>
                        24;
                    dstA =
                      dstP >>>
                        24;
                    srcR =
                      srcP >>
                        16 &
                        255;
                    dstR =
                      dstP >>
                        16 &
                        255;
                    srcG =
                      srcP >>
                        8 &
                        255;
                    dstG =
                      dstP >>
                        8 &
                        255;
                    srcB =
                      srcP &
                        255;
                    dstB =
                      dstP &
                        255;
                    dstOutPixels[dstOutSp++] =
                      srcR +
                        dstR -
                        (srcR *
                           dstR *
                           norm +
                           pt5 >>>
                           24) <<
                        16 |
                        srcG +
                        dstG -
                        (srcG *
                           dstG *
                           norm +
                           pt5 >>>
                           24) <<
                        8 |
                        srcB +
                        dstB -
                        (srcB *
                           dstB *
                           norm +
                           pt5 >>>
                           24) |
                        srcA +
                        dstA -
                        (srcA *
                           dstA *
                           norm +
                           pt5 >>>
                           24) <<
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "JRs1FoCSU4fYl9kjHX7+XwFjlXQrGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LA0mAAA=");
    }
    public static class DarkenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        DarkenCompositeContext(java.awt.image.ColorModel srcCM,
                               java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int sp;
            int srcM;
            int dstM;
            int t1;
            int t2;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                sp =
                  0;
                final int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYfWwUxxWfu/M3/sYfBLABY6hs6G1RQlVkmsY2NpicjWUT" +
           "qpiGY7w351u8t7vMztlnU6cBqYL2D4SoA6Rq/JejNFESoqpRW7WJXEVqEqWt" +
           "lBS1TauQSv2j9AM1qFL6B23TNzO7t3t7ZyMq9aSb25t58968r997sy/dRqU2" +
           "Re3EYFE2ZxE7OmCwUUxtkujXsW0fhbm4ejWC/3Hi1si+MCqbQLUpbA+r2CaD" +
           "GtET9gRq0wybYUMl9gghCb5jlBKb0BnMNNOYQM2aPZS2dE3V2LCZIJzgGKYx" +
           "1IAZo9pkhpEhhwFDbTE4iSJOovQGl3tiqFo1rTmPfIOPvN+3winTniybofrY" +
           "KTyDlQzTdCWm2awnS9Euy9TnpnSTRUmWRU/pex0THI7tLTBBx6t1n9y9lKoX" +
           "JliPDcNkQj17jNimPkMSMVTnzQ7oJG2fRk+iSAyt8xEz1BlzhSogVAGhrrYe" +
           "FZy+hhiZdL8p1GEupzJL5QdiaFs+EwtTnHbYjIozA4cK5uguNoO2W3PaSi0L" +
           "VHx6l7J49UT99yKobgLVacY4P44Kh2AgZAIMStKThNq9iQRJTKAGA5w9TqiG" +
           "dW3e8XSjrU0ZmGXA/a5Z+GTGIlTI9GwFfgTdaEZlJs2plxQB5fwrTep4CnRt" +
           "8XSVGg7yeVCwSoOD0SSGuHO2lExrRoKhLcEdOR07HwUC2FqeJixl5kSVGBgm" +
           "UKMMER0bU8o4hJ4xBaSlJgQgZWjjqky5rS2sTuMpEucRGaAblUtAVSkMwbcw" +
           "1BwkE5zASxsDXvL55/bI/otnjENGGIXgzAmi6vz862BTe2DTGEkSSiAP5Mbq" +
           "7tgV3PL6hTBCQNwcIJY0P/jqnUd2t6+8LWk2FaE5MnmKqCyuLk/Wvre5v2tf" +
           "hB+jwjJtjTs/T3ORZaPOSk/WAoRpyXHki1F3cWXsZ48/9SL5axhVDaEy1dQz" +
           "aYijBtVMW5pO6EFiEIoZSQyhSmIk+sX6ECqH55hmEDl7JJm0CRtCJbqYKjPF" +
           "fzBRElhwE1XBs2YkTffZwiwlnrMWQqgRvqgVodIyJD7yl6ETSspMEwWr2NAM" +
           "UxmlJtffVgBxJsG2KWUSon5asc0MhRBUTDqlYIiDFHEWeGbiWaZoaXC/Mn7s" +
           "YD8oxdUmUR5n1v9dQpbruH42FALzbw4mvw55c8jUE4TG1cVM38CdV+LvysDi" +
           "yeBYh6E+EBqVQqNCqIBKEBoVQqN+oZ0HMJ0mRu6/gxwoFBJHaOJnkt4H300D" +
           "CgAMV3eNP3H45IWOCISdNVsChuekHXnlqN+DChff4+r1xpr5bTf3vBlGJTHU" +
           "iFWWwTqvLr10CnBLnXZSu3oSCpVXL7b66gUvdNRUSQLgarW64XCpMGcI5fMM" +
           "Nfk4uNWM562yei0pen60cm327LGvfS6MwvklgossBXTj20c5sOcAvDMIDcX4" +
           "1p2/9cn1KwumBxJ5NcctlQU7uQ4dwSAJmieudm/Fr8VfX+gUZq8EEGcYkg7w" +
           "sT0oIw+Delw857pUgMJJk6axzpdcG1exFDVnvRkRvQ3iuQnCooInZTtkZ6WT" +
           "peKXr7ZYfGyV0c7jLKCFqBdfHLee/e0v//ygMLdbWup8PcE4YT0+OOPMGgVw" +
           "NXhhe5QSAnQfXhv91tO3zx8XMQsU24sJ7OQjTwVwIZj562+f/uCjm8s3wrk4" +
           "R9l83SrW0A2E7PSOASioA07wYOl8zICw1JIantQJz6d/1e3Y89rfLtZL9+sw" +
           "40bP7nsz8OYf6ENPvXvin+2CTUjlVdgzlUcmoX29x7mXUjzHz5E9+37bM2/h" +
           "Z6FIADDb2jwRWBsWqoeF5hsYekDs9NAEOJuUZ5WobHuFSx8SxIoYH+R2cazH" +
           "/3+BDztsf2rkZ5+vqYqrl258XHPs4zfuCKXyuzJ/JAxjq0cGHx92ZoF9axC6" +
           "DmE7BXQPrYx8pV5fuQscJ4CjCihtH6GAqdm8uHGoS8t/99M3W06+F0HhQVSl" +
           "mzgxiEUKokqIfWKnAI6z1pcekUEwy6OiXqiKCpQvmOB+2FLcwwNpiwmfzP+w" +
           "9fv7n1+6KWLQkjw2+Rl+RozdfPisdBSDnjMzCa07PNiiHfSiVmxsCNZNf9Tm" +
           "CaCobbXWRrRly+cWlxJHntsjG5DG/HZhALrhl3/9759Hr/3hnSJVqsxpTT2B" +
           "vIq05VWRYdHyeUj2Ye3lP/6oc6rvfgoIn2u/R4ng/7eABt2rF4TgUd4695eN" +
           "Rx9OnbyPWrAlYMsgyxeGX3rn4E71clj0t7IMFPTF+Zt6/FYFoZRAI29wNflM" +
           "jUiJ7Tnv13Gv7gWv1zrerymOx0XjKsQfBwMAWOsyKcIsgAERwSXiwkhzAEbG" +
           "sA09O1+ccEnaAiRfphrjkCdJxVkfXwNo4nwYZ6jKokQV/Q2BAOta4/5ItTQU" +
           "khmnA1cWGj+a/s6tl2VwB9v1ADG5sPjNT6MXF2WgyzvN9oJrhX+PvNeIk9ZL" +
           "o34KnxB8/8O/XA0+Ifvaxn6nud6a6645GlC0ba1jCRGDf7q+8OPvLpwPO2Z5" +
           "lKGSGVOTF6l9fDgqnbr/f0QxPtFnQc/YUryXdN256z7aUtBsQ8HVV17X1FeW" +
           "6ipalx77jQCB3JWqGtI5mdF1Xzb4M6MMgiCpCQNUy0JhiR/eBa19LoZKxa9Q" +
           "47TclYGb02q7GIrA6KcG0zQVowZK1zwO5RmG6oOUIF/8+umehKj26ABL5YOf" +
           "5CxwBxL+eM5yXXDgfm4GvbqVwqOUBP2ZDRVWIRFHzfeKI19d2Z6XhuJliIuK" +
           "Gfk6BK4LS4dHztz5/HOy/1N1PD8vLs8xVC5b0RyybluVm8ur7FDX3dpXK3e4" +
           "WdAgD+zh3SYfcvQB2lm8Om8MdEl2Z65Z+mB5/xu/uFD2PiT8cRTCDK0/7nsV" +
           "Ie/d0GploKQdj3lFzfcyTbRvPV3fnnt4d/LvvxcF3imCm1enj6s3nn/iV5c3" +
           "LEObt24IQtNIkOwEqtLsA3PGGFFn6ASq0eyBLBwRuGhYH0IVGUM7nSFDiRiq" +
           "5emC+WsSYRfHnDW5WX57YKijELgK71zQDM0S2mdmjISoNVAFvZm8tzRuccpY" +
           "VmCDN5NzZVOh7nH1wDfqfnKpMTIIKZ+njp99uZ2ZzBU+/4sbrxLW84FkJaRG" +
           "4rFhy3IhtrLXklmyKGn4PNyCu51ZDnghrwxeFeyuiEc+PPNfpGkPwJMVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "z4kM05EL7tyv12MZkTfEsABXwmmQsqNapbloKzxdCZrmusyYUcCOF7az7tBu" +
           "pd9dkzFakhvuzAySVG/q69ii1EK/3zV8etFP2pwEThfvyo4d117fye+e/JB7" +
           "dL0BDnzZi/brOPGkNx9wbzfgrrSWl0vuOV0pP15a2xVSoOxw9/CtLjPyg92n" +
           "P3T9Ra33mdLeQQFKBmf5gzumnZzsdP32W59gufwiZ1cV+cqH/uUh8d3me19H" +
           "JfjRU5M8LfJ3uZe+Rr9N/Y096OxRjeSGK6aTTFdPVkYuBnoUB654oj7y8JFZ" +
           "L2XmQoE57z4w6103r8be1FFnckdt4+FUce/sQUXroOBx36n6IK+E0bbWlByS" +
           "PHyKZBRYUVbL3JLmg6xeo4L4/qxZRtBFP9DV/BZgW34eHgvCCTiUrzxL20Vn" +
           "8JPO4ydqdRF0/82vGQ51KLyOGwsQWw/ecCu6vclTP//ipQsPvDj867w4f3Tb" +
           "dgcLXTBi2z5e9zrWPw80N6zcGHdsq2B+/vNcBD3y2vOKoHP5b67Gs1uuj0TQ" +
           "g7fiiqCzoD1O/XwEvelm1IDy0DwHlL8eQZdPU4Lx89/jdNeBK3d0YHVuO8dJ" +
           "PgGkA5Ks+4J/6ILG67k0wm3fVPqBftqf6ZmTaHIUL/f+pHg5BkBPnkCO/J78" +
           "cJXH25vya+oXXmx33/cK9pntbYZqK5tNJuUCC92+vVg5QorHbyntUNb51lOv" +
           "3v3FO956CGl3bye8W7/H5vboze8QKMeP8qr/5g8f+P13/vaL386rg/8LMf6w" +
           "GMAgAAA=");
    }
    public static class DarkenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        DarkenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                        java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int srcV;
            int dstV;
            int tmp;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcV =
                      srcP >>>
                        24;
                    dstV =
                      dstP >>>
                        24;
                    srcM =
                      (255 -
                         dstV) *
                        norm;
                    dstM =
                      (255 -
                         srcV) *
                        norm;
                    dstA =
                      srcV +
                        dstV -
                        (srcV *
                           dstV *
                           norm +
                           pt5 >>>
                           24);
                    srcV =
                      srcP >>
                        16 &
                        255;
                    dstV =
                      dstP >>
                        16 &
                        255;
                    dstR =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstR >
                          tmp)
                        dstR =
                          tmp;
                    srcV =
                      srcP >>
                        8 &
                        255;
                    dstV =
                      dstP >>
                        8 &
                        255;
                    dstG =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstG >
                          tmp)
                        dstG =
                          tmp;
                    srcV =
                      srcP &
                        255;
                    dstV =
                      dstP &
                        255;
                    dstB =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstB >
                          tmp)
                        dstB =
                          tmp;
                    dstA &=
                      255;
                    dstR &=
                      255;
                    dstG &=
                      255;
                    dstB &=
                      255;
                    dstOutPixels[dstOutSp++] =
                      dstA <<
                        24 |
                        dstR <<
                        16 |
                        dstG <<
                        8 |
                        dstB;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "SzdpLAAlpw6xr7BHOvzkvx9ig5crGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class LightenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        LightenCompositeContext(java.awt.image.ColorModel srcCM,
                                java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int sp;
            int srcM;
            int dstM;
            int t1;
            int t2;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                sp =
                  0;
                final int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "0mpEdAuTpAQzCVWXEtyPqdq8Waq6YmvW3ox8esKxxrrEm06U1OblWdrrEqw0" +
           "tKtjX6pJySZBw5qstvoLUuaHQ3CQqo0WQUVzlOem4Ibx7uzqce313f7uzC+6" +
           "R28c4NKXdfRex60nufGAe7sBd+m1PGVy5+l0+fH02i6ZAmUXvAdu9qKRX+4+" +
           "/dTzL8rMZ0p7B0koHtznDx6adnKyG/Y7bn6LpfPXnF1m5CtP/cv9k/cs3/c6" +
           "ssEPnZrkaZG/S7/0tc7bpd/Yg84e5Umue2c6yXT1ZHbkoq+EkW9PTuRIHjgy" +
           "66XMXDVgzmcPzPqRG2dkb7hQZ/KF2vrDqQTf2YOs1kHS4+5TOcKxEITbfNP6" +
           "kOSBUyQzXw+zfOaWNB8kfo0s4geywguhi66vSPlLwDYFzR1zwgW4mMeOLu+8" +
           "0/9Jd/IT+boQuvcmbw2HShRex7sFcK77rnsb3b7nSZ9/8dKFe1/k/jrP0B+9" +
           "ud1GQRfUyDSPJ7+O1c8D1VU9t8Zt21SYm/88E0IPvva8Quhc/pur8fSW69kQ" +
           "uu9mXCF0FpTHqZ8LoTffiBpQHprngPLXQ+jyaUowfv57nO55sJY7OrA9t5Xj" +
           "JJ8A0gFJVn3BPVyC9ut5OkJNdykMfeX0eiZnTsLJkcPc9ZMc5hgCPXYCOvLX" +
           "8sNtHm3fy69JX3ixN3j/K8hntk8akimkaSblAgXdun1dOYKKR24q7VDWefLx" +
           "V+/44m1vO8S0O7YT3m3gY3N76MYPCbjlhnnqP/3De3//Xb/94rfzFOH/Ag2D" +
           "Q9XGIAAA");
    }
    public static class LightenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        LightenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                         java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int srcV;
            int dstV;
            int tmp;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcV =
                      srcP >>>
                        24;
                    dstV =
                      dstP >>>
                        24;
                    srcM =
                      (255 -
                         dstV) *
                        norm;
                    dstM =
                      (255 -
                         srcV) *
                        norm;
                    dstA =
                      srcV +
                        dstV -
                        (srcV *
                           dstV *
                           norm +
                           pt5 >>>
                           24);
                    srcV =
                      srcP >>
                        16 &
                        255;
                    dstV =
                      dstP >>
                        16 &
                        255;
                    dstR =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstR <
                          tmp)
                        dstR =
                          tmp;
                    srcV =
                      srcP >>
                        8 &
                        255;
                    dstV =
                      dstP >>
                        8 &
                        255;
                    dstG =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstG <
                          tmp)
                        dstG =
                          tmp;
                    srcV =
                      srcP &
                        255;
                    dstV =
                      dstP &
                        255;
                    dstB =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstB <
                          tmp)
                        dstB =
                          tmp;
                    dstA &=
                      255;
                    dstR &=
                      255;
                    dstG &=
                      255;
                    dstB &=
                      255;
                    dstOutPixels[dstOutSp++] =
                      dstA <<
                        24 |
                        dstR <<
                        16 |
                        dstG <<
                        8 |
                        dstB;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "lRe3aiwCJaaPsa+wRzr8+L/Lf3usLRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xT977z/5/p997U+qMsv/BWZCPnYTJgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "S+pSVmLSpD1gvSq5WzzckfyTFZgLSyBYcPMfjX575J09r3MXrsGYyTuOJ14g" +
       "tjyTkWbLFl/AXwiuz/FCaXEDfyGXxOxp6bL8uBRf78q+p/kUiB5s+WDvg+ee" +
       "tBTwv5T5gOnho9/6InLfUSvLWDP3y4vG3l4ca+5uqYPLKyjd8nJcOEbPn08f" +
       "fP7Rg4fC9tk8DF6bVlWZCkrRgetkXqHZLVlv+WbTT4+0VPRA/oqTGlOR9pk0" +
       "nimM4WrDTHvOwR3TuxFtS402ZyS02nl75hHz/JcVMe1wpW23T08/YoJQy0fM" +
       "wnxhcgYysqqjPWXO8myZ0PkQl3cZqZeMVLx/OJXsim3HrZddW733JdhqMT5b" +
       "BZdpK2xO31ZBqD5tK9xm6QO+OFZrzVttkCoZit+OeiWFGZz1+TI2u4DLOUYa" +
       "RZ1C4Nof24oPI98leCG4ST/6f5g0x0iD96Uex0ltRd8LrW9c4lMnm2paT+54" +
       "h/cE+e9QDZDRxkxZ9g48PPdVmk7HJK5zgzX+0PjPRUbay08bGJnFf7nsn1lY" +
       "nzPSFoQF72aweqBDIUbmlYIGSMeUNmQllAw/JPDnv164akbqXDioFtaNF6QO" +
       "qAMI3tZrwfUo5GnHiCerzL/UseZRvHNpNAH/GuwkQtP6HpwST5/c1n/HhY0P" +
       "W3NxURYOHEAq9ZD+rBF9vmlaHkjNoVXVu+ri7KdrVzp5eY4lsBtml3k8HN5I" +
       "Qhr60yLf0NjoyM+O3z21+cVfHa56EyrKThISGJm7s3j+ltNM6FZ3JorTPDSY" +
       "fJrdueoH+29cO/a33/MJp10WFgfDp8S3H7n9rfvbTrWHSX0c3AxCN8cHg7fs" +
       "VwapOKmPkkbJ6M6BiEBFEuSCGjIbXV/AWOd2sc3ZmN/FryqMrCiujMXfoupk" +
       "dYrqW1RTydhVqN7dcZrngr7T1DQfgrvj6R7etAqX1ShUpBJ9muY0DrUrNR79" +
       "b/lLAd/kPtzOb/Fu6X8BPzYf9ikiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
