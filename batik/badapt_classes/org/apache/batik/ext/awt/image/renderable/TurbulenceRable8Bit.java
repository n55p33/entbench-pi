package org.apache.batik.ext.awt.image.renderable;
public class TurbulenceRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.TurbulenceRable {
    int seed = 0;
    int numOctaves = 1;
    double baseFreqX = 0;
    double baseFreqY = 0;
    boolean stitched = false;
    boolean fractalNoise = false;
    java.awt.geom.Rectangle2D region;
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region) { super(
                                                                     );
                                                                   this.region =
                                                                     region;
    }
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region, int seed,
                               int numOctaves,
                               double baseFreqX,
                               double baseFreqY,
                               boolean stitched,
                               boolean fractalNoise) { super();
                                                       this.seed = seed;
                                                       this.numOctaves = numOctaves;
                                                       this.baseFreqX = baseFreqX;
                                                       this.baseFreqY = baseFreqY;
                                                       this.stitched = stitched;
                                                       this.fractalNoise =
                                                         fractalNoise;
                                                       this.region = region;
    }
    public java.awt.geom.Rectangle2D getTurbulenceRegion() { return (java.awt.geom.Rectangle2D)
                                                                      region.
                                                                      clone(
                                                                        );
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return (java.awt.geom.Rectangle2D)
                                                              region.
                                                              clone(
                                                                );
    }
    public int getSeed() { return seed; }
    public int getNumOctaves() { return numOctaves; }
    public double getBaseFrequencyX() { return baseFreqX;
    }
    public double getBaseFrequencyY() { return baseFreqY;
    }
    public boolean isStitched() { return stitched; }
    public boolean isFractalNoise() { return fractalNoise;
    }
    public void setTurbulenceRegion(java.awt.geom.Rectangle2D turbulenceRegion) {
        touch(
          );
        this.
          region =
          turbulenceRegion;
    }
    public void setSeed(int seed) { touch();
                                    this.seed = seed;
    }
    public void setNumOctaves(int numOctaves) { touch(
                                                  );
                                                this.
                                                  numOctaves =
                                                  numOctaves;
    }
    public void setBaseFrequencyX(double baseFreqX) {
        touch(
          );
        this.
          baseFreqX =
          baseFreqX;
    }
    public void setBaseFrequencyY(double baseFreqY) {
        touch(
          );
        this.
          baseFreqY =
          baseFreqY;
    }
    public void setStitched(boolean stitched) { touch(
                                                  );
                                                this.
                                                  stitched =
                                                  stitched;
    }
    public void setFractalNoise(boolean fractalNoise) {
        touch(
          );
        this.
          fractalNoise =
          fractalNoise;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.Rectangle2D aoiRect;
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null) {
            aoiRect =
              getBounds2D(
                );
        }
        else {
            java.awt.geom.Rectangle2D rect =
              getBounds2D(
                );
            aoiRect =
              aoi.
                getBounds2D(
                  );
            if (!aoiRect.
                  intersects(
                    rect))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                aoiRect,
                rect,
                aoiRect);
        }
        java.awt.geom.AffineTransform usr2dev =
          rc.
          getTransform(
            );
        final java.awt.Rectangle devRect =
          usr2dev.
          createTransformedShape(
            aoiRect).
          getBounds(
            );
        if (devRect.
              width <=
              0 ||
              devRect.
                height <=
              0)
            return null;
        java.awt.color.ColorSpace cs =
          getOperationColorSpace(
            );
        java.awt.geom.Rectangle2D tile =
          null;
        if (stitched)
            tile =
              (java.awt.geom.Rectangle2D)
                region.
                clone(
                  );
        java.awt.geom.AffineTransform patternTxf =
          new java.awt.geom.AffineTransform(
          );
        try {
            patternTxf =
              usr2dev.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        return new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed(
          baseFreqX,
          baseFreqY,
          numOctaves,
          seed,
          fractalNoise,
          tile,
          patternTxf,
          devRect,
          cs,
          true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vVAI4p+sAw/zV3x75H+biVV1KC4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p+T9s5z8Tli6G8DsOpEtB9XeCXhfvQl4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("F/PEB8H1oT28D916eN84Je8Pc/IvwtJ5AI8+2O47gvYvbxbao+CS99DkWw/t" +
       "W6fk/XFO/n1YeguANr568/AI4H+4CYD354n5Jpm5B2jeeoB/dkref83JnwDj" +
       "n6vmfuMvApMw3e1HHoH89q0AGe5Bhrce5F+ekvdXOfnv1wHJnQD5P24C5AN5" +
       "4mPg+uge5EdvOcgzt5+Sdy5P/H6YHyKgj++XHqI7U7pZdPne6Ut7dC/denSX" +
       "Tsm7Pyd3h6V7jQA7ufl6hPCem0BYnFDqgOvlPcKXbw3CM0cMcAHl0VNgPp6T" +
       "h4BDDK51iNfdU9w6hnyE/+GbxZ+P8Gf3+D97y/EXx+XOlE/B/96cvBu4kuDQ" +
       "lZx54gjfe24WX35M4xf2+H7hh4SvdQo+JCdV4E+CE/7kOMrazaKsgesLe5Rf" +
       "uOUohwUS9BSU/Zx8ANjb4DpO5TjSH70VSL+8R/rlHxLSySlIZzkhr4OUO4F0" +
       "eCs09yt7pF+55UiL43pnfuwUpB/OCQti2HxmHvmX4xiXN4uxAa6v7jF+9YeE" +
       "UTsFo5ETMSxdBBhPeJnjOKWbwPn2PPFHwPX1Pc6v31KcxTN4f37P4Ynla96X" +
       "58Xt/hulAnZwSpfEObFBl0i+IoTKrrBhawcNPXqioR2DIhP501GXOW/qcCfw" +
       "f9f57CE/w/3wNV9k7b4ikn7l1Yt3PvQq86+Lk/+HX/rcRZXuVCPTPH7k8dj9" +
       "OddXVKPoz7t2ByDdAvSLYenpN7wAEeYv2QcPhSn/2K6WvxGWHj+9lrB0h3HQ" +
       "TwelXgpLD9+oVFi6DdDj3H8rLL31etyAE9DjnH8nLF06yQnaL/6P8/00wHPE" +
       "F5bO7W6Os3wa1A5Y8tufcQ8UgXjjKzYdMQjz2YU6Zv6FR6j4YFSLtZLdCs5O" +
       "ix8+PoGK6Pz+11OiwyLHv3rIxSg+9ztYZIl2H/w9L33pVXL8E99t/uLuqwvJ" +
       "FLIsr+VOqnR+9wFIUWm+UPPkDWs7qOsc/vT37v3Vu951sKh0707go8l8TLZ3" +
       "XP8Th77lhsVHCdlvPvRr7/sHr/5RcT7t/wEPapsahzkAAA==");
}
