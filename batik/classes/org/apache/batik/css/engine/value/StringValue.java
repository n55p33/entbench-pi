package org.apache.batik.css.engine.value;
public class StringValue extends org.apache.batik.css.engine.value.AbstractValue {
    public static java.lang.String getCssText(short type, java.lang.String value) {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return "url(" +
                value +
                ')';
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_STRING:
                char q =
                  value.
                  indexOf(
                    '\"') !=
                  -1
                  ? '\''
                  : '\"';
                return q +
                value +
                q;
        }
        return value;
    }
    protected java.lang.String value;
    protected short unitType;
    public StringValue(short type, java.lang.String s) { super();
                                                         unitType =
                                                           type;
                                                         value = s;
    }
    public short getPrimitiveType() { return unitType; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        !(obj instanceof org.apache.batik.css.engine.value.StringValue)) {
                                                      return false;
                                                  }
                                                  org.apache.batik.css.engine.value.StringValue v =
                                                    (org.apache.batik.css.engine.value.StringValue)
                                                      obj;
                                                  if (unitType !=
                                                        v.
                                                          unitType) {
                                                      return false;
                                                  }
                                                  return value.
                                                    equals(
                                                      v.
                                                        value);
    }
    public java.lang.String getCssText() {
        return getCssText(
                 unitType,
                 value);
    }
    public java.lang.String getStringValue()
          throws org.w3c.dom.DOMException {
        return value;
    }
    public java.lang.String toString() { return getCssText(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "juMXfIrD7f8CdYm+MQEeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2s6V5AzILuSmQs8yfjvHbsufrrly1JHZDu4Q8W77z4Elv/0f/uNZTsiB+jKB" +
       "eIJfhJ/84O3NN34n5z9EzIz7rvWzFzSw2z3kLX/M/red+07/6Q50rQhdUPa2" +
       "0vkSBXBIBNvHYH9/Dbbbx9qPbwW3+56HDlaEO07OhCPdnsTqwwgE5Yw6K589" +
       "Ac/nMi+/AqTyHnKVT8LzKSgv9HKWe/P8Ypb92D4aXuf5bgi01NRcNgqiPV+Y" +
       "s4fXbcE9y9+YZfR2PPHnHHvyuGZ3glTb06z2HJpxz6FZVhzsq3QmcsxwvOcE" +
       "5IRW4+fVKpeyPgWsvaa8W9stZs/i5fu9Kiu+GiwSQf4KAzh005GsfUVuXVjK" +
       "xX0QmoBXGhCSFxdW7XLeQv/PeoGZce4QVGgXvD686x/f86Vfvv+bIHy7ewMC" +
       "ovYI8jBR9kb180++787rH/vWu/L1DTht8nPP3P6mTKpyJeuy7M1ZdmnfrNsz" +
       "s7h8q0hLQdjPlyRNzSzLRRSP2FMNwcIGVPyhrQ3P/V0HDSh8/0cXRXma8Gtk" +
       "gq2D2UyHmTDpJCLl1yLcsOeb7ghfG9K4XzJn1JCnOp2wpsCyGaslS8XQAkcY" +
       "Xd5gQpLnuqPynCwQPMGOOLO3MpnikuVDvOQVl+6oaHLMKFwVedsal3r4Kmx6" +
       "YRFWbdXG4NTRKX5lW51Z3UGcOI3Dgoyptuz1kw3HDifT7iJkVsZEDpmZVWYl" +
       "hrFXnCeV2qpsYvHAKoaFMlI3E5oY92ZVzp7UqKqo2GZt5E2WJak/JvmiWbSl" +
       "ca/IWM0Z62LRklwIta4ku1N30+erm0HYI1ZBQFXrHEsazTLX5oQSYQ/sZWAk" +
       "ZZsYz9rsimyZXYVAzRVKy/SE5Lpa3JbnKuYaGlaSB61l20FoKmKjaD5YTQo9" +
       "sWua7KrXW09Wm65nxdWBH3WsiTMTPQsVkRVhBWS1ytCYNUqwgiCVEWVQr4tr" +
       "crZhGaLkCK21T9QmxVDEbLc6ngrT0lhSfYkV0aU3ITZlY9jnOkN+MB4150XZ" +
       "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" +
       "YXthfhGf/t6tv/3633jiG/kNzf8Cf8z9GUsoAAA=");
}
