package org.apache.batik.ext.awt.image.spi;
public class ImageWriterParams {
    private java.lang.Integer resolution;
    private java.lang.Float jpegQuality;
    private java.lang.Boolean jpegForceBaseline;
    private java.lang.String compressionMethod;
    public ImageWriterParams() { super(); }
    public java.lang.Integer getResolution() { return this.resolution; }
    public java.lang.Float getJPEGQuality() { return this.jpegQuality; }
    public java.lang.Boolean getJPEGForceBaseline() { return this.jpegForceBaseline;
    }
    public java.lang.String getCompressionMethod() { return this.
                                                              compressionMethod;
    }
    public void setResolution(int dpi) { this.resolution = new java.lang.Integer(
                                                             dpi);
    }
    public void setJPEGQuality(float quality, boolean forceBaseline) {
        this.
          jpegQuality =
          new java.lang.Float(
            quality);
        this.
          jpegForceBaseline =
          forceBaseline
            ? java.lang.Boolean.
                TRUE
            : java.lang.Boolean.
                FALSE;
    }
    public void setCompressionMethod(java.lang.String method) {
        this.
          compressionMethod =
          method;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2pz/AnVT+nL4IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zgx70bkcFgCQL6iL/LUL/qRYQaGnwfPksak9edGfXILKzI+WTZ4t05tF8oMn" +
       "5ns1iKwNWO2P7fd74HcJPP+neIrOioL92vxY/zhAeOY0QgjA2nQtKgLM9HRy" +
       "3poc61QhglskiBfNvdxvlNW1IvnAfrTmXZXoL56H+NTxc5K/E0TqLhCLbL+U" +
       "G5ZAD9mBbk5SED4nuxNurx+4HQJtTy7wSr9GXt99PCUnU3MnXsXvh9dHC16H" +
       "Pog+enKsF3HWHeTb831Hl70LPEuvkefCQz9zzPMzd+H5x78vnosgEihEDLSB" +
       "OcT7gOcbB573cf4Flj/0qiyXQ2SXgM5ert1q36oW78admbqvyP4QWJvicjsF" +
       "WhiWJzsnXL7ddtSbJ9o8BdsrwO1N22kX1coFvrDvmy/g3x45gKR9sJX5qT/4" +
       "1G/99Du/AZzQCLq8KRwE8D1nJDFOi93dX//ip5986KVv/lS5rAKJTv/qd5/4" +
       "QNGrfy90RWIXyfoE1hMFLKGMV2k5TphyJdS1Atm9fS8XWS4IGDbHWxf4xce+" +
       "sf65P/rF/bbkoqO9QKx/4qW/8b1bn3zp6Mxm8J237cfOttlvCEum33Qs4Qh6" +
       "9l6jlC2G/+nLL/7jv/fix/dcPXZ+azMAO/df/Lf/+7duffabv3mH+Pl+x79N" +
       "4b7/iU2uf4JoxGT35EcjS3mxVTN+lrrT+majtbFR3p4haET2cmYhdldyVsPR" +
       "ejQncC0V51rMt1A78oKWXDOUmkbrbbm+9JTldiF0THfgNzG7PyDhPpMxFtal" +
       "utSQ6He9qW0O2EnXWw0mqhCOupMwM0d8Vxo1sXoYhZ6du7GjUwwylpCpjk43" +
       "hhEihqZPRbRlSrudOB71xvxy1djKCBlVZaFqufyUQUOXX85aw0SgW56widrR" +
       "Rq3Vs4k7XozXnai3VpakY8GLYDpAlmZNSEF8xFRdPlTkRXXFb0drJJKI0Wzh" +
       "uym2HAVWplB4GJtUrSV4VG8UO51tQ14yC6Y5XdsJvuAmXVutMKaw5OlBWmU1" +
       "zxgKSzbGK0xakbacvqh4vZ2bt53tjGzVM06j/CFTzfhFHR8uEqQp1Xb1MTbt" +
       "LHZhvLXHccfU0Ymi9Hobe5wJywU7EGke1VhbUXfr6pbXyKo3J5CIaIYt3fdF" +
       "dTqy0I0colScLLXOaioOBZkl3BHBptg4GPbl8TYU2MRqTIUxyiTTXY2vGCGD" +
       "62t8PcZNfrVs9ODBerAN5G1FbGA01ifmDBJUc7Ot5H3Up+hFIm2IpIlyJpoi" +
       "ITyrTuXe2qV9s2ayGEluZ31hInb9XAC7uPnMk+wJIoz96ozd9mQrFMJ0l0/b" +
       "kSbZlJwR1BYmm8sYG3rSiONamk8hq2GVqTO7aqfW110vlTgZFmbOdOf30yqC" +
       "aKvFEq11G9TYMk135M62LBo7qc/zUgx0CiYlrZ91tkm3S+2QmRriqDqSkKU/" +
       "wGReS0kzlJee36VBCGUSgiD6DZ/xyIimMD+sjgW+xTPehOTEUdfJetpkOOew" +
       "xSC2B1t6vcH5xWjq9qbKKM4b83HYqaQOrPjkdNTHeVaaOsMKn/ZCgesiA1hE" +
       "KGGLbXm72qYb/ZnXYqpGf9XFsqTbz3wORBW8tpknwww1pz2mHQ/ypbImrDAn" +
       "DUdSN2Sk1sNZ3RGAWkyWaTg3G5u42mzH8cLQqs0J0nVZdzhQBnnDE/T2HE4d" +
       "n+WqnIEF/SEuu7yWz+Y9Gw3W3Cz2KXs+lxo1eRCyAU653iwMCbSjkbQm2tZ6" +
       "OWw1l9VaSMZ8GEzBmHYHRk3fnhSKHJp0aAVgHpX1KnbHRt6z8PVw1RZ6DBqT" +
       "XruTS6bLhpknTwVhJNV5FLf7yHAIU9uQXG9FBVvrYoOTbEnacK7e70taneH7" +
       "861ZG4ZaBWMdZrmYMl6/s1aTScPDY27hSFucENL+DBiurzIKrLT8jmwjDt0T" +
       "+r3lWlx1mamWkPhcQni1alY8Z6PoMJH5S30QVohazNaHu3644ISRa8PYkp3b" +
       "/XZvUNG3vGtn4lhckysudSRnMGp0qdzo97u9CUGIVR/X8LpqzKbmMHJ1Zrrg" +
       "svVcWNE7EUkJbLXgdhODklFdq/QTRNb7TS5kcXe+HMnilNxu67MFHg9iPVa0" +
       "upRRfYeP86aXWD1z0ZaaWtC3+tGc3W35lifyLXfUXmQMushNHhPVFCV2HVlY" +
       "w6wYb2ZsXTHgMJkNBNRXRx5BCmRvt+tvmRY5bixXpCY02gvVSCs2s1PZVr85" +
       "qbAUO9i1aHaIEysJr/dHgScMG7V5PQhbozXmaXmMTrC1SFLjXmYvB8scW1XH" +
       "GhbKNu3NTHXo1+MmRc0XrTGOWttwUWnSWmbU6iuUilZDstZmWKMbJ54aGjVu" +
       "o3U5GlcpuKp2+rNNf9FR1r1GgzBgLueQ+jhnK7iTLZk5NsRmzcWgSlA7zUR0" +
       "pdVeKqIU9tox0h6glU6lQ68ILfPM2YgPJ+t2rG97FMk4PYwz4JjWx2iz0kLF" +
       "ZsxuPAwftWjTDSSlZY5oWVyZAbV1M3pOrLsDZ97tbwQ5d6tyhdKFaSisBW9o" +
       "w0ridNTQg72wOjWsXt+qsXir1oC7vbSCTKOdis+1TS03tx1xbQ/Wab7MdxOR" +
       "FetDom0vxzKfO7sxXGsl2YYTOmi3N8CkcSCgzoDdkKJicr1h2iAiY1fdTLfz" +
       "lhLzVqxPEWMDVzohz05gKutknaoCw2ZtkagzD06b03okLml+pG1pazdt4kQT" +
       "H4y2NWG82FapaiuFPTrSo6WQYxbwqH53yyuzat7dKTnH1PJQUGYwbODNlpIY" +
       "oUCvuIQyWw4VihVKsccCpiHjCO93a0o9rywjvLGoTycJMZoKS2LHTxC/QbiO" +
       "02rU5byXtgmEy+urHaq7olIfbJjOZBHnDjyWqQqGTJu9FE3bA01P4eE8aKPZ" +
       "Yp0DYW9oH3G7SkWGk9AeTdownDL2mmA0qtlXe3BM+D5scC3Hy7lUq3cnsyYL" +
       "c8P1JOjW9BnaDoh4VcGHY7EzXqNBr2pFCm6Ma4JaX41XtQE9Hu6qrk2GXh2F" +
       "/YwLME3rqX11sJ3keZvvUQRjj4C3xtPNuGuI/SHJMWZNTzcK4fWSQcQTppM5" +
       "btpMpR1NNbMtRc+YntSYaoPuzOZn+EjgeysWrMPZajJb7Gq1hG9LJrNOLSbm" +
       "JKm+QZY0JlO4ElGp63LzVpWt1Ikw0ESZSsQ+6TRiI3dSfhXVcUzM+Ymd9FdJ" +
       "fYivsqFuYbS66DfciuJzK7o9mmbT0JIqWBxZToXFa9VxY2MEa9pKVuJkIKET" +
       "IWz3ZggihfJkgGhrZIIttlKnhvSagcaTCMLbc1oVKXHdGKxn6XjgovBkIEdC" +
       "S/ZXolTt02JXSjpho7rbboTOsDPuC+K6btr+YhX0GqOm0o7zQV5PPWDwsKtF" +
       "u8Yg7MlpvQJ854agGaMCT+G531YrnRY9WtKaHi4UpLWqApXS2VmSCasK2/fZ" +
       "hs+JbpPeVDpcnc3H4WhEKQvEw5dIj4PzLeM4wQxEImDtz+DWrrVL5MayLu4w" +
       "MCnqdlnHyFWuopWUbo2MkbaYN2tDd7XUWKXG1OdNhidNS58yihxzFK9OCbxP" +
       "NRpkpHS1xWDOu0hH6m8cjgRb72wamznmKIAjcWisZZlpisgQ7kp4xqYBirZS" +
       "A5FZZWVP2kav1lGpfiQ1Q5qmpq49zXAgz2jW33jarMXFreFaXbgToAIj25/P" +
       "UJtpK3pjFdm2lZgY21hMO2xeS5Y+qgpjadFCzJiuT3WrTTTSdkPKfLzDEujY" +
       "mmsDZNcww0XQq7cZoonU6gEiott1c2pGIVFrTRIYmxGZ4lITD8dmW6UzQXZz" +
       "PTUHa5lYcgOFRqxBro1YTe7WwqGAZDMS7bLNgJGEIKCG64rgGxOkPp9RdYOa" +
       "5B1J5S2qEW4FzA/sqrSZc+1WPdGbQU9b5bjVHQl6BcQaGTEmlZUUGt0QHmA7" +
       "o0Gy1mLLVkjNSGIdlporNUWMXkPCCA7bmRNOwypobKPtvOoOu6aLToaWnooN" +
       "JG+NCaya+mHYcKeIpGFe2OTxelwlNXrUxFv8UnL9aY7SSLsZdzkiD7YsvmsT" +
       "WV4NV2K7muxg3uHQ0UrbRVFqNyWDqIWbFjlUCGGIsBKsuHI/d2xER6ZWO5hN" +
       "uDqZ6ON5pAxkHMUn8aab0HlzN4naTWwd5+seEyvbbLXkKtvxwph3OjvJroXU" +
       "zqlX8ywLRGXMenZLUeGNB1supapyPMAX/Yx24Sa8o3rBBF83F+vxmnAyAvbi" +
       "xLAjtUbxdFhNMtUxmOk0XWg00egN1EZoed1Nymy2u12KYGMDiztsrblojegq" +
       "00QSepFN8KUNB5Ue8PFbdsSZrDPDpbxeY+caDDxPx8PWFB3g2SblXGlmxCpY" +
       "nWAvW+8QhKk2U71Z9eqLOUdWq11fd8GKFXCtUbOFzSxhGlmUqFMdZYPNwSYn" +
       "3nDZcLzrjp3hbmhsrYqdeUHIbAk7rhvzsEnbzDbOttN8wroObAozHzh9aQC2" +
       "qpPdsEFMZgEpNitaQk87CGlWN4RA1nx94ISL+cTczkJN0ml/1GpyHYuAa3Ju" +
       "DlAmbWas3kC31ryKWUSuagjTGuXNBOsErojnxmYDW8teZ6pFYUZVYGVFkbUu" +
       "oo/kdN6XZ9NebYzrsWsiNF1FKr7XygZVTF4xWMoHm6Q2sSZkQ2JQZrw0Fwkb" +
       "tsfbOuzhoTbn4DQjczmeVDx5smZE0unVh8Mq0iS3BrHr1bNGYA5GOVrpgt0I" +
       "SrezsbARQOCgbTphvkAttbPhsc7GE1mk0pYrcmDbvcAmcUUWXLmZa2arIyOG" +
       "FXKuz65nyrDV2XUtmxqRoQWborpIyMqg5yWb4djVcp+fwT2mn1Ld9irTUA53" +
       "eNQeBRG63M3i9dj10Y3l4QHa61DqYjJZ1HtLzt0wYtdgG3ja5ybwcLxKh2uW" +
       "m0fYpKE1q4HN2VGqDNvDWpDDYCcsVjy6UWzAiy35R1/bqcij5WHP6W30/8Mx" +
       "z77q2SJ51+m5Wfm7Al24wTx7y3E4+oaKE44n73bJXJ5ufP5jL72ssT+PHB1f" +
       "GXwkgR5M/OCHHX2jOxdO0d9795Oc/Znb4Sj71z/2x0+IP7L68Gu4oHv6Ap8X" +
       "u/wF5ou/ib9b/dkj6L7Tg+3bbv/PN3r+/HH2tUhP0sgTzx1qP3kq2TefnEK+" +
       "71iy77t4InmYuzsfR/7Qfu7vcSPzmXvUfbZIfiaB3mTqCX96tl0U4gd9+dlX" +
       "Oz0622tZ8MlTgI+eHA03jgE23niAf+cedZ8vks8l0CMA4Igb4Mfn4UUpd0D4" +
       "8utAWE7hD4Ln/ccI3//GI/zSPeq+UiS/kEBvOUZ47hS9qFsccH7hdeB8rCgs" +
       "Dvy7xzi7bzzOf3SPun9SJF/d4+xfPHkv3dwB5y+9DpwPneAkj3GSbwzOS8df" +
       "HhTvmzNuOE+g+ywvKdv82j3wf61IfhWYanzWVO/U3f0b39IOwvhnr1cYGHj4" +
       "Y2Hwb4wwjkqCoztxf9koLqbuVHNV2V8AlT3+zj1E9c0i+TfA6OPbjP5fHuTy" +
       "9dcrlzp4Pngslw++oUpSqnNJ8Mf3gPmnRfKHwCLiu1jEGbD/8bWAzUAkcdsn" +
       "NsX3Ao/f9onf/rM09UsvX3/g7S9L/678yuT007EHaegBI3Wcs9e7Z/JXAMeG" +
       "VUJ5cH/ZG5R//zWBnnv1j4CA2YC05P2/7Nt9J4Geunc7oF3l/9lW/zOBHr9b" +
       "KzAGSM9S/zkQ952oASVIz1J+L4FuXKQE45f/Z+guHSXQtQNdAl3ZZ86SXAa9" +
       "A5IieyW4wyXj/u49u3Q+DDud+8debe7PRG7vPBdvlR9+nsRG6f7TzxfUL788" +
       "Gn/k262f33+aozpynhe9PEBDV/dfCZ3GV8/etbeTvq4Q7/nuI1958F0nseAj" +
       "e4YP1nOGt6fv/B3MwA2S8suV/B++/R+8/+++/Hvl3eL/BX1YXxWRKwAA");
}
