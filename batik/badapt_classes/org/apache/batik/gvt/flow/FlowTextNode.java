package org.apache.batik.gvt.flow;
public class FlowTextNode extends org.apache.batik.gvt.TextNode {
    public FlowTextNode() { super();
                            textPainter = org.apache.batik.gvt.flow.FlowTextPainter.
                                            getInstance(
                                              ); }
    public void setTextPainter(org.apache.batik.gvt.TextPainter textPainter) {
        if (textPainter ==
              null)
            this.
              textPainter =
              org.apache.batik.gvt.flow.FlowTextPainter.
                getInstance(
                  );
        else
            this.
              textPainter =
              textPainter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcRxWfO387/o5jp0nsxB9J5CTcNqKhVA6ljmsnDmf7" +
                                                              "FLsRdWguc3tzdxvv7W52Z89nl0BbCcUUEUXBbQOi/stVAbVNhagAQSujSrRV" +
                                                              "C1JLBBTUFIk/CB8RjZDKHwHKm5nd2729u0RF4qSd25t582bem9/7vTf33HVU" +
                                                              "Y5mol2g0QhcNYkXGNBrDpkWSoyq2rFnoi8tPVeF/nLw2dU8Y1c6hlgy2JmVs" +
                                                              "kXGFqElrDvUomkWxJhNripAkmxEziUXMHKaKrs2hTYo1kTVURVbopJ4kTOA4" +
                                                              "NqOoHVNqKgmbkglHAUU9UdiJxHcijQSHh6OoSdaNRU98s0981DfCJLPeWhZF" +
                                                              "bdHTOIclmyqqFFUsOpw30V5DVxfTqk4jJE8jp9UDjguORg+UuKD/xdYPb17I" +
                                                              "tHEXbMSaplNunnWMWLqaI8koavV6x1SStc6gL6GqKNrgE6ZoMOouKsGiEizq" +
                                                              "WutJwe6biWZnR3VuDnU11Roy2xBFfcVKDGzirKMmxvcMGuqpYzufDNbuKFgr" +
                                                              "rCwx8Ym90spTJ9u+X4Va51Cros2w7ciwCQqLzIFDSTZBTGskmSTJOdSuwWHP" +
                                                              "EFPBqrLknHSHpaQ1TG04ftctrNM2iMnX9HwF5wi2mbZMdbNgXooDyvlVk1Jx" +
                                                              "Gmzt8mwVFo6zfjCwUYGNmSkMuHOmVM8rWpKi7cEZBRsHPwcCMLUuS2hGLyxV" +
                                                              "rWHoQB0CIirW0tIMQE9Lg2iNDgA0KdpSUSnztYHleZwmcYbIgFxMDIFUA3cE" +
                                                              "m0LRpqAY1wSntCVwSr7zuT518PzD2hEtjEKw5ySRVbb/DTCpNzDpGEkRk0Ac" +
                                                              "iIlNe6JP4q6Xl8MIgfCmgLCQ+eEXb9y3r3f9dSGztYzMdOI0kWlcXku0vL1t" +
                                                              "dOieKraNekO3FHb4RZbzKIs5I8N5Aximq6CRDUbcwfVjP3/wke+Rv4ZR4wSq" +
                                                              "lXXVzgKO2mU9aygqMQ8TjZiYkuQEaiBacpSPT6A6eI8qGhG906mURegEqlZ5" +
                                                              "V63Of4OLUqCCuagR3hUtpbvvBqYZ/p43EEJ18KAmePqQ+PBvih6UMnqWSFjG" +
                                                              "mqLpUszUmf2WBIyTAN9mpASgfl6ydNsECEq6mZYw4CBDnIF0jkopVV8AwOoL" +
                                                              "sxBCU0BIEQYx4/+pPM8s27gQCoHTtwVDXoVoOaKrSWLG5RX70NiNF+JvCjix" +
                                                              "EHB8QtEuWC8i1ovw9SKwXoStF/Gvh0IhvkwnW1ecK5zKPMQ3EGzT0MxDR08t" +
                                                              "91cBoIyFanApE+0vSjSjHgm4zB2XL3c0L/Vd3f9qGFVHUQeWqY1VljdGzDQw" +
                                                              "kjzvBG1TAlKQlwl2+DIBS2GmLpMkEFGljOBoqddzxGT9FHX6NLh5ikWkVDlL" +
                                                              "lN0/Wr+08OjxL98ZRuFi8mdL1gBvsekxRtkFah4MBn05va3nrn14+cmzuhf+" +
                                                              "RdnETYIlM5kN/UEgBN0Tl/fswC/FXz47yN3eAPRMMYQTMF9vcI0idhl2mZrZ" +
                                                              "Ug8Gp3Qzi1U25Pq4kWZMAE2hhyO0nb93Aiw2sHDrhmfAiT/+zUa7DNZ2C0Qz" +
                                                              "nAWs4JngMzPG07/95Z8/yd3tJo1WX7afIXTYR1RMWQenpHYPtrMmISD33qXY" +
                                                              "N564fu4ExyxIDJRbcJC1o0BQcITg5q+8fubd96+uXQl7OKeQqe0EFDz5gpGs" +
                                                              "HzXewkhYbZe3HyA6FfiAoWbwAQ3wqaQUnFAJC6x/te7c/9LfzrcJHKjQ48Jo" +
                                                              "3+0VeP13HEKPvHnyn71cTUhmidbzmScm2Hujp3nENPEi20f+0Xd6vvkafhry" +
                                                              "AHCvpSwRTqeI+wDxQzvA7b+Tt3cFxu5mzU7LD/7i+PIVRHH5wpUPmo9/8MoN" +
                                                              "vtviisp/1pPYGBbwYs2uPKjvDpLTEWxlQO6u9akvtKnrN0HjHGiUgWataROY" +
                                                              "MV+EDEe6pu53P3u169TbVSg8jhpVHSfHMQ8y1ADoJlYGSDVvfPY+cbgL9dC0" +
                                                              "cVNRifElHczB28sf3VjWoNzZSz/q/sHBZ1evcpQZQsdWv8LdrNlbwBv/1AaT" +
                                                              "mh9vRRpM1FOp7uA109pjK6vJ6Wf2i+qgoziXj0Gp+vyv//1W5NIf3iiTTBqo" +
                                                              "bnxCJTmi+tZkuaCnKBdM8pLM46P3Wi7+8ceD6UMfJw2wvt7bED37vR2M2FOZ" +
                                                              "1oNbee2xv2yZvTdz6mMw+vaAO4Mqvzv53BuHd8kXw7z+FGReUrcWTxr2OxYW" +
                                                              "NQkU2hozk/U0c9gPFLPq3fDsdgCwuzyrlsFOgasqTQ1Edcg5UfZ7M2TissUD" +
                                                              "qxlimJfsfOXZW1DD51kzTVELlHG+eQCZoVvc2EwlCwSfc2pe6WzH+/Pfvva8" +
                                                              "QGywQA4Ik+WVxz+KnF8R6BW3iIGSQt4/R9wk+G7bhOM+gk8Inv+wh5nCOkQl" +
                                                              "2THqlLM7CvUsi2ET9d1qW3yJ8T9dPvuT75w9F3Zcc5ii6pyuiKvLp1kTE/E/" +
                                                              "/D9yD+sYMfIUNfkrO0ZJm0vui+KOI7+w2lrfvfrAb3hkFu4hTRBjKVtVfRD1" +
                                                              "w7XWMElK4TY0CYY2+JdC0R0Vq00wln3xXWeEPMRJZzl5iqqg9UvqcOkPSlJU" +
                                                              "w7/9clDiNHpykLvFi1/EBu0gwl5zhovznoo4Zx7Mh0o5mp/Xptudl4+UB4rg" +
                                                              "zq/5Lp/Y4qIP5fLq0amHb3zqGVH/yCpeWuLXQrjlilKswEl9FbW5umqPDN1s" +
                                                              "ebFhp4u2drFhjym2+qJ0BGLeYEDZEigOrMFCjfDu2sFXfrFc+w4E1gkUwhRt" +
                                                              "POG7ZIsbJVQYNiSDE1EvHfj+JuJVy/DQtxbv3Zf6++95+nPSx7bK8nH5yrMP" +
                                                              "/eri5jWobjZMoBoIJJKfQ42Kdf+idozIOXMONSvWWB62CFoUrE6geltTzthk" +
                                                              "IhlFLQzTmP0BwP3iuLO50MuqZ4r6Swmi9M4BpcICMQ/ptpbkLA35w+sp+v/B" +
                                                              "pXXbMAITvJ7CUXaW2h6X7/9q608vdFSNQ1wWmeNXX2fZiULK8P8l4eWQNtac" +
                                                              "zAvqqopHJw3DpbLatwwB/2Uhw/opCu1xen3JgP38Glf3OH9lzdf/C8w+s5Nt" +
                                                              "FAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PB8AAA==");
}
