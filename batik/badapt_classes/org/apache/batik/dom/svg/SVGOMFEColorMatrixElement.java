package org.apache.batik.dom.svg;
public class SVGOMFEColorMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEColorMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_MATRIX_VALUE,
    SVG_SATURATE_VALUE,
    SVG_HUE_ROTATE_VALUE,
    SVG_LUMINANCE_TO_ALPHA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFEColorMatrixElement() {
        super(
          );
    }
    public SVGOMFEColorMatrixElement(java.lang.String prefix,
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
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getValues() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEColorMatrixElement.getValues is not implemented");
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEColorMatrixElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
      ("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" +
       "PmR7ff4w9EQxF56EXnDa/E8vaPvnefG1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("sPQO3dbD4lOAgprmQI8VFMSUvopCJbjl6V3s6PKJuX79jXwPPqeC+/LKMnjs" +
       "QxXYb0QFYelu19djMVReUw/fuKDtm3nx9bD06Ikeziohb/+NE4H/5ZsQ+KG8" +
       "8omCdPeXvlGbv/81Zf3WBW3fyYvfD0v3qUo4cCTRHB1+MEFP5PuDNyHf43nl" +
       "0+D52KF8H/vRy/dHF7T9cV78x7B0CcjXs6tHwf7kLYL97DeNE/H/05sQ/6m8" +
       "8lnwfPJQ/E/+6MX/0wva/iwv/huICyD+7NTHkXdfIP+pLyInSvjvb0IJT+aV" +
       "z4Hn5w6V8HM/ciXsXbqg7XJe5Ne6gBKKOxnBkRqeuUANuw8i+T2pYy3s7b8J" +
       "LTycV+Zf3j9/qIXPv1EtvCa6752/GXS67ZG8uAJcwVaSkSMfu8LV0zo4bijE" +
       "vfpmjd4GzxcPxf3ij17cpy5oy0fbexyAeO755y6iHF8uWZzI+sQbusUUln7s" +
       "tpdU8+t2j950PX53pVv6ystXLr/95fm/3l3qOLp2fc+gdHkdmebpGz6n3i+5" +
       "vrLWC3Xcs7vvU9ym2CsD8W73lTMs3QHKnPO953bUB2HprbeiBpSgPE1ZPfSK" +
       "05Rh6a7i39N0cFi694QOgOzu5TRJE4wOSPLXlnvkcj/5Gjd/dTNU/ONLEmwo" +
       "2rLoyyfrb7p3Kos69LwCpR56LSMedzl9OzS/zlD8r4ejqwfR7v893JC++jI9" +
       "+ugPGr+8u50qmWKW5aNcHpTu3l2ULQbNry88edvRjsa6RD37wwd+9Z5njrLC" +
       "B3YMn0TBKd7edet7oITlhsXNzewfvf0fvO/vvPyt4jPt/wWNHDCJjjIAAA==");
}
