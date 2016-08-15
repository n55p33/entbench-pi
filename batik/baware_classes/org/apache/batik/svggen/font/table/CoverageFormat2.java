package org.apache.batik.svggen.font.table;
public class CoverageFormat2 extends org.apache.batik.svggen.font.table.Coverage {
    private int rangeCount;
    private org.apache.batik.svggen.font.table.RangeRecord[] rangeRecords;
    protected CoverageFormat2(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        rangeCount =
          raf.
            readUnsignedShort(
              );
        rangeRecords =
          (new org.apache.batik.svggen.font.table.RangeRecord[rangeCount]);
        for (int i =
               0;
             i <
               rangeCount;
             i++) {
            rangeRecords[i] =
              new org.apache.batik.svggen.font.table.RangeRecord(
                raf);
        }
    }
    public int getFormat() { return 2; }
    public int findGlyph(int glyphId) { for (int i = 0; i < rangeCount;
                                             i++) { int n = rangeRecords[i].
                                                      getCoverageIndex(
                                                        glyphId);
                                                    if (n > -1) {
                                                        return n;
                                                    } }
                                        return -1; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxUfnz/xN+bLAWzANiA+chdoaIVMScDYYHoGCwNR" +
                                                              "TYLZ25u7W9jbXXbn7DOU5qOKoFWLKAVC2sR/NCQQRCCijdqqTUoVFRIljRRC" +
                                                              "m6ZRoF9qaSkqqGpalbbpezO7tx/nM0Vqaunm9mbfm5n35vd+78341HVSapmk" +
                                                              "mWoszIYNaoU7NdYrmRaNd6iSZW2EvgH5iWLpL1uvrlsaImX9pDYlWT2yZNEu" +
                                                              "hapxq580KZrFJE2m1jpK46jRa1KLmoMSU3Stn0xSrO60oSqywnr0OEWBzZIZ" +
                                                              "JeMlxkwllmG02x6AkaYorCTCVxJZEXzdHiXVsm4Mu+KNHvEOzxuUTLtzWYzU" +
                                                              "R7dLg1IkwxQ1ElUs1p41yQJDV4eTqs7CNMvC29UltgvWRpfkuaDlxboPbx1I" +
                                                              "1XMXTJA0TWfcPGsDtXR1kMajpM7t7VRp2tpJPk+Ko6TKI8xIW9SZNAKTRmBS" +
                                                              "x1pXClZfQ7VMukPn5jBnpDJDxgUxMss/iCGZUtoeppevGUaoYLbtXBmsnZmz" +
                                                              "VliZZ+LhBZFDT2ytP1tM6vpJnaL14XJkWASDSfrBoTQdo6a1Ih6n8X4yXoPN" +
                                                              "7qOmIqnKLnunGywlqUksA9vvuAU7MwY1+Zyur2AfwTYzIzPdzJmX4ICyf5Um" +
                                                              "VCkJtk52bRUWdmE/GFipwMLMhAS4s1VKdihanJEZQY2cjW2fAQFQLU9TltJz" +
                                                              "U5VoEnSQBgERVdKSkT6AnpYE0VIdAGgyMrXgoOhrQ5J3SEk6gIgMyPWKVyA1" +
                                                              "jjsCVRiZFBTjI8EuTQ3skmd/rq9btn+3tkYLkSJYc5zKKq6/CpSaA0obaIKa" +
                                                              "FOJAKFbPjx6RJr+8L0QICE8KCAuZ73zu5v0Lm8+9JmSmjSKzPradymxAPhar" +
                                                              "fXt6x7ylxbiMCkO3FNx8n+U8ynrtN+1ZAxhmcm5EfBl2Xp7bcP6zj5yk10Kk" +
                                                              "spuUybqaSQOOxst62lBUaq6mGjUlRuPdZBzV4h38fTcph+eoolHRuz6RsCjr" +
                                                              "JiUq7yrT+W9wUQKGQBdVwrOiJXTn2ZBYij9nDUJIOXxINXyaiPjj34zQSEpP" +
                                                              "04gkS5qi6ZFeU0f7rQgwTgx8m4rEAPU7IpaeMQGCEd1MRiTAQYo6LwaTSapF" +
                                                              "EjoylBRTKTDUIFiTpF26mZbY4jDCzfh/TZRFiycMFRXBZkwPUoEKUbRGV+PU" +
                                                              "HJAPZVZ23jw98IaAGYaG7StGFsPcYTF3mM8dFnOHce4wnzscmJsUFfEpJ+Ia" +
                                                              "xN7Dzu0ADgASrp7X99DabftaigF0xlAJuB1FW3zJqMMlCofdB+QzDTW7Zl1e" +
                                                              "9GqIlERJgySzjKRibllhJoG15B12YFfHIE252WKmJ1tgmjN1mcaBrAplDXuU" +
                                                              "CrQI+xmZ6BnByWUYtZHCmWTU9ZNzR4ce3fzwPSES8icInLIUuA3Ve5HWc/Td" +
                                                              "FiSG0cat23v1wzNH9uguRfgyjpMo8zTRhpYgKILuGZDnz5ReGnh5Txt3+zig" +
                                                              "cCZByAE7Ngfn8DFQu8PmaEsFGJxAbKj4yvFxJUuZ+pDbw9E6nj9PBFjUOnHZ" +
                                                              "asco/8a3kw1spwh0I84CVvBs8ek+4+mfv/WHT3B3O4mlzlMR9FHW7iEzHKyB" +
                                                              "09Z4F7YbTUpB7oOjvV87fH3vFo5ZkGgdbcI2bDuAxGALwc2Pv7bzvSuXj10K" +
                                                              "uThnZJxh6gwCncazOTvxFakZw06YcI67JOBDFUZA4LRt0gCiSkLBIMTY+mfd" +
                                                              "7EUv/Wl/vYCCCj0OkhbefgC3/66V5JE3tv6tmQ9TJGM+dt3migmSn+COvMI0" +
                                                              "pWFcR/bRi01PXpCehnQBFG0puyhn3SI73HFRjZA8uKaihzdIWlxPr5CB6awu" +
                                                              "4G++sUu42D28vTdfeYKj3L2+MytTAxfE9ZZiM9vyBo8/Pj1F14B84NKNms03" +
                                                              "XrnJTfVXbV6s9EhGu4AnNnOyMPyUILmtkawUyN17bt2D9eq5WzBiP4zIjVpv" +
                                                              "AstmfciypUvLf/GjVydve7uYhLpIpapL8S6JBykZB9FBrRQQdNa4736BjKEK" +
                                                              "aOrxKUtyjiHcMSSb14G7M2P0fe9MG4zv1K7vTvn2suMjlzlKDTHGNK4fwpzh" +
                                                              "Y2Ve+7vEcPKdT/30+FePDInqYV5hNgzoNf5jvRp77Nd/z3M558FRKpuAfn/k" +
                                                              "1FNTO5Zf4/ouIaF2WzY/zwGpu7qLT6b/Gmop+3GIlPeTetmutTdLagbDvB/q" +
                                                              "S8spwKEe973314qiMGrPEe70IBl6pg1SoZtf4Rml8bkmwH5YnJBp8Jlhs8KM" +
                                                              "IPsVEf7Qw1Xm8nY+Nnc7ZFNumAqcx2iAaqrGGJSRShPMAy7IwBHEl5Yx9fVl" +
                                                              "YhakUCUNjDloF5qLe7fJ+9p6fytgcNcoCkJu0onIVza/u/1NzscVmKQ3OqZ7" +
                                                              "UjAkc08yqBcr/wj+iuDzb/zgirFDFGwNHXbVODNXNiKMx8RjwIDInoYrO566" +
                                                              "+oIwIAi+gDDdd+hLH4X3HxIMK84erXnlv1dHnD+EOdg8gKubNdYsXKPr92f2" +
                                                              "fP/Enr1iVQ3+SroTDoov/Oxfb4aP/vL1UUq2YsU+P3p5E9Kkf2+EQau+WPeD" +
                                                              "Aw3FXZDeu0lFRlN2Zmh33A/ScisT82yWe6ZxgWubhhvDSNF82AORnLFdhs06" +
                                                              "gcL7ClLZaj/058Jnpo3SmQWgL6AyF5vefIwX0makmmN8A5V1M275b0JyoOW5" +
                                                              "TLjowarzP7Se+d1ZsRWjhUTg7HXieIX8fvo8DwmccpPftCnBxX0sxwE8Q66i" +
                                                              "iY//3DHKRAjx2YUD0OPbkeda33p4pPVXPFtWKBbQJlDAKGdij86NU1euXaxp" +
                                                              "Os0r0hJkEhuY/suE/LsC3xUA35k6bPSsU1SE/4uzzgYXO4ZhkGCc4U85CP7U" +
                                                              "GODPFuTvMiMTUxXZpW/+V0YCp1Zvpeimb4J70FToYoFTzLHHDo3E1z+7yIHp" +
                                                              "VqhPmW7crdJBqgYqgSZfJdDD/eim1Q9qD/7me23JlXdyNMO+5tscvvD3DADD" +
                                                              "/MJYCi7lwmN/nLpxeWrbHZyyZgS8FBzy+Z5Tr6+eIx8M8Xsjke/z7pv8Su1+" +
                                                              "Aq00KcuYmp8yW3P7Wof71QifBfa+LggSnosnzna7/WxXOYZqoIp2akP8/eUx" +
                                                              "3u3HZi8AIkmZiGzs2OxCet/t+Hzs0hQ7Og3e/4V8P0RsYyJ37odCqqOfJrhR" +
                                                              "fNQnx3DGN7A5BM5IQNSsVoeNVMAZh/8XzsjCkSNwkYIVfGPeFa64dpRPj9RV" +
                                                              "TBnZ9K6gQedqsBrCJ5FRVW+N6XkuM0yaULhV1aLiFJn6GUZabk9+jJTyb27C" +
                                                              "N4Xmc1D8jqXJSAl+eVWeZ2RKARVgPfHglT/FSH1QHpbCv71yZ6B8deVgKPHg" +
                                                              "FTkL1RGI4OO3DIf2F9zBFVe2yE+yOQxMuh0GPLzc6uMzfpXvcE9GXOYPyGdG" +
                                                              "1q7bffOTz4r7C1mVdu3CUaogjYmrlBx/zSo4mjNW2Zp5t2pfHDfbYfrxYsFu" +
                                                              "NE3zoL0T4sJA5E0NnOytttwB/71jy175yb6yi5C2t5AiCY7jW/IPR1kjA4lj" +
                                                              "SzS/7ASu51cO7fO+Prx8YeLP7/PjJxFl6vTC8gPypeMPvXOw8VhziFR1k1II" +
                                                              "R5rlp7ZVwxrk5EGzn9QoVmcWlgijKJLqq2lrMUgkvOTnfrHdWZPrxdsviIP8" +
                                                              "cj7/zhCO6kPUXAnHpLhdfFS5Pb7/MTgpIGMYAQW3x1ORxLB5IIu7AVAdiPYY" +
                                                              "hnPaqZptcKqQC9cc5/kjNhf+A2d+A+DmGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
