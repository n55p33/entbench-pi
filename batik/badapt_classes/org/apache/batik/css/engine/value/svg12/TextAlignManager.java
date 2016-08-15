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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+1Id75SiItG83nRENPs57gizx66CCevZWDM8d5p2uHPqJszHWsBMJwuMPcua" +
       "77tN2A+5yqrGanmBz2pSs+qyLXT8Kliojo0thCdsqhmeuoXysRawws8KjL3E" +
       "mp8YFlpPYjglGQW7ZaFrJ69XbXpuuOevguEa2NgieGKm9rGpGy4fawHjvFFg" +
       "7NesOU1RNRiuNwq7JRz4iVFXDtnG+OX/whhpAKr3xo8dT+dk/ftg3JgLz0zU" +
       "lM2euOMsL5Izt9qVUPTEUpLkPEA53ktUjcRErlulcZxS+dc7nwsE/F4SDkj8" +
       "myty1mB/j6LmSdmBcTSDIpPxHEVzCzDCycp4cfL8AXbUXDyQFKF1Un4INvVS" +
       "ghT820n3EUUVNh0sarw4ST6G2YGEvV5Qrbi5YXKT2agxfZr2uY9fGRQ1TIYi" +
       "x4ltkatM5X9jWXVcyvgjKyycmNjQf8+lLzxpXOcJEt65k80yHao349Iwc2Bp" +
       "zjubNVdJT9vl6pPli62y0nWd6JSNYxm2In711ui539JbM9dc7x5Z8+Kv9pa8" +
       "BQXxFuTDcDDYkn11kFZTcFLcEsquUuFwxy/e2tseG1+7PPbX9/jlDMq6kvHS" +
       "h4UzR+9++8CcI01+NL0XFUPFTNL8TmP9uLyRCKPaMKoS9a40iMj8hiVXCVzN" +
       "ogyzLYTbxTRnVaaX3fNS1JJd2GffjldIyhjR1ikpOcqmgSJ6ut1jHVxdZ76U" +
       "qnoY7B7HWSZt1AnMGwDZcKhPVa1L0tJqlSeb8dyFA2s/46+sufJfUet4pOIe" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
