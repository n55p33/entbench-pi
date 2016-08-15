package org.apache.batik.bridge;
public class SVGColorProfileElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public org.apache.batik.ext.awt.color.NamedProfileCache cache = new org.apache.batik.ext.awt.color.NamedProfileCache(
      );
    public java.lang.String getLocalName() { return SVG_COLOR_PROFILE_TAG;
    }
    public org.apache.batik.ext.awt.color.ICCColorSpaceExt createICCColorSpaceExt(org.apache.batik.bridge.BridgeContext ctx,
                                                                                  org.w3c.dom.Element paintedElement,
                                                                                  java.lang.String iccProfileName) {
        org.apache.batik.ext.awt.color.ICCColorSpaceExt cs =
          cache.
          request(
            iccProfileName.
              toLowerCase(
                ));
        if (cs !=
              null) {
            return cs;
        }
        org.w3c.dom.Document doc =
          paintedElement.
          getOwnerDocument(
            );
        org.w3c.dom.NodeList list =
          doc.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_COLOR_PROFILE_TAG);
        int n =
          list.
          getLength(
            );
        org.w3c.dom.Element profile =
          null;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.w3c.dom.Node node =
              list.
              item(
                i);
            if (node.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element profileNode =
                  (org.w3c.dom.Element)
                    node;
                java.lang.String nameAttr =
                  profileNode.
                  getAttributeNS(
                    null,
                    SVG_NAME_ATTRIBUTE);
                if (iccProfileName.
                      equalsIgnoreCase(
                        nameAttr)) {
                    profile =
                      profileNode;
                }
            }
        }
        if (profile ==
              null)
            return null;
        java.lang.String href =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            profile);
        java.awt.color.ICC_Profile p =
          null;
        if (href !=
              null) {
            java.lang.String baseURI =
              ((org.apache.batik.dom.AbstractNode)
                 profile).
              getBaseURI(
                );
            org.apache.batik.util.ParsedURL pDocURL =
              null;
            if (baseURI !=
                  null) {
                pDocURL =
                  new org.apache.batik.util.ParsedURL(
                    baseURI);
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              pDocURL,
              href);
            if (!purl.
                  complete(
                    ))
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ERR_URI_MALFORMED,
                  new java.lang.Object[] { href });
            try {
                ctx.
                  getUserAgent(
                    ).
                  checkLoadExternalResource(
                    purl,
                    pDocURL);
                p =
                  java.awt.color.ICC_Profile.
                    getInstance(
                      purl.
                        openStream(
                          ));
            }
            catch (java.io.IOException ioEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  ioEx,
                  ERR_URI_IO,
                  new java.lang.Object[] { href });
            }
            catch (java.lang.SecurityException secEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintedElement,
                  secEx,
                  ERR_URI_UNSECURE,
                  new java.lang.Object[] { href });
            }
        }
        if (p ==
              null) {
            return null;
        }
        int intent =
          convertIntent(
            profile,
            ctx);
        cs =
          new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
            p,
            intent);
        cache.
          put(
            iccProfileName.
              toLowerCase(
                ),
            cs);
        return cs;
    }
    private static int convertIntent(org.w3c.dom.Element profile,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String intent =
          profile.
          getAttributeNS(
            null,
            SVG_RENDERING_INTENT_ATTRIBUTE);
        if (intent.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_PERCEPTUAL_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     PERCEPTUAL;
        }
        if (SVG_AUTO_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     AUTO;
        }
        if (SVG_RELATIVE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     RELATIVE_COLORIMETRIC;
        }
        if (SVG_ABSOLUTE_COLORIMETRIC_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     ABSOLUTE_COLORIMETRIC;
        }
        if (SVG_SATURATION_VALUE.
              equals(
                intent)) {
            return org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                     SATURATION;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          profile,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_RENDERING_INTENT_ATTRIBUTE,
          intent });
    }
    public SVGColorProfileElementBridge() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qrOasi9L+pN+WK2ysgmPSt03JxdkbY7Z/YOi0GqnMORB8fh/IyhyUDGVeg1g" +
       "pevCgtdI8YImXzjdWN16+sF3eN7Mv3LVg7eksqrqLa48/UrDJCmFS1cvSi2D" +
       "/8xQ1FoEryDERIdL8XVBfwaAPEgPpRP/9dKdpajWpYOtRMdLch5sCySse8Fw" +
       "0KqzGHh2Q4SYUCSA2oSOciFPtYE8Fmq5lYXyS7xXVxYv/JnYcaqseCgelS+e" +
       "3jb48PVPPCOuzrKKp6fZLnXgSuKCnq8JlhfdzdmrcmvnjTnP1ax0/Nt3dffy" +
       "xv0EPJ1fcxcF7pJWR/5K+e7Mphd/fKjyLYjMXSiEIZ/sKizTc0YWirFdscKQ" +
       "gfqJX3K7Or86tXlN6k+/5BchVHD9CdKPypfPPPT2sYUzcBmu60cVELokx+8P" +
       "909pO4g8YcZRg2L15oBF2EXBqi8e5zCvxawI4Hqx1dmQH2VvKhS1FyJM4UsU" +
       "XBonidmjZ7WkHdF17ojv/dopq7KGEVjgjnhA9WsCBJg1wFFHYwOG4TxIlN80" +
       "eCCfCuISH+SrX+Jd1vzg35RIFMBCGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
