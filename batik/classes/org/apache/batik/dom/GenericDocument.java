package org.apache.batik.dom;
public class GenericDocument extends org.apache.batik.dom.AbstractDocument {
    protected static final java.lang.String ATTR_ID = org.apache.batik.util.XMLConstants.
                                                        XML_ID_ATTRIBUTE;
    protected boolean readonly;
    protected GenericDocument() { super(); }
    public GenericDocument(org.w3c.dom.DocumentType dt, org.w3c.dom.DOMImplementation impl) {
        super(
          dt,
          impl);
    }
    public boolean isReadonly() { return readonly; }
    public void setReadonly(boolean v) { readonly = v; }
    public boolean isId(org.w3c.dom.Attr node) { if (node.
                                                       getNamespaceURI(
                                                         ) !=
                                                       null)
                                                     return false;
                                                 return ATTR_ID.
                                                   equals(
                                                     node.
                                                       getNodeName(
                                                         ));
    }
    public org.w3c.dom.Element createElement(java.lang.String tagName)
          throws org.w3c.dom.DOMException { return new org.apache.batik.dom.GenericElement(
                                              tagName.
                                                intern(
                                                  ),
                                              this);
    }
    public org.w3c.dom.DocumentFragment createDocumentFragment() {
        return new org.apache.batik.dom.GenericDocumentFragment(
          this);
    }
    public org.w3c.dom.Text createTextNode(java.lang.String data) {
        return new org.apache.batik.dom.GenericText(
          data,
          this);
    }
    public org.w3c.dom.Comment createComment(java.lang.String data) {
        return new org.apache.batik.dom.GenericComment(
          data,
          this);
    }
    public org.w3c.dom.CDATASection createCDATASection(java.lang.String data)
          throws org.w3c.dom.DOMException { return new org.apache.batik.dom.GenericCDATASection(
                                              data,
                                              this);
    }
    public org.w3c.dom.ProcessingInstruction createProcessingInstruction(java.lang.String target,
                                                                         java.lang.String data)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericProcessingInstruction(
          target,
          data,
          this);
    }
    public org.w3c.dom.Attr createAttribute(java.lang.String name)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericAttr(
          name.
            intern(
              ),
          this);
    }
    public org.w3c.dom.EntityReference createEntityReference(java.lang.String name)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericEntityReference(
          name,
          this);
    }
    public org.w3c.dom.Element createElementNS(java.lang.String namespaceURI,
                                               java.lang.String qualifiedName)
          throws org.w3c.dom.DOMException {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        if (namespaceURI ==
              null) {
            return new org.apache.batik.dom.GenericElement(
              qualifiedName.
                intern(
                  ),
              this);
        }
        else {
            return new org.apache.batik.dom.GenericElementNS(
              namespaceURI.
                intern(
                  ),
              qualifiedName.
                intern(
                  ),
              this);
        }
    }
    public org.w3c.dom.Attr createAttributeNS(java.lang.String namespaceURI,
                                              java.lang.String qualifiedName)
          throws org.w3c.dom.DOMException {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        if (namespaceURI ==
              null) {
            return new org.apache.batik.dom.GenericAttr(
              qualifiedName.
                intern(
                  ),
              this);
        }
        else {
            return new org.apache.batik.dom.GenericAttrNS(
              namespaceURI.
                intern(
                  ),
              qualifiedName.
                intern(
                  ),
              this);
        }
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.GenericDocument(
          );
    }
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
      ("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" +
       "1lLSpIjlfukY7CN3Aba4ClEC6Ut7sF96");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("n8C+eCewL+fZMwn0+H5+9BMr2RzdwztUgg+dmidvQlNI5Nm7dZUvgfTVvUS+" +
       "+n5ayNm7YzeIJb9Adu6VIx3Yhwb8KKf4tWPE8N0qfO4YvrlH/M33E/G1OyHO" +
       "V5bnamA5eUbrd5hP6D1+t6Oc30f71h7zt94t5h+5U1R0rn2bOibP6gl0wdfX" +
       "t5z/jyoKuI13dYUMaMyZe8H5Dcenbvg/g93dePUX3rx0/5Nvjv9dcTX26P76" +
       "xR50v5G67slLVSeez4eRbliFHC7urliFBbhhAn3wZjeVE+gekOd9PTfYUY73" +
       "iE9SJtB9xd+TdFOwSDymS6Dzu4eTJD8BuAOS/PEnw0NxfvimF6YpBUwZspoc" +
       "SibbhfBPnVSVYqZ99E4iP7Hr8PKpvYLi3z4O1/Xp7h8/rqtff7PL/9QPal/d" +
       "XeRVXXm7zbnc34Mu7O4UF0zzvYEXb8ntkNf5zkffefgXL374cB/j4V2Hj9X2" +
       "RN+ev/mV2aYXJsUl1+0/evIffuzvvvl7xQWe/weqv6c9jzMAAA==");
}
