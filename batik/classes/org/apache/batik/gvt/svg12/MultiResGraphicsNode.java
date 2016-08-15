package org.apache.batik.gvt.svg12;
public class MultiResGraphicsNode extends org.apache.batik.gvt.AbstractGraphicsNode implements org.apache.batik.util.SVGConstants {
    java.lang.ref.SoftReference[] srcs;
    org.w3c.dom.Element[] srcElems;
    java.awt.Dimension[] minSz;
    java.awt.Dimension[] maxSz;
    java.awt.geom.Rectangle2D bounds;
    org.apache.batik.bridge.BridgeContext ctx;
    org.w3c.dom.Element multiImgElem;
    public MultiResGraphicsNode(org.w3c.dom.Element multiImgElem, java.awt.geom.Rectangle2D bounds,
                                org.w3c.dom.Element[] srcElems,
                                java.awt.Dimension[] minSz,
                                java.awt.Dimension[] maxSz,
                                org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        this.
          multiImgElem =
          multiImgElem;
        this.
          srcElems =
          (new org.w3c.dom.Element[srcElems.
                                     length]);
        this.
          minSz =
          (new java.awt.Dimension[srcElems.
                                    length]);
        this.
          maxSz =
          (new java.awt.Dimension[srcElems.
                                    length]);
        this.
          ctx =
          ctx;
        for (int i =
               0;
             i <
               srcElems.
                 length;
             i++) {
            this.
              srcElems[i] =
              srcElems[i];
            this.
              minSz[i] =
              minSz[i];
            this.
              maxSz[i] =
              maxSz[i];
        }
        this.
          srcs =
          (new java.lang.ref.SoftReference[srcElems.
                                             length]);
        this.
          bounds =
          bounds;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) { java.awt.geom.AffineTransform at =
                                                            g2d.
                                                            getTransform(
                                                              );
                                                          double scx =
                                                            java.lang.Math.
                                                            sqrt(
                                                              at.
                                                                getShearY(
                                                                  ) *
                                                                at.
                                                                getShearY(
                                                                  ) +
                                                                at.
                                                                getScaleX(
                                                                  ) *
                                                                at.
                                                                getScaleX(
                                                                  ));
                                                          double scy =
                                                            java.lang.Math.
                                                            sqrt(
                                                              at.
                                                                getShearX(
                                                                  ) *
                                                                at.
                                                                getShearX(
                                                                  ) +
                                                                at.
                                                                getScaleY(
                                                                  ) *
                                                                at.
                                                                getScaleY(
                                                                  ));
                                                          org.apache.batik.gvt.GraphicsNode gn =
                                                            null;
                                                          int idx =
                                                            -1;
                                                          double w =
                                                            bounds.
                                                            getWidth(
                                                              ) *
                                                            scx;
                                                          double minDist =
                                                            calcDist(
                                                              w,
                                                              minSz[0],
                                                              maxSz[0]);
                                                          int minIdx =
                                                            0;
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 minSz.
                                                                   length;
                                                               i++) {
                                                              double dist =
                                                                calcDist(
                                                                  w,
                                                                  minSz[i],
                                                                  maxSz[i]);
                                                              if (dist <
                                                                    minDist) {
                                                                  minDist =
                                                                    dist;
                                                                  minIdx =
                                                                    i;
                                                              }
                                                              if ((minSz[i] ==
                                                                     null ||
                                                                     w >=
                                                                     minSz[i].
                                                                       width) &&
                                                                    (maxSz[i] ==
                                                                       null ||
                                                                       w <=
                                                                       maxSz[i].
                                                                         width)) {
                                                                  if (idx ==
                                                                        -1 ||
                                                                        minIdx ==
                                                                        i) {
                                                                      idx =
                                                                        i;
                                                                  }
                                                              }
                                                          }
                                                          if (idx ==
                                                                -1)
                                                              idx =
                                                                minIdx;
                                                          gn =
                                                            getGraphicsNode(
                                                              idx);
                                                          if (gn ==
                                                                null)
                                                              return;
                                                          java.awt.geom.Rectangle2D gnBounds =
                                                            gn.
                                                            getBounds(
                                                              );
                                                          if (gnBounds ==
                                                                null)
                                                              return;
                                                          double gnDevW =
                                                            gnBounds.
                                                            getWidth(
                                                              ) *
                                                            scx;
                                                          double gnDevH =
                                                            gnBounds.
                                                            getHeight(
                                                              ) *
                                                            scy;
                                                          double gnDevX =
                                                            gnBounds.
                                                            getX(
                                                              ) *
                                                            scx;
                                                          double gnDevY =
                                                            gnBounds.
                                                            getY(
                                                              ) *
                                                            scy;
                                                          double gnDevX0;
                                                          double gnDevX1;
                                                          double gnDevY0;
                                                          double gnDevY1;
                                                          if (gnDevW <
                                                                0) {
                                                              gnDevX0 =
                                                                gnDevX +
                                                                  gnDevW;
                                                              gnDevX1 =
                                                                gnDevX;
                                                          }
                                                          else {
                                                              gnDevX0 =
                                                                gnDevX;
                                                              gnDevX1 =
                                                                gnDevX +
                                                                  gnDevW;
                                                          }
                                                          if (gnDevH <
                                                                0) {
                                                              gnDevY0 =
                                                                gnDevY +
                                                                  gnDevH;
                                                              gnDevY1 =
                                                                gnDevY;
                                                          }
                                                          else {
                                                              gnDevY0 =
                                                                gnDevY;
                                                              gnDevY1 =
                                                                gnDevY +
                                                                  gnDevH;
                                                          }
                                                          gnDevW =
                                                            (int)
                                                              (java.lang.Math.
                                                                 ceil(
                                                                   gnDevX1) -
                                                                 java.lang.Math.
                                                                 floor(
                                                                   gnDevX0));
                                                          gnDevH =
                                                            (int)
                                                              (java.lang.Math.
                                                                 ceil(
                                                                   gnDevY1) -
                                                                 java.lang.Math.
                                                                 floor(
                                                                   gnDevY0));
                                                          scx =
                                                            gnDevW /
                                                              gnBounds.
                                                              getWidth(
                                                                ) /
                                                              scx;
                                                          scy =
                                                            gnDevH /
                                                              gnBounds.
                                                              getHeight(
                                                                ) /
                                                              scy;
                                                          java.awt.geom.AffineTransform nat =
                                                            g2d.
                                                            getTransform(
                                                              );
                                                          nat =
                                                            new java.awt.geom.AffineTransform(
                                                              nat.
                                                                getScaleX(
                                                                  ) *
                                                                scx,
                                                              nat.
                                                                getShearY(
                                                                  ) *
                                                                scx,
                                                              nat.
                                                                getShearX(
                                                                  ) *
                                                                scy,
                                                              nat.
                                                                getScaleY(
                                                                  ) *
                                                                scy,
                                                              nat.
                                                                getTranslateX(
                                                                  ),
                                                              nat.
                                                                getTranslateY(
                                                                  ));
                                                          g2d.
                                                            setTransform(
                                                              nat);
                                                          gn.
                                                            paint(
                                                              g2d);
    }
    public double calcDist(double loc, java.awt.Dimension min,
                           java.awt.Dimension max) {
        if (min ==
              null) {
            if (max ==
                  null)
                return 1.0E11;
            else
                return java.lang.Math.
                  abs(
                    loc -
                      max.
                        width);
        }
        else {
            if (max ==
                  null)
                return java.lang.Math.
                  abs(
                    loc -
                      min.
                        width);
            else {
                double mid =
                  (max.
                     width +
                     min.
                       width) /
                  2.0;
                return java.lang.Math.
                  abs(
                    loc -
                      mid);
            }
        }
    }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() {
        return bounds;
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        return bounds;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        return bounds;
    }
    public java.awt.Shape getOutline() { return bounds;
    }
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode(int idx) {
        if (srcs[idx] !=
              null) {
            java.lang.Object o =
              srcs[idx].
              get(
                );
            if (o !=
                  null)
                return (org.apache.batik.gvt.GraphicsNode)
                         o;
        }
        try {
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode gn;
            gn =
              builder.
                build(
                  ctx,
                  srcElems[idx]);
            srcs[idx] =
              new java.lang.ref.SoftReference(
                gn);
            return gn;
        }
        catch (java.lang.Exception ex) {
            ex.
              printStackTrace(
                );
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aeMikI1qU6U5bWJJt1prNwf1BZq20B2a");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZRwc1jxRY0mB5EZuQ9Y03kmmKtk3PeA8myUI8GtoH+miUCB2srrhdoWkIzbt" +
       "qBOv8Dm1seEuBmGCFIFFSgbJMbTOhGpro+UkMwULb25A1xSYrSKLPsX1xtqW" +
       "p5Z6mweu67VWYYDWE0R2AiAwhIbQkFuhY4SuaiSG0joiI2FgbvsYFU3sjV9j" +
       "jNZOEbeWU9/SMez5my66VgNyky1cDp/RJmmrnKJUudlm0uP0LUZWl8M8ykPZ" +
       "ytqDKUNN9caEh+oOHUg+Ow/Yfo/euRNb2iBEw6TUFqG3QTSHm8l6Vx/KHcR0" +
       "67jkD412JMhdpdNs7szGLhn1PWE5HXqNuZTz1V66nqYim/b7bidMcHyD4/jP" +
       "FVtX/+6NbandV+4eHl8ZXTtYUfCv38CuWXbqpPZ4n7X8u1Q5vF549Htqn/XU" +
       "sc+Fo53KJ645SysPnbgFdXw3uDiUeeRGl0bLw/vPfeTFl9TJ5+tH5ySjuHJn" +
       "7AfvcbSt5pzq9fb9EeLZC2PFqQZ3yDF3fmf4RCfXaPdCqd29qs6d8l04K+P9" +
       "x0eqRxcI4W5Z789ucjr4nSJ5Na7cGxzdVWAl6/DG0/k9z61vqSeG+/brbXee" +
       "7uqcRq4WmcXx21cONfKVN0cjt+wd8nrcX1L9RN5fY90nZQM/uIlq/qJIvh9X" +
       "7lAkR+keXlv74YkCXvsJFFCcWVSeAc/XDxXw9TdHAaf4v3DrTcouFZk/jitX" +
       "DS0+vqVCnBzJHEt5ofKTSvlu8Pz+oZS//+ZLeeUmZVeL5G6AREBKSvNdEGbu" +
       "rivkPW+GKb9xKOQ33nwhH75J2aNF8sDelFxxk+KGpnzwJ5CyRN7iGPJPDqX8" +
       "kzdfynffpOzZInkyrtwFpJwkcXFD/Qj37j3GPc6UDu/slnWe+gnkfbDI/Gnw" +
       "fOtQ3m+9OfJeOCGgSyabNxG6VST1uHK58N9Tl8KPJH/8upfJr6Es24LfiDKy" +
       "uPLW691GL67WPnjNv7/s/2VD+eJLl+944KX5f9hfUz36t4o7R5U79MRxTt8k" +
       "PPV+KQg13SpVdef+QklQsovHlYdufFU+rtxW/haMX3h+XwNEHG+9Xo24cgtI" +
       "T1NSceXKeUrQYvl7mo4G7nZCB6aQ/ctpEga0DkiK13FwZJZnrss4LkdxKCln" +
       "DJldOBU2HPpgqYWrr2et4yqnL30XlzzK/2E6uluXsId3Sb70Ej3+wGvNz+8v" +
       "nSuOlJc3Ae4YVW7f338vGy3u5z1+w9aO2rrUf+ZH9375zqePwqB79wyfjIdT" +
       "vD12/RvePTeIyzvZ+b944Ks/+49f+tPy+Pb/AwpvMEpcNgAA");
}
