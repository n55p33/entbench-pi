package org.apache.batik.svggen;
public class SVGCSSStyler implements org.apache.batik.svggen.SVGSyntax {
    private static final char CSS_PROPERTY_VALUE_SEPARATOR = ':';
    private static final char CSS_RULE_SEPARATOR = ';';
    private static final char SPACE = ' ';
    public static void style(org.w3c.dom.Node node) { org.w3c.dom.NamedNodeMap attributes =
                                                        node.
                                                        getAttributes(
                                                          );
                                                      if (attributes !=
                                                            null) {
                                                          org.w3c.dom.Element element =
                                                            (org.w3c.dom.Element)
                                                              node;
                                                          java.lang.StringBuffer styleAttrBuffer =
                                                            new java.lang.StringBuffer(
                                                            );
                                                          int nAttr =
                                                            attributes.
                                                            getLength(
                                                              );
                                                          java.util.List toBeRemoved =
                                                            new java.util.ArrayList(
                                                            );
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nAttr;
                                                               i++) {
                                                              org.w3c.dom.Attr attr =
                                                                (org.w3c.dom.Attr)
                                                                  attributes.
                                                                  item(
                                                                    i);
                                                              java.lang.String attrName =
                                                                attr.
                                                                getName(
                                                                  );
                                                              if (org.apache.batik.svggen.SVGStylingAttributes.
                                                                    set.
                                                                    contains(
                                                                      attrName)) {
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attrName);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_PROPERTY_VALUE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      attr.
                                                                        getValue(
                                                                          ));
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      CSS_RULE_SEPARATOR);
                                                                  styleAttrBuffer.
                                                                    append(
                                                                      SPACE);
                                                                  toBeRemoved.
                                                                    add(
                                                                      attrName);
                                                              }
                                                          }
                                                          if (styleAttrBuffer.
                                                                length(
                                                                  ) >
                                                                0) {
                                                              element.
                                                                setAttributeNS(
                                                                  null,
                                                                  SVG_STYLE_ATTRIBUTE,
                                                                  styleAttrBuffer.
                                                                    toString(
                                                                      ).
                                                                    trim(
                                                                      ));
                                                              int n =
                                                                toBeRemoved.
                                                                size(
                                                                  );
                                                              for (int i =
                                                                     0;
                                                                   i <
                                                                     n;
                                                                   i++) {
                                                                  element.
                                                                    removeAttribute(
                                                                      (java.lang.String)
                                                                        toBeRemoved.
                                                                        get(
                                                                          i));
                                                              }
                                                          }
                                                      }
                                                      org.w3c.dom.NodeList children =
                                                        node.
                                                        getChildNodes(
                                                          );
                                                      int nChildren =
                                                        children.
                                                        getLength(
                                                          );
                                                      for (int i =
                                                             0;
                                                           i <
                                                             nChildren;
                                                           i++) {
                                                          org.w3c.dom.Node child =
                                                            children.
                                                            item(
                                                              i);
                                                          style(
                                                            child);
                                                      }
    }
    public SVGCSSStyler() { super(); }
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
      ("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");
}
