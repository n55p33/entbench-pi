package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOPNGImageWriter extends org.apache.batik.ext.awt.image.codec.imageio.ImageIOImageWriter {
    public ImageIOPNGImageWriter() { super("image/png"); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVXbWwcxRmeu/N37JztJE6aD8cxDigf3BI1aYmcFhxjkwtn" +
                                                              "+xSTVFw+LnO7c76N93Y3s7P22XwjIcIfFEGAgIR/GSGhFhACtT8KchWJUlGQ" +
                                                              "SKMCrQj8DIKoRJXoj/TrnZm92729My38wdLNjmfeeed933nmed/55VXU6FDU" +
                                                              "S0yWYHM2cRIjJktj6hBt2MCOczeMZdVnY/jvJ66M742ipgxaWcDOmIodMqoT" +
                                                              "Q3MyaJNuOgybKnHGCdH4ijQlDqEzmOmWmUFrdCdZtA1d1dmYpREucATTFOrC" +
                                                              "jFE95zKS9BQwtCkFlijCEmUoPD2YQu2qZc/54usC4sOBGS5Z9PdyGOpMncIz" +
                                                              "WHGZbigp3WGDJYp22JYxN2VYLEFKLHHK2OOF4GBqT00I+l+Lf3P9bKFThGAV" +
                                                              "Nk2LCfecQ8SxjBmipVDcHx0xSNE5jR5AsRRaERBmaCBV3lSBTRXYtOytLwXW" +
                                                              "dxDTLQ5bwh1W1tRkq9wghrZUK7ExxUVPTVrYDBpamOe7WAze9lW8lV7WuPj0" +
                                                              "DuXcsyc6X4+heAbFdXOSm6OCEQw2yUBASTFHqDOkaUTLoC4TDnuSUB0b+rx3" +
                                                              "0t2OPmVi5sLxl8PCB12bULGnHys4R/CNuiqzaMW9vACU919j3sBT4GuP76v0" +
                                                              "cJSPg4NtOhhG8xhw5y1pmNZNjaHN4RUVHwfuAgFY2lwkrGBVtmowMQygbgkR" +
                                                              "A5tTyiRAz5wC0UYLAEgZWr+sUh5rG6vTeIpkOSJDcmk5BVKtIhB8CUNrwmJC" +
                                                              "E5zS+tApBc7n6vi+J+41D5hRFAGbNaIa3P4VsKg3tOgQyRNK4B7Ihe3bU8/g" +
                                                              "nrfORBEC4TUhYSnz6/uu3b6zd+ldKbOhjsxE7hRRWVZdzK38cOPwtr0xbkaL" +
                                                              "bTk6P/wqz8UtS3szgyUbGKanopFPJsqTS4feueehl8mXUdSWRE2qZbhFwFGX" +
                                                              "ahVt3SD0TmISihnRkqiVmNqwmE+iZuindJPI0Yl83iEsiRoMMdRkif8hRHlQ" +
                                                              "wUPUBn3dzFvlvo1ZQfRLNkKoGX6oHX7rkfwTX4bmlIJVJApWsamblpKmFvff" +
                                                              "UYBxchDbgpID1E8rjuVSgODNuxK7FYtOKRiwUCDeJL+deJYpehEgoKjASKrs" +
                                                              "65aS5N/kRHr8TtH7BdUBaAkOQfuH3LzEI7NqNhKBQ9sYpgwDbtsBy9AIzarn" +
                                                              "3P0j117JvifhyK+QF1OG9oMtCWlLQtgiCBZsSYj9E8KWhGdLoq4tKBIRJqzm" +
                                                              "NknMwIlPA3cAebdvmzx+8OSZ/hiA1Z5tgOPiov1VSWzYJ5hyVsiqr3Z3zG+5" +
                                                              "vOtCFDWkUDdWmYsNnpOG6BSwnTrtEUJ7DtKbn2X6AlmGp0dqqUQDklsu23ha" +
                                                              "WqwZQvk4Q6sDGso5kN92ZfkMVNd+tHR+9uEjD94SRdHqxMK3bARO5MvTPB1U" +
                                                              "aH8gTCj19MYfu/LNq8/cb/nUUpWpygm2ZiX3oT8MknB4sur2Pvxm9q37B0TY" +
                                                              "W4H6GYarCqzaG96jirkGy1mA+9ICDuctWsQGnyrHuI0VqDXrjwj0don+aoDF" +
                                                              "Cn6V++C32bvb4stne2zerpVo5zgLeSGyzM8m7Rc+/uCLH4twlxNSPFBJTBI2" +
                                                              "GCBBrqxb0F2XD9u7KSEg9+n59FNPX33sqMAsSNxQb8MB3g4D+cERQpgffff0" +
                                                              "J59dXrwU9XHOoApwc1BMlSpO8nHU9i1Owm43+vYAiRrAJRw1A4dNwKee13HO" +
                                                              "IPxi/TO+ddebXz3RKXFgwEgZRjv/twJ//Ef70UPvnfhHr1ATUXkS92Pmi8nM" +
                                                              "sMrXPEQpnuN2lB6+uOm53+MXIMcArzv6PBFUjUQMkDi0PcL/W0S7OzT3U95s" +
                                                              "dYLgr75fgWIrq5699HXHka/fviasra7Wgmc9hu1BCS/e3FgC9WvD5HQAOwWQ" +
                                                              "2700fqzTWLoOGjOgUQWKdiYosGapChmedGPzX353oefkhzEUHUVthoW1USwu" +
                                                              "GWoFdBOnAIRbsm+7XR7ubAs0ncJVVON8zQAP8Ob6RzdStJkI9vxv1r6x76WF" +
                                                              "ywJlttSxIajwJt7sqOBN/DWFE2YQb1UaKNq0XE0j6rHFR84taBMv7pKVR3d1" +
                                                              "nTACZfCv/vyvPybOf/6HOommlVn2zQaZIUbVnlBf1U0qPBrraspgWbqpryzE" +
                                                              "W9YuHP5IkFSlvGqH6513DaOybdAEXpJTktcFLNolOGzxGWNo53dJggw1ez3h" +
                                                              "SEpqSQML/z9aGGoU3+DaSWDXb18Lq8Q3uOoI1HHLrWIoBm1Q+h7IbPWkQRLa" +
                                                              "oOQxeIGFJWF/8Q3KQQXd5ssB2clOUCQH2kGEd1VbTKxj6LbvU3EEkFGK1ML+" +
                                                              "Vt6skf3BZa9fAOc3VLGNeJV5IBtz5bsMKpCFg+P3XvvJizKlwHtufl5U8fAo" +
                                                              "kdmtkri3LKutrKvpwLbrK19r3Rr1aK9LGixTWtA23h+C5GHzC7A+xLfOQIV2" +
                                                              "P1nc9/b7Z5ouwk07iiKYoVVHA28i+QAA0nbhSh9N+dVW4FUvEsHgtufnfr4z" +
                                                              "/7e/CkbxqrONy8tn1UsvHf/Tk+sWIWGsSAIqTY2UMvDAc+6YMw8RdYZmUIfu" +
                                                              "jJTARNACL84kanFN/bRLkvCWXMnvKubvNREXL5wdlVFekDDUX/Mwq1PGAfvO" +
                                                              "Errfck2Nq+mAfOCPVD0Xvfvf5tp2aIE/UjnK1bW+Z9U7Ho//9mx3bBT4psqd" +
                                                              "oPpmx81xaU+3/4IUA+JcOyUv/wf+IvD7N//xQ+cD8iHTPey9pvoqzymgeTkX" +
                                                              "y6bGbLss237MljfK5c1siY8zFNnujfLEEpFlCP93Xuw/J7q8ue+/srr1h00S" +
                                                              "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZa+zrSHX3/e/e5y577y7sst3CPu+2LIG/kzjPLhRsJ3ac" +
       "OLFjx3GSFi5+xo6f8TuBLbBVu6hIFKkLpRLsJ1ArtLCoKmqlimqrqi0VqBIV" +
       "6ksqoKpSqSgS+6G0Km3p2Pm/771LaT80kseTmXPOnDNzzm/OjF/8LnQ+DKCS" +
       "79mbpe1F+1oW7a/s+n608bVwv0/XWSkINRW3pTCcgLYbyuNfuPr9H3zUuLYH" +
       "XVhAr5Vc14ukyPTckNNCz040lYauHrd2bc0JI+gavZISCY4j04ZpM4yepqG7" +
       "TrBG0HX6UAUYqAADFeBCBRg9pgJMr9Hc2MFzDsmNwjX0C9A5GrrgK7l6EfTY" +
       "aSG+FEjOgRi2sABIuJT/nwKjCuYsgB49sn1n800Gf6wEP//r777223dAVxfQ" +
       "VdPlc3UUoEQEBllAdzuaI2tBiKqqpi6ge11NU3ktMCXb3BZ6L6D7QnPpSlEc" +
       "aEeTlDfGvhYUYx7P3N1KblsQK5EXHJmnm5qtHv47r9vSEtj6wLGtOwuJvB0Y" +
       "eMUEigW6pGiHLHdapqtG0CNnOY5svD4ABID1oqNFhnc01J2uBBqg+3ZrZ0vu" +
       "EuajwHSXgPS8F4NRIuih2wrN59qXFEtaajci6MGzdOyuC1BdLiYiZ4mg+8+S" +
       "FZLAKj10ZpVOrM93R2/7yHvdnrtX6Kxqip3rfwkwPXyGidN0LdBcRdsx3v1m" +
       "+uPSA1/60B4EAeL7zxDvaH73fa+88y0Pv/zlHc1P3oKGkVeaEt1QPi3f87U3" +
       "4E+178jVuOR7oZkv/inLC/dnD3qeznwQeQ8cScw79w87X+b+ZP6Bz2rf2YOu" +
       "UNAFxbNjB/jRvYrn+KatBaTmaoEUaSoFXdZcFS/6KegiqNOmq+1aGV0PtYiC" +
       "7rSLpgte8R9MkQ5E5FN0EdRNV/cO674UGUU98yEIugge6G7wPATtfsU7gjaw" +
       "4TkaLCmSa7oezAZebn8Ia24kg7k1YBl4vQWHXhwAF3xrZb8Ge8ESloAvGNpB" +
       "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" +
       "lx0AAA==");
}
