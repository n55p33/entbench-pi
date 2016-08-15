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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sgqDe6KVhYIRP92OHOav+Pba/wB0WyRISjIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dQ0fI2DbPa4m47C1adRa9TgGz4twSQbr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XNXUpRNbmtVetVEI8XiqryI7pl/jYm0NBU0OJ1rxBDV1zGdwGU57TVvGSQ7f" +
       "0u5suA6HCO7MMXwdkFNBgFyK96K22+9WoWrVNfIdrBnOYgy26fNw3If7Kddg" +
       "Yitr4KNqR4MsYpMmshluF9tlnVJXS268EOfN1riBrnq04hvREFvlG2KYJbbE" +
       "qxtrSs/MWnuuo608jCW8zaPNbITuRLcG9mkcmpOzuiTPELUtG+N05ISUhea7" +
       "DY6iwq7rJ7uqHar0EqLopcF6aaoNJouxqddFtiPqwA3uIoLuN6Y7XM83tBJb" +
       "Bgb6oE3SX0ZMgo5mgS1l5oBz2nVSbXsZKZMIIrT4jV1d6o2aE3ublipN2Ko0" +
       "nSVsi91ECLRVx5qHmgbho80Bi6KbrMbHhW9jnSBEMmxJS4G8XEwt30EVYhtM" +
       "vEnLFaLJgra7dmc8Gisa7Ab9caON6fAwaSTJbh3GlNiaywSPQJYUQoPUC2pi" +
       "xx5F7WbXQ9eL9RSLdGJH7jaz+lKhhxmtBnDHFW3DakvbPt0gupTj173BYmci" +
       "29hc943WWLQWJM92EGbIKJsqqypQ1oOlLU8Kq+J13tveVrzi+7WX9urxvvIt" +
       "69EZ05WLFg1feQlvF/MTv44e/TpQ/t1eOTiPePj/xG8RJ36+O3f4RvftN3j+" +
       "rvih8rXXO4JaHlz5zAefe15nfrF2/uD19tuSyl1JEL7FBTt69wRLe+jyEZz7" +
       "C+5fDa5nD+A8e/qnlWOBXft3lTfuBX7Gq/Y/PqPtPxXFvwfMmkayf09cVMDH" +
       "CvrDH/T69+SIp8CV5+OerJw6znLj4M4dE8AlwX85A+G3iuLPAML4EOE133xv" +
       "Als/Rv3nN4D6VUVl8SOef4Dav/kq/csz2v66KL6bVF4GVNoLUl+PkX5RhRzD" +
       "+96NwnsCXOkBvPSmwzt37oy20t/8TVK5B8CjrviB8xjf396o0dbB9Z4DfO+5" +
       "6UaLlEBefgbIC0VxZ3E64BTIvzgCee6uGwBZetKHwfUTByB/4uYr8eEz2l5d" +
       "FK9IKneWSjz84fwY24M3w+t85ADbR266AhsliCfPAPiGongMAIxPADyhvMdv" +
       "AGAZMx4H18cPAH785iuvdkZbvSjenFQuFDHj9OmVY4hvuVEdNsD1qQOIn7rp" +
       "OuyUWN52Bs63F0Ub4IyvxnlClZ0bVWXhUX/hAOcv3HxVkme0jYuin1RuA6oc" +
       "x6cUOLhRBT4Grs8eAPvsD0mBszPQSUXBAnTxIboTauNuVG2Fi/nyAbov33y1" +
       "KWe0FecZzv14UnmgWIHXOhV1DPOdN6rE4szWVw9gfvWHpETvDKzF90nnLIA1" +
       "vjbWEyq1bwDrg0XlG8H19QOsX7/5Kt2e0fbuokj2Kh2fOiBV0PeOYaY3qtK3" +
       "g+t3D2D+7k1Xaa/E85NnYP1QUbx/r9JrYT2h0g/cANaHD1X6jQOs37ipWMtn" +
       "sLl8w9HnHldtJvny9uBb0RL6Pz5DLJ8oin8I4o0WGUpi7DuDLejhRK85NdGe" +
       "wNDJ4ulYZD/9UkSWJ5WHr/vJWfH9zENXfR+7/6ZT+8LzF+581fOz/7D/AOLw" +
       "u8u7qMqdy9R1T55IP3F/exgZS7uU6l37g8BhCf35pPLUi96jJ8W56sOHAtG5" +
       "T+9H+fmk8ujZo4BYYB9K67DXZ5LKQ9frlVRuAeVJ6l9OKq+4FjWgBOVJys8l" +
       "lYunKcH85f+TdJ8HeI7pksrt+5uTJF8CowOS4vbL4aE5kC/+pUZXjZNI0ZLy" +
       "iCJZfJECtFoeU9y/3tjb8kMnl1G5EO//QaZ01OXkF2cFG+XH14fn6tP959fP" +
       "aF98fjR59/dav7j/4k1zld2uGOVOqnLH/uO7ctDibP7j1x3tcKzbh099/94v" +
       "3fXk4RuXe/cMHy/pE7y97tqflw28MCk/CNt99VX/4q2//PyflMft/g+GQf1v" +
       "FT8AAA==");
}
