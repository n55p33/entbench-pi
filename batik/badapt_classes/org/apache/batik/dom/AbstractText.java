package org.apache.batik.dom;
public abstract class AbstractText extends org.apache.batik.dom.AbstractCharacterData implements org.w3c.dom.Text {
    public org.w3c.dom.Text splitText(int offset) throws org.w3c.dom.DOMException {
        if (isReadonly(
              )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.node",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ) });
        }
        java.lang.String v =
          getNodeValue(
            );
        if (offset <
              0 ||
              offset >=
              v.
              length(
                )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INDEX_SIZE_ERR,
                    "offset",
                    new java.lang.Object[] { new java.lang.Integer(
                      offset) });
        }
        org.w3c.dom.Node n =
          getParentNode(
            );
        if (n ==
              null) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INDEX_SIZE_ERR,
                    "need.parent",
                    new java.lang.Object[] {  });
        }
        java.lang.String t1 =
          v.
          substring(
            offset);
        org.w3c.dom.Text t =
          createTextNode(
            t1);
        org.w3c.dom.Node ns =
          getNextSibling(
            );
        if (ns !=
              null) {
            n.
              insertBefore(
                t,
                ns);
        }
        else {
            n.
              appendChild(
                t);
        }
        setNodeValue(
          v.
            substring(
              0,
              offset));
        return t;
    }
    protected org.w3c.dom.Node getPreviousLogicallyAdjacentTextNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getPreviousSibling(
            );
        org.w3c.dom.Node parent =
          n.
          getParentNode(
            );
        while (p ==
                 null &&
                 parent !=
                 null &&
                 parent.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              parent;
            parent =
              p.
                getParentNode(
                  );
            p =
              p.
                getPreviousSibling(
                  );
        }
        while (p !=
                 null &&
                 p.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              p.
                getLastChild(
                  );
        }
        if (p ==
              null) {
            return null;
        }
        int nt =
          p.
          getNodeType(
            );
        if (nt ==
              org.w3c.dom.Node.
                TEXT_NODE ||
              nt ==
              org.w3c.dom.Node.
                CDATA_SECTION_NODE) {
            return p;
        }
        return null;
    }
    protected org.w3c.dom.Node getNextLogicallyAdjacentTextNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getNextSibling(
            );
        org.w3c.dom.Node parent =
          n.
          getParentNode(
            );
        while (p ==
                 null &&
                 parent !=
                 null &&
                 parent.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              parent;
            parent =
              p.
                getParentNode(
                  );
            p =
              p.
                getNextSibling(
                  );
        }
        while (p !=
                 null &&
                 p.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              p.
                getFirstChild(
                  );
        }
        if (p ==
              null) {
            return null;
        }
        int nt =
          p.
          getNodeType(
            );
        if (nt ==
              org.w3c.dom.Node.
                TEXT_NODE ||
              nt ==
              org.w3c.dom.Node.
                CDATA_SECTION_NODE) {
            return p;
        }
        return null;
    }
    public java.lang.String getWholeText() { java.lang.StringBuffer sb =
                                               new java.lang.StringBuffer(
                                               );
                                             for (org.w3c.dom.Node n =
                                                    this;
                                                  n !=
                                                    null;
                                                  n =
                                                    getPreviousLogicallyAdjacentTextNode(
                                                      n)) {
                                                 sb.
                                                   insert(
                                                     0,
                                                     n.
                                                       getNodeValue(
                                                         ));
                                             }
                                             for (org.w3c.dom.Node n =
                                                    getNextLogicallyAdjacentTextNode(
                                                      this);
                                                  n !=
                                                    null;
                                                  n =
                                                    getNextLogicallyAdjacentTextNode(
                                                      n)) {
                                                 sb.
                                                   append(
                                                     n.
                                                       getNodeValue(
                                                         ));
                                             }
                                             return sb.
                                               toString(
                                                 );
    }
    public boolean isElementContentWhitespace() {
        int len =
          nodeValue.
          length(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            if (!org.apache.batik.xml.XMLUtilities.
                  isXMLSpace(
                    nodeValue.
                      charAt(
                        i))) {
                return false;
            }
        }
        org.w3c.dom.Node p =
          getParentNode(
            );
        if (p.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            java.lang.String sp =
              org.apache.batik.dom.util.XMLSupport.
              getXMLSpace(
                (org.w3c.dom.Element)
                  p);
            return !sp.
              equals(
                org.apache.batik.util.XMLConstants.
                  XML_PRESERVE_VALUE);
        }
        return true;
    }
    public org.w3c.dom.Text replaceWholeText(java.lang.String s)
          throws org.w3c.dom.DOMException {
        for (org.w3c.dom.Node n =
               getPreviousLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getPreviousLogicallyAdjacentTextNode(
                 n)) {
            org.apache.batik.dom.AbstractNode an =
              (org.apache.batik.dom.AbstractNode)
                n;
            if (an.
                  isReadonly(
                    )) {
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          NO_MODIFICATION_ALLOWED_ERR,
                        "readonly.node",
                        new java.lang.Object[] { new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
            }
        }
        for (org.w3c.dom.Node n =
               getNextLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getNextLogicallyAdjacentTextNode(
                 n)) {
            org.apache.batik.dom.AbstractNode an =
              (org.apache.batik.dom.AbstractNode)
                n;
            if (an.
                  isReadonly(
                    )) {
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          NO_MODIFICATION_ALLOWED_ERR,
                        "readonly.node",
                        new java.lang.Object[] { new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
            }
        }
        org.w3c.dom.Node parent =
          getParentNode(
            );
        for (org.w3c.dom.Node n =
               getPreviousLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getPreviousLogicallyAdjacentTextNode(
                 n)) {
            parent.
              removeChild(
                n);
        }
        for (org.w3c.dom.Node n =
               getNextLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getNextLogicallyAdjacentTextNode(
                 n)) {
            parent.
              removeChild(
                n);
        }
        if (isReadonly(
              )) {
            org.w3c.dom.Text t =
              createTextNode(
                s);
            parent.
              replaceChild(
                t,
                this);
            return t;
        }
        setNodeValue(
          s);
        return this;
    }
    public java.lang.String getTextContent() {
        if (isElementContentWhitespace(
              )) {
            return "";
        }
        return getNodeValue(
                 );
    }
    protected abstract org.w3c.dom.Text createTextNode(java.lang.String text);
    public AbstractText() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "eubSrjKhiz0bLxxmsfy7+MTiH/8BF+0e0y0dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "78qnn375H7z2d5/4Rr4z+H+rDxYkQCgAAA==");
}
