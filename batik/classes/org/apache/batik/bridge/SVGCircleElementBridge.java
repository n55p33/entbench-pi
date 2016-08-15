package org.apache.batik.bridge;
public class SVGCircleElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGCircleElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CIRCLE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGCircleElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMCircleElement ce =
              (org.apache.batik.dom.svg.SVGOMCircleElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _r =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getR(
                  );
            float r =
              _r.
              getCheckedValue(
                );
            float x =
              cx -
              r;
            float y =
              cy -
              r;
            float w =
              r *
              2;
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  x,
                  y,
                  w,
                  w));
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_CX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_CY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_R_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.geom.Rectangle2D r2d =
          shapeNode.
          getShape(
            ).
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ikLrHKovu7C/P+PiLvNP1rz1HxiAIGC7GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aaezjxnXn7nrX9vrY9TqxXSe+10ltJX+KEnXVaWKROiiJ" +
       "EilRpES2yYaXKEq8RA4PKXVzIG3cpnDSxkldIHE/NEHawDl6BC2QpnVb5EKC" +
       "AimCXkCToCjQtGmA+EPTom6bDqn/vUdgOKgAjqiZN2/e+817b97M6LnvIacD" +
       "H8l5rrU2LBfs6AnYWVilHbD29GCnS5dY2Q90jbTkIBjDukvqg58594MX3z8/" +
       "fxI5IyG3y47jAhmYrhOM9MC1Il2jkXMHtU1LtwOAnKcXciSjITAtlDYD8BiN" +
       "3HSoK0Au0nsioFAEFIqAZiKg9QMq2OkW3QltMu0hOyBYIT+PnKCRM56aigeQ" +
       "B44y8WRftnfZsJkGkMMN6W8BKpV1Tnzk/n3dtzpfpvAHc+jTv/6W8793Cjkn" +
       "IedMh0vFUaEQAA4iITfbuq3oflDXNF2TkNscXdc43Tdly9xkckvIhcA0HBmE" +
       "vr4PUloZerqfjXmA3M1qqpsfqsD199Wbmbql7f06PbNkA+p6x4GuWw1baT1U" +
       "8KwJBfNnsqrvdbluaToaQO473mNfx4s9SAC7Xm/rYO7uD3WdI8MK5MJ27izZ" +
       "MVAO+KZjQNLTbghHAcjdV2WaYu3J6lI29EsAues4HbttglQ3ZkCkXQDyyuNk" +
       "GSc4S3cfm6VD8/O9wRueeptDOSczmTVdtVL5b4Cd7j3WaaTPdF93VH3b8eZH" +
       "6Q/Jd3z+yZMIAolfeYx4S/OHP/fC46+79/kvb2ledQUaRlnoKrikflS59euv" +
       "Jh+pnUrFuMFzAzOd/COaZ+bP7rY8lnjQ8+7Y55g27uw1Pj/6oviOT+jfPYmc" +
       "7SBnVNcKbWhHt6mu7ZmW7rd1R/dloGsd5Ebd0cisvYNcD99p09G3tcxsFuig" +
       "g1xnZVVn3Ow3hGgGWaQQXQ/fTWfm7r17Mphn74mHIMj18EFuhs9rke0n+waI" +
       "jM5dW0dlVXZMx0VZ3031D1DdAQrEdo4q0OqXaOCGPjRB1PUNVIZ2MNd3GxTf" +
       "1Awd5YQ2afqqpacRAvYlsuqd1NS8/49BklTT8/GJE3ASXn08BFjQeyjX0nT/" +
       "kvp0SDRf+NSlr57cd4ldjACyA8fd2Y67k427sx1358rjIidOZMO9Ih1/O99w" +
       "tpbQ72FEvPkR7s3dtz754CloaF58HYQ6JUWvHpjJg0jRyeKhCs0Vef6Z+J3C" +
       "2/MnkZNHI2wqM6w6m3Zn07i4H/8uHvesK/E9957v/ODTH3rCPfCxIyF71/Uv" +
       "75m67oPH0fVdVddgMDxg/+j98mcvff6JiyeR62A8gDEQyNBmYXi59/gYR1z4" +
       "sb1wmOpyGio8c31bttKmvRh2Fsx9Nz6oyab91uz9NojxTalNPwCf1+0aefad" +
       "tt7upeUrtmaSTtoxLbJw+9Oc95G//ct/KWZw70Xmc4fWOk4Hjx2KBimzc5nf" +
       "33ZgA2Nf1yHdPzzDfuCD33vPz2QGACkeutKAF9OShFEATiGE+Re+vPq7b33z" +
       "o984eWA0AC6HoWKZarKvZFqPnL2GknC01xzIA6OJBZ0ttZqLvGO7mjkzZcXS" +
       "Uyv973MPY5/9t6fOb+3AgjV7ZvS6H83goP4nCOQdX33Lf9ybsTmhpqvZAWYH" +
       "ZNsQefsB57rvy+tUjuSdf3XPb3xJ/ggMtjDABeZGz2IWkmGAZJOGZvo/mpU7" +
       "x9qwtLgvOGz8R/3rUNZxSX3/N75/i/D9P3khk/Zo2nJ4rvuy99jWvNLi/gSy" +
       "v/O4p1NyMId0+PODnz1vPf8i5ChBjiqMYQHjw3CTHLGMXerT1//9n/3FHW/9" +
       "+inkZAs5a7my1pIzJ0NuhNatB3MYqRLvTY9vJze+ARbnM1WRy5TfGsVd2a9T" +
       "UMBHrh5fWmnWceCid/0XYynv+sf/vAyELLJcYbE91l9Cn/vw3eQbv5v1P3Dx" +
       "tPe9yeUhGGZoB30Ln7D//eSDZ75wErleQs6ru+mfIFth6jgSTHmCvZwQpohH" +
       "2o+mL9u1+rH9EPbq4+Hl0LDHg8tB6IfvKXX6fvZwPPkh/JyAz/+mTwp3WrFd" +
       "NC+Quyv3/ftLt+clJ6C3ni7sVHbyaf83ZVweyMqLafHa7TSlrz8J3TrI8k7Y" +
       "Y2Y6spUN/DiAJmapF/e4CzAPhXNycWFVMjavhJl3Zk6p9jvb5G0b0NKykLHY" +
       "mkTpqubzU1uqbOW69YAZ7cI88L3/9P6vve+hb8E57SKnoxRvOJWHRhyEaWr8" +
       "i8998J6bnv72e7MoBUOU8O4X73485UpfS+O0aKZFa0/Vu1NVuWzJp+UA9LPA" +
       "omuZttc0ZdY3bRh/o928D33iwreWH/7OJ7c53XG7PUasP/n0L/9w56mnTx7K" +
       "pB+6LJk93GebTWdC37KLsI88cK1Rsh6tf/70E5/77Sfes5XqwtG8sAm3PZ/8" +
       "6//52s4z3/7KFRKR6yz3ZUwsuOUdFB506nsfGhNnk5hPksmMKdbQGUpIcV1u" +
       "dHTap73xsOnZdn+kKuN+pR0HI26s9hOwAUVQnEdazdaAWmPk+mBFzPLDIRh1" +
       "uUF3KHDdnr2Wh8KyBTBONk1rRC4xqWeClS3wMHhaVNkYeXxvVmgAaDS2VlQi" +
       "Jc+OWkI5H1TCaOpsJFCJ4He0URKc0gSxG7p22y0O2+JAXA7bg4VNjztOt59I" +
       "MtYqGN2yulyh7KyG5ZWwIbMyqXFyrMnxnMyvVwQhAFMaWuWu1GoHXMCLnaVm" +
       "d3hpICbdDSkM2hipjOqBKK/nK69DzosTSe2Iid+URklB5K1Bt+AN+8yw45Zd" +
       "v8GtutWuRuVESptRDYEOF9Qi4NBCoGpVVow35Spm8dpQZ3HTUQecbc5Xg16i" +
       "gHXJciO57fcLluAlbc4ttRvluUgZVjGheX7oU+tSRWWU7oYFVKdbmgwG+TWY" +
       "bGpzghbKeodqaoByhHpXcPwm66ord7XozqubkYIlWq3jjolVixMwwHIlcTaM" +
       "RpV20i/lvKGA9UBHabZ4bTTu9cf1boCXxaVSspctkp0K+RI+IAqJUFLEyWTE" +
       "ublogZdruXGuFtYEVxG7WE9yxUJcapprMjaH4zq56HZdy6upwXrJacN5rLQp" +
       "k7ENS7Awv5X3ypPlgE9An67S5JqViQVVcojSRGzOhhtlaK08UKoJtOpKCTrg" +
       "loKXp6ZzqRwOgwExMtRWOxFEu+uQODVjlozXHUl9bzLH1aWmJ7V8yzB6LWzC" +
       "dza6U17JRr5Rn/Kwpp1YbpkxdODJExLk1SYxFlcTi5j2goYcDzrOuNtvVvtB" +
       "vdjzV/UV3mzEojQEZKOTmBPCksSmz3CbDToZKZyq56fSShxx5EAFTR44ZbtA" +
       "DLVCY0h5HbPrtmqduljw8QA1RnpOX6z7zUY9Iht12gmrqB6yuYaWnxaTepXL" +
       "R3Glietdojvg2vrYn1Qjs1yoAdwFbq0ypEVeivLEJgpA25HKOafeHEl2S++E" +
       "YT/s5qc1dJPv47nakMW5kYs1Vi2FE8YBPQPDeVmwGrxol4zCopl0x51h2SRk" +
       "qtevxbk5E5lML3FH2KDgWc2p2+x5E0a2JiW0SrhzriMSdSz2ddObjouFaj0f" +
       "V2obYtlzG/MK3+jXNI7d4Pa6o270udQMeA6bjwbQLGQGsDNzSTe5Ya9gTwwu" +
       "ovC1HNoFksNFTMXyrU5/JnUW4+V4KDB8wRRz/Yrout5KHLcIwqw4Un+xGUz6" +
       "aFVdMrLiRYw1JDvrmCYM6IdGjSkKQteWSNtnio1ajFvF+TgkZkrTKLVbTcEo" +
       "uqY4qNLOQpyXOuWpM5KbQ6eA52wMFdvlGCPhtrduo5uC36a0JI9HfqdH9Qui" +
       "b8huW496hjHkq3iv0a41x/nIYSwAI2sJ6I0yu2IYv9n0J8k66najkt3moESM" +
       "F5aYoe2t1WDYK8aSseILfEnvNOrt1bQnxd5g7PPV0VLr+HZuzeE5MQJYe1Gq" +
       "tFprVF+YZX25wEs5lME35Jy3ibGwbFTFeEAVJnOWyK11nCXc7lgFNjtlFxs0" +
       "gWKTcdCaqNJgseQX9hD3jRgfzUl17gshQa9HOqttaHGSqwfNfKI0mI45KBLM" +
       "cGWOvaoSS8uwJhMxt9A3k7ag0YE8GLTZVT4pt/SCS6ElnFUA1QR2k2WJUJ2p" +
       "zsyn9Hmsea3YZyQnnuRxwjH5AtsOKmgpkaoFtbLQpAFtr2K6TTLFDTGu236X" +
       "oVZGhVVmujyvN2Z6WaMiVMFrE7YS9qtkUva4JiqvB4ZMkPm406fQZMGzUeSg" +
       "WKU7iUs5le/DjfK82XEtTOfyQmtBcMIcLKa6btbrq3l9Zg9meXbFEbO16xGc" +
       "JsQLZcLWwESp+DGWsCA2arxLz0PAUJP6YlNOKvIiqVVUFK+FtCkug+E4EHU5" +
       "MWUjtymxqlLy8Pkqv9BynOav1BCfqHM2T/SBN5LioB/gc8NQ/CGYsrmKPgWs" +
       "y+TGfssCOamAqhA5cjVpaizdI9bFBVVJCkY5VwgG9LpQdMV2sUhGgrnpGjOz" +
       "FU8a+XwpkMRG5LjBwilgU7qGN81R3+DFXizn8oUOT9vkYtPA5bKXy2Hs1Krh" +
       "OJNftYhScyGvmBJP9QeJtaozVVswZFKuVvAaWyTDAYvl6dFGENqj6pJvElFj" +
       "nV+JyppY8camWDHyk0ihotymNQ0lUR4G2jCqkpWJ30crbRQVCI/RirVqr9s1" +
       "3RUW12I79IL8zNkE0DdrwXLlKkw8j9E6OQ24ClrGsHCUr+TQKdnzBq2GVuiZ" +
       "XE+myyWbo5ZymZw2Gn1uw0eUX5zqocuyuWSgVHLaoE+4RUXt1JgNqlqEOZ3Z" +
       "MWVtep48QKc+XYyCNVHAF+46HsTEUsjp6KK13kQTrjcjIxIXYmXtOmZexRiV" +
       "apkiRo7GRttixrywwgtltMfk606/EBfZbqAStTnPrFaTaher+qRbBP1eWLTC" +
       "uVKKsXBtrcZLVvCWQKSGLcAwmsnQs6ShEquqa7rrqUMJQO6TBhrl1rVia83m" +
       "26VNTiSb1emMCLTpWNWjKLYIINeHPW84rxbxYrlnG3Udy4khA4oWuRiMTMoS" +
       "uzpeF1aFoJJj40bD6CVrz0g0gPkDx+0G/XZcG3qjxtAk0O7cXIf+vB/X+Zag" +
       "TroTOsn5Pb0xdyaSVqFCRi+aSUtq5BWV88VqYNpeYb6kO/1B36BHxgq0e9gC" +
       "8Jq07E28fsF1V9Vic1gA0iSkmrHFxXzHYhmbw8ohy9bWcm2m560mFtYJukr0" +
       "F0GtlpPZjjlejiSV9/TWdDTUhujIWzdzvK8QM2MWc9XmpoJKcW1kEKzcNopU" +
       "nxHLYN1FqUkPT3g+Z0mzpkdENRyNSDZypvhkYBLSUGthAlPuOKG+0uDCluMs" +
       "PC/heRefenD1aZVnvUa9KLLMUBVH62JB2CwHwbro95Z5i8R6ltmcEsXFeoBF" +
       "iwk9adGlQoA3wcZnl71ce9iWK93etGmVeuO24eFOP+yU8JiqYA2DrGD16UQD" +
       "ZKLE7YBX1pt1nAeRwkrTUoDly2sJn/VQftj2lQptyzNCWnPDehPUcLc0n7WU" +
       "ZaFs2iiYFVSqP3LQuWqUVmSHdjBOMqc6vupWmGl72u3mK3lMRsv9pBHlZGEc" +
       "lXMe9FPL48DKL/OVPIoCUeryxopyLYuP6hI6E3VzNJmQnSShl1a5rDep2MFZ" +
       "vp3jnFVHRtHpZjYfNZyq2HSresvRxYnZs4m5k6h9LDaUHhZ7aqvP490h3RL0" +
       "QrGB04rNz6Zru7IyG3h1CcYgXm0SRfCGCw+VwKzT2ai5qhTjA95dOR7MRz3f" +
       "XDVxFQIvTJs1SZbLQcHDIBZyrkg35MU0r4kBpTcsZ1WtgRxJdtoqrloGxwiY" +
       "FKATBatoAPjspqbn4nIzN827c7JNVGYDbSL6FWZsTgsCQVZwUBkp4yjvFWa1" +
       "mT9hF9imiCt8sVihGjHWmfbrQa+amy17eBVF69F4nc+RhRnpmS2+XmhrJVIa" +
       "uoVOrd9jQUfr8YzYkmHObhD5oNkbwjQQI2s+Z1NKo7NMsKZfxTZ9uNYxZjxw" +
       "uFKlV5nH7sSyVd/1Ijkk6wO+2K8oK1CdNKZ1a1IcrW18MxUKw/IAtDtNgjKF" +
       "aB05rdDUl0SlwtdCZuwIk0bABj2MbdN+hQ0kujKsWWisunTHX8Ule850AemO" +
       "qI3YH1SoyawPfS/X5vB2Kw9zI5/quVFYIVE2x5p0BAO2v8GoxKx32mSlPYRr" +
       "G9yKvfml7YZvyzb++1c4cBOcNlAvYRe4bXogLR7ePyzMPmeOH/sfPiw8OEFC" +
       "0p3tPVe7mcl2tR9919PPaszHsJO7J29TgNwIXO/1lh7p1iFW6S3ko1ffwfez" +
       "i6mDE6Evvetf7x6/cf7Wl3DOfd8xOY+z/J3+c19pv0b9tZPIqf3zocuuzI52" +
       "euzoqdBZXweh74yPnA3ds4/shRSxe+GD7SKLXfms+YpWcCKzgu3cX+NgM7hG" +
       "W5gWDkBuhhsi2lVla7ArOnVgLu6POjQ4zDSrWB7V7x74VHf1q/749Xv7Ndre" +
       "mRYbgNwE9dubob1TsHuvdlOzvZk5AOBtLwOAW9PKAnyauwCQLwUA6Bie7wJd" +
       "Bbp2RRxO7Z7a7qr08LVV2r2f3qO+PaWOi+qO5to7u7dSVwfHiMAON5c9feDC" +
       "DXZK9tQ1gP9QWjwJkLNKaFpa1i+j4w4FoAlArotcUztA+pdeBtLZtc3r4WPs" +
       "Ij378Zjaid2Lt11gipcBk6IXRMZO3THt9BCXNiO9DtdAUwmBnh04Z3x/6xpo" +
       "fTwtnoWoz2VHs/Q9TvtcSFhv6FpK9cwBWr/5MtB61R5a4S5a4UtF61euZZDp" +
       "z/elxa+mxQcy0t+9BgC/nxbPAeSC6utQ88xeWDn718Ie8A9c3SIPU2bIfPKl" +
       "IJMA5I4rX86mN013XfZXkO3fF9RPPXvuhjuf5f8mu5/c/4vBjTRywyy0rMMX" +
       "A4fez3i+PjMzlW/cXhN42dcfA+TOq/guQM4oBwHpc1v6PwXI+eP0ADmdfR+m" +
       "+3PogQd0kNX25TDJFwByCpKkr1/09sB+/TVusTPIj+CUnDiaAOzPw4UfNQ+H" +
       "coaHjqz02f909lblcPtPnUvqp5/tDt72Qvlj27tV1ZI3m5TLDTRy/faad39l" +
       "f+Cq3PZ4naEeefHWz9z48F4WcutW4AOzPyTbfVe+yGzaHsiuHjd/dOcfvOHj" +
       "z34zu834P23/Z/FAJQAA");
}
