package org.apache.batik.dom.svg;
public class SVGOMFEDiffuseLightingElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEDiffuseLightingElement {
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
             t.put(null, SVG_MODE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      surfaceScale;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      diffuseConstant;
    protected SVGOMFEDiffuseLightingElement() {
        super(
          );
    }
    public SVGOMFEDiffuseLightingElement(java.lang.String prefix,
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
        surfaceScale =
          createLiveAnimatedNumber(
            null,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1.0F);
        diffuseConstant =
          createLiveAnimatedNumber(
            null,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_DIFFUSE_LIGHTING_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSurfaceScale() {
        return surfaceScale;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDiffuseConstant() {
        return diffuseConstant;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthX() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEDiffuseLightingElement.getKernelUnitLengthX is not impl" +
           "emented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthY() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEDiffuseLightingElement.getKernelUnitLengthY is not impl" +
           "emented"));
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEDiffuseLightingElement(
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
       "GuPK3v/TVT/Z9uD8GW5oGmfRljWuGmRzLrRdtnHtKnyIsP8q7zdhd55jsOWa" +
       "OQkZvc9aqwMY+vY1bLt4/N0C6TkXBlOviJV6OYD1BUNNzyR4LdBmnyqaGFn4" +
       "agcDTGcEu+0c9DXseq2Vd/+P6seBHs0CrOaDpRhOc4IVL49cf3nilUtfe/B7" +
       "R2esBGtj8SDho2v594g8eevbn+SZMQ8PBZI/H/149OT9rb2Xv8fpXT+N1F2Z" +
       "/BQAYp1Le8GJ9L/CneW/DpOKcdIg2uXIXkE20fuNQwpuODUKlCw58Nx02sod" +
       "u7Nx6Bx/jPBM648QbuoBz4iNz3W+oLAC92WbHRicAJFjzyHCHyYKm3QYHyNg" +
       "1wYvenx23RzAmJGmTFrerQsSG1R4MMvuDpjvuXnmyw9snwrHB6rVBM1AxYxe" +
       "1j1u3D6vWcg+9+TGw/XQuu0VdhcRPWmJjt3m/ChTjJqRsJQVZ0tw4tejSGnM" +
       "1q0j7BMptUiRotBsVOu7gEhqoEjFqBmpNUxeOY6JgkwXKdywiWWwTzhtkcJd" +
       "AK3fXl5/EeEygcIVo4bolrCyb+do4jDzrXc2YL2eefuz8/JPObGrI+fb798t" +
       "XxhyNLoZNTpzoehVZLHiAANvW7Hilxfux249Mp8YOb7V8qCNuQVlv2KmH/r9" +
       "f34TuefPzxeoWKqYqp0n02kqe9ZZjVPm+Owhfi/gOsA3lx3+yxNdqe2LqS1w" +
       "rH2B6gF/rwEhNhUPA/6lPHvru627L5+6fhFlwhqfOv0sfzR08vkrN4iHw/wS" +
       "xPLMeZcnuUTduf64WqfM1JXdOV55Xa6pnw9twjaaCb+pe7KMInZejDQg2B8O" +
       "gB3B7g5GVksKpPd4d0V7ZDkmTdPsdaNhBMbnUV1KA+m0fbkSnWt8a9/97zxk" +
       "WaU/GPuQ6cEj3/0icuiIZaHWddW6vBsjL411ZcWX3mAp5wv4hKB9jg3lwgH8" +
       "hpDba9+brM1enGgaHqyOoGXxKQb+dmruZz+cuy1s6+kAI6XTqpRwXcahLyNl" +
       "4uO3Z3e5FmEYUUV7l8UAAymQhlZoujQNYvridU0AxwDbOBEAO4ndDxhpce0m" +
       "12gQfq+rrWNLoK1GhLVDU2zZlAWOU3+uWqoDSANEfzwA9gR2j0JATVEWUyGa" +
       "DtvOYaerih8vgSraELYOmmnLYy5eFcVIA8T9VQDsGex+ASkkqGJQ2erEwI4C" +
       "MTA3T3I1dXqpNLUF2pwt7tziNVWMNEAbrwTAXsPuRUhUQFNjBRKxIJVZ2Zer" +
       "st8tlcow/Txgy31g8SorRhqglrcDYH/F7k3w8KCyvvz07nVXIWeWSiFbod1h" +
       "S3XH4hVSjDRA6A8CYGexe5eRZlDIVVRXqLwHHHOMKik29U2fSt5bSpUcteU6" +
       "uniVFCMNEPuzANjn2H1cWCVX+1TyyRKopAlhrdDmbbnmF1BJgWyvGGlxsUNV" +
       "AbAa7EohT1DozDDk3Y6HafB6mCwANRMqWwLNdCDsMmjHbfGOL14zxUgDpG8J" +
       "gLVi1wT5DBiL//IieyEx6aql+Uu5MGOkLfANEd5rtuS9p7berYoPz9dXrprf" +
       "8zovxrLvP2uhrEqasuy9JfI8l2s6TUpcv7XWnZHG5e8E0YvV+4yUQI9ChDos" +
       "7PVwqgphAyb0XsxzbePyYjJSxr+9eJsZqXbxIGuwHrwoEeAOKPgY1RzL/cYC" +
       "r94kmVE9m95DkaokBD3hpqkZqzhf7d0p7hFWLLTBWRLvew6sjvjfD5wS07T+" +
       "gBAXT83vHL7p7CXHrfcsoizs349camKkwnrlw5limdpRlJvDq3zHxk+XPVK1" +
       "3ilOllsLdg/Nao8b7IHKQENDavW9gTC6si8i3ji27anfHix/GeqwCRISGGma" +
       "yL+tzGimTtomYu4NgefvK/zVSPfG+2Yv35L84E/8jp3gzUfOLbAfPy6++uC1" +
       "rxxuOdYeJjWDpEzCC0B+jdo3q+yi4rQ+Tuokoz8DSwQuUGYMkkpTkW406WAi" +
       "RpahzQuYMnK92Oqsy47iWzpGOvPryfx3m9WyOkP17aqpJJBNXYzUuCPWzvgq" +
       "fVPTfATuSHYrm/Nlj4t9t9f//M7GkgE4tznieNlXGOZk9hbB+1cJPmCVv9jd" +
       "l8F9hoMRjw1pmlP5Vq60XnCEeiwcHGcktMl+7YGeKGSVjIjUx09XL3/EbuC/" +
       "dN4FjwUlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DkJNN0uVPLx/ExKUOJ8HEO900x9D94G4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kP7S9X3p9wM7v11pUBLEp0tWDi3jdMkYeqD8f7rcjRi6clIOrI37j9NFENA6" +
       "KFJ8osGR2f3gXV6Imk6shcf3u1NArqocqiduU37plD9/aH3lHH38bgN5XOX0" +
       "C8JiD1C+kj/y15P9O/kXla++QjE/+lrjS/sXjIoj73ZFKw/R0IP7x5THPv9z" +
       "d2ztqK3L5Ae+9+jXHn7+aH/y6F7gk5lwSrZ33f6tYN8N4vJ13+6Xnvz7H/o7" +
       "r3yzfA/wfwHe3vLivjAAAA==");
}
