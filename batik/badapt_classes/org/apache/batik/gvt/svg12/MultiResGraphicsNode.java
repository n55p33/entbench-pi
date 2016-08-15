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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aCZAU1fXP7LK77LLswb3Aci0aQGY4xGvBuCzXmllYWFzj" +
       "Ii49PX9nm+3pbrr/7A4Y4pGywFRiiOJZSqUqKMaAWB6VGKPBWMEzJB7EEEsx" +
       "0UowxlKS8qgYY977v3u6p2d6yCbiVvXfnv/f+//9d7//e/97ZJhlkkaqsQjb" +
       "alArslxjHZJp0USrKlnWeujrkW8tkf5xxYnV54dJWTcZ2SdZ7bJk0RUKVRNW" +
       "N5msaBaTNJlaqylNIEaHSS1qDkhM0bVuMkax2lKGqsgKa9cTFAG6JDNG6iTG" +
       "TCWeZrTNnoCRyTGgJMopibb4h5tjZISsG1td8PEe8FbPCEKm3LUsRmpjm6UB" +
       "KZpmihqNKRZrzphkjqGrW5OqziI0wyKb1UU2Cy6OLcpjwfQHaj76dFdfLWfB" +
       "KEnTdMa3Z62jlq4O0ESM1Li9y1WasraQb5KSGKnyADPSFHMWjcKiUVjU2a0L" +
       "BdRXUy2datX5dpgzU5khI0GMTMudxJBMKWVP08FphhkqmL13jgy7nZrdrdhl" +
       "3hZvnhPdfesVtQ+WkJpuUqNonUiODEQwWKQbGEpTcWpaLYkETXSTOg2E3UlN" +
       "RVKVbbak6y0lqUksDeJ32IKdaYOafE2XVyBH2JuZlpluZrfXyxXK/jWsV5WS" +
       "sNex7l7FDldgP2ywUgHCzF4J9M5GKe1XtAQjU/wY2T02fQ0AALU8RVmfnl2q" +
       "VJOgg9QLFVElLRntBNXTkgA6TAcFNBlpCJwUeW1Icr+UpD2okT64DjEEUMM5" +
       "IxCFkTF+MD4TSKnBJyWPfN5bvfiGK7VVWpiEgOYElVWkvwqQGn1I62gvNSnY" +
       "gUAcMTt2izT28Z1hQgB4jA9YwPzkGycvOqvx0DMCZmIBmDXxzVRmPfLe+MgX" +
       "J7XOOr8EyagwdEtB4efsnFtZhz3SnDHAw4zNzoiDEWfw0LrDl119H303TCrb" +
       "SJmsq+kU6FGdrKcMRaXmSqpRU2I00UaGUy3RysfbSDm8xxSNit41vb0WZW2k" +
       "VOVdZTr/DSzqhSmQRZXwrmi9uvNuSKyPv2cMQkg5POQ8eOYQ8TcbG0bi0T49" +
       "RaOSLGmKpkc7TB33b0XB48SBt33ROGh9f9TS0yaoYFQ3k1EJ9KCP2gPJARa1" +
       "BpLzF0Tb0ypTQPdXmpLRp8jWavBMEdQ140tZJYN7HTUYCoEYJvmdgAr2s0pX" +
       "E9TskXenly4/eX/P80LB0ChsLjGCC0fEwhG+cAQWjvCFI4UWJqEQX280EiBE" +
       "DgLrB9MH3ztiVufGizftnF4CumYMlgK3EXR6Tgxqdf2D49R75IP11dumvTH/" +
       "qTApjZF6SWZpScWQ0mImwVnJ/bY9j4hDdHKDxFRPkMDoZuoyTYCPCgoW9iwV" +
       "+gA1sZ+R0Z4ZnBCGxhoNDiAF6SeHbhu8puuqeWESzo0LuOQwcGmI3oHePOu1" +
       "m/z+oNC8NTtOfHTwlu266xlyAo0TH/MwcQ/T/RrhZ0+PPHuq9EjP49ubONuH" +
       "g+dmElgaOMVG/xo5jqfZceK4lwrYcK9upiQVhxweV7I+Ux90e7iq1vH30aAW" +
       "VWiJU+A51zZN/h9HxxrYjhOqjXrm2wUPEks6jbt+f+SdhZzdTjyp8SQCnZQ1" +
       "e3wYTlbPvVWdq7brTUoB7vXbOm66+b0dG7jOAsSMQgs2YdsKvgtECGy+7pkt" +
       "x46/sfeVsKvnDIJ4Og65UCa7SewnlUU2Caud4dIDPlAFD4Fa03SJBvqp9CpS" +
       "XKVoWP+qmTn/kb/dUCv0QIUeR43OOvUEbv+EpeTq56/4uJFPE5IxBrs8c8GE" +
       "Yx/lztximtJWpCNzzUuTb39augtCBLhlS9lGuact4zwo4zsfz8go9CmDC+VI" +
       "Qk9FMGOidqoDYxP4rNIgiyQpjK6DFSEsq3TBstxsFa2xMx23GF9bhLLLqw7/" +
       "wvrhnx8UoWx6AWBffLx3X4X8Wurw2wJhQgEEATfm3uh3u17d/ALXpwp0MtiP" +
       "FFd7XAg4I48y12blXIFirYEnZss5JuJMz/8ZAeKmkkjSaGfXyhVgmTYfl/JO" +
       "J8ic7iUyIJSZwb7QI5s998w4ctWeGX8E1eomFYoF/hb4VSDv8eB8sP/4uy9V" +
       "T76fu59SZLvN8tyEMT8fzEnzuDRqsLkwc0oNPBttNRuZJuVEJl72uM7xvpfP" +
       "Pbrv+7cMCuWZFcwFH974f65R49f+6RNuZHmxoEBS58Pvju6/s6H1wnc5vuuU" +
       "Ebspkx/ogdEu7oL7Uh+Gp5f9KkzKu0mtbJcZXZKaRlfXDay0nNoDSpGc8dw0" +
       "WeSEzdmgM8kfEDzL+sOBm2DAO3MMSUQAIaYQ4Q6wnWOcydvZ2Mzlkgnja4TB" +
       "pIomqbY//Rz+QvD8Gx+0L+wQdlbfaieVU7NZpQG2UaZSLcn6rKKy6zCVFISI" +
       "AdthRLfXH++/88QBIXO/oHzAdOfub38euWG3cMqiRJmRVyV4cUSZItwHNmvR" +
       "vqYVW4VjrPjLwe2P3bt9h6CqPjfhXg715IHfffZC5LY3ny2Q35WA8eCPViOT" +
       "NYCwYHPWWLhLRrFDUaJrFGOGMybSPEWPZAtCGMwUMKXJOabUzu3T1cvXR974" +
       "1qNNyaVDye+wr/EUGRz+ngI8mR0sYT8pT1/714b1F/ZtGkKqNsUnIf+UP2rf" +
       "/+zKM+Qbw7zmFAaTV6vmIjXnmkmlSaG41tbnGMsMYSxcesJSsJnDFYf/npeV" +
       "A+FyIBxWKTLGGd0LpiWjoIVeFAHX8noxMZhSOOVYnjIYTxK2/XTcw4v37XmD" +
       "Z0dGhhTQltG5oVjY07Lra36+q75kBShJG6lIa8qWNG1L5DKq3ErHPbHZrbxd" +
       "ttmWhf6BkdBsw1b8C3LjdR08B+x4fUD4kf4vJpiKog1CKi+f2lJSkhaM3V/m" +
       "coIFLdgMZoNkfTYVW6YAvOUYgVdU+HulQLOd9jeLOW1sOrgU1mLTic2l2GzL" +
       "dz/4cyM2Pfn+BH/HxbIcG5tkEUW9rsjYDmy+hY0qKCkCe32+wmPHlgJajD8Z" +
       "RxpwGDozr5YWMooISdgHbhxnUREivofNTMtbIuZ6Nc+JYo+865UPqrs+eOJk" +
       "XrqRWxG1S0azG4LPwMAzzl/Cr5KsPoA7+9Dqy2vVQ5/yVK5KkkH7rDVmgpqZ" +
       "nPrJhh5W/ocnnxq76cUSEl5BKlVdSqyQeClKhkMNSK0+XU1kjK9eJExtEI2v" +
       "lm+V5G0+kPl8YCLvLBcqmVtkNcAz1zbmuf5K0tbb2wvrLfHVa6VFpmJQ8piy" +
       "5XMnpY47CaTANb4fcL7nhMp10iA/CuyRf9yvtrx/3j1LRJifFiB8F/7RtW++" +
       "eNe2g/tF1MfQycicoFPo/KNvPCMoktt7zic/XHnBoXfe6toYthV0pL0VW+0n" +
       "uvmDSXsjnXqvW4chyD7DMIqYzyg+tAubO8ScNwVqi0/ujfBEbK5HAuS+3w2d" +
       "d+aLOgibkQoQdfa0f4mP0ANDJHQiPFF7qWgAoQ8VJTQIG2J5StE6uYcc8FH5" +
       "8P9A5Tx7nXkBVP6sKJVB2EillClM5WNDpHISPPPtdeYHUPlkUSqDsKFmiOtp" +
       "TdSV5/nI/OUQyRwHz0J7oYUBZD5TlMwgbEjqZWE63/HR+OwQaZwAzyJ7lUUB" +
       "NP6mKI1B2AzydpGPJNGIsO8cH7G/LUJsxpPvZhflf2XEPsd3/nsW9YSJkOOc" +
       "pufFZB68IF/KXsKhT54cdDvDC7C91+7ek1hz93zHAV7GILjpxlyVDlA1LzjF" +
       "c4850bV02hR3+pns8sS32ezhYRCqL4EI5W57VDa3cw7vFyzji71dJPE4gc1x" +
       "RkYaTgnaISn2wcl6bNYKuXwdAuGAriRcWb55KsX7b8K8j3n1OIaR/SGbAw8N" +
       "nXlBqD4mlHBCSqzCh4q+sn9BxyZ5Z1PH244yLPZwxselsoSedorpvNhXJA3H" +
       "kc/45B8FiyvEN3QSIpUsqfIy+0z4E1cofz8NQkGvRmbBc9jm7OGhCyUItchW" +
       "q4qMVWNTBnxMUldUS10/nmVIqPx0MeQr8Dxn7+q5oTMkCLXIpscXGWvAZhQj" +
       "dcCQlRRqTGZuLciP0adTQY7YmzoydH4EoRbZ88wiY7hMaKpQkE40sEAFmXYa" +
       "GIKVAc+sjtq7Ojp0hgShFtn0giJjZ2Mzl5FKYMiaNMPbdccZjcw6o84+yb68" +
       "46yJnAbWjMexM+E5Zu/v2NBZE4RaJDx+LJw0tpcWds2cSy1FOLgcm8VQYaOJ" +
       "eW7HHTZOK3irngfJObvki+BshpHRha7r8bxufN73QeKbFvn+PTUV4/Zc8qq4" +
       "f3G+OxkRIxW9aVX1nuJ73ssMKPIUzr0R4kDB4CxZw0hD8LcEUADw/0h/aLXA" +
       "WAc0F8KA/BZaL+QljNT6IWFG/t8LByG30oWD+CtevCAbYHYAwdfLDUdcswoS" +
       "3gKx35TkHAFnQp50zxYHD7ZjTiXFLIr3ihmrbv6Rl5NzpDvs4v7gnotXX3ny" +
       "nLvFFbesStt48VQVI+Xitp1PWpJ3UOCdzZmrbNWsT0c+MHymk7HUCYJd45ro" +
       "SQK3gBUYqDYNvvtfqyl7DXxs7+Infr2z7KUwCW0gIQnSzQ35d0cZIw159YZY" +
       "/lFvl2Tyi+nmWXdsvfCs3vdf4yfFJO9Ozg/fI7+yb+PLN47f2xgmVW1kGGTm" +
       "NMMvtZZt1dZRecDsJtWKtTwDJMIsiqTmnCOPRA2X8PMvzhebndXZXvxAAgqG" +
       "/Buc/M9KKlV9kJo8huA01TFS5fYIyfgO+NOG4UNwe2xRYmsJ34TSAEXtibUb" +
       "hnPRVXbU4Maed5EpfBZqNP8QCtPAkPEf9oOWjwAqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mrnN8S7sb2Jkg1p+kMznYDb26c1goBox");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("lyQIUIE4qs6dJKyxUkg2hElP38mg7liKeVirMsOtt0KHQm9B6kgzCrgp1bC6" +
       "wmLdX4w3m8Rcb10ULBljtDryzai+Qykh60mwNZr63A7M+jqsyaOs1uws5AXk" +
       "DjZund86Vd+T5nq8MXtxY6ObyNYckJPOZGdB5ggF5qyy9BhBzXpueaJUWxEE" +
       "740ZZpPIclLT5Zmh9WMykaiEz/okM4qdNe/5vQk7w+rzNstsdrah+vpcnm9y" +
       "DLPWBNRNNYjpUGAe6KzIoG2nGFzjB1zTXIy2pjWpjicEIoxBGJPPFl5MNsAS" +
       "G8PniaMKqu2zM3GuCgijGHoTD82uvB6z7WkvYbEVi5udYCItM2yNYdjPFVtX" +
       "/+6NbandV+4eHl8ZXbpoUfCv38CuWX7qpPZ4n7X8u1Q5vF549Htqn/XUsc+F" +
       "o53KJ645SysPnTiROL4bXBzKPHKjS6Pl4f3nPvLiS/rk87WjcxI6qdyZBOF7" +
       "XGMDQOqk19v3R4hnL4wVpxrcIcfc+Z3hE51co90LpXb3qjp3ynfhrIz3Hx+p" +
       "Hl0grPfLen9+k9PB7xTJq0nl3vDorgKrOIc3ns7veW4CRz8x3Ldfb7vzdFfn" +
       "NHK1yCyO375yqJGvvDkauWXvkNfj/pIepOr+Gus+KRv4wU1U85dF8v2kcoem" +
       "uFr/8NraD08U8NpPoIDizKLyDHi+fqiAr785CjjF/4Vbb1J2qcj8cVK5ahnJ" +
       "8S2V7smRzLGUFyo/qZTvBs8fHEr5B2++lFduUna1SO4GSASkJMDC2kii7XWF" +
       "vOfNMOU3DoX8xpsv5MM3KXu0SB7Ym5IrblLc0JQP/gRSlshbHEP+6aGUf/rm" +
       "S/num5Q9WyRPJpW7gJSTNCluqB/h3r3HuMfZyuGd3bLOUz+BvA8WmT8Nnm8d" +
       "yvutN0feCycEZMlk6yZCt4ukllQuF/576lL4keSPX/cy+TWUZVv1N6KMPKm8" +
       "9Xq30YurtQ9e8+8v+3/Z0L740uU7HnhJ+A/7a6pH/1ZxJ125w0xd9/RNwlPv" +
       "l8LIMJ1SVXfuL5SEJbtYUnnoxlflk8pt5W/B+IX37muAiOOt16uRVG4B6WlK" +
       "IqlcOU8JWix/T9ORwN1O6MAUsn85TcKA1gFJ8ToOj8zyzHUZx9Q4iRTtjCHz" +
       "C6fChkMfLLVw9fWsdVzl9KXv4pJH+T9MR3frUvbwLsmXXiLHH3yt9fn9pXPN" +
       "VXblTYA76Mrt+/vvZaPF/bzHb9jaUVuXhs/86N4v3/n0URh0757hk/FwirfH" +
       "rn/DG/fCpLyTvfsXD3z1Z//xS39WHt/+f1+B1MtcNgAA");
}
