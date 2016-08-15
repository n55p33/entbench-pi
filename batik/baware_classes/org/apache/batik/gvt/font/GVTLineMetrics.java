package org.apache.batik.gvt.font;
public class GVTLineMetrics {
    protected float ascent;
    protected int baselineIndex;
    protected float[] baselineOffsets;
    protected float descent;
    protected float height;
    protected float leading;
    protected int numChars;
    protected float strikethroughOffset;
    protected float strikethroughThickness;
    protected float underlineOffset;
    protected float underlineThickness;
    protected float overlineOffset;
    protected float overlineThickness;
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics) { super(
                                                                     );
                                                                   this.ascent =
                                                                     lineMetrics.
                                                                       getAscent(
                                                                         );
                                                                   this.
                                                                     baselineIndex =
                                                                     lineMetrics.
                                                                       getBaselineIndex(
                                                                         );
                                                                   this.
                                                                     baselineOffsets =
                                                                     lineMetrics.
                                                                       getBaselineOffsets(
                                                                         );
                                                                   this.
                                                                     descent =
                                                                     lineMetrics.
                                                                       getDescent(
                                                                         );
                                                                   this.
                                                                     height =
                                                                     lineMetrics.
                                                                       getHeight(
                                                                         );
                                                                   this.
                                                                     leading =
                                                                     lineMetrics.
                                                                       getLeading(
                                                                         );
                                                                   this.
                                                                     numChars =
                                                                     lineMetrics.
                                                                       getNumChars(
                                                                         );
                                                                   this.
                                                                     strikethroughOffset =
                                                                     lineMetrics.
                                                                       getStrikethroughOffset(
                                                                         );
                                                                   this.
                                                                     strikethroughThickness =
                                                                     lineMetrics.
                                                                       getStrikethroughThickness(
                                                                         );
                                                                   this.
                                                                     underlineOffset =
                                                                     lineMetrics.
                                                                       getUnderlineOffset(
                                                                         );
                                                                   this.
                                                                     underlineThickness =
                                                                     lineMetrics.
                                                                       getUnderlineThickness(
                                                                         );
                                                                   this.
                                                                     overlineOffset =
                                                                     -this.
                                                                        ascent;
                                                                   this.
                                                                     overlineThickness =
                                                                     this.
                                                                       underlineThickness;
    }
    public GVTLineMetrics(java.awt.font.LineMetrics lineMetrics,
                          float scaleFactor) {
        super(
          );
        this.
          ascent =
          lineMetrics.
            getAscent(
              ) *
            scaleFactor;
        this.
          baselineIndex =
          lineMetrics.
            getBaselineIndex(
              );
        this.
          baselineOffsets =
          lineMetrics.
            getBaselineOffsets(
              );
        for (int i =
               0;
             i <
               baselineOffsets.
                 length;
             i++) {
            this.
              baselineOffsets[i] *=
              scaleFactor;
        }
        this.
          descent =
          lineMetrics.
            getDescent(
              ) *
            scaleFactor;
        this.
          height =
          lineMetrics.
            getHeight(
              ) *
            scaleFactor;
        this.
          leading =
          lineMetrics.
            getLeading(
              );
        this.
          numChars =
          lineMetrics.
            getNumChars(
              );
        this.
          strikethroughOffset =
          lineMetrics.
            getStrikethroughOffset(
              ) *
            scaleFactor;
        this.
          strikethroughThickness =
          lineMetrics.
            getStrikethroughThickness(
              ) *
            scaleFactor;
        this.
          underlineOffset =
          lineMetrics.
            getUnderlineOffset(
              ) *
            scaleFactor;
        this.
          underlineThickness =
          lineMetrics.
            getUnderlineThickness(
              ) *
            scaleFactor;
        this.
          overlineOffset =
          -this.
             ascent;
        this.
          overlineThickness =
          this.
            underlineThickness;
    }
    public GVTLineMetrics(float ascent, int baselineIndex,
                          float[] baselineOffsets,
                          float descent,
                          float height,
                          float leading,
                          int numChars,
                          float strikethroughOffset,
                          float strikethroughThickness,
                          float underlineOffset,
                          float underlineThickness,
                          float overlineOffset,
                          float overlineThickness) {
        super(
          );
        this.
          ascent =
          ascent;
        this.
          baselineIndex =
          baselineIndex;
        this.
          baselineOffsets =
          baselineOffsets;
        this.
          descent =
          descent;
        this.
          height =
          height;
        this.
          leading =
          leading;
        this.
          numChars =
          numChars;
        this.
          strikethroughOffset =
          strikethroughOffset;
        this.
          strikethroughThickness =
          strikethroughThickness;
        this.
          underlineOffset =
          underlineOffset;
        this.
          underlineThickness =
          underlineThickness;
        this.
          overlineOffset =
          overlineOffset;
        this.
          overlineThickness =
          overlineThickness;
    }
    public float getAscent() { return ascent;
    }
    public int getBaselineIndex() { return baselineIndex;
    }
    public float[] getBaselineOffsets() {
        return baselineOffsets;
    }
    public float getDescent() { return descent;
    }
    public float getHeight() { return height;
    }
    public float getLeading() { return leading;
    }
    public int getNumChars() { return numChars;
    }
    public float getStrikethroughOffset() {
        return strikethroughOffset;
    }
    public float getStrikethroughThickness() {
        return strikethroughThickness;
    }
    public float getUnderlineOffset() { return underlineOffset;
    }
    public float getUnderlineThickness() {
        return underlineThickness;
    }
    public float getOverlineOffset() { return overlineOffset;
    }
    public float getOverlineThickness() {
        return overlineThickness;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VY3b8tU5E/e+0Au9xh/x6ch/AY+0kDzcMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C7AjWXmeZva97O7M7sICC8u+ZoHdtqelllot1RJM692S" +
       "utXqllpSY3vp9/uhfkitJhsbHB5lHELwYkPZXrscjINrATtlKlQ5jklcwSZ+" +
       "VHBRsRNXwHG5KiSEKqhKnFRI4pxu6V7de+feywwzvlV9bqvP6/v+8///+U+f" +
       "0698q3BHGBQg37M3mu1FV5Ukumra6NVo4yvh1f4QpYUgVOSmLYThBDx7QXrq" +
       "1y/99Xc/ol++WLiTLzwsuK4XCZHhuSGjhJ69UuRh4dL+adtWnDAqXB6awkqA" +
       "48iw4aERRs8PC686UjUqXBkeQIABBBhAgHMIML4vBSrdr7ix08xqCG4ULgt/" +
       "r3BhWLjTlzJ4UeHJ4434QiA4u2bonAFo4e7sNwdI5ZWToPDEIfct52sIfwyC" +
       "X/rZH738T28rXOILlwyXzeBIAEQEOuEL9zmKIypBiMuyIvOFB11FkVklMATb" +
       "SHPcfOGh0NBcIYoD5VBI2cPYV4K8z73k7pMybkEsRV5wSE81FFs++HWHagsa" +
       "4PrInuuWYSd7DgjeawBggSpIykGV2y3DlaPC4ydrHHK8MgAFQNW7HCXSvcOu" +
       "bncF8KDw0HbsbMHVYDYKDFcDRe/wYtBLVHj0zEYzWfuCZAma8kJUeN3JcvQ2" +
       "C5S6JxdEViUqvOZksbwlMEqPnhilI+PzLeptH36323Mv5phlRbIz/HeDSm86" +
       "UYlRVCVQXEnZVrzvueHPCI/89gcvFgqg8GtOFN6W+Wd/9zvv+IE3ffH3t2Xe" +
       "cEqZkWgqUvSC9Enxga+8sfls/bYMxt2+FxrZ4B9jnqs/vct5PvGB5T1y2GKW" +
       "efUg84vMlxY//mvKNy8W7iUKd0qeHTtAjx6UPMc3bCXoKq4SCJEiE4V7FFdu" +
       "5vlE4S5wPzRcZft0pKqhEhGF2+380Z1e/huISAVNZCK6C9wbruod3PtCpOf3" +
       "iV8oFO4CV+E+cD1W2P7l/6PCO2HdcxRYkATXcD2YDryMfwgrbiQC2eqwCLTe" +
       "gkMvDoAKwl6gwQLQA13ZZWirCFaBYOAuN8nAkgrQKSm8mimZ/7fbfJKxu7y+" +
       "cAEI/o0nzd4GFtPzbFkJXpBeihvt73z2hT+4eGgGO7lEhbeCHq9ue7ya93gV" +
       "9Hg16/Hq8R4LFy7kHb0663k7uiDXAlYO/N99z7I/0n/XB5+6DaiVv74dCPY2" +
       "UBQ+2w03936ByL2fBJSz8MWPr9/D/VjxYuHicX+aoQWP7s2q05kXPPR2V07a" +
       "0WntXvrAN/76cz/zore3qGMOemfo19bMDPWpk3INPEmRgevbN//cE8LnX/jt" +
       "F69cLNwOrB94vEgAYgPO5E0n+zhmsM8fOL+Myx2AsOoFjmBnWQce695ID7z1" +
       "/kk+4A/k9w8CGb8q0+DXg6u8U+n8f5b7sJ+lr94qSDZoJ1jkzvXvsP4v/Nkf" +
       "/5dyLu4DP3zpyMzGKtHzR2w/a+xSbuUP7nVgEigKKPcfP07/9Me+9YF35goA" +
       "Sjx9WodXsrQJbB4MIRDz+35/+e+//rVPfvXiodJciMDkF4u2ISWHJLPnhXvP" +
       "IQl6e/MeD/AdNjCwTGuuTF3Hkw3VEERbybT0/1x6pvT5//bhy1s9sMGTAzX6" +
       "ge/dwP756xuFH/+DH/2fb8qbuSBlc9deZvtiW4f48L5lPAiETYYjec+fPPaJ" +
       "3xN+AbhW4M5CI1VyD3VhK4Oc+WuiwuvzmsJ6Z41HTDEfVjgv91yeXs1Ektcu" +
       "5HnlLHk8PGoexy3wSBTygvSRr377fu7b/+I7OZ/jYcxRbSAF//mtAmbJEwlo" +
       "/rUnfUFPCHVQrvJF6ocv21/8LmiRBy1KwLOFowC4ouSY7uxK33HXf/iXv/vI" +
       "u75yW+Fip3Cv7QlyR8jNsHAP0H8l1IEXS/wfesd2+Nd3g+RyTrVwDfn8waPX" +
       "GshwpzvD0w0kS5/MkmeuVbuzqp4Q/8UcwcXsZxFI5tlzItDAcIA9rXazNvzi" +
       "Q1+3fv4bn9nOyCen+BOFlQ++9JN/c/XDL108Egc9fU0ocrTONhbKed6/Jfc3" +
       "4O8CuP5fdmWksgfbufCh5m5CfuJwRvb9bKCfPA9W3kXnP3/uxd/6Jy9+YEvj" +
       "oeNhQBtEuZ/5d//3D69+/C++fMocBHyPJ0Q5xneco9XDLHk+z6pkydu2w43d" +
       "lGaou+FVb1wzzqp6gsL9OYL7s5+t/CGeJe0tom5UuA0EuEDEz5ytMbnj2CrA" +
       "y596+o9/7OWn/1NuWXcbIYj88UA7JaA8Uufbr3z9m39y/2Ofzeen20UhzCV/" +
       "78lI/NpA+1j8nAvkvkMpPJqRfhxcb9lJ4S1bFZrdZLwDqjmZE/UCHNzlfugg" +
       "lPrbajrZD83VI274XCPuZJLbhwCv+98jW3zvX/6va1xoHrmcYtcn6vPwKz//" +
       "aPPt38zr70OIrPabkmuDOzDq+7rIrzn/4+JTd/7ri4W7+MJlabeY5AQ7ziZm" +
       "HoxreLDCBAvOY/nHF0PbyP/5wxDpjScdy5FuTwYve4MG91npXMX208UPJxcK" +
       "uXVslevJPL2SJW/ZO863Zq7AcAU7r9cGwYCtuNo2iOey5J1+ctLhHsyW23k2" +
       "4wHWUp6rZFP2Qd42ZDW8q4frWJCZnDLgz5094GRuCnup/957/+ujk7fr77qB" +
       "WPXxE6N4sslPk698uftm6aMXC7cdjsE1i9zjlZ4/Lvl7AwWsyt3JMfk/tpV/" +
       "Lr8j/iwX8TnednVOXp6A8OAOKRP1dmTOKf7uJHePreMJd8qzI0lec3pOqy9m" +
       "Cb2fDsY3Mh1sy74u/7X18u86dG0PZCXesHNvB27u2Nyw0+X3nq7LIIq9xw+8" +
       "CBiTIh+qshBKwFEd8ru8B/4T3wv4CWhP7K6D+9Og/eQZ0LLb9x9guj+bC/LV" +
       "tCsryeGYHIH2oRuE9mZwPbmD9uQZ0P7R9UC7dABtu+rPC7/zBLiP3iC4N4Lr" +
       "qR24p84A9/HrAXeXrJw5mJ+4QVCZnj29A/X0GaB+8XpA3akrhqafiumXvg9B" +
       "XdlhunIGpk9dl6BsRZANVzsN1K9+H4J6ZgfqmTNAfeZ6QN2dvXLVd29MTyr8" +
       "Z28Q1Vt3Sn+g/Keh+s3rQfVwCJZ2lpIt+GNN32r9aWL7/A0ChAonQrRTAP7W" +
       "9QB85BjAiW5IlguWdadh/Oc3iPHKTpAHAj0N47+6Lq8RA0cW7N3GaeB+9wbB" +
       "ZUJ7dgfu2TPAffl6wD10CO5c4f2bG8SXOY3ndvieOwPfv70efA94q+8lu698" +
       "H9MBtMMGnYHtT68H24MH2M4V3Z99T3h5c8kFMEPfgVzFrhaz3187HcBt2S2I" +
       "SO8M8/2R7Jd+AOe1pi1dOVgrc0oQgsDvimljBwHn5X0wut1hOAG0fd1AQVD6" +
       "wL6xoedqz3/orz7yh//w6a+DpUK/cMcqC+NBbHmkRyrO9m/e/8rHHnvVS3/x" +
       "ofzlGhAn9/e/++g7sla/cR7dLPnLY1Qfzaiy+ZJqKIQRmb8PU+RDticWs7eD" +
       "gPD7Zxs9/ESvEhL4wd+QE5ooPk0YNy5P4lGlgpm9YK0mEB2PcbhY0hWnTuFE" +
       "AkVrE1sZtQZB1/uGiMlFWXR5xx059VmpYVDDtpbYTQ9qG9MlyjSmi5Fm2+xa" +
       "7XcW40XJYFiOGa9ttKuPbMLhjKnZ7UMqpCB8uYdpCV9xylw9RJF6Ha7DJRgO" +
       "IMxfsWp/0CZdsuo2Z5HmmIwXbZLJrK9oXVOc9zWnG+qiB9X4ClvhqYAu6XWW" +
       "N6Z1vp+wUs9r47PW0Fe8XouqsiJiddvJmOkuQ99ku51OsUoJGjRoNfrcPOgz" +
       "pO1NEGfTby/DcaXEYBRuVjsddpA2HRYu+UwURzhj+OaacNsS2ueH3XI84QaJ" +
       "t1xGoRvT4ZxZSWVGM0uTur3uEumcMaWB1m5bKbtA2/3FqMS77Gbcoe3J2OZ5" +
       "tlhclzxko4VRs8N3OhDfKNKNSl1QVGxqziTc7DYrS4M0qkq4WAhLMyEWpQ4r" +
       "ylJsIe4gJtCayTNtVpiZ5IaiisrGavNaEfcpxxc5DFdljms7LmKP41YYj7iB" +
       "0N80cFOqb1oCQcT+INFj06TJNoGGyMRNmq0I62+Kvs+gRFQtEcNh6jpR4Bpr" +
       "vQRkN7MHVYspMk4XX7NsDWdtus61pFmCEMWSFS07nBmKS3+oGUkU2UI19XHW" +
       "CFtsSCf8bIhvAq4rp4htNpSQCGPbtwS7OgnWFW5jBuWqURk2GbxkOUgwENob" +
       "rK00Bpux1mrXh15LmbGsjaMEu0DYmb0h3EV9xBXxDsFUJY+tLtHl1ONw1idc" +
       "wTLCJW4REaIplteMPZQdjzslZimiLc9fCBWiQjQZr4csLb8EzZExW09cXLMI" +
       "ljFkNFabzMKfOQo3H4RpzeUMjFeDajJdG+M2TSreoEnD9hQvFoujoh4K/iRs" +
       "jybkIKlVqXITHSlIsnAaLZ+u98YIBKeeblNzt0WnRTJyXMjqQO4EEatjo5pQ" +
       "5Xqlji2KvFjbTO1NW0B93WOHATqUHNSec/xQKC5arZT0qQ2BRM5YbFWLqErP" +
       "573qVNUtuzPaWBNu4si4iSw78mzaD+3pvNjmllpMJlHQ7w6CNuLq2CixqLTU" +
       "6XszPuLTJJ5S/Ih1OIUTxA28bjA9gseNZqDNuKEhrHi+XTJYGpGK41D3oD7g" +
       "Nii6qKfCZEDEls1MqOaA0AzCF5bMkCt1IGJNKH4CrSdTwEwJe4QnCCWr3SGq" +
       "S8XADa1RtJcUO+7O2PFo3WZm9UHS4c3Qq/aBMQ+arMCSmIoLdjetTZtab01i" +
       "iTOs0J2gM7G71BxL+mW/L0UjTImwEjf2KZwcdoriSNdtMW3YIgAQkV1ymEam" +
       "4frd9tjdGM2JkcZiMB5pjVnLQRGxR5cpIUTEbujh4pzVLa+BNIYeEuMDCkGQ" +
       "Qc2sYimaqKUyh5puLy3Xkkl7afrtynjGLcfk3AtLOq3ZtXFjU5706haphTHd" +
       "ENtSbd1uOsvNgNImq42xXs0Go/mSoGaJ67f7pt7dFMdBRMaEOlgHm8kak0dl" +
       "ZpJWyq4+dRe9cX+9sXvaim/WmkmpnFrtsjJF4OLQ5GYpXJFpWJ6VJmJT1A3W" +
       "XExRu2u08JLCqa1mcaOO3E1RqvaimE1GPXW8rgisiLMeDTuQI68hzpwFNNR1" +
       "pn6j0jOXfoXlu+lgYacNK/CqPCWve0LZThMKH7IBUx2IzXpxOGyurFVkYWzY" +
       "T8KqOVk6U2nQ02pxtc4jK5WuuhvMkrpyiwFOCnXlSSn211yqL3pzmYxEUQii" +
       "qa/PsVVZjkpoqehGVcwcaWG9q0UUQjB2F9P8WXuAQ7wwD8qrckL3ZKZGovS4" +
       "lhiU6quWjpGmpYc8Om3gWj+sISk07pT7FYoeD0p+DMYO5ieGFeGracqGamlO" +
       "0yqMM/UomLSQsccKARMrkqo1MTX22NoKeHe4jE1aKMmSzFpAKEdOqTrU0zGU" +
       "nFWHTtKkTaK84ly4zCvtOYNTa5wUi444cGcBkRCNIe3NmCWfsN0hIRkkhdW6" +
       "nLyhYzmpxcN2oz+azE2xz5kkxadOReRxBhpO+1ClArkdLq2ptAsNN3GLXPkp" +
       "X2x2lsFy0Vik5Aqv9Ud1zIntRZPVy8VZj1tCK2tcrzcMGll7mjHqjszpWl05" +
       "855vRhxWGukqrJodllkpg2ZPRwWmyXnzheR1RYKxWpAFUf2WqZi0aA9qqd3b" +
       "LHueJwzZ1aCdVld4n9c5pded+5NJ10bodC3Z9FD2UrWfBp4k9JYkVA4Fw1aj" +
       "XpPyRHvGaeGGkiW6NKSb3gJNkV5NwXpiRaAm2BQrd6Gm5DOTRWXZ5PxOOo6m" +
       "PakUTUpKSjYcbomvR+tyTekRcjlQyitNiGBmI9P1hZlQ3IhfYzru9JyqlaCq" +
       "JtFGrwJrCrxp1WcO2YWCsDwYdUV3qqHUGOO8VqSZMT4jxIGFkfMW3KhAPO7q" +
       "E9Kqg7Vm2Q14qCxSdd9ZQnyUio6/QEddkypT0rzhaSPUSchisyov4FCtz1AU" +
       "VchoZlXDqpwISKu14E24vClXoVKZXgXcemnho0aPW/TskskERajZLAvAwQST" +
       "4qw+p7GlFszGVd1DkamfzP3YZCIzdXs6ORFZWsLscDUyek5nmupS1wLGjbSB" +
       "3DlMI6KFWePYsjv2OyDOQzA3bJFFclD3ayIrx91ps6ZQq4SAZwQXTvmlNICn" +
       "XBXd2P4KHtlFuielU+B7lXHcVqvwKO6ppRFLG2YUSSE94/RSDWgLUIMqv+y0" +
       "+kyaYkZlUrYrQW+6mFWNEelwI6brelM2rfRiEEf1ed+266haJyWvHeqzDlFi" +
       "1FYbVi1ETVCf4LuVkVjtYsXWCur2ujYESyIYvRS4rXbY7fcnmqwFYYVZF3tQ" +
       "rV5TuiKnzjGlh3JGhA1JbV5GTRkWoZUQusPiEuuMSUwQ4m6pqBurHupIJdkH" +
       "038nUqFwpiBQTSF9CVqTMgr8US0s0fEKdspwTRsG6SYYKi2Eptm6JZbLEyTG" +
       "4DYF0ClzlkKmGxkK8AGBYOMZ7a8qM9EwMYE3SMyYljx3ihQNmhCmqaBo7ZQo" +
       "R1rb4LjABQ1FmLQZik4xlnjgKAKHEkSktZRnrJ2OBFSQ0lJTb6xKLWHhVkZc" +
       "bUiC2AghhrHN99szZlRad/ueteH0oeWi4/mEjFDCCRErbaxJdKb7VmnWWZjL" +
       "uTihyov+ULDMeKZJPInLiCdDdrdRl8IuZJaTqJzEVUVsW/EAmft6WUon4gBb" +
       "w5tkgaouVI15GxVmIpwmEabM+63pPPQcHpVJDUObpKyU6jw5hWpELaFVa01t" +
       "WmEi6aNSHCn18VIKA3YVhxTnzTZU2sC70Brv6kI5wpF1JVxpSJWI+02n7DFF" +
       "ujRaFU2n2VvGTbJd17GI6Az0tNNfW72w1aI5jZCNSQxvCCOUrXV5sRnAPWvd" +
       "KZvdhaT63KrVbxid+WwohhIn60qFkRFdp7jEqjQaQSpS7BL3Fh0nmZJtae01" +
       "amhlBgV6EUwVlTmE1KUi1IGGMMHF/sqHaV+vlYgS5/lqok0Il5l0q1RPTuMB" +
       "PxQVtSkvasVyUlHFZD1A68KoS3PL2QymSBMllz0XK3ckd9WiNWTWIhGIbmFc" +
       "swmrEUuaBMrMN8XKtMmqS3JGlawNRbtrqF0zQAAw9QS0PzBmTIPya3U8NcSA" +
       "cASVMmss2xTVaIz7xU3HGYytJlDjiu7iI1kRBKFCu9VauxbboAkNXflJf2b0" +
       "RkKxBg/QIRNWbH+6mWCzSotx19KmakkUshg25K6DV6KOOPLbRVPwxnG3Nt2o" +
       "ZLNiuaUm3KrJRovOME96w2TVWvjGmBxQi6QpDuuTPhVRnSjhETxO1MlmLE7q" +
       "S6lT8qVhs4qJ4aA2jw22V2HcLh8kzkJVV7XxZlBTqdmkPZpXWsS8CrN9kanX" +
       "NuW+X16t4X5PY1NsOiE3LZPuLwiGdq32eoY0qJhs9srTWhNRZya/HCMbpKKt" +
       "ezWq0tIn1ZbRUGtLAi0j3ALhe7HFrKnSalUvLple0opWrutKgzRdq6PUgZcl" +
       "q9FOuEk09z1qmoZxLYrFxZKc65Jch43avDvksIrY7tVb1qTG0sU07TT4cSdE" +
       "O77J9FldFEnV7lGCXmvICNmdmFOiFDkNTOE1O53B7QrUb3c3LQ/yukWjE5OL" +
       "5bgt2TFrq+lCKrEknpT1cF0x0CLa93m4s87KG6015g2KDQNytRqTrEc0Neyi" +
       "OE+scSJKKJKJwbJmuFwp7VaNxUdt2lS04WLYQRbJFG82hgLbaQlMxSeohk53" +
       "G/1asZWMaYNpaDomTFsiYaxnjoaaPl/UETA30H1iUFsAwE26U4EaPQAgMLwm" +
       "IhubmYN7jCxMNEpvRAQ0RadsVwkHDAqW/hrc1lo6CIKLlNBiWMm0x6224Cgj" +
       "cUMzFEcsNclVxtNY0mpTszKVBGJQHBebvBEy1Y00bRoIIk0WC2oDJpOGZrla" +
       "E+WtYYZUr/vaqDEYN0JW3zBd3/Ub0kyuUEZFZNbefDIk6VmNkId6ZU7XCRwR" +
       "arRAxc1EwPmFUFuGOLLBGUsYTPG1Nakb7HxmHciqrItj2QhnZaRheTo5pjdz" +
       "FLV0XYtljtmUG6YuAEmB/qmk3BAnOgKm7QayGeJ9egQTiGRKakRUpj1/Oe8N" +
       "B91RZwH1eoiDp3itHY3K3YUume0kqUADF/h5aApX5VQGwourcFwBC8fB3J1r" +
       "IRIEowFUUYLNRqLmqxkCLcNEoZKi2FfmSdRcY+UKibphWHSlhd2K+UWtCkbX" +
       "m8vNIjapFwmdqM4rWnnTUx0TKa+hSmcU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0CzuTFMfpdcm1kPQETNV0zmi1HC/JYMoawOja3g01GRdHhlNswiJTXPcaQSy" +
       "GvetFbAxJxBEfxJM0ImLGVVG7IesvJKHxVYlUSohBAXFeMFhJprAcHNZkhU1" +
       "XumNWrEqDvBYpCDSs7n2BgkSJVmrHbmEpmpbHZr2DAlXTiotINrhVzIK/FOL" +
       "igZ0vTybUP0u29ZbZd50YrVhU6N5rIoIptR7KYMJ3IqxHG8+tfotfKPaZWhQ" +
       "F0g74vuw6HuwO2N6Vs+l6h3BwaByFQSPFbeGJkYttMRkXqpjkKoMGVpWarKk" +
       "TMsTuuUPB7LZ769ntZUKs5jsDzZ6ZdlS2KpnLUpWd0YwTL/dQcrTKa8jXlih" +
       "uNj0wg5fmsUdp94mo8FYTdouDEISXViPpnOk79i8MQIuxO5MBEoRB0qnIvrm" +
       "nBojrfmsHfdRTkmqpKkJHg7VrSlGNUvYpOoWuUVZrEVTtA0rUBGP64kOJ1VJ" +
       "h/EFVLRaqUSO8fx123+/sVd4D+ZvKw8PR5s2lmX81Q28pUuO7BsfvuHN/+4s" +
       "nDhQe+QN75Et1kJ2iOixs8485weIPvnel16WR79Surjb3u1FhXsiz/9BW1kp" +
       "9pGmtqeY/EMYOZTsNMr7djDed/JF857o6W+Z37oV1NlbzRfuOifvniy5CMBq" +
       "SoTvtwUPBXvhths+prQndyl7mG0//9SO3E/denIPn5P3mix5ICpcBuQa12wW" +
       "7zleugmOD2cPsx29l3YcX7r1HB8/Jy9T6wuPRoWHjnA8uuu8Z/mGm2CZq2m2" +
       "h/lzO5Y/d+tZQufk/WCWvDkq3AtYtpTT9PQtN8suM8Jf3rH75VvPDjsnr54l" +
       "yNYIe/t98D258q0Yuk/vyH361pNrnpPXzpK3b4dueGRDfc/uh27WxWRD9xs7" +
       "dr9x69mNzskbZ0k/KrwKsKOO7szv6Q1udvCyPdwv7Oh94dbTe+c5eT+SJVxU" +
       "eATQY8/Y4t8znd0s02wH+Hd2TH/n1jPVzskzskSMCq8/yfT4nu2erHSzZLOt" +
       "7y/tyH7p1pMNz8mLs8TdThrTUw4d7Fl6N8sy20T/ox3LP7r1LH/snLz3ZEka" +
       "FV5zlOVZw/numyWancn66o7oV2890Q+dk/cPsuT9IFQGREfXHoPYk/zAzZLM" +
       "Ap0/35H881tP8mfPyftElnw0Krz6CMmzBvOnb+gwZVR44PjHYtmXL6+75kPU" +
       "7ceT0mdfvnT3a1+e/un2PPrBB473DAt3q7FtHz1IfOT+Tj9QVCPnf8/2WLGf" +
       "k/ol4HDO/IQtKtye/csAX/jFbfl/DPifVj4q3AbSoyU/BcLekyWjwh35/6Pl" +
       "Pg1m5n257KRnfnO0yCugdVAku/3MVh+OHxLZnrxOtp/+vO6o9uRLs4e+12Ac" +
       "WWQ9fewIc/7J8MFx43j70fAL0ude7lPv/k71V7Yffkm2kKZZK3cPC3dtv0HL" +
       "G82OLD95ZmsHbd3Ze/a7D/z6Pc8cLNse2ALea/IRbI+f/pVV2/Gj/Luo9Auv" +
       "/c23/erLX8vPrPx/eMuv2cs9AAA=");
}
