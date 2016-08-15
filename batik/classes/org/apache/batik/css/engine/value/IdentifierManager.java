package org.apache.batik.css.engine.value;
public abstract class IdentifierManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    java.lang.String s =
                                                      lu.
                                                      getStringValue(
                                                        ).
                                                      toLowerCase(
                                                        ).
                                                      intern(
                                                        );
                                                    java.lang.Object v =
                                                      getIdentifiers(
                                                        ).
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                            }
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        java.lang.Object v =
          getIdentifiers(
            ).
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public abstract org.apache.batik.css.engine.value.StringMap getIdentifiers();
    public IdentifierManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DS/9G+ps1veWGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wjR33f+13ucnckuUsgIQ155wgNS39r7/qpo2nW9tpr" +
       "e+21vQ97Xcqx7117X96X10tDIaUlKipFEF4SRGoFKqXhUVTUShVVqqoFBKpE" +
       "hfqSCqiqVFqKRP4orZq2dHb9e99dooiqlnZ+szPf78z3+ZnZmd9zP4DOBD4E" +
       "e6610S033FWTcHdhlXfDjacGuz2qPBL9QFWalhgELGi7Kj/8hYs/evH9xqUd" +
       "6OwcerXoOG4ohqbrBBM1cK1YVSjo4mErYal2EEKXqIUYi0gUmhZCmUF4hYJe" +
       "dYQ1hC5T+yIgQAQEiIDkIiD4IRVgulV1IruZcYhOGKygd0CnKOisJ2fihdBD" +
       "xwfxRF+094YZ5RqAEc5l7zxQKmdOfOjBA923Ol+j8Idg5JmPvPXSF09DF+fQ" +
       "RdNhMnFkIEQIJplDt9iqLal+gCuKqsyh2x1VVRjVN0XLTHO559Adgak7Yhj5" +
       "6oGRssbIU/18zkPL3SJnuvmRHLr+gXqaqVrK/tsZzRJ1oOtdh7puNWxn7UDB" +
       "CyYQzNdEWd1nuWlpOkoIPXCS40DHy31AAFhvttXQcA+muskRQQN0x9Z3lujo" +
       "CBP6pqMD0jNuBGYJoXtuOGhma0+Ul6KuXg2hu0/SjbZdgOp8boiMJYTuPEmW" +
       "jwS8dM8JLx3xzw+Gb37f2x3S2cllVlTZyuQ/B5juP8E0UTXVVx1Z3TLe8kbq" +
       "w+JdX356B4IA8Z0niLc0f/CLLzzxpvuf/+qW5nXXoaGlhSqHV+VPSrd9897m" +
       "Y/XTmRjnPDcwM+cf0zwP/9Fez5XEA5l318GIWefufufzkz8X3vkZ9fs70IUu" +
       "dFZ2rcgGcXS77Nqeaal+R3VUXwxVpQudVx2lmfd3oZtBnTIdddtKa1qghl3o" +
       "JitvOuvm78BEGhgiM9HNoG46mrtf98TQyOuJB0HQJfBAd4LnIWj7y/+GkIYY" +
       "rq0ioiw6puMiI9/N9A8Q1QklYFsDkUDUL5HAjXwQgojr64gI4sBQ9zrkIKPV" +
       "gUxILFqRinQVwGqCIPcHogNCwt/N4s37f5spyXS+tD51Crjj3pNgYIE8Il1L" +
       "Uf2r8jNRg3jhc1e/vnOQHHvWCiEMTL67nXw3n3wXTL67nXw3n3z3msmhU6fy" +
       "OV+TCbF1P3DeEsAAAMhbHmN+ofe2px8+DeLOW98ELJ+RIjfG6eYhcHRzeJRB" +
       "9ELPf3T9Lv6XCjvQznHAzQQHTRcy9lEGkwdwePlkol1v3Ivv+d6PPv/hJ93D" +
       "lDuG4HtIcC1nlskPnzSx78qqArDxcPg3Pih+6eqXn7y8A90E4AFAYigCOwK0" +
       "uf/kHMcy+so+Oma6nAEKa65vi1bWtQ9pF0LDd9eHLbnvb8vrtwMbE9BecSzm" +
       "s95Xe1n5mm2sZE47oUWOvj/LeJ/4m7/4Zyw39z5QXzyy9DFqeOUIOGSDXcxh" +
       "4PbDGGB9VQV0f//R0Qc/9IP3/HweAIDiketNeDkrmwAUgAuBmX/lq6u//c63" +
       "P/mtncOgCcHqGEmWKSdbJX8MfqfA8z/ZkymXNWwT+47mHro8eAAvXjbzo4ey" +
       "AaCxQApmEXSZc2xXAfEsSpaaRex/XXx98Uv/+r5L25iwQMt+SL3p5Qc4bP+p" +
       "BvTOr7/13+/PhzklZwvdof0Oybbo+erDkXHfFzeZHMm7/vK+j31F/ATAYYB9" +
       "gZmqOZxBuT2g3IGF3BZwXiIn+tCseCA4mgjHc+3IhuSq/P5v/fBW/od//EIu" +
       "7fEdzVG/D0TvyjbUsuLBBAz/2pNZT4qBAehKzw/fcsl6/kUw4hyMKANkC2gf" +
       "4E9yLEr2qM/c/Hd/8qd3ve2bp6GdNnTBckWlLeYJB50Hka4GBoCuxPu5J7bR" +
       "vD63j+sJdI3y2wC5O387DQR87MZY0842JIfpevd/0pb01D/8xzVGyFHmOuvw" +
       "Cf458tzH72k+/v2c/zDdM+77k2sxGWzeDnnRz9j/tvPw2T/bgW6eQ5fkvZ0h" +
       "nyEuSKI52A0F+9tFsHs81n98Z7Ndxq8cwNm9J6HmyLQngeZwLQD1jDqrXzh0" +
       "+GPJKZCIZ9Dd6m4he38iZ3woLy9nxRu2Vs+qPw0yNsh3mIBDMx3Rysd5LAQR" +
       "Y8mX93OUBztOYOLLC6uaD3Mn2GPn0ZEps7vdpm2xKiuxrRR5vXLDaLiyLyvw" +
       "/m2Hg1Eu2PG99x/f/43feOQ7wEU96Ey+oAHPHJlxGGWb4F997kP3veqZ7743" +
       "ByCAPvy7X7zniWzU/ktpnBWtrCD2Vb0nU5XJ13VKDMJBjhOqkmv7kpE58k0b" +
       "QGu8t8NDnrzjO8uPf++z293byTA8Qaw+/cyv/Xj3fc/sHNkzP3LNtvUoz3bf" +
       "nAt9656Ffeihl5ol52j/0+ef/KNPP/merVR3HN8BEuAD57N/9d/f2P3od792" +
       "nY3GTZb7Ezg2vNUiS0EX3/9RRUFF11yS2BqdImt4zXXWwVAXKvqg3BK5ZUvY" +
       "eOP2olGnU03u49NwuE5pbIgxmIoWi+gcRlOuvCItoiE1mHZfJ8YNXvTYgun2" +
       "OGXqLtLxhBfHNqf0+gxPsiG+8orEymrVGZ2JllpIoIit2HVNSedti5eYNFZt" +
       "xLHharVM+khsYxhKr1YbdjhpDBurBbcWEyEuiOy0xXajJdzm4+nMM6iNLfu1" +
       "YY2eGRFMl1arpNhgW1bYGvhSVycoLmxNO7y5EicSYRNoJCxbrLRkm72JvO6x" +
       "DV7pFEahuZgKw+KkzUfm2DHFgdCqoaWKznOou+rPI2YsyI0JEy/crkMM5x3U" +
       "KCvVUsVoFN2Ct8A23qKajsJa162VS4FZ6U/hDlHTmanUX7kcv0nFadqaNJbD" +
       "mVftr1ibXo47NFlkULo5k8iwzAguHbXLbj1ygk1RbgyCpLeyOaxUE9dwopDT" +
       "pkfTLjqPQ77gqLTbhxdN31wNyyTbbmNYg1vpPN4zqJVTFw0cLogmqi1hZwKT" +
       "kbdZteZLb9JuO8uu3WDnCYY2mVIaNA1j4TnlcmyE/YjykqlDtRyzlETLAiqP" +
       "QmeD4YvpyJ3O2x10ttr0cQL4eCG0mwybkCzqleklMhbEcIaj4ojgqeaKbUWq" +
       "5NOc3xW9llrGUrlrSwItzPpzp4/gC2eAFubiSkrUoaUSeDmuuJt+UG1OJ0p1" +
       "nnAO2Wml8gCvNCbjdJAszDS0GFosu6LgTY2ZzKX1RZ1mmrg/jjcGLRXcldFv" +
       "yQNCNAbgS6Eb9kvFZqVjzbt9jOmOG0PTk4Ybj52jQWtDDypMrxt3iXaxSeFt" +
       "nmJlAi30JmrZHMjrbkyNw/JGVbVKbSix9U1cVfpmH+9WvJIdDGLMF/ghKQ4H" +
       "6tIkbJ1djztJPE1qiJ4wNW2x6RIJXTCEJZkiDKJEHWWRwLNZQ8Y2g8V4sZKH" +
       "hLe0yr1wVqi7K9jxA99uuEXDLnnpyG4skUHApLofj7kW0ZknS2YoLSibshCt" +
       "VseDkeZqNVrwVw2rU/T7IUpGfZdXpNRYdZlasWISkyG7NMpEyE2oOkIWx9IY" +
       "xyK6PwnYgGnOFwS76vYtDuZFLAXON1tUQ++tVi2lMKMqdKWqT206TuSB0cap" +
       "UV9XnGVpicQGYi56DBvU2KYcClw6URhPr9DVmoWr/eWaEsr9MT8ZbcrzyC42" +
       "m8SqYs+5dUJ0aBqPNsnUTN3eoKDzU4npDj207+HLHsjELj0edAYB5qaIXRk3" +
       "aWTU3HA6gVGE2cKFVXlIRDOuwA42thY6WgHDdBgWhe6wJ8gLn3NRPW0KhV5p" +
       "gUcjXWsKRKO6WNsDa20Ry7XNgeR2u/XSKE10ooN3ZUldSjGKYa7alttJr5BM" +
       "x/Z0Xpko+sznymin3UQaPZjvSSWMdYocGk+stkVSvGErnjBXeSsqL9ulHkU6" +
       "ShIxRMeq6X5HtJCG0JvRxc6Uafgb0Z/hpVnHLzSn/Y0quFOYNUtlYW35i0l1" +
       "wNj+qOrVpLhvIGNEJrjZROgW9e4qwLFwgTaIEdp1e5hR7RjkELGFugxHDmuv" +
       "6Iox6bfciJpu5k25Oi7KpX5A2Yzs+zw8mC03Na2qzm1/zXFeYsitdWtOzIUJ" +
       "3m+r7XprPp36+rrhKGmH5ilpifqrQZkrI4U5SPHQ7xszbhyBZBnr/nqqdSSO" +
       "HsG+g9STQVVdTlNR1DQetoYNFURTMrcLstVe1c1h4hN6r1At1ylthCWVmkzX" +
       "SJwwFzOrQYppMK7pTX/dajvpss6MYm3WKJaXPtdEiX6oePRYDtlSR5nXW2Rt" +
       "orbKbSwQYgrv4eww1MbVqc9Umo5MLH1kWMDrBotPGoJMsnFhgw+6UrhmTC7Q" +
       "kOokJiXWxGrlAkPJvtwfdDYFqYxqeqrAKJ5ipXLQQRQMR4m5zc/kOkx6Dl5z" +
       "ObUMo7YpqgLpTknMcspJJy6N2uP2uNMDhhXkWaODNeAujQ16oTyWtep6E2qC" +
       "OxQ3RWSBa+xmKKs9dcryaTnARojRT9VSGJDwJkKw7jQtmKbOzPSGgcj6HLdb" +
       "I96QJamdMHgDnRrd9qpdnW/WdEpvakNNahMxtmYSYdOYNhZNdLLc4CnR1a1G" +
       "ulrpUwQJbN9cw/WZ0DHxikEXZ+0KPqKJcZUbV2S2jyvudDFA1C7CCD7Zprhx" +
       "h5/2jaXuWAY/A56M5OFmUdggwsDC6iFwVY8nPbFTokg5xXCFxGIh6JGjSd3x" +
       "qxOWLzUYHd8YUn+4GiLpbCRIsq4mdOj00VGJxYR0QDtUZUI6YWkZuSgqdJBx" +
       "q4LFchWplYtRIlfrdbewBrAyrchS2O+5i9Wy6DQmuNhPjEZcY1Nd9RGvSNdh" +
       "tIcpMhMX9aBYTNuDCUrXebm7KAbwEJn2ZjMyrrKBj0myq0S45s0MeT2fx07o" +
       "TjUtIlVFa/p9uGg3YJOvy2SD9evwujscLwuU4Vd7RuB5hJN6nolT401SqeDz" +
       "coHF6bhpMoN1ZCf6ZGbo4IOLcCuTqGULhtc1+zWaQaxiv+C0OGNZDi3MCYVp" +
       "t9pmuM4kkLwRVzGoABOjyYqPFYrRYqxjjRKYaTukSHQ1lrMUcRogpOKWBvWJ" +
       "shQWDawmF0hUapKu48973ZYCF5dUGQBoMkqHy6WGiKw4aBphiIzrE53DgsFo" +
       "UZOHjXSmNQK5tKlL4+oomLa11bxuo8lqMyO4pI0VhiQRbbhJMO5NiZXKLHCi" +
       "VgnLPbo3RqikGrBxYyzJvC223E6ITBwvQKoRicHUnAtGTJCYizhkiOFILLaY" +
       "YmC2CLniOYuFgXCT1BfrAVni6qpKICvCL44NwaFq9baMLLxCidIaPawVz6x2" +
       "CpaZmMBYejlTFZmLTVpn6zId+8ygoI4m82Izmkdm39SVnlno8TDoXwicHVVr" +
       "TEyP2Oqcb+GtqCV2xWmRptHOeA2ist6Yi0rNcPioYlQYuuWmYPdhmpSPCd0m" +
       "p1SblaRZHcoa4c+dIQk3pVrEpSZSHMhul0R7zYVMkwuUGaG1cqI3N8t4MGeR" +
       "8bRXCKjpsIavqwW2WGuWcVs0Oamx7JdCB6cXzrAwbsOSABeS4SJpcvxgWvWd" +
       "dqU8s1S71UJa+oLCQ8WcaswEqUk9E8WrBTfS+uvqlPc3IWfVuvOOFtcbcgCz" +
       "zdhRyiRThsH6hxcHVWEVuRTjwDhvBPaGWchtHTWBYqW4OuAUuVxVB6ZgMtTA" +
       "MQjJwZjVprmW3FltRiGlehkmNzxaGk0m3Bo2bQTnlxNPH4cwWUMwVvZW8cgd" +
       "941SbT6sNat6qzmL6iKl0zEawgZax6YLU2W7Za3pkUzPa5LjOKy5asOvDgUC" +
       "7/GI6oyTJBE0Em5Hmk1itVEBqzqeiA2MZZurjwabalFvAai1tEBMwV5RlTar" +
       "sMrL1ZFnKKsipeMdyZ3A2MzAcd9fo3V6U2gAoDKrKj+sSKjm99NSeRavR2Nt" +
       "3GgPCI5qITqMdO14RrZGgdgxRg08nvCsi2uOspI0ZyNaYScdIsgYi/2kQMwW" +
       "RFXj+7Acd+BZORFpfYj5I6/B4zOB1b3FiqgkyrLsqSW9JghgzQxmK6rU7FM9" +
       "eN1xW37PEzy7ySVhKVykgWRSVLTi6hN+6vb6I6yFz6YMY7fCwrQQVPU2Eqdj" +
       "BjZZf86jsjSxzdYQpv3Ios3JohGPh2O7VKA7JaWc9quySLY69qY+bYpStTpB" +
       "NnyLQeod2AuKsTrtgM+r7LPrLa/sy/f2/CP/4GIGfPBmHZ1X8MWXXH/Cnb3D" +
       "hXOiFIS+KIfJwaln/rv4EqeeR06GoOwT974bXcbkn7effOqZZxX6U8WdvRO1" +
       "aQidD13vZyw1Vq0Th0xvvPGn/CC/izo86fnKU/9yD/u48bZXcJb9wAk5Tw75" +
       "O4PnvtZ5VP7ADnT64Nznmluy40xXjp/2XPDVMPId9tiZz30Hls2tey94Ht2z" +
       "7KPXP0++rsdO5R7bBsaJA8udrUv3T35el90+rDE5v3QIRHmXUhNTFi3OMcN9" +
       "mte/1A1Fk2GIvJbPFp6Y7dTe/cPeSHfvz6a49m6LHhCJrHqZJ3LmNCvcEHqV" +
       "7KtiqOYnbfucb3j5W5JD+jzQvZc72jh6gpk3WMeN/zB4Ht8z/uP/N8Y/vRe9" +
       "2fvkSDbyIXQmMFw/PMjYdc7/9PXNmb2+PSf49az4ZZD7W5NtD+9yQ2Qd7zi0" +
       "xrt/AmvcnzW+CTzDPWsMX4E1dg7QSr2uSY4eoH/kJfo+lhUfCKHbdDU8vA8L" +
       "9uMDfvn42BpnIHqHVvngK7FKAsx8zU1cdpVw9zX/BrC9upY/9+zFc699lvvr" +
       "/DLq4Hr5PAWd0yLLOnrye6R+1vNVzcx1Pr89B/byP78VQg+9rJLh3glrLvxv" +
       "bhk/tZflN2AMobPbylGeT4fQa67HE0KnQXmU8ndD6NJJSiBF/vco3edC6MIh" +
       "HZh0WzlK8ntgdECSVb/o7Tu28vKOxfeWpTzu9/ySnDq+8hy4/I6Xc/mRxeqR" +
       "Y0tM/j8h+8tBtP2vkKvy55/tDd/+QuVT24s72RLTHMbOUdDN2zvEgyXloRuO" +
       "tj/WWfKxF2/7wvnX7y9/t20FPsyuI7I9cP2bMcL2wvwuK/3D1/7+m3/72W/n" +
       "5+n/C3/EfwKsIwAA");
}
