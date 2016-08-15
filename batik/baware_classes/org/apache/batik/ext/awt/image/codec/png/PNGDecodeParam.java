package org.apache.batik.ext.awt.image.codec.png;
public class PNGDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    public PNGDecodeParam() { super(); }
    private boolean suppressAlpha = false;
    public boolean getSuppressAlpha() { return suppressAlpha; }
    public void setSuppressAlpha(boolean suppressAlpha) { this.suppressAlpha =
                                                            suppressAlpha;
    }
    private boolean expandPalette = false;
    public boolean getExpandPalette() { return expandPalette; }
    public void setExpandPalette(boolean expandPalette) { this.expandPalette =
                                                            expandPalette;
    }
    private boolean output8BitGray = false;
    public boolean getOutput8BitGray() { return output8BitGray; }
    public void setOutput8BitGray(boolean output8BitGray) { this.output8BitGray =
                                                              output8BitGray;
    }
    private boolean performGammaCorrection = true;
    public boolean getPerformGammaCorrection() { return performGammaCorrection;
    }
    public void setPerformGammaCorrection(boolean performGammaCorrection) {
        this.
          performGammaCorrection =
          performGammaCorrection;
    }
    private float userExponent = 1.0F;
    public float getUserExponent() { return userExponent; }
    public void setUserExponent(float userExponent) { if (userExponent <=
                                                            0.0F) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                              getString(
                                                                "PNGDecodeParam0"));
                                                      }
                                                      this.
                                                        userExponent =
                                                        userExponent;
    }
    private float displayExponent = 2.2F;
    public float getDisplayExponent() { return displayExponent;
    }
    public void setDisplayExponent(float displayExponent) {
        if (displayExponent <=
              0.0F) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGDecodeParam1"));
        }
        this.
          displayExponent =
          displayExponent;
    }
    private boolean expandGrayAlpha = false;
    public boolean getExpandGrayAlpha() {
        return expandGrayAlpha;
    }
    public void setExpandGrayAlpha(boolean expandGrayAlpha) {
        this.
          expandGrayAlpha =
          expandGrayAlpha;
    }
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    public boolean getGenerateEncodeParam() {
        return generateEncodeParam;
    }
    public void setGenerateEncodeParam(boolean generateEncodeParam) {
        this.
          generateEncodeParam =
          generateEncodeParam;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getEncodeParam() {
        return encodeParam;
    }
    public void setEncodeParam(org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam encodeParam) {
        this.
          encodeParam =
          encodeParam;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeOye247edl/NyXk4gD+6AkIZgSnEcJ3F6caw4" +
       "sYoDuaz35ux19nY3u3P2OWAKaVFCHzQNIUAElioFhaaQRC1pi8ojCFFAQCUe" +
       "LYWKgNqqoaWhRFCKoC39/9m927292zUn9bC0s+uZ+Wf+/5tv/v/fvXnoPJlo" +
       "6KSJKizERjRqhNoV1iXoBo21yYJhbIW6qHh3ifDhjnc7VwdJaS+pGRCMTaJg" +
       "0HUSlWNGL5kjKQYTFJEanZTGUKJLpwbVhwQmqUovmSoZHQlNlkSJbVJjFDv0" +
       "CHqE1AuM6VJfktEOawBG5kRAkzDXJNzqbm6JkCpR1Ubs7o2O7m2OFuyZsOcy" +
       "GKmLDApDQjjJJDkckQzWktLJMk2VR/pllYVoioUG5ZUWBBsjK3MgWHCq9uPP" +
       "DgzUcQgmC4qiMm6esYUaqjxEYxFSa9e2yzRh7CY3k5IIqXR0ZqQ5kp40DJOG" +
       "YdK0tXYv0L6aKslEm8rNYemRSjURFWJkfvYgmqALCWuYLq4zjFDOLNu5MFg7" +
       "L2OtaWWOiXctCx+6e0fdT0tIbS+plZRuVEcEJRhM0guA0kQf1Y3WWIzGekm9" +
       "AovdTXVJkKU91ko3GFK/IrAkLH8aFqxMalTnc9pYwTqCbXpSZKqeMS/OCWX9" +
       "NzEuC/1g6zTbVtPCdVgPBlZIoJgeF4B3lsiEXZISY2SuWyJjY/PXoQOIliUo" +
       "G1AzU01QBKggDSZFZEHpD3cD9ZR+6DpRBQLqjMz0HBSx1gRxl9BPo8hIV78u" +
       "swl6TeJAoAgjU93d+EiwSjNdq+RYn/OdV99xo7JBCZIA6Byjooz6V4JQk0to" +
       "C41TncI+MAWrlkYOC9Me3x8kBDpPdXU2+/zipgvXLm8685zZZ1aePpv7BqnI" +
       "ouLRvpqXZ7ctWV2CapRrqiHh4mdZzndZl9XSktLAw0zLjIiNoXTjmS2/vu6W" +
       "4/S9IKnoIKWiKicTwKN6UU1okkz19VShusBorINMokqsjbd3kDJ4jkgKNWs3" +
       "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" +
       "e55oPs/If0YNPMsf8em5/wG5gu71ijAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zr1n2f7vX7xvG9thPHcRO/cpPapncpiZQoxU0TiRJF" +
       "UiT1pCgxXW4ovsT3W6SYOk2NtQ7SwQtau0u71sCABN2yNCmGGm0wZHHRdW2Q" +
       "bkC3YOsKrAmGYumWpkiGri2Wrt2h9L3ud7/7+V7c6wngIcXz4O93fv/zP4fn" +
       "HH7hu6U7orAE+Z690W0vvqRm8SXTrl2KN74aXaKZ2lAKI1XBbSmKpuDeZfnJ" +
       "Xzv/lz/49OrC2dKdYulByXW9WIoNz43GauTZa1VhSucP73Zt1Yni0gXGlNYS" +
       "nMSGDTNGFD/HlN5yJGtcusjsQ4ABBBhAgLcQ4NZhKpDpraqbOHiRQ3LjKCh9" +
       "vHSGKd3pywW8uPTElYX4Uig5e8UMtwxACXcX/2eA1DZzFpYeP+C+43wV4Vcg" +
       "+OV//JEL//K20nmxdN5wJwUcGYCIwUPE0r2O6izVMGopiqqIpftdVVUmamhI" +
       "tpFvcYulByJDd6U4CdWDSipuJr4abp95WHP3ygW3MJFjLzygpxmqrez/u0Oz" +
       "JR1wfeiQ644hUdwHBM8ZAFioSbK6n+V2y3CVuPTY8RwHHC/2QQKQ9S5HjVfe" +
       "waNudyVwo/TATjtbcnV4EoeGq4Okd3gJeEpceuSahRZ17UuyJenq5bj08PF0" +
       "w10USHXPtiKKLHHp7ceTbUsCKj1yTKUj+nyX+5GXPuaS7tktZkWV7QL/3SDT" +
       "o8cyjVVNDVVXVncZ732G+Xnpoa988mypBBK//VjiXZrf+PHvf+jZR1//vV2a" +
       "HzohzWBpqnJ8Wf7s8r4/eBf+dPO2AsbdvhcZhfhXMN+a/3Av5rnMBy3voYMS" +
       "i8hL+5Gvj//t4hOfV79ztnSOKt0pe3biADu6X/Yc37DVsKe6aijFqkKV7lFd" +
       "Bd/GU6W7wDVjuOru7kDTIjWmSrfb21t3etv/oIo0UERRRXeBa8PVvP1rX4pX" +
       "2+vML5VKd4GjhIGDK+1+23NcMuGV56iwJEuu4XrwMPQK/hGsuvES1O0KXgKr" +
       "t+DIS0JggrAX6rAE7GCl7kUULVNKY9hwgPyw7AHBYB+Y1pDrddTi77BotpcK" +
       "m/P/vz4tK7hfSM+cAbK867hTsEF7Ij1bUcPL8stJu/v9L17++tmDRrJXa3EJ" +
       "AwAu7QBc2gLYOlQA4NIWwKUtgEsAwKUrAZTOnNk+920FkJ0pACEt4BKAs7z3" +
       "6cnfpz/6ySdvAzbop7cDFYqk8LV9Nn7oRKitq5SBJZde/0z6k7OfKJ8tnb3S" +
       "+Rbgwa1zRfYtmAPXePF4ozup3PMv/ulffunnn/cOm98V3nzPK1yds2jVTx6v" +
       "5tCTVQX4ycPin3lceu3yV56/eLZ0O3AVwD3GEjBn4HkePf6MK1r3c/uesuBy" +
       "ByCseaEj2UXUvns7F69CLz28s9X/vu31/aCO31KY+zvBMdmz/+25iH3QL8K3" +
       "7eylEO0Yi60n/sDE/+U//Pf/A9lW977TPn+kG5yo8XNHHEVR2PmtS7j/0Aam" +
       "oaqCdP/1M8Ofe+W7L354awAgxXtOeuDFIsSBgwASgmr+qd8L/ss3//iz3zh7" +
       "aDQx6CmTpW3I2QHJ4n7p3CkkwdPed4gHOBobNL/Cai7yruMphmZIS1strPRv" +
       "zr+38tqfvXRhZwc2uLNvRs++cQGH99/ZLn3i6x/5q0e3xZyRi47usM4Ok+28" +
       "54OHJbfCUNoUOLKf/A/v/oXflX4Z+GHg+yIjV7furLStg9JWNHjL/5lteOlY" +
       "XKUIHouOGv+V7evIgOSy/OlvfO+ts+/96+9v0V45ojmqNSv5z+3Mqwgez0Dx" +
       "7zje0kkpWoF06Ovcj12wX/8BKFEEJcrAq0WDEPid7ArL2Et9x11/9Fu//dBH" +
       "/+C20lmidM72JIWQto2sdA+wbjVaAZeV+R/80E7c9G4QXNhSLV1FfmcUD2//" +
       "3QsAPn1t/0IUA5LDJvrw/xnYyxf+219fVQlbz3JCP3wsvwh/4ZcewX/0O9v8" +
       "h028yP1odrUvBoO3w7zVzzv/++yTd/7O2dJdYumCvDcynEl2UjQcEYyGov3h" +
       "Ihg9XhF/5chm140/d+DC3nXcvRx57HHnctgHgOsidXF97pg/ubeo5WfAwe81" +
       "Nf64PzlT2l58cJvliW14sQh+eL/53uWHxhp0+3vt9+/A7ww4/rY4isKKG7tO" +
       "+gF8b6Tw+MFQwQfd01vBUMsHZhG1bH8lnS7yMDQc4JnWe4Ml+PkHvmn90p/+" +
       "6m4gdFzRY4nVT778qb+79NLLZ48MP99z1QjwaJ7dEHRbZW8tgk7RRp447Snb" +
       "HMS3v/T8v/pnz7+4Q/XAlYOpLnhX+NX/9H9//9JnvvW1E/rqu5aeZ6uSu3Pj" +
       "RVgtgg/tard2zUbz/qslNfckNa8h6egakhaX+JZ0B4gDHJXkKkPJVuN4C5M+" +
       "Bm18g9AgcLywB+2Fa0CbXw+0+8Bo30/iRtuIe8DNnoRtcYPYquB4dQ/bq9fA" +
       "dvl6sD0EXh6Kzr0nOY6Ee2G46yBOwvjRG8T4PnB8eQ/jl6+BUbsejPcmkRp2" +
       "M99z1b3X1t6ekRenfly4E0+Kj8HVbxDu0+D48z24f34NuP71wD2vGJFvS5t9" +
       "xMVt6xi44AbBPQse8tgu6e58Arj0usDtmklhh1svdpLQ2Q2CK4OHYHvgsGuA" +
       "+/j1gHtQ33O3XfdgbH8SwJ+4QYCgoz7T3APYvAbAn7oegG9RD4FtU779Bl9a" +
       "jhE7wumn35DTzubPgJ7sjuol7FK5+P/SyahvKy6fAiPWaDvbUrQQw5XsfRrv" +
       "MG354n4fN1PDCLT4i6aN7VO6sB0pFR37pd2UxTGsnevGCrqh+w4LYzxXf+5n" +
       "/uTTv/+P3vNN0KXQpTvWxVAC9D1HnsglxYTQT3/hlXe/5eVv/cx2AA5kmP2D" +
       "HzzyoaLUXziNcRH8bBH83D7VRwqqk+37LSNFMbsdM6vKAdtjnuR227sJtvED" +
       "NolGVGv/x1QkvJrK2dhRBxu1imKqYsPcZm6hegeqtyxK1CduV6YRoi5LKRot" +
       "vE4i5UgtySpNd4EkyLA6EFp9aUbgZD7iKL7VtQ2PWEnSaIxXfKPhmThBtEY4" +
       "rzILoa9zQeBJwmpM4H0PR5pw02lWsWqzmvNuc4mXIygRIUGD4Fq8htewtp67" +
       "3pC2vXp/QveNvDs2x8GK82YVY+61vWpls6BXS0qoB+QKMbTOynRlbJYqtDSB" +
       "/N4YZ6cSrZdJfmILXI+pWWZ/tJgSdFdyxWmP79OMny5nq3TkBLy3diaeSI5s" +
       "zrYm9HJGm0RnXcbJoFtpJWx9RmtW3B1IabtXs8YtK+/MaS4Plk6dtnB/XOGX" +
       "EeZVB5hTHRDJRowG8qbXd5hOy++MTJOmO5ZsjXLBihmataqzMezb9mLmGR7f" +
       "q4m80G5HZh9hdYHEg2YyHHb0nJdHuoOjgcE6dTVa8FJgZt1FRkykplrd5OMV" +
       "hi8Qq0ZRwXxcFoNRzfLRcoce9BZKvxzPF+syU5f6kd11GiG3UJ3xxOTHhEBb" +
       "2nqhO0GLwYVkwQRoDogOGC6psYSOMdVBLAnCwJjLMZ5BdbWsKdNyTC1Bfdri" +
       "OJl15S49XrFlPWmVrZFWWSCCQOU91XKaLW+tTOcz2urzzYrlIT2iD1Nhy2LI" +
       "hkQEGQtezl256S/SaYAv5/5E7AcqO4EHuDBvcnk3weGKXs+ny1k8xJWZPmzb" +
       "IuXRukqgbcSOjO5cpCaL6iQRNrS5gIdzbzSgbIP3epVWzpcro3Zf1zsTkRC7" +
       "pN9B5E5THEP1jj9uj5jAZPMy2Z5kFX2c2c320GusqBnWSKLUrk9VuuW1dJNv" +
       "IgrUNdKJySkBNF648ECZNZuZh9FtXKRa9fbG9Ly8PkPpkVWOPRytAEIUxLaE" +
       "0LYWA7zJqkjWsNodf6jM+SoE54avr+eM06g3arkoViR16K+xduBSXsKM134w" +
       "FzE5FmZVXPLHYWCQK9RRxNxVRLs5nwBbaaXlnDEpg/PmU9OZVOF1UhdQeNKk" +
       "+q5H9QWjb8jTtM/Veb7iWVZeac4mqyRqg/dDjvWsIDKXCmJ1aNS09D4nREgG" +
       "sT1xXLH0aBNO7Dk0LLf41aY78nQftf0J6riY0O4sW26FlShpxDIh1Q+tmgGv" +
       "uxiFDlet6aydopTXB61xFcZlQi0jadLOIL2z1OctLSJr8yqBTwd2Kw0HYXMx" +
       "IlC2i8fteCOmZouZpPYCDlsUYumsVMbjMMIq0saFquh8yXkTuYxhfHVGexA0" +
       "XY1auCAul8u+bKRuLnmylwe8RoxkC8FW4+GYKOc4OpEyvsdZxEQfsSuekkcC" +
       "iqc8MbI37S4h6+1W0I1WvK6PcE1JvWBhU23CpeZJa5puZjMmceBFQg5hfcXo" +
       "XmfRaM0W7WSDUYZVieO4SQ3gxFOZ/gq8zTSimtwkJ6MpFYxB2fbE6pB8DDii" +
       "7LQ7VxZQCAWdoMeTJuIMUIoYTysK0dOHWm0864YE2a9MesEiL5t8lpp+l10u" +
       "k36qVDt0kDdqcgNOwymirTtjSo/drBWoMt5HB9nUhnoCrGLDxRSSpRjRtCTb" +
       "yEOzHlSzht4fDRzUmQxozshStsFy08pYHlgNlJxXGjHtdoa61RisOL2N9vMl" +
       "yQwtVRgJMTMghbLfRodm4KMjsZf1F5W83XbHlWofW9l9xM0rgxbhC+ioqrUq" +
       "QiUW5hhZcSzJjjnOMIbDObFM0SE5WyYIhMCwE24iFBlYKA/FVJfxfAkhUW61" +
       "ifR5kql+UhWQWd9TmssmMlVURatpSlQT6ySZuumUc4Zi20Q5e9XW10m1hghQ" +
       "Q9OWnlTuLWvpBlcxaigHYz6zjIjOeGgc0ZFRrTTTjtZHO70RJyNLYoC7BK12" +
       "h75rZGsfwSSGma7hpmkG03bO8H7PKWvDtI0NPVFq6DED5egsYzXaaBtLBrza" +
       "YInYcaHNcN4PQz0yg64WVGzNQYZJJHegbsftzFfhhJT1JjtoSV2m6feXa8he" +
       "MzleWS76RlnoWXAuQo1kPCrPiVa92eQ5JE/H7DxhluJEXOXhVKYFL6aZTSr4" +
       "1Q5aFzA37nbTdtDRCEGuh3VomiNpj4KXuIFT6MIZ5J0A3dgyzwaw1o1MVVPd" +
       "UMp9hZmQLSUQ2zNqKQ5QOmGnLbrKV9nWGmgJNYNKLaEGdpkbZ+WyPZCX7gzv" +
       "tGSYXc/nMb7I8mi4hGQ4MmdZYzmQfdGvrYw8GaaWMszEuS+4jfWyN1xjQRA3" +
       "VAgiV4spKwoDJs5n2cYUm4m9XgNn1JuSrFEjG8k0YExLbbBDZKrmmBgiCZPH" +
       "PIHXByK/DNmWX8X6c7IMN1jM0Js0cEZqZCtSfzZYy5S86iOgv7aM8qLuosvy" +
       "IIiaA5gHrWIjmOxAxuaiYzquEkbpwFrj7Frr1aqJ0AzcFm03+pVcCRfVZq72" +
       "yx10lMrzZGHMJ1gPpQflaGOOFT2Ww/qaEuxpvcPaFAdJci/rcJI4QlR0SRn9" +
       "srTGnInWmhGjideZ9jB6kjUSTPFCzMHW0LJDr8YrtB01Yb7dGGoYYjcb3XnC" +
       "R1GWOzVOgCDKW+FDUqs3chs0U1hn0uFMWxNtP+y0pxG1qPZTSLbLVteSHcgm" +
       "R2K3XYtVcj3X1Aa0bId6zYdCtlmB651EW0EoKg59ulGtGAu+hmO1UYZsVqyM" +
       "dbxxgjhQA8FpRVIGuVsPUoVs1myJE6ZuliBpfa2lGIzliwSMIGvY0EKCWRMM" +
       "5Kct3kazEe7Mxv5kvaw7XSleL5FqNGI5Wo3AGE8dNYKRgfHYxLT16qyRsCLd" +
       "NFM1RQgxgW3XQQdU2rUjqu50usJmk2TVnjGJ5PnUw+Y25rXbRn3TIc24xZEy" +
       "8B2EHLgx3Wryq6i16ofdZNQXhrKBl5OlwBJSGLFhiAgaGTXjNlKuKCLj+F1J" +
       "ZTXeSvI+N6aXnVp342IBhttTRA7NXthyySE3VTApSex83NXUVs938nDFj3GJ" +
       "4CrIKG1CylTAK2OMnW2GwoqF6wFR3dhKzFTtXuBTvYoST53AH9VrXN/GZmZj" +
       "ueQa81QZ1aEEjzbNTOtoAb1GqHQuJa1J0tyUYwRW04aSQJzr06MqNbXSjCOs" +
       "5UR0mErQXWvVNOSV3FoMYy2SYiyvD2NliJSbPk9ocq1h1BF7tInUFZYJHlbn" +
       "0/LGDzObV6EVBngrgDdJw7OFLNnyJsSmNYWp5yO60mG5OJCayxlphlq9nuR2" +
       "PjJtwM+WowqxNutYyMwW6mJM5qxSRcbi2EagWdmXkYon181gU+m2paqUQBZD" +
       "NRRS1Fcql7fKS3Mwq2kVUreGQIAysYoa6WDeliqISaC9+tIJ5hNmSk08LO65" +
       "LWtJb2oW0ujV+4rO1GYy3B6a+RIJN65FpVOBWyC5MyJhN43F1GbWLqvGm5DD" +
       "gCvM6znfGaRr1DWB7xRpbNNurtXErDUXawIMyqFUmbImyUJxb8HEwH57bb4u" +
       "8raykdGAcCSPHTti1MYTbLyoxOEa0fkyRNSjzbLhq56JrW0KRuNhWTZqA7Yy" +
       "nE0rCcK6miPEmNYONKKawBBGElJZCnOIbjragGu1s0l1iXrzDjqZB2xsjRFm" +
       "mfIivEnVsc+00c60lc7ptWPUqdFqtgjFQaeitul0E3PdaIHNcVmjJs0FuRJF" +
       "qDrDCLQsjTm1jKpSNMx4k/BljLPLjSqRQl17sKrF+drXGzoqLGtGeSOTVm+c" +
       "TDk0JixBQpu208NAC+pummOyNtQaVQszGzOt17dIw8kHU60WD1l0ZmwGCzrb" +
       "ZGbHnwzaNdVLuKzWBg2lAwBYbCuTddLwWIvMBAa8aATWaiCIE7nfbsyYCrd2" +
       "0u5Ei00qwnE21/GxggRNuTdLcV3oj/3RICnXxMxP12TGx2WSobo9N285C5rg" +
       "Fm0TogjT2ogjPh2n9ZCISTsD7WoBCVMdnQcUFEdwRRITQD5Do5SZLMlBo9Fj" +
       "NH6ccIIsGBsdvGDYluMCnp1Jc7ysB6wcDuZQuTVJE8rQ2Sm1ksdtiwID4nGH" +
       "nZr1DTYMPLlrNMZkOZonyLTiMQSxSMutLinU1ra0aA02kWdkdLPtgX5BxVOm" +
       "yyOjhhnk+UjgO0RQbRl+d06MFK6yGoUQnuKiGMXlmseMizphNW/pN6r5YNRx" +
       "JyJXXXMNn+m2q7M0csJJi5tEUVBZ8B3PmNfJ1Visy8O+W1ksO4pv6fKsXa4m" +
       "TCZytodvKr7prKdtft0dN80uhsaDnuhErRbVHLToJGquPUT0uibhWd4yVZr0" +
       "lI2M1WJo0FNPnWlLlCLZKWHZrWzd7mZWb+5NKJ3NhktGlwh1k+eq7pOZteYz" +
       "uN0cOlVkgfXm1jgs92NbNzlb1/rxgmOsPkPZEmHxTLvBMRU6chbNPBjldVD8" +
       "0mijOAVeTyg9Q0l4BVF+DxcwDrwSUhudVZVFQDo8P02zmR1BmpAv63CGiYmE" +
       "LmZC12bVaZTkDU9ZZ2Bo5HN4LWP6a9bFkBqGTtosv0jggNHctuXr436Mc9l6" +
       "soYoS12sqQihgGGDrqtm+6ytEcEURSZ2xaSJHrNxR52y72LQgJ2y7ryH+Hhd" +
       "zWsszlUwH02HWAODahXDZ5kkKxs+pHaihskuyGWooxvWqWbxSiZRr802shWb" +
       "5R3czVnYi+hcQyfwlG9MjFl33lUli6IgkjSbPc3wSVcf4IFKcuuFqg6IMM90" +
       "MvAmokAOydXGZi2mnw85RSM6jUon12RsWhb6/NJ2M0GuhhNvPSahuT9dzBMy" +
       "D2mk23OItbRYWVW1Pl2lYi46nXG1Ia9BD2LD0ny9oixdLVtUp7VR5+vEWEC8" +
       "HU9pd1AdI214rKYThURngTCnrRod2o053NBFyKdUaYiFgyZU1ogKiimNQdjO" +
       "Ao4bzRixNR1PF+aUMOv9iJz1qjxJUNhmPrPintpazVZE1xlFSH0VNgiOhtpt" +
       "kaozbUGp+CtpWOv0NtRQbY2SWjvTfZGUlvWeKfgZiS/quuHHvTVrz4lmyDcD" +
       "x1q3wrAndKNIEciJK3eEltkkKdqqMG4TWjRbVU6t1bxhBFNaecEN2UhrqE4N" +
       "Tns1PcEqhllMLn3gA8W00+dubDrs/u3M38HOJdPGiohXbmDGaxf1RBG892CW" +
       "dfu7s3Rst8uRWdYjq6Nn9mcZ339dE6fbtSiquHFkw0exvPXua+1p2i5tffaF" +
       "l19VBp+rnN1bmGbi0j2x5/89W12r9hE0D4CSnrn2Mh673dJ1uGD6uy/8z0em" +
       "P7r66A1sA3nsGM7jRf5z9gtf671P/tmzpdsOlk+v2mx2Zabnrlw0PReqcRK6" +
       "0yuWTt99IM6DhRbvAceH98T58PEp8EP5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("T57/fmpnPqes+3/llLivFsFvxqULuhpPjq6gbqf2D63uy280z3q04O2N167c" +
       "blKsPWh7HLVbw/HMYQJ6m+BrpxD9ehH8G0A0Okb0xJnmtWcoh+R/5ybIHwjs" +
       "75H3b73Af3hK3B8VwX/cCdy9ahX2kOM3boXAH9/j+PE3SeA/OYXofy+Cb+4E" +
       "vorovzsk+q2bFfMiOF7cI/rirRfze6fE/a8i+A7oKYCYg6vXrQ9J/tnNqlms" +
       "xP3iHslffJPU/JtTmP5tEfwVYBqdxPSInH99s3I+C44v7jH94i2X88zdp8Sd" +
       "K4Lb4tI7gZzDay/1H5A9c/vNykqB47U9sq+9ObKeedspjB8qgvOAcXQa40N5" +
       "z1y4Ccbbwc/j4PjqHuOv3np5Hz8l7ski+KG4dB7Iyx/ZJVGktQ4pvutmRUXA" +
       "8e09it++5aJaWy7PnsLzUhH8MOAZXc3ziJRP3ayURS/6F3s8/+LWS9k4Ja5Y" +
       "RT6DxKUHgJSdE3aQHLJEb4HnPfPwLu/u/CaoeVo1EEXwQUA1OpHqEUHfcDvZ" +
       "G7ne9wJQF/eoXrz1gg5PiRsXQX8naPeEXTeHLJmbFfQ5ABjZY4ncckF3PvfH" +
       "TqH6kSIQdoKeQPWIoPObFfRpAGov7+58awVdnRJnFkGxpxoI2rvGTqVDpsrN" +
       "ioqXil2XO6bMmyRqfArddRF4gG50TbpHhPVvgu4jxc2nil0+e3Rnt17YT5wS" +
       "90IRfCwu3Ve01CsZfuqQ4Y/frKDvB2Av7zG8fMsF/dSWyj88heZLRfAioBld" +
       "RfOIkJ+8EZoZKO3Kb3GKDwsevuqjwN2HbPIXXz1/9zte5f/z9nOUg4/N7mFK" +
       "d2uJbR/dB37k+k7wIq0ZW/r37HaF+1s6r8Slp653711cug2EBfwzL+9yfyYu" +
       "Xbye3HHpju35aN5/EpcePT0vyLU9H831alx6+Fq5AD4QHk39T+PS205KDVKC" +
       "8GjKz4IX0uMpwfO356PpfiUunTtMF5fu3F0cTfJ5UDpIUlz+i91e1yt3A+62" +
       "+We7KbyHj5r69kXpgTcynYMsR7/CKapg+7Hp/gRZsvvc9LL8pVdp7mPfr39u" +
       "9xWQbEt5XpRyN1O6a/dB0rbQYpLtiWuWtl/WneTTP7jv1+557/6E4H07wIfN" +
       "7gi2x07+5Kbr+PH2I5n8N9/x6z/yK6/+8XZz4v8DWbabDwU8AAA=");
}
