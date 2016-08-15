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
           "6Fnz6qqmn96Lnb0ovePEPUBfCaPtmfKT+yT3niCRAyvK7iy2pHkn77mOD9+X" +
           "Fb8XQef8wNDymZAP9dsOXfbOn8NleYSw4PnBnst+8H8TIacPgeHJg+IPc9IP" +
           "XsfYD2XFH4GAubqlf/x8LE0j6O5rXZPuj03hedy5Ari4+4r/dWz/i6B99Knz" +
           "Z+96avj3+eXiwf8Fbmahs2Zs20fP7Y/Uz4ARNa3c7pu3p/h+/vWJCLrv+npF" +
           "0I35d27Gn265PgnMvRZXBJ0G5VHqT0XQi69GDSj33bNH+ekIunCSEvSffx+l" +
           "+ywI0UM6ALjbylGSzwHpgCSr/oV/lePv7eVIeuoISO8FbD76tz/X6B+wHL3Z" +
           "zFyQ/2tnH4Tj7f92Lmsfe6rNv+nZyge2N6uarWw2mZSzLHTT9pL3AMgfvKa0" +
           "fVln6Ed+euvHb375/opz61bhw8lzRLf7r36fSTp+lN9Abj5115+9+oNPfSs/" +
           "jf8faCqHq04lAAA=");
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
           "73wYMy3Lk6cHfL/xrr9/fPE1+ttfQVHjDReEvMjyx6cv/dbwy+XvPYDuOTnu" +
           "u6Vwen7Qc+cP+R7w1TDyncW5o74nTsxaltWmwJzXj8z64O0LC7f12UEI3e/5" +
           "bqjKoaoU3fo+TC6cWb+qJH5V+Z87Ex7rELrHcEpHZ8DSb7qzpcuD9f0p1os/" +
           "8szvvuPFZ/6yPHS+agS86GP+5jYl2TNjPvfSpz/z+69+4uNl2eZeSQz2prhY" +
           "y761VH2uAl3q9uCJ5UpDXQOBOdtbbv8bQvL/sFwoeuBpKYg3ku8mgerDM1dR" +
           "aUPeqj4tOqp1XJX8/5gm3bvm2I+Xjsp9J0du70gvQWWUfOsd4uMERE7w44ql" +
           "Opt9XTcrmm/20hP+F8ojj56evuKW66hFjeb43r40abiHJ682gJvpbSV195KW" +
           "k91ezEulmLcN3bPllu+5y733F813hdBluZB0r9hdyD+YQicW2Jvhjn9L+vQu" +
           "vD5UND4wl+erclnSVU8qubdbcvfGrqGcQnXwxQ5Xz863N+jJEnik6MSAAR89" +
           "Ao9HXgF4lFaPb2v1e44qO0fOfs2FOhkjBuG+5vIjxyRPXCBZ+kZYhMSetJzk" +
           "o3ex4U8WzQ+F0AOnNix6fuDUTD/8SsyUhtDTX7TKfix65RXU7gFKPnbL+0H7" +
           "d1rkj7947errXuT+aA9yx++d3E9CV7XIss6Wfc5cXwEKa0Zpg/v3RSCv/PmZ" +
           "EHry7nKBWC9/SzV+ej/q50LosTuNAlgP2rPUvwCW8e2oASVoz1J+KoSuX6QE" +
           "85e/Z+leBh48pQNgs784S/IrgDsgKS5/1Tt2Qe9/4/WJ9NL5DOQkdB75YqFz" +
           "Jml55tweWL4xdpwZRPt3xm7Kn3iRmH3j55sf3RfzZUvM84LLVbBd7d8rOMku" +
           "nr4jt2NeV0bPfuGhT97/puM06KG9wKfL9oxsb7h9Cb1ve2FZ9M5//nU/81U/" +
           "+uKfl8Wx/wZhtOZRyicAAA==");
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
           "vzbdLGpOr1JqFMoVnpjNq8OAnkzHzVVRpBbLxJPYWbPbp8wp4xQVtzDgaSUc" +
           "9gHPr0wbL80mm3VZdVAsrC2KcKekhhiWHjuuv76T373ZIffofgMe+NIX3ddx" +
           "4klurXBvp3BXWsvKJfeeLpUfL63tCilIerh7+Ha3GdnB7pMfvPGSOvhUYe+g" +
           "ACXCs/zBJdNOTnq6fsftT7B0dpOzq4p86YP//NDk3cb7Xkcl+NFTgzwt8nfo" +
           "l7/Servy63vI2aMayU13TCeZrp2sjFwMQLQMnMmJ+sjDR269lLqrAk199sCt" +
           "z9y6GnvLiTqTTdQ2Hk4V984eVLQOCh73naoPjqQw2taaVockD58imQVmlNYy" +
           "t6SZkvg1KogfSBs/Qi56AVCyi4Bt+Xl6LAgFeCiPXVPdRWfw487jJ2p1EfLA" +
           "be4ZDo3IvY47CxhcD950L7q9y1M++9KlCw+8NP2rrDp/dN92Vx+5oC0t63jh" +
           "61j/PDRdMzNv3LUtg3nZz/MR8shrjytCzmW/mRnPbbk+FCEP3o4rQs7C9jj1" +
           "CxHy5ltRQ0rYHqf8tQi5fJoS6s9+j9PdgHO5o4PLc9s5TvIxKB2SpN0XvcMp" +
           "aL6eayPM8gyJDcDpKU3OnISTo4C58uMC5hgCPXkCOrKb8sNlvtzelV9XPvdS" +
           "l3n/q9VPba8zFEvabFIpF/rIndublSOoePy20g5lnW8/9cN7Pn/X2w4x7Z7t" +
           "gHcL+NjYHr31JQJpe1FW9t/8wQO/967feumbWXnwfwHIMMo/wiAAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "7IsaCz/JwgH2ZfZIh5/8F4rE8dYnGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYC2wUxxmeOxvj94uXediAbUh59K4koS0ypbEdGwxn+4SJ" +
           "pdjAsbc351u8t7vsztlnpzQJUoQbKYhQQmgVLFV1CkU8oqhRW7VJSaOSREkj" +
           "hZDSNA2kbdTSUlRQ1bQqbdN/ZnZvH3dnRNVY8tzu7D//zP//3/+aU9fRDENH" +
           "DVghATKmYSPQoZCwoBs41i4LhrEN5iLi0wXCX3de7VnnR0UDqDIhGN2iYOBO" +
           "CcsxYwDVS4pBBEXERg/GMboirGMD6yMCkVRlAM2RjK6kJkuiRLrVGKYE/YIe" +
           "QjUCIboUTRHcZTIgqD4EJwmykwRbvZ9bQqhcVLUxm7zOQd7u+EIpk/ZeBkHV" +
           "od3CiBBMEUkOhiSDtKR1tEpT5bEhWSUBnCaB3fJaUwWbQ2uzVND4XNXHtw4m" +
           "qpkKZgmKohImnrEVG6o8gmMhVGXPdsg4aexBX0UFIVTmICaoOWRtGoRNg7Cp" +
           "Ja1NBaevwEoq2a4ycYjFqUgT6YEIWupmogm6kDTZhNmZgUMxMWVni0HaJRlp" +
           "uZRZIj61Knj46Z3VzxegqgFUJSl99DgiHILAJgOgUJyMYt1ojcVwbADVKGDs" +
           "PqxLgiyNm5auNaQhRSApML+lFjqZ0rDO9rR1BXYE2fSUSFQ9I16cAcp8mxGX" +
           "hSGQda4tK5ewk86DgKUSHEyPC4A7c0nhsKTECFrsXZGRsXkLEMDSmUlMEmpm" +
           "q0JFgAlUyyEiC8pQsA+gpwwB6QwVAKgTtCAvU6prTRCHhSEcoYj00IX5J6Aq" +
           "YYqgSwia4yVjnMBKCzxWctjnes/6Aw8pmxQ/8sGZY1iU6fnLYFGDZ9FWHMc6" +
           "Bj/gC8tXho4Ic1+c8CMExHM8xJzm+1+5ed/qhnOvcZqFOWh6o7uxSCLiVLTy" +
           "7UXtK9YV0GMUa6ohUeO7JGdeFja/tKQ1iDBzMxzpx4D18dzW8w8+chJf86PS" +
           "LlQkqnIqCTiqEdWkJslY34gVrAsEx7pQCVZi7ex7F5oJzyFJwXy2Nx43MOlC" +
           "hTKbKlLZO6goDiyoikrhWVLiqvWsCSTBntMaQqgW/tE8hHzvIvbHfwnaGUyo" +
           "SRwUREGRFDUY1lUqvxGEiBMF3SaCUUD9cNBQUzpAMKjqQ0EBcJDA5gfqmcIo" +
           "CUpJMH+wr39jOwhFxcYBijPtU98hTWWcNerzgfoXeZ1fBr/ZpMoxrEfEw6m2" +
           "jptnIm9wYFFnMLVDUAg2DfBNA2xTFiph0wDbNODctLl3BOuZNzNuRLp6tkXC" +
           "re1bIj2tyOdjh5lNT8dxAFYchngAAbl8Rd+OzbsmGgsAgNpoITUEkDa6ElO7" +
           "HTSsSB8Rz9ZWjC+9vOYVPyoMoVpBJClBpnmmVR+CCCYOm05eHoWUZWeOJY7M" +
           "QVOeroo4BoErXwYxuRSrICOdJ2i2g4OV16gHB/NnlZznR+eOjj7a//Dn/Mjv" +
           "ThZ0yxkQ5+jyMA3xmVDe7A0SufhW7b/68dkje1U7XLiyj5U0s1ZSGRq9cPGq" +
           "JyKuXCK8EHlxbzNTewmEcyKA+0GkbPDu4YpGLVZkp7IUg8BxVU8KMv1k6biU" +
           "JHR11J5hOK5hz7MBFsXUPT8D8Lhk+iv7pV/nanScx3FPceaRgmWOL/Vpx375" +
           "1h/vYeq2kkyVozrow6TFEdgos1oWwmps2G7TMQa6D46Gv/7U9f2DDLNA0ZRr" +
           "w2Y6UrcAE4KaH3ttz3tXLk9d9GdwjtJu2YqnkQ02WW4fA+KhDBGDgqX5AQVg" +
           "KcUlISpj6k//qlq25oU/H6jm5pdhxkLP6tszsOfnt6FH3tj59wbGxifSfGyr" +
           "yibjQX6WzblV14Uxeo70oxfqv/GqcAzSBYRoQxrHLOr6meh+JnkdQfPZSjuu" +
           "AGdVp17FctxaZtJ7GXGQjfdQvZjao+9fpMMyw+kabu9zlFcR8eDFGxX9N166" +
           "yYRy12dOJHQLWgsHHx2Wp4H9PG/o2iQYCaC791zP9mr53C3gOAAcRYjXRq8O" +
           "0TXtwo1JPWPmr15+Ze6utwuQvxOVyqoQ6xSYC6ISwD42EhCY09qX7+MgGKWo" +
           "qGaioizhsyaoHRbntnBHUiPMJuM/mPe99ccnLzMMapzHQifDu9i4kg6f5YYi" +
           "UH2molDEw4PBCkMbtWxhjTeDOlHr2kBH9fmKHFagTe07PBnrfXYNL0Vq3YVD" +
           "B9TFp3/x7zcDRz98PUe+KjKLVHtDmkXqXVmkmxV/diT7oPLQ737YPNR2JwmE" +
           "zjXcJkXQ98Ugwcr8CcF7lFf3/WnBtg2JXXeQCxZ7dOll+d3uU69vXC4e8rNK" +
           "l6eBrArZvajFqVXYVMdQ0itUTDpTwVyiKWP9KmrVblD0h6b1f507HufElY8+" +
           "dnoCYKXFJAczTwwoY1zK3JUCNV5fKmpAVpeSEMRHzDr47vAucaI5/BEH1vwc" +
           "CzjdnBPBJ/ov7X6TWaGYmj0ju8PkAA9HfqrmInwCfz74/w/9p0enE7yerG03" +
           "i9olmaqW+p6OVkzThroFCO6tvTL8zNXTXABv1e8hxhOHH/8kcOAw9xLeGjVl" +
           "dSfONbw94uLQYQc93dLpdmErOv9wdu+PTuzd7zdj8RaCCiSza6U28mX8cLZb" +
           "5fyc93+t6scHaws6wf26UHFKkfakcFfMDcGZRirqsIHdSdmANE9M9U2QbyWo" +
           "lk5sd19uZAzN0hPff3vZ+Z8Y3/7981ypuWDkaadOHC8W30+e/8iSdzCD3koz" +
           "ECIzcvNfggb/T4X+EFaT0FCSBJSeQyRh9RGfJnsKgWX5AerQ4+R3mt56eLLp" +
           "NywFFksGhERwkRwtrWPNjVNXrl2oqD/DQm8h9TTTwu67gOxW39XBMytU0SFp" +
           "Gj0beotcKYBdXdkx8uQ7X3j3+JNHRjkEpvFHz7q6f/bK0X2//UdWHcHCdQ4X" +
           "9awfCJ56ZkH7hmtsvV1D09XN6eymDTRqr737ZPJv/sain/nRzAFULZpXRf2C" +
           "nKKV6QDozLDuj0KowvXdfdXB+/qWTHJY5I0Rjm291bvTRwuJyx9ruD18iMXt" +
           "8TxlBQv/BJhKiiCzdTsgicsMf/QtSgdds8scT93IK04qBxQRqoJp8Wp9422m" +
           "pAYyt1TwMZ2FDfrea4OH5/G76NDPzjNN1TkxzbfH6fAYiCbSc3ExpiF/IruQ" +
           "oxNtmqPm89kpM8GBnhnkvK+M8MFpdn6SDn2gSk3HIuvecaZpZwsiZi6gP1D+" +
           "FY6oEne8dXTYxj+s/x+rVVNIaMhvd3tgmXXVHVxJgOPXZV178qs68cxkVfG8" +
           "yQcu8dhjXaeVQ8aPp2TZCWzHcxEoKS4xvZVzmPM8Mwl97/TnAiSwXybGMb7q" +
           "WwTV5VsFSRRGJ/UUQDoXNVDC6KQ8TlC1lxL2Z79OupMEldp04Hj8wUlyGrgD" +
           "CX08o1km6L6TW6FWWUsIYR3ntW3al92AMGjNuR20HC1FkytosxtxK42n+J14" +
           "RDw7ubnnoZuff5a3/qIsjI9TLmWQTvgtRKaoXpqXm8WraNOKW5XPlSyzioAa" +
           "fmC71F3ocLE28FqNNmYLPA2y0Zzpk9+bWv/SzyeKLkAuGEQ+AfxxMDtIp7UU" +
           "dDODoew6CoI069xbVnxzbMPq+F/eZ71ddvLz0kfEi8d3vHOobgo6/LIuwKgS" +
           "w2mWPe4fU7ZicUQfQBWS0ZGGIwIXiKOuIq2S+o1A78qZXkx1VmRm6cURQY3Z" +
           "ZWf2dRv0waNYb1NTSswsAsrsGddVvemLpSlN8yywZxyVwRCPX7wUK4iEujXN" +
           "qspLejQWgRL5Y+zL7JEOP/0vWxcTHS0bAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "pO3uQjY8vd1eOiitlCbZMnJ7etTWx4HfZznCxiWEcCZNkmUipoPSWUucW1ip" +
           "tZks+OnWH/l80BlgTifwXJenSxiGLSZuuQFeQuecOFcng0VzNOMnauj79Y5P" +
           "hEKySNc0E/axiTKomlW9PuEriE524LHniJlHl9SJZTUlGMY9eGRtWEMsb1N7" +
           "1ihZ21G7lro8rjbbZWatGfPmEkZQxbbUCtcUKHNrNbhyVBGZHr1qydPearAd" +
           "rgVsiBKkky6zMasmLiFvh+1SuWcvp/i6vgh6FC/aQbPP6Wgn5Tl0ONpUbGRp" +
           "cgOSrlQGDWMybBhZc9TpRgI3ZVEcpQy7ZG6aAQ97ksfIaa07lVWJ1t35hIL5" +
           "IK01GxUD3izUVdW2t7yfgfc0hO0Siu5HFX+euEFU7TXZ0UxC8DrS28BNkNar" +
           "OE6N22WRDpPqAuFCuU3UhxJZi+OsFguU3VJaPSWx4sG6ulh59qxcnc/rWrs0" +
           "NPBOD9dXQqM94/WhzDl9JrAQG4ZXzqra8DmYRCy3EShGalNTJI6yaKJ5MdIF" +
           "pK1GK1n2UlNjtN423JpLayYg82zp8JU6l6p+s+yn2moD91ZyO2M6C9qfpSFJ" +
           "TULEVY3SwLOVmTYVGWu9bvcUPqg0u3KcSmI8aPaE3szSlNlGtCS/1NKC0Wib" +
           "lGxpuW5lTlemURXv9lKhNa4gyHZBbytVZTIgZ9Rcj0gyrc6DOtma9mC/as4W" +
           "mIQ1W5Vs2nLDRg2r6ZN2W6YXlkCv0EmZFeLErwym86kbVholUUXWcbKebdIJ" +
           "v135MyRlFhjSZxK8XiUMbFFurYRmaaT3hnN/1ZNM38yMaCv5JL30Yq9DcuZ0" +
           "NFiPYHeqtlqy7FHZCLyIZOTM1PB1y6zbOqI1FguTI6uu7+BEUp92MHu0jOep" +
           "YbEqPnHIsGp3yJbmDsmupLNquTnteKEmLMZUmV/VFjzeabHdoAanzUzGQTCh" +
           "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" +
           "1b4TJgAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "yIYr/wWkgZHjghwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "EORkahD9TOkwBGFtarGGYhtvo8UWTVHDejCiq8SiywfqzMIdtcJ2yJEhqb4U" +
           "K1wcS1UT2qBjtOs+SZVwXXclme4S4/E2E2Uwq0XEwFvOs9SKBKfnVbwu41JV" +
           "gQZ6H8o7UDliNhNHpfF4RTaiUjAd8/SuGgCw6NHV5rCB1hpVmyPp0WzZbshm" +
           "t0/Uw002mHfqbG2Lo/Zw0wsrfrwRML4X1l1e2OiDOVmuKKm4W8H0UW0KccU0" +
           "Sg4jor0sqIk4V+HTDaFSrr5OqKCbJQ2UIt2uIFeYbSRKZDLecNNltxvLZLQq" +
           "1ad6ZxZkI2bio9qQaveDnelRbH+xZH1xZtpoFjJMmduWVk6QbTJJ6bJpTa23" +
           "gIqimqD10JkVRuEQli1kvb0slYVFuKG36qQBnbCcrbrOmKiM1Z4TtupoKIPW" +
           "LLXWUj+tVEVO7k5FYlqlhhlWQ1254pvNhrpZCpsVP28Cd8k5bhQMt81JsiMm" +
           "xIJYJwu2lDmLxMwDRSf6052GmfOWivVqIxSNKVBbCUOJt7erihh1hjPcIlW/" +
           "XKuCJmdTOCEYK3EoLjqMTaLxkK+ls06yMMSeGGtmV0FR3UU7xppyZMWX24QG" +
           "+rTS2nWWsVteD1aoSbQrHeiO4iIeJmF1WmsZJN9DtfU6qIbmSJNbRnknSA13" +
           "ltTClr+u+oxergI/2jUwiebxxJWrsbVxJrzfAWy1O+rExC6x0V3PN1fCjGDV" +
           "cQoaPS+csGGV3sQVYj5m+5wfcARnDJlyNahvumaM+YxXG5Zjk6fWUdlZcXQS" +
           "k5WMpiabvgbjfjwJskjXNHNNJbM2a+heNAjcycgCbXRJW9oarbir2UCT2TBV" +
           "ttiyJxo10huNF5XE4kULJbcoa3U6YnW5GXSm6/q451RRGERsWacai6YglTGD" +
           "9Ta4z5PrpTCv21x1UxGDrN6dgJGWplJf9rRRuWNVxt0NhhkVFKNn/q6eaTtz" +
           "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");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ZOHw+gp7pMNP/gt2gCiNIxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "w87PwGOg3SdvrN385Hp7TPTMbz3xtZ9/5om/y091zxmBKPuYP79Ot/MIzvef" +
           "e/G737jzoefzvsjpmRxsxT/ZJr62C3ysuZvLdseBtu6Atio7TW+1tb2GkPJj" +
           "duJk1w2QIJrPfCcONB+hHVVjDWWl+axsa+Z+w+//Y5lka5p9O57aC4SDM62n" +
           "k1NQ7hnvfrngPUgUZ03Nnm9bpnE2vNNNDuif6D/ce3i8iZuOrWVNkP25be/P" +
           "cHYP/jUAJpPrcmpvOc0Xe8Wue7Sf8cGbzP1yNrw/hM4oGadbwW4CfjWBDjSw" +
           "VcMNH3P46Ca0PpINHlCX62tK3jPVDlql1wu505FjqIc52X+508tjnY0Qeu1N" +
           "OrP71oFfQacXBP4D1/ybZPsPCOX5Zy6cu/+Z0V9u43b/Xwq39aFz+to0j7YK" +
           "jtyfBXrQjVw1t20bB25++c0QevjmfAHz5ddcjN/YYn0ihB64ERZIX2A8Cv1J" +
           "4JnXgwaQYDwK+bshdPEkJFg/vx6Fez6Ezh/CgfjZ3hwF+T1AHYBkt59z900w" +
           "eCXNdsx0FzLrazc0bHLq+I564D33vJz3HNmEnziW3/M/Gu3vdOvtX42uKJ95" +
           "hqTf8VL1E9tOsGLKaZpROQdS8bYpfbBbPnZDavu0zvae+uFdn73tyf1t/a4t" +
           "w4d72BHeHrl+/7VtuWHeMU3/8P7ff9NvP/OtvLPyv9Qe3QIBJgAA");
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
           "TAbUylIpEnaj0nrUWfkhPaaJaklb2EpatdoVYHeLIBjKHGw2VWbe4jSKW62M" +
           "ONr0xz5VHmlDMjUmQyYgEiwtUZuyji90YQCiy+fRlltDbd3t+6zD1zYcy4uS" +
           "jQ6wJOxZojGbuRvaDXR5Ml/wTElGZMEqdsTlQIhccWb1xoXGQPRQWYITlWCE" +
           "Di+sN3psJgKxILG0vZy18FE77fOIq3AreOBISxoryxwpmcupaCZ9thFLUbct" +
           "YoU6smG6dmcWDroKh7S0xVDpcVy6SiQeR5dY4DeEqj1Ex0snCvypMPFnaUFp" +
           "rgWHJVazTZujOUToJs7QdPWlRCrJsDjvoCTeJvxAT/TJnFl4AY0x3bYkzpZO" +
           "ualPdaNTXHbIhT8e6BhuElKimKlVCmdTHl9WGX6JLgaI2JQxz5FmA6OgS21h" +
           "Nqab+DwtstHIXHQaEaGmDZlxKhI5HDaZmkx5PrepozLrT1qsXrTafJeqdjvy" +
           "hJYb6tCK1biEtnByMdVXhrkcwAXGD3VELdPzdSgpkuAMVzJXbPGmSdtJ4quT" +
           "BqwEI629LLVCaz5v20JhFclG2p2qJlNGm2tv7cnciMYnjaSiEf2OHadRYRTz" +
           "wniu11yeR5SUJBXWc60NSyEDDB0sWgQ3qq+YUkLqiAHzhRBL1VXVbVa5ZEFZ" +
           "zLjkyJ5CtARx5sOzXpcJOMzyHMHeyMYM8bnWRJih1bRM8gSLFice6YQNsmKw" +
           "cHvsWSJTlPk53iPk4toctTw5LoXNYdMm2ulckGeLmiHzZWTg6L2mUbTJ1iBJ" +
           "VsY8xpiE7TP8lF5okVARSQKRMF6oBiuVSkQYkSlVqi8Nz+w2mRTuuxuUi8bs" +
           "QGD7ZNUdidVyZIdR7LI1YSFPxus5zw3WhWaxO+AtvYk3hREO+gNrsejNh43i" +
           "hGv38SRwSL2TTmCj6XJxUx4yGDYjmsoQIZYJWtPs6oZo0xxQHPOQ/mjDT0oe" +
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Y9EnkT++vsIe6fCT/wLOId40JRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "e72u60jLwO2vnGp9VFbbfRwvOfWks5pY3ZIwl1ecOVmOphpbR/u8iOBdtksO" +
           "VKG8RMrdMcqWq6RmY7bvMFysIkgZ7W07M3xLtNoazTZprsL3mRbSYJztimwt" +
           "4VVrFtD8pL0Mg2W7mVhBCTVpnZbXJhom/kgrL2y3HyR0vVxJNAQmSTWSQm6z" +
           "0fjU3pTrY6beGIxxPDNVJ3JxRq7XjX6DdFw2U3WdLW+GCzQTlKYVYKhGW6Y+" +
           "7Aa+n3aZRDI7uLVw6/MeFoTVadSFUUWhlT69mvo64yJpi7Fitk1OVx6SuaOh" +
           "RdZqStqLZV8aJ6uJLKBd362J27HarYgpmsohN1nx9fZKQrGlwqtUqBkLjYjq" +
           "zFLNGqXW0nVVJVpvogHCMALfCRy8Vu5YWBLY6tIW15RXDZeGUpoO+sMgagcM" +
           "TsbRWjbGaE3SGbYyMyZx1J2QnfXI4dA6LLmVAdyKvETn6xRu1Dtsm0DUTbvG" +
           "SXwZd4fZhA4DXB8PmGQ9mxOj5qIaUmirPmZnlerUZc1WazbImhqjokYpcLxB" +
           "tG6k9JC2e7Lou6t0Qth0JpItnJhSnKVIE92UKXzRMMMxHbgaxvKMy7iE0FMI" +
           "0RfVnkFOHaKyEW1QiIybTXM9rY4kAd+OaX3br2dzpbdc26ZUXk3YtrvuTbk5" +
           "rqpbUxSMDjPiY0kQiXnYVxYt3LUmpdI6otSGhk3gdMBQClLucxH4Yfra1+Y/" +
           "Wa89v1ODu4oDkqMG2cpG84n+8/i1nN14wb3jBY+PZYujtrvO9lpOHsseH8JB" +
           "+cHAAzdrhxWHAh9++5NPKcxHKnsHh5diDF046FIe08lPZl5189OPYdEKPD5R" +
           "++zb//n+yeuMNz6PLsJDZ5g8S/K3hk9/vvdK+Zf2oFuOzteua1KeRnr89Kna" +
           "pVCNk9CdnDpbe+BIrZdzdQ2BOj9zoNY/vPFJ/g0Nda4w1M4fzhwMv6AAeEHx" +
           "PD3hB4sYusV0i3PwFGj30Ztrtzi93h0VPfUbj3zpLU898nfFye5FMxKksB3q" +
           "N2h5nsD5ztNf/9ZXXvjAM0Vv5PxSinbin+0VX98KPtXhLWS740hbd0A7lZ0f" +
           "7bS1u8aQ/CO24yTfj+BorS9DL43UEB55isqasqWGrOSq9mHX7/9jmWxnmkM7" +
           "njsIhKNzrSeyc1DhGW/7YcF7lCgu2Kqr7/qmaT682c+O6J/pQdxzfMSJ2Z6r" +
           "5o2Qw7ld/8/09o/+OgAmsxty6u44LRZ73q57sqfxnueY+8V8eFcM3SrnnO4E" +
           "ew7wJzPoSAM7Ndz0sYBfPwet9+dDANTlh6pc9E3Vo3bpjULu/NozleOcHP6w" +
           "E8xT3Y0YetlztWcPzVN6Hv1eEPn3Xfefkt3/IORnnrp88SVPTf9yF7iH/1W4" +
           "fQBd1BLbPtkvOHF/AShCMwvd3L7rHvjF5ddj6MHn5gvYr7gWYvzaDusjMXTf" +
           "zbBA/gLjSeiPAte8ETSABONJyN+OoStnIcH6xfUk3DMxdOkYDgTQ7uYkyO8A" +
           "6gAkv/2Uf2iC4fNpubdt35DYUL2pYbNzp7fUI/e5+4e5z4ld+JFTCb74u9Hh" +
           "Vpfs/nB0Tf7EU/3Rm77b+MiuHSzb0nabU7kIcvGuM320Xb78ptQOaV0gH/v+" +
           "nZ+8/dHDff3OHcPHm9gJ3h66cRMWd/y4aJtu/+Alv/ea33zqa0V75X8BMemm" +
           "eAcmAAA=");
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
           "4Af+s28u3v/3/3GDEXLcucm2fIpfgF/66IPkz34v598BQMb9SHIjZINcbseL" +
           "fNL6t70nzv/5HnS7AF2WDhLFiWius7ASQHIUHGaPIJk88f5korPd1a8eAdxD" +
           "p8Hn2LCnoWe3VYB+Rp31Lx5Hmx+Dzxnw/Z/sm5k7e7DdXu8hD/b4x442eddN" +
           "zpwJoXPIfnW/mPE/nUt5PG+vZM1Pb5cpBKnwemHqIJrOB3mWCrhU3RbNfHA8" +
           "BG5mSlcOR5iArBWsyxXDrB6Gy+XcpTIL7G9TvS3kZS2ai9i6BXZLF7q6pcr3" +
           "trt2whgHZI0f+IcPfuXXn/w2WNcOdC7KbA6W89iI7DpLpH/1pQ89/Lrr3/lA" +
           "jmNg55u8983/mqcl7C20zrqtrKGypn2o6oOZqqM8R2DEIOzlGKTIubav6s6c" +
           "r1sAoaODLBF+5p5vrz763U9tM8DTvnuKWHnu+q/9eP/563vH8u4nb0h9j/Ns" +
           "c+980q8/sLAPPf5qo+QcrX/8zDN//LvPPLud1T0ns8gmOCR96uv//ZX9F77z" +
           "pZskL7eZzv9hYcM7zXY5oPHDDzOZL5B4nCRTdQ2z8KJTDw2SwhtDrSGIJDoc" +
           "mJPVdNVlDXFu00iLnCJ9zWLXixqGKlQdtQQkTTFxhYsWWV+yZAlvjVi1uuo2" +
           "kbHW1bxSSwhpz6V5sVs0ha7OUivGkwecO6sPlhvPbCP6InJtIZLRRb/cd0od" +
           "INuCrXQWpXCEKhaKJi3PQ7qKoxPOOqHm0TwYUw1j2vJW8Ag3LLRK92KzNA6G" +
           "MF0z2KKCaqUWixsTO+ARfe4GPXE85JDYHnvDFRKXhW611SKLdtqmyDHiTPpz" +
           "URSHg15QVFLNxgTPC4bNlOcNgh6nhkeM06E/GdtuS9PiVsOeNcv6qNN31nGX" +
           "idTWWGS9qdFTCgNHLcyJSJtwFtdaIYMNmszRZbeLWhY2dqWgZKpLkWFNz+b4" +
           "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" +
           "AA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NQY/ifwA+yp7pMNP/gszkzMOJxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "gdory8uCjRSvEXrVVNsDuqcZ1SDFYHOMzieKPV3PyM5Uz8p1CdcajjUhh6Wm" +
           "Q5G1dFWr624ZK3kIyQdBOFelzEVDo23UlmwdK4l6VV56TaW9GFdB/dIf9uAG" +
           "IQ/mk43XI3tewrGuF8fVDoU7frVUbzLjWYuhpbrsCSWJ43Ss1E4bPuWV8bJd" +
           "btJKOPQr8yZRHfaqK3o8Xc4qilTbuF7HtXVTqWKLwKya6ZqB6+BFASmJUrvt" +
           "zEbCuDyA3S3bM1YrlaA0ur7uCYndCJCmXZlY+NZK6kYHbEk4X+uo2/aqU9fK" +
           "QjJuDbKRLuEBPReSddyXB1GFbazr81kTbdlis1ZyTItAmSyqYP6qrlcXs1WX" +
           "60SIq2urXq3VsGO95Rhpf0xgUU1qs6W22HU9WjNdbZHKYbXZ9BaiUJqwvuIt" +
           "Cbc0Z+PhTBMoICM1nSOoxAetyoIcbSxL4Gprrdn3OdoJYh6n5vy62l7aXadX" +
           "J4EeXNmSCV5ddQm8X5FboSxW0rUe4YuSmbSkeU1TS4us3NVJoylVYlL29FUs" +
           "l+J22BQpezXoBmqr2vTRBlb1liVDCGxn3O+PlnyEeUyIe3U6pVrthQLeTSY1" +
           "VLREsy6XR/ykshhYs8qsvakkvcFigUi80N9GoG6Je+rEjFOLloSw38RLiTRC" +
           "NknW77EI2iU2Is655sbUNGs24OewoSdYaes23P6Ag5dBtsn6QzoNwIvp616X" +
           "v7Jee2GnBncXBySHHbK12cgn6BfwtpzefMG9owWPjmWLo7a7Tzdbjh/LHh3C" +
           "QfnBwAO36ocVhwIfecdTT6vDjyJ71w8vpRA6f71NeUQnP5l59a1PP/pFL/Do" +
           "RO1z7/jn+8evX73pBXQRHjrF5GmSv9N/5gu9Vym/sgfddni+dkOX8iTS1ZOn" +
           "ahd9LYx8e3zibO2BQ7VeytXVB0a+4/pp97mbn+Tf1FBnCkPt/OHUwfCLCoAX" +
           "FfeTY34wD6HbDLs4B0+Adh+/tXaL0+vdUdHTv/XYl9/69GN/V5zsXjACUfYx" +
           "f3mTnucxnO8+841vf/XFDzxb9EbOLuRgJ/7pZvGNveATLd5CtjsPtXUntFPZ" +
           "2cFOW7vfEFJ+zH6c7LoBHMTLhe8kgebDA0fVOEPZaD4n25p50Pb7/1gm3Znm" +
           "wI5nrgfC4bnWk+kZqPCMt/+o4D1MFOdNzV7uGqdJPrzFTQ/pn+pB3Ht0xImb" +
           "jq3ljZCDuV3/z3D2D/87ACbTm3Jq7zgtFnvBrnu8p/He55n75Xx4dwidU3JO" +
           "d4I9D/hTKXSogZ0abnlbwMfPQ+sD+eABdbm+phR9U+2wXXqzkDsbO4Z6lJP9" +
           "H3WCeaK7EUIPPG9/9sA+pRfQ8QWhf98N/yrZ/RNCefbpSxde/vTkL3eRe/Bv" +
           "hTtY6IIemebxhsGx6/NAE7pRKOeOXfvALX5+M4QefH6+gAGL30KM39hhfTSE" +
           "7rsVFkhgYDwO/THgmzeDBpBgPA75uyF0+TQkWL/4PQ73bAhdPIIDEbS7OA7y" +
           "e4A6AMkvP+0emKD/gprupruSOV+7pWHTMyf31EP/uedH+c+xbfixExm++MPR" +
           "wV4X7f5ydE355NP04M3fq3901w9WTDnLcioXQDLetaYP98tHbkntgNZ58okf" +
           "3PWpOx4/2Njv2jF8tIsd4+2hm3dhu5YbFn3T7A9f/vuv/e2nv170V/4XvhG8" +
           "hQkmAAA=");
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
          ("H4sIAAAAAAAAALVZe6zjWHn33NmZnR2WndlZ9sHCvgeqJfQ6cRIn0VAgseM4" +
           "jvOyYydxWwa/Yjt+PxI7hm0Bqd1Vkba0HWArwf4FaouWh6qiVqqotqpaQKBK" +
           "VKgvqYCqSqWlqOwfpVVpS4+de2/uvTOzaFU1UhzH/h7ne/3OOd956fvQuTCA" +
           "Cp5rbTTLjfbVJNpfWtX9aOOp4T5FV0diEKoKZolhOAHPrstPfuHSD3/0Ef3y" +
           "HnRegO4THceNxMhwnZBRQ9daqwoNXdo9bVuqHUbQZXoprkV4FRkWTBthdI2G" +
           "XneMNYKu0odDgMEQYDAEOB8C3NxRAabXq87KxjIO0YlCH/oF6AwNnffkbHgR" +
           "9MRJIZ4YiPaBmFFuAZBwIfvPA6Ny5iSAHj+yfWvzTQZ/tADf+Ph7Lv/uWeiS" +
           "AF0yHDYbjgwGEQElAnS3rdqSGoRNRVEVAbrXUVWFVQNDtIw0H7cAXQkNzRGj" +
           "VaAeOSl7uPLUINe589zdcmZbsJIjNzgyb2GolnL479zCEjVg6wM7W7cWEtlz" +
           "YOBFAwwsWIiyeshyh2k4SgQ9dprjyMarPUAAWO+01Uh3j1Td4YjgAXRlGztL" +
           "dDSYjQLD0QDpOXcFtETQw7cVmvnaE2VT1NTrEfTQabrR9hWguit3RMYSQfef" +
           "JsslgSg9fCpKx+Lz/cE7nn+fQzp7+ZgVVbay8V8ATI+eYmLUhRqojqxuGe9+" +
           "G/0x8YEvPbcHQYD4/lPEW5rff/8r7377oy9/ZUvzplvQDKWlKkfX5U9J93zj" +
           "zdjTjbPZMC54bmhkwT9heZ7+o4M31xIPVN4DRxKzl/uHL19m/mz+gc+o39uD" +
           "Lnah87JrrWyQR/fKru0Zlhp0VEcNxEhVutBdqqNg+fsudCe4pw1H3T4dLhah" +
           "GnWhO6z80Xk3/w9ctAAiMhfdCe4NZ+Ee3ntipOf3iQdB0BXwhR6EoLNPQ/ln" +
           "+xtB74F111ZhURYdw3HhUeBm9oew6kQS8K0OSyDrTTh0VwFIQdgNNFgEeaCr" +
           "By+yyhTjCDZsEH6Y5TsYMCozW93P8sz7f9eQZDZejs+cAe5/8+nit0DdkK6l" +
           "qMF1+caq1X7lc9e/tndUDAfeiaB3AaX7W6X7udIcOIHS/Vzp/nGlV2ducPTn" +
           "ADagM2dy/W/IBrQNPQicCSAAgOPdT7M/T733uSfPgpzz4juA1zNS+PYYje1A" +
           "o5tDowwyF3r5hfiD/C8W96C9k2CbGQEeXczYRxlEHkHh1dNFdiu5l5797g8/" +
           "/7Fn3F25nUDvAxS4mTOr4idPuztwZVUBuLgT/7bHxS9e/9IzV/egOwA0ADiM" +
           "RJC+AGkePa3jRDVfO0TGzJZzwOCFG9iilb06hLOLkR648e5Jngf35Pf3Ah9f" +
           "yNL7TSDP336Q7/lv9vY+L7u+YZs3WdBOWZEj78+w3if/+s//qZy7+xCkLx2b" +
           "9lg1unYMGDJhl3IIuHeXA5NAVQHd370w+o2Pfv/Zn80TAFA8dSuFV7Nrllcg" +
           "hMDNv/QV/2++/a1PfXPvKGmg5KRtF17FNqDkrbthADyxQMVlyXKVc2xXMRaG" +
           "KFlqlpz/dektpS/+y/OXt+G3wJPD7Hn7Txawe/7GFvSBr73n3x/NxZyRs/ls" +
           "56od2RYk79tJbgaBuMnGkXzwLx75zS+LnwRwCyAuNFI1R6293PS93PL7I+iN" +
           "OeeuLoFkN+i7iprPEXAe0v2c+On8+tOZXw68l/1Hsstj4fHSOFl9x5Yn1+WP" +
           "fPMHr+d/8Eev5EadXN8cz4S+6F3bJl92eTwB4h88jQOkGOqArvLy4OcuWy//" +
           "CEgUgEQZ4F04DAA6JSfy5oD63J1/+8d/8sB7v3EW2iOgi5YrKoSYlyB0F8h9" +
           "NdQBsCXeu969TYI4y4rLuanQTcZvc+eh/N9ZMMCnb48+RLY82RXwQ/85tKQP" +
           "/f1/3OSEHHduMSuf4hfglz7xMPbO7+X8OwDIuB9NbkZssJTb8SKfsf9t78nz" +
           "f7oH3SlAl+WDdSIvWqusrASwNgoPF49gLXni/cl1znZSv3YEcG8+DT7H1J6G" +
           "nt1MAe4z6uz+4nG0+TH4nAHf/8m+mbuzB9vZ9Qp2MMU/fjTHe15y5kwEnUP2" +
           "a/vFjP/duZQn8uvV7PJT2zBFYCW8kiwDVNP5MF+kAq6F4YhWrrwZgTSz5KuH" +
           "GniwaAVxubq0aoflcjlPqcwD+9uV3hbysms5F7FNC/S2KXRtS5XPbffshNEu" +
           "WDR++B8+8vVfferbIK4UdG6d+RyE85jGwSpbR//ySx995HU3vvPhHMfAzMd/" +
           "4C3/mq9KBrexOrslsksnu5CHpj6cmcrmSwRaDKN+jkGqklv7quk8CgwbIPT6" +
           "YJEIP3Pl2+YnvvvZ7QLwdO6eIlafu/ErP95//sbesWX3UzetfI/zbJfe+aBf" +
           "f+DhAHri1bTkHMQ/fv6ZP/ztZ57djurKyUVkG+yRPvuX//31/Re+89VbrF3u" +
           "sNz/Q2Cjuy2yEnabhx+an0tIzCXJdLGqDQfSdLOQxrGt9YvwGJlqUbFN8QLh" +
           "te0k7OOmtNmIxSHjD1dSsVou9BrlKY+kS1QyNdHEou4II9okO5hVTLRv8kzP" +
           "8C1CiuaWzExd1hMRjqD5gV9t9WAeR1vp1OXWfisCiWMrZWktIWlb4NFiWI5S" +
           "KalKDRQul1cp3WhgpYlAODKj9SdC1J6sp1KtyUw6CFuLhonEFDorkUGpOQ3L" +
           "amrXh5XYN23NMzaIXmJCM+4M0I5Z0yZuMUakOdc1G5O2IdYSQ08wodhejgaD" +
           "FuV60/moaiQKl3KI0JtTVGpgIrMpzfuia4Vu2l9p8bynLXFDYZK2za1l0nKW" +
           "us+1SwFiDBY1drSuo6V448XOBhHd4ayCTZCulaaMYkxDBN1Y42hQ3DRUKylP" +
           "xwlnY0kbdldJPCYrtXVvQuNepILs2FRtu8JRvI3jfcoap0nFinxrZDpjmZHK" +
           "wsIrmzVq5LIMS7kFrjB3RbTiV8et+djvDiZ8yR9ixVRmu1U46Fc4NB3y3Bx1" +
           "6uNmEtEd3pjPvRT3QkaeShrXD+WyzNtFUsA5fuUJgt1LkWQm+HVZhKtqq81N" +
           "ej1XmMNxpadvME1otjvUxOTciag2Bp5pohqhDeURJ7q6w0fJmij6KDLoVJdW" +
           "vEBW04Vulg2K24yYsDWrtMtTXRXYeeR7MtNUZ3W/XnPVVlKcqTOvt+Tkymio" +
           "zelip4X2BZwkHalni8VuXBwXVviw4qLKsthr0a3SdI7GAWFy/JTX7DYW9U2m" +
           "KHXjYJ600GRpjHkvHGsUqw/m4aYqiUiI+0CLzTII25TM8arJT5V+c7KII7zX" +
           "pRytRVTFNoyxaVoo62tFHnY4ud/vuq2OMmyXZk61VB/aqYvbRYHSrSamss3y" +
           "wN7Qs7oYlJfagtGMLh+LXUoujtaOVDMZRMEKja4dcLzYRK2JjvGUMqvyg1EN" +
           "hX1UKS4q/akbFRtipV4Mi0TJRCp+WiSwpGkTPLF04qRqVFbLUS2si2qBhSsi" +
           "s57ifnteasziYcXXicFsOPX0IeokRntuSqyGGsPO0CyEE7RrhUQ6w4ddB0e4" +
           "jWK0cbHrz7iUt4dd2MY0nKYNCl0RQj/t2QUk0S19NmqNQ73U9BalbnXstVbU" +
           "Ek4slDJAOQ/aMesig/6AY/wl1ZBkfkzFHIKLgYfhPpVMpJTod8fy1ASV1xn2" +
           "NVaoEA7lVQ3Dm+ONTbRkYKms8ZQsMfQS5F2jvOG4VbcSeGZX748K6HxEByYu" +
           "kxO8NBCJnpIuFki5XCkVhEqfpir9pcPNVd1oJ/5kbLeavtvqtRMX3BMNt1RS" +
           "+tN1uoyb854+n9QHTkVDZ15cbjLNZqcVj+HFvB2rI6dR5zTBSD0/aKJeUuSK" +
           "ZoSuB3Gszcoe6UfRjLArFUSRKjzDZ3XvzaxQrtKbUgXFfcyaLPVqWcCw3orj" +
           "jRgpzMNOQOI8D7AvnPqJOyQSP+UsrDBJcGlSGUqGs2TFMJyZmu/o9WhGFVG5" +
           "MAkaFYVZ0eOCTJF8s1OqF2KdbLAUqsR84jL0AqVtySmhtcUgKLZ7PbNC66XQ" +
           "jp0SQkz67R5WNW0fSSWtVB2snWGFBbWKtzryvK/VmuGk77ox21StOK7WAk4L" +
           "u4JZEOPUU+ROQ01pfOqsWyazMsrGalzGXE9wqoTXTZnS0HC9xToIehV7WMNJ" +
           "ThXidsTQZKXoLUvlTgMuqDKp046y0unSYMws9dEMzCRxKiZTt6T2iNqU6GGD" +
           "VkMhZ+a0DstDR+ESLBlLvYoZdlejUWvW1Ke4LdWStB4OR1I9WeDJYkm2+J4i" +
           "Rsp4KY/DiKu1TJCgBt4CQQz64xHGhZE77HETx4Rhw64JhUWwoJcM3SiEcaUo" +
           "jZZBmNaH0hot8qP1bBE6VQSbcEuLUrTU4mRbniFEUjbX3swQHXQQV93hUGjA" +
           "nbTYIZoEi0SMaWj4POSbdTrl5VSh4DnKtSkZB0C58ZiSM6estOIaLS4ZhXhU" +
           "sYwRDNcNsibN4WjsppPqgqnyHF2qwd6I7FIIrBKmz0f2pMC2lhjv1vujZTWk" +
           "x3itYbSKpNxCiJWmzlrLghgMC3JTrlAutsT0VkSi3abfnbIrsuP61UWj5ivr" +
           "YBIUFhpLtEpYQ1rRxWZr7hlDV2u4ttJi49W0WYe77kAzTIUIS03eYq3FICQb" +
           "IY1udDhKCb1fsBeWXoAX5TXeKo/rrEbN7LAxGdWdllGuq2RatNr9TlitY2sP" +
           "UekWQRd0IlCW87axEWFfi9pci0kQqrFUl1Q1hIepz41GUmOi6IXIk0rYqDbB" +
           "AjhFy2lhNFuU8VXC9/hueWKVXUxlALb3TGOM0ot6FQ9dVKAXcMKUysv1mhmP" +
           "R5FStRK6BaN1Epfm0UzHMKbs1GoEPCXJiqvCsSqGJKphCE4TAA3XjgLza55F" +
           "SKbcdzfcYM5ZSM2v8yGvE11sJqWtkjpOl2zXGuhqgyzwankMvgWrAsO1nkrE" +
           "SWDSdZltNrV2cWXGQb+pa+M2Hxu0uwnxPt7t0aI+V1UaE1SzW8Q3gugmuGOz" +
           "PJWW6uy0SYU22Z9LPs15XFGpjzEaX1EsOuL7UasrWEXEhi1luCbbjUIVTND9" +
           "mo2tSaNpVxEVLvBOGPtxXyFtHeETxIPxtSnIoqxQtqhMRpXWEKuV4YqFrlsU" +
           "wkyQRuAog7lk+MUSEw97A6NaojHCqLTh2WQNVxJl5MRuVSDtqStGNFfFSv4g" +
           "qQ9ZdLEqMA1m2YaL06iZBv5yzNJ+oUxWRjhru5EUhEUjXIsrP5AbpAjUkAuj" +
           "P3ZJA5jbktMVCJEg9+CAdbXxsiu26VrLMi16ROJTFLPSOj+OFhovehtuBVOx" +
           "UPJCothnOqMyN6dUhI2YJioEpDtJCY4cjtsrlp6lsGImOEvqxaY/S2OzGrdq" +
           "Jo6R9YYYaGukLK+Uea+xEhbtLsURMGHSFsWBKMl+rSV01n4nXm04MumELJHQ" +
           "Sb09psq6ZOMxqqwWBaKKLDbe0EOFtrKwh4RrFxpNI+hUZYtaA8uFZqOK2KWC" +
           "j6wwZ9zV4FBTSiKJpMVmxAhrnF1jEtNVLDXhYC9ehAVpneqLekyYhVKbi3Uc" +
           "ZcrFdVdlBx3YD0cDNnXLnbW7tlS3ku32FjWk0R/V5GUdXqjGahny8qBsNNpO" +
           "qaBFI3gYsCjYT9eF+Whsa6LIU12XDAblpRItW1TJNISxi0hlooB14/YMLxiY" +
           "nzJrcTOJhUlfYdrF+iwlCiDXwkrVjsN03QuaxaG0sToB3O8SjtLkXKlkl02D" +
           "Hmt9q0iFnjqBl7wv1oUxh6j4gOBrIo9Wq1wjLSqw7BClUGt65IYaOjVkU0jq" +
           "vrUswb1GuMbpedpUWJPURFYWSbq/Jko1v01JA5OP6FiVNEwCK6Ch4hPrlldh" +
           "JKxGt2rV+jCBmyxJzVxjQIybzWzbcf217fzuzTe5R2cbYMOXvaBew44nubXC" +
           "vZ3CXWstb5fce7pNfry1tmukQNnm7pHbnWTkG7tPfejGi8rw06W9gwaUAPby" +
           "BwdMOznZ7vptt9/B9vNTnF1X5Msf+ueHJ+/U3/saOsGPnRrkaZG/03/pq523" +
           "yr++B5096pHcdL50kunayc7IxUCNVoEzOdEfeeTIrZcyd1WBO0sHbi3euht7" +
           "y0CdyQO1zYdTzb2zBx2tg4bH/af6g4wYRtteU3xI8sgpkmlgRFkvc0uaK1m/" +
           "Sgfx/dnFj6CLXqDK+SnAtv3MHUvCOdiUr11D2WVn8JP24yd6dRF03y3OGA4N" +
           "KLyGswqQWA/ddB66PcOTP/fipQsPvsj9Vd6ZPzpnu4uGLixWlnW86XXs/jww" +
           "e2Hknrhr2wLz8p/nIujRVx9XBJ3Lf3Mznt1yfTiCHrodVwSdBdfj1M9H0Btu" +
           "RQ0oD91zQPlrEXT5NCXQn/8ep7sB4rijA6W5vTlO8nEgHZBkty94hyHAX8tx" +
           "UdPydHEUqKfjmZw5CSVHyXLlJyXLMfR56gRs5CfkhyW+2p6RX5c//yI1eN8r" +
           "6Ke3RxmyJaZpJuUCDd25PVU5goknbivtUNZ58ukf3fOFu95yiGf3bAe8K95j" +
           "Y3vs1gcIbduL8pZ/+gcP/t47fuvFb+Wtwf8F3qSUGbogAAA=");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NBZ9koXj6yvskQ4/+S+230DDJRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1af+zrVnX3+/a919cf9L22/CgdbaF9ZSphXyeO88MqMBLH" +
           "ThzbiWPHcZIxHo5/J/79Mwl0A6QNNCRgW2FMgkqbYGOsFIaGNmli6jRtgEBI" +
           "ILRf0oBNk8bG0OgfY9PYxq6d7+/3XlGFtki5sX3POfecc8/93ON78vR3oQtR" +
           "CJV8z94Ythfva+t4f2nX9uONr0X7fabGyWGkqbgtR9EYPLumPPzpy9//wfvN" +
           "K3vQxTl0r+y6XizHludGvBZ5dqqpDHT5+Clha04UQ1eYpZzKcBJbNsxYUfw4" +
           "A91xgjWGrjKHKsBABRioABcqwK1jKsD0Is1NHDznkN04CqCfg84x0EVfydWL" +
           "oVedFuLLoewciOEKC4CES/n9BBhVMK9D6JVHtu9svs7gD5TgJ3/tzVc+cwt0" +
           "eQ5dtlwhV0cBSsRgkDl0p6M5Cy2MWqqqqXPoblfTVEELLdm2toXec+ieyDJc" +
           "OU5C7chJ+cPE18JizGPP3anktoWJEnvhkXm6pdnq4d0F3ZYNYOtLj23dWUjm" +
           "z4GBt1tAsVCXFe2Q5fzKctUYeugsx5GNV2lAAFhvdbTY9I6GOu/K4AF0z27u" +
           "bNk1YCEOLdcApBe8BIwSQ/ffVGjua19WVrKhXYuh+87ScbsuQHVb4YicJYZe" +
           "cpaskARm6f4zs3Rifr47eN173+r23L1CZ1VT7Fz/S4DpwTNMvKZroeYq2o7x" +
           "ztcwH5Rf+rl370EQIH7JGeIdzR+87bk3vvbBZ7+wo/mJG9AMF0tNia8pH13c" +
           "9dVX4I9ht+RqXPK9yMon/5TlRfhzBz2Pr32w8l56JDHv3D/sfJb/89nbP6F9" +
           "Zw+6nYIuKp6dOCCO7lY8x7dsLexqrhbKsaZS0G2aq+JFPwXdCq4Zy9V2T4e6" +
           "HmkxBZ23i0cXveIeuEgHInIX3QquLVf3Dq99OTaL67UPQdA94Au9DIJumUDF" +
           "Z/cbQ2+GTc/RYFmRXcv1YC70cvsjWHPjBfCtCS9A1K/gyEtCEIKwFxqwDOLA" +
           "1A468pUpZzFsOWD6YWHSxYFRudnafh5n/v/5COvcxivZuXPA/a84u/htsG56" +
           "nq1q4TXlyaRNPPfMtS/tHS2GA+/EUA8Mur8bdL8YtABOMOh+Mej+yUGvTr3w" +
           "6OYANq5Rg/E1roXT0LlzhSIvzjXbxQCYwRXAAoCSdz4m/Gz/Le9++BYQfH52" +
           "Hrg/J4VvDtb4MXpQBUYqIIShZz+UvWPy8+U9aO806ubWgEe35+xcjpVHmHj1" +
           "7Gq7kdzL7/r29z/1wSe843V3CsYP4OB6znw5P3zW76GnaCoAyGPxr3ml/Nlr" +
           "n3vi6h50HmAEwMVYBnEMIOfBs2OcWtaPH0JkbssFYLDuhY5s512HuHZ7bIZe" +
           "dvykCIi7iuu7gY8v5XF+FQT89CDwi9+8914/b1+8C6B80s5YUUDw6wX/I3/1" +
           "lX+qFu4+ROvLJ/Y/QYsfP4EQubDLBRbcfRwD41DTAN3ffoj71Q98910/UwQA" +
           "oHjkRgNezds8wMAUAjf/wheCv/7mNz769b2joIHWp2279Dy2gUFefawGABYb" +
           "LL08WK6KruOplm7JC1vLg/O/Lj9a+ey/vPfKbvpt8OQwel77owUcP395G3r7" +
           "l9787w8WYs4p+cZ27Kpjsh1a3nssuRWG8ibXY/2Orz3w65+XPwJwF2BdZG21" +
           "Ar72CtP3CstfEkMvLziPFyiQ7IWsp2rFZgEXU7pfED9WtD+V++XAe/k9kjcP" +
           "RSeXxunVdyJPuaa8/+vfe9Hke3/8XGHU6UTnZCSwsv/4Lvjy5pVrIP5lZ3Gg" +
           "J0cmoEOfHbzpiv3sD4DEOZCoAOCLhiGAqfWpuDmgvnDr3/zJn770LV+9Bdoj" +
           "odttT1ZJuViC0G0g9rXIBAi39n/6jbsgyPKouFKYCl1n/C527ivubgEKPnZz" +
           "9CHzPOV4Ad/3n0N78c6//4/rnFDgzg225zP8c/jpD9+Pv+E7Bf8xAOTcD66v" +
           "h26Q0x3zIp9w/m3v4Yt/tgfdOoeuKAcJ40S2k3xZzUGSFB1mkSCpPNV/OuHZ" +
           "7e6PHwHcK86Cz4lhz0LP8ZYBrnPq/Pr2k2jzQ/A5B77/k39zd+cPdtvsPfjB" +
           "Xv/Ko83e99fnzsXQBWS/sV/O+d9YSHlV0V7Nm5/cTVMMUuJkYVtgNV2MimwV" +
           "cOmWK9vF4K0YhJmtXD0cYQKyVzAvV5d243C5XClCKvfA/i7l20Fe3lYLEbuw" +
           "qN80hB7fURV7213HwhgPZI/v+Yf3f/l9j3wTzGsfupDmPgfTeWLEQZIn1L/4" +
           "9AceuOPJb72nwDGw803e/ui/FunJ4CZW55dk3nTzpndo6v25qUKRKzByFLMF" +
           "BmlqYe3zhjMXWg5A6PQgW4SfuOebqw9/+5O7TPBs7J4h1t795C/9cP+9T+6d" +
           "yL8fuS4FPsmzy8ELpV904OEQetXzjVJwkP/4qSf+6ONPvGun1T2ns0kCvCx9" +
           "8i/++8v7H/rWF2+QxJy3vR9jYuO7Pt5DI6p1+GEmMxzJxPXa0YbrdImhyVSb" +
           "Wz2d76zrZKU/suOV4LCNgbkcYsZqTGPLVrRQqrVK0owbabSNbdffjjhaoQck" +
           "MfKoxYi2A69uCpQmqoIXqsHKJ8m+Fwj8yFmOB62wTCykMtmeiAO5QiOwoDtq" +
           "dbHGynNxLEkcozRKzSbchGEYa8AO1hPLGdbhZ8FmRLXdcdTuRSJhEuVWWVnU" +
           "FDLDjKFS6a0dgTHDRpJiwbbq1aj2pF8Wl90az/Zw1xxKKDtryX1FNAyrb3mZ" +
           "vhySZb686LYxvtsWaG9jDOcUb6v0ajPhqbgS9Mghrq8IztsGbYJEaH/kJqy5" +
           "GlXaVneFjmeCSMfVqBnPJiM/iIPZWG0YVBer6nRXpKdRatQ7cpOsmXzLsi1B" +
           "6GV+vy0tqboUIH4ztkZhnzK2fseYuo4azKgYnYo12jHrabJYSqgmxGJGRhlP" +
           "iqPVeItZ3c5E1DKdyIKQdIeIoLCpbIZ13GJpPyParIiTycJ0OmOiuw4EKR5n" +
           "mhNG/f4QwAjb6/bXdEwSmoXjdujMZYpKfCJDiOncQck2PR6485nfRuTJXGYc" +
           "aWgRpbRjVmpzV4/xsuTNjc5EIDydm6GUucGzzajlkbRqSR1VRquE0iu3K7hp" +
           "NTqlRKCIdOkH07Aj2RQhGvK2W/JNse4M5M2WkyqqwVfag2U5JuwpZ/mqYXQY" +
           "fW7xq9nIXLlSymysaeRzrDFjVkQbY8etpDOcklSTwe214c/RCcLbnW5Gtmyj" +
           "zqKTvhhVkomcUSzVC4YivxrxKxob9co2ToB3dwJv9SScNPmV4EoxrtEZSwlL" +
           "sk9oibGE2yRvj9tkGRfJbdoVWKJi+oai0p00VhqYnTVx0o5K/R63NLc9Ktpw" +
           "0ybJkGEkLUaDfgMfZiMYzSJ/gsocXu0rDtwy2k0+41hZr1V9Na2GqtPU3elQ" +
           "qeJcR8CiRWXWJ8k1bS+wbcAgtpYw9Q5JD1RpFHCkulqyqVUzdRAnMt+3atKs" +
           "UZ5hnbrWayxMHuFclpnCtNXEaxIV+Otha9YIeOBoYcxIA4Qg6xnTbgo10QQq" +
           "DeFUM6UFrlRMge3D8VgYsWPGH0XKxhHsMdKxfLrVSgLP7aO2LxDyshK2Vs6m" +
           "hm66BB30dLCmPblfWnMNlCl3G6PyqmKKQ5zGLcHzZlayCu1BmRopEm0gyMhr" +
           "B4beMe1AMhTKtHmMxketjs/MYKKFiWvDpoQVWTPgCiZhQbve9ZCOSSnyHKsv" +
           "41VAbba8Wy6JXNMKYY5BO9piMnaGmGyi/UFVUvRBhBHlITP0WN+dUYixWbRT" +
           "xxktZj7wRSbP23HX5ZOua44qCzadxxalppNoWZ7LSEOxXLSpzjszrKsoLanX" +
           "ms0MgkCbwURfJEijb3u0wWSyzJFer0YjCU8LSQXJGNzSyVFzUmlW0mS7QWwd" +
           "CzoWWzck3m9J85pvSvrIsuytGQ1d0+4M6IkL8GsYUt3xVKvTCYW26QqOKNxK" +
           "DILhrF8dEtvxIlN6tKzyjREqboW4sQXvyT3ehGMdtrZ6wlf7WVCvjTaUMuVr" +
           "JrWoLtoGp7UGBBeilXa9VtKHDU+PxSEpN9jZZsq6/YloWrN0wmwDaxaEtuGl" +
           "vA3LPaQdMOhgNDZAQM4swWpUGgne5631dBIIG5vqtfHKZIiPO9h8aKGuMCmr" +
           "saTMzCSdNZFNixfsynbUQevU0Akbfb3kSgkfqbUex4rzNepLgwU68zEE7qsp" +
           "DBOa76Bhpo5Q2mNLY9JTRrPyJkB0M2jWu43pTJ3VO40muVzJZUznth2KbUXi" +
           "Vl8hnQHOlwxhRgzGzdIwbVRDbKNpgcCh8dbu9ZjJMhgsmE4fT6MZ0Yptqz0T" +
           "GYrokRRu232ccKiNz8FIOE9dmYSxZtSXF1N0Nse3lXCRH0P6sG6atZoC6zq5" +
           "ZRHO7zkzO54MzBXXZAbRNkDqjLflFWSkpeoSxVSNQGutgOpki/LSdAhV53hO" +
           "2W74iHIiTEKWBDmkozomBFIVm61XWIOxiEGUUnqwVkearjfx3ny2GMdqptVK" +
           "y5gKaHPTUINhADf1/qDvC42By1reJB1JyyVaZ1pWq7R1NZGbziOSasUIVqvG" +
           "SCUK3UXW67W0ljcKMkRzJSpsr6aL1TbojgcwpgShAmtNER03XdlUJt4E9Ztt" +
           "heiLbSzs8iaNK+VFrdzL9DZNTEiGZye1kaWz5V4c4QJsjmOh6xBIV4dL6RBL" +
           "hh2y5kjkCN1m0tB0tbUyn6icwQ7WQnuzZFUjo7SesZbIQeDNR2mYDtyxNQmn" +
           "bYD2DDk2omE/qofEcgX3tBq22LDBWJuO+fKIqDQBpMG6FaONgZrWWHvSl+S2" +
           "7GBUVLaWNBqXoybDLZ2RPjHhUnXUxEdIpbpadbzqkFn4rWU9NUYriRRRampx" +
           "zdhf6pUg06XBZruurgxL1KZTf64HegNrJ4uJZ/VgeUvXpJXhb32EQfy1bIpI" +
           "ZdwVm5k3WTVrIjtXva0dwACuKt36prRujEvbdLse4qVE54R1ec22gk3Z0eZm" +
           "bbZqkWgF5Bam4DX1UGBHw03iCzjVqVmVqF3lYZki0B7Fr9ezJsxGaI/fjj1Z" +
           "a/SwtFFJWTyYig3SnfeEWU/rLDfipjxFeQ5tNnuwXjJgbhyoKDNZ6Yt4XsYb" +
           "g0k4FrGqUFZ8T6rglZbcgzFbI92w1jBbrhHqRnPtLpebNa63jbKGgpdtJOg4" +
           "LlvtJqhc5klUGSalpW+vkCpeSfnSTN2WqhiqpM12unaYeN0X+/2VSjcknikl" +
           "vQgrB7WS1oTrUYXb+uIUG/UbsUYK8ZCO8dIgKfUTnEXL5WW319GyZGPIK02i" +
           "gwXabwZlvKJ2abeEUEsZsSQ3XZaGmyiBB0u0kmA6SoSD9mbA0dXphqdddKSF" +
           "OF+Tm0bFLU/8pE30Hd6Bm8KAM2E6pXtRP8DnPrXy9JFCrZzQhI0yMmEpBm+y" +
           "IqVo/Qaswtyis2oi8ExwskmHMvoUzdS6ttuT4sRlapuG1J+glZWkeYnv11aS" +
           "Gjc7NWZRC5O6Ksndbsdyx3XGHUklnm5pW3nj1Xkfa2Awi3Fcb1K2iYHRdeFy" +
           "2E3Reb2paKVNFW5aPlWx0G0ytNxU7HgqxzHOUtcoJI6R2EuWwWgjVWcjmkOQ" +
           "MOZ8veEsNmEt4OFBj8ArnmsPKjhMyZNg3vE6w84wTWhqE0wHsFpZb5o+QNG+" +
           "p5JVc2kig/kiHcdY3LdQmOkOkeawJw0yjam0pYhrcwbtrPBOfxFniZCw24zH" +
           "MEsdtEA2vl1XKKSJBvxm1O6atG9IITarVp05LS/bjVEm6uzWnXnDEjZwTbQX" +
           "lphOWo24wUB0eW6s9xK845U6Mk5h5FpddlPKVbKoNoy7zlDySm6tvFmttx4i" +
           "EkmJ9Si1vNk2K4NyvTWYyEtPkrRkGK3LDWndqihZDzN0OtUIYZIMh7HfHCCw" +
           "0+vAFSt2VhTeoOXGcNFmk9QbhhbTqvPxJlymNXJeQdWQdtRBY9UqweukO1C9" +
           "ygSPV6XVXF315Ujd4oLhUeOuOpnSVHOdbfFxNcWGCk4ybb0fzddpEizaHVGU" +
           "DLFPEjMX48etId+siCzj+Z11W6SRKZHO3bRcr4uZMEGqY0Pltm1hSnWTFtvX" +
           "x5tQEhZe6nMLj5zPhczjezyAUlaeItUsk1ik1pMzpSEKWxrBt061FZog35tO" +
           "TZHraDVf00ynhjWWoY551oZdVtiEnLfpUqtCxEFbm/j4Yi3Hq2bTX1SU0pRZ" +
           "KLTR8UszJmWnmpmF20UmUWVkPoqa2wXBb7gF1ShjscbZLrERp9SoyVJ+s5Uu" +
           "rVm33tpKpld3wGvQwiiTrblfaQjlMN12EUWsWsy6lKUWWm1OXd8r0TbRSDVO" +
           "zbK2WsF4XjUmlLvssJGCoSAEGy3UM0oGHbnehm3xxiglRFJrT1ZVjA/a1RqR" +
           "pf4yCKOQK5c9y/DjjcDCWtCZhoYob6qBtLIX5qxF6jJbR0MNY6ebmJ7XyNjY" +
           "LgPfsFglmXqzCa9wquPMJ7Wu2Bi059jKmy7rmzRajVC4JJSQarnT6fMReDF9" +
           "/evzV9ZrL+zU4O7igOSoQLa0G3lH/wW8La9vPODe8YDHx7LFUdvdZ2stJ49l" +
           "jw/hoPxg4IGblcOKQ4GPvvPJp9Thxyp7B4eX8xi6eFClPJaTn8y85uanH2xR" +
           "Cjw+Ufv8O//5/vEbzLe8gCrCQ2eUPCvyd9inv9h9tfIre9AtR+dr1xUpTzM9" +
           "fvpU7fZQi5PQHZ86W3vgyK2Xc3exwJ1vOXDrm258kn/DiTpXTNQuHs4cDN9R" +
           "ENxR3Isn4mAWQ7dYbnEOngHvPnpz7xan17ujoqd+65Gv/PxTj/xdcbJ7yYom" +
           "ctgKjRuUPE/wfO/pb37nay964JmiNnJ+IUc788/Wiq8vBZ+q8Ba23XnkrTuh" +
           "ncvOD3be2v3GkPJjluNk34/gKDUWoZdFWggPPFXjLGWlhZzsavZh1e//Y5j1" +
           "bmoO5/HcwUI4Otd6Yn0OKiLjHT9q8R4BxUVbc41d3TTLm7f56yP5Z2oQ9x4f" +
           "ceK252p5IeSwb1f/s7z9o78OgM71DTV1d5oWg73g0D1Z03jf8/T9ct68J4Yu" +
           "KLmmO8Oeh/zJNXTkgZ0bbnpb0KfPI+uDeRMAd/mhphR1U+2oXHqjJXc+9Sz1" +
           "GJPDH3WCeaq6EUOveL7y7OH0lF5AvRes/Puu+0/J7n8QyjNPXb70sqfEv9wt" +
           "3MP/KtzGQJf0xLZP1gtOXF8EjtCtwje37aoHfvHzmzH04PPrBeav+C3M+I0d" +
           "18di6L6bcQH8Au1J6o+D0LwRNaAE7UnK342hK2cpwfjF70m6Z2Lo9mM6sIB2" +
           "FydJfg9IByT55Wf8wylgX0jJvWX7psyF2k0ndn3u9JZ6FD73/KjwObELP3IK" +
           "4Iu/Gx1udcnuD0fXlE891R+89bn6x3blYMWWt9tcyiWAxbvK9NF2+aqbSjuU" +
           "dbH32A/u+vRtjx7u63ftFD7exE7o9tCNi7CEAxKuvGy6/cOX/f7rfvupbxTl" +
           "lf8FLbJ+dwcmAAA=");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Lbs8/3+xUFZSxBkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ghEej2fdBTtpIG59KcwQ12+wW2suL1qm4a9CnBlg5YnfxmrxSiIpYar25mOy" +
           "16naWG2LrKZ0XKdJz3ddPekOFilP9Cy/R08qfjrgDb/OrKhlfTVph6tJKhCV" +
           "TYzgfbWPaO2ar/s6ts1ia9aZ6/iUSjwmntuCHA/AcbEzwAmiotV8oxxwFaNf" +
           "nvCsMpkOGwnOVSY4YnVNk2cpaxXMQiKuN9aCKauBM8r89tCTh0bIJmzUXIZJ" +
           "SDrTyFtqG1tjZ10vQrJ1JtChK9aR7TCEu0lFpMRGQw/GVmkoBfGkKVCVMEbI" +
           "xtCm2isPRzVOHaQL3gpNdkI3geM6i7HCzRo9f2h7/TiscfhqMhwmeClJK+FQ" +
           "GLLrUlTWWT7BR5vhCkgYIqq2NrUZPGUjXyPxsC8gUj3ehgMmWqJ9q21nw2mP" +
           "JplabIlEZ9I12KjTp9dyL6vReKtVh9myy62bXt3rbrF2q77mKJ9Yyuu+azRl" +
           "FicHiM1uKYkYIjLfXmXRom+x06S1MLerVpVtogbPWnOiP8Qlqu6O1nN80JV4" +
           "dMl5GFod+bWGynUQZxEZpLfMtmvTRzJ4iLY9SmmX7ZQbcFKLwXtjwoyXtfE4" +
           "JsIJ3maJrU7ii/IYztqYggS2X2+S9som6h2RmDaHIu5PB6UBL6eJO8fqht1D" +
           "VpVRKzLYuS5m9iY0MGwqbIQWyYmOOCbna0mxmioCl7IsSevTZplxN62YEPnq" +
           "yGv3xpI9a8rc0h/KymQlmov1mp1T5khyPQTGyvQUndZ9qcuF2Nq16RmFzUiH" +
           "shpkXd8u5oNZt6tUurVqO5Jmjh53ZskU7tQCkpz6KA6PWGmFMswARj3NXFYG" +
           "1DQZDtKKMR0RVX845+1NOsPRcIpH6drrWGuYIqx64rIzqz/J2CHF4qllbpA2" +
           "by40z6NYAyYGmyomIkPSF6ccGWZohgVmn5YH29qcYLuY1WDpPsrXbQm0S2RP" +
           "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" +
           "ilu87A/u+b03f+K5bxTZyv8FeBOb148kAAA=");
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
           "M2X7Q4WMRyFY3L+raN6UnMWX87Y+M927pX34j7/1aulbX/x2Ofz5+eLZdGKV" +
           "cG+sh4vmzYXuj10E076SWICu9hL3Yzfcl74LOC4ARw3Uj2QUA7TPziXfEfV9" +
           "9/+n3/jN17/3q/dAB13oQaCv3lVKHIMeAABiJBYoFFn4D969z6RtkVo3SlWh" +
           "25TfJ+Dj5d39d4+1bjHdO0XBx/9y5Krv/6//7zYjlOB9Sfhd6L9AXvz4E9SP" +
           "fKPsf4qiRe+nstsrIJgan/bFPu39n4O3Xv3tA+j+BXRDO5p3S4q7LrBpAeaa" +
           "yfFkHMzNz70/P2/cT5KePakSb7wY/2eGvYjfp3EHrgvq4vrByyD7SQBnXzyC" +
           "tS9ehOwrUHkxKLu8pWxvFs0PngnPegodOJWTeL5RUv1w0Qz3Dnz3HZ3deeWi" +
           "jF9WFOwyUYTvgyizlxWlepko8++DKLdeVpTaZaK892VFKftnV64A7MIO8UO0" +
           "uDcvH+yeFHxUrlXXBtXoalJ+7xWIZ/uKeyzGYytXu3kMvRL4/gMpeXPl4sfl" +
           "5kaJJkXwH+4/mi7IW/87ywvQ4uFTZkwAvr9+7r99+A/+ydNfAyk9gO7bFOkG" +
           "MvnMiNy6+CT92Rc/8uSrnv+LnyvnAWDmKL3vbf+7nODHd9C6uFwVjVM0J6o+" +
           "UagqlrNtRklStqzhhn6ibeWMPngKZgLB30Pb9Pq7+rWEJo//GGnRnmfTiiDD" +
           "IzxJ8hzH8wZCMj7BtGJyJyiS7FaimS5p8gLrU6TjzBaz1a6e4KN5Eyaa1dVm" +
           "t26QoRgNrIkiTPv4lIvDkLYWww6dh5Gi0CmrIIrjdmRsnaItZIK5oSh2edVl" +
           "VMzvb0yE2Ca06DjVvr/Z+Dy/21V9c2Rqa0JbO/2eLOpRkEWDxEN7qcKYvU44" +
           "CNGZOBu6vjwKLSYPmrLoI2qT70dyPnKMgEQXlBxP6vMEi7gxJ6Oc0110k7rt" +
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
           "tzpZ/9+W14M5jikAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wWpBwHrX0BtMzzcaxhAeEgVNqsvyaBGpS3g9iNrFmepSc43r+tp8NVsnLLw0" +
           "cA7uykhzKFU5fOEzG40QiTDZ6GsGGSGagjZHjYkRT8EB453vzI4e11/b6e/e" +
           "/KB7dMkBDn3Zi95rOPXEtx5wbzfgrryWl0zuPV0vP15e2xVToOyA9/DtrjTy" +
           "w92nPnjjRWn46eLeQRGKA+f5g5umnZzshP22259iqfw6Z1cZ+fIH//mhybu0" +
           "97yGavCjp5Q8LfJ3qJe+2nmr+Ot70NmjOslNF00nma6drI5c9OQg9KzJiRrJ" +
           "w0duvZS5qwrciR249elbV2RvOVFn8onaxsOpAt/Zg6rWQdHjvlM1wjHvB9t6" +
           "U3RI8vApkrmnB1k9c0uaD7J5lSri+7KHG0AXHU8W85uAbQl6eiwIl+BgvrF1" +
           "aRed3k86k5+o1wXQg7e7bDi0An4NNxcguh686XZ0e6Mnfu7FSxceeHH6V3mJ" +
           "/ujW7a4BdEEJDeN49etY+zywXdFzd9y1rYU5+c9zAfTIq+sVQOfy39yMZ7dc" +
           "Hwbm3o4rgM6C53Hq5wPojbeiBpSH7jmg/LUAunyaEoyf/x6nuwEmc0cH1ue2" +
           "cZzk40A6IMmaLziHU/CaLo8ww9H4kSefns/4zEk8OYqYKz8pYo5B0JMnsCO/" +
           "Lz9c5+H2xvy6+PkXe/R7X6l9enunIRrgDJBJuTCA7txerxxhxeO3lXYo63z3" +
           "qR/d84W73nIIavdsFd6t4GO6PXrrm4S26QR57T/9gwd+7x2/9eK38hrh/wIe" +
           "eR6TyCAAAA==");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sl0aC0HJwkH2FfZIh5/8FzKUrJYvGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sfwN20Xp7BEmAAA=");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVZe6zjWHn33NmZnR2WndmFfbBl3wPVEnod5x0NUJyX7cSO" +
           "nThOYrdl8DN24rcd2zFsCyu1uyrSlrYDbCVYqdKiAloeqopaqaLaqmoBgSpR" +
           "ob6kAqoqlZaisn+UVqUtPXbuvbn3zsyiVdVIOTmxv+8753uc3/nOd176PnQu" +
           "8KGC65ibhemE+2oS7i/N6n64cdVgv09WGdEPVKVtikEwAc+uyY9/4dIPf/Rh" +
           "/fIedF6A3iDathOKoeHYwVgNHDNSFRK6tHvaNVUrCKHL5FKMRHgdGiZMGkF4" +
           "lYRed4w1hK6Qh1OAwRRgMAU4nwKM7qgA0+tVe221Mw7RDgMP+kXoDAmdd+Vs" +
           "eiH02EkhruiL1oEYJtcASLiQ/Z8CpXLmxIcePdJ9q/MNCn+kAF//2Hsu/+5Z" +
           "6JIAXTJsNpuODCYRgkEE6E5LtSTVD1BFURUButtWVYVVfUM0jTSftwDdExgL" +
           "WwzXvnpkpOzh2lX9fMyd5e6UM938tRw6/pF6mqGayuG/c5opLoCu9+103WrY" +
           "y54DBS8aYGK+JsrqIcttK8NWQuiR0xxHOl4ZAALAerulhrpzNNRttggeQPds" +
           "fWeK9gJmQ9+wF4D0nLMGo4TQg7cUmtnaFeWVuFCvhdADp+mY7StAdUduiIwl" +
           "hO49TZZLAl568JSXjvnn+8N3PPc+G7f38jkrqmxm878AmB4+xTRWNdVXbVnd" +
           "Mt75NvKj4n1fenYPggDxvaeItzS///5X3v32h1/+ypbmp25CQ0tLVQ6vyS9K" +
           "d33jze0nm2ezaVxwncDInH9C8zz8mYM3VxMXrLz7jiRmL/cPX748/jP+A59R" +
           "v7cHXSSg87Jjri0QR3fLjuUapupjqq36YqgqBHSHaivt/D0B3Q76pGGr26e0" +
           "pgVqSEC3mfmj807+H5hIAyIyE90O+oatOYd9Vwz1vJ+4EATdA77Q/RB0229D" +
           "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" +
           "E/UTWSLQwbhhL91Ccz0tCUYfBGMcSX4ymFENfOXORphj47qRkrqyHHSrErVa" +
           "TPsAMvRemJopTqLtsmk2CHehIKtGY427cEyOcS6srBIOHDDe+c7s6HHttZ3+" +
           "7s4PukdXHODQl73ov4ZTT3LzAfd2A+7Ka3nJ5O7T1fLj5bVdMQXKDngP3epC" +
           "Iz/cvfj09RcU+pPI3kERSgDn+YN7pp2c7IT9tlufYqn8MmdXGfny0//84ORd" +
           "+ntfQzX4kVOTPC3y09RLX8XeKv/GHnT2qE5ywzXTSaarJ6sjF301XPv25ESN" +
           "5KEjs17KzFUF5vz0gVk/dfOK7E0ddSZ31DYeThX4zh5UtQ6KHveeqhGOxSDc" +
           "1pviQ5KHTpHMfCPM6plb0nyQ6FWqiO/PGi+ELrq+Kuc3AdsSNHcsCHlwMI8c" +
           "Q9lFp/+TzuQn6nUhdN/NrxoOdSi8hlsLEFsP3HAzur3Nkz/3wqUL97/A/VVe" +
           "oD+6cbuDhC5oa9M8Xvs61j8PNNeM3Bh3bCthbv7zbAg9/OrzCqFz+W+uxjNb" +
           "rg+F0AO34gqhs6A9Tv1cCL3xZtSA8tA8B5S/HkKXT1OC8fPf43TXgSt3dGB1" +
           "bjvHST4GpAOSrPu8e+iCzmu5OEJNVxcZXz3tz+TMSTQ5ipd7flK8HAOgJ04g" +
           "R35XfrjK19vb8mvy51/oD9/3Su2T2xsN2QQnmUzKBRK6fXu5coQUj91S2qGs" +
           "8/iTP7rrC3e85RDS7tpOeLd+j83tkZvfI3QtN8wr/+kf3P977/idF76VVwj/" +
           "F6895cTEIAAA");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "JRGNBaDk1CH2ZfZIh5//F+mAqEMrGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "DSYAAA==");
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
           "Y/nBv/+Pm5yQ484tFuZT/Dz80icebr7zezn/DgAy7qvJzaANqrkdL/IZ89/2" +
           "njj/p3vQnTx0RTwoFeeCEWbTigflkX9YP4Jy8sT7k6XOdl2/fgRwbzoNPsfU" +
           "noae3WIB7jPq7P7ScbT5MficAd//yb6Zu7MH2wX2vubBKv/Y0TLvOMmZMwF0" +
           "Dtmv7xcz/nflUh7Pr9eyy09vwxSAYjhcGhqYTef9vE4FXIpmCUauHAtAmhni" +
           "tUMNc1C3grhcWxv1w+lyJU+pzAP722JvC3nZtZyL2KZF7bYpdH1Lla9t9+yE" +
           "kTaoGz/8Dx/5+q8++W0Q1z50Lsp8DsJ5TCMdZqX0L7/00Ude9/x3PpzjGFj5" +
           "5u9/87/mhQl9G6uz23Z26WSX7qGpD2emTvIqgRT8gMoxSJZya181nUeeZgKE" +
           "jg7qRPjp+76tf+K7n93WgKdz9xSx/Ozzv/Lj/eee3ztWeT95U/F7nGdbfeeD" +
           "vvvAwx70+KtpyTna//j5p//wt59+Zjuq+07WkQTYJn32L//76/svfOertyhf" +
           "7jDs/0Ngg7uMbsXvYYcfcs4pbDxLElYJYaoMr9PGeIwtqd5yMO4USMK1tWI6" +
           "5ZAOvqEdnna7vWK3S9fFer0t1yOy3k9QWpvRE5wtKhuc6E7weVwqDIs609cG" +
           "TmcpzUzb9mZ9wlkOJoZrljjVUJxubSy5s8Gi2EJdc4nwyBJWkFTDXFSYLJFq" +
           "UG2gtYaHonV/A0vjYIYw0zLBtQhkmRB12tzEzVkS6Gp94gO1KmnqsmY24XJX" +
           "r0brITVw+vaQ8wNfmi37FLOWVWdY6dRokTaRdrM/mlV7ZljgbGpsSjiXptPx" +
           "xCWGKVMesp6rC510NFVxSozXkyGyxtdzIjI6jFHqtFqzLidPB8Oevgnrq4aO" +
           "ibTgmrRcYDx4wLRggx12FkMdmaUl3IZVU050UwZb0nHJjIuzAe24puI1gk5t" +
           "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");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "WOcBKDl5iH2FP7LhJ/8FzwyMRysbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "gA0mAAA=");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVZe6wjV3mfvZvdbJaQ3QTyICXvhSqY3vHY47GtBYo9nvHY" +
           "nrHHb3vasozn/R7P2wNpIVVJRKSUtgukEuQvUFsUHqqKWqmiSlW1gECVqFBf" +
           "UgFVlUpLUckfpVVpS8+M772+9+5uUFTVko/HZ77vO+d7nN/5znde+j50zveg" +
           "guuYG8V0gn0pCfZ1s7IfbFzJ3+/SFZb3fEnETd73J6DvmvD4Fy798EcfUS/v" +
           "Qec56A28bTsBH2iO7Y8k3zEjSaShS7tewpQsP4Au0zof8XAYaCZMa35wlYZe" +
           "d4w1gK7Qh1OAwRRgMAU4nwLc2FEBptdLdmjhGQdvB/4a+kXoDA2dd4VsegH0" +
           "2EkhLu/x1oEYNtcASLiQ/Z8BpXLmxIMePdJ9q/MNCn+0AF//+Hsu/+5Z6BIH" +
           "XdLscTYdAUwiAINw0J2WZK0kz2+IoiRy0N22JIljydN4U0vzeXPQPb6m2HwQ" +
           "etKRkbLO0JW8fMyd5e4UMt28UAgc70g9WZNM8fDfOdnkFaDrfTtdtxqSWT9Q" +
           "8KIGJubJvCAdstxmaLYYQI+c5jjS8UoPEADW2y0pUJ2joW6zedAB3bP1ncnb" +
           "CjwOPM1WAOk5JwSjBNCDtxSa2drlBYNXpGsB9MBpOnb7ClDdkRsiYwmge0+T" +
           "5ZKAlx485aVj/vl+/x3Pv8+m7L18zqIkmNn8LwCmh08xjSRZ8iRbkLaMd76N" +
           "/hh/35ee3YMgQHzvKeItze+//5V3v/3hl7+ypfmpm9AMVrokBNeET63u+sab" +
           "8SfrZ7NpXHAdX8ucf0LzPPzZgzdXExesvPuOJGYv9w9fvjz6s+UHPiN9bw+6" +
           "2IHOC44ZWiCO7hYcy9VMyWtLtuTxgSR2oDskW8Tz9x3odvBMa7a07R3Isi8F" +
           "Heg2M+867+T/gYlkICIz0e3gWbNl5/DZ5QM1f05cCILuAV/ofgg698tQ/tn+" +
           "BtB7YNWxJJgXeFuzHZj1nEx/H5bsYAVsq8IrEPUG7DuhB0IQdjwF5kEcqNLB" +
           "i2xl8nEAaxZwPzyetXGgVKa2tJ/Fmfv/PkKS6Xg5PnMGmP/Npxe/CdYN5Zii" +
           "5F0TrodN4pXPXfva3tFiOLBOAOFg0P3toPv5oDlwgkH380H3jw96hdYUNZDs" +
           "o44D6IDOnMnn8MZsUlv3A+cZAAYAQN755PgXuu999vGzIO7c+DZg+YwUvjVO" +
           "4zvg6OTwKIDohV5+If7g7JeKe9DeScDNFAFdFzN2NoPJIzi8cnqh3UzupWe+" +
           "+8PPf+wpZ7fkTiD4ARLcyJmt5MdPm9xzBEkE2LgT/7ZH+S9e+9JTV/ag2wA8" +
           "AEgMeBDCAG0ePj3GiRV99RAdM13OAYVlx7N4M3t1CGkXA9Vz4l1PHgt35c93" +
           "AxtfyEL8ERDrHzqI+fw3e/sGN2vfuI2dzGmntMjR951j95N//ef/VM7NfQjU" +
           "l45tfWMpuHoMHDJhl3IYuHsXAxNPkgDd373A/sZHv//Mz+UBACieuNmAV7I2" +
           "iyvgQmDmX/nK+m++/a1PfXPvKGig5KRuF15FNzDIW3fTAJhiglWXBcuVqW05" +
           "oiZr/MqUsuD8r0tvQb74L89f3rrfBD2H0fP2nyxg1/+mJvSBr73n3x/OxZwR" +
           "sj1tZ6od2RYo37CT3PA8fpPNI/ngXzz0m1/mPwkgF8Ccr6VSjlx7uep7ueb3" +
           "BtCbcs7d2gSSHY9xRCnfJ+Dcpfs58ZN5+zOZXQ6sl/0vZc0j/vGlcXL1HUtR" +
           "rgkf+eYPXj/7wR+9kit1Msc5HgkM717dBl/WPJoA8fefxgGK91VAh77c//nL" +
           "5ss/AhI5IFEAmOcPPIBQyYm4OaA+d/vf/vGf3Pfeb5yF9kjoounwIsnnSxC6" +
           "A8S+5KsA3BL3Z9+9DYI4i4rLuarQDcpvY+eB/N9ZMMEnb40+ZJai7BbwA/85" +
           "MFdP//1/3GCEHHdusjOf4ufglz7xIP6u7+X8OwDIuB9ObkRtkM7teEufsf5t" +
           "7/Hzf7oH3c5Bl4WDXHHGm2G2rDiQH/mHCSTIJ0+8P5nrbDf2q0cA9+bT4HNs" +
           "2NPQs9stwHNGnT1fPI42PwafM+D7P9k3M3fWsd1h78EPtvlHj/Z5103OnAmg" +
           "c6X96n4x4393LuWxvL2SNT+9dVMAsuFwZWpgNZ3380QVcMmazZv54I0AhJkp" +
           "XDkcYQYSV+CXK7pZPVwul/OQyiywv832tpCXteVcxDYssFuG0NUtVb633bUT" +
           "RjsgcXzuHz7y9V994tvAr13oXJTZHLjz2Ij9MMulP/TSRx963fXvPJfjGNj5" +
           "Zh94y7/mmUn/Flpnj2TWtLOGOlT1wUzVcZ4m0LwfMDkGSWKu7auGM+tpFkDo" +
           "6CBRhJ+659vGJ7772W0SeDp2TxFLz17/8I/3n7++dyz1fuKG7Pc4zzb9zif9" +
           "+gMLe9BjrzZKzkH+4+ef+sPffuqZ7azuOZlIEuCc9Nm//O+v77/wna/eJH+5" +
           "zXT+D44N7nQp1O80Dj/0bCnPY2GUzOUQ7pfhJgK7hOl3UXTC4bJAeLPmqIGZ" +
           "gcXYE78w4HixKc6VEK0WK+UaVw0rETeQIx/td4jhtDdyNA0dL9cOXKZnpDfr" +
           "q7zSGI5DfeyNZg3eMBuKu9b8oax2Cp2RoZt63DJTIQ2rIiZVx2rHpkaplPaj" +
           "spey5XKY0vUKnkw40hNGynTCecQk4lfVxmjSLo2x/iBZjQrNcKVi3SUNC3Jq" +
           "1fpo3FNNChmbfguzl12F4YsjtjRoe6NWN1CHm0WJwYluZA0Iwo2GvBAXi4lK" +
           "6ZxTt2iuOBEXS6NrKPag4bg6OVUTSy8Z47YxbVONKRMwXJMguI7DCpRZVbX1" +
           "jEA8RGNlFGejGobEG29UNn1kuJJiw/a5nmpZGBH0fcQtmXxPNDFvMAl9S+sy" +
           "odaFp3VdMQaJvJxavVbd5NZsFUkYZOhMPEZqLyc91daR3oocyF3HWK4j0iqU" +
           "5+PAKKgJQhhqsKpoTXut0RbVAylqw5Gwku1OO1RxxkxolzUHTowkgy636jXn" +
           "XYdP0QmODAQx0Bi8azWHiZmKTWk1FP1gMC+ZpjJds95sMl+pm4jlqsRsmOqW" +
           "U1yiG9pBO8NWA+Wa6GBcb4xV0ahpwxGtrxm0waG10doiRavM1BbzumfEnNVe" +
           "4DCfLAvWiuiQcxELlA6sWGjRSXuTSjCiNae5gdWpLU7ibqhzldBw+k1YqfVI" +
           "TVXmjaI2pkIbR8hpZT1a9pQgxAf2sia3ho3malwfEK6QCtPptK0q5pQu9omk" +
           "xhuMwqtcMcb5FdFtTBWu5Cnraani4Vgwkbo0IU2HbYxYGYSJz/AiG9PDGGn6" +
           "BtGFW+PEwRcyi1X6qzSKLVt3mmS7wzUqw9lY3FRrg743bfed0rjbI4ia0Qy9" +
           "waa3ELi+VymynXhC6ENSG8uDFl2vF3hS9mpmOOYCptfvCPZE7c0ScW5qklvu" +
           "wyJSdZCYERy/WOfRGswUScQooeukyG2QhtVbCqMquhRH0mJUhktYk5W7i1rf" +
           "Qd3mrNfjJW3ZF2Zj27JMuhgb9WEjwZnxoDucjQY6MZbnzTrhyg2hGMcaF9ds" +
           "I+VUBVM7JMKYbqSwXcPB8RKm4bY+13sTECPh0hVGKWJ0OojALPrj/hQmpwYb" +
           "9RaO1O9tjHjS5KNlsZFM2jxhIfX6vEERVkwvXW7Y02RjnaTDDUmQI2awNhWt" +
           "w0yFEYdyYYdzLdUV6NpGjEYNaqOTyJgbUZY8h+ESQffFBJ7GTnOwkikiKVAy" +
           "bTk9w8Y7JQ+v2BIc+FFSL4wUYT6JV8RgWEZinhxKbXVO4WuNGGKsVuzpcLGD" +
           "LfuuqSWM2h/08eZQI9RhzCzGniPbLYFkGg100Tcq9UBTiYK86iTNMmLEo3kX" +
           "mwShPHNSlO0hm4aORQtsHVlBUF3C0+WSFGZDdsZxzTCsRexkOB42QlHwulXB" +
           "6a7JkRSLutZLtFrRJCfdod1Y16c9tTYw025smUwtRQYtHe0uU9vTe5g/M0ay" +
           "PaoFc44pSnDNNWI8lBc4VTEYobEqp1XcmJQotIk0V6TWXdVKFSupy2GaRJKm" +
           "jWbliTA3rdgoREPK2Ywdytb4QJjDba8WyMZgKXObIdVudyS/0SHDFlcYN6e0" +
           "QGPkZsGYDZQXO0UkssZ8gemZa9rSW4Iee+KAbYmNeXeSeO1Nq85uMANbaSZW" +
           "K80XiW+G1ADdbBR1rCztpJDaEUi54HotSvHyHAnWMlFuttuUyOqpng4cUghm" +
           "leUiJAilW6SQWCyI3CSooSKREjTZD+YDD2/paTyLOzOlsi7UQQpcb5Vq/mII" +
           "26iamLXy1JsXmfKgPaa68arhNCqNeDkw0YRoxWaX5m0V76YbGTbnqQzOjXI1" +
           "GPbqpShG4xW7isLUx1cRVluwMjWoLQolXF+qJieqKTKULGFSqo+qNmV4Cd0V" +
           "dKnA1821LCdMvWEOm0bgTSsdv1GiySGL14plhhrLpYHdxBeNUk+oraeiV8K7" +
           "QqHTUWaMWGWrUnepwzBMNQulElydbphaYYEIs9mmLsGYvsYIKSonXK+yEk3Y" +
           "UJaxyZdbLbRQZRS8UFgqYrNMiIrnUKYiwWYviOyYGnTQ1iiZKSW9wjRm41Ra" +
           "UPq0KS3gELNX6ViUWhIeKwNnqIvJUsFpkpiYBBsRE4WQOKwYsfi4texw1IhH" +
           "huRo6izSVhMW8ZLvyNVispywrl1dymy5npbKEsESDj6rrNhOCneHyxDWY14y" +
           "nKaB2JzSxcSyFo8msDPiy8t5U/BtFnPSSQg2xNVMUqORuSmJi5nKUFSlFBSS" +
           "BhaxVXVRcVQExuqrOkx5ZUytioseyZgTC15TguaNiUAiR8aY5QoU16xPF7Cn" +
           "66ljSYWCqbB4BfHCKc5icGsyceZeUWkSs0qtkMh9tVJhqIVGWW5zXsPnQ24Z" +
           "tegyWncIEVvPY55qmu2x6ugsUxblMMAdcdxwS7VYXBgMMgWLaWVGJNyKVg4V" +
           "sZV+Ages56RUr8bNtFZt0Gzgccmabxoe02gaQ8JEFbqDFpvtpk329UkgU5TQ" +
           "nYOMgNqMeCdp2dpw5usY1gxaRGHSak87MwD8HtaOO03Es9tNrrvmx4pRLKK0" +
           "56cLOdWBUf1oIzUG9dBvLu1uARVM1lGFOddr0eNaqaTYISmjhVqpoXZ5bDZi" +
           "UZLF6SqMzgph0y0M9TlSt+t9cVWzECSJ+73+GjNNXdM6BLzgIrgms2ml1hvM" +
           "RxVr3dZ5ZDDq81pN1kECW418ebpM2DrpDZmUj4rGBoODpNJCi+6a5lWU7Xh0" +
           "KV1vUB/hhBKtw0nbIVrh1Jx2C1zKYLQTUfLGnQ67I6M/Jppj13RXLaJVKrQQ" +
           "l6edOZ306kO0uxBNdIAVSxrW7ugtbC0QpdY4AKnjzKMcedMnBshw6qALOMWw" +
           "EUb57MppEKmpVGCjRYEdJaqgiN0VfbYuVZVlPXQXeKcyJGDO6JPcUiWmWl+M" +
           "fWNRojjTlSjUnndw1OcK0w5RVUJaRTm2DFd9v9ppzqhprb+RwjQlpz07GlH0" +
           "KFxw89UGi4zlQBIxU+4F1cCd4gJZV5qREdcwSaFCmsSkfrziu7SvI5tSPapO" +
           "ovqsINBlg2UidIlb7Taiwmm03Az7JdgJAPIX0SoZ9TxLqhStggcg24JZ1lO8" +
           "gizLWuxFM4bqr+sshUgRy8q8N07CucPUV/1YU/nxqCOqyYxnV4X5fDBd9/tF" +
           "ipy5ol2bjxrDsB0sqenMbheJirlpNzR17VZCq1VwjMkymZD2bI4BqK4tea1O" +
           "eH6XJsujFoNOSpZq6J2l0zcJMuqGtbo+C0XGXc5Kg1a/QqYc2KmqC5Dq69xa" +
           "XvQ2LPBmr4LZOofU19yG25gCDGP+0lNXs1qHtLprjkRXjLZZdOKgWWzMGC3p" +
           "tHWURQqNkKss9YWveQoiEGCn1IxhnYUTgVssp7w5moIDxjvfmR09rr2209/d" +
           "+UH36I4DHPqyF93XcOpJbj7g3m7AXXktL5ncfbpcfry8tiumQNkB76Fb3Wjk" +
           "h7tPPX39RXHwaWTvoAjFgfP8wUXTTk52wn7brU+xTH6bs6uMfPnpf35w8i71" +
           "va+hGvzIqUmeFvk7zEtfbb9V+PU96OxRneSGe6aTTFdPVkcuelIQevbkRI3k" +
           "oSOzXsrMVQHmfO7ArB++eUX2po46kztqGw+nCnxnD6paB0WPe0/VCEe8H2zr" +
           "TfEhyUOnSOaeFmT1zC1pPkj0KlXE92fNOoAuup4k5DcB2xL09FgQLsHBPHI0" +
           "cRed3k86k5+o1wXQ/be4azhUovAa7i1AcD1ww93o9j5P+NyLly7c/+L0r/IK" +
           "/dGd2x00dEEOTfN48evY83mguqzl1rhjWwpz859nA+jhV59XAJ3Lf3M1ntly" +
           "PRdAD9yKK4DOgvY49fMB9MabUQPKQ/McUP5aAF0+TQnGz3+P010HvtzRgeW5" +
           "fThO8nEgHZBkjy+4hy5ovZaro4bpqjzrSaf9mZw5CSdHAXPPTwqYYwj0xAno" +
           "yG/LD5d5uL0vvyZ8/sVu/32vYJ/eXmkIJp+mmZQLNHT79nblCCoeu6W0Q1nn" +
           "qSd/dNcX7njLIabdtZ3wbgEfm9sjN79IICw3yEv/6R/c/3vv+K0Xv5WXCP8X" +
           "LJdiucYgAAA=");
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
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYC2wUxxmeOz/w+8XLPGzANqQ8eleS0BaZ0tiODYbzQ5hY" +
           "ig0ce3tzd4v3dpfdOfvslCZBinAjBRFKCK2CpapOoYhHFDVqqzbUaVpClDRS" +
           "CG2aRoE+opaWooKqplVpm/4zs3v7uLMRVWPJc7uz//wz//9//2tO30AFho7q" +
           "sUICZFTDRqBdIb2CbuBomywYxnaYC4vP5gl/3XWte70fFQ6gioRgdImCgTsk" +
           "LEeNAVQnKQYRFBEb3RhH6YpeHRtYHxaIpCoDaK5kdCY1WRIl0qVGMSXoF/QQ" +
           "qhYI0aVIiuBOkwFBdSE4SZCdJNji/dwcQmWiqo3a5LUO8jbHF0qZtPcyCKoK" +
           "7RGGhWCKSHIwJBmkOa2j1Zoqj8ZllQRwmgT2yOtMFWwJrctSQcMLlR/dPpSo" +
           "YiqYLSiKSph4xjZsqPIwjoZQpT3bLuOksRd9GeWFUKmDmKCmkLVpEDYNwqaW" +
           "tDYVnL4cK6lkm8rEIRanQk2kByJomZuJJuhC0mTTy84MHIqIKTtbDNIuzUjL" +
           "pcwS8ZnVwSPP7qp6MQ9VDqBKSemjxxHhEAQ2GQCF4mQE60ZLNIqjA6haAWP3" +
           "YV0SZGnMtHSNIcUVgaTA/JZa6GRKwzrb09YV2BFk01MiUfWMeDEGKPOtICYL" +
           "cZB1ni0rl7CDzoOAJRIcTI8JgDtzSf6QpEQJWuJdkZGxaSsQwNJZSUwSamar" +
           "fEWACVTDISILSjzYB9BT4kBaoAIAdYIWTsuU6loTxCEhjsMUkR66Xv4JqIqZ" +
           "IugSguZ6yRgnsNJCj5Uc9rnRveHgI8pmxY98cOYoFmV6/lJYVO9ZtA3HsI7B" +
           "D/jCslWho8K8l8f9CAHxXA8xp/nul249sKZ+6iKnWZSDpieyB4skLE5GKt5e" +
           "3LZyfR49RpGmGhI1vkty5mW95pfmtAYRZl6GI/0YsD5Obbvw8GOn8HU/KulE" +
           "haIqp5KAo2pRTWqSjPVNWMG6QHC0ExVjJdrGvneiWfAckhTMZ3tiMQOTTpQv" +
           "s6lClb2DimLAgqqoBJ4lJaZaz5pAEuw5rSGEauAfzUeo4Dxif/yXoF3BhJrE" +
           "QUEUFElRg726SuU3ghBxIqDbRDACqB8KGmpKBwgGVT0eFAAHCWx+oJ4pjJCg" +
           "lATzB/v6N7WBUFRsHKA40z7xHdJUxtkjPh+of7HX+WXwm82qHMV6WDySam2/" +
           "dTb8BgcWdQZTOwSFYNMA3zTANmWhEjYNsE0Dzk2bQlI8QbCSmTBDR7ize3u4" +
           "t6VtK/L52GHm0NNxHIAVhyAeQEAuW9m3c8vu8YY8AKA2kg8moKQNrsTUZgcN" +
           "K9KHxXM15WPLrqx91Y/yQ6hGEElKkGmeadHjEMHEIdPJyyKQsuzMsdSROWjK" +
           "01URRyFwTZdBTC5F6jDW6TxBcxwcrLxGPTg4fVbJeX40dWzk8f5HP+NHfney" +
           "oFsWQJyjy3tpiM+E8iZvkMjFt/LAtY/OHd2n2uHClX2spJm1ksrQ4IWLVz1h" +
           "cdVS4aXwy/uamNqLIZwTAdwPImW9dw9XNGq2IjuVpQgEjql6UpDpJ0vHJSSh" +
           "qyP2DMNxNXueA7Aoou75KfDTKdNf2S/9Ok+j43yOe4ozjxQsc3yhTzv+y7f+" +
           "eB9Tt5VkKh3VQR8mzY7ARpnVsBBWbcN2u44x0H1wrPerz9w4MMgwCxSNuTZs" +
           "oiP1CTAhqPmJi3vfu3pl8rI/g3OUdstWNINssMkK+xgQD2WIGBQsTQ8pAEsp" +
           "JgkRGVN/+lfl8rUv/flgFTe/DDMWetbcmYE9v6AVPfbGrr/XMzY+keZjW1U2" +
           "GQ/ys23OLboujNJzpB+/VPe114TjkC4gRBvSGGZR189E9zPJawlawFbacQU4" +
           "qzr1Kpbj1jGT3s+Ig2y8j+rF1B59/zwdlhtO13B7n6O8CouHLt8s7795/hYT" +
           "yl2fOZHQJWjNHHx0WJEG9vO9oWuzYCSA7v6p7h1V8tRt4DgAHEWI10aPDtE1" +
           "7cKNSV0w61evvDpv99t5yN+BSmRViHYIzAVRMWAfGwkIzGntiw9wEIxQVFQx" +
           "UVGW8FkT1A5Lclu4PakRZpOx783/zoYTE1cYBjXOY5GT4T1sXEWHT3NDEag+" +
           "UxEo4uHBYIWhjVq2sNqbQZ2odW2go7rpihxWoE3uPzIR7Xl+LS9FatyFQzvU" +
           "xWd+8e83A8d+/XqOfFVoFqn2hjSL1LmySBcr/uxI9kHF4d99vyneejcJhM7V" +
           "3yFF0PclIMGq6ROC9yiv7f/Twu0bE7vvIhcs8ejSy/LbXadf37RCPOxnlS5P" +
           "A1kVsntRs1OrsKmOoaRXqJh0ppy5RGPG+pXUql1g9Yum9X+SOx7nxJWPPnZ4" +
           "AmCFxSQHM08MKGVcSt2VAjVeXypiQFaXkhDEh806+N7e3eJ4U++HHFgLcizg" +
           "dHNPBp/qf3fPm8wKRdTsGdkdJgd4OPJTFRfhY/jzwf9/6D89Op3g9WRNm1nU" +
           "Ls1UtdT3dLRyhjbULUBwX83VoeeuneECeKt+DzEeP/Lkx4GDR7iX8NaoMas7" +
           "ca7h7REXhw476emWzbQLW9Hxh3P7fnBy3wG/GYu3EpQnmV0rtZEv44dz3Crn" +
           "53zwK5U/PFST1wHu14mKUoq0N4U7o24IzjJSEYcN7E7KBqR5YqpvgnyrQLV0" +
           "Yof7ciNjaJae+P47Si/8yPjm71/kSs0FI087dfJEkfh+8sKHlryDGfRWmIEQ" +
           "mZGb/xI0+H8q9ONYTUJDSRJQesZJwuojPkn2FALLpweoQ48T32p869GJxt+w" +
           "FFgkGRASwUVytLSONTdPX71+qbzuLAu9+dTTTAu77wKyW31XB8+sUEmHpGn0" +
           "bOgtdqUAdnVlx8hT73zu5yeePjrCITCDP3rW1f6zR47s/+0/suoIFq5zuKhn" +
           "/UDw9HML2zZeZ+vtGpqubkpnN22gUXvtvaeSf/M3FP7Uj2YNoCrRvCrqF+QU" +
           "rUwHQGeGdX8UQuWu7+6rDt7XN2eSw2JvjHBs663enT6aT1z+WM3t4UMsbo9N" +
           "U1aw8E+AqaQIMlu3E5K4zPBH3yJ00DW7zPHUjbzipHJAEaEqmBav1jfeZkpq" +
           "IHNLBR/TWdig7z02eHgev4cO/ew8M1Sd4zN8e5IOT4BoIj0XF2MG8qeyCzk6" +
           "0ao5aj6fnTITHOiZQZ72lRE+PMPOT9OhD1Sp6VhkrTvOdOxsQdjMBfQHyr/8" +
           "YVXijreeDtv5hw3/Y7VqCkkb8jvcHlhmXX0XVxLg+LVZ1578qk48O1FZNH/i" +
           "oXd57LGu08og48dSsuwEtuO5EJQUk5jeyjjMeZ6ZgL535nMBEtgvE+M4X/UN" +
           "gmqnWwVJFEYn9SRAOhc1UMLopDxBUJWXEvZnv066UwSV2HTgePzBSXIGuAMJ" +
           "fTyrWSbouptboRZZSwi9Op7WsGlfdgPCoDX3TtBytBSNrqDNbsStNJ7id+Jh" +
           "8dzElu5Hbn32ed76i7IwNka5lEI64bcQmaJ62bTcLF6Fm1ferniheLlVBFTz" +
           "A9ul7iKHi7WC12q0MVvoaZCNpkyf/N7khvM/Gy+8BLlgEPkE8MfB7CCd1lLQ" +
           "zQyGsusoCNKsc29e+fXRjWtif3mf9XbZyc9LHxYvn9j5zuHaSejwSzsBo0oU" +
           "p1n2eHBU2YbFYX0AlUtGexqOCFwgjrqKtArqNwK9K2d6MdVZnpmlF0cENWSX" +
           "ndnXbdAHj2C9VU0pUbMIKLVnXFf1pi+WpDTNs8CecVQGcR6/eCmWFw51aZpV" +
           "lReLGotAielj7CvskQ4//i8bEXR8LRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+T997y/94D987Y/LMsv/BSzpfRATJgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ltSlnMSkKXvAemVyj3ikK/knKzAXl0Gw4BY+Ev322Nt7X+MuXIcxU3AcT7xA" +
       "bHkmI62WLT6HvxBcn+GF0uIG/kIuidnT0hWFcSm+3lV8T/MpED3U9v6+B84+" +
       "YSngfynzAdMjx771eeTuY1aWsWbul5aMvb041tzdUgeXl1G6lZW4cIy+P586" +
       "9Nwjhw6H7bN5CLw2raoyFZSSA9fJgmKzW7Le/M2Wnx5tq+qD/BUndaYi7Tdp" +
       "PFMcw7WGmfacgzumdyPalhptzkhojfP2zCPmuS8qYjrhSttun555xAShVo6Y" +
       "xYXC5AxkZFVHe8qc5ZkKofMBLu8w0igZqfjgaCrZE9uBWy+5tnr3C7DVUny2" +
       "Gi7TVticua2CUH3aVrnN0vt8cazWXrDaMFUyFL8d9UsKMzjrcxVsdh6Xs4w0" +
       "izqFwLU/tpUeRqFL8EJwk374/zBpnpEm70s9jpM6Sr4XWt+4xCdPtNS1n9j5" +
       "Nu8JCt+hmiCjZU1Z9g48PPc1mk6zEte5yRp/aPznAiOdlacNjMzhv1z2Ty2s" +
       "zxjpCMKCdzNYPdChECMLykEDpGNKG7IaSoYfEvjzXy9cLSMNLhxUC+vGC9IA" +
       "1AEEbxu14HoU8rRjxJNVFl7sWAso3rk0moB/DXYSoWl9D06Jp05sH7z9/KaH" +
       "rLm4KAsHDyKVRkh/1oi+0DStDKTm0KrpX31h7lP1lzl5eZ4lsBtml3g8HN5I" +
       "Qhr60xLf0NjoKsyO3zm55YVfHal5AyrKLhISGJm/q3T+ltdM6FZ3JUrTPDSY" +
       "fJrdvfoHB25Yl/3b7/mE0y4LS4PhU+JbD9/25j0dJzvDpDEObgahm+eDwZsP" +
       "KMNUnNLHSbNk9OZBRKAiCXJRDZmLri9grHO72OZsLuziVxVGVpVWxtJvUQ2y" +
       "Ok31raqpZOwq1OjuOM1zUd9papoPwd3xdA9vWIXLahSqUokBTXMah/o+jUf/" +
       "m/5SwDe5D3fyW7xb/l8Og39dKSIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
