package org.apache.batik.css.engine.value.svg12;
public class MarginShorthandManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ShorthandManager {
    public MarginShorthandManager() { super(); }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_MARGIN_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public void setValues(org.apache.batik.css.engine.CSSEngine eng,
                          org.apache.batik.css.engine.value.ShorthandManager.PropertyHandler ph,
                          org.w3c.css.sac.LexicalUnit lu,
                          boolean imp) throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT)
            return;
        org.w3c.css.sac.LexicalUnit[] lus =
          new org.w3c.css.sac.LexicalUnit[4];
        int cnt =
          0;
        while (lu !=
                 null) {
            if (cnt ==
                  4)
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            lus[cnt++] =
              lu;
            lu =
              lu.
                getNextLexicalUnit(
                  );
        }
        switch (cnt) {
            case 1:
                lus[3] =
                  (lus[2] =
                     (lus[1] =
                        lus[0]));
                break;
            case 2:
                lus[2] =
                  lus[0];
                lus[3] =
                  lus[1];
                break;
            case 3:
                lus[3] =
                  lus[1];
                break;
            default:
        }
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_TOP_PROPERTY,
            lus[0],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_RIGHT_PROPERTY,
            lus[1],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_BOTTOM_PROPERTY,
            lus[2],
            imp);
        ph.
          property(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_MARGIN_LEFT_PROPERTY,
            lus[3],
            imp);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2MZseWZ6w5JilcpumYyqpZItStmtUgHrqp1pyps+qZvcdGKuVBz1lwE3DTlV" +
       "xtrFZF3Epqu4XycLvUmSRrAe8GsEq/UwB2TDb3lL9mr39pf2dn1HfpCwf4UE" +
       "Xqqzju5LeKvcdj2QFQ/tHz7mnzN71w1734cPHw9OpE7sHVqUXvyg/fjhevaS" +
       "/ZrrXSrlL9hPv/eJp+TRJ4sndw8B5yF0S+i4bzKVtWIe0uIUkPTI9Q8TBvmd" +
       "2sHh1Bff+y/3TN6qv/MlHLnfd0zP4yJ/ffDMlzuvkz58Erpp/6jqqtu+o0yX" +
       "jx5QnfOVMPLtyZFjqtfsO+Xi3rH3m3ad8qZrH3tfM4BO5AG0DZsbnLFGN+iL" +
       "s8INofOaEtK+k9+bDne17x4Em/diRxiH5eYN1r6Jd2aNrwdPZdfEyo/exPfc" +
       "oO9ns+KnQujlRoDahiWE2Qn4nq05B3toPc1C6KzoOKYi2AfmP/bDmv8QeC7v" +
       "mn/5R2/+4zfo+3BWfDCELhrZRXp+0rVnfNbzvgMrf/GHsDK/vsnuM4ldK7Ef" +
       "jZWndoFgF44euhEc4SxL5LU9auylg9elvbnpgjZT8fdEvSoTFZelXEIgSDuU" +
       "khiSYE5tI794eV+u/cePaX/iKJjevSdEdqyd1mhAgD3NzRAqZ346Kz4GoDBQ" +
       "tifmwbWC89TaMeQDnz35UnyWhNBd174QzW537r7q7xrbvxhIn3nq/M2vfGr6" +
       "1/md4P7fAG6hoJvVyDQPH8Yfqp9xfUU1csNu2R7Nu/nXZ0Po9f/Hy9sQOp1/" +
       "53Y8u2X/zRB64EXZw90j8MOMv73rw+swhtAZ5SB2dnl+D4DGtXhC6CZQHqb8" +
       "gxC6cJwSaJF/H6b7oxA6d0AHBt1WDpP8CZAOSLLqF9y9yKm9+JShYhD6grQN" +
       "ne21VJqcOLSb7q7ZPGwuvljY7LMcvv7MduD8rz97u2W0/fPPFenZp8jhu56v" +
       "fXJ7/SqZwmaTSbmZgs5ub4L3d9wHrittT9aZ7sMv3P7ZWx7ayw5u3yp8gB+H" +
       "dLvv2nedhOWG+e3k5ndf+Vtv/tWnvpFfePwvv6eLHJMlAAA=");
}
