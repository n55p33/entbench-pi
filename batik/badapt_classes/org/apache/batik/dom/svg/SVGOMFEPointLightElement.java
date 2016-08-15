package org.apache.batik.dom.svg;
public class SVGOMFEPointLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFEPointLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected SVGOMFEPointLightElement() {
        super(
          );
    }
    public SVGOMFEPointLightElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_POINT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEPointLightElement(
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
       "Caon/CIiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v9xE+dwnXnlVnfwkenC0j/9SDF2L/eB7HS3VnDMjXwU9PXv3DaNxedXhdG/8" +
       "S5/4T08I32d+7A0cmL7rgp4Xu/wH48//Vu99yt86gO472Sm/7RLG+UbPnd8f" +
       "vx5qcRJ6wrld8ifPb2gi4BGPJkK8uKF5OtX33M28xzHJ5+5R91NF8vdi6Lss" +
       "z4rLCy9a03FoK9WacRxachJr+53NT5zxsx+JoftT31JPHfAn3sjJS1nw2RMT" +
       "PFgUVsAjH5lAfiMmiKErQWilUqy9rh1+4R51v1QkX4ihx0/tcN4IRf1PnwL+" +
       "4ncA+JGi8CnwrI8Ar9/onH/4dbG+do+63yiSX4mhBw0tpn1Fcpgjd22e4vtH" +
       "3wG+J4vCp8ETHuEL33x8X7lH3e8UyZeAjwJ8y2PyevoO5HX+kOQU/JffDPDb" +
       "I/DbNx/8H9yj7l8XyT/fg18V+X96iuv33wxcLx7hevHNx/Xv71H3tSL5t3tc" +
       "4gVcf/wd4Hq0KHwCPC8d4XrpjeJ6fQL+b/eo++9F8nXAYp6WMb6qHfvrzbP+" +
       "elJRwv0v3wHcYgahBnhePoL78psO9xJ0j7ryVPebgGfBNF48lT05aV2eYv3z" +
       "N3SkD/q924Wt4urJ47fdE93fbVS+8OqNq+94dfYvyjtLJ/cPr9HQVT1xnLOn" +
       "3Wfyl4NQ063SGtf2Z99BCfEa0OJuh7MxdB9IC8UvXd1LPxhDb7uTNJAE6VnJ" +
       "G0dOcVYyhh4o/5+VeySGrp/KxdDlfeasCPCv+4BIkX0sOPa4O1/KODlRPo7u" +
       "Lp0J0I7cq5ypR15vpk6anL0PVQR15SXf4wAs2V/zfV754qtD5uPfqP3k/j6W" +
       "4ki78rT2Kg1d2V8NOwninr5rb8d9Xe6//5sP/dy1Z44Dzof2Cp+6+hnd3nXn" +
       "m08dN4jLu0q7f/iOX/jQ33/1D8tz0v8Hu9FhaX0tAAA=");
}
