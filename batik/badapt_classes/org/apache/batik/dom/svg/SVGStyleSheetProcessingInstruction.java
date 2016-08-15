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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5o3/AlNBgH8FHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
