package org.apache.batik.svggen.font.table;
public class FeatureList {
    private int featureCount;
    private org.apache.batik.svggen.font.table.FeatureRecord[] featureRecords;
    private org.apache.batik.svggen.font.table.Feature[] features;
    public FeatureList(java.io.RandomAccessFile raf, int offset) throws java.io.IOException {
        super(
          );
        raf.
          seek(
            offset);
        featureCount =
          raf.
            readUnsignedShort(
              );
        featureRecords =
          (new org.apache.batik.svggen.font.table.FeatureRecord[featureCount]);
        features =
          (new org.apache.batik.svggen.font.table.Feature[featureCount]);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            featureRecords[i] =
              new org.apache.batik.svggen.font.table.FeatureRecord(
                raf);
        }
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            features[i] =
              new org.apache.batik.svggen.font.table.Feature(
                raf,
                offset +
                  featureRecords[i].
                  getOffset(
                    ));
        }
    }
    public org.apache.batik.svggen.font.table.Feature findFeature(org.apache.batik.svggen.font.table.LangSys langSys,
                                                                  java.lang.String tag) {
        if (tag.
              length(
                ) !=
              4) {
            return null;
        }
        int tagVal =
          tag.
          charAt(
            0) <<
          24 |
          tag.
          charAt(
            1) <<
          16 |
          tag.
          charAt(
            2) <<
          8 |
          tag.
          charAt(
            3);
        for (int i =
               0;
             i <
               featureCount;
             i++) {
            if (featureRecords[i].
                  getTag(
                    ) ==
                  tagVal) {
                if (langSys.
                      isFeatureIndexed(
                        i)) {
                    return features[i];
                }
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxkfn5/4bYPN029DhCF3kIZW1JQGHBtMz9jCxGpN" +
       "wjHem/Mt3ttddufss1PyQIqglYoIBULbxP/UFEoJpFFQW7VJqaISUNJIIbRp" +
       "GgX6UktLUUFV06q0Tb+Z2b19nM/AP7V0c3uz3zfzvX/fjE/dQPmmgeqJSoN0" +
       "XCdmsFOlfdgwSbRDwaa5FeYi0nO5+G/br21eHUAFg6g8js0eCZukSyZK1BxE" +
       "dbJqUqxKxNxMSJRx9BnEJMYoprKmDqIa2exO6IosybRHixJGMICNMKrClBry" +
       "UJKSbmsBiurCIEmISxJa53/dHkalkqaPO+TzXOQdrjeMMuHsZVJUGd6JR3Eo" +
       "SWUlFJZN2p4y0DJdU8aHFY0GSYoGdyqrLBNsCq/KMEHzSxUf3T4Qr+QmmI1V" +
       "VaNcPXMLMTVllETDqMKZ7VRIwtyFnkC5YVTiIqaoNWxvGoJNQ7Cpra1DBdKX" +
       "ETWZ6NC4OtReqUCXmEAUNXkX0bGBE9YyfVxmWKGIWrpzZtC2Ma2t0DJDxcPL" +
       "Qoee2175ci6qGEQVstrPxJFACAqbDIJBSWKIGOa6aJREB1GVCs7uJ4aMFXnC" +
       "8nS1KQ+rmCbB/bZZ2GRSJwbf07EV+BF0M5IS1Yy0ejEeUNav/JiCh0HXWkdX" +
       "oWEXmwcFi2UQzIhhiDuLJW9EVqMUNfg50jq2fg4IgLUwQWhcS2+Vp2KYQNUi" +
       "RBSsDof6IfTUYSDN1yAADYoWZF2U2VrH0ggeJhEWkT66PvEKqGZxQzAWimr8" +
       "ZHwl8NICn5dc/rmxec3+x9WNagDlgMxRIilM/hJgqvcxbSExYhDIA8FY2hY+" +
       "gmtf3RdACIhrfMSC5ntfvPXQ8vpzFwTNwmloeod2EolGpKmh8ncWdSxdncvE" +
       "KNI1U2bO92jOs6zPetOe0qHC1KZXZC+D9stzW85/4amT5HoAFXejAklTkgmI" +
       "oypJS+iyQowNRCUGpiTajWYRNdrB33ejQngOyyoRs72xmEloN8pT+FSBxn+D" +
       "iWKwBDNRMTzLakyzn3VM4/w5pSOECuGDSuFTh8Qf/6YIh+JagoSwhFVZ1UJ9" +
       "hsb0N0NQcYbAtvHQEET9SMjUkgaEYEgzhkMY4iBO7Bejw8NEDcU0VqHwkEJC" +
       "XYTnBis/QRZq+v9jkxTTdPZYTg44YZG/BCiQPRs1JUqMiHQoub7z1unImyK8" +
       "WEpYNqIoCPsGxb5Bvm9Q7Btk+wb5vkHXvignh283h+0v/A3eGoG8h5elS/sf" +
       "27RjX3MuBJo+lgemZqTNHgDqcIqDXdEj0pnqsommKytfD6C8MKrGEk1iheHJ" +
       "OmMYKpU0YiVz6RBAk4MQjS6EYNBmaBKJgpzZkMJapUgbJQabp2iOawUbv1im" +
       "hrKjx7Tyo3NHx54eeHJFAAW8oMC2zId6xtj7WClPl+xWfzGYbt2Kvdc+OnNk" +
       "t+aUBQ/K2OCYwcl0aPYHhN88EamtEZ+NvLq7lZt9FpRtiiHNoCLW+/fwVJ12" +
       "u4IzXYpA4ZhmJLDCXtk2LqZxQxtzZnikVvHnORAWJSwNa+HTauUl/2Zva3U2" +
       "zhWRzeLMpwVHiM/06y/88u0/fYKb2waTClcX0E9ou6uAscWqeamqcsJ2q0EI" +
       "0H14tO+rh2/s3cZjFihaptuwlY0dULjAhWDmZy7sev/qlanLASfOKSB4cgga" +
       "oVRaSTaPimdQEnZb4sgDBVCB+sCipvURFeJTjsks+1hi/bti8cqzf9lfKeJA" +
       "gRk7jJbfeQFnfv569NSb2/9Rz5fJkRgAOzZzyERVn+2svM4w8DiTI/X0pbqv" +
       "vYFfAHyAmmzKE4SX2QC3QYBrPg/QgnPKWnALVqNaYp0E5c3sgoLtLQYs4fqT" +
       "QyYkrpwAP41akPZA3w5pX2vf7wVczZ+GQdDVnAh9ZeC9nW/xKChipYHNMxnK" +
       "XIkPJcQVgpXCOx/DXw58/ss+zCtsQkBDdYeFT41pgNL1FEi+dIaO0qtAaHf1" +
       "1ZHnr70oFPADuI+Y7Dv05Y+D+w8J14oupyWj0XDziE5HqMOGdiZd00y7cI6u" +
       "P57Z/cMTu/cKqaq9mN0JLemLv/jPW8Gjv744DUjkylan+iCL9XRln+P1jVDo" +
       "4S9V/OhAdW4XFJVuVJRU5V1J0h11rwhNmpkccjnL6Z74hFs15hgAnTbwAZ9e" +
       "xcVYkSGMFXqz7dDr7u1MSURn4cz5NrFhsemuu143unr0iHTg8s2ygZuv3eKm" +
       "8Db57jLTg3Xhhyo2LGF+mOvHxY3YjAPdg+c2P1qpnLsNKw7Cijwleg0A55Sn" +
       "KFnU+YW/+snrtTveyUWBLlSsaDjahXl9R7OgsBIzDrie0j/7kKgrY0UwVLKn" +
       "FEobBnHDoFTGBMvthumrRmdCpzzPJ74/95U1xyev8AKnizUWcv5c1mp4AJ0f" +
       "FR1MOfnup35+/NkjYyLMZkgaH9+8f/UqQ3t++88Mk3MInSaPfPyDoVPPL+hY" +
       "e53zO1jGuFtTme0R9AMO7wMnE38PNBf8NIAKB1GlZB3NBrCSZAgxCMcR0z6v" +
       "wfHN8957tBB9dHsaqxf5E9m1rR9F3fmRRz254ABnqd3ENliY0uAHzhzEH7Zz" +
       "lvv42MaG+22cKtQNGY7vxAdUJTMsSlFpTLSAHVpS5djzaQHQbOxhQ0Qs15c1" +
       "Jj/v1WEZfBqt7Rqz6CBMcx8bcKaw2bgpKreE3UIkzYia3juQNIhwUBMl69GS" +
       "8z82v/mHl0XMTgdRvlPXieNF0geJ8xyi2KarvcrNn0k5EGdx9qxwSTX5rZa3" +
       "n5xs+Q0vGUWyCbEDYDbNOdLFc/PU1euXyupO844uj2GiVWK9B/DM87Xn2Mx1" +
       "qmCDlrIr64q7PycIu+u6jvxlmv3ckPKFTvweQ4dFZ5Nl3aYsoZOaMXSycVNU" +
       "ZIWOyZkU78azZ9qYk/LnJ9I2a7t7m921tcZnsJZL62Vp0flfAfKdgd1tqFPd" +
       "EYvOumzXFLyNmNpzaDLae2ylHfrrKWCSpt+vkFGiuJZi/UGdByh6eIQ5VffD" +
       "8oO/+0Hr8Pp7OfSxufo7HOvY7wZIk7bsWeYX5Y09f16wdW18xz2c3xp8VvIv" +
       "+e2eUxc3LJEOBvgtlICDjNsrL1O7FwSKDQKRoXrbopa0X1k0onr4rLT8utIf" +
       "kk7k+EIifTLJxuprsnz9/d2EdRjgsH/ctFkqecPBMDIort+4cId9+9gtCvv9" +
       "DTYcoHC4ZL2rlZX3nldO4jx7pzIzc9fEJgb0FAjkug1hvdS8jLtXcV8onZ6s" +
       "KJo7+ch7ohbbd3qlEKmxpKK40d71XKAbJCZzC5QK7Nf51zGKmu+sNUX5/JuL" +
       "PyU4T0AbMhMnRXnsy83yHYrmZmGBc654cNOfBgf76UEU/u2m+y5FxQ4dLCUe" +
       "3CSvwGEDSNjjWX2a6BEdVirHW7TSTq65k5Ndda7FUx/4Rbudy0lx1R6Rzkxu" +
       "2vz4rU8eEzcNkoInJtgqJQCY4tIjXQ+asq5mr1Wwcent8pdmLbYrZ5UQ2MnS" +
       "ha7wH4AKqrPwWuA7hput6dP4+1NrXvvZvoJL0CBsQzkYTj/bMnvRlJ6EQrwt" +
       "nHlUg9rJ7wfal359fO3y2F8/4N2+VboXZaePSJePP/buwXlT9QFU0o3yIT9J" +
       "ijfJD4+rgP2jxiAqk83OFIgIq8hY8ZwDy1kmYFYDuF0sc5alZ9k9FQR75hE4" +
       "83YPTkZjxFgPPWnUanNKnBnPfwDskprUdR+DM+PqfbrY0J5i3oB4jIR7dN2+" +
       "ISip0Xkt2JAdrS/wRzZc/B+cTAhjhBsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
