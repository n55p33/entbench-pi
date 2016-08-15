package org.apache.batik.css.engine.value.css2;
public class FontVariantManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_CAPS_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_CAPS_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_VARIANT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontVariantManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3BU1Rk/uwl5EUgIBJBHeAWUh7uCUIuhVBKILG4gEmRK" +
       "UJKzd88mF+7ee7n3bLLBUpFpC+1UBhERHWX6Bw6WojBOnT6sFsdplWqdqrRo" +
       "HbEPZ6RSpjKd2k5ppd937r17H5vdmJnSnbln757zfed8j9/3ne+cPXGJjDAN" +
       "0sBUHuEDOjMjq1TeTg2TJVsUapoboK9LeqSE/m3LhbVLw6Ssk4zupWabRE3W" +
       "KjMlaXaSqbJqcqpKzFzLWBI52g1mMqOPcllTO0m9bMbSuiJLMm/TkgwJNlIj" +
       "TsZQzg05keEsZk/AydQ4SBIVkkRXBIeb4qRa0vQBl3yih7zFM4KUaXctk5Pa" +
       "+FbaR6MZLivRuGzypqxB5uuaMtCjaDzCsjyyVVlim2BNfEmeCWaeqvn0yv7e" +
       "WmGCsVRVNS7UM9czU1P6WDJOatzeVQpLm9vJ10hJnIz0EHPSGHcWjcKiUVjU" +
       "0dalAulHMTWTbtGEOtyZqUyXUCBOZvgn0alB0/Y07UJmmKGC27oLZtB2ek5b" +
       "S8s8FR+eHz34yJbaZ0tITSepkdUOFEcCITgs0gkGZekEM8wVySRLdpIxKji7" +
       "gxkyVeQdtqfrTLlHpTwD7nfMgp0ZnRliTddW4EfQzchIXDNy6qUEoOxfI1IK" +
       "7QFdx7u6Whq2Yj8oWCWDYEaKAu5sltJtsprkZFqQI6dj4x1AAKzlacZ7tdxS" +
       "pSqFDlJnQUShak+0A6Cn9gDpCA0AaHAyqeCkaGudSttoD+tCRAbo2q0hoKoU" +
       "hkAWTuqDZGIm8NKkgJc8/rm0dtm+e9XVapiEQOYkkxSUfyQwNQSY1rMUMxjE" +
       "gcVYPS9+iI5/YW+YECCuDxBbND/86uXbFjScftWimTwIzbrEVibxLuloYvSb" +
       "U1rmLi1BMSp0zZTR+T7NRZS12yNNWR0yzPjcjDgYcQZPr//Fpl3H2cUwqYqR" +
       "MklTMmnA0RhJS+uywozbmcoMylkyRiqZmmwR4zFSDu9xWWVW77pUymQ8RkoV" +
       "0VWmid9gohRMgSaqgndZTWnOu055r3jP6oSQcnhINTyziPUR35wo0V4tzaJU" +
       "oqqsatF2Q0P9zShknATYtjeaANRvi5paxgAIRjWjJ0oBB73MHpBMpO0BmaJ9" +
       "VMkw7FgUbQVTQVTKENZtVAVgGBFEnf5/Xi+L+o/tD4XANVOCiUGBmFqtKUlm" +
       "dEkHM82rLj/T9ZoFOgwU23KcLAURIpYIESFCBFaMWCJEhAjYsSiSLwIJhcTK" +
       "41AUCxDgzm2QGCAzV8/tuGdN996ZJYBEvb8UfIGkM307VIubPZyU3yWdrBu1" +
       "Y8b5hS+HSWmc1FGJZ6iCG84KowdSmbTNjvbqBOxd7hYy3bOF4N5naBJLQgYr" +
       "tJXYs1RofczAfk7GeWZwNjgM5Wjh7WVQ+cnpw/33b7zvpjAJ+3cNXHIEJDxk" +
       "b8dcn8vpjcFsMdi8NXsufHry0E7NzRu+bcjZPfM4UYeZQWwEzdMlzZtOn+t6" +
       "YWejMHsl5HVOAQCQMhuCa/jSUpOT4lGXClA4pRlpquCQY+Mq3mto/W6PAO0Y" +
       "bOot/CKEAgKK3eFLHfoT77zx55uFJZ2NpMZTAXQw3uRJXjhZnUhTY1xEbjAY" +
       "A7r3D7c/9PClPZsFHIFi1mALNmLbAkkLvAMW/Mar29/94PzRs2EXwhx270wC" +
       "iqCs0GXcVfiE4PkMH0w42GElnroWO/tNz6U/HVee48oGiVCB5IDgaLxLBRjK" +
       "KZkmFIbx8++a2Quf+8u+WsvdCvQ4aFkw9ARu/3XNZNdrW/7RIKYJSbgRu/Zz" +
       "yazsPtadeYVh0AGUI3v/W1MffYU+AfsE5GZT3sFEuiXCHkQ4cImwxU2iXRwY" +
       "uwWb2aYX4/4w8hRMXdL+s5+M2vjJi5eFtP6Ky+v3Nqo3WSiyvACL3Ursxpf+" +
       "cXS8ju2ELMgwIZioVlOzFyZbfHrt3bXK6SuwbCcsK0FiNtcZkDizPijZ1CPK" +
       "f/fSy+O73ywh4VZSpWg02UpFwJFKQDozeyHnZvUv32bJ0V8BTa2wB8mzUF4H" +
       "emHa4P5dlda58MiOH034wbJjR84LWOrWHJNzGXaKL8OK4t4N8uNv3/KbYw8e" +
       "6rfKg7mFM1uAb+K/1imJ3X/8Z55fRE4bpHQJ8HdGTzw+qWX5RcHvJhfkbszm" +
       "b12QoF3eRcfTfw/PLPt5mJR3klrJLqY34sYEcd0JBaTpVNhQcPvG/cWgVfk0" +
       "5ZLnlGBi8ywbTGvulgnvSI3vowIYnIwuXA7PDTYGbwhiMETEyxrBMke0c7FZ" +
       "INxXwkmlbmgcpGRQAJeZonLnIImsUiWbW0dAZVKRdYBXbNymYJnIyfyh93ir" +
       "VAZ4WykZ2y9ic4e17rLB8JwdXI8Qvt7oyis+ZUVi0wNhgnE6tVD1LCr/o7sP" +
       "Hkmue3KhBeI6f0W6Cg5cT//2P69HDv/+zCDFTiXX9BsV1scUz5rluKQvbNrE" +
       "wcLF4PujD/zpx409zcOpSbCvYYiqA39PAyXmFY7EoCiv7P540oblvd3DKC+m" +
       "BcwZnPJ7bSfO3D5HOhAWpygrOPJOX36mJn9IVBkMjovqBl9gzMoBYCw6dg48" +
       "i20ALA4Ghgu6Odh8xY/1qiKsRfYeuciYcBkE2VjZjKm9cP6FkIOqSBxx/XUq" +
       "+rkjkzChppTTUGf02cexRe3d0t7G9g8tGF43CINFV/9U9IGN57a+LhxWgQjJ" +
       "mcmDDkCSpzqqxSaCoVAkRwfkie6s+2Db4xeetuQJJuQAMdt78NtXI/sOWiFi" +
       "Hbhn5Z15vTzWoTsg3YxiqwiO1o9O7nz+qZ17wrbd7+akPKFpCqNqzi+h3OY1" +
       "zm9FS9aV36r56f66klYIvhipyKjy9gyLJf0ALDczCY9Z3TO6C0dbaizQOAnN" +
       "c3ZOkeRYkST3OTZt7GjWRX+3H/TXw9NkI7dp+KAvxFoE2F8vMvZNbO6Do45s" +
       "rlDlNOVYKzqoxzHNNcmua2WS2fA023o1D98khViLqP1gkbGHsPkOFAoy3ogJ" +
       "7BYwyAPXwCA1ONYAT8zWKjZ8gxRiLaL0kSJj38XmUai3exh3LJE7u6XtyMcv" +
       "3fPOOSmR7RtOT0TjzwFPmD12DUxYh2Mz4LnTtsOdwzdhIdYiZjpVZOxZbL7v" +
       "N+FayFVONVYrCnysSe2qy7XQiWtgoTE4Nh2eTbaam4ZvoUKsRazwsyJjL2Hz" +
       "E8tCK1mKZhSrYHcsdP3Q9apLLwz3/DUwXD2OYa3abWvfPXzDFWItYpw3ioz9" +
       "GpsznIwGw8WSsFvCgZ9ZdWWHa4xf/i+MkYWkmH/nhwfUiXl/QVjX5tIzR2oq" +
       "Jhy565wok3NX29VQ9qQyiuI9Qnney3SDpWShXbV1oNLF1zuczPl8V5OclOKX" +
       "UOScxfweJzOGZIaTVV8ORTbjeU4mF2GEk5X14uX5A+yog/FAUoTWS/khBH+Q" +
       "EqQQ3166jzipculgUevFS/IxzA4k+HpRd+Lm5qEN5qLG9mg25D9+5VBUPxSK" +
       "PCe2Wb4yVfyT5dRxGeu/rC7p5JE1a++9/IUnres8SaE7duAsI6F6sy4NcweW" +
       "GQVnc+YqWz33yuhTlbOdstJ3neiVTWAZtiJx9TYpcL9lNuauud49uuzFX+0t" +
       "ewsK4s0kROFgsDn/6iCrZ+CkuDmeX6WKIIFiqmnuYwPLF6T++p64nCF5VzJB" +
       "+i7p7LF73j4w8WhDmIyMkRFQMbOsuNNYOaCuZ1Kf0UlGyeaqLIiIfqOKrwQe" +
       "jTFGcQsRdrHNOSrXi/e8nMzML+zzb8erFK2fGc1aRk3iNFBEj3R7nIOr78yX" +
       "0fUAg9vjOctkrToBvQGQ7Yq36bpzSVp6qy6SzcDghQO2n4lXbK7+FyiQw0fl" +
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Azh78UmoOdLtSaA5XBFAPqfO87ecwJYX5VZ+DXhesYctrziJLaegIvPaguX+" +
       "Ir2YJy8vxuSGCLrZD7wISGmA+O5sWASmEZDEdBW76OwhUFwsOWHBfFcElZ56" +
       "ddoFecCXdtCWp0ieYDuHaFzTeS4XXW5PAYy5sXoJvVTO/1PXED7PviJPunlC" +
       "7Iv7gpWtXdzHHQHE1cBtLq5sdF/+C4XH5wO0J+cJIR/6mYUEHn3bYWOUB+La" +
       "d3znXV/5rQe+BdxuAN1YGAN425Ee6TgP9d/6xHtf8pzHvv2OAlQBogpvevDf" +
       "isCJf3qq3p2ryhZxC6WE0ajAPkMvtL3ubBsHpgOWi81eHAs/ese3rA997+O7" +
       "GPXk1DpBbLz9sd/46aV3Pnb6yJvBA1cE50d5dm8HhdDP3bNwAN1/vV4KDuK7" +
       "n3z0T37v0bftpLrjeJzbBa9xH//r//nKpQ98+0tXCaHO2N4zGNjo/Jl+LSSx" +
       "/Q9VkQ2kzVemFhwndr3LL8j2oN03MJFfojHOk/FSaA9JqldbdJ3pkB8MM73Z" +
       "dIgSahioi6gU1eZ9wsdLFb697E774qzRThqit2ozLtcIiVD3bXGtr4Op11e7" +
       "Y7kxZf3VUK9add/XWwgaVNB+faM7A5d1VdtF62g2N/TmqgUjrlHSxrPeYNXB" +
       "6HLY5vtxt8OsRqt1hTO4RZUbCCGv+J7qDVuUsWa7sINQS1WgkgYbWrUs9kVF" +
       "nXYRcbga2cpMYdfqYK2t/WFGZJTYJuvVRcUZrZmxZtscU3Za6khlY3NAjRyY" +
       "sxbJgLbJFRfKk2xRrltGN5QtGEv1SY1tk4JlTWdt0lBr66lS3kzaNpKaSzQj" +
       "RrUhr8y0yKqPlRKhKtPGSKbMzTTuZam/3rbrcayMInyldDI8XKWpINimU23T" +
       "865j4KJirDduOd2ghuj08FCYCjSL8qOWlvGVcUPsDBglygxh4lNOazOolJcD" +
       "l8zK3f6Y7fU1caUNTV5Y8WVdsbHY7o84kVOjXpeJUnnNpzMebzPyZuGWFbtd" +
       "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" +
       "ruNHxU2C7A9f8JlX/+7j3yxO/v4PV5hGXjwpAAA=");
}
