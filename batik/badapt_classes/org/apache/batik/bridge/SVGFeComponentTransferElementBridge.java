package org.apache.batik.bridge;
public class SVGFeComponentTransferElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeComponentTransferElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COMPONENT_TRANSFER_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
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
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcR =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcG =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcB =
          null;
        org.apache.batik.ext.awt.image.ComponentTransferFunction funcA =
          null;
        for (org.w3c.dom.Node n =
               filterElement.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            org.apache.batik.bridge.Bridge bridge =
              ctx.
              getBridge(
                e);
            if (bridge ==
                  null ||
                  !(bridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)) {
                continue;
            }
            org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge funcBridge =
              (org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge)
                bridge;
            org.apache.batik.ext.awt.image.ComponentTransferFunction func =
              funcBridge.
              createComponentTransferFunction(
                filterElement,
                e);
            if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncRElementBridge) {
                funcR =
                  func;
            }
            else
                if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncGElementBridge) {
                    funcG =
                      func;
                }
                else
                    if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncBElementBridge) {
                        funcB =
                          func;
                    }
                    else
                        if (funcBridge instanceof org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncAElementBridge) {
                            funcA =
                              func;
                        }
        }
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.ComponentTransferRable8Bit(
          in,
          funcA,
          funcR,
          funcG,
          funcB);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    public static class SVGFeFuncAElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncAElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_A_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "hwRiThosOUSSVbcCG5OW2JbX6VRZqBtfLqMzaaO3FGOt2FK1Ys9ZK1bH1elQ" +
           "kjE1JKqpVmPN2rTcTRc0w3elDbrU6ri+HI1nRktXKL62FtHmrL1YdTxesqhm" +
           "V/F6dL8T6MSI6etrdKikTbVoDMKhEoUNboUMi8y6VDBxYYa1Rl7XDiyrr3Yq" +
           "lDUnS2NyrNWn4Thwgobmr21MZ4J0Qnqu6oqO7KxHKFKkuXVzOcBm3dqmvmLi" +
           "admz+t3akKKMdDMRnTCInWqxbfn6ymz0XbkctRQurimrKtML2jzJib4/Xo78" +
           "MoPhwbDMI0qPj3296DSLEbwR07Q7RnvaiDMS1zd8pD7VJJ2mm4Fj13ixEASG" +
           "QsZInSL7gwqGkhKbzFW/S5kbrt0ZNw12ojMqsUDtEhHqaWR5HcbqkQ6nUv5M" +
           "am9ghRFL1apPFnu+JdZ5kHoGTguuTepBF+8F1lIZrVWC99pYTBS8ltrVObrC" +
           "UoTAuxQnNKo1JClyM88swAs1xQV0Lpfmrix0So4XMHJUKCeTWWIa8khfdEm3" +
           "EiiNlF2nQ7k/CcJFjyUtsiOjtsVZanWlK0GrWFziDXPcqvD2eJQiUhgs6HVT" +
           "4C2lptani05a3czH7qBTdDvdRrfbmk3CESbqCavJ8743GOGutjKno4Ws0QuZ" +
           "GiZVmuZ7dZJzF6SODLmKXsHFoUMmjNYR7akmLMSJECVUoSeYXnPOTJ2yLUlB" +
           "r6+3kDIrBT6MKtSM8Op4KWY4XqwNu4yE612p07QnS7VPC+w07a7pkPXaxljV" +
           "vLldXfsTsuVgDU/TuwvHFluE2C40bNsg2ZFencCwJkoFt9EQgb5Luq2QU02u" +
           "LBftMAo7G8oa4mqz16zWnKJHSI1SQtd6JQ+pkFTqUFZ73GvzlG/DU8QpTIfC" +
           "gkWZ6UpGwFDb66uWbVcqItfwiMaIiNGk2I9rcK0r0ck8bA8wftayWDpsITKs" +
           "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");
    }
    public static class SVGFeFuncRElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncRElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_R_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZfazjWHX3vNmZnR2WndkBdrdb9nug3TV6Tpw4TjoUNnYS" +
           "x7ETO7GdrxYGf8eJv+KvOKELy0rAtkgUtQulEuxfoLZogVVV1IqKaquqBQSq" +
           "RIX6JRVQVam0FIn9o7Qqbem1897Le29mliKqRorj3HvOuefcc87vHh+/8F3o" +
           "XBhAsO/Za9P2on09jfbnNrYfrX093O+wGC8Hoa6RthyGIhi7rj764qXv/+BD" +
           "s8t70Pkp9BrZdb1IjizPDQd66NmJrrHQpd1o09adMIIus3M5kZE4smyEtcLo" +
           "Ggu96hhrBF1lD1VAgAoIUAHJVUDqOyrA9GrdjR0y45DdKFxC74LOsNB5X83U" +
           "i6BHTgrx5UB2DsTwuQVAwoXs/xAYlTOnAfTwke1bm28w+MMw8txvvP3y756F" +
           "Lk2hS5YrZOqoQIkILDKF7nR0R9GDsK5pujaF7nZ1XRP0wJJta5PrPYWuhJbp" +
           "ylEc6EeblA3Gvh7ka+527k41sy2I1cgLjswzLN3WDv+dM2zZBLbes7N1a2Er" +
           "GwcGXrSAYoEhq/ohy20Ly9Ui6KHTHEc2XmUAAWC93dGjmXe01G2uDAagK1vf" +
           "2bJrIkIUWK4JSM95MVglgu6/pdBsr31ZXcimfj2C7jtNx2+nANUd+UZkLBH0" +
           "utNkuSTgpftPeemYf77be/MH3+m23b1cZ01X7Uz/C4DpwVNMA93QA91V9S3j" +
           "nU+wH5Hv+cKzexAEiF93inhL8/u/9PKTb3rwpS9taX76JjScMtfV6Lr6CeWu" +
           "r72efLx2NlPjgu+FVub8E5bn4c8fzFxLfZB59xxJzCb3DydfGvzZ5OlP6d/Z" +
           "gy7S0HnVs2MHxNHdquf4lq0HlO7qgRzpGg3dobsamc/T0O3gnrVcfTvKGUao" +
           "RzR0m50Pnffy/2CLDCAi26Lbwb3lGt7hvS9Hs/w+9SEIugK+0L3g+yK0/eS/" +
           "EeQiM8/REVmVXcv1ED7wMvtDRHcjBeztDFFA1C+Q0IsDEIKIF5iIDOJgph9M" +
           "KIGlmToiDKmWTgJ7PBdwioHshsA5GVyAv0ROs5/Fnf//vmKa7cHl1ZkzwD2v" +
           "Pw0ONsirtmdrenBdfS4mmi9/5vpX9o6S5WD3IkgASuxvldjPldjfKrH/v1Di" +
           "ak7Til11cGIcOnMm1+m1mZLbcAHOXgDYAIB65+PC2zrvePbRsyBO/dVtwFMZ" +
           "KXJrXCd3QEPncKqCaIde+ujqPcN3F/agvZMAnRkGhi5m7HwGq0fwefV0Yt5M" +
           "7qX3f/v7n/3IU94uRU8g/gFy3MiZZf6jp10QeKquASzdiX/iYflz17/w1NU9" +
           "6DYAJwBCIxmEPECnB0+vcQIBrh2iaWbLOWCw4QWObGdThxB4MZoF3mo3ksfG" +
           "Xfn93WCPL2Up8Ubw/dxBjuS/2exr/Oz62m0sZU47ZUWO1j8v+B//6z//p1K+" +
           "3YfAfunYUSno0bVjYJIJu5TDxt27GBADXQd0f/dR/tc//N33/0IeAIDisZst" +
           "eDW7ZtEHXAi2+b1fWv7NN7/xia/v7YImAqdprNiWmh4ZeSGz6a5XMBKs9sad" +
           "PgCMbJCeWdRclVzH0yzDkhVbz6L0Py+9ofi5f/ng5W0c2GDkMIze9KMF7MZ/" +
           "ioCe/srb/+3BXMwZNTsMd3u2I9si7Gt2kutBIK8zPdL3/MUDv/lF+eMAqwE+" +
           "htZGzyEPyvcAyp2G5PY/kV/3T80Vs8tD4fHgP5lfx4qW6+qHvv69Vw+/90cv" +
           "59qerHqO+7or+9e24ZVdHk6B+HtPZ3pbDmeArvxS7xcv2y/9AEicAokqQL2Q" +
           "CwAmpSci44D63O1/+8d/cs87vnYW2mtBF21P1lpynmTQHSC69XAG4Cz13/rk" +
           "1rmrzN2Xc1OhG4zfBsV9+b+zQMHHb40vraxo2aXoff/B2cozf//vN2xCjiw3" +
           "OatP8U+RFz52P/mW7+T8uxTPuB9Mb8RpUODteNFPOf+69+j5P92Dbp9Cl9WD" +
           "6nEo23GWOFNQMYWHJSWoME/Mn6x+tkf9tSMIe/1peDm27Glw2Z0P4D6jzu4v" +
           "HseTH4LPGfD97+ybbXc2sD1zr5AHB//DRye/76dnQLaeQ/fx/ULG/9ZcyiP5" +
           "9Wp2+Zmtm7LbnwVpHeZlK+AwLFe284WfjECI2erVQ+lDUMYCn1yd23gu5nWg" +
           "cM/DKbN+f1v7bQEtu6K5iG1IYLcMn5/bUuUn1107YawHysgP/MOHvvqrj30T" +
           "+LQDnUuy/QauPLZiL84q6/e98OEHXvXctz6QoxSAqOHTb/jO05lU9pUszi7N" +
           "7NI6NPX+zFQhLxJYOYy6ObDoWm7tK4YyH1gOwN/koGxEnrryzcXHvv3pbUl4" +
           "Om5PEevPPvcrP9z/4HN7xwrxx26ohY/zbIvxXOlXH+xwAD3ySqvkHK1//OxT" +
           "f/jbT71/q9WVk2VlEzw1ffov/+ur+x/91pdvUq3cZns/gWOjV73YLod0/fDD" +
           "FicyulKH6QiOS3hTc9YJLgxQgaJddbo2OYoqNfvFviJYxbEYpbE7VTl8XPc0" +
           "V3UVB+eQdrihRGceFFFG7g+GKmMwpu9T62CYFNOh16hYljcTCurSazrFYZ9a" +
           "dkyalhf8TGzPqN6iu+SrjcDdhBsOZ1Ylb0KuIpbbYBiG464NY8UVomElaSQo" +
           "/mQAaFejxshozeZSrV9A2fWi6UWV9bxfiBixZ/STdFOdJOuIqTgaLWOYPEmZ" +
           "IkrPyWHPkWkNZaYutRTUlTwtbKj2oOuEmIkNcMeSN72FiTK9lpkOF4M+7Idh" +
           "l5Jl3xHYyG73xLVmqXPFIznO5kxh0vEk26LZtSp2Wo4gqiODl3t1Q56t6v66" +
           "law3bBOXJcvw283SZNxqiow6ttZyp1ObWZXYJ0RtgLmDQRlZ6lhpPK6XIwUh" +
           "CQUdT1JE4zu1pLnGJoPNsIdV6aqMdabxPGhjhNCBtcHMHoxCCRYCn5y2iqY8" +
           "4XSb1SeqU+7Vm23On1ZKHFGzit1wFTXiOdnWMXbZ6C+GZWeAxwOy4QSiafmL" +
           "PudxTSLGZYCZjUiLmOLcHw39eRnu4M1U0PkIL0p9lN50mKknVSyOaPorjupT" +
           "7a7HUKOpXMfZLka4QrCgVj5m+VJrONVIXpsIC2w+ppVVDGPExEFXUpr6cTWw" +
           "SH4yjTyhWEUFfegMJK6SxMuUUVEi8FE4mMBNuhC26x1Tkrp4V6qGuCbN40Bu" +
           "0O6o2sWFuYKW+mo3bA97pkFVx/Plcrjs1WmiyFnLmbRejxyaHxXabGNUmZL1" +
           "jqUrS9NvjdNIcpYSZodyt8G3elwzqRcFUzWHYRkdEE4To03Bj0ipHzQxJCib" +
           "4IgumJgvDWjCHQFWeY6MornUrHmFtcJ2p616exMqDhL1xYjnh2qxRZptu2H1" +
           "3BmsYWMlWm8i1LDFieZW1151sKFdRxXFgss4tWkh6uNJslw0i5S5AfY1ytOp" +
           "zDJ+tBpinVY9JZ1w3R+0YF4vh8FijmMFeJ6E82Jb6DWDZWeIFkmMaOPTjt4l" +
           "hKHT16fpYsM4YspQ/sJplN2ipNBUyeaYdLZZLkab0cRdS0VmSQ4ZmC3BpMXS" +
           "s3prMybiSgc8GiGa11glJS+kaLnf4Jd9lvf1TnWtw5zWFHSlVG/aguUsWd/q" +
           "2+IAlD8ESXCEu1ZEtG9WUFW0nYqyoOlOSV3ZDDcg3GDBUkNuoK5XaW9cXM3q" +
           "KMErHsWVYXnIdk2ubvar7V6/2u2neHmDwGW7VetSFVgym6ugazfq5WWxJ83G" +
           "09HUmU5i1OMbvSJGJ3Bh0Z7JbGVT5PwF2YmZXnNMmgMNE2gkjZha3dGbw1js" +
           "hInXIegBtyy2O9NiwRw1+LqzqitzI3HdYFWl7U0ijvp+dVplpT4zGicsHOn9" +
           "+bqo9wszli3JBZaqIFGMFBnG7i365aU6jZcoXaY2xKruimIwWbQ2xHyplFAS" +
           "JQZeV1tMRRszu3BLjgrKTKCSPja1GG2BSAQ5xPFVocMPqSq8hH1+aOE9fsPW" +
           "IjG2Oq1Al5AGzXlEo9SoEK5MNuF2cca27J4Sb0IihWtwV2zEXnU5lUpMpVIY" +
           "cjUAym5jNOuhop0sSwUh8YcpEjdRLCF6ottiPKnOSq7RnExlclQjPBLt0Q1i" +
           "pBVCiRiNeaJaqiprf4OE0kLFo7JbqPlNqbssmWODqZSnAgqrylhcUfp4gVQm" +
           "03UzGNA8hnTEtEbWEDiJeLKk4YlgjiiScahmlarW4ZbWtxYyYoi15bxD8WTN" +
           "QF3LKdcMvhR1MTJd4a15tGpg1UnYqpPddg/ENlYJSsa4FcNUMt643W59Qmnm" +
           "3FqO5lRad4p+MhEENQqTMYEQIiGJRMDZeJ/mq0OWZjay2SXhKAmnJTxINn4o" +
           "TtwGSGydcgo1ZEIavOcSoetHZQSJJJ22pPkkKaEGPEo5qTh3hbS8EpVlXZ/1" +
           "DV0x8BGK9P0KVaszA2Vt0SLTRJuNskmjLjZD0pKljzQPV/gySi1aCxyuJmZn" +
           "M7S9ioGMG3a84Md4OIvIglGkmbS97FGFxSIxuNXSTKy42zA1z56ApMJUyqit" +
           "HdxfN9ciZzb7HbPnVSYm022F4XoFj+IRwgVtHNd1ndGoGa3REroUY2nAeMtu" +
           "r9lBu+uQJ1urQuKSfLOWYo22rnQ7Q4lq1Yh+XUvGYrGwAuckiapJEm2KpT7P" +
           "s3ZBHI0m5e580ibGmMDzSVoVbGIOd4J2ix00I27mln1LKsXleX8qhtK6LCjL" +
           "QBR9S7BDWC21OnzCdnlH1SuCZbS96Yxr4zBWQhDV2AhKrSb7gjuMMW5prBuo" +
           "xVXW7XnT6Szqhl/DksQgcRwxwII1Ti8Q8gYtyHUe18mZUhiWDTwk/cTl3Ya/" +
           "7JWwQq3aYESDSjr2iBNKKagFKnA9rkgdac6G3Lqld9f6SFksqGS1bDombuv9" +
           "DTcoWCwzkVQf9guT4hAvJ1yHQrDxsDBUFq0Gjg6pziSS0dKSV/xRJa01B0hJ" +
           "rTGqibb6dsWsNKIJvfGKq/ZAaJlyDy4RbjFVWbfaaPtYW1zzlVWlU19NBlKl" +
           "svRWJdcMOgjaKZiuqI/alKZWymbBjNhwIsd+X4NBBGFas+jN/E0XXXoySS1W" +
           "CT+i1grDVFvxxiwJFEyzwbClDnm5zXUDjFiEnFGv6RQsOn6zViMSn1N7vF2l" +
           "uz5GKrTEMQui5W6GjW7NXyCwqCtcd0ynEjiAAaqjJaHcrztcwWPQWkobGlMY" +
           "yzHWIAl2VtANeE5NMSwdmMvy2qrGlhmqpaauVeSptIniQEh6i+IAkQ2FL6ox" +
           "zy07SYhPcNLwW1HDFsl6nTRNvWhKlbkxclE7ShK96rXHhsvEiI3WC2h30Z/b" +
           "U22drtpjJTZAMihqYzBZLwyhzyMFgmr022xJWkUlvFqCYU23PHxOA8dWjOKy" +
           "AsfrBo/HK3WwoGbBaO7XK303HbplCktKSmyKYsff+KsZO/GK43p/2J/4ZHHY" +
           "FiZUwjDTuLe2XMGK7V44rrTGxbQU+YLHdYh1wY7STrFmz2kj5qpIt6+VRtN6" +
           "a1VnC7CvrxBiULZQbzJAY0IUli11jNr4KAhKFN40XA72qElTYMWuy7QrvelI" +
           "Y2QiqWLlJp+gBW6WlEXEYlcw8HeXm9ErqsZxnqJaiIAWFgUZDdabod/j5gOH" +
           "SotxSWnMWtrMM6Zln8bWooAXabB6h2OqI2NeDjbJGtOr4zY6xlbtXn1Kt0CJ" +
           "npXub/vxnp7uzh8Uj94YgIembKL9Yzw1pDdfcG+34K7nlLcb7j7dfD7ec9o1" +
           "IqDsAemBW70fyB+OPvHMc89r3CeLewcNnDF4Hj54bbOTkz2hPnHrp8Bu/m5k" +
           "11X44jP/fL/4ltk7foxe6UOnlDwt8ne6L3yZeqP6a3vQ2aMeww1vbU4yXTvZ" +
           "WbgY6CDtXPFEf+GBo229J9uuR8H38wfb+vmb9ytv6qgzuaO28fAKzbHoFeaS" +
           "7OJF0J2mHrGeKtu9A9XbuxDyf9SD54mGVATde4t2+WEH49pP0IoHEXHfDa8H" +
           "t6+01M88f+nCvc9Lf5U3nY9eO93BQheM2LaPd3uO3Z/3A92w8r24Y9v78fOf" +
           "dwM7bqEnCFVlZ9C7tvTPRNDl0/QRdC7/PU733gi6uKMDorY3x0mejaCzgCS7" +
           "/WX/cNMG/yfvL04Mp2dO5uyRw6/8KIcfS/PHTuRn/oL3MJfi7Sve6+pnn+/0" +
           "3vly5ZPbrrpqy5tNJuUCC92+bfAf5eMjt5R2KOt8+/Ef3PXiHW84BI67tgrv" +
           "suSYbg/dvIXddPwobzpv/uDe33vzbz3/jbyP9T8FJUkheR8AAA==");
    }
    public static class SVGFeFuncGElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncGElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_G_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IBkIPRemQl/t1cqcjWy6pRa/pOKVO57YHU3XGvDET5NxKnGJNezyfYfj9VBp" +
           "yuLI6VVqTYtcpt1ZaZqYi1KtEFar3djueBjb9oiou1DVIh8PEFNOSiwsTJsM" +
           "Vqi0cbloK+FsQqNTFJ+Ne0Ni0u2GlDckTZZatakK35VsE1lVg9bKb/QrHTFc" +
           "e7PZQm5hbGEC8N3gSV2rVFa+LajaQIEtxUjwMR3wbLHcn6+5eRQqi4aDq61R" +
           "CZ6wnYhebgY1sW3QbM3q6sNxn4D9qJxGTtdcVbR2aeJVuCrWR50uBg55DKP8" +
           "YD2miaThpMF0NTR5jFmVYAmWeWxJp4OpW6NdokQ1vT5u46VJdY1Zk7G2wAaq" +
           "oXdaluAXEiq1ShW4GtKbQdQYmh7ZH3dbUyEBp2d1uEbdynBuGyESt5IROKb4" +
           "bpVLIs+o2bOIrHvzXnPAgWpRKeHlkmUu4uJQXyQwllDoLGZgc4GuiLIwmNgu" +
           "wxfTFTueGGbSKKBqw1rV3WWnzwu4QEkEzVA6YsCUsQTIiBSDAtnQK3FR8qTC" +
           "cux5tRUoyEpsJOARpQyKOLWOYJpDu6UYTo2CKKr8XOo6fbXdtqu4LZJtv+v4" +
           "ikoUKrLK97uDocKphaC4QFY2vOy6Fj1sFJmuYS+TSifhML1Rr1ScyoJPFBbH" +
           "uz5veK5Q8lYET5Q2jWYbTTsdWQo7paIgIjpCI2oHnlQVQpz1Oa/bLMf6RF8o" +
           "RByRCLWcAQfI02oLsdhVxzRhnJqWywTSVZwJZtfFNhaiimhtpDgE2wzmbbK8" +
           "pEbjlmLSUiLMpAYVeIRUHYtBc8z1g8CcbQZjCi5ig1CIanAT7aybSp8mgdGz" +
           "0v2dP9rT0935g+LRGwPw0JRNUD/CU0N68w33dhvuek55u+Hu083n4z2nXSMC" +
           "yh6QHrjV+4H84egTTz/7gt79ZHHvoIEzBs/DB69tdnyyJ9Qnbv0UyOXvRnZd" +
           "hS8+/c/3S2+z3v0j9EofOiXkaZa/zb345fabtV/dg84e9RhueGtzctG1k52F" +
           "i6ERJ6EnnegvPHBk1nsycz0Kvi8fmPXlm/crb+qoM7mjtvHwKs2x+FXmltnF" +
           "j6E7p0bM+pri8geiU7sQCn7Yg+eJhlQM3XuLdvlhB+Paj9GKBxFx3w2vB7ev" +
           "tLTPvHDpwr0vDP4qbzofvXa6g4UumInrHu/2HLs/H4SGaee2uGPb+wnyn/cB" +
           "PW4hJwhVdafQe7f0T8fQ5dP0MXQu/z1O94EYurijA6y2N8dJnomhs4Aku/2l" +
           "4NBo/f+T9xcnhtMzJ3P2yOFXfpjDj6X5YyfyM3/Be5hLyfYV73Xtsy8w/Hte" +
           "qX5y21XXXGWzybhcYKHbtw3+o3x85JbcDnmdpx7//l2fu+NNh8Bx11bgXZYc" +
           "k+2hm7ewiXkQ503nze/f+7tv/c0Xvp73sf4HKkMVQnkfAAA=");
    }
    public static class SVGFeFuncBElementBridge extends org.apache.batik.bridge.SVGFeComponentTransferElementBridge.SVGFeFuncElementBridge {
        public SVGFeFuncBElementBridge() {
            super(
              );
        }
        public java.lang.String getLocalName() {
            return SVG_FE_FUNC_B_TAG;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "k24Q503nzR/e+/tv/e0XXs77WP8Dtkvb2XkfAAA=");
    }
    protected abstract static class SVGFeFuncElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge {
        protected SVGFeFuncElementBridge() {
            super(
              );
        }
        public org.apache.batik.ext.awt.image.ComponentTransferFunction createComponentTransferFunction(org.w3c.dom.Element filterElement,
                                                                                                        org.w3c.dom.Element funcElement) {
            int type =
              convertType(
                funcElement,
                ctx);
            switch (type) {
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       DISCRETE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getDiscreteTransfer(
                                v);
                        }
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       IDENTITY:
                    {
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getIdentityTransfer(
                            );
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       GAMMA:
                    {
                        float amplitude =
                          convertNumber(
                            funcElement,
                            SVG_AMPLITUDE_ATTRIBUTE,
                            1,
                            ctx);
                        float exponent =
                          convertNumber(
                            funcElement,
                            SVG_EXPONENT_ATTRIBUTE,
                            1,
                            ctx);
                        float offset =
                          convertNumber(
                            funcElement,
                            SVG_OFFSET_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getGammaTransfer(
                            amplitude,
                            exponent,
                            offset);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       LINEAR:
                    {
                        float slope =
                          convertNumber(
                            funcElement,
                            SVG_SLOPE_ATTRIBUTE,
                            1,
                            ctx);
                        float intercept =
                          convertNumber(
                            funcElement,
                            SVG_INTERCEPT_ATTRIBUTE,
                            0,
                            ctx);
                        return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                          getLinearTransfer(
                            slope,
                            intercept);
                    }
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       TABLE:
                    {
                        float[] v =
                          convertTableValues(
                            funcElement,
                            ctx);
                        if (v ==
                              null) {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getIdentityTransfer(
                                );
                        }
                        else {
                            return org.apache.batik.ext.awt.image.ConcreteComponentTransferFunction.
                              getTableTransfer(
                                v);
                        }
                    }
                default:
                    throw new java.lang.Error(
                      "invalid convertType:" +
                      type);
            }
        }
        protected static float[] convertTableValues(org.w3c.dom.Element e,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TABLE_VALUES_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                return null;
            }
            java.util.StringTokenizer tokens =
              new java.util.StringTokenizer(
              s,
              " ,");
            float[] v =
              new float[tokens.
                          countTokens(
                            )];
            try {
                for (int i =
                       0;
                     tokens.
                       hasMoreTokens(
                         );
                     ++i) {
                    v[i] =
                      org.apache.batik.bridge.SVGUtilities.
                        convertSVGNumber(
                          tokens.
                            nextToken(
                              ));
                }
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TABLE_VALUES_ATTRIBUTE,
                  s });
            }
            return v;
        }
        protected static int convertType(org.w3c.dom.Element e,
                                         org.apache.batik.bridge.BridgeContext ctx) {
            java.lang.String s =
              e.
              getAttributeNS(
                null,
                SVG_TYPE_ATTRIBUTE);
            if (s.
                  length(
                    ) ==
                  0) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  e,
                  ERR_ATTRIBUTE_MISSING,
                  new java.lang.Object[] { SVG_TYPE_ATTRIBUTE });
            }
            if (SVG_DISCRETE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         DISCRETE;
            }
            if (SVG_IDENTITY_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         IDENTITY;
            }
            if (SVG_GAMMA_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         GAMMA;
            }
            if (SVG_LINEAR_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         LINEAR;
            }
            if (SVG_TABLE_VALUE.
                  equals(
                    s)) {
                return org.apache.batik.ext.awt.image.ComponentTransferFunction.
                         TABLE;
            }
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
              s });
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HBxPiU8c3vwvkWhaUqMdAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lj/kB0g+yXc/xR/Z8PS/AFxrgnRkGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aCMAAA==");
}
