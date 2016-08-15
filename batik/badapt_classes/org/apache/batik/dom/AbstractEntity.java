package org.apache.batik.dom;
public abstract class AbstractEntity extends org.apache.batik.dom.AbstractParentNode implements org.w3c.dom.Entity {
    protected java.lang.String nodeName;
    protected java.lang.String publicId;
    protected java.lang.String systemId;
    public short getNodeType() { return ENTITY_NODE; }
    public void setNodeName(java.lang.String v) { nodeName = v; }
    public java.lang.String getNodeName() { return nodeName; }
    public java.lang.String getPublicId() { return publicId; }
    public void setPublicId(java.lang.String id) { publicId = id; }
    public java.lang.String getSystemId() { return systemId; }
    public void setSystemId(java.lang.String id) { systemId = id; }
    public java.lang.String getNotationName() { return getNodeName(); }
    public void setNotationName(java.lang.String name) { setNodeName(name);
    }
    public java.lang.String getInputEncoding() { return null; }
    public java.lang.String getXmlEncoding() { return null; }
    public java.lang.String getXmlVersion() { return null; }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n, org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n, org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected void checkChildType(org.w3c.dom.Node n, boolean replace) {
        switch (n.
                  getNodeType(
                    )) {
            case ELEMENT_NODE:
            case PROCESSING_INSTRUCTION_NODE:
            case COMMENT_NODE:
            case TEXT_NODE:
            case CDATA_SECTION_NODE:
            case ENTITY_REFERENCE_NODE:
            case DOCUMENT_FRAGMENT_NODE:
                break;
            default:
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          HIERARCHY_REQUEST_ERR,
                        "child.type",
                        new java.lang.Object[] { new java.lang.Integer(
                          getNodeType(
                            )),
                        getNodeName(
                          ),
                        new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
        }
    }
    public AbstractEntity() { super(); }
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
      ("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" +
       "zis3i/M7wfP5A87P3xqcJ375wtMljA+d");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("A/HDRdIFC1zV87OxG3lnAH7vzQIsTPlLB4BfepsAEucApIpkEFXuLWSIXR8k" +
       "fhMgy+tM3wueNw8g37z12lpmnllo3bn0PFtX3BKkeA4Dvr9IpsBlA4NXLcww" +
       "be1odX0y8V54y6tSV900BL1dfRW6uMv58DX/V7H/XwD1516/fNd7Xxf+ZXkb" +
       "+Pi+/t1U5a5VbNunr96der/kB/rKLFlz9/4inl/CWUaVd1/Pg0WV20BakHpB" +
       "2dfUD07wdE2wMi//nq5nAAM/qQc82v7ldBXQ7jZQpXi1/SNH+l3nOlJWCYAb" +
       "LRxvut/9efi0/pSBwFvOIsdNTt8eLvZ1yn90OdqDiff/6vKi+sXXCeaHvoF8" +
       "bn97WbWVPC96uYuq3Lm/SF12WuzjPHnD3o76ujR67pv3/fzdzx7tOd23J/hE" +
       "l0/R9vj1rwcPHD8qL/Tmv/TeL33f51//3fIu2v8H9bkxX4E0AAA=");
}
