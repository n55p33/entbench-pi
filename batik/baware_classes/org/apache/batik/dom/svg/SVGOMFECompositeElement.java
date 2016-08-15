package org.apache.batik.dom.svg;
public class SVGOMFECompositeElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFECompositeElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_IN2_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_OPERATOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_K1_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K2_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K3_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K4_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      OPERATOR_VALUES =
      { "",
    SVG_OVER_VALUE,
    SVG_IN_VALUE,
    SVG_OUT_VALUE,
    SVG_ATOP_VALUE,
    SVG_XOR_VALUE,
    SVG_ARITHMETIC_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      operator;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k1;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k3;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k4;
    protected SVGOMFECompositeElement() {
        super(
          );
    }
    public SVGOMFECompositeElement(java.lang.String prefix,
                                   org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        in2 =
          createLiveAnimatedString(
            null,
            SVG_IN2_ATTRIBUTE);
        operator =
          createLiveAnimatedEnumeration(
            null,
            SVG_OPERATOR_ATTRIBUTE,
            OPERATOR_VALUES,
            (short)
              1);
        k1 =
          createLiveAnimatedNumber(
            null,
            SVG_K1_ATTRIBUTE,
            0.0F);
        k2 =
          createLiveAnimatedNumber(
            null,
            SVG_K2_ATTRIBUTE,
            0.0F);
        k3 =
          createLiveAnimatedNumber(
            null,
            SVG_K3_ATTRIBUTE,
            0.0F);
        k4 =
          createLiveAnimatedNumber(
            null,
            SVG_K4_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COMPOSITE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn2() {
        return in2;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getOperator() {
        return operator;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK1() {
        return k1;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK2() {
        return k2;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK3() {
        return k3;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK4() {
        return k4;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFECompositeElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KVktAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nif0JUKcjTpWeVMd6BY0RNpaplaVLdLx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("RQZakuW6QvCyYUGpM+eqsyZrWtX5dK2R9HxmbXmEGXnbRpuQWBGq8FI8qS2T" +
       "SOkizGSpD2d9zGnSm01FKPtkYz11xPm82SVtssw4tYFWyZpRu1xVszoBwSAa" +
       "FIaKwrXSVbtlwma/FsdjEYHKfHXN2aQwU1FXFRiyloRhdSTE3niE1awaSQh4" +
       "HTMylOwRFo+1Z2ZZ4XokptVJXZAQxXEh2poOmyu+WVtvmTa3tmQWWxtt1ip7" +
       "lL91GMsmXUOw+KwRo/6IRzpE4trGOt1MIdGbTtdoa1sjmv6sDKUrzluqQpR0" +
       "GQKrdmkeY1bwcK7W0U1r2XThMiP17WDEWhGKosWTtK/d3KO2B4sniEfnMr+P" +
       "Z4fpibc/R49Yi78L+8esh49brzqN8ciJV5mHRy2SmnTyqfjVx9ny94KPXe9w" +
       "ZvFO8FMfeOFFefxrlfP7F0XrqHR35Pk/ZCsbxb7iKEV+n139CuODe6E/ePq5" +
       "8LFaznwofMZLq784o+yv8uTPo9IbDNeIijeKCtjckcZGQaMoMMQ4UsJrPv/c" +
       "eIZ8bKz/cjNHS06p4N48EwLXR/Yq+MjNqCAq3ekHxkaIlJfVw9+cUfa/8+Q7" +
       "UemRYz1cqYS8/JvHgP/HKwD8UJ75OLh+eQ/4l2/W5u94Oaznbjuj7I4882+j" +
       "0r2aEpGeJNj0/r0reozve68A32N55pPg+uQe3ydvPb77zyh7ME/uiUoXAL6h" +
       "e/Qm7IlrTPUrX40ewT/3qlsB/9N7+J++9fAfO6PsTXnyyCH8As7Dx8h+4BUg" +
       "y8/OlX4IXJ/fI/v8rUf29BllUJ5cikqvAsjGp17WvuUM6554Q3usiKdeqYlz" +
       "bXxhr4gv3HpFNM8oa+dJNSrdARQxuiEH370sO0ZfuxXov7hH/8Vbjx4/o6yf" +
       "J+/coy/QPHsMDL0VwL68B/blWw9sckbZLE/IPbDaKWDUrQD21T2wr956YO8+" +
       "o+xynqz2wOqngHGvANjDeWZ+Qu6P98D++GaBvWz4dM44o8zKExnEIK6S0J58" +
       "dE7rgZNT8aiggKu8ArhP5JltcH19D/frtx5uckbZNk8CECUBO54+NHp0EHR1" +
       "jDW8qRPHUen11/mcJD8Y/8hVn7DtPruSPvvi/Xe9/sXFv98dvTz8NOpusnSX" +
       "Gtv2ybO4J+4v+IGiGoUy7t6dzC3OPJ57PwB3vRMzUek2kOZyn3vfrvbfj0qv" +
       "uVZtUBOkJ2v+1N4nTtYE86H4f7LeT0ele47rgUV8d3OyykdA76BKfvuz/qHD" +
       "/ejLfKFj2JESHB1lnEWCKwuBfBzeprsd0SMn/a4IBB96ORMeNTn5HUd+6LD4" +
       "MvHwgGC8+zbxsvS5Fwn6Pd9p/NruOxLJFrIs7+UusnTn7pOWotP8kOET1+3t" +
       "sK8Lg6e/e9/n737qcNN1307g4zlwQrY3XfuLDdzxo+Ibi+y3X/8v3v5PXvzT" +
       "4hzJ/wdxWArSMjoAAA==");
}
