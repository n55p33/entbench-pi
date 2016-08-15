package org.apache.batik.css.engine.value.css2;
public class DirectionManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LTR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LTR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RTL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          RTL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_DIRECTION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 LTR_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DirectionManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze5AUxRnv3TvuxcEdBwfI43gdKA93FTVIHSHC8Trc4644" +
                                                              "xORQjt7Z3ruB2ZlhpvduD0NUKgkkFSlERLSUyh9YGIJCWbHyMBosK1GisaKS" +
                                                              "qLHEPKzSaKxIpWJSIZF8X/fMzmNv97yqkK2a3tnu7+v+Hr/+vq97T35MRtkW" +
                                                              "aWI6j/FBk9mx1TrvpJbNUq0ate1N0NejPFBG/7b1gw1Lo6Sim4zto3a7Qm22" +
                                                              "RmVayu4m01Xd5lRXmL2BsRRydFrMZlY/5aqhd5NG1W7LmJqqqLzdSDEk2Eyt" +
                                                              "BBlHObfUZJazNmcCTqYnQJK4kCS+IjzckiC1imEOeuSTfeStvhGkzHhr2ZzU" +
                                                              "J7bTfhrPclWLJ1Sbt+QsstA0tMFezeAxluOx7doNjgnWJ24oMMHs03WfXjzQ" +
                                                              "Vy9MMJ7qusGFevZGZhtaP0slSJ3Xu1pjGXsn+RopS5DRPmJOmhPuonFYNA6L" +
                                                              "utp6VCD9GKZnM62GUIe7M1WYCgrEyazgJCa1aMaZplPIDDNUcUd3wQzazsxr" +
                                                              "K7UsUPH+hfFDD2ytf7KM1HWTOlXvQnEUEILDIt1gUJZJMstekUqxVDcZp4Oz" +
                                                              "u5ilUk3d5Xi6wVZ7dcqz4H7XLNiZNZkl1vRsBX4E3ayswg0rr15aAMr5NSqt" +
                                                              "0V7QdaKnq9RwDfaDgjUqCGalKeDOYSnfoeopTmaEOfI6Nt8MBMBamWG8z8gv" +
                                                              "Va5T6CANEiIa1XvjXQA9vRdIRxkAQIuTKUUnRVubVNlBe1kPIjJE1ymHgKpa" +
                                                              "GAJZOGkMk4mZwEtTQl7y+efjDcv236Gv06MkAjKnmKKh/KOBqSnEtJGlmcVg" +
                                                              "H0jG2gWJw3TiM/uihABxY4hY0vzwqxduWtR05kVJM3UImo7kdqbwHuVYcuyr" +
                                                              "01rnLy1DMapMw1bR+QHNxS7rdEZaciZEmIn5GXEw5g6e2fiLr9x1gn0UJTVt" +
                                                              "pEIxtGwGcDROMTKmqjFrLdOZRTlLtZFqpqdaxXgbqYT3hKoz2duRTtuMt5Fy" +
                                                              "TXRVGOI3mCgNU6CJauBd1dOG+25S3ifecyYhpBIeUgvPHCI/4puT7fE+I8Pi" +
                                                              "VKG6qhvxTstA/e04RJwk2LYvngTU74jbRtYCCMYNqzdOAQd9zBlQbKTtBZni" +
                                                              "/VTLMuxYHF+lWjALaN5OdYCFFUPMmf/X1XKo+/iBSATcMi0cFDTYT+sMLcWs" +
                                                              "HuVQduXqC0/0vCQBh5vEsRonS0CAmBQgJgSIwXoxKUBMCIAdi2NhAUgkItad" +
                                                              "gIJIKIAjd0BIgJhcO7/r9vXb9s0uAwyaA+XgBSSdHchNrV7ccIN9j3KqYcyu" +
                                                              "WeevfT5KyhOkgSo8SzVMNSusXghiyg5nn9cmIWt5yWOmL3lg1rMMhaUgdhVL" +
                                                              "Is4sVUY/s7Cfkwm+GdzUhps4XjyxDCk/OXNk4O7Nd14TJdFgvsAlR0GoQ/ZO" +
                                                              "jPL5aN4cjhNDzVu394NPTx3ebXgRI5CA3LxZwIk6zA4jI2yeHmXBTPpUzzO7" +
                                                              "m4XZqyGicwruh2DZFF4jEJBa3OCOulSBwmnDylANh1wb1/A+yxjwegRkx2HT" +
                                                              "KNGLEAoJKPLCF7vMR9585c/XCUu6KaTOl/u7GG/xhS2crEEEqHEeIjdZjAHd" +
                                                              "O0c677v/471bBByBYs5QCzZj2wrhCrwDFvzGizvfevf8sXNRD8Ic8nY2CeVP" +
                                                              "Tugy4RJ8IvB8hg+GGuyQIaeh1Yl7M/OBz8SV53myQQjU5I6ym2/RAYZqWqVJ" +
                                                              "jeH++Xfd3Guf+sv+euluDXpctCwafgKv/4qV5K6Xtv6jSUwTUTAFe/bzyGRc" +
                                                              "H+/NvMKy6CDKkbv7tekPvkAfgQwBUdlWdzERaImwBxEOvEHY4hrRXh8aW4LN" +
                                                              "XNuP8eA28pVKPcqBc5+M2fzJsxeEtMFay+/3dmq2SBRJL8BiNxKnCQR+HJ1o" +
                                                              "YjspBzJMCgeqddTug8muP7PhtnrtzEVYthuWVSAo2x0WhM1cAEoO9ajK3z33" +
                                                              "/MRtr5aR6BpSoxk0tYaKDUeqAenM7oOImzO/dJOUY6AKmnphD1JgoYIO9MKM" +
                                                              "of27OmNy4ZFdP5r0g2XHj54XsDTlHFPzEXZaIMKKst7b5CdeX/Kb4/ceHpCF" +
                                                              "wfzikS3EN/lfHVpyzx//WeAXEdOGKFpC/N3xkw9PaV3+keD3ggtyN+cKExcE" +
                                                              "aI938YnM36OzK34eJZXdpF5xyujNmJZgX3dD6Wi7tTWU2oHxYBkoa56WfPCc" +
                                                              "Fg5svmXDYc1LmPCO1Pg+JoTBqejC5fBc5WDwqjAGI0S8rBcs80Q7H5tFwn1l" +
                                                              "nFSblsFBSgalb4UtanYOkqg61XL5dQRUppRYB3hF2rYFy2ROFg6f4WWRDPCW" +
                                                              "IRnbG7G5Wa67bCg854bWI4KvV3vyik9Fib3pgzDBfTq9WN0sav5jew4dTXU8" +
                                                              "eq0EcUOwFl0NR63Hf/ufl2NHfn92iFKnmhvm1RrrZ5pvzUpcMrBt2sWRwsPg" +
                                                              "O2MP/unHzb0rR1KTYF/TMFUH/p4BSiwovhPDoryw58Mpm5b3bRtBeTEjZM7w" +
                                                              "lN9rP3l27TzlYFScn+TmKDh3BZlagluixmJwUNQ3BTbGnDwAxqNj58Gz2AHA" +
                                                              "4vDG8EA3D5svB7FeU4K1RO5RS4wJl8EmG6/abXofnHxhy0FVJA63wToV/dyV" +
                                                              "TdpQU6oZqDP6nYPY4s5tyr7mzvckDK8YgkHSNT4Wv2fzG9tfFg6rQoTkzeRD" +
                                                              "ByDJVx3VYxPDrVAiRofkie9ueHfHwx88LuUJB+QQMdt36NuXYvsPyS0ij9pz" +
                                                              "Ck67fh553A5JN6vUKoJjzfundj/92O69Ucfut3FSmTQMjVE975dIPnlNCFpR" +
                                                              "yrrqW3U/PdBQtgY2XxupyurqzixrSwUBWGlnkz6zeqdzD46O1FigcRJZ4GZO" +
                                                              "EeRYiSD3OZI2dqw0Rf+2IOivhGepg9ylIwd9MdYSwP56ibFvYnMnHHVUe4Wu" +
                                                              "ZijHWtFFPY4ZnknuulwmmQuPM6f8HplJirGWUPveEmP3YfMdKBRUvAsT2C1i" +
                                                              "kHsug0HqcKwJnrWOVmtHbpBirCWUPlpi7LvYPAj1di/jriXyZ7eMs/Pxy/S9" +
                                                              "c07KVOdu07ej8eegb5s9dBlM2IBjs+DpcOzQMXITFmMtYabTJcaexOb7QRNu" +
                                                              "gFjlVmP1osDHmtSpujwLnbwMFhqHYzPhudVR89aRW6gYawkr/KzE2HPY/ERa" +
                                                              "aBVL06wmC3bXQlcOX6969MJwT18GwzXiGNaqWx3tt47ccMVYSxjnlRJjv8bm" +
                                                              "LCdjwXBtKciWcOBnsq7s8ozxy/+FMXIA1PCNHx5PJxf89SCvy5UnjtZVTTp6" +
                                                              "yxuiSM5faddC0ZPOapr/AOV7rzAtllaFbrXyOGWKrzc5mff5riU5KccvocYb" +
                                                              "kvltTmYNywznqv48hhzG85xMLcEI5yr54uf5A+TToXggJELrp3wPLBqmBCnE" +
                                                              "t5/ufU5qPDpYVL74ST6E2YEEXz8y3V1z3fAG8zDjeDQXCR6+8hhqHA5DvvPa" +
                                                              "nECRKv7Bcqu4rPwPq0c5dXT9hjsufOFReZmnaHTXLpxlNNRu8sowf1yZVXQ2" +
                                                              "d66KdfMvjj1dPdctKgOXiX7ZBJIhEYmLtymh2y27OX/J9daxZc/+al/Fa1AO" +
                                                              "byERCseCLYUXBzkzC+fELYnCGhWOduLarWX+Q4PLF6X/+ra4miEFFzJh+h7l" +
                                                              "3PHbXz84+VhTlIxuI6OgXmY5caOxalDfyJR+q5uMUe3VORAR/Ua1QAE8FvcY" +
                                                              "xQQi7OKYc0y+F295OZldWNYX3o3XaMYAs1YaWT2F00AJPdrrcY+tgRNf1jRD" +
                                                              "DF6P7ySTk1UCegMg25NoN033irR8vClCzeDQZQO2n4lXbC79Fx6vjqrdHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs1l2n701ybxLS3JukL9I2TZrbRzrs9cx4PA8FSm3P" +
       "eMYz48d47BnPLNvU49fY49f4bUOgVEArKkoF6QMJwh+04qE+EALBLgIFIbZF" +
       "VEigsgustmVXSHQXKtE/eIjuAsee3zv33hAlYiQfnznn+z3n+/2e7/mcr885" +
       "n/0GdE8YQDXfs3PD9qKbWhbdtGz0ZpT7WnhzPEU5OQg1lbDlMBRA2TPK2375" +
       "2t9/62Pb65ehK2voEdl1vUiOTM8NeS307ERTp9C109KBrTlhBF2fWnIiw3Fk" +
       "2vDUDKOnp9C3nWGNoBvTYxFgIAIMRIArEWDslAowvUZzY4coOWQ3CvfQ90OX" +
       "ptAVXynFi6Anzjfiy4HsHDXDVRqAFu4t/y+AUhVzFkCPn+h+0PlFCn+8Bj/3" +
       "yfdd/5W7oGtr6JrpzktxFCBEBDpZQw84mrPRghBTVU1dQw+5mqbOtcCUbbOo" +
       "5F5DD4em4cpRHGgnRioLY18Lqj5PLfeAUuoWxErkBSfq6aZmq8f/7tFt2QC6" +
       "vv5U14OGZFkOFLzfBIIFuqxoxyx370xXjaC3XuQ40fHGBBAA1quOFm29k67u" +
       "dmVQAD18GDtbdg14HgWmawDSe7wY9BJBj9620dLWvqzsZEN7JoLeeJGOO1QB" +
       "qvsqQ5QsEfS6i2RVS2CUHr0wSmfG5xvMd370e92Re7mSWdUUu5T/XsD02AUm" +
       "XtO1QHMV7cD4wLunn5Bf/1sfvgxBgPh1F4gPNL/+fd9873c89sKXDjRvugUN" +
       "u7E0JXpG+fTmwT96M/FU765SjHt9LzTLwT+neeX+3FHN05kPZt7rT1osK28e" +
       "V77A/9fVB35J++vL0P0UdEXx7NgBfvSQ4jm+aWvBUHO1QI40lYLu01yVqOop" +
       "6CrIT01XO5Syuh5qEQXdbVdFV7zqPzCRDpooTXQV5E1X947zvhxtq3zmQxB0" +
       "FTzQA+B5Ejr8qncEWfDWczRYVmTXdD2YC7xS/xDW3GgDbLuFN8Drd3DoxQFw" +
       "QdgLDFgGfrDVjiqUsKQ1gExwItuxVhY04b4ZgFaA5rTsArcIbpY+5/+79paV" +
       "ul9PL10Cw/Lmi6Bgg/k08mxVC55RnovxwTc//8wfXD6ZJEdWi6AOEODmQYCb" +
       "lQA3QX83DwLcrAQoC5o3LwoAXbpU9fvaUpCDK4CB3AFIAGD5wFPz/zR+/4ff" +
       "dhfwQT+9G4xCSQrfHrOJUxChKqhUgCdDL3wq/cHFD9QvQ5fPg28pPCi6v2Tn" +
       "Ssg8gcYbFyfdrdq99qGv//0XPvGsdzr9zqH5ESq8mLOc1W+7aObAUzQV4ORp" +
       "8+9+XP61Z37r2RuXobsBVAB4jGRgS4A8j13s49zsfvoYKUtd7gEK617gyHZZ" +
       "dQxv90fbwEtPS6rxf7DKPwRs3IWOknP+X9Y+4pfpaw/+Ug7aBS0qJP6uuf8z" +
       "f/qH/wepzH0M2tfOLINzLXr6DFCUjV2rIOGhUx8QAk0DdP/zU9xPfvwbH/qP" +
       "lQMAiidv1eGNMiUAQIAhBGb+4S/t/+xrX/30Vy6fOk0EVsp4Y5tKdlDyX8Dv" +
       "Enj+uXxK5cqCwyR/mDhCmsdPoMYve37HqWwAdOyDD4c3RNfxVFM35Y2tlR77" +
       "/669vfFrf/PR6wefsEHJsUt9x0s3cFr+7Tj0gT943z88VjVzSSkXvVP7nZId" +
       "kPSR05axIJDzUo7sB//4LT/1RflnACYDHAzNQqugDarsAVUDWK9sUatS+EJd" +
       "s0zeGp6dCOfn2png5BnlY1/529cs/va3v1lJez66OTvutOw/fXC1Mnk8A82/" +
       "4eKsH8nhFtC1XmC+57r9wrdAi2vQogIQLmQDgEHZOS85or7n6p//zu++/v1/" +
       "dBd0mYTutz1ZJeVqwkH3AU/Xwi2Ar8z/7vcevDm9FyTXK1WhFyl/cJA3Vv/u" +
       "BgI+dXusIcvg5HS6vvGfWHvzwf/9jy8yQoUyt1iTL/Cv4c/+9KPEe/664j+d" +
       "7iX3Y9mLcRkEcqe8zV9y/u7y26783mXo6hq6rhxFiYsSdcEkWoPIKDwOHUEk" +
       "ea7+fJRzWNKfPoGzN1+EmjPdXgSa0/UA5EvqMn//BWx5U2nl94DnXUfY8q6L" +
       "2HIJqjLvrVieqNIbZfLOakzuiqD7/MCLgJQaiOyuhFVIGgFJTFe2q86eAsXV" +
       "ghNWzK+LoNpLr02H8A740gHayhQpE+zgEO3bOs/TVZfZJYAx9zRvdm7Wy//T" +
       "2whfZt9VJoMyIY/FfYNlKzeOcWcBImrgNjcsu3Ms//XK48sBOpLzgpBP/ZuF" +
       "BB794GljUw9EtB/5y499+cef/BpwuzF0T2UM4G1nemTiMsj/kc9+/C3f9txf" +
       "fKQCVYCoix/61qPvLVsVX56qj5aqzquYZSqHEV1hn6ZW2t5xtnGB6YDlIjmK" +
       "YOFnH/7a7qe//rlDdHpxal0g1j783I/+y82PPnf5zDfBky8Ky8/yHL4LKqFf" +
       "c2ThAHriTr1UHORffeHZ3/yFZz90kOrh8xHuAHzAfe6//f8v3/zUX/z+LQKo" +
       "u23vFQxsdA0atUIKO/5NG2sNxcSMdxNESOJMGah4qlMtxFAnWA8hhQU1mo+I" +
       "rhAorXarlbH8zIo6aySI8eba3vqJGvfrjDgxdjtybg/46VzMt73VkBoTy80o" +
       "p3EvnDSGZihP5vvpaMBNirk8ySh/OZ5Ta7IrwTpdOEzS6+T73aQpI5Ebd2pJ" +
       "bRTAtWTf6wgISvPRbikvqbYFk/iu52QNIUj88YYR93Ww6jaYOqNZHIkP4c6m" +
       "YaSNqdeem06riDxE7sycZpN3FnIet5x6Q1JRm5ecaRMPeT5XyYBe2ysYlfdb" +
       "FWWGjWVn6oz3+/20UOf9wa45yCMct0fsRhfXY7lgHIUQ9it3Np60dsS8RlmF" +
       "sjOJhukMWC2eC7o2j5LtcFeMtkFzXYjjzkbQtwGn2MvpuDHfRLUZ+ATH6hFN" +
       "aoWGZXbMZh3VYyzDXY6bLY+mR2EdWeqSVcwWeY+mx519HA5JLVkP19tI5uqh" +
       "PR8jUtzwraEUujXe8+don+ecMetsudhzyRWDtadx5LcXRL83nKxdut0cipTW" +
       "oRvLFWEEg1wujDEhN2RaXvs2R/X7jKiIKpLOCrkIs2DSEUORG9W2OtnvN/NI" +
       "70zoxmgpsLaUzNyBOKCmfSpqGOJ4PabDSNuJ+2zRV9Z+iy1i1LTFHaKiktlO" +
       "F+uOquyL1qgjTRlzzax3diPhQ1xqDRA5D1OjHgQNVMboAGXm+6i+6MxUeeLu" +
       "e3za1+W+YYl7YijbE63PrubgC0zzfMGRB6xOtZmoS+M0LjvLYbfoGslCRoU2" +
       "gTEDk5IbUmJJM6yX8CrFZztsRsXCRBRdfhFvFoyNa40dR1njQSN3RsbEl4fY" +
       "eM0Od/Su5azTQSTM7E5e03SrryRNpD1M6m16h1kT15lMtvCExfdzdxCNh7aj" +
       "LIxR3Ro2jeU4RQSThmNzi+HZqrVd1ZMi3WdqvIz4OrpbjGlEpByvs1P3m3QU" +
       "L1ZKnAf1RuBO80YfLCR02tjwtdmIyeadQB2sZcVcDxzKRYfSIEWNttbUzWnQ" +
       "yxqGWxfHwiLyB1QWDdOh0udZWpg4e4sMpiq75gV7Gq3Jvb9X5UwyNvuVgGwn" +
       "XtFUY16IYjpCyVyQ+MWQpRCHMBixTYzlGFcbKjusNdE5Yuqakq+2Pk5popFw" +
       "I4KCW34sdPRBjepy5mIybO+3SSYAJ4a1eosfp7vmdJW4hiB2WtaGj1YEQa+Y" +
       "faGy2EztFbg920yECF+7JrwQpnScrUZkzV5a2FRmUFZdESQpcrSjw1JDmng1" +
       "2MTnmKDQZl0h+8JKqIX0VFmGwGYzNZb2RB2uJ8QM36LJIOQ9d14nMAefGWNj" +
       "TqWSl01EnCYoTDWbzBYTjR0VyapBjakJhVlqHaeM8VZhO3DQS6RNL6zHWJrL" +
       "WE0y8PlcHSlbJlh0FIViehYy2a+UPF5qWqIL6CTfsjtj7nXnxYJm5nEoGVsz" +
       "N1DX7SkOtYzQfMk6U8Q2GgFNb2XRULeLKRW2woW4gsMOoe9SpzZUC3Hrhy3J" +
       "yrM+sYNZidm12A6jNlrCWCWNJMRsvj70ZvCatbgpKjMtxdoy/WIRI70WwwkZ" +
       "om0kg6dQAkOm2Tqldu0Ca1lUM9dGjoQLnC8WBdtxWtJ6nw9NJQ3ibbO/JsmW" +
       "NRjjMsISbGzP8dRx+7mNMdtGumnAWC3PrFQz+F3WHAkTZjgdYN54wk0JspPQ" +
       "fA/togosEWLcnsgAAuC4MxzC2XbeVILBYLAfDTTKUtcWNlLZutLudBK41Wls" +
       "cDzHVyE6I4q11UyDLRGkfTIphmaR6MCi3VBi+H6XUrruqkloC06IjRw4U5dK" +
       "8O7WqA2HcT6jZG3bWNkdGmbxojtfoIiTz2aWiFLt3GnCPLZa75f7xdjSRrWa" +
       "pKvIMNZrYVLTYjvuS74SEamsGxMg0H6BTtpSlLStuZgKooCRGrwp8iGvjGow" +
       "k9CTvE30J7tN0gFoxiU7TDdmKS6q9lItBrxMOSmeDdhkMAJTO+ClbVdetqaM" +
       "xMRcV8OaXX8x4ZQ9rqA1uqkX4zDTBgDf5bwGI6qzb85xfjzt4iaTTVxixtdG" +
       "44a3skIfL8Y0YWh7VQXad52Y63DbyA2iYrBYRdt4uZhjXjOrL7d0Q8EGHtuT" +
       "rQlSIAgMVsMAlfk27s+9bFePVvKkL2p7THPpjsdSTsHC6pgVV21s4rj+tt8Y" +
       "G96KYnv0hPb0Zod1mLy1JlUODepGUxpZaEsK+4I9IrliIK1lip5MwqizQQlV" +
       "k+DJpgUr2sgnyFQvzN0cGTCwrY8Wfl5kMLzUMGkAsGNC+gTMINku7XHyAqnt" +
       "tD5iGFHO1JTJAAQUMtVDuiuXRtpsMUFa2ngtqT6JZnlsMc54bUiI2m8vzU4k" +
       "LMWmN8pW+M6T0fZS5wiFNNAwcaT+SmlMHY5gG5xRG3sCvtcsAtWB2Zf9dG9h" +
       "Q6o+7wa4Enbrs84IjcjUbdguOd/YIYnPDdnetETwLbJid3uj3ZCmqDrjRd/n" +
       "VziyJZvBisybPEsabb21XPJ9jlhSvLsZdoboUm53NoTRRVubJdWaJAskyc1d" +
       "jzQ3iG8UfVwX9r0lUw/lBLW0tKUKktjV9vWBIrIpadcZvo2MdDjW7SYz0t1e" +
       "0yTBWrJNnAYfBGvUTwrRV+gAj5rhkk9DzmCbNAfH7qjY1AO+MRFWJCzQpDiC" +
       "/RY+N1Mv2XJ9L8hTtEv7DrpBAOjimjCw1nQntZlewCF2syMU9oqcK25NcCb9" +
       "LYKvwceXHZuZM05FZobgwmbo9lMs2zMW2h0WTWyEtZL+sDvAkD4wN94hNbE1" +
       "afAsys9b6djuDpxhG5Y3kqe7o2yb18nFGGsjqeAtYDVfCKo/E9veet/n2u6K" +
       "W7VCNMqDjlMkyq4/6a6M3WjOCK1lAibIsBfpwM7BzBN2hcb38bw/XmTIYpVx" +
       "/WCBmbyn70ytF2sjfZRm3e40Fsd4bTaj1QhpM7G0SkIun9dNq+cXxK7d0bco" +
       "imDomGkn4sQbW4Ueu6oF95psuycqehwh5NwRZrS1GPQ6qEpxrs0QpM/nQbBf" +
       "IiLMqfgsMlZNKYv9PA72hZkF81TEl0Pb3RXtAszQot9qsw3SNBR+vG4N1+xA" +
       "41fmvI+wa6qp7tM6r9eaFGuC0E/zjV5uU6nao9XVPOXQtrkhE+D67mi0ELXW" +
       "Ml6b1mgZkSSw0trduXFsp44zizm6rXdHvj02g+FS5BJt4HDISqfVCc6LCRYK" +
       "TRBm7kZhbNRHe2WSjt1gyS6caLTxcTMgAIvtm51psuIwq6GasBWYUr7uaDT4" +
       "XMlyeN5T6p3JglXjekezuppmbNCwp+I23aRwK6z1fYUtZrRECaRDA0jZCGNF" +
       "1jJ205nxTGyQlr1wuIYX9kdONPdjK526m5Qmt/vRquC2sbrguz2ZX7aNlZzu" +
       "AnhSDJojbgUD+JTxxbTeTh0C2UgzW2Gldq/do8ep0OgO00Iyh4y8X2ZIFLXA" +
       "2ksvVvPMcm1+bCXdjTMlVCuV8GiimEuFxd1w3wm7XgH0qZFAVqzBEcwoQ7lx" +
       "pnd7cyLJUdG1ovVCEPx2nsXmnEZ1WVWJ+ppjZT+AMXbRCQossm2Z3ARSzg6X" +
       "k6BQUEfX0cAU0YmiJJ6y2uwSOxKcFZOnhbtPWt3tthh20QzEIgMKzQO0Feso" +
       "VhMETzKM8WAa+EjKTfG9gxMgNkTBZBfRPdf3V4tppzUX2oPmajCQim6OLBoF" +
       "omMgaO1bWn8mEXy7BhrfjzC0nySc7A4IfpJ0cGUftwIu5fZ1BVUlobe1wlhn" +
       "SV5bO648EqSpn9kMw8fd0Ev1Rr5eSLOm2m5PVJ1OLDD8nKpEE4OVTKmzxsfU" +
       "drByplHubJs5wH8JHvdAeLhW4Jpsw6TcwNhNPuCJUCOmK1HCi11B1PTBdOUS" +
       "w+0SeMxUDpZSbdbipmRbgmuB3HLMAUkW421t27ERbrQBurVqi61gU1lMtVlD" +
       "claoIrOZbPf1fMzX9mhMixqyYHmMh0W5McMGXTJRVtlsZnbYyUqp5zWy2UPZ" +
       "ta0umZWEeIgk0yssbKzkpdAk63VszKlBoKxqkcEzesPi+32yzXXyubBriIRm" +
       "0EYTZTymjiBmwHcTwiYKYOD1jG26LVvaEJ0embUTax+oIwPDyk9h/eXtRjxU" +
       "bbycHAZadqesmL2Mr/BD1RNl8vaTTa7qd+UOG+hnNhmhcmfhLbc746t2FT79" +
       "weeeV9nPNC4fbc7KEXRf5Pn/wdYSzT7T1FXQ0rtvv4NCV0ecp5uGX/zg/31U" +
       "eM/2/S/jWOStF+S82OQv0p/9/eE7lJ+4DN11soX4osPX80xPn984vD/Qojhw" +
       "hXPbh285sewjpcXeAZ7mkWWbtz6auKUXXKq84DD2d9j7/r471H1/maQR9IgZ" +
       "Uu5WC8xIU7nAq46zK4bvOeMw74+gqxvPszXZPXWm7KW2dM52WRVE57V/J3h6" +
       "R9r3Xn3tP3KHuh8rkx+JoNeaIeaajhyVhxbH6pd1HzjV80OvVM+3g+eI9/B+" +
       "dfX85B3qfqpMfiKCHjbLuw3VFt9ttPzJV6DltbLwMfAMj7Qcvvpa/twd6j5T" +
       "Js9H0DVDi47VOzkTvODHd5lHl04qrX/2FWj9cFn4BHjYI63ZV1/rX7lD3a+W" +
       "yefOa80c4c/sVMXPvwIVqyXgcfAsj1Rcvvoq/vYd6l4ok/98ULGv6XJsH456" +
       "jo8T3vnSxyGn9JU1/ssrsMbrysJyAXzfkTXe9+pb48t3qPvDMvliBD0IrEGp" +
       "mhuVBw6HK0ajUw2/9HI0zCLo+sV7DOVB7BtfdKHqcAlI+fzz1+59w/Pif6+O" +
       "8k8u6tw3he7VY9s+e252Jn/FDzTdrHS473CK5levP4mgd/zbLltE0N3lq5L/" +
       "KwfmP42gJ16SOTo6CDrL+D8i6E13YIygK4fMWZ6vgqXiVjwAT0B6lvJ/AYte" +
       "pARSVO+zdH8ZQfef0oFOD5mzJH8FWgckZfbr/rHLIy9tsFPfOBrR7NL5MO3E" +
       "Vx5+KV85E9k9eS4eq+7lHcdO8eFm3jPKF54fM9/7zfZnDhcmFFsuirKVe6fQ" +
       "1cPdjZP464nbtnbc1pXRU9968Jfve/txrPjgQeDTKXZGtrfe+kbCwPGj6g5B" +
       "8Rtv+NXv/Pnnv1qd+f0rK1VExDApAAA=");
}
