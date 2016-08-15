package org.apache.batik.dom.svg;
public class SVGStyleSheetProcessingInstruction extends org.apache.batik.dom.StyleSheetProcessingInstruction implements org.apache.batik.css.engine.CSSStyleSheetNode {
    protected org.apache.batik.css.engine.StyleSheet styleSheet;
    protected SVGStyleSheetProcessingInstruction() { super(); }
    public SVGStyleSheetProcessingInstruction(java.lang.String data, org.apache.batik.dom.AbstractDocument owner,
                                              org.apache.batik.dom.StyleSheetFactory f) {
        super(
          data,
          owner,
          f);
    }
    public java.lang.String getStyleSheetURI() { org.apache.batik.dom.svg.SVGOMDocument svgDoc =
                                                   (org.apache.batik.dom.svg.SVGOMDocument)
                                                     getOwnerDocument(
                                                       );
                                                 org.apache.batik.util.ParsedURL url =
                                                   svgDoc.
                                                   getParsedURL(
                                                     );
                                                 java.lang.String href =
                                                   (java.lang.String)
                                                     getPseudoAttributes(
                                                       ).
                                                     get(
                                                       "href");
                                                 if (url !=
                                                       null) {
                                                     return new org.apache.batik.util.ParsedURL(
                                                       url,
                                                       href).
                                                       toString(
                                                         );
                                                 }
                                                 return href;
    }
    public org.apache.batik.css.engine.StyleSheet getCSSStyleSheet() {
        if (styleSheet ==
              null) {
            org.apache.batik.dom.util.HashTable attrs =
              getPseudoAttributes(
                );
            java.lang.String type =
              (java.lang.String)
                attrs.
                get(
                  "type");
            if ("text/css".
                  equals(
                    type)) {
                java.lang.String title =
                  (java.lang.String)
                    attrs.
                    get(
                      "title");
                java.lang.String media =
                  (java.lang.String)
                    attrs.
                    get(
                      "media");
                java.lang.String href =
                  (java.lang.String)
                    attrs.
                    get(
                      "href");
                java.lang.String alternate =
                  (java.lang.String)
                    attrs.
                    get(
                      "alternate");
                org.apache.batik.dom.svg.SVGOMDocument doc =
                  (org.apache.batik.dom.svg.SVGOMDocument)
                    getOwnerDocument(
                      );
                org.apache.batik.util.ParsedURL durl =
                  doc.
                  getParsedURL(
                    );
                org.apache.batik.util.ParsedURL burl =
                  new org.apache.batik.util.ParsedURL(
                  durl,
                  href);
                org.apache.batik.css.engine.CSSEngine e =
                  doc.
                  getCSSEngine(
                    );
                styleSheet =
                  e.
                    parseStyleSheet(
                      burl,
                      media);
                styleSheet.
                  setAlternate(
                    "yes".
                      equals(
                        alternate));
                styleSheet.
                  setTitle(
                    title);
            }
        }
        return styleSheet;
    }
    public void setData(java.lang.String data)
          throws org.w3c.dom.DOMException {
        super.
          setData(
            data);
        styleSheet =
          null;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGStyleSheetProcessingInstruction(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5o3/AvzqKGYFHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7X4JJwAA");
}
