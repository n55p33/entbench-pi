package org.apache.batik.bridge;
public class SVGLineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    public SVGLineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGLineElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertStrokePainter(
            e,
            shapeNode,
            ctx);
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMLineElement le =
              (org.apache.batik.dom.svg.SVGOMLineElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX1(
                  );
            float x1 =
              _x1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY1(
                  );
            float y1 =
              _y1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX2(
                  );
            float x2 =
              _x2.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY2(
                  );
            float y2 =
              _y2.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Line2D.Float(
                  x1,
                  y1,
                  x2,
                  y2));
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
                    SVG_X1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_X2_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y2_ATTRIBUTE)) {
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUYa2wcR3nuzu+3nSdJ7LycoLzuEtI0VA6ljmMnTs+OFaeW" +
       "sEkuc7tzdxvv7W52Z+2z20BTUSUFKQohbUOhQYhUhdImBTUCBK2CKpGGFqSW" +
       "CCioKRI/CI+IRkjlR4Dyzczu7d7eIwoiJ+3s3jfffN9872/mxRuo2jJRF9Fo" +
       "lM4YxIr2a3QEmxaR+1RsWfsAlpCejuB/HLg+fF8Y1Yyjlgy2hiRskQGFqLI1" +
       "jjoVzaJYk4g1TIjMVoyYxCLmFKaKro2jeYo1mDVURVLokC4ThjCGzThqx5Sa" +
       "StKmZNAhQFFnHHYS4zuJ9Qane+KoSdKNGQ99oQ+9zzfDMLMeL4uitvghPIVj" +
       "NlXUWFyxaE/OROsMXZ1JqzqNkhyNHlK3OCrYHd9SpIIVL7d+eOtkpo2rYA7W" +
       "NJ1y8ay9xNLVKSLHUasH7VdJ1jqMPocicdToQ6aoO+4yjQHTGDB1pfWwYPfN" +
       "RLOzfToXh7qUagyJbYii5YVEDGzirENmhO8ZKNRRR3a+GKRdlpdWSFkk4pPr" +
       "YqefPtD2/QhqHUetijbKtiPBJigwGQeFkmySmFavLBN5HLVrYOxRYipYVWYd" +
       "S3dYSlrD1Abzu2phQNsgJufp6QrsCLKZtkR1My9eijuU8686peI0yDrfk1VI" +
       "OMDgIGCDAhszUxj8zllSNaloMkVLgyvyMnY/CAiwtDZLaEbPs6rSMABQh3AR" +
       "FWvp2Ci4npYG1GodHNCkaFFZokzXBpYmcZokmEcG8EbEFGDVc0WwJRTNC6Jx" +
       "SmClRQEr+exzY3jbiYe1XVoYhWDPMpFUtv9GWNQVWLSXpIhJIA7Ewqa18afw" +
       "/FePhxEC5HkBZIHzg0duPrC+69IbAmdxCZw9yUNEognpXLLl7SV9a+6LsG3U" +
       "GbqlMOMXSM6jbMSZ6ckZkGHm5ymyyag7eWnvzz7z6Avkr2HUMIhqJF21s+BH" +
       "7ZKeNRSVmDuJRkxMiTyI6okm9/H5QVQL33FFIwK6J5WyCB1EVSoH1ej8P6go" +
       "BSSYihrgW9FSuvttYJrh3zkDIVQLD2qCZzUSP/6mKBHL6FkSwxLWFE2PjZg6" +
       "k9+KQcZJgm4zsSR4/WTM0m0TXDCmm+kYBj/IEGciaSpymsRGx3ayrbKMACu3" +
       "c2CUOZpx91nkmJRzpkMhMMCSYPirEDm7dFUmZkI6bW/vv3k+8aZwLRYOjn4o" +
       "Wg9co4JrlHONCq7RUlxRKMSZzWXchaUBZxIiHlJu05rR/bsPHl8RARczpqtA" +
       "yQx1RUHp6fPSgpvLE9KFjubZ5dc2vR5GVXHUgSVqY5VVkl4zDTlKmnTCuCkJ" +
       "RcmrDct8tYEVNVOXiAypqVyNcKjU6VPEZHCK5voouJWLxWisfN0ouX906cz0" +
       "0bHPbwyjcGE5YCyrIZOx5SMsieeTdXcwDZSi23rs+ocXnjqiewmhoL64ZbFo" +
       "JZNhRdAdgupJSGuX4YuJV490c7XXQ8KmGOwNubAryKMg3/S4uZvJUgcCp3Qz" +
       "i1U25eq4gWZMfdqDcD9t599zwS0aWQAuhWedE5H8zWbnG2xcIPya+VlACl4b" +
       "PjVqPPvbX/55M1e3W0ZaffV/lNAeX+pixDp4kmr33HafSQjgvXdm5CtP3jg2" +
       "wX0WMFaWYtjNxj5IWWBCUPPjbxx+9/1r566GPT+nULvtJLRAubyQDI4aKggJ" +
       "3FZ7+4HUp0JuYF7T/ZAG/qmkFJxUCQusf7Wu2nTxbyfahB+oAHHdaP3tCXjw" +
       "j21Hj7554J9dnExIYqXX05mHJvL5HI9yr2niGbaP3NF3Or96GT8LlQGysaXM" +
       "Ep5gEdcB4kbbwuXfyMd7AnNb2bDK8jt/YXz5WqSEdPLqB81jH7x2k++2sMfy" +
       "23oIGz3CvdiwOgfkFwST0y5sZQDvnkvDn21TL90CiuNAUYKUa+0xIT/mCjzD" +
       "wa6u/d1PX59/8O0ICg+gBlXH8gDmQYbqwbuJlYHUmjM+/YAw7nQdDG1cVFQk" +
       "fBGAKXhpadP1Zw3KlT37wwWvbHv+7DXuZYagsdhP8ONsWJf3N/6rCZY5v78V" +
       "UDBRZ7lOhHdR5x47fVbe89wm0S90FFb3fmheX/r1v9+KnvnDlRIlpZ7qxgaV" +
       "TBHVx5MdQzoLasEQb9K8fPRey6k//qg7vf1OygCDdd0m0bP/S0GIteXTenAr" +
       "lx/7y6J992cO3kFGXxpQZ5Dkd4ZevLJztXQqzDtSkcyLOtnCRT1+xQJTk0Dr" +
       "rTExGaSZu/3KvAN0MMN2wbPRcYCNpbNqCd/J56pySytE9b4Kc2Ns2ENRUxr6" +
       "NV3C6jBIwzEXwomNBwDrxqOiG+cTn2TDiPDwnv8xuhig1+DwBwvV0wnPVkfG" +
       "rXeunnJLK6hAqjDHzXiAokZQj2tzVztd5doy0Yh5ukrcBV0tZnOfgGeHI/CO" +
       "Crri41o2bHCLYb1h6hQyGpED9bC5As2AoiKcWMTVx6rK+nBOsS72HIY9vVmK" +
       "yno26nSw5TWbnqLR0Qw2yDBkCy4arWC1R9iQpWiBZBI4ugwoqgr+q09CPuAn" +
       "VpfP8vJ8/JjciNpdMGKLa8T9jsInbuPwRrGtJsosLW0r9tdmwzQbZjj9Jypo" +
       "8kts+AJFDUlbUWWuGSgSayrc2phKFlq6KefcGzvS8f7k16+/JGpU8JAcQCbH" +
       "T3/xo+iJ06JeiZuElUWHef8acZvAd9omVPMR/ELw/Ic9TAwGYG+KOvqcI+2y" +
       "/JmWVW0TLa+0Lc5i4E8Xjvz420eOhR217KSoakpXZM89Hr8L7sGb8A3wPObY" +
       "+Oht3KNEPjxaZmnA5iHnMOgExuaiwGBRak2loQFUskxzcVBP/nZwDKu2iMpv" +
       "VPClb7HhGYjuDNZklbiU8lT6AJ4mMsM66Sn2a/8PxebgJFnqsMy6vIVFl3Li" +
       "Ikk6f7a1bsHZh37Dm538ZU8TtC0pW1V9Vd/fAdQYJkkpXN4m0fQa/PVdyEZl" +
       "8iOcTJJexXhB4J+H6hvEp6iav/1434PY9PCAlPjwo7xCUQRQ2OdFw7XwvRXu" +
       "FHYQSefhweO9QGG5UHGXy80073Zm8rW1KwvSB786dTsyW1yeJqQLZ3cPP3zz" +
       "3ufECVJS8ewso9IYR7XiMJvv6paXpebSqtm15lbLy/Wr3OhtFxv2gmexz0t7" +
       "IQwM5heLAscrqzt/ynr33LbXfnG85h1IVBMohKGYTfguLsUtHZzRbGinJ+Je" +
       "Q+27eufnvp41z8zcvz7199/zAwQSlzFLyuMnpKvP7//VqYXn4HzYOIiqITGR" +
       "3DhqUKwdM9peIk2Z46hZsfpzsEWgomB1ENXZmnLYJoNyHLUwF8asjeN6cdTZ" +
       "nIey+weKVhQn3OJbGzhsTRNzu25rPFyboQP3IAV3uk5YNNiGEVjgQfKmnFss" +
       "e0La8UTrT052RAYgDAvE8ZOvtexkvun2X/NygKgPbPhyTpSCSCI+ZBhuaaj+" +
       "piHi4rLAYXCKQmsdqC8/sr8/5+Su8E82vPVfQ4GXxcEZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/+iOP3jjbz/7rfyW4/8AZrTvW1IlAAA=");
}
