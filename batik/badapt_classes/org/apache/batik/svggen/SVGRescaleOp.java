package org.apache.batik.svggen;
public class SVGRescaleOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGRescaleOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.RescaleOp)
            return toSVG(
                     (java.awt.image.RescaleOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.RescaleOp rescaleOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              rescaleOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feComponentTransferDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_COMPONENT_TRANSFER_TAG);
            float[] offsets =
              rescaleOp.
              getOffsets(
                null);
            float[] scaleFactors =
              rescaleOp.
              getScaleFactors(
                null);
            if (offsets.
                  length !=
                  scaleFactors.
                    length)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_SCALE_FACTORS_AND_OFFSETS_MISMATCH);
            if (offsets.
                  length !=
                  1 &&
                  offsets.
                    length !=
                  3 &&
                  offsets.
                    length !=
                  4)
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  ERR_ILLEGAL_BUFFERED_IMAGE_RESCALE_OP);
            org.w3c.dom.Element feFuncR =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_R_TAG);
            org.w3c.dom.Element feFuncG =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_G_TAG);
            org.w3c.dom.Element feFuncB =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_FUNC_B_TAG);
            org.w3c.dom.Element feFuncA =
              null;
            java.lang.String type =
              SVG_LINEAR_VALUE;
            if (offsets.
                  length ==
                  1) {
                java.lang.String slope =
                  doubleString(
                    scaleFactors[0]);
                java.lang.String intercept =
                  doubleString(
                    offsets[0]);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TYPE_ATTRIBUTE,
                    type);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_SLOPE_ATTRIBUTE,
                    slope);
                feFuncR.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_INTERCEPT_ATTRIBUTE,
                    intercept);
            }
            else
                if (offsets.
                      length >=
                      3) {
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TYPE_ATTRIBUTE,
                        type);
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_SLOPE_ATTRIBUTE,
                        doubleString(
                          scaleFactors[2]));
                    feFuncR.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[0]));
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[1]));
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_INTERCEPT_ATTRIBUTE,
                        doubleString(
                          offsets[2]));
                    if (offsets.
                          length ==
                          4) {
                        feFuncA =
                          domFactory.
                            createElementNS(
                              SVG_NAMESPACE_URI,
                              SVG_FE_FUNC_A_TAG);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_TYPE_ATTRIBUTE,
                            type);
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_SLOPE_ATTRIBUTE,
                            doubleString(
                              scaleFactors[3]));
                        feFuncA.
                          setAttributeNS(
                            null,
                            SVG_INTERCEPT_ATTRIBUTE,
                            doubleString(
                              offsets[3]));
                    }
                }
            feComponentTransferDef.
              appendChild(
                feFuncR);
            feComponentTransferDef.
              appendChild(
                feFuncG);
            feComponentTransferDef.
              appendChild(
                feFuncB);
            if (feFuncA !=
                  null)
                feComponentTransferDef.
                  appendChild(
                    feFuncA);
            filterDef.
              appendChild(
                feComponentTransferDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_COMPONENT_TRANSFER));
            java.lang.String filterAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            filterDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf,
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                rescaleOp,
                filterDesc);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5c1uD6PiVxtOgUGMlmigaHOlKkVUWMuPX1ySx5/ba9cSHaWZfxgK2+/88h8/" +
       "jV35/TurpJ8Gpht3qWSOqIE1o3zJkvwxKgo4n8M+bLnwhx/254buJHXwvp7b" +
       "JAf+3AtG7KqcCsJbeevxP244fm/+1B1kgd6QO8MqXxh96Z3DO6QLUVGt2gmg" +
       "rMotnTQQdCwsSgmU5Ro3k/c0C9hv8wDQyw+2H66DDgAOrs7Eq2DH47dKU0NR" +
       "HXVO1GGJHgFlPM9iSgHK5NiQleU5Rk7yp3HDFevwxCYB7VChq0RsafoWnPEA" +
       "b77CUA3TgXL+E1oaUVQo9g9BlUMVw30z+RJvJu24OfhfxizvSNjGjJY7/Zjj" +
       "uWN37vRKU0NuCVFzd8jpXl0nVlRu4dMCb2TXp/zhpO8k8r9wUpGhpmCpyfmu" +
       "u+zV1X7dkl5eaq3vWrr/VyLsvVeiJgjgrKWqAfwHY6HWoCSrCHOabPq37bYY" +
       "6qoADsjr9o3YNbPlYadtYXnwjPgPyp1lqNGXA1X2TVDkYYaqQITfPuJh/vOV" +
       "kDqYgUoPOM5DLGRR4Cu4KUbKuV4czfrbHU2A3LeVcJ34uODykmV/XoBSfeno" +
       "2NkbX3zOrr0kFS8uipdReLe2y0CP27ZW1Obqqj2y82bLqw3bow7G2u0N++Df" +
       "GABgAmAsMLEhVJiY/V598sHygTd+dq72fUgvJ1AEM7T2RODV3n6PherGgqRy" +
       "IuWnlcDHKVExDez89sK9e7J/+a1Io8h+jdlUWT4tXX3+wV9c6F6GympNEtVA" +
       "JiTFGdSomIcWNKCtOTqDmhVzuAhbBC0KVpOo3tKUMxZJyinUwuGL+WcH4RfH" +
       "nc1eL6/cGeor+76wyvsOlBzzhA7pliYLtoc85PeUfPVw04NlGKEJfo93lOvK" +
       "bU9Lh77R+qPzHVUjEIIl5gTV15lWxks9wQ8hfi5qs7ntX/CLwPVPfvFD5x38" +
       "H1JAwvkosMX7KgC1jT1WlU6NGoYr2/ixYQfRN3nzdJH3MxTZ5fQGCJE/Xhbr" +
       "XxK3vLnyb39I+PcUFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1J0NbLfSq+Tefv7IwYbuuskpEOFn0F18t5jhEzmVR/P2Wtb82NZMWffNIBUE" +
       "eTUKMFTDFs184XoIXMyUru1T50F1CmxybWni+3FzJXenTPrdbUm3TYJZW8pJ" +
       "bF0Cv637vG0Lle92dx8Sox1QHX7g7z70lV96/BvApl3oTJzpG5jyyIqDKCuY" +
       "f+Gl5x98zXPf/ECe2UBI8+994p/z8mNwJ4mzhsqa9r6oD2SisnlJQItB2M+T" +
       "kSLn0t7RlRnfsEDOjveqQfjpq99YffRbn9pWeif99gSw8v7nfvEHux98budI" +
       "ff34TSXuUZxtjZ0z/do9DfvQo3daJcdo/f1nnv7933z62S1XV49Xi03wMfSp" +
       "P//Pr+y+8M0v3aJkuct0/heGDS+db5eCDrH/o/mZiK4lPhEKEVbCgY4TblxG" +
       "S0ujztD+YtTpT+wuJ1JpPJ8zGME5yBq10igNU9me6ujcpu2lj6CV1tCj4vKk" +
       "M8FYrcXBkikgPQtteQTZ5VciL/YCcrIKmq0BSyTdqmBQRpNvV5oIbmL2Mva5" +
       "kUGayiJKacy27ZiJZLicuma5wnlen7W9ztijg5HQsOiWvpwgmqh3yo5AcwxR" +
       "romKNe/F6XSVFAb4rGCgug2WUi2ANOh7nRHPze0iNW/1E1voUr1hk6VTajyc" +
       "WB1uOBMXDqolol9edjWv6a2CLiXPzbUmmP1JRZP7RZFf9vlO0WwTxeFsgpOj" +
       "SNY7aoOoMm6L5Nx6QMe2jo0a6zE1pNj6tBquKhSKUKuqXugLk9q4xC7b81GX" +
       "MrCZGNHReGJLfGcl8UMPDqRWkgxwNkxHcsH357DCdGtxc1OeGSk/mFc7Vanc" +
       "m0VLt12uj73aNGrzfGedVsj2hJ/0/NGq06+xKtglB+tKNxEGLIK4ColxEpey" +
       "zkqmmkMpnfKUTqvN5mDBlicza9gjHXRO4vVVEWkwbXnZnPsDzBCEcCEIC8OV" +
       "scSoFqQFE0YtwZNHItobBALWqTYtilxviHXJ1EcbvewRQRNbUaEQrtHWsNkz" +
       "db7lohy+JHm7I87rkhpHDo8JwFKzFabyGDmc1SOk25tzKb4JiC6X8t0BL43K" +
       "Aa6Ow5AtSiUV0Wa9PklVBvMGrQPzc0zP9fsTqlbSLXkJp82R1jORukRvIl+e" +
       "hDNRJ7DprNmiEhA8DKGyxXZnKVSIOrEJScpYeWV/XQxSpSOx00FTj0YWTlIj" +
       "USeHpVZ/JuhVoVn2NbMhNjnDXDOh2m4sE4RfRsaYbzZrxppjlSk+XQ85ZdXj" +
       "uitLmBDdZNasBagrVJaNUGUSuUV2uKleGoeWUoNhaV5TMFfA/Lk58EpGv1wq" +
       "cywrmO4spZVayEapNK0K2ESAHTfoMHF1vGkKEy4NdKI4AqKro2I1oGZDXNsU" +
       "5sOYUR2jwPcnA3Y+9kXW57XWGiFxtz4ZjEkO6Q+anaSDddjBuD7gnGXS7XmN" +
       "Qpk1mosQY7oBQk4iQzT5IqL4BsVvJvXxVBrPkLWP6nNsUcT6/YguVHr1JsAj" +
       "02m9xpkruDqCR0hhUIYnpCH0u2LJs5KN4qRREStViRKl1kPGLdWRPkxxMmoQ" +
       "farE2YOk0Vh2mpis0a60FOzEKywbxDToeADIaFMNCi7WkBUfIfKyxBIzOSYd" +
       "BSfd1mbcks1RyLBjIXQK/QVdmcphr90uDeESoTkgQcVzr79oiWmrFLbM9WDM" +
       "do3VlK/yatgscYnVWfTqghui3BIp1QZsOTY8YrVsqQ0JXzl20eyxC13HYRoV" +
       "bNec4VYiYtOaX5qP5YmLdJrm3KL4eSmpW1o/WlmiLFFYb8TQiVQlhREBDDGL" +
       "vaZL1TXDN4mVTMdcud0b1myxhRBaOdIVMqV6BaXNqwrDe3ifSRe1zQAZt0jU" +
       "VBflVYMjBDvF6xvZWZbV8jrqFawQnnaXablWVruNSIdL3and5KY1s4+vBqrQ" +
       "nOkDlDPtebgWC+YUKzhT3KgRM2M+G2mrEr1RqnXHjBu0Ji1ZzB2X+mnkFbXW" +
       "pFBmvNJKEVwmgjGyvUENOESIToAwA7JSon3a4NIkLUp4Qy6j6HRpDYlw3pnS" +
       "xJq1lygPw/CwH5NtBa+IHWQ1VGyyHnQyp0GMdscboG182uqRfb2mUFOjMomn" +
       "drrW+0TAosh8EXQLGCkS1rDZXVeTQWzDtibXFMEvzmt2g+kU+RnFuqgx33Dx" +
       "uIRi/XpXQAvtuL7Rh3UW17yhBU/Xg2rPXLXmCEcShTj25RiL44Xt1tyg3VuO" +
       "StWukxaKfIFBVWrSY2I73ixShOQmnNGTF5jF1qwqPBencF9zp0YdrzAllIkW" +
       "MTwRVH22IWgy8tg1OxJH425tUXZ9Z47aRbpjt0pTUR7KbHOouIWZspAdvAAS" +
       "W+yNqEHMWAXE6lP13iztjhhPMKuIBItzvFDuFBfrgGYLRtRZIq2gMTBG5T46" +
       "7HjLmNQZsSmk1kipKOai2UZDlrcq9aS+HPdG/RjofhLRc1HbzKnIU+PBsgYH" +
       "DMMrrZk3dJpzPoE7nZZDgZ2DMIzuqk0ZJXGK40w9GFcZbhyuzfFkbifzelqY" +
       "YKHAKLiu9dstwkhhpxBW6uWyEgEPBt9KlcFoJqhlCYkaFcbgk3CoTai+aRma" +
       "2B6avRU/EfoRM0U2bFKGF2JNYtuiMFcTrYcW4GpVr8JLHivDXOS73Srl6iHm" +
       "CezQ6zQRB0u7q3id9DSnZFf7hQVtr/UERsulRdRtT9exiy+6hFrAiJDCe55E" +
       "Bt2FosQJg5ZKqgUXkDqy0uTKaFjte9NEr1XmWGNYGdETngpRzdL8vhPa3Ggk" +
       "k+uA1axJeexgK1gqkjU9rq4bo826gLYrlUZDI4Z+gDc9tNEu4XJvUhyM21N+" +
       "iFBUt621TKZfM1it3SsD+5gKILPCNy7WbrQUwDw5q+M8qXvFcSCqjmAzTWKB" +
       "4+SEwDhtSheAlOKEHzk1rVY3J31+jRXTwrgbdyO0NFR1NTHSmB0sqWV3hsPz" +
       "5TISBhgejzMeIpJvpXJ16U7Nos2b46gk98kFyk1dONXdYXVV9WvriUvprkW6" +
       "G9WKokLKI1NcXpllRfSwWPB9mN/QQcwrRldban5P8Ah13Z5V2oJDsj7ZHooL" +
       "xsPwxWxW8RyiESz9moPNBgvGnIlyOJva6yWjMRsXMb0BNSWQKcrxjdVsJnqj" +
       "DqcyUVeH4yG/angzbeIww365QVPjcYmMSr3JohfxJSlV/UV7ghIYrfBSFytF" +
       "w8ZmZfHw1KmzqmI76GC1mGLp0PeLqxZbjUARMVZoBd0USQbF5wIyXHjeEt1U" +
       "0QXtrbGFs8YpNCoOCoWGShF1jbCIoE83db5rzGC+XKsG7Y3GyQXZw1F1osVd" +
       "hGj2cQ4dDxs8ZlcYXfEpzRtvOpFgm1Kj3eObSUNJq7WgV1PwLlwQkY4Dqq+l" +
       "bE4ErhROQQJd8zWp0qpQG8sdNEOe6Bpci5JZx+pIwqBHhkPOa1g6n0aEvqiT" +
       "xR7vDh0s7E36yby7MezJOqLogiC1S2O1bUuIQldgiVIcv4BX1ps4GJr1NNUJ" +
       "3DWNGR06UrXMKBOV4dfF0sCkes2u6tQwcxj3FpMareP4uOAxaZufLJudjlnW" +
       "OB4pm0KyCmrrUVVXjbIX4HY4hUl6zfCMGrca5QSrtpEusY5XTtCf4j2NRJYc" +
       "IpiTyoByZj4KG8lspI4HmJ3K3TbWT7h5WR1RZLcJT/WFP016WEzbmwVW6xQY" +
       "adIaEUT2SXDj1X2V3ZN/gB5cMICPsWyi+yq+RrZTj2bNEwcHXfnv7MlD6aMH" +
       "XYcnGVD2hfXg7e4N8q+rjz/z3Ivy8BPIzt4J0DyELoSO+1ZTiRXzCKkdQOmp" +
       "239J9vNrk8OTiS88848PcO/Q3/0qzmgfPsHnSZK/1X/pS9SbpA/vQKcPzilu" +
       "utA5jnT9+OnERV8JI9/mjp1RPHig2YczjV0Dz9v3NPv2W5+T3tILTuVesLX9" +
       "iQO2nT0F7h08PJQfA4jrcNewRE3ZrUdqdtwrd7K3obsPdvUAbKxIQBrNVHLq" +
       "0R2O796TNeCz90zosDz1PzkhbBlmqPgNJZB8w92/ccsd0/thn8lHF88HrJs1" +
       "2dvTZO//RpMnjj7vP6HJg0uIHPnZOyjqA1nzzL6ispenDyX/uVcjeRJCl47e" +
       "f2SHufffdJ+6vQOUPv3i5fP3vTj5i/wK4OCe7gINnVcj0zx6jnakf9b1FdXI" +
       "2b6wPVXbyvfhELrvNpbNDsXyTs7uL2/hnw+hKyfhgQby/6NwL4TQxUM4QGrb" +
       "OQry6yF0GoBk3Y8eOCx6OzcjFkHoi1J44G6kY8eKDzrJqePJ6sAEV3+YCY7k" +
       "t8ePZaX8xns/g0TbO+8b0mde7A7e80rlE9s7DMkU0zSjcp6Gzm2vUw6y0KO3" +
       "pbZP62z7ye/f/dkLT+xnzLu3DB969BHeHr71hUHTcsP8iD/9vft+522/8eLX" +
       "8xPA/wZ2ZY7miiAAAA==");
}
