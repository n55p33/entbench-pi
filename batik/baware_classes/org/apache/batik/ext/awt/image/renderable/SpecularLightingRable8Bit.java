package org.apache.batik.ext.awt.image.renderable;
public class SpecularLightingRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.SpecularLightingRable {
    private double surfaceScale;
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private java.awt.geom.Rectangle2D litRegion;
    private float[] kernelUnitLength = null;
    public SpecularLightingRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                     java.awt.geom.Rectangle2D litRegion,
                                     org.apache.batik.ext.awt.image.Light light,
                                     double ks,
                                     double specularExponent,
                                     double surfaceScale,
                                     double[] kernelUnitLength) {
        super(
          src,
          null);
        setLight(
          light);
        setKs(
          ks);
        setSpecularExponent(
          specularExponent);
        setSurfaceScale(
          surfaceScale);
        setLitRegion(
          litRegion);
        setKernelUnitLength(
          kernelUnitLength);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return (java.awt.geom.Rectangle2D)
                                                              litRegion.
                                                              clone(
                                                                );
    }
    public java.awt.geom.Rectangle2D getLitRegion() {
        return getBounds2D(
                 );
    }
    public void setLitRegion(java.awt.geom.Rectangle2D litRegion) {
        touch(
          );
        this.
          litRegion =
          litRegion;
    }
    public org.apache.batik.ext.awt.image.Light getLight() {
        return light;
    }
    public void setLight(org.apache.batik.ext.awt.image.Light light) {
        touch(
          );
        this.
          light =
          light;
    }
    public double getSurfaceScale() { return surfaceScale;
    }
    public void setSurfaceScale(double surfaceScale) {
        touch(
          );
        this.
          surfaceScale =
          surfaceScale;
    }
    public double getKs() { return ks; }
    public void setKs(double ks) { touch();
                                   this.ks = ks; }
    public double getSpecularExponent() { return specularExponent;
    }
    public void setSpecularExponent(double specularExponent) {
        touch(
          );
        this.
          specularExponent =
          specularExponent;
    }
    public double[] getKernelUnitLength() { if (kernelUnitLength ==
                                                  null)
                                                return null;
                                            double[] ret =
                                              new double[2];
                                            ret[0] =
                                              kernelUnitLength[0];
                                            ret[1] =
                                              kernelUnitLength[1];
                                            return ret;
    }
    public void setKernelUnitLength(double[] kernelUnitLength) {
        touch(
          );
        if (kernelUnitLength ==
              null) {
            this.
              kernelUnitLength =
              null;
            return;
        }
        if (this.
              kernelUnitLength ==
              null)
            this.
              kernelUnitLength =
              (new float[2]);
        this.
          kernelUnitLength[0] =
          (float)
            kernelUnitLength[0];
        this.
          kernelUnitLength[1] =
          (float)
            kernelUnitLength[1];
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D aoiR =
          aoi.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D.
          intersect(
            aoiR,
            getBounds2D(
              ),
            aoiR);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        java.awt.Rectangle devRect =
          at.
          createTransformedShape(
            aoiR).
          getBounds(
            );
        if (devRect.
              width ==
              0 ||
              devRect.
                height ==
              0) {
            return null;
        }
        double sx =
          at.
          getScaleX(
            );
        double sy =
          at.
          getScaleY(
            );
        double shx =
          at.
          getShearX(
            );
        double shy =
          at.
          getShearY(
            );
        double tx =
          at.
          getTranslateX(
            );
        double ty =
          at.
          getTranslateY(
            );
        double scaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double scaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        if (scaleX ==
              0 ||
              scaleY ==
              0) {
            return null;
        }
        if (kernelUnitLength !=
              null) {
            if (scaleX >=
                  1 /
                  kernelUnitLength[0])
                scaleX =
                  1 /
                    kernelUnitLength[0];
            if (scaleY >=
                  1 /
                  kernelUnitLength[1])
                scaleY =
                  1 /
                    kernelUnitLength[1];
        }
        java.awt.geom.AffineTransform scale =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scaleX,
            scaleY);
        devRect =
          scale.
            createTransformedShape(
              aoiR).
            getBounds(
              );
        aoiR.
          setRect(
            aoiR.
              getX(
                ) -
              2 /
              scaleX,
            aoiR.
              getY(
                ) -
              2 /
              scaleY,
            aoiR.
              getWidth(
                ) +
              4 /
              scaleX,
            aoiR.
              getHeight(
                ) +
              4 /
              scaleY);
        rc =
          (java.awt.image.renderable.RenderContext)
            rc.
            clone(
              );
        rc.
          setAreaOfInterest(
            aoiR);
        rc.
          setTransform(
            scale);
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              getSource(
                ).
                createRendering(
                  rc));
        org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap =
          new org.apache.batik.ext.awt.image.rendered.BumpMap(
          cr,
          surfaceScale,
          scaleX,
          scaleY);
        cr =
          new org.apache.batik.ext.awt.image.rendered.SpecularLightingRed(
            ks,
            specularExponent,
            light,
            bumpMap,
            devRect,
            1 /
              scaleX,
            1 /
              scaleY,
            isColorSpaceLinear(
              ));
        java.awt.geom.AffineTransform shearAt =
          new java.awt.geom.AffineTransform(
          sx /
            scaleX,
          shy /
            scaleX,
          shx /
            scaleY,
          sy /
            scaleY,
          tx,
          ty);
        if (!shearAt.
              isIdentity(
                )) {
            java.awt.RenderingHints rh =
              rc.
              getRenderingHints(
                );
            java.awt.Rectangle padRect =
              new java.awt.Rectangle(
              devRect.
                x -
                1,
              devRect.
                y -
                1,
              devRect.
                width +
                2,
              devRect.
                height +
                2);
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                padRect,
                org.apache.batik.ext.awt.image.PadMode.
                  REPLICATE,
                rh);
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                shearAt,
                rh);
        }
        return cr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Iz4zuCdaXSgY8dPtyCH+im+v/Q+XL30TSjIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "eOwUC8SFWEWxWROpu25/wtfE4Yxb4Wqz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
