package org.apache.batik.dom.util;
public final class XMLSupport implements org.apache.batik.util.XMLConstants {
    private XMLSupport() { super(); }
    public static java.lang.String getXMLLang(org.w3c.dom.Element elt) { org.w3c.dom.Attr attr =
                                                                           elt.
                                                                           getAttributeNodeNS(
                                                                             XML_NAMESPACE_URI,
                                                                             "lang");
                                                                         if (attr !=
                                                                               null) {
                                                                             return attr.
                                                                               getNodeValue(
                                                                                 );
                                                                         }
                                                                         for (org.w3c.dom.Node n =
                                                                                elt.
                                                                                getParentNode(
                                                                                  );
                                                                              n !=
                                                                                null;
                                                                              n =
                                                                                n.
                                                                                  getParentNode(
                                                                                    )) {
                                                                             if (n.
                                                                                   getNodeType(
                                                                                     ) ==
                                                                                   org.w3c.dom.Node.
                                                                                     ELEMENT_NODE) {
                                                                                 attr =
                                                                                   ((org.w3c.dom.Element)
                                                                                      n).
                                                                                     getAttributeNodeNS(
                                                                                       XML_NAMESPACE_URI,
                                                                                       "lang");
                                                                                 if (attr !=
                                                                                       null) {
                                                                                     return attr.
                                                                                       getNodeValue(
                                                                                         );
                                                                                 }
                                                                             }
                                                                         }
                                                                         return "en";
    }
    public static java.lang.String getXMLSpace(org.w3c.dom.Element elt) {
        org.w3c.dom.Attr attr =
          elt.
          getAttributeNodeNS(
            XML_NAMESPACE_URI,
            "space");
        if (attr !=
              null) {
            return attr.
              getNodeValue(
                );
        }
        for (org.w3c.dom.Node n =
               elt.
               getParentNode(
                 );
             n !=
               null;
             n =
               n.
                 getParentNode(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                attr =
                  ((org.w3c.dom.Element)
                     n).
                    getAttributeNodeNS(
                      XML_NAMESPACE_URI,
                      "space");
                if (attr !=
                      null) {
                    return attr.
                      getNodeValue(
                        );
                }
            }
        }
        return "default";
    }
    public static java.lang.String defaultXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        boolean space =
          false;
        for (int i =
               0;
             i <
               nChars;
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    space =
                      false;
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        result.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    result.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return result.
          toString(
            ).
          trim(
            );
    }
    public static java.lang.String preserveXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        for (int i =
               0;
             i <
               data.
               length(
                 );
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                case '\t':
                    result.
                      append(
                        ' ');
                    break;
                default:
                    result.
                      append(
                        c);
            }
        }
        return result.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "B0QcHShlFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AWu2tq2SIgAA");
}
