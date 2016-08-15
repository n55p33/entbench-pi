package org.apache.batik.dom;
public abstract class AbstractAttrNS extends org.apache.batik.dom.AbstractAttr {
    protected java.lang.String namespaceURI;
    protected AbstractAttrNS() { super(); }
    protected AbstractAttrNS(java.lang.String nsURI, java.lang.String qname,
                             org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super(qname, owner);
                                            if (nsURI != null && nsURI.length(
                                                                         ) ==
                                                  0) { nsURI = null; }
                                            namespaceURI = nsURI;
                                            java.lang.String prefix = org.apache.batik.dom.util.DOMUtilities.
                                              getPrefix(
                                                qname);
                                            if (!owner.getStrictErrorChecking(
                                                         )) { return;
                                            }
                                            if (prefix != null) {
                                                if (nsURI ==
                                                      null ||
                                                      "xml".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XML_NAMESPACE_URI.
                                                      equals(
                                                        nsURI) ||
                                                      "xmlns".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XMLNS_NAMESPACE_URI.
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
                                            else
                                                if ("xmlns".
                                                      equals(
                                                        qname) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XMLNS_NAMESPACE_URI.
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
    public java.lang.String getNamespaceURI() {
        return namespaceURI;
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
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
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
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
