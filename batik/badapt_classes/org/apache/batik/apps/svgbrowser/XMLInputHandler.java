package org.apache.batik.apps.svgbrowser;
public class XMLInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] XVG_MIME_TYPES = { "image/xml+xsl+svg" };
    public static final java.lang.String[] XVG_FILE_EXTENSIONS = { ".xml",
    ".xsl" };
    public static final java.lang.String ERROR_NO_XML_STYLESHEET_PROCESSING_INSTRUCTION =
      ("XMLInputHandler.error.no.xml.stylesheet.processing.instructi" +
       "on");
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_NOT_SVG =
      "XMLInputHandler.error.transform.output.not.svg";
    public static final java.lang.String ERROR_TRANSFORM_PRODUCED_NO_CONTENT =
      "XMLInputHandler.error.transform.produced.no.content";
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_WRONG_NS =
      "XMLInputHandler.error.transform.output.wrong.ns";
    public static final java.lang.String ERROR_RESULT_GENERATED_EXCEPTION =
      "XMLInputHandler.error.result.generated.exception";
    public static final java.lang.String XSL_PROCESSING_INSTRUCTION_TYPE =
      "text/xsl";
    public static final java.lang.String PSEUDO_ATTRIBUTE_TYPE = "type";
    public static final java.lang.String PSEUDO_ATTRIBUTE_HREF = "href";
    public java.lang.String[] getHandledMimeTypes() { return XVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return XVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return "";
    }
    public boolean accept(java.io.File f) { return f.isFile(
                                                       ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null) {
                                                       return false;
                                                   }
                                                   for (int i =
                                                          0;
                                                        i <
                                                          XVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               XVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public void handle(org.apache.batik.util.ParsedURL purl,
                       org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame)
          throws java.lang.Exception { java.lang.String uri =
                                         purl.
                                         toString(
                                           );
                                       javax.xml.transform.TransformerFactory tFactory =
                                         javax.xml.transform.TransformerFactory.
                                         newInstance(
                                           );
                                       javax.xml.parsers.DocumentBuilderFactory dbf =
                                         javax.xml.parsers.DocumentBuilderFactory.
                                         newInstance(
                                           );
                                       dbf.
                                         setValidating(
                                           false);
                                       dbf.
                                         setNamespaceAware(
                                           true);
                                       javax.xml.parsers.DocumentBuilder db =
                                         dbf.
                                         newDocumentBuilder(
                                           );
                                       org.w3c.dom.Document inDoc =
                                         db.
                                         parse(
                                           uri);
                                       java.lang.String xslStyleSheetURI =
                                         extractXSLProcessingInstruction(
                                           inDoc);
                                       if (xslStyleSheetURI ==
                                             null) {
                                           xslStyleSheetURI =
                                             uri;
                                       }
                                       org.apache.batik.util.ParsedURL parsedXSLStyleSheetURI =
                                         new org.apache.batik.util.ParsedURL(
                                         uri,
                                         xslStyleSheetURI);
                                       javax.xml.transform.Transformer transformer =
                                         tFactory.
                                         newTransformer(
                                           new javax.xml.transform.stream.StreamSource(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       transformer.
                                         setURIResolver(
                                           new org.apache.batik.apps.svgbrowser.XMLInputHandler.DocumentURIResolver(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       java.io.StringWriter sw =
                                         new java.io.StringWriter(
                                         );
                                       javax.xml.transform.stream.StreamResult result =
                                         new javax.xml.transform.stream.StreamResult(
                                         sw);
                                       transformer.
                                         transform(
                                           new javax.xml.transform.dom.DOMSource(
                                             inDoc),
                                           result);
                                       sw.
                                         flush(
                                           );
                                       sw.
                                         close(
                                           );
                                       java.lang.String parser =
                                         org.apache.batik.util.XMLResourceDescriptor.
                                         getXMLParserClassName(
                                           );
                                       org.apache.batik.dom.svg.SAXSVGDocumentFactory f =
                                         new org.apache.batik.dom.svg.SAXSVGDocumentFactory(
                                         parser);
                                       org.w3c.dom.svg.SVGDocument outDoc =
                                         null;
                                       try {
                                           outDoc =
                                             f.
                                               createSVGDocument(
                                                 uri,
                                                 new java.io.StringReader(
                                                   sw.
                                                     toString(
                                                       )));
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           java.lang.System.
                                             err.
                                             println(
                                               sw.
                                                 toString(
                                                   ));
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           throw new java.lang.IllegalArgumentException(
                                             org.apache.batik.apps.svgbrowser.Resources.
                                               getString(
                                                 ERROR_RESULT_GENERATED_EXCEPTION));
                                       }
                                       svgViewerFrame.
                                         getJSVGCanvas(
                                           ).
                                         setSVGDocument(
                                           outDoc);
                                       svgViewerFrame.
                                         setSVGDocument(
                                           outDoc,
                                           uri,
                                           outDoc.
                                             getTitle(
                                               ));
    }
    protected void checkAndPatch(org.w3c.dom.Document doc) {
        org.w3c.dom.Element root =
          doc.
          getDocumentElement(
            );
        org.w3c.dom.Node realRoot =
          root.
          getFirstChild(
            );
        java.lang.String svgNS =
          org.apache.batik.dom.svg.SVGDOMImplementation.
            SVG_NAMESPACE_URI;
        if (realRoot ==
              null) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_PRODUCED_NO_CONTENT));
        }
        if (realRoot.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE ||
              !org.apache.batik.util.SVGConstants.
                 SVG_SVG_TAG.
              equals(
                realRoot.
                  getLocalName(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_NOT_SVG));
        }
        if (!svgNS.
              equals(
                realRoot.
                  getNamespaceURI(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_WRONG_NS));
        }
        org.w3c.dom.Node child =
          realRoot.
          getFirstChild(
            );
        while (child !=
                 null) {
            root.
              appendChild(
                child);
            child =
              realRoot.
                getFirstChild(
                  );
        }
        org.w3c.dom.NamedNodeMap attrs =
          realRoot.
          getAttributes(
            );
        int n =
          attrs.
          getLength(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            root.
              setAttributeNode(
                (org.w3c.dom.Attr)
                  attrs.
                  item(
                    i));
        }
        root.
          removeChild(
            realRoot);
    }
    protected java.lang.String extractXSLProcessingInstruction(org.w3c.dom.Document doc) {
        org.w3c.dom.Node child =
          doc.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    PROCESSING_INSTRUCTION_NODE) {
                org.w3c.dom.ProcessingInstruction pi =
                  (org.w3c.dom.ProcessingInstruction)
                    child;
                org.apache.batik.dom.util.HashTable table =
                  new org.apache.batik.dom.util.HashTable(
                  );
                org.apache.batik.dom.util.DOMUtilities.
                  parseStyleSheetPIData(
                    pi.
                      getData(
                        ),
                    table);
                java.lang.Object type =
                  table.
                  get(
                    PSEUDO_ATTRIBUTE_TYPE);
                if (XSL_PROCESSING_INSTRUCTION_TYPE.
                      equals(
                        type)) {
                    java.lang.Object href =
                      table.
                      get(
                        PSEUDO_ATTRIBUTE_HREF);
                    if (href !=
                          null) {
                        return href.
                          toString(
                            );
                    }
                    else {
                        return null;
                    }
                }
            }
            child =
              child.
                getNextSibling(
                  );
        }
        return null;
    }
    public class DocumentURIResolver implements javax.xml.transform.URIResolver {
        java.lang.String documentURI;
        public DocumentURIResolver(java.lang.String documentURI) {
            super(
              );
            this.
              documentURI =
              documentURI;
        }
        public javax.xml.transform.Source resolve(java.lang.String href,
                                                  java.lang.String base) {
            if (base ==
                  null ||
                  "".
                  equals(
                    base)) {
                base =
                  documentURI;
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              base,
              href);
            return new javax.xml.transform.stream.StreamSource(
              purl.
                toString(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "eUGsf1408fHMfwEGs5x4aBYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZecwrV3Wf9701LyHvJSEhDWTlhTYx+sbr2NZjsz3eZ8b2" +
           "bLanLY/Z98Wz2DMDoYDUkpYKEE0olSB/gdqisKgqaqWKKlUXQKBKVKibVEBV" +
           "pdJSVPJHaVXa0jvj7/v8fd97SQp/1JKvr+89595z7jnnN2fOff570PnAhwqe" +
           "ayWq5Yb7chzuG1ZtP0w8OdgfYbUp7wey1LH4IKDB2A3xsc9f+cEPP6xd3YMu" +
           "cNA9vOO4IR/qrhOQcuBaa1nCoCu70a4l20EIXcUMfs3DUahbMKYH4XUMuv0Y" +
           "awhdww5FgIEIMBABzkWAWzsqwPQq2YnsTsbBO2Gwgt4NncGgC56YiRdCj55c" +
           "xON93j5YZpprAFa4lP1ngVI5c+xDjxzpvtX5JoWfLcDP/Prbr/7OWegKB13R" +
           "HSoTRwRChGATDrrDlm1B9oOWJMkSB93lyLJEyb7OW3qay81Bdwe66vBh5MtH" +
           "h5QNRp7s53vuTu4OMdPNj8TQ9Y/UU3TZkg7/nVcsXgW63rfTdathLxsHCl7W" +
           "gWC+wovyIcs5U3ekEHr4NMeRjtfGgACwXrTlUHOPtjrn8GAAuntrO4t3VJgK" +
           "fd1RAel5NwK7hNADL7lodtYeL5q8Kt8IoftP0023U4DqtvwgMpYQuvc0Wb4S" +
           "sNIDp6x0zD7fI970wXc6A2cvl1mSRSuT/xJgeugUEykrsi87orxlvONJ7KP8" +
           "fV98eg+CAPG9p4i3NL/3rhff9saHXvjylua1t6CZCIYshjfETwp3fv11nSea" +
           "ZzMxLnluoGfGP6F57v7Tg5nrsQci776jFbPJ/cPJF8g/W77n0/J396DLQ+iC" +
           "6FqRDfzoLtG1Pd2S/b7syD4fytIQuk12pE4+P4Qugj6mO/J2dKIogRwOoXNW" +
           "PnTBzf+DI1LAEtkRXQR93VHcw77Hh1rejz0Igm4HX+g6BJ15K5R/tr8hJMKa" +
           "a8swL/KO7rjw1Hcz/QNYdkIBnK0GC8DrTThwIx+4IOz6KswDP9Dkgwne8wI4" +
           "WKuC724C2YcXODZ0vCgc8I4EVNvPnM37/9kmzrS9ujlzBhjidadhwAIRNHAt" +
           "SfZviM9E7e6Ln73x1b2jsDg4pxBCwc7725338533s533dzvvn9r5GuqKkQ3U" +
           "YMjhQeD70JkzuRCvzqTaegKwowkQAWDlHU9QPz96x9OPnQUu6G3OZaYApPBL" +
           "Q3ZnhyHDHClF4MjQCx/bvJf9heIetHcSezNNwNDljH2aIeYRMl47HXO3WvfK" +
           "+7/zg8999Cl3F30nwPwAFG7mzIL6sdNn7ruiLAGY3C3/5CP8F2588alre9A5" +
           "gBQAHUMeeDMAnodO73EiuK8fAmWmy3mgsOL6Nm9lU4fodjnUgIF2I7kz3Jn3" +
           "7wJnfCXz9sfAWbcP3D//zWbv8bL21VvnyYx2SosciN9MeZ/46z//p0p+3IeY" +
           "feXYU5CSw+vHcCJb7EqOCHftfID2ZRnQ/d3Hpr/27Pfe/7O5AwCK199qw2tZ" +
           "2wH4AEwIjvkXv7z6m29985Pf2Ns5TQgelJFg6WJ8pOSlTKc7X0ZJsNsbdvIA" +
           "nLFAEGZec41xbFfSFZ0XLDnz0v+68njpC//ywatbP7DAyKEbvfGVF9iN/1Qb" +
           "es9X3/7vD+XLnBGz59zuzHZkW/C8Z7dyy/f5JJMjfu9fPPgbX+I/AWAYQF+g" +
           "p3KOZmcOAicT6l6Qj+Sc2SNtf/tIy60J59NP5u1+dhI5E5TPVbLm4eB4VJwM" +
           "vGOJyg3xw9/4/qvY7//hi7kaJzOd406A8971rd9lzSMxWP41pyFgwAcaoKu+" +
           "QPzcVeuFH4IVObCiCEAvmPgAneITLnNAff7i3/7RH9/3jq+fhfZ60GXL5aUe" +
           "n0cfdBtweznQALDF3lvftjX7JvODq7mq0E3Kb73l/vzfOSDgEy8NPL0sUdnF" +
           "7v3/ObGE9/39f9x0CDnk3OL5fIqfg5//+AOdt3w359/Ffsb9UHwzYoOkbsdb" +
           "/rT9b3uPXfjTPegiB10VDzJGlreiLKI4kCUFh2kkyCpPzJ/MeLaP9+tH2Pa6" +
           "07hzbNvTqLN7UoB+Rp31L58CmjwGXwt888AY29/jQHMGyjutnOXRvL2WNT99" +
           "YKHtUj8CnzPg+z/ZNxvPBraP7Ls7B3nDI0eJgwceXbdLuydRtkRxi2hZW82a" +
           "9nbl+ku6yZuyphufAdByvrxf388XGN1azLNZ92cABgV5+gw4FN3hrfwwuiFw" +
           "e0u8digmC9Jp4CfXDKt+K7m6/2e5gLveuYt0zAWp6wf+4cNf+9DrvwV8agSd" +
           "X2f2Bq50DA6IKMvmf+n5Zx+8/ZlvfyCHT2AT9j2P/2ueG1Evp13WEFkzOVTr" +
           "gUwtKs9RMD4I8RzxZCnT7OVDaerrNngwrA9SVfipu79lfvw7n9mmoafj5hSx" +
           "/PQzv/Kj/Q8+s3cs+X/9Tfn3cZ7tC0Au9KsOTtiHHn25XXKO3j9+7qk/+K2n" +
           "3r+V6u6TqWwXvKl95i//+2v7H/v2V26RN52zgDV+YsOGd/zJoBoMW4cfrLTk" +
           "qxsmjgdRZREmlXZQTfCuJKLIRu7PFl2T6KL2FBVtcV5v9Eet2izAmfVamMDh" +
           "ZpLiODFF61wJbZn6PCEL2LKHxEunpg2paYNpz3ydJAWyx+nzYlUvU8vpKB2P" +
           "TKM5GbQpY9ytMo2Vv3K8MudIZbTREZ0KE6+lCltiYXaxKC2mJS4yNwI3nDaJ" +
           "mtEtcOmwSiCVBJ8bAjaiyVW5HmkYMhF9hIDLCqwZaokseqpdn7ErI/EZTsdX" +
           "xcqobK8pLwrKnm+06+0yXnPQno1zIUcm2gKlS0RtZZUDW1utVljCUNMB02+t" +
           "Q3Zs6pVRtGLtQYBQvjqaFHqTjYk5S6oSb+SBuSLZgNl4lTRuzwYx2W91R8t1" +
           "YW4sHWAxtNnSiUkpZau6w9ZM3NKRTYLOS6uZQVSNEVutjzvl1Fm0myGFjDUR" +
           "XxNpnMglWmPqmmpYTGlTjFKMqODSemb4bVF36OpaxPlxczVIWGm4WPo4qmop" +
           "7qkrLF4NSHmy4QmLX2y8cqXBFb2autFQu+GPHZIdtFGnk4Rsf0TpMScRc0JP" +
           "kY5mC1FZb1hqncSmc9uyrKXlsI3F1CFgpcAXkaLXtQe8WzDCkFy2cbFn2uis" +
           "ZMZJEtfFpD4QbYfyREIzUgLzOBepc7ViiJQmyGhWF6exFZY7zjIdYf7EqXeC" +
           "KilguKiR0Zwr1eQW7jdLHLpAWvSyHE2FsV4UN4vqJujOewZr1Tq+lnrNmcKs" +
           "GXFUXaN4uhHacaPX4gye7VON5UDDSnLATICVtKHWby6d6qTbnjoblGyreIsf" +
           "DKgJQlBNjB1ZDFFUbWZmUv0aTptdxp90h5XWeARPO0tzSDu90RrI3KlVgBEa" +
           "vDMI5QrCdimVrjj2GNNgW0G9aX3m9YpBmmz6ItVywlUNd3i86dcQvKtinUYR" +
           "6zDRsr6o10uNiV/gy82xvWRK3ICz0XTc42okVla4Sk9n58LYQAWaErRVRa+y" +
           "0hJbjYK0XeTGntPC0bJMagluzeR1XfHJXrUpLclmj2Iiiuis+jVt1iZL5TFD" +
           "k6zB2lN8VOIsjBDNINZlvarF3sTsSK7HzuVEKosFIZ3Io+mcR/puMe43NwxZ" +
           "Y9xhyLvjykrmpyKhm2t9IIxGQxrXnEZCdg1zSGGF2iiggZtudD2e9PiVH2ld" +
           "JdgkxUq1ilbLdDusstWe1YbH/apgqMzMaK/n5GjTQVUfH/AdmxeVcBgTXFJT" +
           "u4Qbw0uaYkvd8kBACAQ1E2woGTjcaCQjgSyn9sxsqXI87m7QvknPCHOK4VRk" +
           "OIN+GSWaCK5Mylpb72ty4NC+0EmMfk00k2CAT9glXB8HEjpWSwERU3anvwjL" +
           "I6nSCouqOTSWca8iWuYMdeSWumxRek0SF9VlM5g67cRtbXTehIEenRbCjPp8" +
           "16iFFmYW3HrKVGi+2cQFvoRMzKk5R1biUFrZfbs8j4nWUPS05mYjNEqd4nqU" +
           "xrVRqx50TC42x8mmV0o5El10KkQ71Nswl+LoXHW5lMerioHL/MKGA7vUqU0H" +
           "zUqtRHNkd9zEe1hotuihQsc11JyCDkoQXUwoSnSlXk2YtWNobmHJ0qZTwXh/" +
           "tBoRatJdkqMyXeS4aEkVTMcpIeP2ppBsVKlb1VrDrl9oED47RUlm5AiAzMZR" +
           "bT3vzldVFuXipNxojYxE3pCFqEjWsaCjtzZEsTXpxPGytGyIAjnQJkojWcjd" +
           "uaiNi3QkD1BRmfKLKVxBueq8npRte1hqKQaKF3rjVpklliE1TjGtUIr0tD8r" +
           "FNBOmSAcIUVqdLk1H00QPwSGmGpEi190utXJ0qkYaQO2m9ECc+XmYjAZCmJ9" +
           "Tukk5SFkOtfoQlzGNWI+L8BBmw+pFhG3SmolLG7GMs+Wrfky1pZwIV6Ga56d" +
           "phV2vOirM6bBkav12g/QNdyczcUoDeEF7PfKrt5ZcXalLBfsCV2fCHU75bie" +
           "V2kp4C1+3QTSoIobcK2aypciiXPHrWEZCarIcj4bMzZnD+dGYAZYt5Y6pCYP" +
           "a9Wp21G6ow7WJ6K2YZNlXA/8VqdJzvvygmkuYaHp1BtlvaSRNhv3VLo9RueD" +
           "0aS+CYRNFwEnOp8HQjgL1GajUxqw8Ko0rkttt+QVx2qLbgZ1jEIZRmXNxcTu" +
           "exbcrE7ncqsAM6asDnmpi9tapA3X/hAbtprBZt2KqUXqLhUrYBo6aqx6K54e" +
           "F8bupDlN9bItIguUqk2GC6/eqMPNQMB65cawMLKouDieCprEFsdFt6GUh2sY" +
           "k2uVWrkgr52RPSeD/si21TUxhztTh/XL8QQuLCI2mS1apY5nzOAB3UAMqd6t" +
           "BYXummh6wYBTkcXKanFBXYSb6WihLxAcNegCbq6WRYSlRdNx1yUywSspxZgL" +
           "vpa6fBKVx41Ap5imWJjFCIVt9M1ijgo4CNuVRnPjZT0IyX4AkE7p4II2wJrN" +
           "9twNZsWFxtCYpUx7il5tEu3pQF/ZUUHVvSk3oRvNZVNCEs6pwuimwFiYoNbn" +
           "rfFQieKGuBKK5VjjuM2AZEy/g1KVfmux7FR6lMmEsV5elWsqtnT7nZY4iQSE" +
           "p+YjOrWKiBhxhlCQYl4XnSgxRmm/D0AeThuLtDBZKEY4T9mVbQoVysK5llNk" +
           "h3Rr5atuwTFqLoihen1TmgiYvViq03ohalJ0hK7jOdpOPNsY+wlLFOuNYKFU" +
           "vGDclhFV6LlSo88KNXhisGFc43wvmehORLYHPqvwXlK0Wta6FwRtTWopC7GX" +
           "TOCUIcaoO1FRslqojtu25wih38JTTAcAg/Lz4Qo1yFVLiZrMqASryIgkNuNx" +
           "RyIsl1T6/LwZsi0E08MEK3cSaaMv4Wq/FlCEZhk6xyBEhNlNMxWK8yrA2Da7" +
           "qCiOtWBZpFEmug24MJYXG9WUYWXEBm2zEvaLwz4OwrBsx8p41ejxfq3TpNeo" +
           "ypQGijDoiCGsNjVTLzp0Y9yLJpxJR37c4yhJU10Nw8ORWlEHtWW9w/tVMca8" +
           "oN2dT0R2OBiGakMIl+40oQ0rGbYVpz2ltbS6xgIpQkVr3pZ0dhhMiYgZSpOZ" +
           "068b/QWRFKpwT0BqBVribb0oW54o9qYmxXFDJyTXA7IvzFnJkMJ5pV+DZYlP" +
           "VsN1gPmWNq0v5227o6g9NQkWtIuSbNhctRdRvQTzMuFPU4crdJANglYpldS5" +
           "AGkgRI3D2wUtXTRcp4i3BtNSj0BXpSpn+zSyThQlKa+MwoofJonC8DVFiZJm" +
           "cRNEM4mpTYomr07bHEXRIQB1BFstxUAam7QwH1D1dq84HlEYY/MDttisY20T" +
           "AwHVlRhGLxparylLAltdV2y32ucNhLOmBqbqbFmn0lDTJ442abTdFCRkZIOi" +
           "XNqdT3h3ZhWMisyISBimiSasm0IMs1NJovCZTS7sNsFUykx9Pmw6apzMFYkO" +
           "LEmpDmAd28BluBEXpwPUiVGFIzYgdQoaAlKcdU03LrjJih3QGL6eL2jO0tGE" +
           "MOq4VZ+AFCbEQgD8KVIxGjLTD5RStdhQBriy6faDWlzl20vw0vLmN2evM9KP" +
           "90Z5V/6ifHRz8xO8Im+nHs2ax4+qEHkl4fLpav/xSuCuCnRURXs4L6Lvx7a1" +
           "H/q8E2RF1v1jZe3sLfLBl7q4yd8gP/m+Z56TJp8q7R1U2W6E0IWD+7Tj+/nQ" +
           "ky/9qoznl1a70s+X3vfPD9Bv0d7xY1S6Hz4l5Oklfxt//iv9N4gf2YPOHhWC" +
           "brpOO8l0/WT557Ivh5Hv0CeKQA8eHf992Wk/CFTtHRx/79bV5lu6ypncVbYO" +
           "cqqCuZcT7B25SDGnetfL1DnfnTWbELrob414aOsHbmXrbWVj53bxK73Anygs" +
           "htA9t7gLOdyw+ONerAAvuf+mu9zt/aP42eeuXHrNc8xf5dcIR3eEt2HQJSWy" +
           "rONlumP9C54vK3p+Krdti3Ze/vPLIfTIKwkXQpd3f3KVnt4y/2oI3XtL5hA6" +
           "l/0cp/1QCF09TRtC5/Pf43QfAbvt6EAIbTvHSZ4NobOAJOt+1LtFFXxb5ozP" +
           "HAu7A6DIDXv3Kxn2iOX49UQWqvkl/GFYRdtr+Bvi554bEe98EfnU9npEtPg0" +
           "zVa5hEEXtzc1R6H56EuudrjWhcETP7zz87c9foghd24F3gXMMdkevvVdRNf2" +
           "wvz2IP391/zum37zuW/mdb//Bcy8oxodIQAA");
    }
    public XMLInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IFJkhtNedTOb1BErmJuxMtDFOhNRg3qK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jhHebPpMj4TaukEMUM6dYPwabQ6XkIolSd/PhR0L7RCC7G1jtGsu4Ma63ev3" +
       "lPYihdEUTMBo2uQkE1GInjPjGRdwnxR2HZzGZKe307q0SWwZZWCMloNUjNf5" +
       "1swn+Shz00RklFyOWFxArJ1jprs6J5GYNiZq4koJEEZGag1JxBZ8L1cMVQrG" +
       "i6ZHRvpkpSIM23I4MZYHvEFOBRYkgNgUNudEo2lBjTlV54QYWXJG0NIgGTSC" +
       "YRBkeEvQYgpM02MGne6GjXmHauhszOSLmjRHt62RLuipOxAmPj3NTC0Sem6a" +
       "JnhXjIYs6+2cdNlfduV6sKgRtd0OWgitrTzzzERmPT6nKVOoqssB2Uh5rU8m" +
       "uSvX1XbbcVeRutaQblZbdlaS27SZyZjMZYUhoWpdBivGjtznNlCLaI5doQ4h" +
       "sA4816qthhSBDDEMNRFYgJRt3e/NjeE4FIK8zQ/Sfg2K+ninLU0GSlpvy7zm" +
       "Vpld6tktg4Z4rZHOtUmgKnkL1iauD8/IjCKWkieZ1lBrVmOtqm+2tGnjLbJu" +
       "Tq25Ts2X3Gq4wXZsFdlxW33W3arz5nyA1cHy1mw43EbTFnQEtLCBfbvP01Ml" +
       "mHutASZFxbMYPEnH6rgFw/RsjFZ73S7HD9fLhgPCIJoO6g5Vm0h+gOizAAcc" +
       "V42a0EwwNU5mIT1qWGCJ1MXEoTPQZssQRdEPFY/tvnG1x4lvLp+Snu6g/QGe" +
       "j+5vvaso3nP6pLn8u7dy+61o57brHJy8HW+95h5EfgvyYN1Wz7/8KF76v/N2" +
       "22rLF/5f/OTLryjsl+Brxy+EF1Hlgcjz/46t7lT7nCAPlOfSzXs63gsO6RiE" +
       "dPFx+ZmablH4QanwvZrv8HL6j+5w75tF8QdR5QldPQarMKajnu7/o84M9Iev" +
       "9Uj3fN+XwXwfOIxjmMYbD/PP73DvW0Xxp1HlLWcwiTRS3fBkE8M5nP/1deB8" +
       "vLh4HRzeMU7vjcf5F3e4972i+E5UeQTgxNVQDszTd3P0GcLvvg6ETxQXfwgc" +
       "u2OEuzcG4cHNcfrQyS6WvmmrRYODg9vDPrinuPhXUeXeYjegH132kuK+tefZ" +
       "quSeaeGv3wgtvHishRf/n2jhmVvYar/1vfzuYsbRJfjH76CYtxbFw6eKKX7d" +
       "d6qBg0feCA28dKyBl95QDZQeW0K4fgd47y6KH74dvHe8DnhvKi4Wm1t++Rje" +
       "L78x8K6d7n07eOLEyq+9L37Ii6Roqoka9APJ2cfDB+7sOue2iBEnr+jLdsV7" +
       "zoP3Ap0ZJQ9e+kJv55nKmR7f9zr0+Ehx8RAc3zvW4/euokcwifqBF6lypCp/" +
       "m3h5S6HJpCEfKp5ziHty7KhuVKJ+4Q5eVGQrBz8aVR4GBpA3qKtMpEgu3pse" +
       "NM+UcON1KKHYglBpAjmv79vu/1/BmQ4+/BqxcoCWSMZ3QDkpCgpwippGgSRH" +
       "C56enG6/om7efXU2VxwMr4I7jSqPXtg3UmxCf/st343tv3WSv/LKo/e/7ZXZ" +
       "f9xvkz35HukBunK/Ftv2+T3D587v9QNVM0uFPLDfQeyXAIHjXn+tSIoqD579" +
       "KMQ/EPeNV1HlyUsbg2go/p2v+9Go8tjFulHlnvL/+XofA6Od1StYqjw5X0WO" +
       "KneBKsWp4p948bn3+vs91+nBuQzy2LvKKezx1zLOaZPzn0cU2z3LD/5OtmbG" +
       "+0/+juSvvjIcf/y77S/tP8+QbSnPi17upyv37b8UKTsttne+67a9nfR17+D5" +
       "7z/yaw+85yQjfmQv8Jmnn5Ptmcu/fyAcPyq/WMj/xdv+2Qf/0St/XG5s+L+B" +
       "YUH0iTkAAA==");
}
