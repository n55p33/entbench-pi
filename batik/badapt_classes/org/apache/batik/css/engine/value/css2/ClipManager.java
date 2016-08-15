package org.apache.batik.css.engine.value.css2;
public class ClipManager extends org.apache.batik.css.engine.value.RectManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CLIP_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.InheritValue.
                                                             INSTANCE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    if (lu.
                                                          getStringValue(
                                                            ).
                                                          equalsIgnoreCase(
                                                            org.apache.batik.util.CSSConstants.
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.ValueConstants.
                                                                 AUTO_VALUE;
                                                    }
                                            }
                                            return super.
                                              createValue(
                                                lu,
                                                engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_AUTO_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public ClipManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fo8fHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o0HS0xXG6U2VYWF4Ve1U2nOO8FszX3SjSmeT0nPer+P53O/P5Dgf1vvotuvO" +
       "FptUrLThQdity2MF48aSOBmtJnJtoA95DVOm8MQLtU6n0qiEo3zbqxuEHVWH" +
       "dpdh2pbBVXcsKrGDzQ7ertUdXpeWjCzX6kID4aqMxFv6aFzdqUNG8S0M3TIj" +
       "vx508b5i5c56GxIdnWGDRAzdtL4WqIW9WotNt29ItA6ic9qJV3MeDlopXDdx" +
       "J5fo7a6+yJS2E83IlrsLd7MJs+41fbLdmNRJvlWdbNrMHOu7SxvXpHyc9dBe" +
       "v4d1FIpiUK7Fh3ptrG3n80YT7Bqd/sJlZsbAbzPCytaROhVvhVqw1MMwq7Sa" +
       "UjPIRNI2VKzW90265kgDMJdNdcPw6JBpw7WRvJlUjVo/V2dqaxBkcypG8QhE" +
       "V9EbCas+Wh32Jw6CUCPfRCM4rlFUu75qI8sKvuC4iTXfIAIakMbWNwTDbWww" +
       "q9bkKzU9ilhForyxNddGIIwSwyaCxZSfSumsunO3JsOzjRa83dZc3t6KS9le" +
       "KZ1d4i5wUiYTgG1OUqtmwgcrrOdXzEEft3c1Z5qpNkMllKDq1MzLNXPe6GjL" +
       "BpLKMc1iWXVbG9QdGu60qcUmqgsxvyISe0HTi3Etn4xnTWnErfOVrHsgbDfp" +
       "aqw6C9ZKpTZCtBa0NGKx1JP8eD1op1NuMh9ZnaYei5ruztJ8p+gJvHUN16rk" +
       "QoVhq7wewK3deNESEWOAJcOe3Fw0NyM6ZWwmJKvrqbzB0CCIvVEqCWY8z6mu" +
       "gKnaZkkqzVxZNTtBWxzv8LEcMfYwWgbL8STtOuZE6jDKsrId1tyKZhGmP1Zn" +
       "RkC0zUXUq43aJtVBh91Ky4omTkiM8jo5hPtsTVgYcStr+csBmw6ayDbtI+Ou" +
       "lySwy3uR3qzPbJQnzLSL99xuY2gxJs6zqj2n+Rm+mFoJs92MVLeDV2qu2k/r" +
       "IHkQIh3eudqsvWUGab2ZtUli1kTspSG08h0VEFyFFXUCjfvpZCSIW5VtNepU" +
       "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" +
       "Kwe7n3/tT3/Vjz7/p+W15/8CqJYAQVApAAA=");
}
