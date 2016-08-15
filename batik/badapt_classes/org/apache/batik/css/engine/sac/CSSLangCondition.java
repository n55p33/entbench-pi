package org.apache.batik.css.engine.sac;
public class CSSLangCondition implements org.w3c.css.sac.LangCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected java.lang.String lang;
    protected java.lang.String langHyphen;
    public CSSLangCondition(java.lang.String lang) { super();
                                                     this.lang = lang.toLowerCase(
                                                                        );
                                                     this.langHyphen =
                                                       lang +
                                                       '-'; }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.CSSLangCondition c =
                                                    (org.apache.batik.css.engine.sac.CSSLangCondition)
                                                      obj;
                                                  return c.
                                                           lang.
                                                    equals(
                                                      lang);
    }
    public short getConditionType() { return SAC_LANG_CONDITION;
    }
    public java.lang.String getLang() { return lang;
    }
    public int getSpecificity() { return 1 << 8; }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        java.lang.String s =
          e.
          getAttribute(
            "lang").
          toLowerCase(
            );
        if (s.
              equals(
                lang) ||
              s.
              startsWith(
                langHyphen)) {
            return true;
        }
        s =
          e.
            getAttributeNS(
              org.apache.batik.util.XMLConstants.
                XML_NAMESPACE_URI,
              org.apache.batik.util.XMLConstants.
                XML_LANG_ATTRIBUTE).
            toLowerCase(
              );
        return s.
          equals(
            lang) ||
          s.
          startsWith(
            langHyphen);
    }
    public void fillAttributeSet(java.util.Set attrSet) {
        attrSet.
          add(
            "lang");
    }
    public java.lang.String toString() { return ":lang(" +
                                         lang +
                                         ')'; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZCWwc1fXv+nZ85ySHkxgnKA7sEq42mFAS4xDDJtnGwagb" +
       "iDM7+9eeeHZmMvPXXpumHKUipWoKNBytSKSqoYE0EFQVtZRDrmg5Cm0FpKWU" +
       "cqgglaMUIsShpoW+9//MzrGHZbWppfk7/v+99997/51/jrxHqiyTtFONRdi4" +
       "Qa1Ir8bikmnRVI8qWdZWmBuU76iQPtz+1qbVYVKdIE3DkrVRliy6XqFqykqQ" +
       "RYpmMUmTqbWJ0hRixE1qUXNUYoquJchsxerLGKoiK2yjnqIIMCCZMdIqMWYq" +
       "ySyjfTYBRhbFgJMo5yS6NrjcHSMNsm6Mu+DzPOA9nhWEzLh7WYy0xHZKo1I0" +
       "yxQ1GlMs1p0zyUpDV8eHVJ1FaI5Fdqrn2iq4NHZugQo6Hmj++MTNwy1cBTMl" +
       "TdMZF8/aQi1dHaWpGGl2Z3tVmrF2ka+RihiZ4QFmpDPmbBqFTaOwqSOtCwXc" +
       "N1Itm+nRuTjMoVRtyMgQI0v9RAzJlDI2mTjnGSjUMlt2jgzSLslLK6QsEPG2" +
       "ldF9d2xv+UkFaU6QZkXrR3ZkYILBJglQKM0kqWmtTaVoKkFaNTjsfmoqkqpM" +
       "2CfdZilDmsSycPyOWnAya1CT7+nqCs4RZDOzMtPNvHhpblD2f1VpVRoCWee4" +
       "sgoJ1+M8CFivAGNmWgK7s1EqRxQtxcjiIEZexs7LAABQazKUDev5rSo1CSZI" +
       "mzARVdKGov1getoQgFbpYIAmI/NLEkVdG5I8Ig3RQbTIAFxcLAFUHVcEojAy" +
       "OwjGKcEpzQ+ckud83tt0wd6rtQ1amISA5xSVVeR/BiC1B5C20DQ1KfiBQGzo" +
       "it0uzXl0T5gQAJ4dABYwP/vq8YtOb598SsAsKAKzObmTymxQPphsem5hz4rV" +
       "FchGraFbCh6+T3LuZXF7pTtnQISZk6eIixFncXLLE1+59jB9N0zq+0i1rKvZ" +
       "DNhRq6xnDEWl5iVUo6bEaKqP1FEt1cPX+0gNvMcUjYrZzem0RVkfqVT5VLXO" +
       "/wcVpYEEqqge3hUtrTvvhsSG+XvOIITUwEOWwLOciL9OHBiRo8N6hkYlWdIU" +
       "TY/GTR3lt6IQcZKg2+FoEqx+JGrpWRNMMKqbQ1EJ7GCY2guyhbBDwFPUkuRo" +
       "T39/DCwL3CnFJY+gsRn/n21yKO3MsVAIDmJhMAyo4EEbdDVFzUF5X3Zd7/H7" +
       "B58RJoZuYeuJkTNh54jYOcJ3jsDOEbFzBHaOBHcmoRDfcBZyIE4dzmwEvB/C" +
       "b8OK/qsu3bGnowLMzRirBIUjaIcvDfW4IcKJ64Py0bbGiaWvrno8TCpjpE2S" +
       "WVZSMausNYcgXskjtks3JCFBuXliiSdPYIIzdZmmIEyVyhc2lVp9lJo4z8gs" +
       "DwUni6G/RkvnkKL8k8k7x64buObMMAn7UwNuWQVRDdHjGNDzgbszGBKK0W2+" +
       "8a2Pj96+W3eDgy/XOCmyABNl6AiaRFA9g3LXEunBwUd3d3K110HwZhKcO8TF" +
       "9uAevtjT7cRxlKUWBE7rZkZSccnRcT0bNvUxd4bbait/nwVmMQOdcQE859je" +
       "yX9xdY6B41xh22hnASl4nljTb+z/0+/ePpur20kpzZ5aoJ+ybk8YQ2JtPGC1" +
       "uma71aQU4F65M/7d2967cRu3WYA4tdiGnTj2QPiCIwQ1f+OpXS+99urBY2HX" +
       "zhnk8WwSyqFcXkicJ/VlhITdlrv8QBhUIUag1XReroF9KmlFSqoUHetfzctW" +
       "Pfj3vS3CDlSYcczo9KkJuPOnrCPXPrP9k3ZOJiRjGnZ15oKJ2D7TpbzWNKVx" +
       "5CN33fOLvvektB+yBERmS5mgPNiGbF9HpuZBVcYxMeNGRMblp3kuXz6Tj1wT" +
       "HInwtdU4LLO8XuF3PE8dNSjffOyDxoEPHjvOxfAXYl4j2CgZ3cLucFieA/Jz" +
       "g1Frg2QNA9w5k5uubFEnTwDFBFCUISZbm00InjmfydjQVTV//uXjc3Y8V0HC" +
       "60m9qkup9RL3PlIHZk+tYYi7OeNLF4lTH6uFoYWLSgqEL5hAzS8ufqa9GYPx" +
       "U5j4+dyfXnDowKvc/AxBYwHHD2Mq8IVbXs67Hn/4hS/84dAtt4+JgmBF6TAX" +
       "wJv3z81q8vq/flqgch7gihQrAfxE9Mhd83sufJfju5EGsTtzhekLorWLe9bh" +
       "zEfhjupfh0lNgrTIdvk8IKlZ9N8ElIyWU1NDie1b95d/otbpzkfShcEo59k2" +
       "GOPctAnvCI3vjYGw1oRHOB+eLtvju4JhLUT4y2Uc5TQ+duFwhhNF6gxTZ8Al" +
       "TQUCSWMZsgxiAgiI7+eJwInj+TjEBJk1Ja2x1889lkxRe5toCe63Cu5x2FTI" +
       "ZClsBq4CTG4YN4apVozVy8uwmnO3XJnfkv9VO7Wd8+sNsF7PsIPTIqx4xs6W" +
       "eaGDFY6vvHGgVk1VF/XmGBSp0Gk5mBheFpUq83mLcvD6fQdSm+9eJXyvzV86" +
       "90JneN8f//1s5M7Xny5Sp9Ux3ThDpaNU9chUg1v6vH0j74Bc13ml6dY3Huoc" +
       "Wjedugrn2qeonPD/xSBEV+kAEmTlyevfmb/1wuEd0yiRFgfUGSR578YjT1+y" +
       "XL41zNs94dMFbaIfqdvvyfUmhb5W2+rz51PzBjYT7ekUeNbYBrameJlSxDbz" +
       "yb8UaiAblk6hImrxnYwyKZRXBCNQhtBdcMiWv+7GM+/PJi2okZUMmOuo3UOe" +
       "Fd8h7+mMvylM8pQiCAJu9j3Rbw+8uPNZfni1aC15lXksBazKU+21CF18Dn8h" +
       "eD7DB7nFCfyF2NxjN4RL8h0hprOyeSkgQHR322sjd711nxAgmIQCwHTPvps+" +
       "j+zdJ/xLXCucWtDZe3HE1YIQB4dx5G5puV04xvq/Hd398D27bwzbZwOVVk1S" +
       "11UqaQUHDiWuX+2C14u/2fzIzW0V68Fz+0htVlN2ZWlfym+9NVY26TkH9ybC" +
       "tWWba9Q5I6Eup1rg8VadKjWUL1RwokdY5FDe7FtxbSk8fbbZ903fY0qhljH+" +
       "75RZuwWHm8ClhijLR+t8ZzJqHyv+XO15v4aRKijkTBY8MPz3Bo8Wv3UStNjm" +
       "xJ24rYr49LVYCrWMpn5QZu2HONwFdgxajDm1hquF/SdBC824tgieK2xRrpi+" +
       "FkqhlpH0/jJrD+BwLyNNoIV+g8rQYckKG5/KkioUbUo7OnwSNMjz1zx4tttq" +
       "2D59DZZCDWgp7K+yZjpVVkrPRPDeHGIcNxm+42QZFf8Kh4fB+zISk/mFnkdJ" +
       "j5wEJfG7iDPgGbElHZm+kkqhlkjyvrItn2q3SGO8YByUrzytZU7n6g877KxW" +
       "BNZzgbz34V8kEqe1yAK4WNIPXBzfc6hWfjnzxJtOdhrLy9NAhNuFqRBH/DJy" +
       "5X95mwlomSiDLAlN2FYlQ1O2RTi3pSeVPu/7fVWyq+gfj6hr3//ij9YI3S0t" +
       "UXa48A99+fXn9k8cPSIqCKyDGFlZ6ttP4QcnvJZbVuZq0T3Ujy45f/LtNwau" +
       "cs6oCYdjOce9Gt0bAmiBcfIvxeMLR/59GXd7HYffQHZMK6qa/zYHRIvFscpR" +
       "XUm53vjMyUp92EKbtkuZ0/fGUqhl1PCPMmsf4PA2I7VMF9dZgdz3zv9CDTk4" +
       "guBdO94FzSv4vie+Scn3H2iunXvg8hd5a5f/btQA5Xk6q6re2wrPe7Vh0rTC" +
       "pWoQdxcG//kUGqcpOl7IYjBy9j8RSCcYWVAGCVsR/uLF+YyRWcVwgDqMHshQ" +
       "CBQShISswH+9cJWM1LtwsKl48YLUAHUAwddao3SHFfK01t6kM3uq882jeG+P" +
       "0bv5J1wnGmfjdhA5euDSTVcfP+9ucXstq9LEBFKZAQW9uEjPN8BLS1JzaFVv" +
       "WHGi6YG6ZU6caBUMuz6ywGPIPRAWDDSq+YGrXaszf8P70sELHvvtnurnIcJt" +
       "IyEJMvm2whu0nJGFFLYtVti4DEgmv3PuXvH98QtPT7//Mr+jtJPewtLwg/Kx" +
       "Q1e9cOu8g+1hMqOPVEETRXP8au/icW0LlUfNBGlUrN4csAhUFEn1dUVNaP8S" +
       "+ibXi63OxvwsfvtgpKOw1yv8YlSv6mPUXKdntRSSgb5qhjvjXIT47hCyhhFA" +
       "cGc8/fDXRSwVGbViMLbRMJxWuGaJwcPADcWDOBruAv6Kbwv/A1gX35DeIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T7z7vz3/u+XB7/8HqY3MUKcrAAA=");
}
