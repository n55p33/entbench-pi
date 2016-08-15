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
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYf3BURx3fu/wgCfkNCRBIgBBAfngnbdHBIAJpUoIXyBDA" +
           "8Wg59t7t3T3y7r3He3vJJTWVMirojIiYUnTa+IcwVIYWdNqpWtvB6WhLwTot" +
           "YKlOqaPOiFbGMo7VEbV+d/fdvR+Xuwwzkpm3ebf73e9+f3+++87cRGWmgdqI" +
           "SgN0RCdmoFul/dgwSaxLwaa5HeYi0uMl+G+7b2xZ40flYVSbxGafhE3SIxMl" +
           "ZoZRq6yaFKsSMbcQEmM7+g1iEmMIU1lTw6hJNntTuiJLMu3TYoQR7MRGCDVg" +
           "Sg05mqak12JAUWsIJAlySYIbvMudIVQtafqITT7bQd7lWGGUKfssk6L60F48" +
           "hINpKivBkGzSzoyBVuiaMpJQNBogGRrYq6y2TLA5tDrPBO3n6j64fSRZz00w" +
           "A6uqRrl65jZiasoQiYVQnT3brZCUuQ89gkpCaLqDmKKOUPbQIBwahEOz2tpU" +
           "IH0NUdOpLo2rQ7OcynWJCUTRQjcTHRs4ZbHp5zIDhwpq6c43g7YLctoKLfNU" +
           "fGxFcPzx3fU/KEF1YVQnqwNMHAmEoHBIGAxKUlFimBtiMRILowYVnD1ADBkr" +
           "8qjl6UZTTqiYpsH9WbOwybRODH6mbSvwI+hmpCWqGTn14jygrF9lcQUnQNdm" +
           "W1ehYQ+bBwWrZBDMiGOIO2tL6aCsxiia792R07HjM0AAW6elCE1quaNKVQwT" +
           "qFGEiILVRHAAQk9NAGmZBgFoUNRSkCmztY6lQZwgERaRHrp+sQRUldwQbAtF" +
           "TV4yzgm81OLxksM/N7esPfywukn1Ix/IHCOSwuSfDpvaPJu2kTgxCOSB2Fi9" +
           "PHQMN794yI8QEDd5iAXN85+/tX5l2/lXBc3cSWi2RvcSiUakE9HaN+Z1LVtT" +
           "wsSo0DVTZs53ac6zrN9a6czoUGGacxzZYiC7eH7bzz+3/zR5z4+qelG5pCnp" +
           "FMRRg6SldFkhxgNEJQamJNaLKoka6+LrvWgavIdklYjZrfG4SWgvKlX4VLnG" +
           "f4OJ4sCCmagK3mU1rmXfdUyT/D2jI4Smw4O64LmAxB//T9H2YFJLkSCWsCqr" +
           "WrDf0Jj+ZhAqThRsmwxGIeoHg6aWNiAEg5qRCGKIgySxFhJDFJxPIXrUfgyx" +
           "GmDRpd8lvhmmz4xhnw9MPc+b6ArkyCZNiREjIo2nN3bfeiZyUQQRC3zLEhSt" +
           "haMC4qgAPyoARwWcR3U4f1iF4bMG1iGskc/HD5/JpBE+Bg8NQq5Dsa1eNvDQ" +
           "5j2H2ksguPThUjAvI213gU6XXRCyVTwinW2sGV14fdXLflQaQo1YommsMAzZ" +
           "YCSgOkmDVgJXRwGObFRY4EAFBmeGJpEYFKVC6GBxqdCGiMHmKZrp4JDFLJad" +
           "wcKIMan86Pzx4Ud3fuFjfuR3AwE7sgxqGNvez8p3rkx3eAvAZHzrDt744Oyx" +
           "Mc0uBS5kyQJi3k6mQ7s3PLzmiUjLF+DnIi+OdXCzV0KppuBwVgXbvGe4Kk1n" +
           "tmozXSpA4bhmpLDClrI2rqJJQxu2Z3jcNvD3mRAWFSz12uG5ZOUi/89Wm3U2" +
           "zhJxzuLMowVHhU8N6E9ee/1P93JzZwGkzoH8A4R2OooWY9bIy1ODHbbbDUKA" +
           "7p3j/d987ObBXTxmgWLRZAd2sLELihW4EMz8pVf3vf3u9RNX/Lk4Rxm3bhVF" +
           "dINDlthiQK1ToC6wYOnYoUJYynEZRxXC8unfdYtXPfeXw/XC/QrMZKNn5dQM" +
           "7Pk5G9H+i7v/0cbZ+CSGtbapbDJRwGfYnDcYBh5hcmQefbP1W6/gJwEKoPya" +
           "8ijhFbWEq17CNZ9N0UemrCtWKXHXBJZ3A+moCfkrp8BdQxaa3dO/RzrU0f8H" +
           "gVRzJtkg6JqeCn5t51t7L/FgqGAVgs0zmWoc+Q+VxBGJ9cJbH8KfD57/sod5" +
           "iU0IVGjssqBpQQ6bdD0Dki8r0ky6FQiONb47+MSNp4UCXuz2EJND41/9MHB4" +
           "XLhaNDiL8noM5x7R5Ah12PBJJt3CYqfwHT1/PDv2wlNjB4VUjW647oZu9Olf" +
           "/edS4PhvL0yCHCWy1aTey0p7rsDPdPtGKHT/V+p+cqSxpAdqSy+qSKvyvjTp" +
           "jTk5Qn9mpqMOZ9mNE59wqsYcQ5FvOfiATazh431clmBOImSlIvvdy4bFprPO" +
           "uv3l6MMj0pEr79fsfP+lW1xndyPvLCt9WBcGb2DDEmbwWV4c3ITNJNDdd37L" +
           "g/XK+dvAMQwcJYB4c6sB0JxxFSGLumzar3/6cvOeN0qQvwdVKRqO9WBez1El" +
           "FFJiJgHVM/qn14uCMsyqSz1XFeUpnzfBknr+5OWiO6VTnuCjP5z17NpTE9d5" +
           "QdMFj7lWdkOj4QJwfh20MeT05U9cPfWNY8Minopkh2ff7H9tVaIHfvfPPJNz" +
           "yJwkYTz7w8EzT7R0rXuP77exi+3uyOQ3R4D/9t57Tqf+7m8v/5kfTQujesm6" +
           "fu3ESpohQhiuHGb2TgZXNNe6+/ogeuXOHDbP82as41gvajoToZS6gt4DlAvg" +
           "ec0Ck9e8QOlD/GUX37KUDSvyoajQbkhpXZfY62oBuGzczIYHRRD0FYy5He5T" +
           "5sJz0TrlYgEZo0VlLLSbovLMQFKOc+xb4xFTugtiymyA8ls+UvDYvUWOFUtL" +
           "+bicDR8VhRIYmvymbbcKPEGrkOdK4mwV7ET0ZWG2iecyHmbQamMqq0Wthe6U" +
           "vPCfODA+Edt6cpXfqpAbQCDrqu9O91ZXuvfxK7SdO+/UHv39jzoSG++kVWdz" +
           "bVM04+z3fEjc5YUriFeUVw78uWX7uuSeO+i653tM5GX5vb4zFx5YIh318+8F" +
           "IqnzvjO4N3W6U7nKIDRtqG4UW5RzeR3zcCs8ly2XX/ZGoR1qk8aQno4qzhji" +
           "YV1bhGERkPxikbUvs2GMomkx2YQ+WvTxa61Gg/1bT1HpkCbH7Kx4ZKpkLI5T" +
           "bGJA5/MjOfVa2NpSeK5a6l0tYi827M+3TKGtRbQfL7J2jA1fp6gmQSD7FM1g" +
           "4a9k03NOLj3lFE6QgIeCG+rIXTBUM1ubD881S9trd26oQls9xijlgpTmCqNj" +
           "4Id8t4jxTrJhgqJKMN42bFKr+rjqmjCcY5Ub7Tv/D6NlKGop/HEjK8rCKW8y" +
           "UCZn531nFd8GpWcm6ipmTex4i1fI3Pe7aqh18bSiOFHf8V6uGyQucxNVix5A" +
           "dLrfp2jmZNIAcsPIBT4nKJ+lqN5LSVEZ/++ke56iKpsOKop4cZL8GLgDCXt9" +
           "Qc8apZ77h7U9AdH2ZHwO4LBMzj3VNJWncluc121W7vkX7mxpTotv3BHp7MTm" +
           "LQ/f+vhJcd2XFDw6yrhMhwuE+PKQK+8LC3LL8irftOx27bnKxVkUbBAC27kx" +
           "1xGsA1ByddY/t3guxWZH7m789om1L/3iUPmb0IfuQj5M0Yxd+Q1iRk8Dru4K" +
           "5V+UAAr5bb1z2bdH1q2M//U3vAVH4mI1rzB9RLpy6qHLR2efgFv99F5UBgBP" +
           "MrxzvX9E3UakISOMamSzOwMiAhcZK65bWC0LS8y+fXO7WOasyc2yj0UUtedf" +
           "QPM/scF1ZZgYG7W0GuOAB1Bsz7g+vWcRMs1yzbXBnnFc0rsF2DBvQDxGQn26" +
           "nr2fV/XoPKF7vLdRPsl3v85f2fDL/wH52JVN/RoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "85Pj/wNzKN4rfiUAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUZa2wcxXnu/Iwf8SMPmyR2HjihCeEOaKBQh4fjvA4uthWH" +
       "iDoFZ25v7rzJ3u5md84+h6YlSChupQIlITwE+VEFQVMgtCqCqoBS0RQQtBKP" +
       "QmlFqNqq0NKoRFVpC6X0+2Z2bx/nu8hSY2nHezPf9833/r6Zfew0qbEt0s10" +
       "HuOTJrNjG3Q+RC2bpfs1atvbYG5UubeK/v3mDwaujJLaETJ7jNpbFGqzjSrT" +
       "0vYI6VJ1m1NdYfYAY2nEGLKYzaxxylVDHyHzVDuRMzVVUfkWI80QYDu1kqSN" +
       "cm6pqTxnCYcAJ11J4CQuOIn3hZd7k6RJMcxJD7zTB97vW0HInLeXzUlrchcd" +
       "p/E8V7V4UrV5b8EiF5qGNpnVDB5jBR7bpV3mqOC65GUlKlj2ZMvHn9411ipU" +
       "MIfqusGFePZWZhvaOEsnSYs3u0FjOXsP+TqpSpJGHzAnPUl30zhsGodNXWk9" +
       "KOC+men5XL8hxOEupVpTQYY4WRokYlKL5hwyQ4JnoFDPHdkFMki7pCitlLJE" +
       "xHsujB+69+bWH1aRlhHSourDyI4CTHDYZAQUynIpZtl96TRLj5A2HYw9zCyV" +
       "aupex9LttprVKc+D+V214GTeZJbY09MV2BFks/IKN6yieBnhUM6vmoxGsyDr" +
       "fE9WKeFGnAcBG1RgzMpQ8DsHpXq3qqc5WRzGKMrYcz0AAGpdjvExo7hVtU5h" +
       "grRLF9Gono0Pg+vpWQCtMcABLU4WlCWKujapsptm2Sh6ZAhuSC4B1CyhCETh" +
       "ZF4YTFACKy0IWclnn9MDa++4Rd+sR0kEeE4zRUP+GwGpO4S0lWWYxSAOJGLT" +
       "quRhOv+5qSghADwvBCxhnv7amWtXd594ScIsnAZmMLWLKXxUOZqa/dqi/pVX" +
       "ViEb9aZhq2j8gOQiyoacld6CCRlmfpEiLsbcxRNbf/6VW4+xD6OkIUFqFUPL" +
       "58CP2hQjZ6oaszYxnVmUs3SCzGJ6ul+sJ0gdvCdVncnZwUzGZjxBqjUxVWuI" +
       "36CiDJBAFTXAu6pnDPfdpHxMvBdMQkgdPGQVPCuJ/BP/OdkWHzNyLE4Vqqu6" +
       "ER+yDJTfjkPGSYFux+Ip8PrdcdvIW+CCccPKxin4wRhzFrLjHIzPwXv0IQq+" +
       "GkPvMs8R3QLKM2ciEgFVLwoHugYxstnQ0swaVQ7l120488ToK9KJ0PEdTUBW" +
       "ga1icquY2CoGW8X8W5FIROwwF7eUhgQz7IaAhozatHL4put2Ti2rAg8yJ6pB" +
       "hwi6LFBZ+r2od1P1qHK8vXnv0lOXvBAl1UnSThWepxoWij4rCylI2e1EaVMK" +
       "ao6X+pf4Uj/WLMtQWBoyT7kS4FCpN8aZhfOczPVRcAsThmC8fFmYln9y4r6J" +
       "/du/cXGURIPZHresgUSF6EOYo4u5uCcc5dPRbTnwwcfHD+8zvHgPlA+36pVg" +
       "ogzLwj4QVs+osmoJfWr0uX09Qu2zIB9zMDGmuu7wHoF00uumZpSlHgTOGFaO" +
       "arjk6riBj1nGhDcjnLNNvM8Ft2jE+OqA5wYn4MR/XJ1v4tghnRn9LCSFSP1X" +
       "DZsP/fqXf/6iULdbJVp85X2Y8V5fZkJi7SIHtXluu81iDODevW/o4D2nD+wQ" +
       "PgsQ50+3YQ+O/ZCRwISg5ttf2vPOe6eOvhn1/JxDac6noMMpFIXEedJQQUjY" +
       "bYXHD2Q2DbIAek3PDTr4p5pRaUpjGFj/aVl+yVN/vaNV+oEGM64brT47AW/+" +
       "vHXk1ldu/me3IBNRsLJ6OvPAZLqe41Husyw6iXwU9r/edf+L9CFI/JBsbXUv" +
       "E/mzWuigWkjeWS6LbLKoOaYq9gDEmQt5ntiDTvBYlhk5KFoKeGZWY5euD+YN" +
       "jM3hfMqGGFdzYNJxp6xdOrRTmeoZ+qMsWedNgyDh5j0a//b2t3e9KhymHrMI" +
       "ziMTzb4cAdnG562t0pCfw18Env/igwbECVke2vudGrWkWKRMswCcr6zQVQYF" +
       "iO9rf2/3gx88LgUIF/EQMJs69K3PY3cckl4gO53zS5oNP47sdqQ4OFyF3C2t" +
       "tIvA2Pj+8X0/eXTfAclVe7Bub4C29PG3Pns1dt/vXp6mhNSlDENjVKa+NRga" +
       "xUIwN2gfKdT6b7Y8e1d71UbIQQlSn9fVPXmWSPupQrNm51M+g3ldlJjwi4fG" +
       "gRq1Cu3g+FhX0Mf6MhnIcdss4BDTlkC+TMBeXGSZCJaJWBvAYbntT9hBo/q6" +
       "9lHlrjc/at7+0fNnhGKCbb8/P22hprRKGw4r0Cod4YK6mdpjALfmxMBXW7UT" +
       "nwLFEaCoQENgD1pQyAuBbOZA19T95qcvzN/5WhWJbiQNmkHTG6koDGQWZGRm" +
       "j0EPUDCvuVYmpIl6GFqFqKRE+JIJTAqLp083G3ImFwli7zMdP1r7yJFTIjM6" +
       "Nlgo8GuxLQl0AuLw6BWjY2986VePfOfwhHS6CiEUwuv8ZFBL3fb7f5WoXNTe" +
       "aaIqhD8Sf+zBBf1XfyjwvSKI2D2F0lYKGgkP99JjuX9El9WejJK6EdKqOIe1" +
       "7VTLY2kZgQOK7Z7g4EAXWA8eNmRn3Vss8ovCYe3bNlx+/ZFSzQNR4VXcJjRh" +
       "NzxxpxjFwxU3QsTLToFygRhX4XCRW+DqTEuFAz0LVbjGCkQ5MAeRju+Xy4qO" +
       "4yAOVJLZWtYXR4K8r4BnjbPNmjK8q5J3HJRSJsthc9Jsyg53K8s63cIVIW53" +
       "zZDbi+DpdfbrLcOtWZHbctictDrcFnMYzl8fYnjPDBnuhKfP2bKvDMMTFRku" +
       "hw0+AOmiWPIvLmkOMMAxPas5OCTHoMuE5IZ9CwSqxmUg+gQrzFCwLng2Oaxt" +
       "KiPYrRUFK4fN5UkioxkT+HttiNH9M2R0NTwJZ6tEGUYPVGS0HDYnjRq1uXON" +
       "4xriC2c96zkIIbmmKshV8Pi7sMif+KslodO1vw/2qkTE5W52sWoLVrBCdpW7" +
       "FxE9y9HbDh1JDz58SdSp2+s5lDzDvEhj40wL1aGuQB3aIm6CvKT+7uy7//Dj" +
       "nuy6mRxGca77LMdN/L0YKsqq8qUtzMqLt/1lwbarx3bO4Fy5OKSlMMnvbXns" +
       "5U0rlLuj4tpLVpuS67IgUm+wxjRYjOch/QQqzflFc2MmIRfAs98x9/6wM3sO" +
       "FfKU4ompHGqFPu27FdaO4vAQtGBZxv3HEFGXPM8+craIrdwe4cSNMqnfXxQJ" +
       "D7lkOTxTjkhTM9dGOdQKEh+vsPYDHI5BiIE2htzCp4gwv8JTxvfPgTIW4loM" +
       "njsdie6cuTLKoVYQ+NkKa8/j8DQnczxlBOuqp5FnzoFG5uAatmUHHbEOzlwj" +
       "5VArSP1yhbVXcPgZ1AzQyKC/vnmaOHkONCHSBgbKA444D8xcE+VQQ9LWCEZq" +
       "Si8hZAcCBxvDwoSvuRDtRYjiDYWIFs9BAKjDB4QtjKpnN0PlsgXfb1VQ+Ckc" +
       "XoMuVLEYtNehMj0vWAj9q8IWr58DW7S4XnnSUejJmduiHGoFRXxYYe00Dn+S" +
       "KVwEqEnxPnJSAH8Zh6ukdNf43vs5qVKdj2e+qwj8mSh4Knz//6HCAidN/uYJ" +
       "T8udJd/b5Dci5YkjLfUdR254W7QYxe84TdAsZPKa5j/P+d5rTYtlVKGNJnm6" +
       "M8W/TziZO10vB8LDKPj9t4T8DA4PYUhOasR/H1yEcNLgwXFSK1/8IFVAHUDw" +
       "tdp0fbVV+CoeaGPyQFuI+Dov4lP5vLOpvIjiv5HFfkl86XR7m7z81jmqHD9y" +
       "3cAtZy5/WN4IKxrduxepNCZJnbycLvZHS8tSc2nVbl756ewnZy13O8k2ybDn" +
       "8gt9fnkj+JOJtl4Qui61e4q3pu8cXfv8L6ZqX4+SyA4SoVBsdpQe/QtmHhrT" +
       "HcnSOzLoJcU9bu/KByavXp3522/F5QqRd2qLysOPKm8+ctMbd3ce7Y6SxgSp" +
       "gSaZFcSdxPpJrPjj1ghpVu0NBWARqKhUC1zAzUa3pJjGhF4cdTYXZ/F7AifL" +
       "Su8fS7/CNEAJYdY6I6+nkUwz9LLejNsnB1rMvGmGELwZx5Q4bpbBjtYAfxxN" +
       "bjFN93q29nJTRGZi+uhHx+0Qr/jW+T/rCSFKBSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XTEsAAA=");
}
