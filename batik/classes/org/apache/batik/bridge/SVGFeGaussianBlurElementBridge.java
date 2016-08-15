package org.apache.batik.bridge;
public class SVGFeGaussianBlurElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeGaussianBlurElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_GAUSSIAN_BLUR_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float[] stdDeviationXY =
          convertStdDeviation(
            filterElement,
            ctx);
        if (stdDeviationXY[0] <
              0 ||
              stdDeviationXY[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              java.lang.String.
                valueOf(
                  stdDeviationXY[0]) +
              stdDeviationXY[1] });
        }
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter blur =
          new org.apache.batik.ext.awt.image.renderable.GaussianBlurRable8Bit(
          pad,
          stdDeviationXY[0],
          stdDeviationXY[1]);
        handleColorInterpolationFilters(
          blur,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          blur,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[] convertStdDeviation(org.w3c.dom.Element filterElement,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_STD_DEVIATION_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0,
            0 };
        }
        float[] stdDevs =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            stdDevs[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                stdDevs[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                stdDevs[1] =
                  stdDevs[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s });
        }
        return stdDevs;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC2wcxRken+NH/LbzJCRO4jhESeAuEJ41L8eJHcPFucbB" +
       "VS8hznpv7rzx3u5md86+mIYE1IqUioimBtKKWJUaCKWBIFTUUgp1i3iJhxRI" +
       "CxTxaEEtNCCIELQqben/z+zePu6BaIGTdm5v5p9/5v/nm+//Z+7oe6TCMkkr" +
       "1ViY7TKoFV6nsZhkWjTRpUqWtRnqBuXbyqUPt73dd1GIVMZJw7BkbZAli3Yr" +
       "VE1YcbJA0SwmaTK1+ihNYI+YSS1qjkpM0bU4maVYvWlDVWSFbdATFAUGJDNK" +
       "miXGTGUow2ivrYCRBVGYSYTPJNIZbO6IkjpZN3a54nM94l2eFpRMu2NZjDRF" +
       "d0ijUiTDFDUSVSzWkTXJSkNXd6VUnYVploV3qOfZLrgiel6eC9rua/z4k5uH" +
       "m7gLZkiapjNunrWJWro6ShNR0ujWrlNp2tpJriXlUVLrEWakPeoMGoFBIzCo" +
       "Y60rBbOvp1om3aVzc5ijqdKQcUKMLPYrMSRTSttqYnzOoKGa2bbzzmDtopy1" +
       "wso8E29ZGZm4bVvT/eWkMU4aFa0fpyPDJBgMEgeH0vQQNa3ORIIm4qRZg8Xu" +
       "p6Yiqcq4vdItlpLSJJaB5XfcgpUZg5p8TNdXsI5gm5mRmW7mzEtyQNm/KpKq" +
       "lAJbZ7u2Cgu7sR4MrFFgYmZSAtzZXaaNKFqCkYXBHjkb268EAehalaZsWM8N" +
       "NU2ToIK0CIiokpaK9AP0tBSIVugAQJOReUWVoq8NSR6RUnQQERmQi4kmkJrO" +
       "HYFdGJkVFOOaYJXmBVbJsz7v9V28/xptvRYiZTDnBJVVnH8tdGoNdNpEk9Sk" +
       "sA9Ex7oV0Vul2Q/vCxECwrMCwkLmF986dfmZrVNPCpnTC8hsHNpBZTYoHx5q" +
       "OD6/a/lF5TiNakO3FFx8n+V8l8Xslo6sAQwzO6cRG8NO49Smx7+59256MkRq" +
       "ekmlrKuZNOCoWdbThqJSs4dq1JQYTfSS6VRLdPH2XlIF71FFo6J2YzJpUdZL" +
       "pqm8qlLnv8FFSVCBLqqBd0VL6s67IbFh/p41CCFV8JA6eJYR8eHfjCiRYT1N" +
       "I5IsaYqmR2KmjvZbEWCcIfDtcGQIUD8SsfSMCRCM6GYqIgEOhqndMGQqiRSN" +
       "9A/0dNMeKWNZiqStUTMmcgPoWMObwwg546scLIuWzxgrK4NFmR+kBBV203pd" +
       "TVBzUJ7IrFl36t7BpwXccIvYPmPkfBg/LMYP8/HDYvxw6fFJWRkfdibOQ+AA" +
       "VnEE+AAIuW55/9VXbN/XVg4ANMamwRKgaJsvMHW5pOEw/aB8rKV+fPFrZz8a" +
       "ItOipEWSWUZSMc50milgMHnE3uR1QxCy3MixyBM5MOSZukwTQFzFIoitpVof" +
       "pSbWMzLTo8GJa7iDI8WjSsH5k6mDY9cN7FkVIiF/sMAhK4DnsHsMKT5H5e1B" +
       "kiikt/GGtz8+dutu3aULX/RxgmZeT7ShLQiMoHsG5RWLpAcGH97dzt0+Heic" +
       "SbD9gClbg2P42KjDYXa0pRoMTupmWlKxyfFxDRs29TG3hiO2mb/PBFjU4vZc" +
       "Dk/Y3q/8G1tnG1jOEQhHnAWs4JHjkn7j0EvPvbOau9sJMo2e7KCfsg4PsaGy" +
       "Fk5hzS5sN5uUgtyrB2M/uOW9G7ZwzILEkkIDtmPZBYQGSwhu/s6TO19+/bXD" +
       "J0IuzhlE9swQJEjZnJFYT2pKGAmjneHOB4hRBb5A1LRfpQE+laQiDakUN9a/" +
       "Gpee/cC7+5sEDlSocWB05mcrcOtPW0P2Pr3t761cTZmMgdn1mSsm2H6Gq7nT" +
       "NKVdOI/sdc8v+OET0iGIG8DVljJOOf0S7gPCF+08bv8qXp4baLsAi6WWF/z+" +
       "/eVJoAblm098UD/wwSOn+Gz9GZh3rTdIRoeAFxZnZEH9nCA5rZesYZA7d6pv" +
       "a5M69QlojINGGWjY2mgCU2Z9yLClK6r++NtHZ28/Xk5C3aRG1aVEt8Q3GZkO" +
       "6KbWMJBs1rjscrG4Y9VQNHFTSZ7xeRXo4IWFl25d2mDc2eO/nPPzi49MvsZR" +
       "Zggdp3sVLsNiZQ5v/FMZDIJevPk0mGRBsTyF51iHr5+YTGy842yRTbT4Y/86" +
       "SG3v+cO/nwkffOOpAsFlOtONs1Q6SlXPmOU4pC8WbOApnMtHrzYcePPB9tSa" +
       "zxMGsK71M4gefy8EI1YUp/XgVJ64/m/zNl86vP1zMPrCgDuDKn+64ehTPWfI" +
       "B0I8XxVknpfn+jt1eB0Lg5oUEnMNzcSaeg77JTkAtODCtsKz2gbA6sKsWgA7" +
       "Oa4q1rXErt5com0Ai42M1KUgm9NlSe0Da7jkXDjP8Q2AuXpY5Oq84UIsYgLh" +
       "Hf/j7sKKToPXX5nvnl7bxt7P755iXQMuqOITqXIMXVos1xI5lX08c6RnoPTY" +
       "ajmc0NNhO/nCpqQjsDhPXWqUhXtMyRhWZKsPAO9IrsqTROBLYyyspOFAE4aQ" +
       "DuyHQSLcrahwSHI6nsaXBgVTFGaxCcgJlkml56z1b2Lcnf2ZIYttksY4fQzK" +
       "W5c1zW6/6MM2wRutBWQ956H9D/0qHl/WJAvhtkKK/eegu45Uy6+kH39LdDit" +
       "QAchN+uuyE0DL+54hu/faiSM3K7xkAUQiyc/acqtdwMubzM8b9jrzb8Z2fp/" +
       "pvjQDQ75ShqwHtmspGnCXl7nCPGl6ueR0ce/7qL9bETtfP/COy8Rbl1chCdd" +
       "+Qe//sbxQ+PHjgruR/cysrLYtUj+XQzmp0tL5NguQD7q+drUO28OXB2yCaUB" +
       "Cyvr4LTejaEQsbHymtwmLMudQGb6YSI0r/1u469vbinvhmDTS6ozmrIzQ3sT" +
       "fsKtsjJDHty4p3+Xfm3QfAqfMnj+gw+CBSsEaFq67JPwotxRGMI5tjNStgJe" +
       "uR65BIt+G4ttwKKySaG72KpYt8NlzMEvgTEXYNsqeG6yt8FNJRiTlyuwOIsr" +
       "DUEaYJg6AwDTBKTHFr+KCqTHM0soDzgkJLRyJsQiwQc/UMJtE1jcCIQKJxvI" +
       "BFg/S6ylo4qI44WpiWe6Ah9bax//jfWTv9zvIM/IzXwejrCQ5N02fOOL2L2Q" +
       "CupmJ7zxaTrE8GWpRk4osRE97pi8c8lzeyaX/InnztWKBXkWsGeB2y5Pnw+O" +
       "vn7y+foF9/J8jrOEvZH814T5t4C+yz3u/UYsDmatwkEiZgLnMWXU3trnxLbL" +
       "+9pjbzlLtxOLvdh5eYnrYr+OyO6W10duf/seO4zlHaZ9wnTfxI2fhvdPCDoU" +
       "V5hL8m4RvX3ENaZgkNzsFpcahffo/uux3Q/dtfsGx7IehudfXWJB1sOfe7IF" +
       "uHC+LwLw+383Rb37hQt+f+T7t44Jo0s4K9Bv7j83qkPX//kfeUc1ni0X8F+g" +
       "fzxy9PZ5XZee5P3diwjs3Z7Nv+MC7Ll9z7k7/VGorfKxEKmKkybZvm8fkNQM" +
       "Hu/jgC7LuYSPknpfu/++WFyOduRy8/nBBfQMG7wC8QaNacwXIJoFcssIZ7Vj" +
       "RcgSX8O4mIomqbzfXuBMlWopNsyFf2yjBL8OM1KuiKTwkJENMmQuj3TT6y5V" +
       "1yimeU6buL5T9HDu9h8a8+HCw4GYPx/Mkxvz6ZQg36kSbb/D4mGwVsZ5CTNK" +
       "iD9WLFx5Ils+7HlU/N4XERWzjLSWvhXF4/zcvP9mxP8J8r2TjdVzJq96UbCg" +
       "c+dfB2lpMqOqXuB43isNkyYVbn6dgJHBv55jZE6R0wTgRbxwO54V8sfhmBWU" +
       "B8fzb6/cCUZqXDlQJV68Ii8C6kAEX18yHCBdVuxo0wm0bMIRHh3H85Ucmfk8" +
       "ly3Lv9fgKzfrs1bOc5GxxEdU/K80J0JkYnbGemzyir5rTp1/h7gzlFVpfBy1" +
       "1EKwEdeXuXP84qLaHF2V65d/0nDf9KUOCzeLCbvJ0Oke9HYCLA0EyLzAhZrV" +
       "nrtXe/nwxY88u6/yeeC/LaRMgr27JZ+YskYGzl5bovnJLBATv+nrWP6jXZee" +
       "mXz/FX5llE/4QflB+cSRq184MPdwa4jU9pIKCDA0yxlz7S4NznyjZpzUK9a6" +
       "LEwRtABR+DLlBsSyhAd37hfbnfW5WrxxZqQtPw7m39PXqPoYNdfoGS1hpwi1" +
       "bo3vPz57f9RkDCPQwa3x5A3XCtoUCVr5YHSDYTiZecWEwTf4nsIkguVJ/orF" +
       "u/8FfQplamYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b9FGaLdUUskyL1Vge1pM5ojRLOYohDJMayvkWX8+7SLouDuAGuuxD82p3maZ" +
       "eZMJZFlODiOzPVr3xu0ubQ7cbNozlmw9z/fDxoCuIzCYobbmikx70tl5vdnU" +
       "3RuQZqwzc8vkesFgeneVFDqmtuwYijer6WDaQcTlejvOgjQehfjC74Q4P/LR" +
       "3BIahgV11nRXH0qZzUM4t8cE3W8aS9w061MLglJ9N63z45WT5AJk7NOEVrLZ" +
       "qr6YFkHcyGiEdfLpoLOum8mMa2Hcot/a49qsj+83CUxL1kobTlN9vA+ybUAz" +
       "uTkd6agiko0EauYw2t3obrhZBgNJRKMiSMhi2k4lO51k6YoajLM9HLfrCzto" +
       "T+3e2mbCVd3Z1vG+mA41Yo12KH4bZTthxJBItmLFzKGsXECRPpnVR3CWbSeT" +
       "vaiNOq1JrGQY6xfMcONIw4XCpmtrhO4zjGApwZX8fb7lyDQZzIYgz3DQ3nYg" +
       "9SfSmEjqE3wtjZlGGg0Kx6NoYU+lU3c7NaAZQ2XD5srAyemE2m3IPuFAIrr3" +
       "I3hNwvA8ducW2lt2dW0HQSt7Lm26xYZkILJYbK1Vgk8RttECc5Vu0a0pDvCf" +
       "6hQ7TUqG2GgeCx4cpcKw24ldzMD8wtprC4gMwyKbT/oLb56OLGBlhA+3dW4T" +
       "dvZ1OyK6EIWtEm64UcdYE5aQDMbr+6KdQzMlHQRatvWGrurQITNfzNpZEu5o" +
       "na5345Ve+HS24+iNuUQsJUyUpM7tOXTebJi5DaUWBxf+WFO721Cyd2TLXm5M" +
       "Hh9EMxlZ0lgAC5tFe8hqquOxRUrEhra07QjK8117CpmZnY52HdJa5qa9mFP9" +
       "ZsrZVock8jFep7f0tt7G2oLe7iynWd2uS50MhqmokcKTbn/TWWHttccvIMiz" +
       "rZnRDN3GAiPqjl3s9l1eRRaqZSF823S3q7StdthNncE7tN8tOl4HkkdRYk92" +
       "w0kw8fa6ugkw22OnzDiHVg6gyhWRL0Erh+r1ObHnzFzYY1DY79tTZtTZ4thU" +
       "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");
}
