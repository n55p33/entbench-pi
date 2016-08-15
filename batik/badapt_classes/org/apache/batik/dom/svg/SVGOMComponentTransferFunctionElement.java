package org.apache.batik.dom.svg;
public abstract class SVGOMComponentTransferFunctionElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGComponentTransferFunctionElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TABLE_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_SLOPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_INTERCEPT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_AMPLITUDE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_IDENTITY_VALUE,
    SVG_TABLE_VALUE,
    SVG_DISCRETE_VALUE,
    SVG_LINEAR_VALUE,
    SVG_GAMMA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      tableValues;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      slope;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      intercept;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      amplitude;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      exponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      offset;
    protected SVGOMComponentTransferFunctionElement() {
        super(
          );
    }
    protected SVGOMComponentTransferFunctionElement(java.lang.String prefix,
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
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
        tableValues =
          createLiveAnimatedNumberList(
            null,
            SVG_TABLE_VALUES_ATTRIBUTE,
            SVG_COMPONENT_TRANSFER_FUNCTION_TABLE_VALUES_DEFAULT_VALUE,
            false);
        slope =
          createLiveAnimatedNumber(
            null,
            SVG_SLOPE_ATTRIBUTE,
            1.0F);
        intercept =
          createLiveAnimatedNumber(
            null,
            SVG_INTERCEPT_ATTRIBUTE,
            0.0F);
        amplitude =
          createLiveAnimatedNumber(
            null,
            SVG_AMPLITUDE_ATTRIBUTE,
            1.0F);
        exponent =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            1.0F);
        offset =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            0.0F);
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getTableValues() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGComponentTransferFunctionElement.getTableValues is not im" +
           "plemented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSlope() {
        return slope;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getIntercept() {
        return intercept;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAmplitude() {
        return amplitude;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getExponent() {
        return exponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getOffset() {
        return offset;
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
       "19QB2WoncVC2og0nt5aET6vDjTgooroj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4bWU6cLL5dynOdgc6yUBgoOgOeLmLZLieGfQYRDRrzMGFLoS6pYxn2IEKujY" +
       "Y8iatJbOMurym3IIN2Mf7hVTWmgEVXjZala8uOfXDXNeTFvNaZfjwXxQHK87" +
       "IxMuyro1HZjtZNJt6qURMVoFEkeMVKcfE8MQUnRSCCutYETpKmVjU3E6T0AA" +
       "262VSaUXqSDCo32vPeBn3mZlLsNwkrRBjI0MvMQeIvaAKLYqRCrUVlyShutu" +
       "u7YcBBihIYPQsiRY2JikNEj9emPdXlSxFLOL9gBKmjAmx3JcmWtTHeL9io+i" +
       "6Aezpag372yJ7JF85e/wYOb3seaXnLEBboSFi9LuXMTRYZ/871Jhd8Lv4P+x" +
       "tdNjZxv2Dtbmy9na/LqsHF+Sv9WBtmy/8KnTDnLme4Vf+uSrr6nDny2d220X" +
       "uWHh3tBx/5ypxZp5TIz78vvN9cu/RXD96A7Cj55c/j3S4Jlrv2dsXf3xGXnf" +
       "ypI/DAvvNmwjzHcaNdQ0KSPW0DD0DTB93m3OnFzijB1DPbLrv7+TIycnVPDA" +
       "wbr8Z3Yq+MydqCAs3OP6RiyF2i318D/PyPtelvyXsPDEkR6uV0KW/+0jwP/1" +
       "LQB+9mDJ/4s7wF+8U5vfcudz7/wZefdkSQEobqGF42Nbie+7Sc+4yf7hoRL2" +
       "9t6CEp7JHsLg+vJOCV9++5Xw2Bl5j2fJQ2HhoUwJN25EPn+GLo52H49Ucekt" +
       "qOKp7OHz4Pr6ThVff/tV8cwZec9lyXsAwwJVcMe3MZ+5pRKOFPDUW1VA1iF+" +
       "aaeAX3r7FXDGEcm97Ijk3kth4QGgAOLYJuje80f4oLcD36/s8P3K24/v6hl5" +
       "2Xi+V9viQ4/tph7HV3+r+LKt9N/c4fvNtx9f94y8bOtsDwsL9wN87aNt2ePw" +
       "8LcKL/uY4M0dvDfffnhn5U2yZAACCgBveLC/exzcLc/h3YqHm+D6xg7cN+4U" +
       "3C0DkL1rZ+RJWSKCgTfj4RPnEw/PHPJHWG956ua6w62AyG/ri4Xs7PUTN3xP" +
       "tf0GSPnqa5cuvuu1yb/cnvs7+E7nXqpwcR6Z5vFDoMfuL7i+Nt/a/d7tkdD8" +
       "wN2eDqCedjokLNwF0gzF3mJbehUW3nGz0qAkSI+XtMPCwydLhoXz+f/j5byw" +
       "cN9RubBwYXtzvEgIWgdFstvIvW5APP1Iy0GgvHcs1t35Wh4vPXorsx1WOf5B" +
       "QHamLf8Y7uD8WbT9HO6a8rXXyMHHv1v72e0HCYoppWnWykWqcM/224i80ewM" +
       "2zOntnbQ1oXei9976Ofvff4gdn9oK/CR3x+T7b03P/rfttwwP6yf/uK7/v4H" +
       "vvza7+cnDv4frnpTu6U4AAA=");
}
