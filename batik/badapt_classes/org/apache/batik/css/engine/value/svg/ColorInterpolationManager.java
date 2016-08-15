package org.apache.batik.css.engine.value.svg;
public class ColorInterpolationManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINEARRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LINEARRGB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SRGB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SRGB_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_INTERPOLATION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 SRGB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorInterpolationManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tj0fv3TPO+ekRLbvPD0ejT+HPG722DUwYT2OzYOn27ZD99hNWIi1iJlOFRl7" +
       "Fpvv+03YCbHKqcbqRIGPNalddbkWOnENLDQRx+bCE7fVjI/dQoVYi1jhZ0XG" +
       "XsLmJ5aF1rIUzShWwe5YaNHo9apLLwz3/DUwXAOOzYeH2trTsRuuEGsR47xR" +
       "ZOzX2JzhZAIYri0J2RIO/MyqK3tcY/zyf2GMLCfTC1794Tl1Wt5/E9Z9uvTM" +
       "kdqKqUfuPCeq5dyddzVUP6mMonhPUp73Mt1gKVkoWW2dq3Tx9Q4nCz7XPSWE" +
       "IGiFNucs1vc4mTcqKxyvBnJQshnPczKzCCMcr6wXL88fIK2OxANiQeul/BAi" +
       "QJASpBDfXrqPOKly6WBR68VL8jHMDiT4elF3nOfG0c3lQsfez2zIfwbLQalh" +
       "NCh5jm3zfbWq+IPLKeYy1l9cvdLJI+2d91z+wpPWnZ6k0OFhnGU8lHDWzWHu" +
       "1DKv4GzOXGUbFl+ZcKpygVNb+u4UvbIJQEM+EvdvMwKXXGZz7q7r3aMrX/zV" +
       "3rK3oCreQkIUTgdb8u8PsnoGjotbYvmlKpzwxO1by+LHhlYtS/31PXFDQ/Lu" +
       "ZYL0vdLZY3e/fWDa0cYwGd9GSqFsZllxsbF2SO1m0oARJzWyuS4LIuK+UcVX" +
       "B09AD6OYR4RdbHPW5HrxspeTpvzqPv+KvErRBpmxRsuoSZwGKunxbo9zevUd" +
       "/DK6HmBwezwHmqxVLOBuAGR7Yx267tyUjluki4gzNHL1gO1n4hWbq/8Fm51z" +
       "ffweAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A04rqALHGS3ubld0r2cSVJPd9acO8BAPxvrOjOzPI2xgruINx1LevitifLe3" +
       "pHvuhBk4QtvwRq2ANcd1reXNEtMomgVhblV6pnj2FLc7rt8qTFXc1AiOpgxp" +
       "3/BQLddpkqg1dbRR1LYRJwZyd11nR3YwXvS8yQCk+JOsMaDy9rhgV+OFOvJq" +
       "skZFe2s5VWtZe5GrBDkbMrVhrufMllqtxnKBbJC4pTDxCi6WrZhqhXhszNYg" +
       "J7R0tZf1uCQIx26YqlLue1RUbHdsQ93X6IntSekcbjW41Wgwg+lMlug6kE+W" +
       "WgZsigOlrknbsY6OQUqeyJ63S9RRc842/HrY58lC3GfzNk1kVG2hLVcgzPYH" +
       "XVbi27yuTjixM4l3SWQIUV5suLxG5cOYxyJ/xydZOJe3YyoLdmqIFka+0OEB" +
       "1Z342NYothN/s1vSLJb1xzwi7ZpdJN0vXC9bO22rmE7ohsU2grYtqhu4N/I7" +
       "jcI0twb45/uD5V9i8/XtSjxSbcCcHha6HlI2zF7Hv/FD01Nl8ezpZlf1uXaX" +
       "jfRzm41QucPwnjudAVa7C5/72Esv6+znG1ePN2mVFHogDaMf8Izc8M51dR30" +
       "9IE776Qw1RHo2ebhVz72Xx4XPmR/5HUcj7z3kpyXu/xl5gu/N36f9jNXoXtO" +
       "txJfdTh7ken5ixuID8ZGmsWBcGEb8T2nmn2s1Nj7wNM51mzn9kcUt7WCK5UV" +
       "HOb+LnvgP3GXtp8si20KPeYkRGAbsZMaOheH1XF3xfAj5wzmIyl0XQ1Dz1CC" +
       "M2PavdbWzvkhq4r0Ivpy4/SDx+g/+Oaj/+Rd2v5hWfx0Cr3VSfqB4ytpeXhx" +
       "Ar9s++gZzo+/UZzPggc/xom/+Th//i5tv1AWP5NCjzrl3Ydqq+8OKH/2DaC8" +
       "UVY+AR7yGCX55qP8J3dp+3xZvJxCNywjPYF3ejZ4yY7vcY4vpVSo//EbQP1o" +
       "WfkUePhj1Pybj/rX7tL262XxxYuop8fxZ3YG8UtvAGK1BDwJHvkYovzmQ/yt" +
       "u7S9Uhb/8gBxYJhK5h2OfE6OFd7/2sciZ/SVNv7VG9DG28rKZ8CjHGtDefO1" +
       "8bW7tP1BWXwlhR4G2iB0I0jLg4fDFaTJGcKvvh6EuxT63jtebChPZt/5qptX" +
       "h9tC2pdevnH/O15e/LvqbP/0Rs8DNHS/mXne+YO0c+/XotgwnQrMA4djtaj6" +
       "+uMUevbvdAsD+C8oKxhfP7D+SQo99Zqs6fG50HnGf59C77oLYwpdO7yc5/kG" +
       "WDFuxwPEAuV5yv+YQjcvUwIpqu/zdH+RQg+e0YFBDy/nSf4S9A5IytdvRSeW" +
       "33ptdZ2ZyPF87q5czNZOTebR1zKZcwneMxfSsur63kkKlR0u8L2gffllcvrj" +
       "3+l+/nB/QvOUoih7uZ+Grh+ucpymYU/dsbeTvq5Nnvvuw7/6wLMnKePDB4HP" +
       "PO2cbO+9/QWFoR+l1ZWC4l+849c/+E9f/kZ1BPj/AD0oCOtXKQAA");
}
