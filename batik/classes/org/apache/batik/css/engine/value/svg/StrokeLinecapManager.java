package org.apache.batik.css.engine.value.svg;
public class StrokeLinecapManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BUTT_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          BUTT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ROUND_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ROUND_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SQUARE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          SQUARE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_LINECAP_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 BUTT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public StrokeLinecapManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vHNOymT7ktOzo/HnsGebPXoNTFiPY03wdNt26B69CYuxljDTqRJjz2Dzfb8J" +
       "OyFWOdVYnSjwsSa1qy7XQieugYUm4tgceOK2mvHRW6gYawkr/KzE2IvY/MSy" +
       "0BqWohnFKtgdCy0YuV516YXhnrsGhmvAsbnwUFt7OnrDFWMtYZzXS4z9Gpsz" +
       "nEwAw7UnIVvCgZ9ZdWWPa4xf/i+MkYU8UejWD4+o0/L+h7DuzqWnj9RWTj1y" +
       "xzlRKOfut2ug8EllFMV7iPK8l+sGS8lCvxrrSKWLr7c5mfeZbich+kArFDln" +
       "sb7LSdOIrHCyGsyhyGY8z8mMEoxwsrJevDx/AEsV4gGxoPVSfgCbP0gJUohv" +
       "L92HnFS7dLCo9eIl+QhmBxJ8vag7++bGkc3losb2ZzbkP37lUNQwEoo8J7a5" +
       "vjJV/Jnl1HEZ6++sXunkkQ2dd1/+3BPWdZ6k0J07cZZxUL1Zl4a5A0tT0dmc" +
       "ucrXL7wy4VTVPKes9F0nemUTWIZUJK7epgfut8yW3DXXO0dXvPCrveVvQkG8" +
       "hYQoHAy25F8dZPUMnBS3xPKrVDjciYu31oWPDq9ckvrru+JyhuRdyQTpe6Wz" +
       "x+5668C0o41hMq6djIWKmWXFncaaYbWbSYNGnIyXzbVZEBH9RhVfCTwBdxjF" +
       "FCLsYptzfK4X73k5ac4v7PNvx6sVbYgZq7WMmsRpoIge5/Y4B1ffmS+j6wEG" +
       "t8dzlsladQJ6AyDbG+vQdeeSdMxSXQSb4cKFA7afildsrv4XTJU6wugeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/BjOXnseak51ex5oTpYEkC+oi/yd57DlNYWV3wKeNx5iyxvPY8sFqMy8tWR5" +
       "qEyvFckbyzG5JYLu8AI3AlKqIMS7FJaxaQQkMRzRKjt7DBSXa05YMr8igirP" +
       "vzzt4zzgS3toK1KkSLC9Q7Ru6DyPl11mFwDG3AYfoAe14p28gfBF9juKpF8k" +
       "gyNxX7W15GtHuLMCoTVwm2tbCz2S/2rp8cUAHcp5TsjH/s9CAo+++6Qx0gWh" +
       "7Xv//v2f+8lHvgLcjoBuK40BvO1Uj1RcRPs/9pEPvO7bnv6b95agChB19SPf" +
       "vP+tRavsC1P1/kJVpoxcSDGMpiX2qUqp7U1nGx0YNlguksNQtvrUvV8xf/6r" +
       "H92Hqeen1jli9T1P//i3Dt739MVTHwePPCc+P82z/0AohX7ZoYUD6KGb9VJy" +
       "DP7h40/97q889e69VPeeDXX74Evuo3/23587+ODffOY6MdStlvsiBja6Ao0a" +
       "4Rg7+pF1QUW6bH1hVuPGsI3j8z4W6luz29VVUicnAQtbmNslSJ2w54ygWCMc" +
       "liLHrCUx4sTNDpzn6WqyEudJtML4RX9Rtyq6PLP8cbr0apWgK41EYeU7ol8T" +
       "u3DWg1WT9fncUbyZKK41pdLqqFkVNQjTQwQL7cSNJoJos07VUNBqMoMXs3U+" +
       "2C7H4/q0uehXgt50F1qStVbmKScRlCuKTVzzWh6vkS2qAq9jo02wu0kDXuD0" +
       "jkWJoZ8rS2Jp2qK8I4iVWadWvM07fM0xW70Jn/NZN7dX1FaYDmEuo1sNN8yl" +
       "rMfsxibcz6khYY1nS81cjMWd4oT40pYGc2LimjjTmmy38tCY1k2fp+PKcknP" +
       "FpGzGZpLMgpsYcdmkrScLwJKHthEZjPLCOap0NqurVm/slCnCyvmFqjs5XA6" +
       "l/gw2S2pbttPxOWkmqCtxpwgrMGqLm3mu0pmez4/DW1mWif9jphxHOWo86A5" +
       "zIddxxmrokmofDh0VwMXxV23VSe7yoQWYNdGRJ5QJB1YwoxdFpcp2nRqotWt" +
       "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" +
       "n3jil5/5cnnq9797XbetOykAAA==");
}
