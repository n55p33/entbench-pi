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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
