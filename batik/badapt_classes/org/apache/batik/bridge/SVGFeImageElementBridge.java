package org.apache.batik.bridge;
public class SVGFeImageElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_IMAGE_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        java.lang.String uriStr =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            filterElement);
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        org.w3c.dom.Document document =
          filterElement.
          getOwnerDocument(
            );
        boolean isUse =
          uriStr.
          indexOf(
            '#') !=
          -1;
        org.w3c.dom.Element contentElement =
          null;
        if (isUse) {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_USE_TAG);
        }
        else {
            contentElement =
              document.
                createElementNS(
                  SVG_NAMESPACE_URI,
                  SVG_IMAGE_TAG);
        }
        contentElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            uriStr);
        org.w3c.dom.Element proxyElement =
          document.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_G_TAG);
        proxyElement.
          appendChild(
            contentElement);
        java.awt.geom.Rectangle2D defaultRegion =
          filterRegion;
        org.w3c.dom.Element filterDefElement =
          (org.w3c.dom.Element)
            filterElement.
            getParentNode(
              );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          getBaseFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            ctx);
        contentElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getX(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getY(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getWidth(
                    )));
        contentElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                primitiveRegion.
                  getHeight(
                    )));
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            proxyElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            filterDefElement,
            null,
            SVG_PRIMITIVE_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                USER_SPACE_ON_USE;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  filterDefElement,
                  SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            at =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  at,
                  filteredNode);
        }
        filter =
          new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
            filter,
            at);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        java.awt.geom.Rectangle2D primitiveRegionUserSpace =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegionUserSpace,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createSVGFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                       java.awt.geom.Rectangle2D primitiveRegion,
                                                                                       org.w3c.dom.Element refElement,
                                                                                       boolean toBBoxNeeded,
                                                                                       org.w3c.dom.Element filterElement,
                                                                                       org.apache.batik.gvt.GraphicsNode filteredNode) {
        org.apache.batik.gvt.GraphicsNode node =
          ctx.
          getGVTBuilder(
            ).
          build(
            ctx,
            refElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          node.
          getGraphicsNodeRable(
            true);
        java.awt.geom.AffineTransform at =
          new java.awt.geom.AffineTransform(
          );
        if (toBBoxNeeded) {
            short coordSystemType;
            org.w3c.dom.Element filterDefElement =
              (org.w3c.dom.Element)
                filterElement.
                getParentNode(
                  );
            java.lang.String s =
              org.apache.batik.bridge.SVGUtilities.
              getChainableAttributeNS(
                filterDefElement,
                null,
                SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                ctx);
            if (s.
                  length(
                    ) ==
                  0) {
                coordSystemType =
                  org.apache.batik.bridge.SVGUtilities.
                    USER_SPACE_ON_USE;
            }
            else {
                coordSystemType =
                  org.apache.batik.bridge.SVGUtilities.
                    parseCoordinateSystem(
                      filterDefElement,
                      SVG_PRIMITIVE_UNITS_ATTRIBUTE,
                      s,
                      ctx);
            }
            if (coordSystemType ==
                  org.apache.batik.bridge.SVGUtilities.
                    OBJECT_BOUNDING_BOX) {
                at =
                  org.apache.batik.bridge.SVGUtilities.
                    toObjectBBox(
                      at,
                      filteredNode);
            }
            java.awt.geom.Rectangle2D bounds =
              filteredNode.
              getGeometryBounds(
                );
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    primitiveRegion.
                      getX(
                        ) -
                      bounds.
                      getX(
                        ),
                    primitiveRegion.
                      getY(
                        ) -
                      bounds.
                      getY(
                        )));
        }
        else {
            at.
              translate(
                primitiveRegion.
                  getX(
                    ),
                primitiveRegion.
                  getY(
                    ));
        }
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          at);
    }
    protected static org.apache.batik.ext.awt.image.renderable.Filter createRasterFeImage(org.apache.batik.bridge.BridgeContext ctx,
                                                                                          java.awt.geom.Rectangle2D primitiveRegion,
                                                                                          org.apache.batik.util.ParsedURL purl) {
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            ).
          readURL(
            purl);
        java.awt.geom.Rectangle2D bounds =
          filter.
          getBounds2D(
            );
        java.awt.geom.AffineTransform scale =
          new java.awt.geom.AffineTransform(
          );
        scale.
          translate(
            primitiveRegion.
              getX(
                ),
            primitiveRegion.
              getY(
                ));
        scale.
          scale(
            primitiveRegion.
              getWidth(
                ) /
              (bounds.
                 getWidth(
                   ) -
                 1),
            primitiveRegion.
              getHeight(
                ) /
              (bounds.
                 getHeight(
                   ) -
                 1));
        scale.
          translate(
            -bounds.
              getX(
                ),
            -bounds.
              getY(
                ));
        return new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
          filter,
          scale);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxkfn/ED4zfPEDBgDBGP3JEHbVLnZRwMDoe52sRS" +
       "DeGY25u7W7y3u+zO2YcpeSlVaKpSRElCq4a/oNCUhKhq2tI86irKS0krJUFN" +
       "0ygPKZFK2qIERU3/oG36fTO7t3t7d07TNrV0c3uz33wz3ze/7/d9Mz51ntTY" +
       "FulgOg/zPSazw+t1HqOWzZK9GrXtrdAXVx6sph/vODdwbYjUjpDmDLU3K9Rm" +
       "fSrTkvYIWajqNqe6wuwBxpI4ImYxm1ljlKuGPkJmq3Z/1tRUReWbjSRDgWFq" +
       "RUkb5dxSEznO+h0FnCyMwkoiYiWRnuDr7ihpVAxzjyc+zyfe63uDkllvLpuT" +
       "1uguOkYjOa5qkahq8+68RVaZhrYnrRk8zPI8vEtb67jglujaEhd0PtbyycWD" +
       "mVbhgplU1w0uzLMHmW1oYywZJS1e73qNZe3d5HZSHSUzfMKcdEXdSSMwaQQm" +
       "da31pGD1TUzPZXsNYQ53NdWaCi6IkyXFSkxq0ayjJibWDBrquWO7GAzWLi5Y" +
       "K60sMfH+VZHDD+5o/Uk1aRkhLao+hMtRYBEcJhkBh7Jsgll2TzLJkiOkTYfN" +
       "HmKWSjV1wtnpdltN65TnYPtdt2BnzmSWmNPzFewj2GblFG5YBfNSAlDOr5qU" +
       "RtNg6xzPVmlhH/aDgQ0qLMxKUcCdM2TaqKonOVkUHFGwsWsTCMDQuizjGaMw" +
       "1TSdQgdplxDRqJ6ODAH09DSI1hgAQIuT+RWVoq9NqozSNIsjIgNyMfkKpKYL" +
       "R+AQTmYHxYQm2KX5gV3y7c/5gesO7NU36iFSBWtOMkXD9c+AQR2BQYMsxSwG" +
       "cSAHNq6MPkDnPLU/RAgIzw4IS5mff/3CTas7Jl+QMpeWkdmS2MUUHleOJZpf" +
       "WdC74tpqXEa9adgqbn6R5SLKYs6b7rwJDDOnoBFfht2Xk4PPfe3Oh9mfQ6Sh" +
       "n9QqhpbLAo7aFCNrqhqzNjCdWZSzZD+ZzvRkr3jfT+rgOarqTPZuSaVsxvvJ" +
       "NE101RriN7goBSrQRQ3wrOopw302Kc+I57xJCKmDD2mEz0oi/8Q3J4lIxsiy" +
       "CFWorupGJGYZaL8dAcZJgG8zkQSgfjRiGzkLIBgxrHSEAg4yzHmRsNRkmkWG" +
       "hjf0sf4sQABJAQavE/1hxJr5f5klj7bOHK+qgm1YECQBDeJno6ElmRVXDufW" +
       "rb/waPwlCTAMCsdLnODEYTlxWEwclhOHK0xMqqrEfLNwAXLLYcNGIfSBextX" +
       "DN12y879ndWANXN8GngbRTuLclCvxw8uqceV0+1NE0vevuKZEJkWJe1U4Tmq" +
       "YUrpsdJAVsqoE8+NCchOXpJY7EsSmN0sQ2FJ4KhKycLRUm+MMQv7OZnl0+Cm" +
       "MAzWSOUEUnb9ZPLI+F3Dd6wJkVBxXsApa4DScHgM2bzA2l1BPiint+Xec5+c" +
       "fmCf4TFDUaJx82PJSLShM4iIoHviysrF9PH4U/u6hNunA3NzCpEGpNgRnKOI" +
       "eLpdEkdb6sHglGFlqYavXB838IxljHs9Aqpt4nkWwGIGRmInfNY4oSm+8e0c" +
       "E9u5EtqIs4AVIklcP2Q+9PvffnCVcLebT1p8hcAQ490+DkNl7YKt2jzYbrUY" +
       "A7m3jsS+e//5e7cJzILE0nITdmHbC9wFWwhu/sYLu9945+1jZ0Mezjkk8VwC" +
       "aqF8wUjsJw1TGAmzLffWAxyoAUMgarpu1QGfakqlCY1hYP29ZdkVj//lQKvE" +
       "gQY9LoxWf7YCr/+SdeTOl3b8rUOoqVIwB3s+88Qksc/0NPdYFt2D68jf9erC" +
       "7z1PH4IUAbRsqxNMMC0RPiBi09YK+9eI9urAuy9js8z2g784vny1Ulw5ePaj" +
       "puGPnr4gVltcbPn3ejM1uyW8sFmeB/Vzg+S0kdoZkLt6cmB7qzZ5ETSOgEYF" +
       "iNfeYgFF5ouQ4UjX1P3h18/M2flKNQn1kQbNoMk+KoKMTAd0MzsD7Jo3b7xJ" +
       "bu54PTStwlRSYnxJBzp4UfmtW581uXD2xC/m/vS6E0ffFigzpY5L/Qovw2ZV" +
       "AW/irzaY7/x4K9JgkYWVShJRTh27+/DR5JbjV8jCob04za+HKvaR3/3j5fCR" +
       "d18sk1Wmc8O8XGNjTPPNOQ2nLMoFm0W15vHRW82H3jvTlV73edIA9nV8BtHj" +
       "70VgxMrKtB5cyvN3/2n+1hsyOz8Hoy8KuDOo8kebT724YblyKCRKU0nmJSVt" +
       "8aBuv2NhUotBDa6jmdjTJGC/tACAdtzYDvisdQCwtjyrlsFOgasqDZ0iqrdO" +
       "8W4Ymy2cNKahcDMUqg2ANUJyHhzdRABgWR6WZbl4cQ02MYnw7v8wurCjxxT9" +
       "m0rds8mxcdPnd0+loQEX1ImF1LmGLqtUZMmayjmJudIzUXr8KiWcNLJhp/jC" +
       "VylXYEmJuvQYD2+wqJlRFXsAAO9KrimRRODTcR5WsbILQ0oH9sMkEe5TNTgP" +
       "uQMvEVuDgmkGqxgEcoJt0tiVNxcHMUbnUC5h80E6Lugjrmy/rHVO17Ufd0re" +
       "6Cgj6zv6HHjilyMjl7UqUriznOLiI8/JE/XKm9nn3pcDLikzQMrNPhn59vDr" +
       "u14W8VuPhFGIGh9ZALH46pPWwn434/a2weddZ7/FNyfb/8uiHobBeV7NAtYj" +
       "W9UsSzrb6x4avlD9IjMW8a+3aT8e1Xo+vOaH10u3LqnAk578ma+++8pDE6dP" +
       "Se5H93KyqtINSOm1C9any6aosT2A/HXDVyY/eG/4tpBDKM3Y2HkXp01eDoWM" +
       "jZ17C0FYVTiBzCqGidR88zdbnjzYXt0Hyaaf1Od0dXeO9SeLCbfOziV8uPEO" +
       "+h79OqD5FP6q4PNP/CBYsEOCpr3XOfQuLpx6IZ3je06qVsKj0KNMwaL3YLMD" +
       "WFSxGAyXoYp9uzzGjH8BjLkA362Gz7NOGDw7BWOKdiU2lwulISgDTMvgAGCW" +
       "hPLYFrdOgfJ41hTKAw6pFVpr8WcSG01yYnnWiFkQBFwdc/b6ythOZX9X7H0X" +
       "RbuxuRMDYsUUV4XFOiL72t8Z/cG5RxxeKzldFQmz/Yfv+zR84LCMD3l9tbTk" +
       "Bsk/Rl5hSUgVVrdkqlnEiL4/nt73xMl997qWbeCkLmEYGqN6MBDw5x1CKIVN" +
       "RjwemgJ2R7G5D/K0hJ13IxCA3re+KOhFYNUOOOT3vws9fDyAzXdK8VZRY8AT" +
       "1UJVtYc3l3MWlSRVefMlKO7WwahY2cNT+PVRbI5Bopd+HaQ2hHN51x7/X7g2" +
       "z8ncCtc5eA6ZV3J/LO88lUePttTPPXrr66IcL9xLNkI+TeU0zUeTfsqsNS2W" +
       "UoWdjfJYZoqvn8EiKpRBQA7yQRjwuJQ/A7gLynNSI779ck9y0uDJgSr54Bf5" +
       "FSfVIIKPk6a7izdWqsl6gD4sOHugxwTRFoKuyHP5qtIDmdiy2Z+1Zb4T2NIi" +
       "9hHX/S6T5WJOqj199JaBvRe+dFxediganZhALTMgO8l7l8IBZElFba6u2o0r" +
       "LjY/Nn2ZyxZtcsFeKF3qg2kPxIiJAJkfuAmwuwoXAm8cu+7p3+yvfRV4bhup" +
       "ooDpbb7Ldnmz3J03c1A0bouWZmE4rIkriu4V399zw+rUh2+Ksy6RWXtBZfm4" +
       "cvbEba8dmnesI0Rm9JMaIEKWHyENqn3zHh2K1TFrhDSp9vo8LBG0qFQrSvHN" +
       "iGWKJw7hF8edTYVevCrjpLOUr0svGBs0Y5xZ64ycnnSKhBleT9H/IZz4aMiZ" +
       "ZmCA1+MrRm+XSQB3A+Abj242TbekqDllisi+ozLDvyYesTn7L1MimXkKHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
