package org.apache.batik.dom.svg;
public class SVGOMMPathElement extends org.apache.batik.dom.svg.SVGOMURIReferenceElement implements org.w3c.dom.svg.SVGMPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMURIReferenceElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMMPathElement() { super(
                                      ); }
    public SVGOMMPathElement(java.lang.String prefix,
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
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_MPATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMMPathElement(
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
      ("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" +
       "n6ep/BWb5v8Crh6dtQ4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nhJRpHc1Ao2R5nKrExN3paR+s2jbUWOXI7gw6wujji3Oi6Uya+74bUKthFwg" +
       "FG+kmli0FuZqmrfdRS9d7DuzvZzaez1F3UkfuAk0ahBi3t2oCENNOwO+wdJD" +
       "rO8NRZfMrG0CXNCijfbxmiISXWSzQvvzOS6mzZYz5vAmcGXjvqhgRGsbjAJx" +
       "RrCkEJGJ6mdRkxbG6UwMgmLruMEWQYE/4cz69KjTFec5S4c1PEQYn8Vrdt/G" +
       "hLa9Wsw6eNKpBUg8K9TRMCb2+XCaLZi1Ejgsn8/rxp42MRKJYTNPSaNvRU1S" +
       "TS0lcFM+8+qRtuc321znd2vfrg8bu9psW2tZc32OIBrNYFhLkFr9edAdytZA" +
       "4UjNQYXE1JNmRI9Rdyy33EhwUjnbe6M2kYbCzrC5sZ/q/czVFsaCEoCH4/u+" +
       "IbCGaxI7Ox4Plx7c1cbd/cCi2VxFQtizqIVDjByKHANXoO7u6mBOSfm+lFl9" +
       "u5Gsxe6AGdvtRKp1SFSdJ0107sw7TnsiFtkos0di6vVX8LKnDDodY93tFo3u" +
       "eubt+UTilxKK2Yt0UJvb9Sg3tGwapOyqhSp5iFiNtkxP+8gii6eTaDmkzS65" +
       "nXVrcxQfDqR+e7bP14IqK2o7aa1iT9hirTZGTpwdsWkMxj18w3VWeZjR3lge" +
       "mqE0XZMNhxl2iprSCOfoNNsm7VZ3Wm8gsDdsUIMdNulMdjPY4CcdfR7qTt5B" +
       "PNQc200bLBGwjbIgYRWxu6G7M5sRXlvMfdvfxSPKpNYqjRd8IAgBgUiknQ13" +
       "7HKQisRa1vLU2XqRN2x36r4qrsbb5tBrUqE0EgZymPERPeklHr/QG9tuskEE" +
       "oTW2E77eyNlG0fUmE3HVHnc4ods14C5JcOjSb4ZrL9RpZ00mrs3XWs2s5e36" +
       "W5opahLVz1Rpa1NWI0QCzQ90ZIXpG1903T0HFmgbP14LIytrutJcRtk+S3tt" +
       "PYCJldLKOj3gqWnJorkBq/dq4+Tjb2xn5cFqw+jk0P5vsVV0mPRUGbz/ZGeu" +
       "+l2Cjg54j//Pb94fboBfON5ee7LcXssb6tldtbPnnuVuyrtud2Zf7aR89mMv" +
       "v6LNfx45ONqk/1gC3Zv4wfc4eqY7Z5q8DGp69va7RrPqysLpxveXPvanj3Hf" +
       "t/nIGzgNffJcP89X+Yuzz3+Z/E71Rw6gu062wW+6THFjoedu3Py+EulJGnnc" +
       "DVvg77pxb7QOng8faeDD5/dGT3V8x43RO5yB/Owd0n6uDH4ygd5pnez04o4z" +
       "tTL9ZA84rgq+cMbAXkygu4Hbp51a3k+9kWOVKuLHT0RwXxlZA49xJALjjYgg" +
       "gS4HkZXJwOV6PTl84Q5pv1oGv5hAj57K4UYhlOn/6BTw594E4IfKyPJ6hX8E" +
       "2H+jOv/A62L9jTukfbEM/lkC3Qdmsqmvyg59ZK74Kb5ffxP4SmjQ94Jnd4Rv" +
       "9+3H96U7pH25DP5VAj0O8A1e77Dg6Vuw2bkTglOp/OabkMp7jqXy4pFUXvz2" +
       "j/Tfv0PaH5TBv02gR4BUbne+o5xC/eqbgPpwGfkYeF46gvrStx/qf75D2n8t" +
       "g/8EmMHTc9rX9JPD5rO6Pkmo4P7hm4D7VBnZBc8nj+B+8tsP98/ukPZaGfwp" +
       "4C6g2fPHmCdHk+tTrF9/Q2fgwPm46WpTeUnj0ZsuTx5e+FN/+ZWr9zzyCv8H" +
       "1e2ek0t5906he4zUcc6eC595vxREumFVcO49PCUOqr+/ArBud5yXQHeBsOrx" +
       "Xx7m/mYCve1WuUFOEJ7N+ddH1nA2ZwJdrP7P5CtP+a6c5kugS4cvZ7PcDWoH" +
       "WcrXi8GxqSF3PoPkl9TJ1aZjt+nCGc/nyMYqdT30euo6KXL2FlHpLVW3YI89" +
       "m/TwHuzz6hdeGdM/+Fr75w9vMamOvN+XtdwzhS4fXqg68Y6eum1tx3VdGr33" +
       "m/f/yr3PHHty9x92+NTez/TtyVvfFxq4QVLd8Nn/80f+6fv/8St/VJ1C/j/6" +
       "57mdniwAAA==");
}
