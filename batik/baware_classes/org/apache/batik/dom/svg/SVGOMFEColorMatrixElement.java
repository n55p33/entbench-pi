package org.apache.batik.dom.svg;
public class SVGOMFEColorMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEColorMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_MATRIX_VALUE,
    SVG_SATURATE_VALUE,
    SVG_HUE_ROTATE_VALUE,
    SVG_LUMINANCE_TO_ALPHA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFEColorMatrixElement() {
        super(
          );
    }
    public SVGOMFEColorMatrixElement(java.lang.String prefix,
                                     org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getValues() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEColorMatrixElement.getValues is not implemented");
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEColorMatrixElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zkxn3ffp+k00mWdCfJlhXZkk/Syba06sd9cR+RnZjL" +
       "JZfL5S53l7vkLh37zCW5JJfv98NV7RiJ7TaI6yay4xaxgAJOH4FsB0WDFigc" +
       "qK88EDdADKNtAtR2iz7SOAZstE2DuG065H7vu/skVUY/gHPcmf/M/J+/+c9w" +
       "7pXvle7yvVLZsY1UMezgQE6Cg60BHwSpI/sHJAVPBM+XJdQQfH8O6m6IT/3a" +
       "lT/94WfVq/ulS3zpYcGy7EAINNvyZ7JvG5EsUaUrJ7WYIZt+ULpKbYVIgMJA" +
       "MyBK84MXqNJbTnUNStepIxYgwAIEWIAKFiDkhAp0ul+2QhPNewhW4Lulv1La" +
       "o0qXHDFnLyg9eXYQR/AE83CYSSEBGOFy/psFQhWdE6907Vj2ncw3Cfy5MvTS" +
       "L3346j+4o3SFL13RLCZnRwRMBGASvnSfKZtr2fMRSZIlvvSgJcsSI3uaYGhZ" +
       "wTdfesjXFEsIQk8+VlJeGTqyV8x5orn7xFw2LxQD2zsWb6PJhnT0666NIShA" +
       "1kdOZN1JiOf1QMB7NcCYtxFE+ajLnbpmSUHpXed7HMt4fQgIQNe7TTlQ7eOp" +
       "7rQEUFF6aGc7Q7AUiAk8zVIA6V12CGYJSo/ddtBc144g6oIi3whKj56nm+ya" +
       "ANU9hSLyLkHpbefJipGAlR47Z6VT9vne+H2f+ahFWPsFz5IsGjn/l0GnJ851" +
       "mskb2ZMtUd51vO856vPCI1/79H6pBIjfdo54R/OP/vIPPvD8E6/+9o7mHbeg" +
       "oddbWQxuiF9aP/D770Sf7dyRs3HZsX0tN/4ZyQv3nxy2vJA4IPIeOR4xbzw4" +
       "anx19purj/+q/N390r2D0iXRNkIT+NGDom06miF7fdmSPSGQpUHpHtmS0KJ9" +
       "ULobvFOaJe9q6c3Gl4NB6U6jqLpkF7+BijZgiFxFd4N3zdrYR++OEKjFe+KU" +
       "SqW7wVN6N3jeU9r9PZMXQUmGVNuUIUEULM2yoYln5/L7kGwFa6BbFVoDr9ch" +
       "3w494IKQ7SmQAPxAlQ8bJNuE/Ai4EtunRzgGeLe9kQD8KsmxAoxykLub8/9r" +
       "oiSX+Gq8tweM8c7zUGCAKCJsQ5K9G+JLYRf7wVdu/O7+cWgc6ioo1cDcB7u5" +
       "D4q5D8DcB2Dug9vOXdrbK6Z8a87DzvbAcjrAAICO9z3LfIj8yKefugM4nRPf" +
       "CdS+D0ih24M0eoIagwIbReC6pVe/EP80+7HKfmn/LNrmfIOqe/Pukxwjj7Hw" +
       "+vkou9W4Vz71R3/61c+/aJ/E2xn4PoSBm3vmYfzUeQ17tihLABhPhn/umvDr" +
       "N7724vX90p0AGwAeBgLwXwA1T5yf40w4v3AEjbksdwGBN7ZnCkbedIRn9waq" +
       "Z8cnNYXpHyjeHwQ6fqB06OzsocMX/+atDzt5+dadq+RGOydFAb3vZ5wv/tvf" +
       "+6/1Qt1HKH3l1LrHyMELp5AhH+xKgQEPnvjA3JNlQPfvvjD5xc9971MfLBwA" +
       "UDx9qwmv5yUKEAGYEKj5Z3/b/YNvf+tL39w/dpq9oHSP49kBiBpZSo7lzJtK" +
       "918gJ5jw3ScsAd81wAi541xfWKYtaRtNWBty7qj/68oz1V//k89c3bmCAWqO" +
       "POn51x7gpP7HuqWP/+6H/+cTxTB7Yr64najthGyHmA+fjIx4npDmfCQ//Y3H" +
       "/+ZvCV8E2AvwztcyuYCwUqGGUmE3qJD/uaI8ONdWzYt3+af9/2yInUpCboif" +
       "/eb372e//xs/KLg9m8WcNvdIcF7YeVheXEvA8G8/H+yE4KuArvHq+KeuGq/+" +
       "EIzIgxFFAGc+7QHUSc44xyH1XXf/4T/954985PfvKO3jpXsNW5BwoYiz0j3A" +
       "wWVfBYCVOD/5gZ1x48uguFqIWrpJ+KLisWPPeEteeR08Hz70jA/fOgLy8smi" +
       "vJ4X7znytktOuDY08Zyr3XvBgOeMsn8Idvnvt4GssZA9TzwOdonHUcMztwRc" +
       "ZA0gB6iiZ4thjrEFtx+4wO54XnSKplpe/PiOc/h16W5H+2jx625g3GdvD894" +
       "nsCdINyjf04b60/8hz+7yYEKYL5F3nKuPw+98suPoT/x3aL/CULmvZ9Ibl7F" +
       "QLJ70rf2q+b/2H/q0r/cL93Nl66Kh5k0Kxhhjjs8yB79o/QaZNtn2s9mgru0" +
       "54XjFeCd59H51LTnsflk9QTvOXX+fu85OH5bruX3gef5Q995/rwz7pWKl8mt" +
       "/XE/f30vcEq/yNcPnfIvwN8eeP5P/uQD5hW7xOYh9DC7unacXjlgcX84MY25" +
       "J2jBwCqWlGNLAT98701+WARqzwZxkA4sSU5kaZ5j3UncFI42fS1HGx6r4R15" +
       "7SXwdA/V8L7bqOGnbq2GOwo15MU8AFbQLMEoFL0ISm+ZrybYDRahFhgDHPiZ" +
       "2ztwAbS7hPjlv/P0733s5af/fYFVlzUfmBnxlFtk6Kf6fP+Vb3/3G/c//pVi" +
       "Sb9zLfg7g5/f2ty8czmzISnYvu9YMW/N9fBYDjyHitnbmfHGzWb88WtuKPia" +
       "G4K18L07jLq284prhUKu7dDlgx+6NqJ72I0xMsKYa++/ZsnxYctHBXP94gcP" +
       "Dg4+9MKzjlMwghwDwt4O/nZ2ywv5yCTqBZ75/rz4yJEpLhmypQTqxTAy8TQT" +
       "pA7R4fYFevGhb+u//Edf3m1NzmPGOWL50y/9tb84+MxL+6c2hE/ftCc73We3" +
       "KSwYvL/gMl/BnrxolqIH/l+++uI/+XsvfmrH1UNntzcY2L1/+V//768ffOE7" +
       "v3OLPPoO4AD5D8lJbrckPHyyJKCGbcl5cB217XJpzT443n6DxuQmO3ml526v" +
       "41HhcCd4+Vuf+OPH5j+hfuQNJNHvOqej80P+/dErv9N/t/gL+6U7jtHzpr35" +
       "2U4vnMXMez05CD1rfgY5H9+5XqG/nd/lxfsK012wBn78grZP5MWLADbEXNU7" +
       "y1xA/rNJ6RzOfej141yRfedbzP5hOPdvg3Ofvk36UeDcUTzta8cY/fzFmzPE" +
       "0swcI3aBfo7/v/oG+c+XKOqQf+o2/P+N18N/sSoeSVB9fRLkwZXj3eHe4pQY" +
       "v/CaYuwCfA/kcHfVDloHlfz337pgQSnQa34Gwt6+NcTrR9jLyp4P+Li+NVoF" +
       "WJ5jaPG6GQLR+sBJyFO2pbzwc//xs1//609/G+AHWboryjMTEHSnUsVxmJ/H" +
       "ffKVzz3+lpe+83PFdgiol/2ZHz72gXzUv/3GxHosF4spzhgowQ9GxfZFlnLJ" +
       "iiGMU/IACLsTRMp5L3r90gYP/gzR8AfI0R9VEVAuFqubZVT2YC1pw6o1VskN" +
       "Oqti1mq+NSgXIxCRrvebE9VuGRai8NusVYVhXTKFVZkLovl4jDgYJaC6N8dQ" +
       "xVi7XJ90uwiGeu50hSnsAEb1uSqgtor0YjzoO5ytGDzCdKDWqDXK6JbfStRl" +
       "t2KlE6geQdBy05GgLGnPaT0ed0mkyq40us65XcJlcQ2yu36lpmGUusUGYjrR" +
       "WksLndTldq0eOHp3SuuZtVUCbIsq60B3FXG84slImK7meBcTohnT9xcsNLer" +
       "bq+hjjCDVX2jncoaLbQGOuMmxJYlsX6XqqCk7o2GPGXHRj9MK+h2PCMUchTD" +
       "6VxsKVx9ttBgt++2iM1MwOsugTaGK5ETIwXuuykGq1NFsUyUIQYw1a05gyYn" +
       "cE47bCQct1BNk1GtDYUbiluboS16gRFbBF5sNgTYn3fZ5XRVU4aot22oQJ0C" +
       "McSyqTDgl/R6KI0abaEK075OVajhcqSNxtjGn4t0LMyUWiCwVX/Qa6GurTfU" +
       "ios3NryB2FVsZmg8rjexRX2qrlXccaCs12WGJrNoLeOMofQqKVRcfiCTgdse" +
       "EOtOZ9bhENmdxabBD1KFTgcxwvTmK75rz6dlxuK2k5lrVDgsZWN826t2Jcyc" +
       "OalHVgKmPx5OSUqZGEEgd/WpO2rWO5MZLikzfjyaD4xJ1SCUpGX0uGW8SLiZ" +
       "0uNmYsN3bEYKsTaKKy7CjZtzBIV8eK234OFiiI6pCA2Y0ZaHurOuIrB90bew" +
       "asBy5YGPYO6cl2ZdYeFvECQkG2nXVfDhVlMyXZXm7tAWKpWpFBtbCZl2KvZk" +
       "uW4MELcx9RBHjEdBmUo0s2vIdpu1KB6uZFFohOEiW3nT2QCx3PHCIAloZGwX" +
       "DdysGKJgz0NMNJGIYisrGp36cm3W1rtkz5Lh7tgiO52WHLNuEtATs65RIxet" +
       "ZHJTbzj+rBendCjjyawWGOWV2m9zgqCrNtSbk0CpXpB2A2Za0bLBYDGbMv01" +
       "3SO9RUeWN7VOh2CmBiHMp0afxepEbLdMrR+IOli01y5GVhUJt8epqTIe04tb" +
       "AYmtE4IccIJfryUmhvPjtrkss4yaRu0+LnJId+ja+LhhkMJaaMEekkRGa6HR" +
       "GD7Ce4ZPZ4qjQNRciaf+ZCs4ab/L4lMSW4w7Zd9NzTI2kIcjxWwRcXOidNYR" +
       "qjreNJ4ue+62weE+MklcHdeGXuL3sK63ZSquULbcZNxgoYWMbGJXk7Aukjab" +
       "JsTDa36GaZxvIjEWJyYZDcmeiverHMxs2Vmb6WnTmsSX2xtZ4iujLBYMt7EK" +
       "p71azzFaKrSVB5LS6hIhIYbwGFH6ZXie6fF62uH6jWWCIIM45AKkKkUhx0Or" +
       "pNGw5gLfq9kTxHS23JZyRWSIE1KVSLoTFmcn1Nytdgb6Nh00ZwKGG6je69cD" +
       "Othi1BJbSusupZbxMc3qWpML1wPcmRsS3rdZxQCLPIczw+rUdBtZvG1X40UL" +
       "T/tOJog0PNZhvixG/Umquv2O0BjoJtlQxJGPav1aI+pCPVlz2uO635tmQtOY" +
       "y51yu09O68GCrDA6P4tbC2DOWVcXokVLZcXyICSGoENvMKiHQig51GAwzZBV" +
       "Q5yNxH4rgR1M2I634cpmMmxA4JNqiCLbdMwnw1m0rC4MS7UibzlplHudROt5" +
       "BA3D3eosMiIVbU1FPLHl7aZpLsShpVXCfgehoTIBR9XWoMpVLEN3lrN5F+F4" +
       "3zPRfiKozRq8dUK6qc5RS43qYwKKpIiuU4xUThNl3F+u/a5F9BRVW2HktJ3J" +
       "chSt2XGlLclzc9WORsgg5QRvO2g0e4wwH5nkAKfUQSr54ThR0VVz3evOpyLv" +
       "1ocyqi30mJmZ3JAvR9vUEao9qN4xNG+Oc8zKn1edjhhj1sTKxk7Pszr1xIt5" +
       "mtS62sRaL2AX5afrVt+W0rDZJkMYHcNxI6rW650hjWQOog8rg0V1RlgLko0n" +
       "quSFq7RV7m8TCV6RG6XSHzagOdTRKMt1VCKpOpuNm6jNVqefWeOoEvtB0FLh" +
       "rpCNOr3BxmAYFKp0w81Yifo03ZUkiqq7mgfDmISIM8XWVLS7nTckxFyk2Vz3" +
       "W4OhVk1gaOVjVarMzFZd0THYhVrTlrFY4YfxqO+Mpo1k7BrSxmad+sjQ+kO3" +
       "4aKzXnkQk+wEZVrDtbfth6NhPXLhOIDCsGV3UCsUura14Dsp0LNeibNJzw9h" +
       "yZxCs54WNujxkABwTaz5KdNIUFyGkqox2ChAtK5bmW7r0HKqW7Qq4umwxnBc" +
       "JigkFwrCrIy7yFKoD7UhKsa+NQ5CorNx4hrW69YrpBo35+3WGlpAlUZFaPIK" +
       "xrZHamcusG7a0GozLIWijWwy9aTeabk46TdVN+Mr+oQO3Ek5nc+gTacptfm1" +
       "n82nsIBmrXGZJrK257l0R9jAsibRjbJn8v11U61mlkfVlXq0bcXiGl3GElmZ" +
       "ow7mVjge06ZYsu2oLuGPw7TcHbuLMaE2Ua7OabWaAyJ/ZaZjsVa3MxUf1+Je" +
       "oDXqIU6m1mjWCn2lJlfhZdOLNg1xMEkMuS4seyHpoZMMhHONTpqQVZ51TQdd" +
       "8UYsVaccJaF6xxzKIVKuN9S4XocVqWbHUb/b27JDvYMYK3hW3YJwyZqB2fY7" +
       "wXDaWDa4WJ10fb8XbAysV+OWm2mb2tp0hRosEnSG6726Vu0YmJ90LaefxWnU" +
       "onWBqKXUmlY2cw9ppsOuSsYsoaMjIqTctitvRlmjLfkT05eV0TRMnRoGS95s" +
       "tenVyzAOjbqyZHBcT8vmbS4C21CDr0/a60TejpYymNnzjAGt6eRywfaN1VqN" +
       "0mWFW66SCdScO+V1fT5fQgBzO6uR390qrMZRfq0Ke/XtGobLvkCVN0ZjCzPj" +
       "Cb6FnBZXNTuwxxkEyQ2bVVvPxtzKiocmTfBStzcOolDftoN6Y92b+5Fotbs0" +
       "Areghk1WE8SCeiu5GYceaoB1f6SkgrIYrof9rl/fIGMhSlu4zTOCj8RC3Zh0" +
       "YLfZqnv1yXio1GXLnDY3zV4dsnVpFIAeg0SGXHNLrYVIXPvNSj1rbFGcNFpm" +
       "EAebymZJa/PKhOgEmd42WGnpEjVX1xvRpgNtoYkqw40mrPsei8g1BIJGvanF" +
       "Lrcp16hu/RjmWUaR5VlgBjrN9HVPshEkNjl8YUmMBfOi3NJI2ifgbWZjENQk" +
       "4fVo7Jc1VBRgTa20+5DR6NJsKNR8UmYdaN3xODiGNkrVr6mOYSk+jLLwvA0l" +
       "fLYK8LiNlRlubC4WKWVtGLzFGXADZqz1EPOU1OR5xNxu2mmGgpQllep9p8M0" +
       "bGTSQhG63sDioTuczXkonq7bHb7Gdn1HhZaW549iaJCYHQ4KPa7pxaFP2PXh" +
       "omFXvAVZU6tjo5UNmEHaVFw865Tndjy3XZlG1TlbdgSh1dymsu4vyhud0Hqq" +
       "KlpmMxV9xiCmkQsSH5Y1uerEC7hRd8guNkY92MTRzNPVZIuzpjVhBp3hmNds" +
       "hp/UBgku6mpli2/05TDgTV5dxWG1E4xIlQULSotgHcrWw7ZE+O6cqrIjEfPC" +
       "vkARMpfFYqh5kjKqm6g5y9o6NcvYWk1I2qN4wsHeloTbvRqA+G4loKEwWBDe" +
       "kk57W0dzapGeWgKaCuVAg6JWIFG0rzCS6c/qmemzsznaXMO454q1eNNuYJ2t" +
       "P4r6rK4P+a4yIr25ZJj0dOiQG3EQK+2KPMws1UsiBGH4xVB2Vm2amNhbKBGG" +
       "vrgSImXBpDN81gl42YK17UwylR7RrjIEP28sNrN5VVEgn5wl5biiBXZ7Vukx" +
       "VBtdSOsMbvTW7GLrDfrzEVFmRpDK8S1HYKwaV7bVcqpsarjSjEbGoDwzDAyf" +
       "cnC14SVckrARsaJZvD/xUb7RMby0RdY6Q2sQdGZEPUAgv4fA0TTGhm6octXA" +
       "VgVgNZ1kZCRJxtFyRI/H3MDH+cYabAGjJVEzfbdaxcQ1AXnIxF+rm7nWsYdG" +
       "l4VJvuWOXLbGJ53JsktLveXIZgKVlkymrK35ZjlaYkHWTGfThjLy4hTbYGrP" +
       "1jodvU+t+5wVV6pOhLSaeKPF8ww37CkEqvldk1htk3Lq9BoVpT1MeSoRmXpt" +
       "sQj9ntum1a6ajGye7izIjdB0ndRNfbxBurzUhMUmSzZ6RqQRfLPD5zLzeFmd" +
       "ln18JfXBVqbR6cXL2dCgrCpOUIvaJhUW+gCgGYQMiQ7Yi/UlqJzJENuI6nND" +
       "XFBOS+6sApirjcuLtImxW5TVa8sKBdftqEpMBb2lhmm70qKlRrM7FtAaZQ05" +
       "WlutFtMuYgaj1iBU0Haz3+OVONxikT/LqO3U6uARFCSRD3LSBU1o02G7zY1F" +
       "1Zh2k1l7KUD80orgHtmukrwxmyzZDjKoVTF1CTaBNE8iYNcRcCmmlDftmpiu" +
       "TZcsZz4TBF57mXl+onVUyJgQGqFqsh5FEidDMrWBiUW4UAXdcfBBv8W3YGZV" +
       "mScS3+RABjV262gmVDbZ0lScERdGZVno9XyCdzDPXs96I0FTBx0WjiJklQn6" +
       "ZCK0ZW6zsdeQuIxURVfkij4Am1A/q2fjreaQApLUui1y3Q+JLlmFZNPxouWk" +
       "Xg64ZNPK6KiGTf24KlvdAJoRGdwcLyJCUDoVFdF5qaZPRwOKtWDgj/2673BD" +
       "DLJjl0dHmcbEKM4ovp55piwrWRysyCXa4WjXZ0Z1ja12+/0tHVnZECL4zbCp" +
       "zdlxUyHJlaPbtB+KNX6U1tWQTIYCDEA3wzUzmeA0MeQb06kV0gnlVObzluG2" +
       "bG/Eb2Okw9hiv0mX0Xmd5qDUgJK1HEEI1QtGMhGSU6Q4rfryGzsmerA4/Tq+" +
       "UPX/cO6VnDq0PT5VLB19/Xnm8P2Zc6eKpz5C7h2dF74nPy+M6+LpY8Jb3UHJ" +
       "D/Qfv929quIw/0ufeOllif6V6v7hCa8blO4JbOcvGXIkG6emvly8Z2cPQyvg" +
       "2RyyvTl/GHqimAtPQi84bf5nF7T9i7z4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("WlB6h2ZpQfEpQEYMg9IiGQExpa3DQPZveXoX2Zp0Yq7feCPfg8+p4L68sgwe" +
       "61AF1htRQVC62/G0SAjk19TDNy5o+2ZefD0oPXqih7NKyNt/80Tgf/UmBH4o" +
       "r3yiIN39JW/U5u9/TVm/dUHbd/LiD4LSfYocULYoGOPDDybIiXx/+Cbkezyv" +
       "fBo8HzuU72M/evn++IK2P8mL/xSULgH5Blb1KNifvEWwn/2mcSL+f34T4j+V" +
       "Vz4Lnk8eiv/JH734f3ZB25/nxX8DcQHEn5/6OPLuC+Q/9UXkRAn//U0o4cm8" +
       "8jnw/PyhEn7+R66EvUsXtF3Oi/xaF1BCcSfDP1LDMxeoYfdBJL8ndayFvf03" +
       "oYWH88r8y/vnD7Xw+TeqhddE973zN4NOtz2SF1eAK1hyPLalY1e4eloHxw2F" +
       "uFffrNE74Pniobhf/NGL+9QFbfloe48DEM89/9xFlOPLJcsTWZ94Q7eYgtKP" +
       "3faSan7d7tGbrsfvrnSLX3n5yuW3v7z4N7tLHUfXru+hSpc3oWGcvuFz6v2S" +
       "48kbrVDHPbv7PsVtir0yEO92XzmD0h2gzDnfe25HfRCU3norakAJytOU1UOv" +
       "OE0ZlO4q/j1N1whK957QAZDdvZwmaYHRAUn+2naOXO4nX+Pmr2YEsnd8SYIJ" +
       "BEsSPOlk/U32TmVRh55XoNRDr2XE4y6nb4fm1xmK//VwdPUg3P2/hxviV18m" +
       "xx/9QfNXdrdTRUPIsnyUy1Tp7t1F2WLQ/PrCk7cd7WisS8SzP3zg1+555igr" +
       "fGDH8EkUnOLtXbe+B4qZTlDc3Mz+8dv/4fv+7svfKj7T/l+D6IlLjjIAAA==");
}
