package org.apache.batik.css.engine.value;
public class FloatValue extends org.apache.batik.css.engine.value.AbstractValue {
    public static java.lang.String getCssText(short unit, float value) { if (unit <
                                                                               0 ||
                                                                               unit >=
                                                                               UNITS.
                                                                                 length) {
                                                                             throw new org.w3c.dom.DOMException(
                                                                               org.w3c.dom.DOMException.
                                                                                 SYNTAX_ERR,
                                                                               "");
                                                                         }
                                                                         java.lang.String s =
                                                                           java.lang.String.
                                                                           valueOf(
                                                                             value);
                                                                         if (s.
                                                                               endsWith(
                                                                                 ".0")) {
                                                                             s =
                                                                               s.
                                                                                 substring(
                                                                                   0,
                                                                                   s.
                                                                                     length(
                                                                                       ) -
                                                                                     2);
                                                                         }
                                                                         return s +
                                                                         UNITS[unit -
                                                                                 org.w3c.dom.css.CSSPrimitiveValue.
                                                                                   CSS_NUMBER];
    }
    protected static final java.lang.String[]
      UNITS =
      { "",
    "%",
    "em",
    "ex",
    "px",
    "cm",
    "mm",
    "in",
    "pt",
    "pc",
    "deg",
    "rad",
    "grad",
    "ms",
    "s",
    "Hz",
    "kHz",
    "" };
    protected float floatValue;
    protected short unitType;
    public FloatValue(short unitType, float floatValue) {
        super(
          );
        this.
          unitType =
          unitType;
        this.
          floatValue =
          floatValue;
    }
    public short getPrimitiveType() { return unitType;
    }
    public float getFloatValue() { return floatValue;
    }
    public java.lang.String getCssText() {
        return getCssText(
                 unitType,
                 floatValue);
    }
    public java.lang.String toString() { return getCssText(
                                                  );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nLvO0gMGjxGdeev3ohr+im+1/wOSqfFiJyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vyMaIYke/1G8ICI9vqZZ285usHU0lJ/10W1r2ksXu8yn20NXR2eG3URnaR93" +
       "7WbcFpo0pVQqXYQI60tp0FjT654zsy1shNUnRGW8Nur9RpOt1BSy1Z1j4rK5" +
       "8AN24bclbikayXxhJrOa09YYTYs1NTXTai7Yq6TeNh1N6bQRzUu7FWPoRXw+" +
       "4wb8UojCiejy7YmydmxOnCgtYyaIdSIWzM6aIqrdbqK161VqK5E93qSN5by+" +
       "EybDWBe9TGyg1bEXYKNh3V4YFUuW5y7dsrB8gY/Gkltnx2tv4WgzvrcQ1vNa" +
       "y+lTKBfa9NbxR/SCFmYmIUpLGJ3hND8mrXRmkMEmTCJ+QVqtjlDHkJ3da+eD" +
       "sDFmZ5ocGk281eoJ3oL0t/Z4hLtugNUj2l4uc7eVCPpiqei2LemU6taijR4b" +
       "Vms+WlPNeVeoaDihzXrVVcpxoyoyx+vSdMnz0YqrbzszO1DqfGsx8mtRc9ic" +
       "Ef3lgrB7+NKfMi43bEzQMcFEuxY/7HUnymK2Y1tK2GFkR3ZpnLUMb2LDxgwX" +
       "+IhSPReeDwYxTzcjxNzkch5G6bht0usE72XCcDDoNtVujc18rrqJ1sHSrMxJ" +
       "Fp0N2FRA3QHb5Ia1gJtnTCNltqvNxOrWJvPtgrP0FuL1tqFQM2ZLNOHb65AY" +
       "WUNsovnrYNxFzQ4u2sJYlHBtPUPGg3DV4kcLzsVXvtpOUJeJEVTFxxm7GaA5" +
       "uSaU+mxjLTM+ykNTJocinnVFCWV77GjHe3h3mHPNhTvc7tiePTR8n51wcNDr" +
       "UpyO9pFFyvYmnC1ZCMdZEm/uFra9ziLUQJFed72xNyNn0iNR16w2Rhutr7FV" +
       "f4daZt6qSAOkEtQQEY+rw/62b8cTfuERldm25/eNfuSmls8n6GCzMGpjwmPt" +
       "pE07OqqjgzRC+9kmSVSrk8uxOA+artsXHHZitxV0OQ6YtUYYbjPgmwSbSIaH" +
       "0/KWQTBsVjGRaSyskPrMScQNusmnEm1SYBeQCdPAibrVbmVaXZE6r4zo3XKh" +
       "zGdS31Qta4q73jhXFrzbkoYitZPmY0FMSCZRmpNRp9dcTPqeXdutZ5i9Urzh" +
       "3OKBAcFp1ZiFgJ8xOVYxtaozrQ6ekVJD7XqbDN31ueasx3fmQw6u5PwmpH3S" +
       "EfnZbMQjXHdoaP5sCi82rJHrA1Ix2F0PE+HJkvLG3ISmx2MpzYajNt4f1jfx" +
       "TpcGAxabbBfYaI6h2crq6riG1k2Xs1ewu6nKpmUF4w2JDVCnNW34Kt0QV+va" +
       "nN6ttdkYCadEJ+wGZEqtWGKZt2iKxOZpheLpQac2GKt4Jlq6ZgfrqcDzmEYM" +
       "vJjy2IjZeC1k0+F6Oz+T6ggizRujdjNb9ozM2oz6PavXhKPZvCFLmJetCY+Z" +
       "TmrzRBy08i61BXBgz3pbyx7zDjanqD5BrtejZaWGSLrfH41ndpbY6oocjMzF" +
       "3KpvZdZiKgROJLzfmvL61MEFx6/LxGjFGOZWy5rkTus2mZkersI64iwWBjnv" +
       "tNj+lCIXpB7rXZxm81Ryazgq7NqLuF2B61Mzg2VfCnupoGgONVvr620nRysi" +
       "W0M79Mrhpow1bI9sJVjk4XaHbejUqg4CPB2vDJzqtqpMeyipsy2hg8m1BY5f" +
       "EaPtisbwOYHQjorVlyGseY2RsBiTg7nLOCkskLBbD6ppVRZSo82ZISXTWJ5m" +
       "WstcKzCs+tq0o2FtccYtt3Cl3VJDhGNaMkXjhD/3V9JEkWrkWB7L0+4KiTZs" +
       "F5Eq63o/Q6OYbYaZNBywuugOaa7TbiQSYjbbzaTvbfHEGRAjRNzoY5eY4TMh" +
       "dTB2udYndKxU7F51rPSlYT8Qlfpms6r6fZ4XeWPbqgXdANul3Y6gdhWZZBYj" +
       "Pctxc5T14kanqUYjQoW1aejMVzuJ1K15sAtzrJoPOzsnzo2I5rs+o4zniSoh" +
       "WWvXJQfVib3B9XA8D91BG9Upl2GRrsY5sDdnM6nhCeRwss7FGGxnky3WnNcT" +
       "jaiyamykxMbtS13L3O6yRKsn5HiBkE3VbDNkF14QQQXvM3gWDlwdpuENn86n" +
       "Goz1XJUZGtPthFhJhi1ooykpcr3QXWHGZgGz2VAxRRnRArZS7ZA9dywwbI/u" +
       "ZrsG3J6myGbSl1ujjijbPkmlDddluTYD1BuxNSz3sTUy77Y0kyHyel1uqxs/" +
       "xDVzEOs1JzdyrdIZmu1q3FR2AtmbiVUWwCPeGpDV5rDtO5WAN5eYV1tVkHkl" +
       "88fxrucro+nOGgvhrEvEMaFMfaoS1kY9YrVs6llf7eRjzMf7lqhjAWovo8hJ" +
       "8ADRJhW0OpnqOcuPehNY8aWmFWlpJIa7IckNhlR7uenQ/V0WNeB1ULcYOVOV" +
       "ime2XERL5qE6a4QagiTmnO5ujWF1sYYHTREgpkwM46G44za9uC476rKS8NtM" +
       "2WQpsebXQlVqVWvkXHW0BTHSjZbSHcXadKB0O9TCGMaugcm9ejJMDBQEMHqo" +
       "j9lF15/iiCyPaZLCpxY94bLFdrvs1Lbz1iTL5YY6yf15Lx5Pk8q0RbdrGSxM" +
       "U9pE+nXBFnIYH4cTIhWclTqSrFETJpFAc1ZbP9UIvT9cyuMQRcJsWmt5gxhp" +
       "w8Fux3WynZh26X4FZTg3hSctS6+YMdPesbts2Z0KNW7I9/rtuLbuOHBmiytY" +
       "zIejbZVlvG28S8weW9kaKOFy/Z2zWE+ZXNLi9s4b9pW6OlOEfOO3Y2YurrkA" +
       "qfCdUSeJR3Ye2W5qjhpWZI2E5TaVszUH65Q5xrRU5obMIg1q9JwSaILHFxhJ" +
       "ckt+KaUEF2XchN9MR2JTzLVGM0fxxUCCtZaWwApriHinyeqNcBlZMgxQK7CJ" +
       "ZmfW84YBm85atqwyFp0koxHs4Cw1jd0G0UJXTUq28vrUMCkRVidKe0c5ai6H" +
       "fF/lmfFugtXVFVphnKCOMMnClJUGvpj1bXnNLOFmZSKFSne1FJwJJ9Zrik1b" +
       "FLFidxFpZK1czBtG0EHwdbsfxYvlEtW1NNdZbUtK42Eda3i7SRP1uYxHzcRY" +
       "T2qVitLG8/lEXlp+dbqYrF1rE9C273jYoK6JmqXTzeqGNqUGWaWnWIMK5i0h" +
       "6Lbh+kZZmVYmzHNmIldZGWeSitqndM2aNPjNeAaHFXuwrMS8uckUzpY7k+XQ" +
       "S3d1uEYQNa+rrnaw3oeXXK/iOLzZ4BW/i0SIzlvCLpp3QPyBNbBK3zSidEln" +
       "teWu7yCLaCPNZSbu9CgBhHYhue03porjpbYc06tU6HFaqvMY47a6DJqOx7Bl" +
       "IN6sCtZkUXR6dcrMIsXWvV027SceJZH5ppfOgaGEvYqJsVt6Uw1zP2WGFJyQ" +
       "rpXouNrUFHM3pVm4xXiZloteRUIFqmWs15mtDbJey0f7uriGdQFtbOdBkK5W" +
       "tcYg4baKO+Iik9DaHJvQGzhhTFRdgW55Q94hqSnojINbM1fxRM/xa1RFs1Xc" +
       "pKO0kkltWWnmXSKcc3SvwTJOrbda03UiIJG1SylzHu4oITZlyBHRa/TqmW0H" +
       "6GSLjnFbxk0Hd7wqadH+auSOnDQiB93tNtcGsjSdtOSU8CraUmvxRO5yazZF" +
       "O1QwqE/S1GZ7qEnUGlGKSolRYVrWcKOJnbkveQi/ohrNjo8u1ppPoPVt2IBH" +
       "M07Ue4SVw3xMjRptnSLdDbFqhv18txTcamdFkXrXB2Y+xRZ6e9hQtMo0xYVG" +
       "q71JTMvjyGHNjwcTUx1guwqpjTeYTdSRdOK1mWm6JM1gzgksaTBEFa7StMj1" +
       "qyJCrOshQld0hYQJWieyOKGETpbEw4hX1y141+TZVX0xG9t+BDtpMpIFABeu" +
       "M+r41bVP0jEvk53qHNGjQVfGYUYban16BtPmuI32R3xUoTADodVxNJEZbJCk" +
       "sYHBqDr0wB6Qp3E4WfW1zUSXmYHOJ4Tem7orBWU5jcp0pkl2aQ1TK6juisO6" +
       "pwZer7qdw2D3w8LSjLJUZLQzWrDc1DoY4y+8WZJK+IiZml2YVztaU8w63KI1" +
       "3o1jZL2RIp71aEOy5by5rOVIVJcTOVhSVMZ2KvNtj28tg0wexmmjWq9Praja" +
       "6wn+QMnZQMZqfmQvk0GUdjUQtU67zVl3sEUEwSK3LFvZMVLkzPXQGw86dbBY" +
       "Js4YXTR6qtBmYzhcIc1tONeQGEeGW65KOtNd2tG2fFWJ1foUzunJhFxQwpz3" +
       "9c0Y85Bwl9T9VuTCY5fh+z4mhvlgNu9T0SAF9pOLUQ8bEZxM6YrkTJbCUspY" +
       "oc5VuvZC7UYdFhPdChfWF+rWpxq5xC4tsUVXW1KjErK8u+ZYoudMp4g91nOx" +
       "6m8mNNj0RrScOlTCADjCzQxXVDVBXD2oGHalBqfMzNcwY7QrNvMf+lCxzf/c" +
       "mzt+eLQ8VTl5dfGXOE/JzpzZnRw+QcdH5edu6s8cPp25qoCKy5Qn7vaYorxP" +
       "+vwnXnlVYX6qdnB0YNeOoAcj1/urlgp2XGe6ulzmjRM2vqvo/pmj7zh/hxvV" +
       "O6rs9AiYze50GHlwSlUeiH2wpPr79zhn/EKR/HQEXduoUR+Ip2blqfH6VNE/" +
       "80ZHOWe7vCBsqfenwTc+Enb8JoQtT/ved0c5z0rwi/eo+8dF8vMRdANId+5K" +
       "sNTQqYz/4NuVsbAl7khG7jsv46/co+5Xi+SXI+hhICN2/qT2VMB/+m0I+FhR" +
       "+B7wrY8EXH/nBfyX96j7SpH8i3uZ6Je/XemKO6KXjqR76Tsv3b+9R93vF8nv" +
       "RtDVyN1fEF2Q7ffejGwZ0NKpDRSPA95127u9/Vsz+YuvXr/6zlf539tfuB2/" +
       "B3uQgq5qsWWdvXs8k7/iBapmlHw/uL+J9Mp/fxRBT7/hS5/o6Oi65Po/7hv+" +
       "cQS9+x4NI+jKPnO2zZ9G0Nvu1CaC7gPpWcqvA8+/SAm4KP+fpfsGUNspHRh0" +
       "nzlL8l9B74CkyP437/iSDH7j102oFEaBKO8nJLt0fo05meTH3miSzyxLz5y7" +
       "cCtfbx5fjsX795u35C+9Opp89Jutn9q/u5EtMc+LXq5S0AP7J0AnF2xP37W3" +
       "476uEM9/65Gfe/C544XukT3Dp15xhren7vzIZWh7UfksJf9H7/yH3/Mzr/5B" +
       "eUPx/wCqxgcCVisAAA==");
}
