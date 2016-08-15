package org.apache.batik.bridge.svg12;
public class SVG12BridgeExtension extends org.apache.batik.bridge.SVGBridgeExtension {
    public float getPriority() { return 0.0F; }
    public java.util.Iterator getImplementedExtensions() { return java.util.Collections.
                                                                    EMPTY_LIST.
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() { return "The Apache Batik Team.";
    }
    public java.lang.String getContactAddress() { return "batik-dev@xmlgraphics.apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "The required SVG 1.2 tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        super.
          registerTags(
            ctx);
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGMultiImageElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVGSolidColorElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLShadowTreeElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.bridge.svg12.XBLContentElementBridge(
              ));
        ctx.
          setDefaultBridge(
            new org.apache.batik.bridge.svg12.BindableElementBridge(
              ));
        ctx.
          putReservedNamespaceURI(
            null);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI);
        ctx.
          putReservedNamespaceURI(
            org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI);
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        java.lang.String ns =
          e.
          getNamespaceURI(
            );
        if (org.apache.batik.util.XBLConstants.
              XBL_NAMESPACE_URI.
              equals(
                ns)) {
            return true;
        }
        if (!org.apache.batik.util.SVGConstants.
               SVG_NAMESPACE_URI.
              equals(
                ns)) {
            return false;
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        if (ln.
              equals(
                org.apache.batik.util.SVGConstants.
                  SVG_SCRIPT_TAG) ||
              ln.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_HANDLER_TAG) ||
              ln.
              startsWith(
                "animate") ||
              ln.
              equals(
                "set")) {
            return true;
        }
        return false;
    }
    public SVG12BridgeExtension() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "P15g7AlsjsKBD/DY0hUJgHBsvECYB0+PI0nP2EHIx1pA0B8VGHsOmx9wUgMg" +
       "rGW2Yqmme9L2gfHMOIBRhWNheKKORNGxg5GPNSCwW/g4oWBRvpswef3lXJqL" +
       "5V8qAN0r2JzmpNpiCTi1QR1EE9KXtmETkkBQTkoHDTXmgfmzcQBzMo5huNnt" +
       "ILJ77GDmYy0M5mQEc+gGJRQzkqE2WeqIxX5TALrz2PwKgrJqrx2G8lJVHE5B" +
       "3euDLwBledQwNEb1q6W7s/8LjNOcTBntWhTP8DNy/pCRfyIoTx2prZh+ZMtb" +
       "4uCaueivhgNJPKVpvlLaX1aXmRaLqwKaannvYYqvP3Iyp+C1LdT44luI8AfJ" +
       "9CEn0/MwQbCTL376j0APQXqYV3z76T7hpNKjg6nki5/kr5yUAAm+XjZdC1ma" +
       "TwLANoBsuij3skPoc+rV9Om7y1iYVWeJ/9fcejjV6ZRzp47csfHeSzcfkzeP" +
       "ikZHRnCWKjjhyPvNzFF+ft7Z3LnKNiy5UvP0xEVuxZZ18+nfm7AqMFZxSzgz" +
       "cBVnN2Vu5M4fXXX6F3vL3oRacyspAqufvNX375b8K6c5babgELE1knuS66GW" +
       "uCNsXvLd4dXL45+8Le6RiDz5zc5P36ecO77t1wdmHG0sJlXtZAKcKVm6l1QK" +
       "H+1iyqDVSyapdlsag53OVaplHRNr0NYpVlYCFwfOSZlevJLmZEHu0Tf3Ir9S" +
       "M4aYtcZI6TGcBg6aVV6Pe6WTdRuSMs0Ag9fjO+0zGU1QG2CpfZEO03Tvc0tP" +
       "msLt46OHFmiLysQrvpX/G2d+eYR7HwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6Vs/+doPP/WVfBv2fwGs3Jdx4CkAAA==");
}
