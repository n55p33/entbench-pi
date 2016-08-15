package org.apache.batik.dom;
public abstract class AbstractElementNS extends org.apache.batik.dom.AbstractElement {
    protected java.lang.String namespaceURI;
    protected AbstractElementNS() { super(); }
    protected AbstractElementNS(java.lang.String nsURI, java.lang.String qname,
                                org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super(qname, owner);
                                            if (nsURI != null && nsURI.length(
                                                                         ) ==
                                                  0) { nsURI = null; }
                                            namespaceURI = nsURI;
                                            java.lang.String prefix = org.apache.batik.dom.util.DOMUtilities.
                                              getPrefix(
                                                qname);
                                            if (prefix != null) {
                                                if (nsURI ==
                                                      null ||
                                                      "xml".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XML_NAMESPACE_URI.
                                                      equals(
                                                        nsURI)) {
                                                    throw createDOMException(
                                                            org.w3c.dom.DOMException.
                                                              NAMESPACE_ERR,
                                                            "namespace.uri",
                                                            new java.lang.Object[] { new java.lang.Integer(
                                                              getNodeType(
                                                                )),
                                                            getNodeName(
                                                              ),
                                                            nsURI });
                                                }
                                            }
    }
    public java.lang.String getNamespaceURI() {
        return namespaceURI;
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
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
