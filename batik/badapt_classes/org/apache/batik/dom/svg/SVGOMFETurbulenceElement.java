package org.apache.batik.dom.svg;
public class SVGOMFETurbulenceElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFETurbulenceElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_BASE_FREQUENCY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_NUM_OCTAVES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_SEED_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_STITCH_TILES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TYPE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      STITCH_TILES_VALUES =
      { "",
    SVG_STITCH_VALUE,
    SVG_NO_STITCH_VALUE };
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_FRACTAL_NOISE_VALUE,
    SVG_TURBULENCE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger
      numOctaves;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      seed;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      stitchTiles;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFETurbulenceElement() {
        super(
          );
    }
    public SVGOMFETurbulenceElement(java.lang.String prefix,
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
        numOctaves =
          createLiveAnimatedInteger(
            null,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1);
        seed =
          createLiveAnimatedNumber(
            null,
            SVG_SEED_ATTRIBUTE,
            0.0F);
        stitchTiles =
          createLiveAnimatedEnumeration(
            null,
            SVG_STITCH_TILES_ATTRIBUTE,
            STITCH_TILES_VALUES,
            (short)
              2);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              2);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_TURBULENCE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getNumOctaves() {
        return numOctaves;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSeed() {
        return seed;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getStitchTiles() {
        return stitchTiles;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFETurbulenceElement(
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
       "VsjQHox8pBGOB7o9q9YiMxjWh1i20Jc5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LwoUuWBnfcIfs5BgSiJdhlaLjl9FIEJGjDVMsLwWgLAiUWqbmEXsiuVSwBPD" +
       "sF0V0kW70ySSzmhQbgib+rTasMublqX20+GWWDCcqlaxFqx25sNyU5QGWpmj" +
       "XZgd9LoI4jRqLWrUaHn2wEV8FJ7idBSwYZdfYuogCfDNkI2mTXTediUiCRk8" +
       "3AaqluLr6TQWVSheQYlFB35vtFj42zVBJX6rjacZv876Cg6TsyZY8xUcOPuw" +
       "2zIaYT+i3M68oyZzw/Gi9YadBUxF1PplQuzRlr6IkO3Uh1JlES4EUQX+qiOG" +
       "RFIBiqLF07Nv3NrjtYeKp4bHhxJ/iOeF6al3HscPVou//KXCs/v7Z888WD31" +
       "Lv/g6Mnvu/Inv0ldOv3A9wYnufLXYU/c7Ghi8Srsi594+RWZ+YXqhf37ET8q" +
       "3R253o9aykaxTo18T3GfXfs4uJLj20udnH0cfKKXc58Fn/Ou5vfOKfvPefKt" +
       "qPR2wzGi4kWaglrW0NgoaBQFhhhH+8fkZx96blxDPrHWv7uVUxVnVHBvnlkG" +
       "18f2KvjYraggKt3pBcZGiJTX1MOfnFP2nTz5b1HpsRM9XKuEvPz3TwD/0RsA" +
       "/HCe+SS4PrMH/Jlbtfn7XhPrn55T9ud58r2odK+mRENXEqzR/nUjeoLv+28A" +
       "3xN5Zl7++T2+z7/p+A4OzikriOcvANEAfJgQKkSg+DGYzdvF0bR/6gbT/trX" +
       "VSea+Ms3QxM/v9fEz7/5mnjgnLKH8uTSDTSxzAvuOAZ5cM8bAJl7cjF/v7QH" +
       "+aU3H+TbzynLX4YfPBqV7gMgR9e9Z336HFPvX66eqOFtb9TWV8D1tb0avvbm" +
       "q+G5c8rKeXIF0CFQA6so8hkLP/sGoD2dZ+aL1K/uof3qmw+teU5ZHiAcVKLS" +
       "/Tm061/f3mgRv8E72xNdVN+oLp4D19f3uvj6m68L/Jyybp68f2fm/aGQg5Pj" +
       "jQcfeAPQHskz81NW39hD+8atQnvNWOSAOadskid9AM1RkpErH5/1efC0fY8L" +
       "CriDNwD3qTyzDa5v7uF+882H++I5ZVfzZAFCjtySZw4fHh8oXJxgXd7SyVXQ" +
       "782+S8hPWD923edQu094pK++8sBdb3tl9h925/eOPrO5e1i6S40t6/ShzlP3" +
       "F71AUY1CG3fvjngWB+cOVCDFzc5WRKXbQJoLfqDsahtR6S03qg1qgvR0TWvv" +
       "FKdrRqU7iv+n67lR6dJJvah0cXdzukoAegdV8tvQO/K4D7zGtx6GFSnB8Xk4" +
       "NhIcWQjkk2Ax3YUnj512vCKYePi1bHjc5PQHAfnJteIrt6NTZvHuO7er0tde" +
       "6Y8++n34F3YfJEiWkGV5L3cNS3fuvo0oOs1Pqj11096O+rpIPveD+3/57meP" +
       "tjD37wQ+mQSnZHvnjY/+d20vKg7rZ7/2tn/63n/wyh8URzH+H07nlUB+OAAA");
}
