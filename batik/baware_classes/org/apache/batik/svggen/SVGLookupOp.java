package org.apache.batik.svggen;
public class SVGLookupOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private static final double GAMMA = 1.0 / 2.4;
    private static final int[] linearToSRGBLut = new int[256];
    private static final int[] sRGBToLinear = new int[256];
    static { for (int i = 0; i < 256; i++) { float value = i / 255.0F;
                                             if (value <= 0.0031308) { value *=
                                                                         12.92F;
                                             }
                                             else {
                                                 value =
                                                   1.055F *
                                                     (float)
                                                       java.lang.Math.
                                                       pow(
                                                         value,
                                                         GAMMA) -
                                                     0.055F;
                                             }
                                             linearToSRGBLut[i] = java.lang.Math.
                                                                    round(
                                                                      value *
                                                                        255);
                                             value = i / 255.0F;
                                             if (value <= 0.04045) {
                                                 value /=
                                                   12.92F;
                                             }
                                             else {
                                                 value =
                                                   (float)
                                                     java.lang.Math.
                                                     pow(
                                                       (value +
                                                          0.055F) /
                                                         1.055F,
                                                       1 /
                                                         GAMMA);
                                             }
                                             sRGBToLinear[i] = java.lang.Math.
                                                                 round(
                                                                   value *
                                                                     255);
             } }
    public SVGLookupOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.LookupOp)
            return toSVG(
                     (java.awt.image.LookupOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.LookupOp lookupOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              lookupOp);
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
            java.lang.String[] lookupTables =
              convertLookupTables(
                lookupOp);
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
              SVG_TABLE_VALUE;
            if (lookupTables.
                  length ==
                  1) {
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
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncG.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
                feFuncB.
                  setAttributeNS(
                    null,
                    SVG_TABLE_VALUES_ATTRIBUTE,
                    lookupTables[0]);
            }
            else
                if (lookupTables.
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
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[0]);
                    feFuncG.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[1]);
                    feFuncB.
                      setAttributeNS(
                        null,
                        SVG_TABLE_VALUES_ATTRIBUTE,
                        lookupTables[2]);
                    if (lookupTables.
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
                            SVG_TABLE_VALUES_ATTRIBUTE,
                            lookupTables[3]);
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
                lookupOp,
                filterDesc);
        }
        return filterDesc;
    }
    private java.lang.String[] convertLookupTables(java.awt.image.LookupOp lookupOp) {
        java.awt.image.LookupTable lookupTable =
          lookupOp.
          getTable(
            );
        int nComponents =
          lookupTable.
          getNumComponents(
            );
        if (nComponents !=
              1 &&
              nComponents !=
              3 &&
              nComponents !=
              4)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_ILLEGAL_BUFFERED_IMAGE_LOOKUP_OP);
        java.lang.StringBuffer[] lookupTableBuf =
          new java.lang.StringBuffer[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTableBuf[i] =
              new java.lang.StringBuffer(
                );
        if (!(lookupTable instanceof java.awt.image.ByteLookupTable)) {
            int[] src =
              new int[nComponents];
            int[] dest =
              new int[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   offset;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    i);
                lookupTable.
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          dest[j] /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        else {
            byte[] src =
              new byte[nComponents];
            byte[] dest =
              new byte[nComponents];
            int offset =
              lookupTable.
              getOffset(
                );
            for (int i =
                   0;
                 i <
                   offset;
                 i++) {
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          i /
                            255.0)).
                      append(
                        SPACE);
                }
            }
            for (int i =
                   0;
                 i <=
                   255;
                 i++) {
                java.util.Arrays.
                  fill(
                    src,
                    (byte)
                      (255 &
                         i));
                ((java.awt.image.ByteLookupTable)
                   lookupTable).
                  lookupPixel(
                    src,
                    dest);
                for (int j =
                       0;
                     j <
                       nComponents;
                     j++) {
                    lookupTableBuf[j].
                      append(
                        doubleString(
                          (255 &
                             dest[j]) /
                            255.0)).
                      append(
                        SPACE);
                }
            }
        }
        java.lang.String[] lookupTables =
          new java.lang.String[nComponents];
        for (int i =
               0;
             i <
               nComponents;
             i++)
            lookupTables[i] =
              lookupTableBuf[i].
                toString(
                  ).
                trim(
                  );
        return lookupTables;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZaXAcxRVurU7rsA6fGEs+JJPYhl0gmBQRGGRZsmVWlkoS" +
       "SiID8uxs72qs2ZlhpldamziAKwGTFC7H2EAI6E9MDI6xKQI5KkAMFAYKQhVH" +
       "IOACQ8hBQpzgSgJUnIS81z2zc+zhOAlbNb2z3a9f97u+97r3wHFSbpmkhWos" +
       "zDYb1Ap3aaxfMi0a71QlyxqCvlH59lLpL1e/t/6iEKkYIdPHJKtXlizarVA1" +
       "bo2QZkWzmKTJ1FpPaRxn9JvUouaExBRdGyGzFKsnZaiKrLBePU6RYFgyo6RR" +
       "YsxUYmlGe2wGjDRHYScRvpNIR3C4PUpqZd3Y7JLP9ZB3ekaQMuWuZTHSEN0k" +
       "TUiRNFPUSFSxWHvGJMsNXd2cVHUWphkW3qSusFWwLroiRwWLH6j/8OTOsQau" +
       "ghmSpumMi2cNUEtXJ2g8Surd3i6VpqxryFdJaZTUeIgZaYs6i0Zg0Qgs6kjr" +
       "UsHu66iWTnXqXBzmcKowZNwQI4v8TAzJlFI2m36+Z+BQxWzZ+WSQdmFWWiFl" +
       "joh7lkd23351w4OlpH6E1CvaIG5Hhk0wWGQEFEpTMWpaHfE4jY+QRg2MPUhN" +
       "RVKVLbalmywlqUksDeZ31IKdaYOafE1XV2BHkM1My0w3s+IluEPZv8oTqpQE" +
       "WWe7sgoJu7EfBKxWYGNmQgK/s6eUjStanJEFwRlZGdsuBwKYWpmibEzPLlWm" +
       "SdBBmoSLqJKWjAyC62lJIC3XwQFNRuYVZIq6NiR5XErSUfTIAF2/GAKqaVwR" +
       "OIWRWUEyzgmsNC9gJY99jq+/eMe12lotREpgz3Eqq7j/GpjUEpg0QBPUpBAH" +
       "YmLtsuht0uxHt4cIAeJZAWJB86OvnLjs7JbDzwiaM/PQ9MU2UZmNyntj01+c" +
       "37n0olLcRpWhWwoa3yc5j7J+e6Q9YwDCzM5yxMGwM3h44MiXr99P3w+R6h5S" +
       "IetqOgV+1CjrKUNRqbmGatSUGI33kGlUi3fy8R5SCe9RRaOity+RsCjrIWUq" +
       "76rQ+W9QUQJYoIqq4V3RErrzbkhsjL9nDEJIJTykFp5lRHz4NyPDkTE9RSOS" +
       "LGmKpkf6TR3ltyKAODHQ7VgkBl4/HrH0tAkuGNHNZEQCPxijzsBEMkm1yODw" +
       "mqiuj6eNPiOM/mV8apwzKNOMyZISUPf8YLCrECdrdTVOzVF5d3pV14mDo88J" +
       "R0Lnt7XBSCssFhaLhfliYbFY2LMYKSnha8zERYU5wRjjENaAq7VLB69at3H7" +
       "4lLwI2OyDDSJpIt9+aXTjX0HsEflQ011Wxa9dd6TIVIWJU2SzNKSiumiw0wC" +
       "EMnjdqzWxiDzuAlgoScBYOYydZnGAX8KJQKbS5U+QU3sZ2Smh4OTnjAQI4WT" +
       "Q979k8N3TN4wfN25IRLyYz4uWQ5whdP7EamziNwWjPV8fOtveu/DQ7dt1d2o" +
       "9yURJ/flzEQZFge9IKieUXnZQunh0Ue3tnG1TwNUZhJEEQBeS3ANH6i0OwCN" +
       "slSBwAndTEkqDjk6rmZjpj7p9nD3bOTvM8EtajDKZsMzYIcd/8bR2Qa2c4Q7" +
       "o58FpOAJ4JJB4+5fvvD7z3F1O7mi3pPkBylr9+ATMmviSNTouu2QSSnQvXlH" +
       "/617jt+0gfssULTmW7AN207AJTAhqPnrz1zz+rG39r4Scv2cQYJOx6DOyWSF" +
       "xH5SXURIWO0sdz+AbyogAXpN2xUa+KeSUKSYSjGw/lG/5LyH/7ijQfiBCj2O" +
       "G519agZu/xmryPXPXf1RC2dTImN+dXXmkgnQnuFy7jBNaTPuI3PDS83fflq6" +
       "G+AfINdStlCOoiV2rOOm5jKyvAiO2KCum3ZpwQ29gs88l7cXoJI4P8LHLsJm" +
       "ieUNGH9MemqnUXnnKx/UDX/w2Akuob/48vpHr2S0C5fE5qwMsJ8TBLS1kjUG" +
       "dBccXn9lg3r4JHAcAY4ygLLVZwKUZnzeZFOXV77x+JOzN75YSkLdpFrVpXi3" +
       "xAOTTIOIoNYYoHDGuPQy4RCTVdA0cFFJjvA5HWiUBfnN3ZUyGDfQlh/Peeji" +
       "fVNvcc80BI8z+fxSTAw+JOYlvAsG+1/+/C/2feu2SVEELC2MgIF5c//ep8a2" +
       "/erjHJVz7MtToATmj0QO3DWvc+X7fL4LQji7LZObzADI3bnn70/9LbS44qkQ" +
       "qRwhDbJdMg9LahpDewTKRMupo6Gs9o37Sz5R37RnQXZ+EAA9ywbhz02i8I7U" +
       "+F4XQLwz0ITnwhOxwSASRDyeVhu4fXFL4dU64Am9/gdPrFs6frIMtLOalE/g" +
       "zjM+svVpLMxvPLCnuWb329/kdr/0jf34+T7yvZzv4DO8XYbNOcIbGKk0TAVO" +
       "aaCICosX+wzEUjRJDSDY3CKbhilrOnp7O/xZHjPpYDpmQUZWUgDAE3Ypen7/" +
       "Rnl7W/+vhYedkWeCoJt1b+SW4dc2Pc/hvQpz/pCjVU9Gh9rAk1saxKY/gU8J" +
       "PP/CBzeLHaKka+q068qF2cISI6SoqwcEiGxtOjZ+13v3CwGCfh0gptt3f+OT" +
       "8I7dArPF6aQ154DgnSNOKEIcbEZwd4uKrcJndP/u0Naf3rv1JrGrJn+t3QVH" +
       "yftf/efz4TvefjZPyVcR516WxZqSbNU2028eIdPqm+sf2dlU2g0FQw+pSmvK" +
       "NWnaE/eHQKWVjnns5R583LCwpUPbMFKyDMwg0j22X8AmKnzwkoJA2eUPrJXw" +
       "rLB9dEVOYBH+sqlAJODrADaD2Azl8f5CnCGn4KlDMof0wYE1q6Jp5r9Nybo1" +
       "z59Cg1fWHPmZ9d3fPiiMlS9oAue3e/dVyUdTR3jQ4Kpfyu5vOm6nER5bSeKb" +
       "kQ3/4wkDbxWkSRZJUj0FJ1g2BkVyko05B5hPkz06/JLC4ejR49T3Wl+4bqr1" +
       "HZ6WqxQL8BkAIc8Z2jPngwPH3n+prvkgL3fLEFdsH/VfPuTeLfiuDLgV6rGx" +
       "hK980Y5V/LrS876RkVLFvsDxxBb+TGRyIo57teBqO+x1+R02hK9h4at8NYhi" +
       "lasQf23BJmO4/ENiklObzXAzR6eqg/M60Q9j4kyn6OHszQ4M5u7UJM2+OqKX" +
       "K8dNym9O3/XuT9qSq07nMId9Lac4ruHvBWDhZYUdJLiVp7f9Yd7QyrGNp3Eu" +
       "WxDwnyDL+3oPPLvmLHlXiF8eiWoh59LJP6ndD5DVJmVpU/NDYqswPbeesDs2" +
       "y7mBi1THO4uM7cLmFkjRMhpa+EUR8j25BSd2dBqe2tTnwgHMHj9NzG6H50Ib" +
       "uS4sgNl3/teYXYgzI7UWYPWQHuXIjX1mQJDvFBHEa5vsovxTQQKXSJ5FPWU4" +
       "QYhrLnTPx/P53m27p+J995znIL7E4PCgG+eodIKqvooe32/ObmMBsm+DJ2Zv" +
       "IxbUqitoQILsUbXQ1IDfBEClhQMHgHpYSUlJGl6VTmAOi/fgrz7DIWvKkg1A" +
       "xgAIAnTBoYNFvPIhbO4DJ2Y6nB7/kxNmt6ICfK+mlmwqhnPDzA27/1QeWvz4" +
       "JaKhkNINW3PG6Su90NSAWgKn7DkBpTs3dHzBx4uo9ClsHnFUij9+6Oro0U9B" +
       "R7Nw7LPwHLUFPVpER8FY52AzEIjwmiLM8msNfz7B13mxiGpexuY5yJJwVISs" +
       "w4ROh3iS5BOcM/WE/Q128JzFxB8H+VO74WDaG/9hWsdmGzY8pb+am9Lx59ew" +
       "uTF/NXGzcIVXsdlRROh3ioy9i80xbG4VuyhC+5vTTSCu1z3///C6DCM1nptq" +
       "vC6Zm/O3l/irRj44VV81Z+qK10Qp6PydUgvVRiKtqt4Dvee9wjBpQuGy1orj" +
       "vdDwnyAYCwASHq75C9/0cUF/ApwmSA/hyL+9dH9lpNqlA1bixUvyEdSYQIKv" +
       "H2dx9vxC6NgBxwsTCrIsSnYKN6dmpsSfo7KWmXUqy3jSWquvMON/TDpFVFr8" +
       "NTkqH5pat/7aExfeI65uZVXawt27BopscYucLcQWFeTm8KpYu/Tk9AemLXES" +
       "ZaPYsAsmZ3q8sxPcjvvEvMC9ptWWvd58fe/Fj/18e8VLcKjYQEog787YkHtH" +
       "lDHSkME3RHPPx1C08gvX9qV3bl55duLPR/ltDBE18/zC9KPyK/uuennX3L0t" +
       "IVLTQ8qhBqAZfnm1erMGqXLCHCF1itWVgS0CFyjNfYfv6ei+EiIP14utzrps" +
       "L178M7I49+oh9++SalWfpOYqPa3FkQ0cjWrcHqcg99WyacMITHB7POclTj+S" +
       "QWuAx45Gew3DuZmpPmLwAE4UrDJLavgrvtX+GwbKeUS0IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "95U34nh5Ar3p1FGp4tzH2+44d7k/K6h9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4ZVrDz31ivzP9zuIR+f5Hmagh8zUdU9vuZ+6vxJGhmmXUj6834Dfj9l/AHF3" +
       "D0Aptr/Lm1Laf7+n//0Eun6eHkRe+X+a7g8S6OoJHWC1vzlN8p8T6BIgKW6/" +
       "e4yT9XuhG76Ik0jVkmOU6+7DwYjyC2cnlOMRePz7jcCpOej5Mxtx5cnYo02z" +
       "dH829rb2xVdo9kPfa/3C/riT5qq70iUeYqAH9yevjjfe3nFPbke8rpAvvP7o" +
       "Lz/8rqNZ7dG9wCd4ckq25+5+tojwwqQ8DbT720/9zff8tVe+UR5x+N+q2roR" +
       "siwAAA==");
}
