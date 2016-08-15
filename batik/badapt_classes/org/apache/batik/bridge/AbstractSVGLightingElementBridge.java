package org.apache.batik.bridge;
public abstract class AbstractSVGLightingElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    protected AbstractSVGLightingElementBridge() { super(); }
    protected static org.apache.batik.ext.awt.image.Light extractLight(org.w3c.dom.Element filterElement,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.Color color =
          org.apache.batik.bridge.CSSUtilities.
          convertLightingColor(
            filterElement,
            ctx);
        for (org.w3c.dom.Node n =
               filterElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)) {
                continue;
            }
            return ((org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge)
                      bridge).
              createLight(
                ctx,
                filterElement,
                e,
                color);
        }
        return null;
    }
    protected static double[] convertKernelUnitLength(org.w3c.dom.Element filterElement,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        double[] units =
          new double[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            units[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                units[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                units[1] =
                  units[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              units[0] <=
              0 ||
              units[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        return units;
    }
    protected abstract static class AbstractSVGLightElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        public abstract org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element lightElement,
                                                                         java.awt.Color color);
        public AbstractSVGLightElementBridge() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "jf8BnF/rZ6UUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LCAAAA==");
    }
    public static class SVGFeSpotLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeSpotLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_SPOT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            double px =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_X_ATTRIBUTE,
                0,
                ctx);
            double py =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Y_ATTRIBUTE,
                0,
                ctx);
            double pz =
              convertNumber(
                lightElement,
                SVG_POINTS_AT_Z_ATTRIBUTE,
                0,
                ctx);
            double specularExponent =
              convertNumber(
                lightElement,
                SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                1,
                ctx);
            double limitingConeAngle =
              convertNumber(
                lightElement,
                SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                90,
                ctx);
            return new org.apache.batik.ext.awt.image.SpotLight(
              x,
              y,
              z,
              px,
              py,
              pz,
              specularExponent,
              limitingConeAngle,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcxRWfO387ts92YjvNh+M4l1Rx0jsiSAtySrGNnTic" +
           "HdcOVuuUXOZ25+423tvd7M7ZZwMFgirCPzRKHRJQsfjDCFFRQFVRW6kgV0gF" +
           "RFsJGrWlFWml/kM/ohJVon+kX+/N7t7u7fkSJapqaefWM2/evM/fe7MvXyE1" +
           "lkm6mcZjfMFgVmxY4xPUtJg8pFLLOgpzSelCFf378Y/H7wqT2hnSkqXWmEQt" +
           "NqIwVbZmyFZFszjVJGaNMybjjgmTWcyco1zRtRnSoVijOUNVJIWP6TJDgmlq" +
           "Jkgb5dxUUnnORh0GnGxNgCRxIUl8ILjcnyBNkm4seOQbfeRDvhWkzHlnWZy0" +
           "Jk7SORrPc0WNJxSL9xdMssfQ1YWMqvMYK/DYSXW/Y4LDif1lJuh9LfLptbPZ" +
           "VmGC9VTTdC7UsyaZpatzTE6QiDc7rLKcdYp8nVQlyDofMSfRhHtoHA6Nw6Gu" +
           "th4VSN/MtHxuSBfqcJdTrSGhQJxsL2ViUJPmHDYTQmbgUM8d3cVm0LanqK2t" +
           "ZZmK5/fEly4cb/1eFYnMkIiiTaE4EgjB4ZAZMCjLpZhpDcgyk2dImwbOnmKm" +
           "QlVl0fF0u6VkNMrz4H7XLDiZN5gpzvRsBX4E3cy8xHWzqF5aBJTzX01apRnQ" +
           "tdPT1dZwBOdBwUYFBDPTFOLO2VI9q2gyJ9uCO4o6Ru8DAthal2M8qxePqtYo" +
           "TJB2O0RUqmXiUxB6WgZIa3QIQJOTTRWZoq0NKs3SDEtiRAboJuwloGoQhsAt" +
           "nHQEyQQn8NKmgJd8/rkyfuCpB7VDWpiEQGaZSSrKvw42dQc2TbI0Mxnkgb2x" +
           "qS/xNO1840yYECDuCBDbND946Oo9e7tX37FpNq9BcyR1kkk8Ka2kWt7fMrT7" +
           "rioUo97QLQWdX6K5yLIJZ6W/YADCdBY54mLMXVyd/OlXH/0O+0uYNI6SWklX" +
           "8zmIozZJzxmKysyDTGMm5UweJQ1Mk4fE+iipg/eEojF79kg6bTE+SqpVMVWr" +
           "i//BRGlggSZqhHdFS+vuu0F5VrwXDEJIOzykC54nif0nfjmZjWf1HItTiWqK" +
           "pscnTB31t+KAOCmwbTaegqifjVt63oQQjOtmJk4hDrLMWUiZipxh8YEUxDmV" +
           "+NT0wYSSyXIIK0QH4DIoCGIYdMb/97gCar9+PhQCx2wJwoIKGXVIV2VmJqWl" +
           "/ODw1VeS79khh2ni2I2ToyBBzJYgJiSI2RLEbiRBFBZG2JShc7FcskZCISHU" +
           "BpTSjhTw8ywgBkB20+6pBw6fONNbBSFqzFeDk5C0t6R0DXmw4taCpPRqe/Pi" +
           "9sv73gqT6gRpB9HyVMVKNGBmAOOkWQcGmlJQ1Lza0uOrLVgUTV1iMkBbpRrj" +
           "cKnX55iJ85xs8HFwKx/meLxy3VlTfrJ6cf6x6UduC5NwaTnBI2sACXH7BBaB" +
           "IthHgzCyFt/IEx9/+urTD+seoJTUJ7eslu1EHXqDYRM0T1Lq66GvJ994OCrM" +
           "3gCAzykkKGBpd/CMErzqd7EfdakHhdO6maMqLrk2buRZU5/3ZkQ8t4n3DRAW" +
           "EUzgPni+6WS0+MXVTgPHLjv+Mc4CWoja8sUp47nf/OJPtwtzu2Uo4usfphjv" +
           "90EfMmsXINfmhe1RkzGg++jixLfOX3nimIhZoNix1oFRHIcA8sCFYOZvvHPq" +
           "w99fXrkU9uKcQ+3Pp6CFKhSVrEedWq6jJJy2y5MHoFMFPMGoid6vQXwqaYWm" +
           "VIaJ9c/Izn2v//WpVjsOVJhxw2jvjRl4858ZJI++d/wf3YJNSMLS7dnMI7Pr" +
           "wXqP84Bp0gWUo/DYB1ufeZs+B5UF0NxSFpkAaCJsQITT9gv9bxPjHYG1L+Cw" +
           "0/IHf2l++VqspHT20ifN05+8eVVIW9qj+X09Ro1+O7xw2FUA9l1BcDpErSzQ" +
           "3bE6/rVWdfUacJwBjhLAtHXEBBwtlESGQ11T99ufvNV54v0qEh4hjapO5REq" +
           "kow0QHQzKwsQXDC+dI/t3Hl0d6tQlZQpXzaBBt62tuuGcwYXxl78Ydf3D7y4" +
           "fFlEmWHz2Oxn+Fkx9uHwOTEfxtcYhKIlGkMvFMWmtmAF9YdiCXOTbK3U5IgG" +
           "beX00rJ85IV9divSXto4DENf/N1f/etnsYt/eHeNqlTrNKnegWE8r6RGjInm" +
           "z8Opj1rO/fFH0czgzZQHnOu+QQHA/7eBBn2V4T4oytun/7zp6N3ZEzeB9NsC" +
           "tgyyfGns5XcP7pLOhUWna4N8WYdcuqnfb1U41GTQ0muoJs40i3TYUfR+J3q1" +
           "F54lx/tLa6OtiCkc9pRjWKWt18n26eusfQWHL3PSlIE+UJeoOg7aCMqNcBMU" +
           "iYFdfszu8sXCnThM2jHdf4tZhxMDhpgfK+rYgWs98Dzv6Pj8zZun0taACaqF" +
           "INWuojsrdWh2r+Vc7Fzq9Ug9f7sUk/VczGnKcCnrErQIu9F5jniim0Jsdh0n" +
           "5HA4wck6yWTQwotmz+UVLRMNUwN5Kzm4LMU8YuEX+r/wS4GTzddpPV3R7rzV" +
           "vhZwZmPZFdu+FkqvLEfqu5bv/7WAmOLVrQnAIp1XVV+u+fOu1jBZWhG2bLJL" +
           "kCF+FjjpqiAkAGDK06Zg0z8EMR+k56RG/PrpHuGk0aMDVvaLn+Q0J1VAgq+P" +
           "G67Fpm/5JhAkKFkthMprkoiGjhtFg6/S7CjBXvGhxMXJvP2pBK4Hy4fHH7z6" +
           "+Rfsfk9S6eKiuFgnSJ3dehaxdntFbi6v2kO7r7W81rAz7CRBmy2wl+KbfRky" +
           "AJ2dgbV6U6AZsqLFnujDlQNv/vxM7QdQ646REIU8Peb7TGHfyaGjykORO5bw" +
           "ypzvQ5vo0vp3P7tw9970334nyj2xr05bKtMnpUsvPvDLcxtXoJtbN0pqoCyz" +
           "wgxpVKx7F7RJJs2ZM6RZsYYLICJwUag6SurzmnIqz0blBGnBEKcIrsIujjmb" +
           "i7N4W+Ckt+xbyRp3LGiN5pk5qOc1WVQfqIveTMkXHLdc5Q0jsMGbKbpyQ7nu" +
           "SeneJyM/PtteNQJpWqKOn32dlU8VS6H/o45XG1ttBP8P/IXg+Tc+6HScwF9O" +
           "2oecDxw9xS8c0IPZa1XJxJhhuLTVpw070c7jcKGA85yE+pxZxLmQfUfAf58V" +
           "5z8jXnH49n8B8nc+6eAVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFeDistantLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFeDistantLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_DISTANT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double azimuth =
              convertNumber(
                lightElement,
                SVG_AZIMUTH_ATTRIBUTE,
                0,
                ctx);
            double elevation =
              convertNumber(
                lightElement,
                SVG_ELEVATION_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.DistantLight(
              azimuth,
              elevation,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/7R4xeH7/wWbokFv5hUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class SVGFePointLightElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge.AbstractSVGLightElementBridge {
        public SVGFePointLightElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_POINT_LIGHT_TAG;
        }
        public org.apache.batik.ext.awt.image.Light createLight(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element filterElement,
                                                                org.w3c.dom.Element lightElement,
                                                                java.awt.Color color) {
            double x =
              convertNumber(
                lightElement,
                SVG_X_ATTRIBUTE,
                0,
                ctx);
            double y =
              convertNumber(
                lightElement,
                SVG_Y_ATTRIBUTE,
                0,
                ctx);
            double z =
              convertNumber(
                lightElement,
                SVG_Z_ATTRIBUTE,
                0,
                ctx);
            return new org.apache.batik.ext.awt.image.PointLight(
              x,
              y,
              z,
              color);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwcRxWfu/N3bJ/txHbIh+M4TlCccNeoDbRyKLVdO3F6" +
           "doydWODQXOZ25+423tvd7M7ZZ7elbQA1/FNFIWnSivovV1VRaStEBUi0MqpE" +
           "WxWQWiKgoAYk/ikfEY2QClKg8N7s7u3ens9RIsRJN7c38+bN+/y9N/viNVJt" +
           "maSLaTzGFwxmxYY1PkFNi8lDKrWsozCXlC5F6N9PfDh+T5jUzJDmLLXGJGqx" +
           "EYWpsjVDtiqaxakmMWucMRl3TJjMYuYc5YquzZB2xRrNGaoiKXxMlxkSTFMz" +
           "QVop56aSynM26jDgZGsCJIkLSeIDweX+BGmUdGPBI9/oIx/yrSBlzjvL4qQl" +
           "cYrO0XieK2o8oVi8v2CSPYauLmRUncdYgcdOqfsdExxO7C8zQc8r0Y9vnMu2" +
           "CBOsp5qmc6GeNcksXZ1jcoJEvdlhleWs0+SrJJIg63zEnPQm3EPjcGgcDnW1" +
           "9ahA+iam5XNDulCHu5xqDAkF4mR7KRODmjTnsJkQMgOHOu7oLjaDtt1FbW0t" +
           "y1S8uCd+4dKJlu9FSHSGRBVtCsWRQAgOh8yAQVkuxUxrQJaZPENaNXD2FDMV" +
           "qiqLjqfbLCWjUZ4H97tmwcm8wUxxpmcr8CPoZuYlrptF9dIioJx/1WmVZkDX" +
           "Dk9XW8MRnAcFGxQQzExTiDtnS9WsosmcbAvuKOrY+wAQwNbaHONZvXhUlUZh" +
           "grTZIaJSLROfgtDTMkBarUMAmpxsqsgUbW1QaZZmWBIjMkA3YS8BVb0wBG7h" +
           "pD1IJjiBlzYFvOTzz7XxA08+pB3SwiQEMstMUlH+dbCpK7BpkqWZySAP7I2N" +
           "fYmnaMdrZ8OEAHF7gNim+cHD1+/b27Xylk2zeRWaI6lTTOJJaTnV/O6Wod33" +
           "RFCMOkO3FHR+ieYiyyaclf6CAQjTUeSIizF3cWXyp19+7DvsL2HSMEpqJF3N" +
           "5yCOWiU9ZygqMw8yjZmUM3mU1DNNHhLro6QWnhOKxuzZI+m0xfgoqVLFVI0u" +
           "/oOJ0sACTdQAz4qW1t1ng/KseC4YhJA2+JJO+P6T2B/xy8lsPKvnWJxKVFM0" +
           "PT5h6qi/FQfESYFts/EURP1s3NLzJoRgXDczcQpxkGXOQspU5AyLD6QgzqnE" +
           "p6YPJpRMlkNYIToAl0FBEMOgM/6/xxVQ+/XzoRA4ZksQFlTIqEO6KjMzKV3I" +
           "Dw5ffyn5jh1ymCaO3Tg5BhLEbAliQoKYLUHsZhL0wsIIm9AhfcV6ySIJhYRU" +
           "G1BMO1TA0bMAGYDZjbunHjx88mxPBGLUmK8CLyFpT0ntGvJwxS0GSenltqbF" +
           "7Vf3vREmVQnSBrLlqYqlaMDMAMhJsw4ONKagqnnFpdtXXLAqmrrEZMC2SkXG" +
           "4VKnzzET5znZ4OPglj5M8njlwrOq/GTl8vzj04/eESbh0nqCR1YDFOL2CawC" +
           "RbTvDeLIanyjT3z48ctPPaJ7iFJSoNy6WrYTdegJxk3QPEmpr5u+mnztkV5h" +
           "9npAfE4hQwFMu4JnlABWvwv+qEsdKJzWzRxVccm1cQPPmvq8NyMCulU8b4Cw" +
           "iGIG74HvJ05Ki19c7TBw7LQTAOMsoIUoLp+fMp79zS/+dKcwt1uHor4GYorx" +
           "fh/2IbM2gXKtXtgeNRkDug8uT3zr4rUnjouYBYodqx3Yi+MQYB64EMz8jbdO" +
           "v//7q8tXwl6ccyj++RT0UIWiknWoU/MaSsJpuzx5ADtVABSMmt5jGsSnklZo" +
           "SmWYWP+K7tz36l+fbLHjQIUZN4z23pyBN/+pQfLYOyf+0SXYhCSs3Z7NPDK7" +
           "IKz3OA+YJl1AOQqPv7f16Tfps1BaAM4tZZEJhCbCBkQ4bb/Q/w4x3hVY+xwO" +
           "Oy1/8Jfml6/HSkrnrnzUNP3R69eFtKVNmt/XY9Tot8MLh10FYN8ZBKdD1MoC" +
           "3V0r419pUVduAMcZ4CgBTltHTADSQklkONTVtb/9yRsdJ9+NkPAIaVB1Ko9Q" +
           "kWSkHqKbWVnA4ILxhfts586ju1uEqqRM+bIJNPC21V03nDO4MPbiDzu/f+D5" +
           "pasiygybx2Y/w0+LsQ+Hz4j5MD7GIBQt0Rl6oSg2tQZLqD8US5ibZGulLkd0" +
           "aMtnLizJR57bZ/cibaWdwzA0xt/91b9/Frv8h7dXKUs1TpfqHRjG80pqxJjo" +
           "/jyc+qD5/B9/1JsZvJXygHNdNykA+H8baNBXGe6Dorx55s+bjt6bPXkLSL8t" +
           "YMsgyxfGXnz74C7pfFi0ujbIl7XIpZv6/VaFQ00GPb2GauJMk0iHHUXvd6BX" +
           "ewCkIrbz7d9ytBUxhcOeMgyruHWNbJ9eY+1LOHyRk8YMNIK6RNVx0EZQboSr" +
           "oEgMbPNjdpsvFu7GYdKO6f7bzDqcGDDE/FhRx3Zc6wbdoo6O0Vs3T6WtARNU" +
           "CUGqXEV3VmrR7F7Ludm51OuRev5OKSbruZjTlOFS1iVoFnaj8xzxRDeF2GwN" +
           "J+RwOMnJOslk0MOLZs/l1VsmGqYG8lZycFuKecTCL/R/4ZcCJ1vW6j1d2e6+" +
           "3c4WgGZj2SXbvhhKLy1F6zqXjv1aYEzx8tYIaJHOq6ov2fyJV2OYLK0IYzba" +
           "NcgQPwucdFYQEhAw5WlTsOkfhqAP0nNSLX79dI9y0uDRASv7wU9yhpMIkODj" +
           "1wzXYtO3fRcIEpSsFkLlRUmEQ/vNwsFXanaUgK94VeICZd5+WQL3g6XD4w9d" +
           "/+xzdsMnqXRxUVytE6TW7j2LYLu9IjeXV82h3TeaX6nfGXayoNUW2Mvxzb4U" +
           "GYCcNrBYbwp0Q1ZvsSl6f/nA6z8/W/MeFLvjJEQhUY/7XlTYt3JoqfJQ5Y4n" +
           "vDrne9Um2rT+3c8s3Ls3/bffiXpP7LvTlsr0SenK8w/+8vzGZWjn1o2SaqjL" +
           "rDBDGhTr/gVtkklz5gxpUqzhAogIXBSqjpK6vKaczrNROUGaMcQpoquwi2PO" +
           "puIsXhc46Sl7W7LKJQt6o3lmDup5TRblBwqjN1PyDsetV3nDCGzwZoqu3FCu" +
           "e1K6/5vRH59ri4xAmpao42dfa+VTxVrof63jFccWG8L/A58QfD/BLzodJ/CX" +
           "k7Yh5xVHd/EdBzRh9lokmRgzDJe26uuGnWgXcbhUwHlOQn3OLAJdyL4k4N9n" +
           "xPlPi0ccvv1fMOkb5uIVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd3G7YqndJ7iM8VhhI1n+CMbzv4TWQWDxQ0ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Tf+9jPfyA/x/weUQY8eXCQAAA==");
}
