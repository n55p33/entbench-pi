package org.apache.batik.ext.awt.image;
public final class CompositeRule implements java.io.Serializable {
    public static final int RULE_OVER = 1;
    public static final int RULE_IN = 2;
    public static final int RULE_OUT = 3;
    public static final int RULE_ATOP = 4;
    public static final int RULE_XOR = 5;
    public static final int RULE_ARITHMETIC = 6;
    public static final int RULE_MULTIPLY = 7;
    public static final int RULE_SCREEN = 8;
    public static final int RULE_DARKEN = 9;
    public static final int RULE_LIGHTEN = 10;
    public static final org.apache.batik.ext.awt.image.CompositeRule OVER =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OVER);
    public static final org.apache.batik.ext.awt.image.CompositeRule IN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_IN);
    public static final org.apache.batik.ext.awt.image.CompositeRule OUT =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_OUT);
    public static final org.apache.batik.ext.awt.image.CompositeRule ATOP =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_ATOP);
    public static final org.apache.batik.ext.awt.image.CompositeRule XOR =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_XOR);
    public static org.apache.batik.ext.awt.image.CompositeRule ARITHMETIC(float k1,
                                                                          float k2,
                                                                          float k3,
                                                                          float k4) {
        return new org.apache.batik.ext.awt.image.CompositeRule(
          k1,
          k2,
          k3,
          k4);
    }
    public static final org.apache.batik.ext.awt.image.CompositeRule
      MULTIPLY =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_MULTIPLY);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      SCREEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_SCREEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      DARKEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_DARKEN);
    public static final org.apache.batik.ext.awt.image.CompositeRule
      LIGHTEN =
      new org.apache.batik.ext.awt.image.CompositeRule(
      RULE_LIGHTEN);
    public int getRule() { return rule; }
    private int rule;
    private float k1;
    private float k2;
    private float k3;
    private float k4;
    private CompositeRule(int rule) { super(
                                        );
                                      this.
                                        rule =
                                        rule;
    }
    private CompositeRule(float k1, float k2,
                          float k3,
                          float k4) { super(
                                        );
                                      rule =
                                        RULE_ARITHMETIC;
                                      this.
                                        k1 =
                                        k1;
                                      this.
                                        k2 =
                                        k2;
                                      this.
                                        k3 =
                                        k3;
                                      this.
                                        k4 =
                                        k4;
    }
    public float[] getCoefficients() { if (rule !=
                                             RULE_ARITHMETIC)
                                           return null;
                                       return new float[] { k1,
                                       k2,
                                       k3,
                                       k4 };
    }
    private java.lang.Object readResolve()
          throws java.io.ObjectStreamException {
        switch (rule) {
            case RULE_OVER:
                return OVER;
            case RULE_IN:
                return IN;
            case RULE_OUT:
                return OUT;
            case RULE_ATOP:
                return ATOP;
            case RULE_XOR:
                return XOR;
            case RULE_ARITHMETIC:
                return this;
            case RULE_MULTIPLY:
                return MULTIPLY;
            case RULE_SCREEN:
                return SCREEN;
            case RULE_DARKEN:
                return DARKEN;
            case RULE_LIGHTEN:
                return LIGHTEN;
            default:
                throw new java.lang.Error(
                  "Unknown Composite Rule type");
        }
    }
    public java.lang.String toString() { switch (rule) {
                                             case RULE_OVER:
                                                 return "[CompositeRule: OVER]";
                                             case RULE_IN:
                                                 return "[CompositeRule: IN]";
                                             case RULE_OUT:
                                                 return "[CompositeRule: OUT]";
                                             case RULE_ATOP:
                                                 return "[CompositeRule: ATOP]";
                                             case RULE_XOR:
                                                 return "[CompositeRule: XOR]";
                                             case RULE_ARITHMETIC:
                                                 return "[CompositeRule: ARITHMATIC k1:" +
                                                 k1 +
                                                 " k2: " +
                                                 k2 +
                                                 " k3: " +
                                                 k3 +
                                                 " k4: " +
                                                 k4 +
                                                 ']';
                                             case RULE_MULTIPLY:
                                                 return "[CompositeRule: MULTIPLY]";
                                             case RULE_SCREEN:
                                                 return "[CompositeRule: SCREEN]";
                                             case RULE_DARKEN:
                                                 return "[CompositeRule: DARKEN]";
                                             case RULE_LIGHTEN:
                                                 return "[CompositeRule: LIGHTEN]";
                                             default:
                                                 throw new java.lang.Error(
                                                   "Unknown Composite Rule type");
                                         }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8F/DoRM7HzIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C7Drxnkez9XV1ZUs6cqSH4piSbYesS06FwQBEGRkJwZA" +
       "kABI8AGQBIi2vgZAgADxfhEgEzm2m9Qeu3XdVk7cjq26M3YfqWxn3GTaNI9R" +
       "3GljJ5m0yWQStzOx00w6Tet4arfTpLXbpgDI87jnnnulI9lnZpd7dv/d/f5/" +
       "///fB3af/0bl9iisVH3P3ixtL76qZfHVlY1cjTe+Fl1l+shIDiNtQdhyFE3y" +
       "vGvqYz975c++81HjvguVS1LlAdl1vViOTc+NOC3y7LW26FeuHOeStuZEceW+" +
       "/kpey0ASmzbQN6P46X7lVSeqxpUn+ocQgBwCkEMASggAdkyVV7pHcxOHKGrI" +
       "bhwFlfdUDvqVS75awIsrb7q+EV8OZWffzKjkIG/hcvH/LGeqrJyFlTce8b7j" +
       "+QaGP1YFnv3pd933hdsqV6TKFdPlCzhqDiLOO5Eqdzuao2hhhC0W2kKqvNrV" +
       "tAWvhaZsm9sSt1S5PzKXrhwnoXYkpCIz8bWw7PNYcnerBW9hosZeeMSebmr2" +
       "4vC/23VbXua8vu6Y1x2HnSI/Z/AuMwcW6rKqHVa5aJnuIq48errGEY9P9HKC" +
       "vOodjhYb3lFXF105z6jcvxs7W3aXAB+HprvMSW/3kryXuPLQTRstZO3LqiUv" +
       "tWtx5cHTdKNdUU51ZymIokpcee1psrKlfJQeOjVKJ8bnG4O3f+RHXcq9UGJe" +
       "aKpd4L+cV3rkVCVO07VQc1VtV/Hup/o/Jb/ulz94oVLJiV97inhH889/7Fvv" +
       "fNsjL3xpR/P9Z9AMlZWmxtfUTyv3/vYbiLe2bitgXPa9yCwG/zrOS/Uf7Uue" +
       "zvzc8l531GJRePWw8AXu38zf+zPa1y9U7qIrl1TPTpxcj16teo5v2lrY1Vwt" +
       "lGNtQVfu1NwFUZbTlTvydN90tV3uUNcjLaYrF+0y65JX/p+LSM+bKER0R542" +
       "Xd07TPtybJTpzK9UKvfkofLOPLyhsvsrf+PKNcDwHA2QVdk1XQ8YhV7BfwRo" +
       "bqzksjUAJdd6C4i8JMxVEPDCJSDnemBo+4LCMuU0BkwnH36AyDkqeNa4xNau" +
       "Formf++7yAou70sPDvIBeMNp87dzy6E8e6GF19RnE5z81ueu/caFI3PYyyeu" +
       "vC3v9equ16tlr6XrzHu9WvZ69bpeKwcHZWevKXrfjXQ+TlZu8bkvvPut/F9h" +
       "3v3Bx27LVcxPL+ZCvpCTAjd3ycSxj6BLT6jmilp54ePp+2Y/XrtQuXC9by0Q" +
       "51l3FdVHhUc88nxPnLaps9q98oE/+bPP/9Qz3rF1Xees90Z/Y83CaB87LdvQ" +
       "U7VF7gaPm3/qjfLPX/vlZ564ULmYe4Lc+8Vyrq25Y3nkdB/XGe/Th46w4OX2" +
       "nGHdCx3ZLooOvdddsRF66XFOOej3lulX5zK+u9Dm78vDr+zVu/wtSh/wi/g1" +
       "OyUpBu0UF6WjfQfvf/Irv/VfoFLchz75yolZjtfip0/4gaKxK6XFv/pYByah" +
       "puV0f/Dx0d/52Dc+8JdKBcgpHj+rwyeKuFCqfAhzMf/kl4J//7Wvfvp3Lxwp" +
       "zUFcucMPzXXuFrIjLouCyqtuwWXe3Q8cA8odiZ1bWqE2T0xdx1uYuikrtlao" +
       "6f+58iT483/6kft2imDnOYd69LYXb+A4//vwynt/411//kjZzIFaTGTHQjsm" +
       "23nHB45bxsJQ3hQ4svf9zsN/99fkT+Z+NvdtkbnVSnd1sBNCXumtt1jMhKaT" +
       "D8d6PwEAz9z/NesTf/LZnXM/PVucItY++OyH/uLqR569cGJKffyGWe1knd20" +
       "WurRPbsR+Yv87yAP/68IxUgUGTu3ej+x9+1vPHLuvp/l7LzpVrDKLjr/+fPP" +
       "/OI/fuYDOzbuv35GIfMF02d/7//+5tWP/+GXz3Bjt+WrhRIhUCJ8qoyvFpBK" +
       "eVbKsqeL6NHopMe4XrQnFmnX1I/+7jfvmX3zV75V9nb9Ku+kgbCyv5PNvUX0" +
       "xoLV1592j5QcGTkd/MLgL99nv/CdvEUpb1HNnX40DHMPnV1nTnvq2+/4D7/6" +
       "r1737t++rXKhU7nL9uRFRy49U+XO3CVokZE798z/kXfuDCK9nEf3laxWbmC+" +
       "zHjoRp/xxb01ffFsn1HEbyqiJ280xJtVPSX+iyWCi+X/tSKCd2AaceFtPLk0" +
       "Pvo4KnumbjGGbBERZdHbi6i9a+9HXpIcdrQPlv99/61NrFMsVo/9+4PfHtrK" +
       "+//of92gDOW0dIbVnaovAc9/4iHih79e1j+eH4raj2Q3zt75wv64bv1nnP95" +
       "4bFL//pC5Q6pcp+63zXMZDspvK6Ur5Sjw61EvrO4rvz6Ve9uiff00fz3htNm" +
       "f6Lb0zPTsbnl6YK6SN91ajJ6sJDyU3l4dK8dj55WrHL5sNP1AtJVOl/kL7Xw" +
       "/j/61Kf//H0faF4onOHt6wJ6LpX7jukGSbE5+WvPf+zhVz37hx8uZ4vCTRaN" +
       "Cjs9LeMniujN5fjeFucbqkSxzdw3X4rKvU6hc6Yr2yVqOK7cyU375LXhjOSK" +
       "DOhY6UvNEl9Ms7jr+X5LHh7b8/3YGXwXiXmxKioSi5uALpLvKqJrRfTuQ6R3" +
       "lEjpwVk4tXPifGsentzjfPIWOEss9vlwXt5JdDo5C6hzTqBP7YV6KNybAb1Y" +
       "JOLzAd0NPTYZjs5CmrwMkVb3SKu3QHp7kfixlyNScXimjj5zTqC1PFzdA716" +
       "C6CXisRPnA/olZ1IOXpCseSEJs7C+5PnxFtgBPd4wVvgvaNI/PXz4b2nxMtO" +
       "+xN61J+fhfZvnBPt2/IA79HCt0B7uUg8ez60ryrR8gRHkmd6gY+9DKzoHit6" +
       "C6x3FolPvBysbYzrnY31ky9DC35oj/WHboH1riLx6fNhvbvE2qe71ORssJ85" +
       "J1gmD9092O4NYCtl4vnzYbx4OEXddwrbZ8+JrZMHfo+Nvwm2f3Y+bBd2k9Jp" +
       "ZD93TmRUHq7tkV27CbJ/eT5kt+2nodPQfvFlDKi9h2bfBNqvnnNADyee09i+" +
       "+DLElu6xpTfB9qVzim0/1ZyG9uWXMSd+eA/tQzeB9m/PORWedNan8f27c+J7" +
       "cx4+tsf37E3w/d758F06ds+n0f3+y0D3qT26v38TdH9wTnTHDvk0uq++jKXu" +
       "83t0//Qm6P74nCvcEy74NLz/9NLhlVvb1+bhF/bwfuEm8L5+NrxyR/GWIzsN" +
       "k90R8+lJ4U/PiehNefilPaJfugmi//5SEF2wwCJFn8LzP74HeP73S8NTPwvP" +
       "t7/7eA4qLw0PdAaeg4PvAZ47Xhoe+Cw8l18UT1k/X9zke9b6VfRqcXZycO/5" +
       "TOr1K1t94vA4bqaFkem5T6xstKz/2vjk9nr3PezUIMIvGWS+p7/3uLG+5y6f" +
       "/vAff/Q3/+bjX8s39Mzhhr6glnIBzd775H8rPtAcvP58/DxU8MOXH0v6chSz" +
       "5amstjhi6dT50kXbewUsxQ+8QMERjR3+9WcyAeFTkLOqCWSNmyZmjLApT2M8" +
       "Z4A212mTwpLDlgndYclgSS4UB9EQRk2o9RpZNLYS2zHtKdyfqfG8m43RZQRP" +
       "cU7szDV/6js+56MIqHfbM8GognE4m/mrXlxfd7gqALhQDKF1KhElJ9qozarm" +
       "DnRABwCEqi7AKjH2WZfj+UwU0r4UgF3Dm9mm4uFRDTLHfSMmGWlCZfayb7jg" +
       "opp0fdzBOcjiOq1lTAbEUlowNokoLs91LStzegQNdoyOzGVoPHSn3sgTllMn" +
       "qFlilyelft6bPRV6sexn5hIVCMqcrnBVqgWTNSPTEYgRLDjVMCtdOUx/JAmD" +
       "msQkshEIVciBM2jgZClYbzNGbUvPg7mfdPpz2uL5CUIaU9Y2VrypbQczUaub" +
       "SRjSXUdgB92qmPVxIlkhdY3xhg18E1Wr6353bXrx0u5hXi8ZpStKCoIRLXS9" +
       "Ks+HSU2Q58x8O0QcgyN5yVmx/AisTSYcgRMDbEDWhDCaqZ0Wbgu8yWuzVKAC" +
       "a26BpGGYUsNASBIaG/MxNMlcp0tOg7khgRAechPWMQZ2xxq3mpthe5BtpIXI" +
       "YXZf4njP9scjiZyTDG7xjXEPq9WmIDiHyOYkGSyk3piwWiC+mDpjX4CESUdV" +
       "pkHTjAiO1UEvEpjVNGARvx72CG3MRZrNWIHfwMEmO9usg3VAqoK2pEIBT0JT" +
       "xCR7mWvf0prXoIistZOQr5IOP7e2bOwqNDzMAJvxsE6dYvhVON0OLcKY4oRl" +
       "ggHf23gjrju02qDdQTwh4AksCdgJtlQ7XSEmNNrxJL07JdgWugjZnrMEXSwi" +
       "ki22yeKEXaX8dsCSWx5GkaHiBnAMij0+mbKYhW8hMthEBtAV+aAlcoG/Bad+" +
       "HaOkSN8Ii65iKN0RinkTzIMoDQ8URUTB9WzYR+Kxprf8iG113a0WJqsZZ7F6" +
       "B2vBpshsxYHYITCF4bzApAykn4zVTRxGdU+eZj7s9LsSqXQ39AxE1iOIWSx0" +
       "dbxt9qwWLUzNTaCuaFxbcfwMH8pMZ9AazgSvv8JkZUO1A45Zw+tpLOEry0MY" +
       "Yrvoz0aTWlfi69Z0KHUyPgSo2mSK1YZLk/SM/sZqyatgTcibEQKyMi2PiVFI" +
       "02vLJYHhEFixY1MXAoJbctyU4DorZeL3EhqiEzxLrG5dlzpJbeQPyOlg0AgI" +
       "gpyJ69XYXOIQNA2sdr8z8iWODLEWPYB4F+dqumxN8HhcU3iDQTqE3Rs1xpvu" +
       "fEnaWhPRcdWWPdXfBqxILhN5goCjeobUtrOxO0wRdkRTvbY87zAx3OGRKOWD" +
       "tpQFSzgKiPkUjhYdGpIy3+ktBvMRtVSj2F3Ym0yNhkmyZMasXAdIeqwagQSG" +
       "cXsi9ZNOTFRH5lQLeqg00AU9IesdvkuIs2Vk8ktvw0l9SiO2SA/q8pIqWhBO" +
       "TNGBlWUZNmfl0AtqKxP2A2w+n4O85zSMoT/P9dXLxit/483B7jIZdvsAYFUH" +
       "aFVuLaoAkqaEsm5jEh1hVrULLdZjU9DUhQKJbd0cCKi7TZvVIdTPFjFXJ3po" +
       "w0rrjDBpcmMEnFIhZJhwkPqpN8w4VBFVlBzhsD7A21japAVQNLxEbw3nrbhO" +
       "++Mx1moYjbFPZD0TWk1j2Q0AsE4s9Ik1SYFuzJsUBqXt0VKL+Q0P1PuxgEET" +
       "VZY0D0GQ6ag9bzK1obJoKn0AjUcEmixw01+wE6AdeTIlw328sXYmTmCFirwY" +
       "BuIYTeotZQIoKtR3taCxrXV7MtXsNCYDcjjHfHzbbjW19VBBUWQLk2PYq6oG" +
       "50l+shz3aT/seey4N/XnbUbC0Fp9TutMk90uqZnvNgbY0gtaU4OIa1suChuB" +
       "20ahdN6CZojTo8kBI3iA41IwlgAbltF4GWmgzTUzH5EZnbVin4iQRGq79elI" +
       "Z0yR0+q0UfVlsOonet4jVyVxt00ZIT9Ql02F9cTlwJ3XAhqx4rTb7fGz3FNJ" +
       "81QL1XgJmeE6qLebGbagpRGOjhYOOeTcRtbStdFWZ6R+bcRnFNURh1iqiDTX" +
       "zmSfhcVmW99QMOCxOmHU+pPeQocEruOajlTrDfyehjclrwF6RoxJ1BpMkDip" +
       "AliVhDFoQEVyDay1QQiaRNQac9v2FpjQsZy6BtodJvNpCjtEhqGB4ngRg/ZH" +
       "69DS6sAo5Fp+057Fk0geNAdmE0V1XQebaQuF3DXJYGOBj8fyAkFCtqY1EHZM" +
       "xoBI2el2IXQ2adtvdQje7/Xits0I1f6QFChE4nmUkgZ2CMfwkmPlyTJdeTMr" +
       "xdEtrLM5Gs52iK7Wbfa9mUOmkNtHJ6OZMOyIErseUSSTzcIR5NY6tB6KAY2K" +
       "UyH0GGdDeS7j5L5dXaDz2KLTatBerIfDsB9U+RXUZGhIwU2CyV3jEGwnJIiI" +
       "dDRLEnOutACUdrIuCCf0sGP7HU4w9OVmqccea2xUeis26HbPjclIcOSGsU55" +
       "vrdszCSaGvWs9tYdZusqW2NWYmcC6co46bQ0nWoDw1bGyOKGdpyUAvor2zFQ" +
       "aNEk5tsItxahJBLVMHDUDrF1WQMAmgSPAJnf6nJrmDe6oNbpEyKpIxHSr64j" +
       "Y9QChDHSMQWKT+VYZodWLZhOtp32XIi7sZNNOW2IN0ShgdjtRTOoIxTo2rq7" +
       "hpTU3+qQ05TnKTqDqx4EzENRXWujll5X/f6sRVepZW5y1WQzpBRmNY4BegXF" +
       "G7bRCpCRxDe5+WxmtbYQ5Ea8CyuhCcEKExEIz8x8pZavd1x2DNfHosLyw5YI" +
       "i3HQWGtrZbppZd2Bw4l9pldFVaQNhqagigE/Tiab7lpM5yuA3RAoythLf9hy" +
       "vLXYGMoDz4oGygSbhD2xEYtrCKKWzXoMicaq2+wINXxmUcFsIqGzua2O9abX" +
       "HKBy5HWhMNGcGiK3J5qURe2JIJnqNl85LtluMlpYMZ/hAzOtV72pZNsGh7eC" +
       "lMyS2dJhKAMVEnOrUDMZWSuRhhN1YAPjUeLW6u2gEyFSczCT4qHfNOihhOM8" +
       "xSosiOG2k2hh2k1yXwMvyZCewy4jzXSHqLe5PjsZmY6A8A6SttvdRYMbIMsl" +
       "6W2mDjXc+jE72o6bXVOQhcEE8uXcwU7hfI0FDLpkbWyGgtMfghpUVbsIPQcY" +
       "R4A4x6+1J0bHwde9kmY0ccRQl0Fnm3dHsUMdqwnBfK7KtJdFm9Z6QJLWvGub" +
       "EwtB+arWAxNlaJtzYDqKKGKcL0P6U28b1XDZMBw08pQZjjGc6cHBYA7W1IYQ" +
       "J8vGqLak8NT22+5226fCrWphQapuuDVBdiyBsFbkKJC7/lpZK6A6BixMMKuc" +
       "AFbbVrvN6oMx5BEE3xvj/Rmk6oEFeN0B0huAnU4o9NUlFmRqttLGbI+OOvRw" +
       "rE6VmVP1YlavacNchGN+nUyFRJtJJrYajZgIsnoE1+VdkhtTa5ZqjA1oqqVs" +
       "c0CusU217UXxyiMwBqC7UHu8oTfkVhDbfIbWxSyyqpv10gRtcr6kImDTWbe8" +
       "QdeI6rV41k6b61adWnuOAE4sbAQDG2YNeEwHh1pMP28ZG1XVDNNrgqPDGIYD" +
       "bpvHPYlZYvKWWiJ6y6KsRGlsagGYiinQqDarSjOZd7l5bbJc+ZxO+jBLsuNh" +
       "dcTJ/nKMjcXqdDA38aU0WPbrCsURVSocEW11znUbENcigja+JvoqtcLSMdpd" +
       "efkeKtg4LLCIl+ai28w3Wb0mvUgVts1EabbNtnBiwC5ApXS1n0U4tO0xtT7W" +
       "bst4TrGCXc7qtlJN92bhaoMP3bFDkpshJ1SNTW3TTtV0OCFdq9Zt0TwSO16C" +
       "LDhYYNIabkLCHCTajAqA9MSI8gFnNwwLbGnIFUiGUK0NmU/CgFWf2LS/3gwY" +
       "Kc06nrZotlvWxhVzURBUjGQeJcYrypBkZCm4fluyRAuvbTJuZNSTfEUAID19" +
       "g1PjEQo31msXT+orkxZTsaEEuZNkY5CQxupCZwYTeOvjynC67iTbVdJfUNCI" +
       "d+eA0OJTacvAvh3LGtJSJwDTWNRYcw1PB/3+xmZRYNUw1DqlG1a+waihdZ61" +
       "UGRQjw2kJemBBE+RJbDdtkeEMtQWyhIdKP4Ir8Xgxu814BCZOYwstQgr36qt" +
       "BDWcgo3ZArUXbSE2skCiViqqLlUa6AnCWNe7KlR3uwTl5C6U4vW5pwlzkWXo" +
       "QI8smBCVIS618lWvLOBIsCWIKOsHWROvgyQOLwx2C9Oym5Czhb+K8tlzCNBT" +
       "Re1a4JxWlPrUn6hIp+VvhMmUVJNO7oz85hb0x25UMzrVrWyb9Y7XgxGri9LT" +
       "hTbYiH63Z5G9CR/GDalDEosNA4toYKM2h3AajKyhBSLMRkCkwNmsOnRsdaKv" +
       "NdDNF8JG2hDMbtN21+kSXfQdqYkPxpSS9qiki89RgF33FwAwmhEQ14cpoRaY" +
       "1S5FqWBjrILj7bSWTwB+yqEcrQCtRQ1Em/oa9YE6B6U9gccUWKDazGhZRSmq" +
       "Vh3q24RrtKbgYDvSRcvQnG0ShekaDml9nS8DI5HyZ9U+2UJ8cW64A6Jtm53t" +
       "VBGIjjAU62pGjfGQkuxgzcvbxlyYWy0patZWShtyIqG/6o3WhE/aQmceGM0J" +
       "l9VgfTLtsl3eMup1DHUZWA9ERFgpq8jpTeUeN5z0Daa7qk5meDtqGz0whSxF" +
       "1hMxpQE29cJe0kHTfIEaozQq6E07aOGiOKDhsTQSVbNFBj6zzTfMYUvHF4Rn" +
       "OTZrggu8UcVMlF24DI/b00yuQd7QTVZxBKoprhhh0h3TyiyjGFYETaLa7afr" +
       "VeDJKSyhUcwttpGj1Tv6FpxsQdkZyXg6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("y70bpJuxCHrZNMFgsrmAsGovE9NE6c/WVBWQpjYMyGttAdamiSv6VSFdDDNm" +
       "E/a3Yixz/ZZUq5uDzJFkJUbHcgalUM4QstqEOD+y1i7aaksB0F7R6agRzWhM" +
       "ngxBS8fqgAka+aw1tPPZcmajQsq0gCSOWhsiSoZZHcZHg1V/xIy3WGPAUhHL" +
       "g+MMZI0MDPR6t9F2qTngVF1Tp4Nuvg9cp4OhMXScKuZVGS7HK1LiLBivkwED" +
       "EKbSSxUuGU6XspFCm5kNOtwkran9CSg054Ekwgg8H61qix6myxMmqjdjUmjY" +
       "zBBa0m195i8TTXI6XV3joTridfsUBBozgAxJIhQtBMOWwqDVWg1xm5HJcNFu" +
       "yCNJoWEzAkagDDc3ugLWYL+q6kpdTOAWNOqj23he7TFLUGtq8QjG0JkxjeeE" +
       "HCikPA+AfOwaM8FxYUNumSBHcy7bE2iOo8kAoVa9wXgwFWv4BhGJLJs5XK/J" +
       "kzYNiZKCmhsXqQobxwPAfPvE80K1Pt7Ckigxw0hGB6sZM9EHtYiM1AAm7BFp" +
       "Ompbwqj6iJtZYH8EkaFmrVdIDET5fmmsSoArqJtWswO0PY5FqW1xbPeOdxRH" +
       "jI+d74jx1eWR6dF7gpWNFo08cI5TxOzsDi8cdfju41ut5V9x3nzd1fQTR80l" +
       "5YP7G6H7U9vd3WvTu3r0OEOxteLW4cM3e1pQXq789PuffW4x/Ax4YX+PDo0r" +
       "d8ae/4O2ttbsE/0Uz2ieuvm1OLZ8WXF8N+3X3v9fH5r8sPHuc1zXfvQUztNN" +
       "/hP2+S93f0D92xcqtx3dVLvhzcf1lZ6+/n7aXaEWJ6E7ue6W2sNHYn9jIeXi" +
       "ctF79mJ/z+kT/uPxvsVAXtspTUlww4XHo0P/U3cbD54+RX/ibuNBqbGNuHLX" +
       "9ZdoTnw3QM9z27HIOICO2L5SZL4uD1/Ys/2Fc7BdftV415kcn+Sge4uyQggH" +
       "eFy5Y6nF3OF3tWPWiFfA2muKzMfz8Ot71n79u88af4uyaREN4sqVnDXC03Td" +
       "VE3NjaPclp68uS2VV8F3l7Kf+4eP/9aPP/f4fyxvBl82o5kcYuHyjPdCJ+p8" +
       "8/mvff137nn4c+WTg4uKHO2U/fRDqxvfUV33PKrk++4jST5U8FTc2nzzXpLl" +
       "b1wRXuFTlryaU1yL90IsT5Uu4vCVzPeq6ZIz+mi8Dk640eIrz4F0+CHvXS/u" +
       "svfTwyVbc5e7x0XFZ8aDuZ8dtX9h/+Rl76YfOP4eRtieqxVeuqjyg9lZiA6g" +
       "HaKy0VekpqtblBUPyg70uHK7WiDaMXALcm9veKV5Dl+BeT5QZD6Sh6/sleor" +
       "5zXPt7wo39mpsoPrZ82HD2fN3R1oPg412SEzVfMLfSlb2BZRFFdelRct9k8Z" +
       "z/hUumvgWDDxKxDM/ZW9yX17L5hvf/f91gdvUfahIvqrceVy7B19AT544Ji3" +
       "nzjX5fq4cs91r8WKly8P3vAqdfeSUv3cc1cuv/656e/vvNfha8c7+5XLemLb" +
       "Jy+bn0hf8kNNN0uW79xdPfdLPv5WXHnk1u/YcqUvf8sB+Oiu1rNx5cGb1Yor" +
       "t+XxSeqfzpdeZ1HnlHl8kvLv5fpymjLvv/w9SffJfKY/psu9yy5xkuRTees5" +
       "SZH8B6Wvek92cGKxtl9tlovS+19srI6qnHyZVbBbvi8+XIwluxfG19TPP8cM" +
       "fvRbjc/sXoaptrwtDKRyOZ8/do/UjhZ0b7ppa4dtXaLe+p17f/bOJw8Xn/fu" +
       "AB8r9wlsj579Cot0/Lh8N7X9F6//ubf/o+e+Wr4B+P+QwqW1+D0AAA==");
}
