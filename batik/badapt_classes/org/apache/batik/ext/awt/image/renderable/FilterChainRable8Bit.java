package org.apache.batik.ext.awt.image.renderable;
public class FilterChainRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.FilterChainRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private int filterResolutionX;
    private int filterResolutionY;
    private org.apache.batik.ext.awt.image.renderable.Filter chainSource;
    private org.apache.batik.ext.awt.image.renderable.FilterResRable filterRes;
    private org.apache.batik.ext.awt.image.renderable.PadRable crop;
    private java.awt.geom.Rectangle2D filterRegion;
    public FilterChainRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter source,
                                java.awt.geom.Rectangle2D filterRegion) {
        super(
          );
        if (source ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        java.awt.geom.Rectangle2D padRect =
          (java.awt.geom.Rectangle2D)
            filterRegion.
            clone(
              );
        crop =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            source,
            padRect,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        this.
          chainSource =
          source;
        this.
          filterRegion =
          filterRegion;
        init(
          crop);
    }
    public int getFilterResolutionX() { return filterResolutionX;
    }
    public void setFilterResolutionX(int filterResolutionX) { touch(
                                                                );
                                                              this.
                                                                filterResolutionX =
                                                                filterResolutionX;
                                                              setupFilterRes(
                                                                );
    }
    public int getFilterResolutionY() { return filterResolutionY;
    }
    public void setFilterResolutionY(int filterResolutionY) {
        touch(
          );
        this.
          filterResolutionY =
          filterResolutionY;
        setupFilterRes(
          );
    }
    private void setupFilterRes() { if (filterResolutionX >=
                                          0) { if (filterRes ==
                                                     null) {
                                                   filterRes =
                                                     new org.apache.batik.ext.awt.image.renderable.FilterResRable8Bit(
                                                       );
                                                   filterRes.
                                                     setSource(
                                                       chainSource);
                                               }
                                               filterRes.
                                                 setFilterResolutionX(
                                                   filterResolutionX);
                                               filterRes.
                                                 setFilterResolutionY(
                                                   filterResolutionY);
                                    }
                                    else {
                                        filterRes =
                                          null;
                                    }
                                    if (filterRes !=
                                          null) {
                                        crop.
                                          setSource(
                                            filterRes);
                                    }
                                    else {
                                        crop.
                                          setSource(
                                            chainSource);
                                    } }
    public void setFilterRegion(java.awt.geom.Rectangle2D filterRegion) {
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        touch(
          );
        this.
          filterRegion =
          filterRegion;
    }
    public java.awt.geom.Rectangle2D getFilterRegion() {
        return filterRegion;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return crop;
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter chainSource) {
        if (chainSource ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Null Source for Filter Chain");
        }
        touch(
          );
        this.
          chainSource =
          chainSource;
        if (filterRes ==
              null) {
            crop.
              setSource(
                chainSource);
        }
        else {
            filterRes.
              setSource(
                chainSource);
        }
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        org.apache.batik.ext.awt.image.GraphicsUtil.
          drawImage(
            g2d,
            getSource(
              ));
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext context) {
        return crop.
          createRendering(
            context);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zClv0njIEYsnDfRv/k2QiHfafwEQPB/iCykAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rjjdASc4ZKayOtlYLPMJrzBWRJKiOqGVdWhvh3QqoQLoeDCZ0jN50p9x9XDk" +
       "jpssCcUjVJSZ1UiGxqJP5nM5cGi+hnSJzrafbVSRXbprc26gMupvxOl0IWOE" +
       "EA2perJWR9qmyjXM7pgcVoNdZyMSfW5tDcXtrKPPlGpURcTGBOnPZpN0GKWq" +
       "3valWbev0+x22/GF+Qpaw3w9yDdot8tRK5FS9Kwtox11Y+cDFKHGLVisbSdi" +
       "3MIX8zXL+Js5KXIYM4vHxjAbjER3OK4hGxJvGYm/Xjv1TZxpyjraIFVRsvq9" +
       "BiQx1ZFojp1gBYX2kNnQ41lLyZSwX5tHmFqNIoKcNXSKiCEoNeieooqQOxTZ" +
       "rYVvGJQZE7isdNfdgF8riFyvtieJQAQU3c3F5jqxJkzVaYSBEnEDdc2wHYFd" +
       "tHncA1w1vZzvbmNZbHWHO3TFIXPB7S9WxGzRdvvuaIUvFF6rZQhr7GjTxrPZ" +
       "kqUwZtQxXSOfDJfOYE7RDc9vaLZaM0dVZslK1mTqDHZSFRmJ9HK5GyusxbBj" +
       "m9nig6bXZ6iqv/T5DSGMW3gkRbpMaooxCnDBX4vNpulxzGbgoyRn41tqlNLA" +
       "mDbYJJqN53Mo3NYNozaEGiOjL+W43+M1y2Y382zIsWLT7SibJe9PMZlgZ6xf" +
       "N/rrvAVTuEziuNG0yJoqtjAocNidGzXaat7nmhGzUxbyxNpsSZPyF8MBG+2S" +
       "eYg7xHDsI4jSzdomFzVaSVTPw2BL+yMZLA59vr9MdggqJ935FGnUbRZd9OMZ" +
       "FlC51JAyFR6sxOmQV/vUECORmc/aHbW1nU6njFNvp5QhLXt1SXJXSgLNRG6w" +
       "DPs6t+4580QL4E511CcZcjTVeCzARQlC0MmMCU1lN8XHnammdB1ti3oNqk3T" +
       "a70mOv2NS0qkRJGOyMC1ppXKC1JeopzWqVGy20UgaEDTATAEg9v0/C3jd8xg" +
       "sESWRDyhaU4cjOpsD+05FsMFnOLQiSUp84G/60v2oAO2SHWr28U6vXkVRs11" +
       "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" +
       "98Ydt9NqieLSTRA+XGT3A4TRSYTHFnrm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gdu10OJqwx8eIPzDO6++J25S91SRPRpX7gfq6/qJp0c14mrrPPPYbcB7pCh8" +
       "EqTvHsD77h1V4GFE+8jRPTQ6VIOVpUX7G2hn3nsT6O8vsufiyn3BUZB7vWjh" +
       "/ML3HUP1jgVy+TYE8q6i8L2A9QN57L/vuEB+8Egg14T0Yvl4cI2/FAR2EyEV" +
       "26UzKPBgWmiosbFvbHnLw4GeODXQnsDQmeLXscgatyKyHCzx17sXXFxyfOya" +
       "fy3sb9prv/LaxXsffU361+XV2KPb8BfYyr1m4jgnL46deD4XhIZplQK9sL9G" +
       "FpSoqbjywlveJMXFbuDwRwHmDLnvhYkrT928l7hyj3UoqMNWbFx57Eat4spd" +
       "ID9JDQz07dejBpQgP0kpxpVLpynB+OX3SToJ4Dmmiyvn9g8nSeagd0BSPMpH" +
       "12dab31X2VlEcahqBxvLvdE+dnK+lKviw29mM0dNTl4CLgYt/wBzuPdL9n+B" +
       "eVn70mv94Ye+0/z8/hKy5qi7XdHLvWzl/P4+dNlpsX985oa9HfZ1rvfC9x78" +
       "1QvPH+51H9wzfDx3T/D29PVv/JJuEJd3dHd//9Ff++G/+9rvl5dR/i+UxQDf" +
       "mTQAAA==");
}
