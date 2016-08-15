package org.apache.batik.css.engine.value.svg12;
public class TextAlignManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.SVG12CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_END_VALUE, org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                           END_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_FULL_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          FULL_VALUE); }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.SVG12CSSConstants.
                 CSS_TEXT_ALIGN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 INHERIT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAlignManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ja82rGGzPfDDpLt0ueokCYeZrlli1G7bu000XHEhyunUeFpVe82gK1DrUdI3" +
       "+NVcQvvVfC3MEyRawpPhxs5BiO5WEm9Up9ycV3V5ZecAftcDMfdgjVXoTi7M" +
       "KpVGvcVKwcJKmiODX2C1rcLI7RajgW+wUZ+XWrgW8z63RpKNXK8mSo2Tgdrx" +
       "mDOTrrDOaJuJ02w2hLWZtYwD39rYbG1uwunMxngRfPNsWXseDklkvY0dXNSd" +
       "aOgiHlnzRqvuAMwZJJ01an23Qc8YeJMYGw2hFDBQ6tDdGgM1RmuZ7Xf9oBrm" +
       "y5ZORdKuPenju1FtIfgzl2q7lE5zktUSHGwhzJD51jNImRfCrFblMFXKd7Kv" +
       "NWqT6mZsoNpcRWu46tYjNhNns5q4XPUTxnVdreW0kKQrm5bGr/RVN7PqecCA" +
       "ADpCiQ3BjKip2ZBNpdFr1yqrYW8p1HXcAOubBm/lvmxX2k1eyxXV7ToEUXwO" +
       "289tR+K+cvPl+Exw4eFFxeg5fInvqx4pktceb3SVv0u32EQ/tdEIFbsLr7rZ" +
       "UV+5s/DRtz/5lDn4GHLxcINWT6G70jD6Hs/aWN6ppi6Dlt5w810UoTzpPNk4" +
       "/Ozb/+HByRvnb3kORyOvPifn+SZ/WfjE55nXGT93EbrteBvxGWewZ5keP7t5" +
       "eHdspes4mJzZQnzVsWUfKCz2OvB876Flv/fGxxM39IILpRfsx/4W+98/eou6" +
       "HyuSLIUecBM2mFuxm1rmMA7LU+2S4c2nHOYtKXR5FoaepQcnzpQ/27bO6S7L" +
       "gvSs9q8HD3GoPfHCa/+uW9T9TJH8VAq92E2IwPX1tDi4OFK/qHvriZ7veL56" +
       "vhY83UM9uy+8nh+4Rd2HiuTnUuh+t7jiUG7z3UTL9z4PLa8UhQ+BZ3Co5eCF" +
       "1/IXblH3sSJ5KoWuOFZ6pN7xueA5P77NPbx7Umr9889D6/uLwkfAoxxqrbzw" +
       "Wv/KLep+tUg+eVbr/iH+jE5U/NTzULFcAh4Gz/VDFa+/8Cr+7i3qni6S39yr" +
       "SFm2vvb2xz1HRwqvf/YjkRP60hq/9Tys8ZKi8FHw2IfWsF94a3zxFnVfKpLP" +
       "ptC9wBqsaQVpceiwv2nUPdHwc89FwzyFrp6/y1Acxr78Gfeq9neBjE89deXO" +
       "lz0l/Vl5nH98X+cuHrrTXnve6bOzU/lLUWzZbqnDXfuTtKj8+5P/0wiWNy5S" +
       "6I7yv9Tgy3v2r6TQI8/Knh4eB51m/MsUesUtGFPo0j5zmuerYLG4EQ9AFJCe" +
       "pvxrYNPzlECK8v803d+m0N0ndKDTfeY0yd+B1gFJkf1GdOT06LOb7MQ7Dsc0" +
       "v3A2UDv2lvufzVtOxXaPnonIygt6R9HTen9F77rx6ad6/R/5VuNj+2sThqfv" +
       "dkUrd/LQ5f0NjuMI7JGbtnbU1qXuY9++9zN3vfYoWrx3L/DJJDsl26tvfC+h" +
       "40dpeZNg9xsv+9Xv+8Wnvlqe/P0vivLWijkpAAA=");
}
