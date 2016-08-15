package org.apache.batik.bridge;
public class URIResolver {
    protected org.apache.batik.dom.svg.SVGOMDocument document;
    protected java.lang.String documentURI;
    protected org.apache.batik.bridge.DocumentLoader documentLoader;
    public URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          );
        document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            doc;
        documentLoader =
          dl;
    }
    public org.w3c.dom.Element getElement(java.lang.String uri, org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException { org.w3c.dom.Node n = getNode(
                                                     uri,
                                                     ref);
                              if (n == null) { return null;
                              }
                              else
                                  if (n.
                                        getNodeType(
                                          ) ==
                                        org.w3c.dom.Node.
                                          DOCUMENT_NODE) {
                                      throw new java.lang.IllegalArgumentException(
                                        );
                                  }
                                  else {
                                      return (org.w3c.dom.Element)
                                               n;
                                  } }
    public org.w3c.dom.Node getNode(java.lang.String uri,
                                    org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException,
        java.lang.SecurityException { java.lang.String baseURI =
                                        getRefererBaseURI(
                                          ref);
                                      if (baseURI ==
                                            null &&
                                            uri.
                                            charAt(
                                              0) ==
                                            '#') {
                                          return getNodeByFragment(
                                                   uri.
                                                     substring(
                                                       1),
                                                   ref);
                                      }
                                      org.apache.batik.util.ParsedURL purl =
                                        new org.apache.batik.util.ParsedURL(
                                        baseURI,
                                        uri);
                                      if (documentURI ==
                                            null)
                                          documentURI =
                                            document.
                                              getURL(
                                                );
                                      java.lang.String frag =
                                        purl.
                                        getRef(
                                          );
                                      if (frag !=
                                            null &&
                                            documentURI !=
                                            null) {
                                          org.apache.batik.util.ParsedURL pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                            documentURI);
                                          if (pDocURL.
                                                sameFile(
                                                  purl)) {
                                              return document.
                                                getElementById(
                                                  frag);
                                          }
                                      }
                                      org.apache.batik.util.ParsedURL pDocURL =
                                        null;
                                      if (documentURI !=
                                            null) {
                                          pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                              documentURI);
                                      }
                                      org.apache.batik.bridge.UserAgent userAgent =
                                        documentLoader.
                                        getUserAgent(
                                          );
                                      userAgent.
                                        checkLoadExternalResource(
                                          purl,
                                          pDocURL);
                                      java.lang.String purlStr =
                                        purl.
                                        toString(
                                          );
                                      if (frag !=
                                            null) {
                                          purlStr =
                                            purlStr.
                                              substring(
                                                0,
                                                purlStr.
                                                  length(
                                                    ) -
                                                  (frag.
                                                     length(
                                                       ) +
                                                     1));
                                      }
                                      org.w3c.dom.Document doc =
                                        documentLoader.
                                        loadDocument(
                                          purlStr);
                                      if (frag !=
                                            null)
                                          return doc.
                                            getElementById(
                                              frag);
                                      return doc;
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        return ((org.apache.batik.dom.AbstractNode)
                  ref).
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        return ref.
          getOwnerDocument(
            ).
          getElementById(
            frag);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5fPf5J+see+/C8A4YysbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
