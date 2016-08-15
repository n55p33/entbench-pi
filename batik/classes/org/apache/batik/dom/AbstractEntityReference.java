package org.apache.batik.dom;
public abstract class AbstractEntityReference extends org.apache.batik.dom.AbstractParentChildNode implements org.w3c.dom.EntityReference {
    protected java.lang.String nodeName;
    protected AbstractEntityReference() { super(); }
    protected AbstractEntityReference(java.lang.String name, org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super();
                                            ownerDocument = owner;
                                            if (owner.getStrictErrorChecking(
                                                        ) && !org.apache.batik.dom.util.DOMUtilities.
                                                  isValidName(
                                                    name)) {
                                                throw createDOMException(
                                                        org.w3c.dom.DOMException.
                                                          INVALID_CHARACTER_ERR,
                                                        "xml.name",
                                                        new java.lang.Object[] { name });
                                            }
                                            nodeName =
                                              name;
    }
    public short getNodeType() { return ENTITY_REFERENCE_NODE;
    }
    public void setNodeName(java.lang.String v) {
        nodeName =
          v;
    }
    public java.lang.String getNodeName() {
        return nodeName;
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected void checkChildType(org.w3c.dom.Node n,
                                  boolean replace) {
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
       "bnTt5dCOqB0dNjObjyKO3DmUSDsdWqGZfisZ9torXOgJdWHohYS7orOI5Jfs" +
       "Nuoi6WQ7b8XN4YhKm57q95e57C5JtEc444yWmtRwbXVRhJtuuQk7mHnKMLd1" +
       "Ih0w02oYClLg1BGGNkEWjtYWTdQE1assHDbVRWrT2BAPNlWzOgw5clgL8pkc" +
       "ar3KLDKwpaEJC364kiWtVt3M+8wIo2hsMFCaSY/NxnLN8GQnapkDkkQ4gdyJ" +
       "s8qwV2GxxK+L2Zy3sL6g1RMrElIbhwXcXE8mShUZd+vjpjxzzNVI7PUbvuWH" +
       "fT6B7e1kywgC258TsheFk9UcI9zhZrKazF2qZ9JVnOtPCIGyZlhEjHfUTpvW" +
       "6Jlnk1wXw6oO5dSqnL6czIZixuvA9q2oLQ23U5+hxvnOa+Rrrdlpxp11Y1Gz" +
       "Q7i+HHf4URLV4W20rLG2lFJ+PyJbOJHshu4s7Vr1WdiAlUZ3MrBxs5IJBtfu" +
       "IS09bebZdpV4ubpNGDxx2KZDbdejTODm7nyO0K0diikSUK49sOqyNswjJMky" +
       "oIR5bC5lecWyQ3OLN9sJ6/s+Cm+HA3QxbQctQekHu2BVr48sVmRZedhjOgNx" +
       "HtAOJrcE3hUpD2kbPXZm0htq5lnSGu7PxzszHo5nu3gXz9k5PJnNsiVFRqNA" +
       "Q4WlF3bixEvIQcUHPkYpi+2KlOpe4DS8ZcJQlYEZ4JE/mZGzHunyZo407Q2l" +
       "TAysTmpEuiSwboS3R30v7OJbsy8uquYIw1g8WtXI3sLZakvK7G0n/akl2kvE" +
       "c+w5NmHGnhGsVoLjhhmrE1jDcZlFW6L7eme00sOBteSGmlxF86228axut43i" +
       "VbPt7BBCNGk3Mkdt2ezNCFZcupzVMRRitFbCetVnxpM5sauj47gHfAlVGHgh" +
       "YtikWl2OJqpbofq1UTevpY673hoLd8n1GCOdb/SaPttUSNeymSkRmS6erRwh" +
       "MiuYk40GNMGuHRKfqB5NLHpash11vWg3YkxvM+oJ44SOFtGYmWd+YzCkzQbS" +
       "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");
}
