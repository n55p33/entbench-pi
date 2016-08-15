package org.apache.batik.svggen;
public class SVGCompositeDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String opacityValue;
    private java.lang.String filterValue;
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue) {
        super(
          );
        this.
          opacityValue =
          opacityValue;
        this.
          filterValue =
          filterValue;
    }
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue,
                                  org.w3c.dom.Element def) {
        this(
          opacityValue,
          filterValue);
        this.
          def =
          def;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public java.lang.String getFilterValue() { return filterValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_FILTER_ATTRIBUTE,
            filterValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
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
       "37x8x96n7nJC8C/u0vbJovhYAl1bGsn44rbsqSd+/I0cKpQVP3xexGLzuH0k" +
       "YvvbL+K/vkvbTxTFv0ygh4GI5IX93VMJ/9W3IOFjReV3guc9RxK+59sv4U/f" +
       "pe1niuIzCXQFSNg92uw/leyz34Jk14rKp8GDH0mGf3sku7QnOLenej6+eZBD" +
       "F6BxU/u5yZe/8Kn8c6/ut0xVJTYSqHKnG1S3XuIqTuVfuMvNgtO7NX9C/f3X" +
       "/vAPxO85hqUHT9RQHDBAz99NDcfw+KbTI0tGKdt+sRzrF+5ivs8Xxc/tYxBP" +
       "kshW08QAvUvi/3T+hPLh17PFL5bFqfX/w7dg/evHkTs6mnH07bX+efkKFCwP" +
       "lu4427GSHz57lrw/lf9iOdH/vIuWf6sofi2Bru+DxPbLSwqCkdxOzddeT+gv" +
       "lsWpmv/7Gzp1TaDHb39rprgC8OQtd/T298q0z75y7f4nXpn9Rnlx5OTu1wM0" +
       "dL+Zuu7Z48gz71fCCAhb8vzA/nAyLH9+P4GeuMNSXhxJlS8l47+3p//fQHMX" +
       "6RPo3vL3LN1XEujqKR0Yav9yluSrCXQZkBSvfxTe5vrC/lQ2u3QmEzhyzVLV" +
       "j76eqk+6nL1XUgR+eUfyeKVPuSN8+dwrQ/b9X2/++P5ei+YqeV6Mcj8N3be/" +
       "YnOSLTx3x9GOx7rSf+c3Hv6pB144hpCH9wyfhskZ3p65/SWSnhcm5bWP/N8/" +
       "8TPv/jev/G554vb/AJUBuFi8KgAA");
}
