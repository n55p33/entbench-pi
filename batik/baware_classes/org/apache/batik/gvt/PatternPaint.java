package org.apache.batik.gvt;
public class PatternPaint implements java.awt.Paint {
    private org.apache.batik.gvt.GraphicsNode node;
    private java.awt.geom.Rectangle2D patternRegion;
    private java.awt.geom.AffineTransform patternTransform;
    private org.apache.batik.ext.awt.image.renderable.Filter tile;
    private boolean overflow;
    private org.apache.batik.gvt.PatternPaintContext lastContext;
    public PatternPaint(org.apache.batik.gvt.GraphicsNode node, java.awt.geom.Rectangle2D patternRegion,
                        boolean overflow,
                        java.awt.geom.AffineTransform patternTransform) {
        super(
          );
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (patternRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
        this.
          patternRegion =
          patternRegion;
        this.
          overflow =
          overflow;
        this.
          patternTransform =
          patternTransform;
        org.apache.batik.gvt.CompositeGraphicsNode comp =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        comp.
          getChildren(
            ).
          add(
            node);
        org.apache.batik.ext.awt.image.renderable.Filter gnr =
          comp.
          getGraphicsNodeRable(
            true);
        java.awt.geom.Rectangle2D padBounds =
          (java.awt.geom.Rectangle2D)
            patternRegion.
            clone(
              );
        if (overflow) {
            java.awt.geom.Rectangle2D nodeBounds =
              comp.
              getBounds(
                );
            padBounds.
              add(
                nodeBounds);
        }
        tile =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            gnr,
            padBounds,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
    }
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
    }
    public java.awt.geom.Rectangle2D getPatternRect() { return (java.awt.geom.Rectangle2D)
                                                                 patternRegion.
                                                                 clone(
                                                                   );
    }
    public java.awt.geom.AffineTransform getPatternTransform() {
        return patternTransform;
    }
    public boolean getOverflow() { return overflow; }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform xform,
                                               java.awt.RenderingHints hints) {
        if (patternTransform !=
              null) {
            xform =
              new java.awt.geom.AffineTransform(
                xform);
            xform.
              concatenate(
                patternTransform);
        }
        if (lastContext !=
              null &&
              lastContext.
              getColorModel(
                ).
              equals(
                cm)) {
            double[] p =
              new double[6];
            double[] q =
              new double[6];
            xform.
              getMatrix(
                p);
            lastContext.
              getUsr2Dev(
                ).
              getMatrix(
                q);
            if (p[0] ==
                  q[0] &&
                  p[1] ==
                  q[1] &&
                  p[2] ==
                  q[2] &&
                  p[3] ==
                  q[3]) {
                if (p[4] ==
                      q[4] &&
                      p[5] ==
                      q[5])
                    return lastContext;
                else
                    return new org.apache.batik.gvt.PatternPaint.PatternPaintContextWrapper(
                      lastContext,
                      (int)
                        (q[4] -
                           p[4] +
                           0.5),
                      (int)
                        (q[5] -
                           p[5] +
                           0.5));
            }
        }
        lastContext =
          new org.apache.batik.gvt.PatternPaintContext(
            cm,
            xform,
            hints,
            tile,
            patternRegion,
            overflow);
        return lastContext;
    }
    public int getTransparency() { return TRANSLUCENT;
    }
    static class PatternPaintContextWrapper implements java.awt.PaintContext {
        org.apache.batik.gvt.PatternPaintContext
          ppc;
        int xShift;
        int yShift;
        PatternPaintContextWrapper(org.apache.batik.gvt.PatternPaintContext ppc,
                                   int xShift,
                                   int yShift) {
            super(
              );
            this.
              ppc =
              ppc;
            this.
              xShift =
              xShift;
            this.
              yShift =
              yShift;
        }
        public void dispose() {  }
        public java.awt.image.ColorModel getColorModel() {
            return ppc.
              getColorModel(
                );
        }
        public java.awt.image.Raster getRaster(int x,
                                               int y,
                                               int width,
                                               int height) {
            return ppc.
              getRaster(
                x +
                  xShift,
                y +
                  yShift,
                width,
                height);
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
           "8f8B27kLc34lAAA=");
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
       "12O+I3XBhv6jHy22+l98a0cQj5WnLcdPD2ynPL/6qbdwyrCver5IPnh8lFX+" +
       "XYbOXVefOso6dex+4ehk59HjO4zyKKq4L3j2bg8NyguUL3/6lVc14SvVi4e3" +
       "GDcT6MHED37U0TPdOTXCZdDTi3c/2OfLdxYnp+vf+vR/f2b8MfOTb+F2973n" +
       "+Dzf5S/zX/0d+kPqz16E7js+a7/tBcjZRjfPnrBfjfQkjbzxmXP2Z48FXhzJ" +
       "Qj8Cvk8dCvxT588OT6b0zgeHH96rxD0uib52j7qvF8kvJdC1lZ6cvvkriisn" +
       "ivTLb3RcdbrfsuArxxCL+2Pog+B7+RDiy+88xH9+j7rfKJJfB2oKIIpHB/5q" +
       "eVRaO0H4jbeB8IeLwqL+c4cIP/fOI/zmPeq+VSSvJdATJwjP3hucwPyttwHz" +
       "iaKwuBP6wiHML7zzML9zj7p/VyTfTqCHAEzh9NH9Cbx//TbgPX2kpz9/CO/n" +
       "3xl4l0qCS7ffpe+vRwjf8SMemJxzRPH4McXxRXuprCdT+WRyeCO7JyruVyxv" +
       "1QPONy5Z+MN7SPG/FMnvJ9AjaqQriX7upuHJs778dG0p4D94GwK+dqQ/3zwU" +
       "8Dffef15/R51/6NI/nTv60r7CJTircz2Tmf291neKdTffyuo8wR6+PTVTPFI" +
       "4+nbnkfun/Spv/rqtQeeenXyH8qnPcfP7h7koAeM1HFO39Seyl8OIt2wSkwP" +
       "7u9tg/LfXybQu+50UwTggLRk9C9KygtQAl0/T5lAl8r/p+nuS6CrJ3QJdHmf" +
       "OU1yGfQOSIrsleAOlz37q+r8wqm4fqgZpWgffyPRHjc5/eanWAuUD1OP4na6" +
       "f5p6S/36q/3Bj7/e/Mr+zZHqKLtd0csDHHRl//zpOPY/f9fejvq63HvhB4/+" +
       "2oMfPFqnPLpn+ERLT/H23js/8Om6QVI+ydn9s6d+/cf+8at/VN49/T/WaSun" +
       "MSwAAA==");
}
