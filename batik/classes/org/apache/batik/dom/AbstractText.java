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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e2k3dbMu9myieJjF8u/iE4t//AdKL2FgLR0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
