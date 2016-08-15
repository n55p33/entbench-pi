package org.apache.batik.css.engine.value.svg;
public class PointerEventsManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_FILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          FILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_PAINTED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          PAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_STROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          STROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_VISIBLEFILLSTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLEFILLSTROKE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLEPAINTED_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                      VISIBLEPAINTED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_VISIBLESTROKE_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          VISIBLESTROKE_VALUE); }
    public boolean isInheritedProperty() { return true;
    }
    public boolean isAnimatableProperty() { return true;
    }
    public boolean isAdditiveProperty() { return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_POINTER_EVENTS_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 VISIBLEPAINTED_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public PointerEventsManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze3BU1Rk/u4G8CCQEAsgjkBBgeLgrKrU2lAohSHATMgSZ" +
       "dlHC2btnkwt3773cezbZYKnItIV2KoOIiI5m+gcOlqIwTp0+rBbHaZVqnaq0" +
       "aB2xD2ekUqYyndpOaaXfd+69ex/7iJkp3Zl79u4533fO9/id7/vO2ROXyFjT" +
       "II1M5RE+pDMz0q7ybmqYLNmmUNPcCH290sNl9G9bLnTdGiblcTKhn5qdEjXZ" +
       "GpkpSTNOZsmqyakqMbOLsSRydBvMZMYA5bKmxkmDbHakdUWWZN6pJRkSbKJG" +
       "jEyknBtyIsNZhz0BJ7NiIElUSBJdGRxujZEaSdOHXPJpHvI2zwhSpt21TE7q" +
       "YtvoAI1muKxEY7LJW7MGWaxrylCfovEIy/LINmWZbYJ1sWV5Jmg+VfvJlQP9" +
       "dcIEk6iqalyoZ25gpqYMsGSM1Lq97QpLmzvI10hZjIzzEHPSEnMWjcKiUVjU" +
       "0dalAunHMzWTbtOEOtyZqVyXUCBOmvyT6NSgaXuabiEzzFDJbd0FM2g7J6et" +
       "pWWeig8tjh56eEvdM2WkNk5qZbUHxZFACA6LxMGgLJ1ghrkymWTJOJmogrN7" +
       "mCFTRd5pe7relPtUyjPgfscs2JnRmSHWdG0FfgTdjIzENSOnXkoAyv41NqXQ" +
       "PtB1iqurpeEa7AcFq2UQzEhRwJ3NMma7rCY5mR3kyOnYcgcQAGtFmvF+LbfU" +
       "GJVCB6m3IKJQtS/aA9BT+4B0rAYANDiZXnRStLVOpe20j/UiIgN03dYQUFUJ" +
       "QyALJw1BMjETeGl6wEse/1zqWr7/HnWtGiYhkDnJJAXlHwdMjQGmDSzFDAb7" +
       "wGKsWRQ7TKc8vy9MCBA3BIgtmh9+9fJtSxpPv2LRzChAsz6xjUm8VzqamPDG" +
       "zLaFt5ahGJW6ZsrofJ/mYpd12yOtWR0izJTcjDgYcQZPb/jFV3YfZxfDpLqD" +
       "lEuakkkDjiZKWlqXFWbczlRmUM6SHaSKqck2Md5BKuA9JqvM6l2fSpmMd5Ax" +
       "iugq18RvMFEKpkATVcO7rKY0512nvF+8Z3VCSAU8pAaeZmJ9xDcn6Wi/lmZR" +
       "KlFVVrVot6Gh/mYUIk4CbNsfTQDqt0dNLWMABKOa0RelgIN+Zg9IJtL2gUzR" +
       "AapkWNQc6AOjCNS2D8AsZidVARlGBGGn/78XzKIFJg2GQuCcmcHQoMCuWqsp" +
       "SWb0Socyq9ovP937qgU73Cq27Tj5AsgQsWSICBkiIEPEkiEiZIiADJFCMpBQ" +
       "SCw9GWWxMAEe3Q6xAYJzzcKeu9dt3ddcBmDUB8eAO5C02Zek2twA4kT9Xulk" +
       "/fidTeeXvhQmY2Kknko8QxXMOSuNPohm0nZ7w9ckIH25WWSOJ4tg+jM0iSUh" +
       "iBXLJvYsldoAM7Cfk8meGZwch7s5WjzDFJSfnD4yeN+me28Ik7A/ceCSYyHm" +
       "IXs3hvtcWG8JBoxC89buvfDJycO7NDd0+DKRk0DzOFGH5iA4gubplRbNoc/2" +
       "Pr+rRZi9CkI7p4AAiJqNwTV8kanVifKoSyUonNKMNFVwyLFxNe83tEG3R6B2" +
       "IjYNFoARQgEBRYL4Yo/++Nuv//kmYUknl9R6ioAexls98QsnqxeRaqKLyI0G" +
       "Y0D33pHuBx+6tHezgCNQzC20YAu2bRC3wDtgwW+8suOd988fPRt2IcwhgWcS" +
       "UAdlhS6Tr8InBM+n+GDMwQ4r9tS32QFwTi4C6rjyfFc2iIUKhAcER8udKsBQ" +
       "Tsk0oTDcP/+unbf02b/sr7PcrUCPg5YlI0/g9l+3iux+dcs/GsU0IQlzsWs/" +
       "l8wK8JPcmVcaBh1CObL3vTnrkZfp45AqIDyb8k4mIi4R9iDCgcuELW4Q7c2B" +
       "sVuwmWd6Me7fRp6aqVc6cPbj8Zs+fuGykNZfdHn93kn1VgtFlhdgseXEbnwZ" +
       "AEen6NhOzYIMU4OBai01+2Gym0933VWnnL4Cy8ZhWQlCs7negMiZ9UHJph5b" +
       "8bsXX5qy9Y0yEl5DqhWNJtdQseFIFSCdmf0QdLP6l26z5BishKZO2IPkWSiv" +
       "A70wu7B/29M6Fx7Z+aOpP1h+bPi8gKVuzTEjF2Fn+iKsqO/dTX78rVt+c+yB" +
       "w4NWhbCweGQL8E3713olseeP/8zzi4hpBaqXAH88euKx6W0rLgp+N7ggd0s2" +
       "P3dBgHZ5bzye/nu4ufznYVIRJ3WSXU9vwswE+zoONaTpFNlQc/vG/fWgVfy0" +
       "5oLnzGBg8ywbDGtuzoR3pMb38QEMzkAXroBngY3BBUEMhoh4WSdY5ot2ITZL" +
       "hPvKOKnSDY2DlAxq4HJTFO8cJJFVqmRz6wioTC+xDvCKzG0KlmmcLB45yVvV" +
       "MsDbCsnYfh6bO6x1lxfCc7awHiF8vd6VV3zKS+xND4QJ7tNZxQpoUfwf3XNo" +
       "OLn+iaUWiOv9RWk7nLme+u1/Xosc+f2ZAtVOFdf06xU2wBTPmhW4pG/bdIqz" +
       "hYvB9yYc/NOPW/pWjaYmwb7GEaoO/D0blFhUfCcGRXl5z0fTN67o3zqK8mJ2" +
       "wJzBKb/XeeLM7fOlg2FxkLI2R94BzM/U6t8S1QaDE6O60bcx5uYAMAkdOx+e" +
       "dhsA7cGN4YJuPjZf9mO9ugRridwjlxgTLoNNNkk2O9R+OALDloOqSJxy/XUq" +
       "+rknkzChppTTUGcM2CeyG7u3Svtauj+wYHhdAQaLruHJ6P2bzm17TTisEhGS" +
       "M5MHHYAkT3VUh00Et0KJGB2QJ7qr/v3tj114ypInGJADxGzfoW9fjew/ZG0R" +
       "68w9N+/Y6+Wxzt0B6ZpKrSI41nx4ctdzT+7aG7btfhcnFQlNUxhVc34J5ZLX" +
       "ZL8VLVlXf6v2pwfqy9bA5usglRlV3pFhHUk/ACvMTMJjVveY7sLRlhoLNE5C" +
       "i5zMKYIcKxHkPkPSxo5Vuujf6gc9RuaYjdzY6EFfjLUEsL9eYuyb2NwLRx3Z" +
       "XKnKacqxVnRQj2Oaa5Ld18ok8+DpsfXqGb1JirGWUPuBEmMPYvMdKBRkvBQT" +
       "2C1ikPuvgUFqcawRnritVXz0BinGWkLp4RJj38XmEai3+xh3LJE7u6XtnY9f" +
       "uuedc1Im25ecnh2NP4c82+zRa2DCehxrgidh2yExehMWYy1hplMlxp7B5vt+" +
       "E3ZBrHKqsTpR4GNNalddroVOXAMLTcSxOfBss9XcNnoLFWMtYYWflRh7EZuf" +
       "WBZazVI0o1gFu2OhBSPXqy69MNxz18BwDTg2VyhsfXaM3nDFWEsY5/USY7/G" +
       "5gwnE8BwHUnIlnDgZ1Zd2eMa45f/C2NkIU8UuvXDI+q0vP8hrLtz6enh2sqp" +
       "w3eeE4Vy7n67BgqfVEZRvIcoz3u5brCULPSrsY5Uuvh6m5N5n+l2EqIPtEKR" +
       "cxbru5w0jcgKJ6uBHIpsxvOczCjBCCcr68XL8wewVCEeEAtaL+UHsPmDlCCF" +
       "+PbSfchJtUsHi1ovXpKPYHYgwdeLurNvbhrZXC5qbH9mQ/7jVw5FDSOhyHNi" +
       "m+srU8WfWU4dl7H+zuqVTg6v67rn8ueesK7zJIXu3ImzjIPqzbo0zB1YmorO" +
       "5sxVvnbhlQmnquY5ZaXvOtErm8AypCJx9TY9cL9ltuSuud45uvyFX+0rfxMK" +
       "4s0kROFgsDn/6iCrZ+CkuDmWX6XC4U5cvLUufHRoxZLUX98VlzMk70omSN8r" +
       "nT1291sHpx1tDJNxHWQsVMwsK+40Vg+pG5g0YMTJeNlsz4KI6Deq+ErgCbjD" +
       "KKYQYRfbnONzvXjPy0lzfmGffzterWiDzFilZdQkTgNF9Di3xzm4+s58GV0P" +
       "MLg9nrNM1qoT0BsA2d5Yp647l6RjVusi2AwVLhyw/VS8YnP1v2kqUHDoHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v/bBf/ryN6pTv/8HxbbmtDspAAA=");
}
