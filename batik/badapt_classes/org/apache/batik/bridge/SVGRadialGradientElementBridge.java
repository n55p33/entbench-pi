package org.apache.batik.bridge;
public class SVGRadialGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGRadialGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RADIAL_GRADIENT_TAG;
    }
    protected java.awt.Paint buildGradient(org.w3c.dom.Element paintElement,
                                           org.w3c.dom.Element paintedElement,
                                           org.apache.batik.gvt.GraphicsNode paintedNode,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                                           java.awt.geom.AffineTransform transform,
                                           java.awt.Color[] colors,
                                           float[] offsets,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String cxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CX_ATTRIBUTE,
            ctx);
        if (cxStr.
              length(
                ) ==
              0) {
            cxStr =
              SVG_RADIAL_GRADIENT_CX_DEFAULT_VALUE;
        }
        java.lang.String cyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CY_ATTRIBUTE,
            ctx);
        if (cyStr.
              length(
                ) ==
              0) {
            cyStr =
              SVG_RADIAL_GRADIENT_CY_DEFAULT_VALUE;
        }
        java.lang.String rStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_R_ATTRIBUTE,
            ctx);
        if (rStr.
              length(
                ) ==
              0) {
            rStr =
              SVG_RADIAL_GRADIENT_R_DEFAULT_VALUE;
        }
        java.lang.String fxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FX_ATTRIBUTE,
            ctx);
        if (fxStr.
              length(
                ) ==
              0) {
            fxStr =
              cxStr;
        }
        java.lang.String fyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FY_ATTRIBUTE,
            ctx);
        if (fyStr.
              length(
                ) ==
              0) {
            fyStr =
              cyStr;
        }
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  paintElement,
                  SVG_GRADIENT_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        org.apache.batik.dom.svg.SVGContext bridge =
          org.apache.batik.bridge.BridgeContext.
          getSVGContext(
            paintedElement);
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX &&
              bridge instanceof org.apache.batik.bridge.AbstractGraphicsNodeBridge) {
            java.awt.geom.Rectangle2D bbox =
              ((org.apache.batik.bridge.AbstractGraphicsNodeBridge)
                 bridge).
              getBBox(
                );
            if (bbox !=
                  null &&
                  bbox.
                  getWidth(
                    ) ==
                  0 ||
                  bbox.
                  getHeight(
                    ) ==
                  0) {
                return null;
            }
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            transform =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  transform,
                  paintedNode);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintElement);
        float r =
          org.apache.batik.bridge.SVGUtilities.
          convertLength(
            rStr,
            SVG_R_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (r ==
              0) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            java.awt.geom.Point2D c =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                cxStr,
                SVG_CX_ATTRIBUTE,
                cyStr,
                SVG_CY_ATTRIBUTE,
                coordSystemType,
                uctx);
            java.awt.geom.Point2D f =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                fxStr,
                SVG_FX_ATTRIBUTE,
                fyStr,
                SVG_FY_ATTRIBUTE,
                coordSystemType,
                uctx);
            return new org.apache.batik.ext.awt.RadialGradientPaint(
              c,
              r,
              f,
              offsets,
              colors,
              spreadMethod,
              org.apache.batik.ext.awt.RadialGradientPaint.
                SRGB,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vQxPxuaUvL/xT00wCXr9zcfBJB2l6hReYx24bs9Mcv0dZ4hqot2f+/uhtL33" +
       "5X8+G97766eLJJc6phunqXSSqp41Q7ikLxcM8RLOxaPXm3f/7ofd6TWfJA1g" +
       "X+dxgB5/LwYhVpaG9eBWnrzu3YUbV49v+QSIvjigziDLu4cOPb32JHl3iNer" +
       "AswL6lz/pB6vYmFRk0JhrqGY2NPE3X5Z3gHa0bCd8KyyHWBVcVQt4jt5rCo1" +
       "tUxUbywzNorNekYa01DN6bKkDoM0nHIBnOd4AGCtHha1Oh84D5uY8PCe/zK6" +
       "sKPX4P2X5mVsxrET4RmwZRwoox7ersTmNAfg6wxTZxClNBnA+CZ4+m2e/eX1" +
       "VseZ1TkamI1F2NRZcjipZ8J2nYVDKYdgaUGVlp5kYajMjHFFtobBtx3K1QWU" +
       "6OPSFAsPZVWmGCp16rkYJHnW3Tctq1R4Gwazw+bCT8pGV3VzBOipl0sHtyzO" +
       "SlOQrDeVgrpioylpFpYK/ssKDPCRbMJiPMuIk8zlDU/8xLr99w8I7OkqQhw4" +
       "Ht11sFZ+LfPEW2LCCUUmCLq5d0VuHH1l67M8rGsRR/LB5MEQwBtP2dKat3at" +
       "Y+0v2Nbm34xMfDqVfy9s0wTUgwq87EHjs1wO88Ty0rDpsdnMncueu3pm2W94" +
       "cq1VLABi0GOR47BnzgeH3nzvaFPHfRzwq9Actin89wiF1wS+0z+3Ugs2LOd4" +
       "YHPeA7mH5gOwIn8sWeRLRfwizMXqe14496WD37hlSvjTitIKCMxb8Pf1auK6" +
       "3/6toGbhaaPIMT8wfyxyaN/CvtXv8fluRY6zu3OFhz3QsTv3zHsyfwl11fws" +
       "RGaNkVbZvngaldQs1rljoEXLuY2KkibfuP/iRNwS9OST1KJgkvIsGzwLeNNV" +
       "FfMlqjZhoQrCkfGrxXE2hK9hBkwVTVJtoP0YPhXw/AsfDDnsEKHX3mdfMyzJ" +
       "3zMYECI1KtXSbNwqa7uYqWTgfDBpY0hke/ubE/vevlfYPGioADHdueeGj8O7" +
       "9ojiR1xaLSu4N/LOERdXAlGw2YGhtbTcKnzGwB8Ob//xXdt3hOyMupaRSkVk" +
       "iWnDTX0hu8RyEoubWvtUXaN4DnDGxNFd0cP5mz8YzBVECE+ewmR8MU/ZwLdf" +
       "JuvfVmZsHza3goFl3JcQowz5t0sld08d4Mb0HD/wC1NdfH3Lwze1Vw4AyAyS" +
       "2qymXJmlg0m/q86ysglPJnCv+Vz3tY2GrsdIxUqnIjfy2WEhbm8xPCfb2eFk" +
       "4aJf/B/hGqZlIhzFeuGNw4mTCf5frIVoU9jcmbOKZ+BAQJwZ2yLv7I695fip" +
       "afs4ft3ged+FsQ2HKRY0H/68vbgbbhcbsZHju+WQA5uv8w3swOZ6bG7E5u7C" +
       "YMGfu7HZU8b77+TM7sZmbxk/fajM2I+w+T42+8VOytA+/J/7u0dhENXLS93n" +
       "iWRu/wXA16Bl1v8pNpsZaUpkFTXp1AWFWZVXf269Hv806vUcI53lbx/x2Lyg" +
       "4D8QcW8v3zfTUjt/5rJXRDHh3K03Qp2XyqqqNy953msMk6YULnqjyFIG/3qW" +
       "kfklNArZRbxwOZ4R9L+A40yQHjydf3vpjjJS79IBK/HiJXkJEB5I8PVlw9H8" +
       "eaXMe7wqLldReHHATTb3eCbz3BQs8yVR/l+VAwdZ8W9VXD48c8nwVcfOuUNc" +
       "ysmqtG0bcmkAcBX3g/mD8tKS3BxeNetWfNR8f91yB0zaxIaxne3bG3cciAUD" +
       "PWNh4MbK6s5fXL164IJHf76z5iik602kQoIEuamw4MkZWZN0bIoWJhEoePhV" +
       "Ws+K26ZXn5r602v8TqawkAzSx+UXD17xwu4FBzpDpGGQVEM+pzleiV08rW2g" +
       "8qQ5RpoUqz8HWwQu4Pa+DNWMTizhyZjrxVZnU74Xr3QZ6SosOwovwutVfYqa" +
       "a/SslrRzXIPb4/sTzQ6M+qxhBCa4PZ66+zsC20Wqq4xHhwzDqc6qHzN4ZN9e" +
       "HLmwfYe/YvPuvwEL8t+axx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
