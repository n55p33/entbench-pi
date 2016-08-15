package org.apache.batik.css.engine.value.svg;
public class ClipPathManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PATH_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    return new org.apache.batik.css.engine.value.URIValue(
                                                      lu.
                                                        getStringValue(
                                                          ),
                                                      resolveURI(
                                                        engine.
                                                          getCSSBaseURI(
                                                            ),
                                                        lu.
                                                          getStringValue(
                                                            )));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_NONE_VALUE)) {
                                                        return org.apache.batik.css.engine.value.ValueConstants.
                                                                 NONE_VALUE;
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                if (value.
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public ClipPathManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dOr17UrolK/IxE/m/2jD6ZPXuFvqYo5F7glX8raVNauF27LXNak0WPxTnAes" +
       "zDkNtCTXEYYfv04dOHoyuuW5teKgUZd5LOiCU+/zv/3Xm4ETH1yeIvOUUU1f" +
       "o5BRorhkljKRGZmil5/unGh1dc6RD3/aEu+YSZJgfY3TpAH2eykYsSp30Peq" +
       "8tqBvy7cdv/w7hnE+6UeOL1Tfr/37OUHV0pH/PwoK0J91hE4k6nNDSwINQic" +
       "2VVmJuup4rtledoB6tnCroRnjeUAa7y7RQRm7k2s6Uqzcp8oz8OaJxgM5Bn7" +
       "Omu+RlE9lJbqMBQhEC8hTfE6I/PgwNa5PxkxIcnLCQj8o9aZ+PPh3dJkS/hP" +
       "wg3vmIJB0DWcCT458O6eN/mClTIPScPk8g7wJFe6qmFNgG2F1jwVZqY+wX11" +
       "7488c/15oY/3QO8hJpNHv/1Z4NBRsUVE1bM8q/Bw84jKx6NdUz4pnKP7L+f3" +
       "vXRm30G/hXsPRSURTVMIVtPr4kuf1+Zmoih03fhE9c8O1xV0w+brQaVJVd6b" +
       "JD3RTAcsMZMRF6xOoeS4o6U1y5gU+VbZoeyLrNkq3jf8l1GUdXTovL837bl1" +
       "bKwJnnWW566budPnYs3j2HvzjPFO2NzVcUJtZ+8DEHn/AopqeCpg5WtAlK8O" +
       "QolZQIiHhTvhabPMbJs5QrlY86CwP8/YAdY8Aqdz2WxX5QSm7HhjQ8XGHnYg" +
       "eXS2IFkBT4dlV8fMIcnFmsfsJ/OMfYc1k3DAlNnFDd/dOQB5YhYAqWZjjfD0" +
       "WFb1zByQXKx5jH46z9gzrDmWuYvS5cagFRvZ107XO6aoQLYu4lwxj/2MuQLR" +
       "8VmAsJaNLYMnbOEQnjmEuVjzwHQ2z9g51pwWEG4kMZxU6AAr++1AdOf0FwQO" +
       "PQfuzGwBtxiehyzrH5o5cLlYPeD4uSJ+2/5FzP6xeyRutomlQIikZAkr21WZ" +
       "2jQr8mHU2d/fxd+4ii95pNkJ15ppgS0tqiUCG7f0dqUkorMzJWd+hTU/pqhC" +
       "MghUlRx31nXBAf/F2QK/GR7NQlCbOfi5WD1wFHBFCqbbv0VQahk5djBrk6y5" +
       "yF/fmhpw9vPnnOA3rLlMUa0AVWTbqaD95f8C2hTsNM9lGqv8FmTd54s7aOnc" +
       "yerS+Se3v8vLnfQ9cSUcX2NJRXEdu9xHsGLdIDGZW1cpqmWdf12dxlXT930Q" +
       "IaHlNvxRsH5AUdO0rLAwo+lYYDF+aG2hHIwUFYsXN8+fIetPxQNqQeum/AhO" +
       "Sl5K0IJ/u+k+pqjcoQOh4sVN8gnMDiTs9aZu78d7p4erHcoLA+pQ7jLWkqZ8" +
       "2bU596GG6XzIVXovz6g3+P9C9oE8Kf4ZGpLOn9zc98ite58TF2WSgicm2CwV" +
       "cAwX13HpyrMp52z2XMWbWm/PuVC2wq4PMi7q3LpxT4Y9xC+1FnpujsyW9AXS" +
       "e6c2XPzVZPE7UNnsQD7YtvU7XP/KiL8g2lJ6Ekr+HaHscgOqdH6l1db69Pj9" +
       "q2Of/IFfeyBRnizOTT8kXTm989dHFpxq9KOKHlQEpQ9JDaJy2dw4rm4l0qgx" +
       "iKpksysFKsIsMlYyapk5bJNhFgQ4LhacVeledoNKUXN2hZZ971yuaGPE6NCS" +
       "apRNA9VQhdNj30BkFO9JXfcwOD2uopSIcMhWA7x2KNSr6/b1Y2GFzkNNLGd0" +
       "9BXwV/ZW+B/rj/nMMx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Y9/MT0T/D2jVMq90KQAA");
}
