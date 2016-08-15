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
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze2wcxRmfOzt+xa84cRLycF5OIA/uIJBC5DQlcZzE4Rxb" +
                                                              "cQitA3Hm9ubsjfd2l905+xyaAlHbpFWJeISnIOofQVAaSISK+qDQINQChaLy" +
                                                              "aIEiQh9IpKRRiarSqrTQ75vZvX2c74ylpift3N7M9818j9983zdzx86SSbZF" +
                                                              "WpjOY3zUZHasQ+c91LJZql2jtr0d+vqVe8ro33ad3ro6Sir6SP0gtbsUarON" +
                                                              "KtNSdh+Zq+o2p7rC7K2MpZCjx2I2s4YpVw29jzSrdmfG1FRF5V1GiiHBDmol" +
                                                              "yBTKuaUms5x1OhNwMjcBksSFJPF14eG2BKlVDHPUI5/pI2/3jSBlxlvL5qQx" +
                                                              "sYcO03iWq1o8odq8LWeR5aahjQ5oBo+xHI/t0VY5JtiSWFVggoUnGj7+5LbB" +
                                                              "RmGCqVTXDS7Us7cx29CGWSpBGrzeDo1l7BvI10hZgkz2EXPSmnAXjcOicVjU" +
                                                              "1dajAunrmJ7NtBtCHe7OVGEqKBAnC4KTmNSiGWeaHiEzzFDFHd0FM2g7P6+t" +
                                                              "1LJAxbuWxw/fs6vxiTLS0EcaVL0XxVFACA6L9IFBWSbJLHtdKsVSfWSKDs7u" +
                                                              "ZZZKNXWv4+kmWx3QKc+C+12zYGfWZJZY07MV+BF0s7IKN6y8emkBKOfXpLRG" +
                                                              "B0DX6Z6uUsON2A8K1qggmJWmgDuHpXxI1VOczAtz5HVsvRoIgLUyw/igkV+q" +
                                                              "XKfQQZokRDSqD8R7AXr6AJBOMgCAFiezik6KtjapMkQHWD8iMkTXI4eAqloY" +
                                                              "Alk4aQ6TiZnAS7NCXvL55+zWNYdu1DfrURIBmVNM0VD+ycDUEmLaxtLMYrAP" +
                                                              "JGPtssTddPrTB6OEAHFziFjS/PCr565a0XLyBUkzewya7uQepvB+5Wiy/tU5" +
                                                              "7UtXl6EYVaZhq+j8gOZil/U4I205EyLM9PyMOBhzB09u+8VXbn6UnYmSmk5S" +
                                                              "oRhaNgM4mqIYGVPVmLWJ6cyinKU6STXTU+1ivJNUwntC1Zns7U6nbcY7Sbkm" +
                                                              "uioM8RtMlIYp0EQ18K7qacN9NykfFO85kxBSCQ+phWcRkR/xzcme+KCRYXGq" +
                                                              "UF3VjXiPZaD+dhwiThJsOxhPAuqH4raRtQCCccMaiFPAwSBzBhQbaQdApvgw" +
                                                              "1bIMO1bGN6gWzAKad1EdYGHFEHPm/3W1HOo+dSQSAbfMCQcFDfbTZkNLMatf" +
                                                              "OZxd33Hu8f6XJOBwkzhW4+QKECAmBYgJAWKwXkwKEBMCYMfKWFgAEomIdaeh" +
                                                              "IBIK4MghCAkQk2uX9l6/ZffBhWWAQXOkHLyApAsDuandixtusO9XjjfV7V1w" +
                                                              "6tLnoqQ8QZqowrNUw1SzzhqAIKYMOfu8NglZy0se833JA7OeZSgsBbGrWBJx" +
                                                              "ZqkyhpmF/ZxM883gpjbcxPHiiWVM+cnJe0du2XHTJVESDeYLXHIShDpk78Eo" +
                                                              "n4/mreE4Mda8DQdOf3z87n2GFzECCcjNmwWcqMPCMDLC5ulXls2nT/Y/va9V" +
                                                              "mL0aIjqn4H4Ili3hNQIBqc0N7qhLFSicNqwM1XDItXENH7SMEa9HQHYKNs0S" +
                                                              "vQihkIAiL3yx13zwrVf+fJmwpJtCGny5v5fxNl/YwsmaRICa4iFyu8UY0L17" +
                                                              "b8+dd509sFPAESgWjbVgK7btEK7AO2DBb7xww9vvnTr6RtSDMIe8nU1C+ZMT" +
                                                              "ukz7DD4ReD7FB0MNdsiQ09TuxL35+cBn4spLPNkgBGpyR9mt1+gAQzWt0qTG" +
                                                              "cP/8u2HxpU/+5VCjdLcGPS5aVow/gdd/wXpy80u7/tEipokomII9+3lkMq5P" +
                                                              "9WZeZ1l0FOXI3fLa3Puepw9ChoCobKt7mQi0RNiDCAeuEra4RLSXh8auwGax" +
                                                              "7cd4cBv5SqV+5bY3Pqrb8dEz54S0wVrL7/cuarZJFEkvwGJXEqcJBH4cnW5i" +
                                                              "OyMHMswIB6rN1B6EyS4/ufW6Ru3kJ7BsHyyrQFC2uy0Im7kAlBzqSZW/e/a5" +
                                                              "6btfLSPRjaRGM2hqIxUbjlQD0pk9CBE3Z37pKinHSBU0jcIepMBCBR3ohXlj" +
                                                              "+7cjY3Lhkb0/mvGDNQ8fOSVgaco5Zucj7JxAhBVlvbfJH339it88fPvdI7Iw" +
                                                              "WFo8soX4Zv6rW0vu/+M/C/wiYtoYRUuIvy9+7IFZ7WvPCH4vuCB3a64wcUGA" +
                                                              "9nhXPpr5e3Rhxc+jpLKPNCpOGb0D0xLs6z4oHW23toZSOzAeLANlzdOWD55z" +
                                                              "woHNt2w4rHkJE96RGt/rQhicjS5cC89FDgYvCmMwQsTLFsGyRLRLsVkh3FfG" +
                                                              "SbVpGRykZFD6VtiiZucgiapTLZdfR0BlVol1gFekbVuwzORk+fgZXhbJAG8Z" +
                                                              "krG9Epur5bprxsJzbmw9Ivh6sSev+FSU2Js+CBPcp3OL1c2i5j+6//CRVPdD" +
                                                              "l0oQNwVr0Q44aj322/+8HLv39y+OUepUc8O8WGPDTPOtWYlLBrZNlzhSeBh8" +
                                                              "t/6OP/24dWD9RGoS7GsZp+rA3/NAiWXFd2JYlOf3fzhr+9rB3RMoL+aFzBme" +
                                                              "8ntdx17ctES5IyrOT3JzFJy7gkxtwS1RYzE4KOrbAxtjUR4AU9GxS+BZ6QBg" +
                                                              "ZXhjeKBbgs2Xg1ivKcFaIveoJcaEy2CTTVXtTn0QTr6w5aAqEofbYJ2Kfu7N" +
                                                              "Jm2oKdUM1BnDzkFsZc9u5WBrz/sShheMwSDpmh+J37rjzT0vC4dVIULyZvKh" +
                                                              "A5Dkq44asYnhVigRo0PyxPc1vTf0wOnHpDzhgBwiZgcPf/uz2KHDcovIo/ai" +
                                                              "gtOun0cet0PSLSi1iuDY+MHxfU89su9A1LH7dZxUJg1DY1TP+yWST17TglaU" +
                                                              "sm74VsNPb2sq2wibr5NUZXX1hizrTAUBWGlnkz6zeqdzD46O1FigcRJZ5mZO" +
                                                              "EeRYiSD3OZI2dqw3Rf/uIOgvhGe1g9zVEwd9MdYSwP56ibFvYnMTHHVUe52u" +
                                                              "ZijHWtFFPY4ZnkluPl8mWQyPM6f8nphJirGWUPv2EmN3YvMdKBRUvAsT2C1i" +
                                                              "kFvPg0EacKwFnk2OVpsmbpBirCWUPlJi7LvY3Af19gDjriXyZ7eMs/Pxy/S9" +
                                                              "c07KVOdu07ej8eeob5vdfx5M2IRjC+DpduzQPXETFmMtYaYTJcaewOb7QRNu" +
                                                              "hVjlVmONosDHmtSpujwLHTsPFpqCY/PhudZR89qJW6gYawkr/KzE2LPY/ERa" +
                                                              "aANL06wmC3bXQheOX6969MJwT50HwzXjGNaquxztd03ccMVYSxjnlRJjv8bm" +
                                                              "RU7qwXCdKciWcOBnsq7s9Yzxy/+FMXIA1PCNHx5PZxb89SCvy5XHjzRUzThy" +
                                                              "zZuiSM5faddC0ZPOapr/AOV7rzAtllaFbrXyOGWKr7c4WfL5riU5Kccvocab" +
                                                              "kvkdThaMywznquE8hhzGU5zMLsEI5yr54uf5A+TTsXggJELrp3wfLBqmBCnE" +
                                                              "t5/uA05qPDpYVL74ST6E2YEEX8+Y7q65bHyDeZhxPJqLBA9feQw1j4ch33lt" +
                                                              "UaBIFf9guVVcVv6H1a8cP7Jl643nvvCQvMxTNLp3L84yGWo3eWWYP64sKDqb" +
                                                              "O1fF5qWf1J+oXuwWlYHLRL9sAsmQiMTF26zQ7Zbdmr/kevvommd+dbDiNSiH" +
                                                              "d5IIhWPBzsKLg5yZhXPizkRhjQpHO3Ht1rb0/tG1K9J/fUdczZCCC5kwfb/y" +
                                                              "xsPXv37HzKMtUTK5k0yCepnlxI3GhlF9G1OGrT5Sp9odORAR/Ua1QAFcj3uM" +
                                                              "YgIRdnHMWZfvxVteThYWlvWFd+M1mjHCrPVGVk/hNFBCT/Z63GNr4MSXNc0Q" +
                                                              "g9fjO8nkZJWA3gDI9ie6TNO9Ii1fYYpQMzp22YDtp+IVm8/+Cw3OPSDdHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zs1l2n701ybxLS3JukL9I2TZqbtqnZ65nxeDyjQKnt" +
       "GY89Y4894xl7xss29fgx9oxf48fYYwiUStCKarsVpFAkCH/Qiof6QAjELggU" +
       "hKBFVEisurssiBZWSHSXraB/8BDldez5vXPvDVEiRvLxmXO+33O+n+/5nu/5" +
       "+pzzma9D98QRBIeBu1+5QXLTzJObaxe7mexDM7454DBRi2LToFwtjqeg7Fn9" +
       "Hb9w7W+/+XH7+mXoigo9ovl+kGiJE/jxxIwDd2caHHTttLTnml6cQNe5tbbT" +
       "kDRxXIRz4uQZDvqWM6wJdIM7FgEBIiBABKQSASFOqQDT60w/9aiSQ/OTeAt9" +
       "L3SJg66EeileAj1xvpFQizTvqBmxQgBauLf8LwNQFXMeQY+fYD9gfgngT8DI" +
       "8z/2/uu/eBd0TYWuOb5UiqMDIRLQiQo94Jne0oxiwjBMQ4Ue8k3TkMzI0Vyn" +
       "qORWoYdjZ+VrSRqZJ0oqC9PQjKo+TzX3gF5ii1I9CaITeJZjusbxv3ssV1sB" +
       "rG88xXpASJflAOD9DhAssjTdPGa5e+P4RgK9/SLHCcYbQ0AAWK96ZmIHJ13d" +
       "7WugAHr4MHau5q8QKYkcfwVI7wlS0EsCPXrbRktdh5q+0Vbmswn05ot04qEK" +
       "UN1XKaJkSaA3XCSrWgKj9OiFUTozPl8fffvHvttn/MuVzIapu6X89wKmxy4w" +
       "TUzLjExfNw+MD7yH+1Htjb/+kcsQBIjfcIH4QPMr3/ON933bYy9+8UDzllvQ" +
       "CMu1qSfP6p9aPvgHb6We7txVinFvGMROOfjnkFfmLx7VPJOHYOa98aTFsvLm" +
       "ceWLk99ZfPDnzb+8DN3PQlf0wE09YEcP6YEXOq4Z9U3fjLTENFjoPtM3qKqe" +
       "ha6CPOf45qFUsKzYTFjobrcquhJU/4GKLNBEqaKrIO/4VnCcD7XErvJ5CEHQ" +
       "VfBAD4DnSejwq94JtEbswDMRTdd8xw8QMQpK/DFi+skS6NZGlsDqN0gcpBEw" +
       "QSSIVogG7MA2jyr0uKRdAZmQneamZlnQQLpOBFoByHnNB2YR3SxtLvx37S0v" +
       "sV/PLl0Cw/LWi07BBfOJCVzDjJ7Vn0/J3jc+9+zvXT6ZJEdaSyAcCHDzIMDN" +
       "SoCboL+bBwFuVgKUBY2bFwWALl2q+n19KcjBFMBAboBLAM7ygael/zT4wEfe" +
       "cRewwTC7G4xCSYrc3mdTp06ErVylDiwZevGT2ffL31e7DF0+73xL4UHR/SW7" +
       "WLrME9d44+Kku1W71z78tb/9/I8+F5xOv3Pe/MgrvJSznNXvuKjmKNBNA/jJ" +
       "0+bf87j2y8/++nM3LkN3A1cB3GOiAV0Cz/PYxT7Oze5njj1lieUeANgKIk9z" +
       "y6pj93Z/YkdBdlpSjf+DVf4hoOM2dJScs/+y9pGwTF9/sJdy0C6gqDzxd0jh" +
       "T/7h7/9ftFL3sdO+dmYZlMzkmTOOomzsWuUSHjq1gWlkmoDuTz4p/sgnvv7h" +
       "/1gZAKB48lYd3ihTCjgIMIRAzT/wxe3//upXPvXly6dGk4CVMl26jp4fQP4L" +
       "+F0Czz+XTwmuLDhM8oepI0/z+ImrCcue33kqG3A67sGG4xsz3wsMx3K0pWuW" +
       "FvuP156q//L//9j1g024oOTYpL7t5Rs4Lf9WEvrg773/7x6rmrmkl4veqf5O" +
       "yQ6e9JHTloko0valHPn3//e3/fgXtJ8EPhn4wdgpzMq1QZU+oGoAa5Uu4CpF" +
       "LtQ1yuTt8dmJcH6unQlOntU//uW/fp3817/xjUra89HN2XHntfCZg6mVyeM5" +
       "aP5NF2c9o8U2oGu+OPqu6+6L3wQtqqBFHXi4WIiAD8rPWckR9T1X/+g3f+uN" +
       "H/iDu6DLNHS/G2gGrVUTDroPWLoZ28B95eF3vu9gzdm9ILleQYVeAv5gIG+u" +
       "/t0NBHz69r6GLoOT0+n65n8Q3OWH/s/fv0QJlZe5xZp8gV9FPvMTj1Lv/cuK" +
       "/3S6l9yP5S/1yyCQO+Vt/Lz3N5ffceW3L0NXVei6fhQlyqXXBZNIBZFRfBw6" +
       "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" +
       "qe4QFP/1Tb/07T/zwleqM79/BSsLtl4wKQAA");
}
