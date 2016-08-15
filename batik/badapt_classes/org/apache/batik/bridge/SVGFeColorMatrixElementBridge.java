package org.apache.batik.bridge;
public class SVGFeColorMatrixElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeColorMatrixElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        int type =
          convertType(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable colorMatrix;
        switch (type) {
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_HUE_ROTATE:
                float a =
                  convertValuesToHueRotate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildHueRotate(
                      a);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_LUMINANCE_TO_ALPHA:
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildLuminanceToAlpha(
                      );
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_MATRIX:
                float[][] matrix =
                  convertValuesToMatrix(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildMatrix(
                      matrix);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_SATURATE:
                float s =
                  convertValuesToSaturate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildSaturate(
                      s);
                break;
            default:
                throw new java.lang.Error(
                  "invalid convertType:" +
                  type);
        }
        colorMatrix.
          setSource(
            in);
        handleColorInterpolationFilters(
          colorMatrix,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          colorMatrix,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[][] convertValuesToMatrix(org.w3c.dom.Element filterElement,
                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        float[][] matrix =
          new float[4][5];
        if (s.
              length(
                ) ==
              0) {
            matrix[0][0] =
              1;
            matrix[1][1] =
              1;
            matrix[2][2] =
              1;
            matrix[3][3] =
              1;
            return matrix;
        }
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        int n =
          0;
        try {
            while (n <
                     20 &&
                     tokens.
                     hasMoreTokens(
                       )) {
                matrix[n /
                         5][n %
                              5] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
                n++;
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s,
              nfEx });
        }
        if (n !=
              20 ||
              tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
        for (int i =
               0;
             i <
               4;
             ++i) {
            matrix[i][4] *=
              255;
        }
        return matrix;
    }
    protected static float convertValuesToSaturate(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 1;
        try {
            return org.apache.batik.bridge.SVGUtilities.
              convertSVGNumber(
                s);
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static float convertValuesToHueRotate(org.w3c.dom.Element filterElement,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 0;
        try {
            return (float)
                     java.lang.Math.
                     toRadians(
                       org.apache.batik.bridge.SVGUtilities.
                         convertSVGNumber(
                           s));
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static int convertType(org.w3c.dom.Element filterElement,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_TYPE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_HUE_ROTATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_HUE_ROTATE;
        }
        if (SVG_LUMINANCE_TO_ALPHA_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_LUMINANCE_TO_ALPHA;
        }
        if (SVG_MATRIX_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_SATURATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_SATURATE;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC3AV1Rk+uSEP8iAhvF8BQpACeq+iVG18hUggehPSBNNp" +
       "QMJm77k3C3t3l91zk0ssgkw7UjulSlGxIxnboliLYp3a1vqitfUxWjso1Vrr" +
       "oz5alTpCHW2n2Nr/P2f37uM+kBaamT13c85//nP+x/n+//y7731SYpmknmos" +
       "zDYa1Aov1VinZFo01qJKlrUS+vrkm4ulD9e803F+iJT2kjEDktUuSxZtVaga" +
       "s3rJDEWzmKTJ1OqgNIYzOk1qUXNQYoqu9ZIJitWWNFRFVli7HqNI0COZUTJW" +
       "YsxU+lOMttkMGJkRhZ1E+E4izcHhpiipknVjo0s+2UPe4hlByqS7lsVIbXSd" +
       "NChFUkxRI1HFYk1pkyw0dHVjQtVZmKZZeJ262FbBZdHFWSpouLfm42PXD9Ry" +
       "FYyTNE1nXDyri1q6OkhjUVLj9i5VadLaQK4mxVFS6SFmpDHqLBqBRSOwqCOt" +
       "SwW7r6ZaKtmic3GYw6nUkHFDjMz2MzEkU0rabDr5noFDObNl55NB2lkZaYWU" +
       "WSLeuDCy8+Y1tfcVk5peUqNo3bgdGTbBYJFeUChN9lPTao7FaKyXjNXA2N3U" +
       "VCRVGbYtXWcpCU1iKTC/oxbsTBnU5Gu6ugI7gmxmSma6mREvzh3K/q8krkoJ" +
       "kHWiK6uQsBX7QcAKBTZmxiXwO3vKqPWKFmNkZnBGRsbGy4EAppYlKRvQM0uN" +
       "0iToIHXCRVRJS0S6wfW0BJCW6OCAJiNT8zJFXRuSvF5K0D70yABdpxgCqtFc" +
       "ETiFkQlBMs4JrDQ1YCWPfd7vuGD7VdpyLUSKYM8xKqu4/0qYVB+Y1EXj1KRw" +
       "DsTEqgXRm6SJD28LEQLEEwLEguanXzl6yen1B54UNNNy0KzoX0dl1ifv6R9z" +
       "cHrL/POLcRvlhm4paHyf5PyUddojTWkDEGZihiMOhp3BA12Pf3nLXfRwiFS0" +
       "kVJZV1NJ8KOxsp40FJWay6hGTYnRWBsZTbVYCx9vI2XwHlU0KnpXxOMWZW1k" +
       "lMq7SnX+P6goDixQRRXwrmhx3Xk3JDbA39MGIaQMHlIFzzwi/vgvIwORAT1J" +
       "I5IsaYqmRzpNHeW3IoA4/aDbgUg/eP36iKWnTHDBiG4mIhL4wQC1B/pNJZag" +
       "ke6eZa0UNq6b7RI4VRqhAVgs4aNh9Djj/7hWGuUeN1RUBCaZHgQEFc7Scl2N" +
       "UbNP3plasvToPX1PC2fDA2JrjJHFsHxYLB/my4fF8uGCy5OiIr7qeNyGcAIw" +
       "4XoAA0DjqvndV162dltDMXifMTQK9I+kDb6o1OIihgPzffL+uurh2a+e9ViI" +
       "jIqSOklmKUnFINNsJgC+5PX2Ca/qh3jlho1ZnrCB8c7UZRoD1MoXPmwu5fog" +
       "NbGfkfEeDk5Qw+MbyR9Scu6fHNg1dE3P5jNDJOSPFLhkCYAcTu9EfM/geGMQ" +
       "IXLxrbn2nY/337RJd7HCF3qciJk1E2VoCPpFUD198oJZ0v19D29q5GofDVjO" +
       "JDh7AJP1wTV8UNTkwDrKUg4Cx3UzKak45Oi4gg2Y+pDbwx12LH8fD25RiWfz" +
       "c/CcYR9W/oujEw1sJwkHRz8LSMHDxoXdxu7fP/vu2VzdToSp8aQG3ZQ1eVAN" +
       "mdVx/Brruu1Kk1Kge2VX57dvfP/aVdxngWJOrgUbsW0BNAMTgpq/9uSGl157" +
       "dc+hkOvnDMJ6qh+yo3RGSOwnFQWEhNVOc/cDJ04FtECvabxCA/9U4orUr1I8" +
       "WJ/UzD3r/r9urxV+oEKP40anH5+B2z9lCdny9Jq/13M2RTJGZVdnLpmA+nEu" +
       "52bTlDbiPtLXPDfjliek3RA0AKgtZZhy7CVcB4QbbTGX/0zenhMYOxebuZbX" +
       "+f3ny5M99cnXHzpS3XPkkaN8t/70y2vrdsloEu6FzWlpYD8pCE7LJWsA6M45" +
       "0LG6Vj1wDDj2AkcZQNhaYQJQpn2eYVOXlP3hF49NXHuwmIRaSYWqS7FWiR8y" +
       "Mhq8m1oDgLFp4+JLhHGHyqGp5aKSLOGzOlDBM3ObbmnSYFzZwz+b9OML9o68" +
       "yr3MEDymeRnOw2Zhxt/4X2kwAnr9zcfBJDPyJSk8wdqzdedIbMXtZ4lUos4f" +
       "+JdCXnv3C/96Jrzr9adyxJbRTDfOUOkgVT1rluKSvljQzvM3F49eGbPjzQca" +
       "E0tOJAxgX/1xgB7/nwlCLMgP68GtPLH1vakrLxpYewKIPjOgziDLH7Tve2rZ" +
       "afKOEE9WBZhnJbn+SU1excKiJoWsXEMxsaeau/2cjAPUoWHr4VlkO8Ci3Kia" +
       "w3cyWJVvaoFTvbLAWA82KxipSkAqp8uS2gHScMrJcJnjBwAT9bBI1PnAedh0" +
       "Cg9v+i9PF3Y0G7z/8mz1LLdlXH7i6sk3NaCCMr6RMkfQuflSLZFT2Xczh3oc" +
       "Ug+dLYdjejJsJ184FHcIZmexSwyy8DJTMgYU2eoAh3coz8yiRMeXhlhYScJt" +
       "JgwhHdAPg0S4VVHhhuRMnMJNg4QJCrvoAnACM6l00aX+Q4ynszvVb7EuaYjD" +
       "R5+8el7txMbzP2wQuFGfg9ZzGdr+4M97e+fVyoK4IRdj/yXozr3l8svJx98S" +
       "E6bkmCDoJtwZ+WbPi+ue4ee3HAEjc2o8YAHA4slPajP2HoPmHQvP67a9+S8j" +
       "q//HBB+mwQ1fSYKvR1YqSRqzzetcIE4pfx4ZffjrGu2H69XmD86740Kh1tl5" +
       "cNKlf+CLrx/cPbx/n8B+VC8jC/PVRLILMZifzi2QY7sO8tGyLxx4982eK0M2" +
       "oIzBxko7flrtxlCI2Nh5VeYQFmVuIOP9biI4X/r1moeurytuhWDTRspTmrIh" +
       "RdtifsAts1L9Hr9xr/4u/NpO8yn8FcHzb3zQWbBDOE1di30NnpW5B0M4x3FG" +
       "ihbAK+cjF0DRr2KzBlBUNilMF0cV+9a5iNl3ChBzJo4h2Q32MbihAGLydgE2" +
       "Z3CmIUgDDFNn4MA0BumxxetQgfR4fAHmAYWEBFeOhNjE+OI7CqhtJzbXMTIB" +
       "bjaQCbAeSU1Ra6UurrVWbnDiua7wkNWVjz9qff/P9zm+Z2T2PgHXmFpIMVZB" +
       "B/csMnLHnGc3j8z5E89JyxUL8hdApRwlJM+cI/teO/xc9Yx7eJ7ET5/toP7a" +
       "W3ZpzVcx4zLVYLNLWOWWjHwoGrd+oJjypZOBT7y00AxvPKFyoO9UsU5bueNK" +
       "pwkwyZRBGw0Wda6VtzV2vuXYegM2W3Dy/ALlZT+PyKa619bf+s7dduTLun/7" +
       "iOm2ndd9Gt6+UyCoKHnOyao6eueIsqcAnczuZhdahc9o/cv+TQ/euelaR7Jl" +
       "DK/MusSCQIn/bk7ngM/pvqDBvxe4We1dz5/7u7033DQkhC6grMC8yf9cofZv" +
       "feMfWbc7nmDn0F9gfm9k361TWy46zOe7tQuc3ZjOrorBsXLnLror+VGoofTX" +
       "IVLWS2pluz7P4aGbsl44OJZTtI+Sat+4v74siqlNmXR+etCAnmWDVRNvnBnF" +
       "fDGF32R3p4sIB5Mf5cFXfA2jMRVNUvm8LQCzKtUSbIATf8/2Evy5g5FiReSR" +
       "txrpIKhmUk83I29RdY1iZuiMiYqfooczXwtgMNtdeAQR++eLedJpvp0CeP3L" +
       "AmO/wuZRkFbGfQkxCpA/kS/CpYlhGKSA6/Ng+o1TEEyn4Rheqx6yMfWhEwmm" +
       "+Lodm2/liKD5OH6mCHqogBpfwOZZRiYFImg3fh2CTASHv+uq7benSm1nw3PQ" +
       "FvLgSVNbPo6fSW1vFFDbW9j8kZHJAbUtT9EuhLmg3l45BXqbgmON8LxtS/n2" +
       "SdNbPo6fSW9HCujtb9i8x0ilrbdM/fg2gWTY/uR4Z/fwyVBmmpEZBb+DYAFv" +
       "ctanWPH5UL5npKZ80sgVL4r8zPnEVwUX0XhKVb2473kvNUwaV7iMVSIKGPzn" +
       "Ezh+eeoHAPfihYtxTNDDraI2SA+4yX89dEWQn1e4dMBKvHhJSiBoAAm+lhpO" +
       "HLg4XzGjGbIqU5IZ6o3fUDK5iE9z6aLsSiY33ITjGc5TupzjyzP4l3MnwUt1" +
       "2nfU/SOXdVx19PO3i68EsioNDyOXSkiDxQeLTOVudl5uDq/S5fOPjbl39Fwn" +
       "iRorNuweoWkeN24GrzTQQaYGSuhWY6aS/tKeCx75zbbS5yB9WUWKJAi9q7Lz" +
       "irSRMsmMVdHs6yvkFby23zT/OxsvOj3+wcu8SEyy8rUgfZ98aO+Vz++YvKc+" +
       "RCrbSAnkhzTNE55LN2pdVB40e0m1Yi1NwxaBC8R53914DPqyhKU6rhdbndWZ" +
       "XvzGxEhDdhqb/WWuQtWHqLlET2kxZAOXl0q3x7mv+IqfKcMITHB7PDeaqwVW" +
       "oDXAffui7Ybh3MVLbjP4+d6cG0PQz6fwV3yb+h+DvvFHVSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16Cczsxn3fvifpSXo63pN8yYolWdJTEpvJx+WxVxTH5pJ7" +
       "cUkul9zlHokj8yaX5/LY5dJVrRhIbDSA46Ry4qKxggB22gSynQQNmsuJkqJx" +
       "AqcB5AZNU6CW29RoUsWoXcBuUbdNh9zvfochqO4HcJbfzH/+87/mN3/OzItf" +
       "rdwRRxUoDNyd6QbJgZ4lByu3dpDsQj0+oJkaL0exrpGuHMcTUPeM+sSvXvnm" +
       "tz5qXb1YubSsvEH2/SCREzvwY0GPA3eja0zlykltx9W9OKlcZVbyRobTxHZh" +
       "xo6Tp5nKPae6JpVrzJEIMBABBiLApQgwcUIFOt2n+6lHFj1kP4nXlb9fucBU" +
       "LoVqIV5Sefwsk1COZO+QDV9qADjcVfwvAaXKzllUefux7nudr1P4YxD8/M/9" +
       "6NVfv61yZVm5YvtiIY4KhEjAIMvKvZ7uKXoUE5qma8vKA76ua6Ie2bJr56Xc" +
       "y8qDsW36cpJG+rGRiso01KNyzBPL3asWukWpmgTRsXqGrbva0X93GK5sAl3f" +
       "fKLrXsNuUQ8UvGwDwSJDVvWjLrc7tq8llcfO9zjW8doQEICud3p6YgXHQ93u" +
       "y6Ci8uDed67sm7CYRLZvAtI7ghSMklQevinTwtahrDqyqT+TVB46T8fvmwDV" +
       "3aUhii5J5U3nyUpOwEsPn/PSKf98lfvBj7zf7/sXS5k1XXUL+e8CnR4910nQ" +
       "DT3SfVXfd7z3nczPym/+3IcvViqA+E3niPc0//zvff093/foS3+8p/muG9CM" +
       "lJWuJs+on1Tuf/lt5DtatxVi3BUGsV04/4zmZfjzhy1PZyGYeW8+5lg0Hhw1" +
       "viT80eK5X9FfvVi5PKhcUgM39UAcPaAGXmi7etTTfT2SE10bVO7WfY0s2weV" +
       "O8E7Y/v6vnZkGLGeDCq3u2XVpaD8H5jIACwKE90J3m3fCI7eQzmxyvcsrFQq" +
       "d4Knci94vqey/yt/k4oFW4Gnw7Iq+7YfwHwUFPrHsO4nCrCtBSsg6h04DtII" +
       "hCAcRCYsgziw9MMGJbI1U4dFqdfVgeBBxMogqLICKACLdtl6UERc+P9xrKzQ" +
       "++r2wgXgkredBwQXzKV+4Gp69Iz6fNrufP0zz3zh4vEEObRYUqmB4Q/2wx+U" +
       "wx/shz+45fCVCxfKUd9YiLEPAuBCB4ABgMl73yG+l37fh5+4DURfuL0d2L8g" +
       "hW+O1uQJfAxKkFRBDFde+vj2x6QPVC9WLp6F3UJ0UHW56M4XYHkMitfOT7cb" +
       "8b3yob/+5md/9tngZOKdwfFDPLi+ZzGfnzhv5ChQdQ0g5An7d75d/o1nPvfs" +
       "tYuV2wFIAGBMZBDIAHMePT/GmXn99BFGFrrcARQ2gsiT3aLpCNguJ1YUbE9q" +
       "Su/fX74/AGx8TxHo3wue7z+M/PK3aH1DWJRv3EdL4bRzWpQY/C4x/MS//bO/" +
       "wUpzH8H1lVMLoKgnT5+CiILZlRIMHjiJgUmk64Du33+c/4cf++qHfrgMAEDx" +
       "5I0GvFaUJIAG4EJg5h//4/VfvvKlT/75xZOgScAamSqurWbHShb1lcu3UBKM" +
       "9t0n8oDwdcHUK6Lm2tT3As02bFlx9SJK/9eVp5Df+NuPXN3HgQtqjsLo+749" +
       "g5P6t7Yrz33hR//7oyWbC2qxxJ3Y7IRsj5tvOOFMRJG8K+TIfuyLj/yjz8uf" +
       "AAgMUC+2c70Eskppg0rpNLjU/51leXCuDSmKx+LTwX92fp1KRZ5RP/rnX7tP" +
       "+trvfb2U9mwuc9rXrBw+vQ+vonh7Bti/5fxM78uxBejwl7gfueq+9C3AcQk4" +
       "qgDR4lEEUCc7ExmH1Hfc+e/+4F+8+X0v31a52K1cdgNZ68rlJKvcDaJbjy0A" +
       "WFn47vfsnbu9CxRXS1Ur1ym/D4qHyv9uAwK+4+b40i1SkZMp+tD/HLnKB//j" +
       "/7jOCCWy3GAFPtd/Cb/48w+TP/Rq2f9kihe9H82uR2KQtp30RX/F+8bFJy79" +
       "y4uVO5eVq+phTijJblpMnCXIg+KjRBHkjWfaz+Y0+wX86WMIe9t5eDk17Hlw" +
       "OVkBwHtBXbxfPo0nfwf+LoDn/xRPYe6iYr+SPkgeLudvP17PwzC7AGbrHehB" +
       "46Ba9H93yeXxsrxWFN+zd1Px+r1gWsdlMgp6GLYvu+XA70lAiLnqtSPuEkhO" +
       "gU+urdxGyeZNIB0vw6nQ/mCf0e0BrSjRksU+JGo3DZ8f2FOVK9f9J8yYACSH" +
       "P/mfPvqnP/XkK8CndOWOTWFv4MpTI3JpkS//xIsfe+Se57/8kyVKAYiSnnvq" +
       "1ecKrsytNC6KTlF0j1R9uFBVLBMARo4TtgQWXSu1vWUo85HtAfzdHCaD8LMP" +
       "vuL8/F9/ep/onY/bc8T6h5//B3938JHnL55Kr5+8LsM93WefYpdC33do4ajy" +
       "+K1GKXt0//Nnn/2df/rsh/ZSPXg2WeyAb6FP/5v//acHH//yn9wgH7ndDV6H" +
       "Y5MH3tjH4wFx9McgSxIjJERwoFTs8E2bsDbdZnscEqS+hmyphzStqWnqFi+2" +
       "OS4cs7TXaDgYiSWY20JypxrHprNtTFepK7q9bJD5SuDazCLEZGSzthNjms1W" +
       "cYBIURTkNbBeh2R/hvooF8E8amCNlIWctix7EwRTmzUY9nkog30IhneNBoaI" +
       "i9BzwKoS59RCRohgg0i2v+wGVWRND91oKkKbyPHw1KVaerOKdSGbnqDOqkM5" +
       "yTQVsyXABVOOsYimOrPcG05oZLQ2ucEiHznIejrnxotgnbaWA9pOZjOuK3Ql" +
       "127019ygSo6W0wk9W8TZFHJHbJI4bI92BGuJdKAObudq3wptO3R8aRVUYwid" +
       "8jpuue3dWmy4sTRQ5qLGkVZ36mTCAOl3Fw4SOrttVetLq3EiLb3hcqnTaB3t" +
       "Ku2l1u/OxDBIGcPDUX5OtYRdd7GbcB3En1O7yEbW9ZFjraYSs2rZNUnWGHk8" +
       "xL1M6op1seuFVH/NtNdtQRxt1+QoEbezRlRfysPEs1Wst9jW/anT71IrNkfZ" +
       "vONMq5GsUFHND7rUSOHcWo1ro66zlBez6Uxk9JQid01ogSSGKjm1UJ+uuQBT" +
       "TK03UdoLuqtPSYtrufxEDhpdebibr7g5gXLYVCIFqacskvlMDckpYg8nJBxk" +
       "Sjxp+9NaL62n5qBhepknenLdEzqb3MKG8LrpRE5AO/2ZPayn47g9b4xVYtie" +
       "LL3Mnm9H2Ga45mfDrsc5S7/dE2Klt8M7RBgu3KGwGbPVlKvak2DQn4PRBVqs" +
       "ivWtMau2aXJWH5EEbXOTZk5350Iqbrq1YZVqVHdEWwszk1wnXbUzsbvO2G2z" +
       "MU5H1BhZkDPe0BqbtEc1JC3cMVNxuGCb2XCd4nB1vZDawDCd+QoZClsqnnTW" +
       "5lzw6iJNoU2mM2Y6nS3TMVPZn+dufaf7SLuGTzmO21WHeTCvai5iG5u60ALh" +
       "EzEwP2JUYeNaHh7K/Z1R43dTTQtWk5lDdXpL27LZkRVibQJBeQPzmbkhbO2u" +
       "WHUkeikhHN0cjrI4xKtdeibv6lZvsvCFWTteThRpQWatzQCdb/vutDr0w3k2" +
       "YmfLGeK47Loh+nOIr5sBZWdjQZhvI8/KsLmD0ZRCYC22N5DHbN8ddPN8a8Mb" +
       "czPYjgRigtCD2iCWF2tPyEOur8+wQUDgsEwp5tSEdR6r28OZP+lTbbuHewOL" +
       "wbdjEmnDIUcvZdPR6/pSrk65dV1pCANcEtYWIZkxLnNWi1qt4IY166VTnUOE" +
       "aZuUl31z3OmqDVF1UW6qcDwWunK8mQT8HOFJ1KAIlI5WdL8b97MF04a9HW50" +
       "m2mP3NVG9iBqrHVu11OJwRafBwRRpVbrja9JSB3V3IRi57bBTsbD1gByKKUe" +
       "IKOBbZl8bhgMlKaRhcqQ3pLswWqwFkeO6w2nfnfAcTFtklCNn6OkDK8tbOVa" +
       "AbL0I7LdVBvTpRBQCBvMeW+b1ozA5JSe4RgdnXJq4y3EKjuhJapp3ehzJqJ1" +
       "ML624ih6JPJdxnLIBaFO0lbHYGFT77HjwZzJIsVH/QWMYQ2B1hp9soutVZt2" +
       "kA4qBSQfdqcU0moG9LK6QVoU2lrXeoFBSasRTVkNguaR7URqTrmJs6Wi4dTE" +
       "yQyb5kPZwYF5cNNEF1BIKdsMQZl+06DQmmDPjFyFSXUhtGZwkK46WySmt05f" +
       "yJuMyPapLJhrWdoweHiTolKuTQIxbMrjHrYcI7pEcJ4mZXA7itIUGTrI0NRR" +
       "aV5raBvQQZa0zDdn9Cgyp0oMpiZHsBMzXMOtVOy5CKBSIcsZbXyKpetrC9oF" +
       "mNADUOZ3x7OOxUkjFVYpuop3kw65kZWMJODWFA+iaYQMmjManuYUFsFRK40y" +
       "CQo6Qx6vyn6/BrXRvOWSmr9r0WsYwVhUmNC9paT5TOgRkN9Ja6gycSnF5hNm" +
       "zlPGyrV1BxOIKjE0k+XS2jVISW3jY0WZ9OZwNdd9i12MMl1Jl8ocAhNyV2Nb" +
       "LdWf9/NQxOa848hcM4EBvqCbSIvdoJPWu/nMDRdUMyQ7DYaexUSdxWtVpleX" +
       "VsiWolYo4ajLMWfJizE9Dn1UX0ijuctjVhdvcfN+uvUGgiwuZmBV6c5soblj" +
       "rXXTQwLKZLohDtGM1e/1d+teWJOHIjPq5SOXarPYSFE8X1x08+U2h5TWiGVa" +
       "Qb25izC2Q+08XfBHW3RpZQmMz1FnS/gRACSjTVP8jhad5lZb55quDRR2nixx" +
       "dxrEuAHRGjn3NxgJt+p0lEctWdtltCJMKGM0HTmmNEEiNx2KG3c1zjcsBuTX" +
       "ewq/yseq3KkmI5rIzDmMZGa7Aftbl2RYk683ewnP9JGN7ERMFi707XDAr0Zm" +
       "blNMvzHZ6Gi0lI3hqNNpzdpLy6cVHxKniJ6pQ5sOZvG8w2axrMspjKorgp8G" +
       "s36ES64zapI2NrTlLabuZrS0kYPuZKMwxIxoosPMDkWHWIfNVETNvqiyEa3S" +
       "/qq9JSYtpT1AeJ/QNatKmq0NZLf4Lrao9ho53PRyhGE0d95v2PXYwTiZJNmo" +
       "LrCOMU4NV2SW3Qk6V8GSFqhTE9KYhbbSV3RMI02821cHS0/PxO1u16ToCWsu" +
       "pqgeEBamBnlzZwusPrdcayGqdEKbW6uvEbxZFXFJ6ltWKrA+S3MmPqbJaBMQ" +
       "PkGydbdalefQGN/5cb6RlEYnlRcrSqhBTd1tJBmr5Dy6HafdnmG2lnlPiyCc" +
       "bTV0yJB2wRAfCNoK3s2DPMLcZryhs1ZT7NQVxyOpgE62S2im8DaU6riuY32i" +
       "s1LRoLkg+gQeu7y84tF+wHv98YavN+QWJDZXaxjut9uQtx0jhrgYbgRksRaF" +
       "dZ7riTro4KGR4UvDWEW9FO3XW3OPatYbeHVoIYlbU7mha0AkE2Wwyisg82u2" +
       "IYlsrkiYlwRmwLBL28htdLxoxKNm0tsxWYa3mqg+rLJoMMjbmRM0DDdKMpcc" +
       "oJxVk/TFuOtJ6WDEtxR7gM/hCPECPY12SWrNqIkQhxMvGliClthGTCQxwrT6" +
       "USuLYDyFuXDU3PnNrtrPFSwfz5Q2Neogmo1VOT+c1dpVFs+wbs+2FGIIqatu" +
       "lRIidJi33faUs122W1UlqCXXbM7FSKud0wFuoWMMZRXbInrMTjM76BIjvcHU" +
       "pKgu5+MsUW2nXpbpydg0BNwg+h6xmHXaXX1kcasONBo0yLWV0LkyZyeDtrKS" +
       "x6RC6GAOCHJ9mkaRNFN8yk7lxtbhZtIqb60NA+ZbuQct0QnKm/251w0HrLRs" +
       "t2E1Zn2m7/dUbNXMa51mi95lU6ZpaUQobF2ahdQBnOgjOFNbi6yh043OpAYn" +
       "Ad+QZ9gyzCU1w3NGWjAcMxvNZqv+NuhFGhTQq124HLUnjV21SmQbftjdBaPW" +
       "NJ7WlFTnhuHW2e6WQru3rc40uS4luYRu0vlCN1l0hlE7mGDc5QTid0O5jrQU" +
       "A4obmpZOmNSHG/bIQ31Na/WSOjTdkcGw7492clDXU30Qr1XCV/N0aWmypbYC" +
       "WN1AkzEMmlxZaNAuNYTZNBbJ8cCHFafhmywcbtZUe5Pp+ExHtLwGN9JGFcOo" +
       "sWORdTNiyebOaKmBsdwYOmvMFLXhe5Rf7bZMw2s5WB2ZzHZ4PR/pjWScqthy" +
       "NYqCqB3PGZ8BL5DUCwJjMh9IzExEQzfNGzwu95TYxfERvZwkA0iUEwjfNPDY" +
       "XrucNxcgPSEJ35tRksBt/LbfNaheF0MFLATfZ+0aa9TU7twg0BUrSNx04zWZ" +
       "MZkPk6moDIiJ0YTRzmZXM2tdW9BFIcmicDC0vKnTxAZoS9AWiL1MbdZerI0g" +
       "UPP5NjFZLtF0YixAkM7oGh1uwioJ8jaG8EbwNl0KThckLWMnI0MCdkSYBCm2" +
       "1RuKRB3mTChAJp3OzscFS19n9R2wkNXZeh7EBJqHwq49pGqjft0j++vAbIfG" +
       "drRcCvaiO/BMzLBQckKI/Q2UrhuK7ose4m8xftzdMKYocQof1A1xhmy6XUqZ" +
       "tVZNZ9mnCWWaTFqd1GIAAxevtedrxfRGXJPJEhH2UfB1ddiv1SfTVaK07GZW" +
       "td1I0VjYMFFzNlnAqYAvYWO7k9qeF3aWbQWiFkR3oyayP+P7tSlT88PhslmN" +
       "TYnBo2bO+x1pO51X59ZQUlC8gTkbbrqVpYbNSuJg2ONzv5NbkK4HfYI3bGuR" +
       "ZBOOoiJ5gIoEhO/mzZbWmY19RMc1tj3c9C1atNsgAfUg1wpHfcbE53lv1VMG" +
       "62ltsKwHmDGlhjW708rrMhOL9gLDBpNVT61N0jBf7XIedzHW304TBPWNKSyO" +
       "5iDNQlr8CLPrzU5sBxy1G81Fx6aysc5MRlKqubWUWsNizRjxK8XFWt2tbwtB" +
       "xKVbPZg5OofivSifjMfyoicCRFzUZRFOhjqZNWq5ooi1XbsFvgKHNGG31g0m" +
       "tyNRYGOPlbR+XN9tQIjsUCyfwODLYzNaYdBWTcHiAda1aGoay1ZTHkFSDkGL" +
       "zVCFBDJSRMJ3rBx8ytZqDIeGmtTGq3rVQxY2wm0zuU02hRrWQnCKX++s4bQe" +
       "WZria7PlfJP3so5FadZagWezdJzMwEeu2wFf99mSADlSdY1lDW8DDdbGUGUH" +
       "k367wVO6vN5Ks4CaE4aR2o2FYmGsxCgrHoe0utqr8uO8bmwlbKdAFkRtNt2+" +
       "JLIEQbzrXcX2yHtf2w7VA+Vm3PFZ68ptFA3917Azs296vCieOt7AL/8unT+f" +
       "O72Bf7KrWyl2mx652RFqudP0yQ8+/4I2+hRy8XA3fJ5U7k6C8PtdfaO7p1hd" +
       "ApzeefNdNbY8QT7Zpf38B//Lw5Mfst73Gs6eHjsn53mWv8y++Ce971Z/5mLl" +
       "tuM92+vOts92evrsTu3lSE/SyJ+c2a995NiyDxYWexQ86KFl0Ruf/9wwCi6U" +
       "UbD3/S0OG+JbtKVF4SeVe009YQJVdrlD0fsn4RJ8u42800zLCud6/fqH+vX/" +
       "3+h3Z0lw59Em81M3Ow/dH3weXqA4on5DQQ0y8QMt8A4OT0iLpg8eETx+HTtz" +
       "kxz0Ijm0bDXmAk0/oqxeR1mEqbxNDmxPBuNHuq/pUXH4dNC13USPjjq+tdyk" +
       "LghNHUgh6MUKYLo6Sp3ZrD0b9IK8LWfSM+pvjb/88ifyz76434tV5FhPKtDN" +
       "7rVcf7WmOBZ96hZHuyc3Hr7R+4GX/uavpPcezdV7jl37WOHJJ8DDHbqWO+/a" +
       "I13vOzlRYuWy7adKXh+4RWD+TFHkIDDVSJcTfW+8ou4nTgLz/a8jMEvpcfD8" +
       "9KH0P/0aAvMiAKwwChLgNF0rUfiGQXpxT1yGVlE8V1J94hZa/0JR/FxSeZMa" +
       "+Bs92h8hxZNgf5gf39Jp5dnk3mkv/NKTf/aBF578D+Xx3l12LMkREZk3uNpy" +
       "qs/XXnzl1S/e98hnyiPwMqJKvDp/J+j6Kz9nbvKUWtx7bOXiTkf5Eh1aObph" +
       "jPzicYeHK4e+OXcTZPY6b2eAbh5c3osgwFu5LBxd/PhOsd6rJp5acGfF2Zkb" +
       "yMmx7y8cXrQ4Pg75pexCpbTMp28SeccL//Gaf8nVfTOxbjTabfYe2D4VZueD" +
       "8hgLTw7LSDfw9QKqjtr290Ts4OD4jhlozG4ovLMXvhzsVAbx7Zamz92i7feL" +
       "4reBydRCrr0atyD/w6wShmHlBB0+/jrQ4buKymIp/t3DMPzd14IOxes/fq2w" +
       "8IVb6PaviuKPkspbzsGCWFz0A+hYNP/yieaff72aY+B5+VDzl7/jmv/FLTT/" +
       "y6L4YlJ56Jzm/VQXivTuvOr/+nWo/tai");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8hp4vnKo+le+46r/1S1U/0pRfCmp3HOo+lEK+Wsn2r7yWrTNksojt7weVtx1" +
       "eei6G6r7W5XqZ164ctdbXpj+xX55OLr5eDdTuctIXff01YRT75fCSDfsUpu7" +
       "9xcVwvLnb0Eo3yRjA3i2fynlf3VP/1+TytXz9AAYyt/TdP8tqVw+oQOs9i+n" +
       "Sb4BUBGQFK/fDI+A7t03Sx8JJU4iWU0Ku5UZyPGx+RnLZRfOfgAdO+jBb+eg" +
       "U99MT55Z2ssLxUdfJSl/mPZ99gWae//X65/a3/dSXTnPCy53gVV4f/Xs+Mvm" +
       "8ZtyO+J1qf+Ob93/q3c/dZTZ3b8X+CTGT8n22I0vV3W8MCmvQ+W/+ZZ/9oP/" +
       "5IUvlTcs/i+x5WpF6S0AAA==");
}
