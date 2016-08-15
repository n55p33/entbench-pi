package org.apache.batik.ext.awt.image.renderable;
public class RedRable extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    org.apache.batik.ext.awt.image.rendered.CachableRed src;
    public RedRable(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          (org.apache.batik.ext.awt.image.renderable.Filter)
            null);
        this.
          src =
          src;
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return src;
    }
    public java.lang.Object getProperty(java.lang.String name) { return src.
                                                                   getProperty(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { return src.getPropertyNames(
                                                                ); }
    public java.awt.geom.Rectangle2D getBounds2D() { return getSource().getBounds(
                                                                          );
    }
    public java.awt.image.RenderedImage createDefaultRendering() {
        return getSource(
                 );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        java.awt.Rectangle aoiR;
        if (aoi !=
              null)
            aoiR =
              aoi.
                getBounds(
                  );
        else
            aoiR =
              getBounds2D(
                ).
                getBounds(
                  );
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          getSource(
            );
        if (!aoiR.
              intersects(
                cr.
                  getBounds(
                    )))
            return null;
        if (at.
              isIdentity(
                )) {
            return cr;
        }
        if (at.
              getScaleX(
                ) ==
              1.0 &&
              at.
              getScaleY(
                ) ==
              1.0 &&
              at.
              getShearX(
                ) ==
              0.0 &&
              at.
              getShearY(
                ) ==
              0.0) {
            int xloc =
              (int)
                (cr.
                   getMinX(
                     ) +
                   at.
                   getTranslateX(
                     ));
            int yloc =
              (int)
                (cr.
                   getMinY(
                     ) +
                   at.
                   getTranslateY(
                     ));
            double dx =
              xloc -
              (cr.
                 getMinX(
                   ) +
                 at.
                 getTranslateX(
                   ));
            double dy =
              yloc -
              (cr.
                 getMinY(
                   ) +
                 at.
                 getTranslateY(
                   ));
            if (dx >
                  -1.0E-4 &&
                  dx <
                  1.0E-4 &&
                  (dy >
                     -1.0E-4 &&
                     dy <
                     1.0E-4)) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cr,
                  xloc,
                  yloc);
            }
        }
        return new org.apache.batik.ext.awt.image.rendered.AffineRed(
          cr,
          at,
          rh);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mXwQuSM1vIu92v8CWGXZAQwgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TghGJcHH7qDhLxbF34ihtwANhdAvryDcYl91v8N9ovfPvQG9315UPgue9qHe" +
       "7Td/Uj91h7ZPF8XfBOqdUnkAXDIC8fTs7eOpPGDab5i+8uvPfP1nXnnm35fn" +
       "LJfNaC6FeLi+xbWEU32+++o3v/0Hb33iC+U55t2yFO0d/vx9jpuva5y5hVEq" +
       "8MCxKYsjAejxwiyHpiy/Y+jGzZv5f+3aJpEic5P4sfae/THgtf12+7Vys/3a" +
       "fuv8/R+4xg873RsDnO9Orr14zdPSw5YPSa780vsPDg4+8MJzQVAKMjrvcyeb" +
       "rp89OpH41VvP48VjiD5G50uO5q1jo6T8iVNA/MEYugtYpXj9TJAdD3lxz+fI" +
       "WR85cVbS8T2tOLM7atufqpv+wfFFHNCY3VL4eC98OdgprP9+/valO7T9ZlF8" +
       "PobuUQq59mrcgfzLhxFUxtmvvIE4K8HzafC8eOgcL775cfbbd2h7rSj+8R5a" +
       "CD/x1KjWOZqRd5YzUhy3rjXfPRgDcAEz52iHFKXu/+QN6P7OohIGD36oO/7m" +
       "6/61O7R9vSi+EkOPKqEGoq+j6VLixOPyUBnE0pEZ3nVshv2p8/jw1Llf/Dqx" +
       "xFffqCWKhIQ6tAT15lji3Hn6j57T5Mwdl+L18IJcyeuP72C5bxTFv4qhK3vL" +
       "HZusqP69E5P80Q9jkiyGLh/dtCmuDTx20x2//b005QuvXLn8jldm/3oP0kd3" +
       "x+7joMt64jinT2pPvV8KQk03S+Hv25/b7tHxP8bQcz/wTaC4SIWOfpQK/Ome" +
       "y7di6Mk7cwHIYh77y2Gvb8fQY7frBeAUlKep/xuAyFtRA0pQnqZ8HSyb5ynB" +
       "+OX3abr/AfQ5oQPYvn85TfLngDsgKV7/IjhyI+wHvzqFy1EcSkpczmp24WyO" +
       "fewnD38/PzmVlj9zZvEvr4seJb7J/sLoDeWLrzCDD73e/LX9tR7FkfK84HIZ" +
       "rNP7G0bHyfNTt+V2xOtS77nvPfil+549SvQf3At8Eo+nZHv3re/QdN0gLm+9" +
       "5P/oHf/gfX/3lW+UB9D/D5/oYvTHKwAA");
}
