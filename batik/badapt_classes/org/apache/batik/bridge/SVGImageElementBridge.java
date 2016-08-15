package org.apache.batik.bridge;
public class SVGImageElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected org.w3c.dom.svg.SVGDocument imgDocument;
    protected org.w3c.dom.events.EventListener listener = null;
    protected org.apache.batik.bridge.BridgeContext subCtx = null;
    protected boolean hitCheckChildren = false;
    public SVGImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_IMAGE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGImageElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ImageNode imageNode =
          (org.apache.batik.gvt.ImageNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (imageNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          imageNode);
        hitCheckChildren =
          false;
        org.apache.batik.gvt.GraphicsNode node =
          buildImageGraphicsNode(
            ctx,
            e);
        if (node ==
              null) {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            java.lang.String uriStr =
              ie.
              getHref(
                ).
              getAnimVal(
                );
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_URI_IMAGE_INVALID,
              new java.lang.Object[] { uriStr });
        }
        imageNode.
          setImage(
            node);
        imageNode.
          setHitCheckChildren(
            hitCheckChildren);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertImageRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            imageNode.
              setRenderingHints(
                hints);
        return imageNode;
    }
    protected org.apache.batik.gvt.GraphicsNode buildImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                       org.w3c.dom.Element e) {
        org.w3c.dom.svg.SVGImageElement ie =
          (org.w3c.dom.svg.SVGImageElement)
            e;
        java.lang.String uriStr =
          ie.
          getHref(
            ).
          getAnimVal(
            );
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        if (uriStr.
              indexOf(
                '#') !=
              -1) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { "xlink:href",
              uriStr });
        }
        java.lang.String baseURI =
          org.apache.batik.dom.AbstractNode.
          getBaseURI(
            e);
        org.apache.batik.util.ParsedURL purl;
        if (baseURI ==
              null) {
            purl =
              new org.apache.batik.util.ParsedURL(
                uriStr);
        }
        else {
            purl =
              new org.apache.batik.util.ParsedURL(
                baseURI,
                uriStr);
        }
        return createImageGraphicsNode(
                 ctx,
                 e,
                 purl);
    }
    protected org.apache.batik.gvt.GraphicsNode createImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        org.w3c.dom.svg.SVGDocument svgDoc =
          (org.w3c.dom.svg.SVGDocument)
            e.
            getOwnerDocument(
              );
        java.lang.String docURL =
          svgDoc.
          getURL(
            );
        org.apache.batik.util.ParsedURL pDocURL =
          null;
        if (docURL !=
              null)
            pDocURL =
              new org.apache.batik.util.ParsedURL(
                docURL);
        org.apache.batik.bridge.UserAgent userAgent =
          ctx.
          getUserAgent(
            );
        try {
            userAgent.
              checkLoadExternalResource(
                purl,
                pDocURL);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        org.apache.batik.bridge.DocumentLoader loader =
          ctx.
          getDocumentLoader(
            );
        org.apache.batik.ext.awt.image.spi.ImageTagRegistry reg =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorspace =
          extractColorSpace(
            e,
            ctx);
        {
            try {
                org.w3c.dom.Document doc =
                  loader.
                  checkCache(
                    purl.
                      toString(
                        ));
                if (doc !=
                      null) {
                    imgDocument =
                      (org.w3c.dom.svg.SVGDocument)
                        doc;
                    return createSVGImageNode(
                             ctx,
                             e,
                             imgDocument);
                }
            }
            catch (org.apache.batik.bridge.BridgeException ex) {
                throw ex;
            }
            catch (java.lang.Exception ex) {
                
            }
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              checkCache(
                purl,
                colorspace);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream reference =
          null;
        try {
            reference =
              openStream(
                e,
                purl);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.IOException ioe) {
            return createBrokenImageNode(
                     ctx,
                     e,
                     purl.
                       toString(
                         ),
                     ioe.
                       getLocalizedMessage(
                         ));
        }
        {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                false,
                false);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.w3c.dom.Document doc =
              loader.
              loadDocument(
                purl.
                  toString(
                    ),
                reference);
            imgDocument =
              (org.w3c.dom.svg.SVGDocument)
                doc;
            return createSVGImageNode(
                     ctx,
                     e,
                     imgDocument);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            throw ex;
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.InterruptedIOException iioe) {
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    ))
                throw new org.apache.batik.bridge.InterruptedBridgeException(
                  );
        }
        catch (org.apache.batik.bridge.InterruptedBridgeException ibe) {
            throw ibe;
        }
        catch (java.lang.Exception ex) {
            
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                true,
                true);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        finally {
            reference.
              release(
                );
        }
        return null;
    }
    public static class ProtectedStream extends java.io.BufferedInputStream {
        static final int BUFFER_SIZE = 8192;
        ProtectedStream(java.io.InputStream is) {
            super(
              is,
              BUFFER_SIZE);
            super.
              mark(
                BUFFER_SIZE);
        }
        ProtectedStream(java.io.InputStream is,
                        int size) { super(
                                      is,
                                      size);
                                    super.
                                      mark(
                                        size);
        }
        public boolean markSupported() { return false;
        }
        public void mark(int sz) {  }
        public void reset() throws java.io.IOException {
            throw new java.io.IOException(
              "Reset unsupported");
        }
        public void retry() throws java.io.IOException {
            super.
              reset(
                );
        }
        public void close() throws java.io.IOException {
            
        }
        public void release() { try { super.
                                        close(
                                          );
                                }
                                catch (java.io.IOException ioe) {
                                    
                                } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "NcPxjJji8Ml/AXhvSUtiHgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e8zr6FmnzzczZy5t55yZ0s7stDOdtqegacqxk9i57HBp" +
           "EjuxYztO7NixA+XU19iJb/EtdtjZbSux7YIo1e4UilRG/FFgF3pBiAoQAg1C" +
           "UBAFqYBgL0BRBbvsdivRP7iIssu+dr77uZRRR/tJ3xv7fZ/3eZ/fc3tv/uRX" +
           "oAfiCKqFgVus3CC5aebJzbWL3UyK0IxvjhlsqkaxaQxcNY7noO6W/rafvfa3" +
           "X/uIff0IurqEXq/6fpCoiRP4MW/GgZuZBgNdO6slXNOLE+g6s1YzFU4Tx4UZ" +
           "J06eZ6DXnOuaQDeYExFgIAIMRIArEeDeGRXo9DrTT71B2UP1k3gL/WvoCgNd" +
           "DfVSvAR660UmoRqp3jGbaYUAcHiofJcAqKpzHkHPnmI/YL4N8Edr8Is/8j3X" +
           "f+4+6NoSuub4QimODoRIwCBL6LWe6WlmFPcMwzSW0GO+aRqCGTmq6+wruZfQ" +
           "47Gz8tUkjcxTJZWVaWhG1ZhnmnutXmKLUj0JolN4lmO6xsnbA5arrgDWN55h" +
           "PSAclvUA4CMOECyyVN086XL/xvGNBHrL5R6nGG/QgAB0fdAzEzs4Hep+XwUV" +
           "0OMH27mqv4KFJHL8FSB9IEjBKAn01F2ZlroOVX2jrsxbCfTkZbrpoQlQPVwp" +
           "ouySQG+4TFZxAlZ66pKVztnnK5Nv+/D3+qR/VMlsmLpbyv8Q6PTMpU68aZmR" +
           "6evmoeNr38n8sPrGX/nQEQQB4jdcIj7Q/MK/+uq73/XMy791oHnTHWg4bW3q" +
           "yS39E9qjX3jz4LnufaUYD4VB7JTGv4C8cv/pccvzeQgi742nHMvGmyeNL/O/" +
           "qbzvp80vH0GPUNBVPXBTD/jRY3rghY5rRiPTNyM1MQ0Ketj0jUHVTkEPgmfG" +
           "8c1DLWdZsZlQ0P1uVXU1qN6BiizAolTRg+DZ8a3g5DlUE7t6zkMIgh4H/9AT" +
           "EHSFg6q/w28CvRe2A8+EVV31HT+Ap1FQ4o9h0080oFsb1oDXb+A4SCPggnAQ" +
           "rWAV+IFtHjdokWOsTFiQRpQHHKBMEKBrv6q9WXpa+P9hjLzEeX135QowwZsv" +
           "JwAXxA4ZuIYZ3dJfTPvEVz9963eOTgPiWEMJ9O1g2JuHYW9Ww948DHvzjsPe" +
           "ACASAAIkhyQyVQ+6cqUa/ZtKcQ7GB6bbgCQA0uNrnxPeM37vh952H/C6cHc/" +
           "0PsRIIXvnqUHZ2mDqpKjDnwXevlju/dL/wY5go4uptsSAqh6pOw+LZPkaTK8" +
           "cTnM7sT32gf/6m8/88MvBGcBdyF/H+eB23uWcfy2y8qOAt00QGY8Y//OZ9XP" +
           "3vqVF24cQfeD5AASYqICBwa55pnLY1yI5+dPcmOJ5QEA2AoiT3XLppOE9khi" +
           "R8HurKbygker58eAjh868fjZscdXv2Xr68Oy/KaD15RGu4Siyr3fLoQ/9p9/" +
           "7382K3WfpOlr5yY+wUyeP5caSmbXqiTw2JkPzCPTBHR/+rHpf/joVz74XZUD" +
           "AIq332nAG2U5ACkBmBCo+ft+a/tfvvhnn/jDo1OngfKL2B66BzYwyDefiQEy" +
           "iguctXSWG6LvBYZjOarmmqVz/uO1d9Q/+78/fP1gfhfUnHjPu74+g7P6f9GH" +
           "3vc73/N3z1RsrujljHamqjOyQ5p8/RnnXhSpRSlH/v7ff/pHP6f+GEi4IMnF" +
           "zt6s8taVCvqVCvkbkuOeTnCT8sM0OcReZcebFcVzVfmtpTKOVVa+N8riLfH5" +
           "eLgYcudWJbf0j/zhX79O+utf/WqF5OKy5rz5WTV8/uBxZfFsDtg/cTn4STW2" +
           "AR368uS7r7svfw1wXAKOOkhyMReBhJRfcJZj6gce/K+/9utvfO8X7oOOhtAj" +
           "bqAaQ7WKO+hh4PBmbINcloff+e6D5XelK1yvoEK3ga8qnro9IsRjrxHvHBFl" +
           "+dayeMftDne3rpfUf3RIc+UrDDTz3D1WpJHjgQDKjmdx+IXHv7j5+F996jBD" +
           "X57yLxGbH3rx+//p5odfPDq3Lnr7bUuT830Oa6MK5+sO4P4J/F0B//+3/C9B" +
           "lRWHufHxwfEE/ezpDB2GpaHfei+xqiGG/+MzL/zyf3zhgwcYj19cFhBg1fup" +
           "P/o/n7/5sT//7TvMRPeBJV8l4Xfew6fpsviXVVOzLJ4/GLv1z/KLA+2T1dv9" +
           "9zbPsFytnmXzJ/+Bc7UPfOnvbwuOahK6g8Uu9V/Cn/z4U4Pv+HLV/2w2KHs/" +
           "k98+eYOV/Vnfxk97f3P0tqu/cQQ9uISu68fbBkl10zLHLsFSOT7ZS4CtxYX2" +
           "i8vewxrv+dPZ7s2XXebcsJfnoTNTgeeSunx+5NLU84ZSy+8CUTI9jpbp5UCr" +
           "FguH2C9FAuksMVdm9PiXfvwTf/f+D3aOyiT4QFaKDrRy/Yxukpa7k3/7yY8+" +
           "/ZoX//wHqrkBgp6tWIuHuK3KG2XxLYcYTKCrcbXHSQASx1fdSlg8gV7TF4dD" +
           "gr8lUEuirBqcRX/lUtLXc6lpxQhgAZwbN9s3kfJdvbMY9wExwlRzHb2s++6y" +
           "eM+JIE+sXf3GSaxJYPMFHOrG2m2fJP1z+A87lkuC4v9sQYHSHz1jxgRg8/MD" +
           "f/GRz//Q278IND4+0XhJLQOrSe97x5ffV75s7oKpfDRvx/NUiUeoVrOMGids" +
           "NV2aximkd58TepiASTf4BiAl154k0ZjqnfwxyFJt7PRc9lOYstc5TKxxVN8Y" +
           "LurRA1J3JYPBiMF4LSLssJtOBDHI8KWJZZq/z/20XdRasTXDJkLBqPZwOZyQ" +
           "4iDp43W7TqzwmVAPJhRJ92x+hu821KDhDpWhMJ6MBYmmtyK+QLrTxOs2UKuL" +
           "2vpGiormZM92m819pnUzLMBqs1HIrpqznStaqM22WYGGabtl27ErTGeb5r7v" +
           "2oxAGhKiwZYxClfaci3msR8TizB16fW45gleyO5QdWlIm/pEUlKlpxQ+McJp" +
           "pVB2eeFJk/VygsWJZ9V5abnJ3BGjizOlF9eVrTDUvTYlKOneCvTeuIbk6GC2" +
           "5SgvxRtYM9dXsWCwvjztDcmsZ+532GCZNPZzoqUq+ywYUXVVHqoOa/gbee7h" +
           "Mm1HxYYfIbJDYLK9sZs0FqBMpIS6vF3gGIUglq+5+3DoBUoPkyQFYTp6PtkD" +
           "rbNLld4Iy2YiGfbCmngdXxKGAjshvT7HeVNs1prs1P6M24tZNFuRzbVY1ON1" +
           "QyUoy6cNeUusGaKYUzCxRNQJl85GPNXpoWKrHa/SDUGq4UwKNcFjeDzfKfK8" +
           "iMJUterjoZeCYSWV3PDI2OP6O6G/E4toPF6G60gsvIUTsouhsuvue8WSzsZc" +
           "3qUTMOnxtGb1YNKrozTtsgint8yAbvecYrTUiInKrmQ3QN0pl4y3zRnOrlpN" +
           "TJbcqDetI2TPtDcK26VEmMX6W74l1fmZL6CU0uc37Win92bjBr+Uc4LOcymS" +
           "xgpFNxpOYYt7USB3liziFL5QuUGv7+hMkY+HspmIo624dDeDKc72Jg0p7k0k" +
           "Nui5BOrxOkFg856winEpYxQM5fqGbIGtNjbbFTNiSptKOMBhXMFFQsTVfMKw" +
           "Sr9HTlI6rmsj3Jii81qHJnrTQafH9CadNpf5Gtaa61aONQqFF6RVP2TbHjub" +
           "Iy5fdJ2UMetqEolUo+XPJ+6ERKexO3R7CMbVEYycMyzcGw+b1H4zQbtZLZNk" +
           "bd0cNFe1ec3HBLrh0e5MBBveERIN0GjPOIutXqx8Wm4VwCChHxHWurbsWZwS" +
           "4eO2MR8YE9vPxt0FvaAjKSeNmciHVEBFW0VoRaqAwPViYxEWp89XdmjLsMBv" +
           "7GBDreAaxs3bBsEzeuqU8RqNIp4SJ3hNR4LleLdpkcrGWwkZiTZUz1v0BohS" +
           "p3LORXv6ej9xqZFPbXctBl+02skepXCFCHr1USsfbYZTBO5MlzV+tl/764Af" +
           "KApJ7IARZlweI2N9wdo4HxqWaVrrdb5K6/qoP+DstYMRQWvSYI1RzhB8rWtT" +
           "xYJtz2YrbrbpF2hPXS94inaMqU+t00ZHHyIB1iOoXjZdrBedthYlNWwprwwr" +
           "RLuLVXc/6DGZIQU52hRr87mJUK16skX1rj92sA63qQWKqopC0nIG+WLR3Sgj" +
           "ZKwgrc0cqF6WaYY3mKkpDlpYYQvCbthQQ70hD4L6yF3v2X59ni5bNCcwI2WZ" +
           "JOQupPUNzMntZo1DkyZs6x417w5n9DSiyI2d2rg30ZmaFu+9vksji6Zq1rZr" +
           "ZWc01UWL64wXukWL8W4zW7orq0u1HNNm+BYtI3FHF9L5lmx4SxznlIWygucK" +
           "Md/jLkq3OulGX6obfGVw6kYVaS2V6jLbJfFRU5f5EdcoGE/vEEkrG/drjugL" +
           "rOi347asL4o9yTe7zGAwpEFE4GnWhM22O613tvVxI2OIhul6A6UjYNPJZuJE" +
           "wjhLNDs10Wl/xA66pmXNurtuJybNqDP0eoshud0RqG4WA2Y1c/t7o9tpp0qz" +
           "uQ4wQxjrHZITOp1kISFEgxsJbrFTNrOZ7Aywhqu3WVpzPH+5DMURq83HSNOX" +
           "4b0i17pBEjeyHQG2zV1V95VB23LRZmotht6+nRIjfkDYS1uqi6k3bi6xtiPW" +
           "83jki72aHiWWpsH+Qg6sem9NFS21s0FdcZTTjo3ON4O2g9OLlLfcRTMdI6nd" +
           "RzIi7/Os1KILvy/aSS3bccMOksdTOMT3kyE1bunonNwv05qFjxGEEqzC8iZW" +
           "d7T1rSUZWHhhFzNtl3nbXVMkeyO0QNGpxUhLTkZHNKv2gxWPNfgdQlGWZ7Ft" +
           "Zzax2Nq0Pp93YAveBNLAMnlzs1hv5+gWDdpsnzJ8bOVsmti+lqtJUqC1Nb2f" +
           "MaLo8R1CZLbTnRvqTdXrLjCWnYPcHJuybKEI4dsmE6wQCdWlcWzk3UTntvYu" +
           "6w3IAZp0Ezvf7qixzbX9db2TdUd8a99iBtJkQGhFfUNl65EPdvMblUmRqDkN" +
           "ZC22ObVDrFZIs42SgdE2O1k6GRJGWPe4bk7OulvAZL/tpWY2GccFTIQwJa/g" +
           "PYyu4f165TY7QMs67vFhMJN5QxYYiZdTnET7QZSozXzb7XZ5PFnh/aGD9PbT" +
           "5cTKsnnRb8yNFFcts6ADVxOcxrQZRwrKscIsbSykuU0oltkxGrDM9Jtakmju" +
           "tisbbibjock5TbiJ5npmaXvMCPp0uMEKrNgK5oIypy1twTIG20zmGljgtBdb" +
           "vAiH05a3l6au58ALP+sLNj43k5A1FM3vxMOocIIFgQ5UZDRC1y7Oi0I+VMDW" +
           "fb5Y2EUaCxO/aXWUJbOeRUasObugYGC1ToPFRHuojalWt4vOTTJrGrvmZJn3" +
           "lc4YHTTRemsgNKdTboqmgrtY0cLa5nt4x5zKUbYLW1HTtlDNl0ZtFtN1q0OS" +
           "SosxOx7fxuFB0UitwZJd6gYVc3NrykhCHnPaENWWLratrXU8q7etJJtnSj1Q" +
           "s5kl7DgzIv3GqG+h5IJTU2zfZ3TJo4zGYjbxRuRY2Nd7OxV1a0inPSz6tDjs" +
           "oMV+ZHcxxJiTNdg0EVFx6sxkxFDcwnMb6EyJM65fa9WcfjfQxkm7sxYdxRZ2" +
           "Uuh1RCZnVqqNZrHNLseR4KUFv9tspMW2z0atZi/s6AkzyzQvi5rGXIlWcDNI" +
           "mHo7w6RonQo9Wd4vZV9gTMFx9raXbguqW2BjeT0ZLLSYtzYoS9jtdJkGxWAy" +
           "NwtlGs60LNuvY36C7Hwu7hCMjYC5lGXqVMMJ0marucz2SRsOsW5zGW19pGOt" +
           "F7Gx5Hy5k62EOG2HnU5PWpqyNpVzzdQnMtX1PAQj4gG92goWia8R08xkwU9w" +
           "NJH769h0XNSHCduAHSeY5E4Tnyys4VAX15PtKE+DTYOKFD6oy1uu35d2vm0M" +
           "9quYYSOCTmfG1Fg0mNiwuw19MlJDdh7GLS30ZvhGCqZ1DtPpaU/vdohC32/C" +
           "rcfSwWiww2rZnPTz2DH3Bd11YMnoiwiCGpjAjQoNrLySoSHQu0ZzKDgFOXIH" +
           "It+Kor4htWlvXdh7m9VdeuI5hZtwQT4XW1i6dneRL+wHQ5vjepQXbmuavl1J" +
           "PFnbJZMWHeU0ns29cYt30F4KkxxIlkas+KpMaCnYIe/hpi+uawLVmiGW1RBn" +
           "rcbK71hMrSvxPavHkCS6HbKjiaP0HHLdkJ14hSJg7R6hdrHti2JH3y+HUyLG" +
           "Y6NPLGnHE4qVQ1ucKzDqSjF4Hov4lpA65CgY8lquKmaHwJ1uf7MWFWyychht" +
           "3/G0OauzIpf1ZC+AF46qIcHM5vIA5IIBnHZlOULF4cRotMhJhGa1wOp501Xc" +
           "WmkC0AbWQNZcVp81Fm4gOsvEn4QCWpv7jCAFyr41ascOj9tzPqutsR3Sr5H9" +
           "qCP4wxpmzNPQ4AZ9d97erdodMhls+jtzE023DZefbt36ouF25mKCNRF3APut" +
           "RGESbNnmjLAjaaiZcjlYDNfE9ij2u5SwWZO4izR1Ngv33W42xerjQdLAiNYG" +
           "2U3liRWLkUFMmcJlGKQFMg0XsW3C8Pywm43cJLbdZlOuzXNkge2MvGlxfWVE" +
           "hmt2H1NtJE/mLQzrqBKcbLu4oBWiPfCllQoPpTFtaAi1TNe8ZImt4X446Fqy" +
           "mtRYkpS8bG7BKY7ALBHJdq9GLRE04xp1eJZ6XExveiYqIL3a3mdWa3nO2ZrH" +
           "CF6f8Ncas/R27GKlhOzQ6BgmrrVoXbQ8ijdJUmwMXS1Hl4s5pssyXGP8lh8O" +
           "Rw1jlICFFi3M8KS2GhmFbA2tWAWmh3urdeqk5hhjYzQnxwEu4xN+VKyj1LD4" +
           "RmQimwXVrDutiT7N1+O102FduCfbmSAmDrnq9cotcvbKtu6PVUcRpzepYMde" +
           "NryS3Xl+l2OYswHPjvGr07jHLl/KXT5VffLkNDeCnr7bvWl16PiJD7z4ksH9" +
           "RP3o+IxwlEBXj6+zz/hcBWzeeffzPra6Mz47dPvcB/7XU/PvsN/7Cm6d3nJJ" +
           "yMss/xP7yd8efbP+74+g+06P4G67zb7Y6fmLB2+PRGaSRv78wvHb06dqfaJU" +
           "1w2oPG0/qHV5j3Puy4a6Uhnq4A/3OH/9wXu0/VBZfCiBXuep0UZIwxAsekzj" +
           "Tkc/D2pB4Jqqf+Za/+6VnONWFd93ivtaWfksgPCeY9zveXVwXzkjGFQEH78H" +
           "+JfK4kcS6P4S/B2Pu7LAMc4Af+wbBfwmINqtY8C3Xn1D/8ydlXH7hRSYIXUz" +
           "LGOj6vepsvjJBHogMmOzulP78TPQP/VqgNaPQeuvPuhfursHfLoi+OWy+PkK" +
           "XRIVl9B99tVAtzpGt3r10f3G10P3ubJ4GaDT3SA2L6H7tW8U3dNgrM0xus2r" +
           "j+4L92j7g7L4PMg7kQnSzm3QfvcVXSIl0LVLX0GcBMW3vqJvKcCE9ORtX20d" +
           "vjTSP/3StYeeeEn84+rrgdOvgR5moIes1HXP38Wce74aRqblVIAfPtzMhNXP" +
           "nyTQE3eRDMyUh4cKwn870H8xga5fpgdOUf2ep/tSAj1yRgdYHR7Ok/xlAt0H" +
           "SMrH/x6eqOlNJ7mjn1rlpw/G+UvtKxfn/lMbPf71bHRuufD2C/N89QHdyZyc" +
           "Hj6hu6V/5qXx5Hu/2vqJw3cOuqvu9yWXhxjowcMnF6fz+lvvyu2E11Xyua89" +
           "+rMPv+NkAfLoQeAznz4n21vu/HUB4YVJ9T3A/hef+Plv+6mX/qy64/p/wCyt" +
           "QNkoAAA=");
    }
    protected org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream openStream(org.w3c.dom.Element e,
                                                                                       org.apache.batik.util.ParsedURL purl)
          throws java.io.IOException { java.util.List mimeTypes =
                                         new java.util.ArrayList(
                                         org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                                           getRegistry(
                                             ).
                                           getRegisteredMimeTypes(
                                             ));
                                       mimeTypes.
                                         add(
                                           org.apache.batik.util.MimeTypeConstants.
                                             MIME_TYPES_SVG);
                                       java.io.InputStream reference =
                                         purl.
                                         openStream(
                                           mimeTypes.
                                             iterator(
                                               ));
                                       return new org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream(
                                         reference);
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ImageNode(
          );
    }
    public boolean isComposite() { return false;
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        if (!ctx.
              isInteractive(
                ))
            return;
        ctx.
          bind(
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            this.
              e =
              e;
            this.
              node =
              node;
            this.
              ctx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                this);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            java.lang.String ns =
              alav.
              getNamespaceURI(
                );
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ns ==
                  null) {
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE)) {
                    updateImageBounds(
                      );
                    return;
                }
                else
                    if (ln.
                          equals(
                            SVG_WIDTH_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_HEIGHT_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGImageElement ie =
                          (org.w3c.dom.svg.SVGImageElement)
                            e;
                        org.apache.batik.gvt.ImageNode imageNode =
                          (org.apache.batik.gvt.ImageNode)
                            node;
                        org.apache.batik.dom.svg.AbstractSVGAnimatedLength _attr;
                        if (ln.
                              charAt(
                                0) ==
                              'w') {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getWidth(
                                  );
                        }
                        else {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getHeight(
                                  );
                        }
                        float val =
                          _attr.
                          getCheckedValue(
                            );
                        if (val ==
                              0 ||
                              imageNode.
                              getImage(
                                ) instanceof org.apache.batik.gvt.ShapeNode) {
                            rebuildImageNode(
                              );
                        }
                        else {
                            updateImageBounds(
                              );
                        }
                        return;
                    }
                    else
                        if (ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            updateImageBounds(
                              );
                            return;
                        }
            }
            else
                if (ns.
                      equals(
                        XLINK_NAMESPACE_URI) &&
                      ln.
                      equals(
                        XLINK_HREF_ATTRIBUTE)) {
                    rebuildImageNode(
                      );
                    return;
                }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected void updateImageBounds() { java.awt.geom.Rectangle2D bounds =
                                           getImageBounds(
                                             ctx,
                                             e);
                                         org.apache.batik.gvt.GraphicsNode imageNode =
                                           ((org.apache.batik.gvt.ImageNode)
                                              node).
                                           getImage(
                                             );
                                         float[] vb =
                                           null;
                                         if (imageNode instanceof org.apache.batik.gvt.RasterImageNode) {
                                             java.awt.geom.Rectangle2D imgBounds =
                                               ((org.apache.batik.gvt.RasterImageNode)
                                                  imageNode).
                                               getImageBounds(
                                                 );
                                             vb =
                                               (new float[4]);
                                             vb[0] =
                                               0;
                                             vb[1] =
                                               0;
                                             vb[2] =
                                               (float)
                                                 imgBounds.
                                                 getWidth(
                                                   );
                                             vb[3] =
                                               (float)
                                                 imgBounds.
                                                 getHeight(
                                                   );
                                         }
                                         else {
                                             if (imgDocument !=
                                                   null) {
                                                 org.w3c.dom.Element svgElement =
                                                   imgDocument.
                                                   getRootElement(
                                                     );
                                                 java.lang.String viewBox =
                                                   svgElement.
                                                   getAttributeNS(
                                                     null,
                                                     SVG_VIEW_BOX_ATTRIBUTE);
                                                 vb =
                                                   org.apache.batik.bridge.ViewBox.
                                                     parseViewBoxAttribute(
                                                       e,
                                                       viewBox,
                                                       ctx);
                                             }
                                         }
                                         if (imageNode !=
                                               null) {
                                             initializeViewport(
                                               ctx,
                                               e,
                                               imageNode,
                                               vb,
                                               bounds);
                                         }
    }
    protected void rebuildImageNode() { if (imgDocument !=
                                              null &&
                                              listener !=
                                              null) {
                                            org.apache.batik.dom.events.NodeEventTarget tgt =
                                              (org.apache.batik.dom.events.NodeEventTarget)
                                                imgDocument.
                                                getRootElement(
                                                  );
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_CLICK,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYPRESS,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYUP,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEMOVE,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOUT,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOVER,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEUP,
                                                listener,
                                                false);
                                            listener =
                                              null;
                                        }
                                        if (imgDocument !=
                                              null) {
                                            org.w3c.dom.svg.SVGSVGElement svgElement =
                                              imgDocument.
                                              getRootElement(
                                                );
                                            disposeTree(
                                              svgElement);
                                        }
                                        imgDocument =
                                          null;
                                        subCtx =
                                          null;
                                        org.apache.batik.gvt.GraphicsNode inode =
                                          buildImageGraphicsNode(
                                            ctx,
                                            e);
                                        org.apache.batik.gvt.ImageNode imgNode =
                                          (org.apache.batik.gvt.ImageNode)
                                            node;
                                        imgNode.
                                          setImage(
                                            inode);
                                        if (inode ==
                                              null) {
                                            org.w3c.dom.svg.SVGImageElement ie =
                                              (org.w3c.dom.svg.SVGImageElement)
                                                e;
                                            java.lang.String uriStr =
                                              ie.
                                              getHref(
                                                ).
                                              getAnimVal(
                                                );
                                            throw new org.apache.batik.bridge.BridgeException(
                                              ctx,
                                              e,
                                              ERR_URI_IMAGE_INVALID,
                                              new java.lang.Object[] { uriStr });
                                        }
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   IMAGE_RENDERING_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_INTERPOLATION_INDEX:
                java.awt.RenderingHints hints =
                  org.apache.batik.bridge.CSSUtilities.
                  convertImageRendering(
                    e,
                    null);
                hints =
                  org.apache.batik.bridge.CSSUtilities.
                    convertColorRendering(
                      e,
                      hints);
                if (hints !=
                      null) {
                    node.
                      setRenderingHints(
                        hints);
                }
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected org.apache.batik.gvt.GraphicsNode createRasterImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                      org.w3c.dom.Element e,
                                                                      org.apache.batik.ext.awt.image.renderable.Filter img,
                                                                      org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        if (org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
              hasBrokenLinkProperty(
                img)) {
            java.lang.Object o =
              img.
              getProperty(
                org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
                  BROKEN_LINK_PROPERTY);
            java.lang.String msg =
              "unknown";
            if (o instanceof java.lang.String)
                msg =
                  (java.lang.String)
                    o;
            org.w3c.dom.svg.SVGDocument doc =
              ctx.
              getUserAgent(
                ).
              getBrokenLinkDocument(
                e,
                purl.
                  toString(
                    ),
                msg);
            return createSVGImageNode(
                     ctx,
                     e,
                     doc);
        }
        org.apache.batik.gvt.RasterImageNode node =
          new org.apache.batik.gvt.RasterImageNode(
          );
        node.
          setImage(
            img);
        java.awt.geom.Rectangle2D imgBounds =
          img.
          getBounds2D(
            );
        float[] vb =
          new float[4];
        vb[0] =
          0;
        vb[1] =
          0;
        vb[2] =
          (float)
            imgBounds.
            getWidth(
              );
        vb[3] =
          (float)
            imgBounds.
            getHeight(
              );
        initializeViewport(
          ctx,
          e,
          node,
          vb,
          bounds);
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode createSVGImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.w3c.dom.svg.SVGDocument imgDocument) {
        org.apache.batik.css.engine.CSSEngine eng =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             imgDocument).
          getCSSEngine(
            );
        subCtx =
          ctx.
            createSubBridgeContext(
              (org.apache.batik.dom.svg.SVGOMDocument)
                imgDocument);
        org.apache.batik.gvt.CompositeGraphicsNode result =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            result.
              getChildren(
                ).
              add(
                sn);
            return result;
        }
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null) {
            result.
              setBackgroundEnable(
                r);
        }
        org.w3c.dom.svg.SVGSVGElement svgElement =
          imgDocument.
          getRootElement(
            );
        org.apache.batik.gvt.CanvasGraphicsNode node;
        node =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            subCtx.
            getGVTBuilder(
              ).
            build(
              subCtx,
              svgElement);
        if (eng ==
              null &&
              ctx.
              isInteractive(
                )) {
            subCtx.
              addUIEventListeners(
                imgDocument);
        }
        node.
          setClip(
            null);
        node.
          setViewingTransform(
            new java.awt.geom.AffineTransform(
              ));
        result.
          getChildren(
            ).
          add(
            node);
        java.lang.String viewBox =
          svgElement.
          getAttributeNS(
            null,
            SVG_VIEW_BOX_ATTRIBUTE);
        float[] vb =
          org.apache.batik.bridge.ViewBox.
          parseViewBoxAttribute(
            e,
            viewBox,
            ctx);
        initializeViewport(
          ctx,
          e,
          result,
          vb,
          bounds);
        if (ctx.
              isInteractive(
                )) {
            listener =
              new org.apache.batik.bridge.SVGImageElementBridge.ForwardEventListener(
                svgElement,
                e);
            org.apache.batik.dom.events.NodeEventTarget tgt =
              (org.apache.batik.dom.events.NodeEventTarget)
                svgElement;
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false);
        }
        return result;
    }
    public void dispose() { if (imgDocument !=
                                  null &&
                                  listener !=
                                  null) {
                                org.apache.batik.dom.events.NodeEventTarget tgt =
                                  (org.apache.batik.dom.events.NodeEventTarget)
                                    imgDocument.
                                    getRootElement(
                                      );
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_CLICK,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYPRESS,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYUP,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEMOVE,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOUT,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOVER,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEUP,
                                    listener,
                                    false);
                                listener =
                                  null;
                            }
                            if (imgDocument !=
                                  null) {
                                org.w3c.dom.svg.SVGSVGElement svgElement =
                                  imgDocument.
                                  getRootElement(
                                    );
                                disposeTree(
                                  svgElement);
                                imgDocument =
                                  null;
                                subCtx =
                                  null;
                            }
                            super.dispose(
                                    ); }
    protected static class ForwardEventListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element svgElement;
        protected org.w3c.dom.Element imgElement;
        public ForwardEventListener(org.w3c.dom.Element svgElement,
                                    org.w3c.dom.Element imgElement) {
            super(
              );
            this.
              svgElement =
              svgElement;
            this.
              imgElement =
              imgElement;
        }
        public void handleEvent(org.w3c.dom.events.Event e) {
            org.apache.batik.dom.events.DOMMouseEvent evt =
              (org.apache.batik.dom.events.DOMMouseEvent)
                e;
            org.apache.batik.dom.events.DOMMouseEvent newMouseEvent =
              (org.apache.batik.dom.events.DOMMouseEvent)
                ((org.w3c.dom.events.DocumentEvent)
                   imgElement.
                   getOwnerDocument(
                     )).
                createEvent(
                  "MouseEvents");
            newMouseEvent.
              initMouseEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                evt.
                  getType(
                    ),
                evt.
                  getBubbles(
                    ),
                evt.
                  getCancelable(
                    ),
                evt.
                  getView(
                    ),
                evt.
                  getDetail(
                    ),
                evt.
                  getScreenX(
                    ),
                evt.
                  getScreenY(
                    ),
                evt.
                  getClientX(
                    ),
                evt.
                  getClientY(
                    ),
                evt.
                  getButton(
                    ),
                (org.w3c.dom.events.EventTarget)
                  imgElement,
                evt.
                  getModifiersString(
                    ));
            ((org.w3c.dom.events.EventTarget)
               imgElement).
              dispatchEvent(
                newMouseEvent);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aecwr11Wf970l770meS8vK6HZX0oTt994n7ESSsfLjGfx" +
           "eDy2x/bQ9mU8m8eeffGMpwTSIEhFpVJBuoDaCKRWQJUuQlQgoaIgBG3VCqmo" +
           "YpNoK4REoVRq/qAgCpQ7429/7yVESHySr6/vPefcc84953e37+XvQWcDHyq4" +
           "jrnRTSfcVZNwd2nWdsONqwa7FFPjJD9QlZYpBcEItF2TH/38pR/88EOLyzvQ" +
           "ORG6U7JtJ5RCw7EDXg0cc60qDHTpsLVjqlYQQpeZpbSW4Cg0TJgxgvApBnrT" +
           "EdYQusrsqwADFWCgApyrAGOHVIDpNtWOrFbGIdlh4EE/C51ioHOunKkXQo8c" +
           "F+JKvmTtieFyC4CE89lvARiVMyc+9PCB7VubrzP4wwX4xY++5/LvnoYuidAl" +
           "wx5m6shAiRAMIkK3Wqo1V/0AUxRVEaE7bFVVhqpvSKaR5nqL0JXA0G0pjHz1" +
           "wElZY+Sqfj7moedulTPb/EgOHf/APM1QTWX/11nNlHRg6z2Htm4txLN2YOBF" +
           "Ayjma5Ks7rOcWRm2EkIPneQ4sPEqDQgA6y2WGi6cg6HO2BJogK5s586UbB0e" +
           "hr5h64D0rBOBUULo/psKzXztSvJK0tVrIXTfSTpu2wWoLuSOyFhC6O6TZLkk" +
           "MEv3n5ilI/PzPfbpD77X7to7uc6KKpuZ/ucB04MnmHhVU33VltUt461PMh+R" +
           "7vni+3cgCBDffYJ4S/P7P/PqO9/24Ctf3tL8+A1o+vOlKofX5E/Ob//6m1tP" +
           "NE5napx3ncDIJv+Y5Xn4c3s9TyUuyLx7DiRmnbv7na/wfzZ77tPqd3egiyR0" +
           "TnbMyAJxdIfsWK5hqj6h2qovhapCQhdUW2nl/SR0C6gzhq1uW/uaFqghCZ0x" +
           "86ZzTv4buEgDIjIX3QLqhq05+3VXChd5PXEhCLobfKAuBJ1+K5T/bb9D6Bl4" +
           "4VgqLMmSbdgOzPlOZn8Aq3Y4B75dwHMQ9Ss4cCIfhCDs+DosgThYqHsdc99Q" +
           "dBUeCgRpgQDIAAKwNvPW3SzS3P+HMZLMzsvxqVNgCt58EgBMkDtdx1RU/5r8" +
           "YtTsvPrZa1/dOUiIPQ+FUBMMu7sddjcfdnc77O4Nh72KO34s+UpnDZoyCMym" +
           "EDp1KlfhrkynbQSA+VsBJAAEtz4xfDf1zPsfPQ1Cz43PAOdnpPDNobp1iB1k" +
           "jpAyCGDolY/F7xN+rrgD7RzH3MwO0HQxY+cypDxAxKsnc+1Gci+98J0ffO4j" +
           "zzqHWXcMxPfA4HrOLJkfPelx35FVBcDjofgnH5a+cO2Lz17dgc4AhACoGEog" +
           "igHgPHhyjGNJ/dQ+QGa2nAUGa45vSWbWtY9qF8OF78SHLXko3J7X7wA+vpRF" +
           "+WMg3JG9sM+/s9473ay8axs62aSdsCIH4J8cup/46z//p0ru7n2svnRk9Ruq" +
           "4VNH8CETdilHgjsOY2Dkqyqg+7uPcb/64e+98NN5AACKx2404NWsbAFcAFMI" +
           "3PwLX/b+5lvf/OQ3dg6DJgQLZDQ3DTk5MPJ8ZtPtr2EkGO0th/oAfDFB/mVR" +
           "c3VsW45iaIY0N9UsSv/z0uOlL/zLBy9v48AELfth9LbXF3DY/mNN6Lmvvuff" +
           "HszFnJKz9e3QZ4dkW9C881Ay5vvSJtMjed9fPPBrX5I+AeAXQF5gpGqOYju5" +
           "D3Zyy+8OoTuznI0r8q7iWLt7+Zl1FfNZhXOyJ/NyN/NIzgzlfZWseCg4mh3H" +
           "E/DIRuWa/KFvfP824ft/9GpuzvGdztFg6EnuU9v4y4qHEyD+3pNQ0JWCBaCr" +
           "vsK+67L5yg+BRBFIlAHuBX0fYFRyLHT2qM/e8rd//Cf3PPP109AODl00HUnB" +
           "pTwLoQsg/NVgAeAtcX/qndvpj7N4uJybCl1n/DZq7st/ZXvFJ24OQHi2UTnM" +
           "4fv+o2/On//7f7/OCTn03GB9PsEvwi9//P7WO76b8x9iQMb9YHI9boNN3SFv" +
           "+dPWv+48eu5Pd6BbROiyvLdjFCQzyjJLBLukYH8bCXaVx/qP73i2y/tTBxj3" +
           "5pP4c2TYk+hzuF6Aekad1S+eAJwrmZcfBzn49r1cfPtJwDkF5RUsZ3kkL69m" +
           "xU/s5/cF13dCoKWq7KX4j8DfKfD57+yTicsatsv3ldbeHuLhg02ECxazi8Fa" +
           "P5oPW5DLympWNLeCkZtGzNPX21Pes6d8E3vom9iTVTu5k3Cgl2G9ll7M6+qV" +
           "y0lOAS+dLe8iu7kA/sYjn86qbwVwGeQ7fMChGbZk7qty79KUr+57TwA7fhDK" +
           "V5cmso8tl/MszIJmd7tNPqEr/r/WFWTZ7YfCGAfsuD/wDx/62i8/9i2QChR0" +
           "dp2FKciAIyOyUXYI+cWXP/zAm1789gdy9AeuFJ57/LvPZVLf/VoWZ4WQFZN9" +
           "U+/PTB3muytGCsJeDtiqklv7mgjA+YYF1rX13g4bfvbKt1Yf/85ntrvnk+l+" +
           "glh9/4u/9KPdD764c+TM8th1x4ajPNtzS670bXse9qFHXmuUnAP/x889+4e/" +
           "/ewLW62uHN+Bd8AB8zN/+V9f2/3Yt79yg03fGdP5P0xseNu7utWAxPb/mNJM" +
           "m8WjJBlrZVhjNc3o+5tASyodOeymoj7jOw1MZ2uNtNlRCt1+p+VJo/ayMica" +
           "la5bKfMVrTCsmyOxOZTogTHQrYUgk/BCJI2OR3tjISoZkmGwjj0UVm6La5Ce" +
           "S/gwTZRpwhyU/LE/b/QqPd9WG6EOJ6NNqcaJtRqClpB5A0HWIwWpDyQvHKdj" +
           "fjSQHKVHBEOyTSwqbXc1XVkkQPRU61HSxB7Ai3WhXuDmWN2IdN5LJ5Q/6ZET" +
           "QhiStBlQIT7iGdIpGYK+XPSM3gyNV/iyY/cEocjMuhbdEAepiQlDqduOVvEs" +
           "FmpBYnYQN+THY9ukF1bcxFtlVt+IvL8yi1alUGOqdYlSyjMlWCGcOkjS2Fum" +
           "jIlM+CFejbWEIhHLkyiiWnXxQuxYE2vt1G2eKE2sDk4sVw7jU0rQ7Rfo2QaH" +
           "h2iZm/M+z4m9rtac0onbj6bWZB6RrhSNeLK+ZG2lPGiNa/WkXcd0Hy/yMdcb" +
           "TxryRBvRRCwtxkVFKhW9IlPHJc6UR33NGneUoT3sJIvhQpoafiduzfvlCUNE" +
           "varuzLpSaLNWwEiIRJfjIEg7bkMkRmm5wcFp2CFcxmmLOFHWvCGNdYD8YRVv" +
           "DYdJd1Q25gzfqeuKXuyrtc0MHIgFQotW/U1sOmVCWhTYSqVHWmg8SwpiPfIL" +
           "mByPZilT6ioM5U1rOm7C9ZD1Ur0dGrV4zo8nbZ+q9ZgmhcnTHktK1aBketSC" +
           "Z13LEO0668wKjfYAawWNkdkKKm7iJQ4bxyOv0yKMmVEcdWfaoJhS2MQL2xjl" +
           "jBnJ8UzOlmKW7KQutjKKulYRFzMMRCGiL4lBiKNcYk2btFrcdBXaXvdrvTlj" +
           "Flqc1DbKJOa10lFrKNRHaNdiXHTEhKTl6h10hcWsV6BsdMZMl9UJjxlkDY7I" +
           "plyqcBU41aeCIpSqU5YM/CK5sdoLmqI8IfUUqWIG/GQeVxOWd3oVgZlVRWWW" +
           "+myQ4ohLJwbWwyK6E5pGgltoEAW2XakUyfVKNyiPGFPllQev5AQnELcv9/jh" +
           "1FI8ku+Ueka7jhNOsErWy3qnbnVkIR0Y4kobSbP1gBSGS9Rb1W0N7eJ1odns" +
           "snynGguMVERmMTdimui0TY4GGmcY3YGBc860ysPJUGm1pNK0tzKMSUCLjtod" +
           "sSXRR4WmzFP6pJAWeb4Dj0fj4rpnLYjmmE1Zvt0lBpQmtjbmaNUmrT7SKBZM" +
           "sofNKAzzuRLKBqSRajqM4LiuBHWlpY/0FjWvYuMWXmGthZeSyapBuxoHYymv" +
           "DudVX5/p5kKtGoYW6mXSl1iUKC5nYUgmkxLSrAhpy11v4hbf60m8yVf1FiYh" +
           "LY6WRgaGVdexiWFG05kuKwW0V20nFbfV6fqEgBWrdq1bNqnhysKCaTuY2a4c" +
           "KMyIY/xyqcrOFl7V09vDdMgJgrgI3ZUYt2puvELWtcVgTCOKpXRDr2mEZdeo" +
           "8sSw5U+icuyORs4K5VdoMmLR4iKmFz5TmSxLqknxWmVkAhctVaRRFRIMH6JB" +
           "p4yQkw5ZT5YpHjNVquonqEoHZtiv+A0Hjex2IYjG1GjclRTZtDsbouKjA5Wq" +
           "jEqUVKyWtKFfQyNKRdY8gdkERXK9NsmsUZUaLce1MlYP6uNmu4P4ol735z07" +
           "kXmOtdbeuI/2l2GtzNWK+Cxkup0p1hFVt6B42mbqD6txudtfGN3ZREyrvtor" +
           "V7VGUm2EMgw3OKXClvrqxE4b2HS5AIBNkkWqXmjrJbVOIJP6qEM3EQRNZ0Kt" +
           "UJenA21ZsvQJjrtxCSkvMWIc80TLShowrLQQpIQiSjp1kqWFW26NG0zCMd30" +
           "xZhIPFsWyDJRFry4gTm6N4gl2lKqKIFK1goXk2FrHAUaooYVrj2cVutdnt84" +
           "vX6/U5z781albXMNguvapRROC/WIMrCk423qaX866rfRKa5t2JDrFIsbLrbY" +
           "NQNXJAmsXGBCsaI72wzSZdz0V5weppsROMT3XEOMzIjedJ1oturRE8Sb2gXH" +
           "GtmzqdZA2lyPFjsCPE+bVZ+ZNMpmS9JdRKGHhhppobFpoOx0blPp0A3SeYr1" +
           "ZnWWS5oNxG95WIEUCg3Wa/rDdFCZsmatyy4ashOuKB0zeAoLR4KHefFkuGK6" +
           "rlcPYbBSTM1SXKWLg5ZeNyhz2kWNtjWZ6RKpbShzIHSYhaGpY0wGacwsUqyC" +
           "i2Nxms6bI6sp1uY9ZdO0xjY67zUSsSCiER40lCrRdFuJxSA03SRNAERzuKuk" +
           "DFxN7TIcce1VfWjzFL2J2rZcWAc1eCl5LonAsFizmb7SFCSiicKk7bgTeZLM" +
           "xULMgVMe0ZXXs+km1iUH0ahoTS0RFWnZSAAYqAY2k83I0xSDleFNH8NDtz8t" +
           "lpVm2axvpqEzNODCyicjZ8g13Fq4Fpa2EA5m8sYpz5d4s4wqCLaYDgJpHaYs" +
           "vOZhFQQK143IwC6MOFbdJJUVMeIDbkxPFpTYLOhhDzVMj7SklFmmI73pFNKa" +
           "pElkq9ytCNUKpU/JORt687mUGHG5tsAqUc+kQ2nJh2NhSqfe3LVxc8yYSnEi" +
           "9lh+QNBMpaLICUyMrUhZt5kSidBiP+4Qydwo0B1l1h4Mqdpk0yGoTuSzmo3q" +
           "NhNtaCtFo2WtPWSY/sqZ12KiiqcIvIFhlO0yllJujOvs1EM6kSSk3MzfDN0F" +
           "bJsJWh40Si4HR11kLdqFftlalvF0Oucds2Gj4oRpWf0VUhWmdrih0Cmi1CVu" +
           "inW7Smdjb+AG6aMlrW+xiBStVkW8UEz67qQithli6tHFyoxyOcwU5vOpSJfp" +
           "IhheN9hic4aMGHGMrDwandfLa1aczuCxsB43Xb8rTIx0UnBSnEnUYa1X7PJ2" +
           "K52IlBBTVjjhm2hq8kmRF7myOaLqUZ9rGBM14jYNo4TBGmdRG4QdjLpFtW8n" +
           "TEIbYB1E/WgjVFVZ6NqeI+FhWidGcasAlwVN1NX5jEGx4rKLhOFCWbfqm8iS" +
           "jNq87yZzeQb3OTNOG1Vk3eadfnEqETWPsgVc0XF8zVfKqVDnyuNRj+61FEeh" +
           "S5u2TTamSjGOwTwEa7U2W1baDZIRG4GEgwRGN5G6QYVKs1cegHMg6tmevyIU" +
           "WazpKx/4lSUjSeRampMMQp8mRYCFM7nZL1B9Q3Nay8Ctq465btTr82qr10eG" +
           "+lBPUIqWnZbeoYi06vaJKi3HCFGSemSdnOExqToMp6TFRghHpb4vL425UhKL" +
           "HFuRBvVxrTeds8zCtcNiDQ2WrIoWGK/aX1XB+kRZQr/LTphJMeaXrjg11Tnp" +
           "hVFSMOe+US36trjw8dhDSKY7W9X1ZNhV28p0wmjdcqkkhIHfQBthYSLYSdlX" +
           "k/VQSlB61jdWjdqkwgzGy3ZF0KeNTdikapVgni6Q0rrRUK2w3qBgeFhat/sV" +
           "OgBKagJdV6PuQinWyrbTZ2IxXgjY2uUxD7UrbjwJQ9ztrFJdcMZSvY3ptaI3" +
           "aZZa7anJ9sWBPaiQcjhn9KQfhwSsMohcn1SNDaLizHgcV0c1RSlJNG0bYCWr" +
           "gVDD0uG4batWrTXR9MKiFsNYErU53KklAHPDoQqycj5C0SLfkRbYwO/Jsr8O" +
           "Edqt+kK8XqvppqjNNGlGD3SstZku4+p8geG+Ml6xHbgtd9piZNNMm7DX0zGm" +
           "zStWKZXVUW21LGiFZhlL/aE/xGMMy45Z9hs76d6RH+oPHsLAATfrmL2BE15y" +
           "4wF38muMfMDDe9f8Ru2uk28qR+9dD+/aTu3fKzx89M5SzZ4Pgt1jrwjZqfeB" +
           "m72P5SfeTz7/4ktK/1Olnb3LTCOEzu09Wx4d0IeevPnRvpe/DR7esH3p+X++" +
           "f/SOxTNv4GHhoRNKnhT5O72Xv0K8Rf6VHej0wX3bda+Wx5meOn7LdtFXw8i3" +
           "R8fu2h44frkPfH766T3/P33jy/2bX0y9dRs4Jy6KTx2fsftuNmM58wuvccv8" +
           "gax4PoTetJBsxVRzppxQORKGixA6s3YM5TA+f/71biCOXeiG0F03eoza1/7t" +
           "b+hdCwTNfde9oG9ffeXPvnTp/L0vjf8qf8Q5eJm9wEDntcg0j16OHqmfc31V" +
           "M3JvXNhelbr510dD6N6baAaieVvJTfjIlv7XQ+jySfoQOpt/H6X7RAhdPKQD" +
           "oraVoyS/EUKnAUlW/U33Btd92zvi5NSRZNqDhXx2rrze7BywHH3jyRIw/w+G" +
           "/WSJtv/DcE3+3EsU+95X65/avjHJppSmmZTzDHTL9rnrIOEeuam0fVnnuk/8" +
           "8PbPX3h8Hxlu3yp8mAZHdHvoxg86HcsN8yeY9A/u/b2nf+ulb+a3j/8DN5Op" +
           "BFoiAAA=");
    }
    protected static void initializeViewport(org.apache.batik.bridge.BridgeContext ctx,
                                             org.w3c.dom.Element e,
                                             org.apache.batik.gvt.GraphicsNode node,
                                             float[] vb,
                                             java.awt.geom.Rectangle2D bounds) {
        float x =
          (float)
            bounds.
            getX(
              );
        float y =
          (float)
            bounds.
            getY(
              );
        float w =
          (float)
            bounds.
            getWidth(
              );
        float h =
          (float)
            bounds.
            getHeight(
              );
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio _par =
              (org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio)
                ie.
                getPreserveAspectRatio(
                  );
            _par.
              check(
                );
            java.awt.geom.AffineTransform at =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                w,
                h,
                _par,
                ctx);
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    x,
                    y));
            node.
              setTransform(
                at);
            java.awt.Shape clip =
              null;
            if (org.apache.batik.bridge.CSSUtilities.
                  convertOverflow(
                    e)) {
                float[] offsets =
                  org.apache.batik.bridge.CSSUtilities.
                  convertClip(
                    e);
                if (offsets ==
                      null) {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x,
                        y,
                        w,
                        h);
                }
                else {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x +
                          offsets[3],
                        y +
                          offsets[0],
                        w -
                          offsets[1] -
                          offsets[3],
                        h -
                          offsets[2] -
                          offsets[0]);
                }
            }
            if (clip !=
                  null) {
                try {
                    at =
                      at.
                        createInverse(
                          );
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      node.
                      getGraphicsNodeRable(
                        true);
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    node.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected static org.apache.batik.ext.awt.color.ICCColorSpaceExt extractColorSpace(org.w3c.dom.Element element,
                                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String colorProfileProperty =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_PROFILE_INDEX).
          getStringValue(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace =
          null;
        if (CSS_SRGB_VALUE.
              equalsIgnoreCase(
                colorProfileProperty)) {
            colorSpace =
              new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
                java.awt.color.ICC_Profile.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB),
                org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                  AUTO);
        }
        else
            if (!CSS_AUTO_VALUE.
                  equalsIgnoreCase(
                    colorProfileProperty) &&
                  !"".
                  equalsIgnoreCase(
                    colorProfileProperty)) {
                org.apache.batik.bridge.SVGColorProfileElementBridge profileBridge =
                  (org.apache.batik.bridge.SVGColorProfileElementBridge)
                    ctx.
                    getBridge(
                      SVG_NAMESPACE_URI,
                      SVG_COLOR_PROFILE_TAG);
                if (profileBridge !=
                      null) {
                    colorSpace =
                      profileBridge.
                        createICCColorSpaceExt(
                          ctx,
                          element,
                          colorProfileProperty);
                }
            }
        return colorSpace;
    }
    protected static java.awt.geom.Rectangle2D getImageBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element element) {
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                element;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            return new java.awt.geom.Rectangle2D.Float(
              x,
              y,
              w,
              h);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    org.apache.batik.gvt.GraphicsNode createBrokenImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                            org.w3c.dom.Element e,
                                                            java.lang.String uri,
                                                            java.lang.String message) {
        org.w3c.dom.svg.SVGDocument doc =
          ctx.
          getUserAgent(
            ).
          getBrokenLinkDocument(
            e,
            uri,
            org.apache.batik.bridge.Messages.
              formatMessage(
                URI_IMAGE_ERROR,
                new java.lang.Object[] { message }));
        return createSVGImageNode(
                 ctx,
                 e,
                 doc);
    }
    static org.apache.batik.bridge.SVGBrokenLinkProvider
      brokenLinkProvider =
      new org.apache.batik.bridge.SVGBrokenLinkProvider(
      );
    static { org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
               setBrokenLinkProvider(
                 brokenLinkProvider); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W5ga9GmlPuZ647QjZVkc1QbZYFKn9IkK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
