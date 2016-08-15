package org.apache.batik.ext.awt;
public final class RadialGradientPaint extends org.apache.batik.ext.awt.MultipleGradientPaint {
    private java.awt.geom.Point2D focus;
    private java.awt.geom.Point2D center;
    private float radius;
    public RadialGradientPaint(float cx, float cy, float radius, float[] fractions,
                               java.awt.Color[] colors) { this(cx,
                                                               cy,
                                                               radius,
                                                               cx,
                                                               cy,
                                                               fractions,
                                                               colors);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center, float radius,
                               float[] fractions,
                               java.awt.Color[] colors) { this(center,
                                                               radius,
                                                               center,
                                                               fractions,
                                                               colors);
    }
    public RadialGradientPaint(float cx, float cy, float radius, float fx,
                               float fy,
                               float[] fractions,
                               java.awt.Color[] colors) { this(new java.awt.geom.Point2D.Float(
                                                                 cx,
                                                                 cy),
                                                               radius,
                                                               new java.awt.geom.Point2D.Float(
                                                                 fx,
                                                                 fy),
                                                               fractions,
                                                               colors,
                                                               NO_CYCLE,
                                                               SRGB);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          center,
          radius,
          focus,
          fractions,
          colors,
          NO_CYCLE,
          SRGB);
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace) {
        this(
          center,
          radius,
          focus,
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          new java.awt.geom.AffineTransform(
            ));
    }
    public RadialGradientPaint(java.awt.geom.Point2D center,
                               float radius,
                               java.awt.geom.Point2D focus,
                               float[] fractions,
                               java.awt.Color[] colors,
                               org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                               org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                               java.awt.geom.AffineTransform gradientTransform) {
        super(
          fractions,
          colors,
          cycleMethod,
          colorSpace,
          gradientTransform);
        if (center ==
              null) {
            throw new java.lang.NullPointerException(
              "Center point should not be null.");
        }
        if (focus ==
              null) {
            throw new java.lang.NullPointerException(
              "Focus point should not be null.");
        }
        if (radius <=
              0) {
            throw new java.lang.IllegalArgumentException(
              "radius should be greater than zero");
        }
        this.
          center =
          (java.awt.geom.Point2D)
            center.
            clone(
              );
        this.
          focus =
          (java.awt.geom.Point2D)
            focus.
            clone(
              );
        this.
          radius =
          radius;
    }
    public RadialGradientPaint(java.awt.geom.Rectangle2D gradientBounds,
                               float[] fractions,
                               java.awt.Color[] colors) {
        this(
          (float)
            gradientBounds.
            getX(
              ) +
            (float)
              gradientBounds.
              getWidth(
                ) /
            2,
          (float)
            gradientBounds.
            getY(
              ) +
            (float)
              gradientBounds.
              getWidth(
                ) /
            2,
          (float)
            gradientBounds.
            getWidth(
              ) /
            2,
          fractions,
          colors);
    }
    public java.awt.PaintContext createContext(java.awt.image.ColorModel cm,
                                               java.awt.Rectangle deviceBounds,
                                               java.awt.geom.Rectangle2D userBounds,
                                               java.awt.geom.AffineTransform transform,
                                               java.awt.RenderingHints hints) {
        transform =
          new java.awt.geom.AffineTransform(
            transform);
        transform.
          concatenate(
            gradientTransform);
        try {
            return new org.apache.batik.ext.awt.RadialGradientPaintContext(
              cm,
              deviceBounds,
              userBounds,
              transform,
              hints,
              (float)
                center.
                getX(
                  ),
              (float)
                center.
                getY(
                  ),
              radius,
              (float)
                focus.
                getX(
                  ),
              (float)
                focus.
                getY(
                  ),
              fractions,
              colors,
              cycleMethod,
              colorSpace);
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            throw new java.lang.IllegalArgumentException(
              "transform should be " +
              "invertible");
        }
    }
    public java.awt.geom.Point2D getCenterPoint() {
        return new java.awt.geom.Point2D.Double(
          center.
            getX(
              ),
          center.
            getY(
              ));
    }
    public java.awt.geom.Point2D getFocusPoint() {
        return new java.awt.geom.Point2D.Double(
          focus.
            getX(
              ),
          focus.
            getY(
              ));
    }
    public float getRadius() { return radius;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WA9mKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7aazs1nnY3Lfp6VnLk2RbsmJt1lMcedxHcjgLp7Jdk7Ny" +
       "htsMZ+GwSZ45JIf7MlxmSCZqYqGp3QRw3UROHTRW+8NuWkOxgzZGCqQpFLRp" +
       "4iYNYCNokwKN4y6oU9eI/SNpUbdNDzl3f/de59XyADxczne+8+3nO8u8/o3S" +
       "1TAolX3PTjXbi26rSXTbtGu3o9RXw9sDqsZJQagqLVsKwwn4dkd+1y89/Gff" +
       "/rh+81Lpmlh6THJdL5Iiw3PDsRp69kZVqNLDR187tuqEUekmZUobCYojw4Yo" +
       "I4xeokpvOdY0Kt2iDkiAAAkQIAEqSIDwIyjQ6EHVjZ1W3kJyo3Bd+mulPap0" +
       "zZdz8qLScyeR+FIgOftouIIDgOF6/j4DTBWNk6D07CHvO57vYvgTZejVv/PD" +
       "N//x5dLDYulhw+VzcmRARAQ6EUsPOKqzVIMQVxRVEUuPuKqq8GpgSLaRFXSL" +
       "pUdDQ3OlKA7UQyHlH2NfDYo+jyT3gJzzFsRy5AWH7K0M1VYO3q6ubEkDvL79" +
       "iNcdh938O2DwhgEIC1aSrB40uWIZrhKVnjnd4pDHW0MAAJre56iR7h12dcWV" +
       "wIfSozvd2ZKrQXwUGK4GQK96MeglKj15LtJc1r4kW5Km3olKT5yG43ZVAOr+" +
       "QhB5k6j0ttNgBSagpSdPaemYfr7BvO9jP+L23UsFzYoq2zn910Gjp081Gqsr" +
       "NVBdWd01fOA91M9Kb/+1j14qlQDw204B72B+5Ue/9cH3Pv3Gb+1gvu8MGHZp" +
       "qnJ0R/708qEvvbP1YvNyTsZ13wuNXPknOC/Mn9uveSnxgee9/RBjXnn7oPKN" +
       "8b9a/Phn1a9fKt0gS9dkz44dYEePyJ7jG7Ya9FRXDaRIVcjS/aqrtIp6snQf" +
       "eKYMV919ZVerUI3I0hW7+HTNK96BiFYARS6i+8Cz4a68g2dfivTiOfFLpdKD" +
       "4Co9Ci6ttPsV96h0B9I9R4UkWXIN14O4wMv5DyHVjZZAtjq0BFZvQaEXB8AE" +
       "IS/QIAnYga7uV+SeKW0jaCwpwEd6AbiBppwEzPZ2bmj+976LJOfy5nZvDyjg" +
       "nafd3wae0/dsRQ3uyK/GROdbn7vz25cO3WFfPlHpvaDX27tebxe9FqET9Hr7" +
       "jF5Le3tFZ2/Ne99pGujJAh4PYuEDL/I/NPjQR991GZiYv70ChHwfAIXOD8mt" +
       "oxhBFpFQBoZaeuOT2w/Pfgy+VLp0MrbmFINPN/LmXB4RDyPfrdM+dRbehz/y" +
       "tT/7/M++7B1514lgve/0d7fMnfZdp2UbeLKqgDB4hP49z0pfuPNrL9+6VLoC" +
       "IgGIfhGQVx5Ynj7dxwnnfekgEOa8XAUMr7zAkey86iB63Yj0wNsefSmU/lDx" +
       "/AiQ8Vtya34aXH9737yLe177mJ+Xb90ZSa60U1wUgfb9vP+p3//dP0YLcR/E" +
       "5IePjXK8Gr10LA7kyB4uPP6RIxuYBKoK4P7DJ7mf+cQ3PvJXCwMAEM+f1eGt" +
       "vGwB/wcqBGL+id9a/8FX/vDTv3fp0Gj2IjAQxkvbkJNDJvPvpRsXMAl6+/4j" +
       "ekAcsYGj5VZza+o6nmKsDGlpq7mV/u+HX0C+8N8/dnNnBzb4cmBG7/3OCI6+" +
       "v4Mo/fhv//D/eLpAsyfn49iRzI7AdsHxsSPMeBBIaU5H8uEvP/Vzvyl9CoRZ" +
       "ENpCI1OLaHW1kEGey7x4QS4TGA7QxmY//kMvP/oV6+e/9ou72H56sDgFrH70" +
       "1Z/889sfe/XSsRH1+bsGteNtdqNqYUYP7jTy5+C3B67/m1+5JvIPu6j6aGs/" +
       "tD97GNt9PwHsPHcRWUUX3f/6+Zd/9R++/JEdG4+eHFA6IF/6xX/7f37n9if/" +
       "6ItnRDFguZ5UaBItCtDhC+fLr1DCThyv/YPnf/fHXnv+qwCnWLpuhCCjwgPt" +
       "jIH6WJtvvv6Vr3/5wac+V/j6laUUFnTcOJ3h3J3AnMhLCoE+cGjiT+byewZc" +
       "79438XfvBDr/LscQ0MzJDdILcPBUhNKD4el7hTrZqSAvb+cOvXPri026m0vu" +
       "KJw+8b9Ye/nKf/yfharvGgXOsPJT7UXo9Z9/svWBrxftj8Jx3vrp5O7BEmj9" +
       "qG3ls86fXnrXtd+4VLpPLN2U95P0mWTHeZATgV7Dg8wdJPIn6k8mmbuM6qXD" +
       "4eadp93sWLenB4Ij8wbPOXRhYrvYnxfvT/ZKRejrFi2eK8pbefHuQtyX8scf" +
       "yB3DcCW7aFcFgdVWXS3SC2C4+LaLsfWodBlYa/74Pj851NylHari/W3RfhjL" +
       "WQNpq+eqeUQ8qNtlBIZ3+3DKACqTM2zgPefbAF14x5EifvOV//bk5AP6h+4h" +
       "FXjmlGJPo/xH9Otf7H2//NOXSpcP1XLXfOJko5dOKuNGoIIJkDs5oZKndiop" +
       "5LfTR168UEi4eH/PoSRKhSRKBax4Qd0P5sUcKFDORb3TzAXgd5JS8f0vHwaU" +
       "h/K6x8BV3g8o5V1Akd6kpJSO7cjwbfXMzPd730lyYHkPFZaXJ6xFKLrL5PJ3" +
       "PC+kA5fRLnKZvCB3/pIXg7wY5sWH7naM/JXNi9Hdlp6/T3bdFq3zQrhAge4F" +
       "dQXVxWzwh3aUXAAbJLs7dAFM4ejPhMcz55POeGyx4o788d/75oOzb/7zb90V" +
       "i08mirTkv3QUn57Nx/zHT08T+lKoA7jqG8wP3rTf+HYx6L5FkoEJhGwAZirJ" +
       "ibRyH/rqff/+1//F2z/0pculS93SDTDOK12pyNBL94PUWA11MMlJ/L/ywZ2V" +
       "b6+D4mbBauku5osPT96dO39h30W+cHbufOTRd2ek5zU9Jf4rBQVXDoz2bYdG" +
       "q6meA6bLwKwr7cP85X2FmoveP3yBHn8iL360qIrz4uUdg8l3JYuv7jP01XuX" +
       "xXlNT7Fw325yeMjtWcUxCXzsAgl8PC/+5pEEfvJNkMDejV3b3f2eJHBu01Ms" +
       "7Gf5+esrhyy/corvn7uA77+bF68e8f2JN4Pvxj7xjXvn+7ym52v+TL4P3OMD" +
       "5y5KnDkg3Gqlsq3uhu18onCA5v33iiYfQHgAr+ZYCrY/fYESPpsXf+9ICX//" +
       "zVCCuS9J896VcF7TUyxcLyi4fq4S8uIzefELB3J86mS0wlcgqVQngeSG+XJF" +
       "Qdk/uUBOv5IXnzuS0+ffDDl9ap/ZT927nM5reoqFywUFlw+E8I6TQhiDfAZk" +
       "wra6C9vH/PaNC0TxL/PiV49E8c/uRRQ72CeKt2u7vOaQuQdyiHwOuW8Epbvs" +
       "Zz/5+eLZyc9eVLrPD4wNmLAfTBaurjw5Dg+N4+YR1f/6O1F9iq7vA5ezT5dz" +
       "Dl1fOoeu/PHfHM5fZDWfU59F05fvkaZ3gMvfp8k/h6bf/wvRlIeQnZzQUzT9" +
       "wXekqcCR7AHpX63cbtwu5mRfObvXy/kjmNFdC4t9m/yNPKDhcdOWbx2svMzU" +
       "IATp2S3TbhzY7s2jmdtu5+MUodW/MKEgq3voCBnludpLP/WfP/47f+v5r4Bk" +
       "blC6usmnwSCNO9YjE+f7Sn/j9U889ZZX/+inioU+IMPZX//2kx/Msf7xRezm" +
       "xX86weqTOat8MW+gpDCii7U5VTnk9tS09gqYPf3/cxs9+tZ+NSTxgx8FS9J8" +
       "KyMrNyp7WyWB5bjWIDJWwuUGQQ7bYrdNtruVqjtSWHRBrjW6Wm06aB22HTFd" +
       "ZMsywkiUtra7rUGrp5FRB+X7W5iBO7gnWXyAaxVbYIejVhcftvChLYW0zXe7" +
       "fquC+s0GjIYoF3ZmtjaL1ihdbjZRdLOCBHSzmaBph3eyCTOgmbGoV7bIeqx4" +
       "CGKwYteroGtxYC8XrTK+cthO7E7WcD2aJwuntkKsrU9Yiuzw40k4XYdStIqG" +
       "lkRIAJUt1VODIWGJ43lk3bYiGl7OyrTtJKzN9tahNqw3KbOLdyq8I9FIJ6Yd" +
       "2decqMuq20HPcQY4L44nHRsW+706Y6166dJJ0O04bFZ7FbWzGNPxPBJNZtKN" +
       "LLM9NSdMtz2Vpmk2d8z+gLQYIUqVmTudebo1r6yJ1YK0tWWcEn2iT6/WHBoa" +
       "SNyrBxo5sNaSb3KsG80oagYr/qazWAuzRgWZS2EgjSVYH5jdcUMjbN+YONTY" +
       "6Y+HrWwts1ELX02RGRBKxZ2wbZdxhqZiDUhjzK5qgzbtTKebBcyJieMMe3xl" +
       "mWQiS1QUX1xu51PWaMgbI643q/V1nYAjcjkp+7PlqDzoyD1S10JYw1q+ZBMS" +
       "SCuqaEdqpCukZxgNs7Ye+i2vsezA6Lzj8xaiSQhbJonJZkKYQs1Z18MRCeFO" +
       "zZk785pTmUZbrUGtUn24tvGx6jcMrKVVGyGBLYLuEKfbtK4pqDgczpZdHmXT" +
       "4VYb+8u+HWM4PiTmfktbwgFD2XOPVwZ4b8EP135rbq7mRH2uD/AUHW1HA3Zc" +
       "H03d8cxaWkEy4yOSiGgNF0hsga/1RCBa5DY0LZIwVq3lCOYk3DbRankeKFjW" +
       "FKSegdAji8hc2lvDNsbwNEz43brktRZdLmmR1WTVa1r2pB9ZykDj8cFWxQk5" +
       "aaNZ1ExVyqnCGOUQdm1Bef0IaYlt2egThoqxFBNtlyQ/GHI83IK7tgqZbh/Y" +
       "TYbyjtnRtlY2yDyj3ZmvtipbnqANNBY2PuF0x4jlDsRZk/bDIVOfTzHRsAIG" +
       "mfGmH469zYClPWSNmYsmaml+1TQsqbtEFWMx7s552Z8JthDLjdVoOho4+KA7" +
       "wwXO8Jcjd660FxaHsXN6NHICjU8CzUknxhbFxN5CY+u8Jdnz8WCajZoVh1un" +
       "FDbTF1rWokjF0OotZF5m5m4gEQRL151FOvQ6SrvbbeBtZNIDdikYFssFlKQT" +
       "5WE4FmjGG/ZEL2t2dNeS4wE5xEdDICd4lQCGqpU4WVs1km0yQcWDVisID7Eh" +
       "DBNIWJ600l5XYozu1Fx1pyrV68/4QW3G82anW4s7623EaLV6RQuVdkpUII+F" +
       "hpEYoVkKE52M6fFWn+yO8DpSU+qVKN1W6UmKr2xvhFVYdo5F6iSheYe1RuJA" +
       "nNtkYtW3sJW0zNqwUulVsZU+nFg1bym6UYrzMjoVx+s+3B1546aRzdigjdDj" +
       "8tgQa6KLp13I96J+W007IcQKDTflpssgg9EJTZUVkqBsq2ONoJHaZilxwcB8" +
       "G+dqtTWqKOo686CoUndqOMZOhUGKOosWyclVzukQE06jkm3kjsPqoKdQsyys" +
       "poRGIzhIpIC9EeuyynDrpNew/DG5mMS6w9uDJB10k+44TJvjHqo3I58TyirR" +
       "E8fmqLFoM83lcgFZm0yrJzJRWQdEEFE03s22qMCM3T5nTlogLhvVzZLnWcTd" +
       "ZKsx4gQDdKKLOIzxzLwhBhvCJyYaGqRZraqiq8Y46DQUURsYwhLrzJdMqIlk" +
       "ZziStygXoFEkMpu+4NVcSsg6gDV3XO90DGMijqkGP5uOB04PCZGkTnK83yE2" +
       "IxBrYhjDy/ZiZLQlb9pXQyhasUKfi7aTWmWLJ7N6v81IK3YxQLmav8Z0JEMa" +
       "SFZZlCdTs4ewm2GGTyeYkBosxAzhGl8hk4pYhzEYUjW/PiIswjN7djBsYxqx" +
       "TJzZqLZRkOZQLTeHeHe1dqwRjraVdbUeVNRsQ8V2LcWMNoxSWtrWBhGmbATX" +
       "XCOxWoXX8ZiG+quYbyQxJ3RaHaxrL1ydw+xVh9pC42Z5qpoLcj4oj2qxovZE" +
       "l642dZEEJjudDccTrA2LMDNorGIOna8WrdbCGXG4wq3UProVK0tGkDr1KQUx" +
       "6VDTNqah60R7s6A63Lqmj5f6nIEhFvWyCFI3Ait4w4Bwq9nSUySsUYWgFV9L" +
       "a80NV6MtvNoZ1gdkMMKavYU+dcwm5CAkYtSbw6WkV5r+kHXwNdMdDCNWAgMT" +
       "w5Y5lZX65TAatvvuHHTX32DtYX/t9cJQb8EaAQtYKEELGQy3gdIeyaMZMoXK" +
       "2SYQhQSbNthFFsOtAeBF5zcOgww4udFvMf7MgtxFHUSfuCw2o7IaLLa2HEOL" +
       "uNqLiHHdntdjvaWq7VqaLoapM7ZZUWgaI25FNsocU6OQpCEz1cYCR5t+d5iQ" +
       "7XJrWJ76kwyuusm2VpZ7A2e9bKhLzxsvyjCixps6ylGKjSHZerYyMETyVh1M" +
       "MVeTWUZtl5KxjNRaU1KtQK9ACpMOpgI23uCowbioGmjZCivPIBkXhrxC1IR2" +
       "3EbHVSh0m/VKVWPZRkWkgA8OagNxRXY7QrORNKYQRmYpApHWdl22HGXZgxqM" +
       "5a97LjPiMJOWN1IrbAuwuYpRShr0lhgyxzO2Hcp8tmwTnJpUYJtz5HDW8Eh4" +
       "XBWDtbyoZUylKixcGqQq2LLfIhfUWGSmZiDTmF8bRvxoWQ1bkRK2W241FIej" +
       "LrWllZisMTPZ1ulEwZaOiNhWW1i0WEtKFhPbJC1p2uyYlSnstXvL1OnEkwxJ" +
       "6zHVqwEGs62DbqD1wo7nHpzwQoURy/qKnqBzqV3VF9OI7pjDaaZiHIq2jXWf" +
       "8eraRNwK9NA0bW6G9F3bbtpusnTYZqbP+laDhJr8EClP61o6nGceIzRhN5br" +
       "EqVuCWc7l1do2kTZTDUIuZ0O12tL6KmE42icS657ut6FBTwqC/DCnqZDtNyE" +
       "a9W0N2yOlE1Sr6/L837WqHYNiDHx7WCuxeVIC5dzH2XwgdBBjXkcZRyugigT" +
       "uY0u3Ua84aZjmVK9s+zxLXQ1iwQWDf1Vu9rq1+byCHeHaDpJt9ZY6XUyy+3I" +
       "S40UqLiBqUDf2GQMQkxz1OjoyWTZJbVpBWoR3GJJU07LSSo1etFeMRU6m7di" +
       "rUw3unKULntppUv15F41phsy5ZSbpqf5pBG2V/bcICohOXCSZScetikzU0w6" +
       "aqQNDoVobLAdt0MD3XDJIJNFrm9WFKvRxpwaHKdzHdEgXZzjDN1WGywCm/MO" +
       "3VJWaKZ0BWGN8c0qAmQjtnFz3YzpacaZlSQQ4d50FmRQpTyYMFRNGslAMppO" +
       "JqjRTwR+IRLNsCFpqC+ZiSn00wE2sMbNIVnPjGCwWNZHg74NTcv1MjYwI4Ne" +
       "pY3tRtEGfKOSrjs9m6CGvGoh7X4znbmTCUI2u6o7JoW5olScChmjHdE3NpBP" +
       "G+UN7DObTRUmamFDb9Fo5jm0G/TFDa+A6YnX6a3xaOQnus/ORkGjR9bshmGZ" +
       "TrepybIxy5BEHw7skV3TecirDeiRMsIlSGK7CISK8Dzh0ha3gAULG+OVdsNM" +
       "y+xskTqsnykTHuA3Oz1f5zEraGMrZqaPMKmcDNfwNpmxIL+dJ34lrQez7mgT" +
       "kwriB7YXMYzGxmFbJdeZTC1Ww/pQ9htErdIVWLLC+m6rUtEplRYAiVOcDWfC" +
       "oDXUwjVR26wWEN0fN2oM5BhVWuvMuCai8f66O0YrcqirVMpis+WgltVWK2xO" +
       "BxutVengdVYQ0v4U74W2C6Yk48ycQDTl62OPiQxsDeTaqkKYa1RNT5gnqgIL" +
       "cBLJOml2tluYi8tGNqkmnZGZ+aGXdmpNRxIUFrKpst0yu6OFb5IhPfaq1fU2" +
       "pg077rrT2nI+jZZrisI2kbswbRzCs6ofJ8hUm5NQIw4a22a25tNOW4wWjjrU" +
       "x5NqyiVgkqhwmtTUqN5IIKG+Mqa1SMdr1gJZjGBqm47KgjWmTcYNomE243CO" +
       "jocNCg/ryTbrd5x+Jqha2UqaVD/w9QbWrTYRhHJ7LMon2tRs+IlprftrdS3y" +
       "+thgOlGPhKtQH8vi1rTXLYNpjZoorUyEKLmJLPkpCCjlIUisMGqGqwY5isdN" +
       "AZbVcbzsbBujGV4eEfq84hmCMGqtU4utjSZqn+wM1vSEn5rMcjDYKm5YgVyZ" +
       "9WcuE2OeY3U9lJHnko0oE5pPWJ4g48qWNpcNgyJ1aUwQmVFNkQVDd9jmwhLn" +
       "qKwIbjfboEJ3uszmYMrBuESaxksPYUFmOzKQFs2NSYehwq5FdjWuVacJz4Gx" +
       "uYGJeHczrRKmZQOJMDCtmjY81ZEWhVEGlkbacOmPCWtESM1lQMBgZNKR2sDr" +
       "ic6ihpJyu65JMlTvkFC1SkZNKKTEtB72KUGfuzWsvmLBGML3pkYgBaqHuGBw" +
       "tnXYm7SSia42uH6NmTqeVuv3RuZ0S6bCiIwdXdH6Siob1orBcRAxOCKjenwX" +
       "HnVcEmQbQkuZMHxNHhALneQEn1AdAsExqs/J9EAQ+3xXTZdWlgHfDF2Lrrhj" +
       "q952ynJNKnfLvktx04jTMmRBYE22LSkzdQVtRKVqieJsPVWgAe+z1mKdsNOK" +
       "m0y4RVmeunRFXKMZoxmYw7WJeONzaV0T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("iMDY0GAGR7Q72WpExWI/0ONotk6jen3TnwXlOsc2Urjc4efapDW1NbUGYvN2" +
       "lI51P8UkcdHwUGUMaGxiraiF1rGVLBgJrWwwihlbLjfpeKOV1cXKK3ZGRdlU" +
       "lbT6pG7VeCJyZHGjzxJJWDKyjm0rC2g964VNLR21KBanISPGU1UzpvGi2dDl" +
       "Zb8/F/ubBNoadEZXmi0MbXZhdbb2miO5NleRmKxOphV6RoXNkckSZLkCL0aj" +
       "EUrUlrZipoaLiEQwJRDTG9Uzkq7V11Wu54PEEeISrb2ajsuSsgAWYHMphGyN" +
       "Od50hiO8WB7603tbtnqkWKE7PKhs2o284r/cw8pUcnaHx3etD1c4i1++zHni" +
       "zOvppe4nDpbYg9JT5x1LLk5mffqVV19T2M8gl/ZXsRtR6f7I8/+SrW5U+xiq" +
       "3fbm5JCMJ3L0L5RKe7+xo2J3P2ex/sxV1h/Yye/s7bO7V+YNR9LU3TkA2lP2" +
       "aQMQjx5CHC7b5zW/nhe/fAD0+DEgV1HzZdK+4UZhTsLe/ecv6u89khdXotKD" +
       "cqBKkbp/ov4A7dFWb7HJdLw21/ne1XveDTkScH68o/QckNX+zuveRZu29yDg" +
       "49w9dUHdM3nxRFR6SFOjVrE0X+xkF+vzRxy+47vl8FlA7Nf2Ofzam8/hixfU" +
       "lfPiFtAt4LCb74ecxeAL3wWDhbs+CWj9k30G/+TNZ7B2QV0eh/Zg4NCAwfHR" +
       "TsYRc8g9bVFFpcfOODeeH4J94q7/p+z+UyF/7rWHrz/+2vTf7Y5THvzv4X6q" +
       "dH0V2/bxc3DHnq/5gboyCs7v35068Qt2PhCVnjhv1zcqXQZlTvPe+3fQeFR6" +
       "61nQAHLfRw8g21Hp5mnIqHS1uB+H60WlG0dwUena7uE4yABgByD549A/iBK3" +
       "722rOtk7GcEPR5BHv5O2jgX950+c/in+ZXRwbC7e/c/ojvz51wbMj3yr/pnd" +
       "+XDZlrIsx3KdKt23O6peIM2P3j13LrYDXNf6L377oV+6/4WDYeShHcFH9n2M" +
       "tmfOPozdcfyoOD6d/dPHf/l9v/DaHxbbSf8Pr9f4Iv41AAA=");
}
